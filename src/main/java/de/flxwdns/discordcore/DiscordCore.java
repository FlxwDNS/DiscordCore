package de.flxwdns.discordcore;

import de.flxwdns.discordcore.injection.InjectionLayer;
import de.flxwdns.discordcore.register.BotClient;
import de.flxwdns.discordcore.register.ClientCfg;
import de.flxwdns.discordcore.services.*;
import de.flxwdns.discordcore.services.impl.*;
import lombok.SneakyThrows;

public final class DiscordCore {
    @SneakyThrows
    public DiscordCore() {
        // Define defaultService
        System.out.println("[ CORE] (info) InjectionLayer next BotClient.class");
        var botClient = InjectionLayer.next(BotClient.class);

        // Check if configuration is defined
        if(botClient.getClass().getAnnotation(ClientCfg.class) == null) {
            throw new Throwable("Cannot found ClientCfg in " + botClient.getClass().getSimpleName() + "!");
        }

        // Register InjectionLayer
        System.out.println("[ CORE] (info) InjectionLayer register DefaultService");
        InjectionLayer.register(DefaultService.class, new ImplDefaultService());
        InjectionLayer.register(EventService.class, new ImplEventService());
        InjectionLayer.register(ChannelService.class, new ImplChannelService());
        InjectionLayer.register(CommandService.class, new ImplCommandService());
        InjectionLayer.register(ButtonService.class, new ImplButtonService());

        // Run onClientReady function
        System.out.println("[ CORE] (main) BotClient marked as ready");
        InjectionLayer.next(BotClient.class).onClientReady();

        // While disconnect
        InjectionLayer.next(DefaultService.class).client().onDisconnect().block();
    }
}
