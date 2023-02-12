package de.flxwdns.discordapi.event;

import de.flxwdns.discordapi.DiscordCore;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import org.reactivestreams.Publisher;

import java.util.function.Consumer;
import java.util.function.Function;

public final class EventHandler {
    private final GatewayDiscordClient client;

    public EventHandler() {
        client = DiscordCore.getClient();
    }

    public <E extends Event> void registerEvent(Class<E> event, Consumer<? super E> consumer) {
        client.on(event).doOnError(error -> {
            System.out.println(DiscordCore.getLogging());
            if(DiscordCore.getLogging()) error.printStackTrace();
        }).subscribe(consumer, error -> {
            System.out.println(DiscordCore.getLogging());
            if(DiscordCore.getLogging()) error.printStackTrace();
        });
    }

    public <E extends Event, T> void registerEvent(Class<E> event, Function<E, Publisher<T>> mapper) {
        client.on(event, mapper).doOnError(error -> {
            System.out.println(DiscordCore.getLogging());
            if(DiscordCore.getLogging()) error.printStackTrace();
        }).subscribe(null, error -> {
            System.out.println(DiscordCore.getLogging());
            if(DiscordCore.getLogging()) error.printStackTrace();
        });
    }
}
