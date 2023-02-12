package de.flxwdns.discordapi.button;

import de.flxwdns.discordapi.DiscordCore;
import de.flxwdns.discordapi.message.ColorType;
import de.flxwdns.discordapi.message.embed.EmbedBuilder;
import discord4j.core.event.domain.interaction.ButtonInteractionEvent;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ButtonHandler {
    private final Map<String, Function<ButtonInteractionEvent, InteractionApplicationCommandCallbackReplyMono>> buttonMap;

    public ButtonHandler() {
        buttonMap = new HashMap<>();

        DiscordCore.getEventHandler().registerEvent(ButtonInteractionEvent.class, event -> {
            if(!buttonMap.containsKey(event.getCustomId())) return DiscordCore.getMessageHandler().getReplyEmbedConstruct(event.reply(),
                    new EmbedBuilder().title("Provied a function").description("You need to provide a function!\n`DiscordCore.getButtonHandler().subscribe();`").color(ColorType.ERROR).toEmbed()
            );
            return buttonMap.get(event.getCustomId()).apply(event);
        });
    }

    public void subscribe(String customId, Function<ButtonInteractionEvent, InteractionApplicationCommandCallbackReplyMono> event) {
        buttonMap.put(customId, event);
    }
}
