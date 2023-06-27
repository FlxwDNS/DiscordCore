package de.flxwdns.discordcore.services;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;
import discord4j.discordjson.json.ApplicationCommandOptionData;

import java.util.List;
import java.util.function.Function;

public interface CommandService {
    void addCommand(String command, String description, List<ApplicationCommandOptionData> options, Function<ChatInputInteractionEvent, InteractionApplicationCommandCallbackReplyMono> onClick);
}
