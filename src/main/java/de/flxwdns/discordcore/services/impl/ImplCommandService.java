package de.flxwdns.discordcore.services.impl;

import de.flxwdns.discordcore.injection.InjectionLayer;
import de.flxwdns.discordcore.builder.command.SlashCommand;
import de.flxwdns.discordcore.services.CommandService;
import de.flxwdns.discordcore.services.DefaultService;
import de.flxwdns.discordcore.services.EventService;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;
import discord4j.discordjson.json.ApplicationCommandOptionData;
import discord4j.discordjson.json.ApplicationCommandRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@SuppressWarnings("ALL")
public final class ImplCommandService implements CommandService {
    private final List<SlashCommand> commands;

    public ImplCommandService() {
        this.commands = new ArrayList<>();

        InjectionLayer.next(EventService.class).registerEvent(ChatInputInteractionEvent.class, event -> {
            return commands.stream().filter(command -> command.request().name().equals(event.getCommandName())).findFirst().get().handle(event);
        });
    }

    @Override
    public void addCommand(String command, String description, List<ApplicationCommandOptionData> options, Function<ChatInputInteractionEvent, InteractionApplicationCommandCallbackReplyMono> onClick) {
        var builder = ApplicationCommandRequest.builder();
        builder.name(command.toLowerCase());
        builder.description(description);

        options.forEach(builder::addOption);
        var applicationCommandRequest = builder.build();
        commands.add(new SlashCommand() {
            @Override
            public ApplicationCommandRequest request() {
                return applicationCommandRequest;
            }
            @Override
            public InteractionApplicationCommandCallbackReplyMono handle(ChatInputInteractionEvent event) {
                return onClick.apply(event);
            }
        });
        var defaultService = InjectionLayer.next(DefaultService.class);
        defaultService.client().getRestClient().getApplicationService().createGlobalApplicationCommand(defaultService.client().getRestClient().getApplicationId().block(), applicationCommandRequest).subscribe();
    }
}
