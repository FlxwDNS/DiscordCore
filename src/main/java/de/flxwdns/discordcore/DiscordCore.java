package de.flxwdns.discordcore;

import de.flxwdns.discordcore.injection.InjectionLayer;
import de.flxwdns.discordcore.register.BotClient;
import de.flxwdns.discordcore.register.ClientCfg;
import de.flxwdns.discordcore.services.ChannelService;
import de.flxwdns.discordcore.services.DefaultService;
import de.flxwdns.discordcore.services.impl.ChannelServiceImpl;
import de.flxwdns.discordcore.services.impl.DefaultServiceImpl;
import lombok.SneakyThrows;

public final class DiscordCore {
    @SneakyThrows
    public DiscordCore() {
        // Define defaultService
        System.out.println("[Core] InjectionLayer next BotClient.class");
        var botClient = InjectionLayer.next(BotClient.class);

        // Check if configuration is defined
        if(botClient.getClass().getAnnotation(ClientCfg.class) == null) {
            throw new Throwable("Cannot found ClientCfg in " + botClient.getClass().getSimpleName() + "!");
        }

        // Register InjectionLayer
        System.out.println("[Core] InjectionLayer next DefaultService");
        InjectionLayer.register(DefaultService.class, new DefaultServiceImpl());
        System.out.println("[Core] InjectionLayer next Services");
        InjectionLayer.register(ChannelService.class, new ChannelServiceImpl());

        // Run onClientReady function
        System.out.println("[Core] BotClient marked as ready");
        InjectionLayer.next(BotClient.class).onClientReady();

        // While disconnect
        InjectionLayer.next(DefaultService.class).client().onDisconnect().block();
    }
}
