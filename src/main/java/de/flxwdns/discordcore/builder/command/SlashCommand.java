package de.flxwdns.discordcore.builder.command;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;
import discord4j.discordjson.json.ApplicationCommandRequest;

public interface SlashCommand {
    ApplicationCommandRequest request();
    InteractionApplicationCommandCallbackReplyMono handle(ChatInputInteractionEvent event);
}
