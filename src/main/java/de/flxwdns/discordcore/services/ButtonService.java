package de.flxwdns.discordcore.services;

import discord4j.core.event.domain.interaction.ButtonInteractionEvent;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;

import java.util.function.Function;

public interface ButtonService {
    void subscribe(String buttonId, Function<ButtonInteractionEvent, InteractionApplicationCommandCallbackReplyMono> event);

}
