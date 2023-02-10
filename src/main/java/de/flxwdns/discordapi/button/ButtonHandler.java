package de.flxwdns.discordapi.button;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;

import java.util.ArrayList;
import java.util.List;

public final class ButtonHandler {
    private final List<MessageButton> buttonList;
    private final GatewayDiscordClient client;

    public ButtonHandler(GatewayDiscordClient client) {
        buttonList = new ArrayList<>();
        this.client = client;

        client.on(ChatInputInteractionEvent.class, event -> buttonList.stream().filter(button -> button.getButton().getCustomId().equals(event.getCommandName())).findFirst().get().onClick(event)).subscribe();
    }

    public void addButton(MessageButton messageButton) {
        buttonList.add(messageButton);
    }
}
