package de.flxwdns.discordapi.menu;

import discord4j.core.event.domain.interaction.SelectMenuInteractionEvent;
import discord4j.core.object.component.SelectMenu;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Consumer;

@Getter
@AllArgsConstructor
public final class MenuOption {
    private final SelectMenu.Option selectMenu;
    private final Consumer<SelectMenuInteractionEvent> onEnable;
    private final Consumer<SelectMenuInteractionEvent> onDisable;

    public void onEnable(SelectMenuInteractionEvent event) {
        onEnable.accept(event);
    }
    public void onDisable(SelectMenuInteractionEvent event) {
        onDisable.accept(event);
    }
}
