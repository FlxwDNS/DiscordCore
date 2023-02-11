package de.flxwdns.discordapi.menu;

import de.flxwdns.discordapi.DiscordCore;
import discord4j.core.event.domain.interaction.ButtonInteractionEvent;
import discord4j.core.event.domain.interaction.SelectMenuInteractionEvent;

import java.util.ArrayList;
import java.util.List;

public final class MenuHandler {
    private final List<MessageMenu> menuList;


    public MenuHandler() {
        menuList = new ArrayList<>();

        DiscordCore.getEventHandler().registerEvent(SelectMenuInteractionEvent.class, event -> {
            var menu = menuList.stream().filter(it -> it.getMenu().getCustomId().equals(event.getCustomId())).findFirst().get();
            return menu.onClick(event);
        });
    }

    public void addMenu(MessageMenu messageMenu) {
        menuList.add(messageMenu);
    }
}
