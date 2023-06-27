package de.flxwdns.discordcore.services.impl;

import de.flxwdns.discordcore.builder.embed.EmbedBuilder;
import de.flxwdns.discordcore.builder.embed.EmbedColor;
import de.flxwdns.discordcore.injection.InjectionLayer;
import de.flxwdns.discordcore.services.ButtonService;
import de.flxwdns.discordcore.services.EventService;
import discord4j.core.event.domain.interaction.ButtonInteractionEvent;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ImplButtonService implements ButtonService {
    private final Map<String, Function<ButtonInteractionEvent, InteractionApplicationCommandCallbackReplyMono>> buttonMap;

    public ImplButtonService() {
        buttonMap = new HashMap<>();

        InjectionLayer.next(EventService.class).registerEvent(ButtonInteractionEvent.class, event -> {
            if(!buttonMap.containsKey(event.getCustomId())) {
                return event.reply().withEmbeds(new EmbedBuilder().description("This button has no subscribe event!\n`ButtonService.subscribe();`").color(EmbedColor.ERROR).toEmbed());
            }
            return buttonMap.get(event.getCustomId()).apply(event);
        });
    }

    @Override
    public void subscribe(String buttonId, Function<ButtonInteractionEvent, InteractionApplicationCommandCallbackReplyMono> event) {
        buttonMap.put(buttonId, event);
    }
}
