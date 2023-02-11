package de.flxwdns.discordapi.menu;

import discord4j.core.event.domain.interaction.SelectMenuInteractionEvent;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.function.Function;

@Getter
@AllArgsConstructor
public final class MessageMenu {
    private final String customId;
    private final String placeholder;
    private int minimumValues;
    private int maximumValues;
    private final List<MenuOption> options;
    private final Function<SelectMenuInteractionEvent, InteractionApplicationCommandCallbackReplyMono> onInteract;
}
