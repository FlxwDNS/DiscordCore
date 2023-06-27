package de.flxwdns.discordcore.services;

import discord4j.core.event.domain.Event;
import org.reactivestreams.Publisher;

import java.util.function.Consumer;
import java.util.function.Function;

public interface EventService {
    <E extends Event> void registerEvent(Class<E> event, Consumer<? super E> consumer);
    <E extends Event, T> void registerEvent(Class<E> event, Function<E, Publisher<T>> mapper);
}
