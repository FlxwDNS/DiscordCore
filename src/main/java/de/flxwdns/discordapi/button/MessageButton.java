package de.flxwdns.discordapi.button;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.object.component.Button;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Consumer;

@AllArgsConstructor
public final class MessageButton {
    @Getter
    private final Button button;
    private final Consumer<ChatInputInteractionEvent> onClick;

    public InteractionApplicationCommandCallbackReplyMono onClick(ChatInputInteractionEvent event) {
        onClick.accept(event);
        return event.reply();
    }
}
