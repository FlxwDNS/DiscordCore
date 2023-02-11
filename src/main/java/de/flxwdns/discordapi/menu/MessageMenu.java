package de.flxwdns.discordapi.menu;

import discord4j.core.event.domain.interaction.SelectMenuInteractionEvent;
import discord4j.core.object.component.SelectMenu;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@AllArgsConstructor
public final class MessageMenu {
    @Getter
    private final SelectMenu menu;

    private final Function<SelectMenuInteractionEvent, InteractionApplicationCommandCallbackReplyMono> onClick;

    public InteractionApplicationCommandCallbackReplyMono onClick(SelectMenuInteractionEvent event) {
        return onClick.apply(event);
    }
}
