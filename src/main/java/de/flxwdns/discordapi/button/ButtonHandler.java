package de.flxwdns.discordapi.button;

import de.flxwdns.discordapi.DiscordCore;
import discord4j.core.event.domain.interaction.ButtonInteractionEvent;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;

import java.util.ArrayList;
import java.util.List;

public final class ButtonHandler {
    private final List<MessageButton> buttonList;


    public ButtonHandler() {
        buttonList = new ArrayList<>();


        DiscordCore.getEventHandler().registerEvent(ButtonInteractionEvent.class, event -> {
            var button = buttonList.stream().filter(it -> it.getButton().getCustomId().get().equals(event.getCustomId())).findFirst().get();
            if(button != null) return button.onClick(event);
            return event.reply("ERROR");
        });

        //client.on(ChatInputInteractionEvent.class, event -> buttonList.stream().filter(button -> button.getButton().getCustomId().equals(event.getCommandName())).findFirst().get().onClick(event)).subscribe();
    }

    public void addButton(MessageButton messageButton) {
        buttonList.add(messageButton);
    }
}
