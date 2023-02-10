package de.flxwdns.discordapi.command;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;
import discord4j.discordjson.json.ApplicationCommandOptionData;
import discord4j.discordjson.json.ApplicationCommandRequest;
import lombok.Getter;

import java.util.List;

public abstract class SlashCommand {

    @Getter
    private final ApplicationCommandRequest request;

    public SlashCommand(String name, String description, List<ApplicationCommandOptionData> options) {
        var builder = ApplicationCommandRequest.builder();
        builder.name(name.toLowerCase());
        builder.description(description);

        options.forEach(builder::addOption);

        request = builder.build();
    }

    abstract public InteractionApplicationCommandCallbackReplyMono handle(ChatInputInteractionEvent event);

    public void registerCommand(GatewayDiscordClient client, long applicationId) {
        client.getRestClient().getApplicationService().createGlobalApplicationCommand(applicationId, request).subscribe();
    }
}
