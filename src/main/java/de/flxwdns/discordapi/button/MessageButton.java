package de.flxwdns.discordapi.button;

import discord4j.core.event.domain.interaction.ButtonInteractionEvent;
import discord4j.core.object.component.Button;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@AllArgsConstructor
public final class MessageButton {
    @Getter
    private final Button button;

    private final Function<ButtonInteractionEvent, InteractionApplicationCommandCallbackReplyMono> onClick;

    public InteractionApplicationCommandCallbackReplyMono onClick(ButtonInteractionEvent event) {
        return onClick.apply(event);
    }
}
