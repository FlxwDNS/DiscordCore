package de.flxwdns.discordapi.command;

import de.flxwdns.discordapi.DiscordCore;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;

import java.util.ArrayList;
import java.util.List;

public final class CommandHandler {
    private final List<SlashCommand> commandList;

    public CommandHandler() {
        commandList = new ArrayList<>();

        DiscordCore.getEventHandler().registerEvent(ChatInputInteractionEvent.class, event -> {
            commandList.stream().filter(command -> command.getRequest().name().equals(event.getCommandName())).findFirst().get().handle(event);
        });
    }

    public void addCommand(SlashCommand slashCommand) {
        commandList.add(slashCommand);
        slashCommand.registerCommand(DiscordCore.getClient(), DiscordCore.getClient().getRestClient().getApplicationId().block());
    }

}
