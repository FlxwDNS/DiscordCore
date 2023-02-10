package de.flxwdns.discordapi.event;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;

import java.util.function.Consumer;
import java.util.function.Function;

@RequiredArgsConstructor
public final class EventHandler {
    private final GatewayDiscordClient client;

    public <E extends Event> void registerEvent(Class<E> event, Consumer<? super E> consumer) {
        client.on(event).subscribe(consumer);
    }

    public <E extends Event, T> void registerEvent(Class<E> event, Function<E, Publisher<T>> mapper) {
        client.on(event, mapper).subscribe();
    }
}
