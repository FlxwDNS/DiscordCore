package de.flxwdns.discordapi.event;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor
public final class EventHandler {
    private final GatewayDiscordClient client;

    public <E extends Event> void registerEvent(Class<E> event, Consumer<? super E> consumer) {
        client.on(event).subscribe(consumer);
    }
}
