package de.flxwdns.discordapi.menu;

import de.flxwdns.discordapi.DiscordCore;
import discord4j.core.event.domain.interaction.SelectMenuInteractionEvent;

import java.util.ArrayList;
import java.util.List;

public final class MenuHandler {
    private final List<MessageMenu> menuList;


    public MenuHandler() {
        menuList = new ArrayList<>();

        DiscordCore.getEventHandler().registerEvent(SelectMenuInteractionEvent.class, event -> {
            var menu = menuList.stream().filter(it -> it.getCustomId().equals(event.getCustomId())).findFirst().get();

            menu.getOptions().stream().filter(it -> !event.getValues().contains(it.getSelectMenu().getValue())).forEach(it -> it.onDisable(event));
            event.getValues().forEach(value -> menu.getOptions().stream().filter(it -> it.getSelectMenu().getValue().equals(value)).forEach(it -> it.onEnable(event)));
            return menu.getOnInteract().apply(event);
        });
    }

    public void addMenu(MessageMenu messageMenu) {
        menuList.add(messageMenu);
    }
}
