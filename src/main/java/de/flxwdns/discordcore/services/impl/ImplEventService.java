package de.flxwdns.discordcore.services.impl;

import de.flxwdns.discordcore.injection.InjectionLayer;
import de.flxwdns.discordcore.services.DefaultService;
import de.flxwdns.discordcore.services.EventService;
import discord4j.core.event.domain.Event;
import org.reactivestreams.Publisher;

import java.util.function.Consumer;
import java.util.function.Function;

public final class ImplEventService implements EventService {
    @Override
    public <E extends Event> void registerEvent(Class<E> event, Consumer<? super E> consumer) {
        var defaultService = InjectionLayer.next(DefaultService.class);

        defaultService.client().on(event).doOnError(error -> {
            if(defaultService.isLogging()) error.printStackTrace();
        }).subscribe(consumer, error -> {
            if(defaultService.isLogging()) error.printStackTrace();
        });
    }

    @Override
    public <E extends Event, T> void registerEvent(Class<E> event, Function<E, Publisher<T>> mapper) {
        var defaultService = InjectionLayer.next(DefaultService.class);

        defaultService.client().on(event, mapper).doOnError(error -> {
            if(defaultService.isLogging()) error.printStackTrace();
        }).subscribe(null, error -> {
            if(defaultService.isLogging()) error.printStackTrace();
        });
    }
}
