package de.flxwdns.discordapi.command;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;

import java.util.ArrayList;
import java.util.List;

public final class CommandHandler {
    private final List<SlashCommand> commandList;
    private final GatewayDiscordClient client;

    public CommandHandler(GatewayDiscordClient client) {
        commandList = new ArrayList<>();
        this.client = client;

        client.on(ChatInputInteractionEvent.class, event -> commandList.stream().filter(command -> command.getRequest().name().equals(event.getCommandName())).findFirst().get().handle(event)).subscribe();
    }

    public void addCommand(SlashCommand slashCommand) {
        commandList.add(slashCommand);
        slashCommand.registerCommand(client, client.getRestClient().getApplicationId().block());
    }

}
