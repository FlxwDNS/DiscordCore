package de.flxwdns.discordcore.register;

import de.flxwdns.discordcore.DiscordCore;
import de.flxwdns.discordcore.injection.InjectionLayer;
import discord4j.core.GatewayDiscordClient;

public abstract class BotClient {
    public static GatewayDiscordClient client;

    public BotClient() {
        // Register this to InjectionLayer
        InjectionLayer.register(BotClient.class, this);
        // Run the DiscordCore
        new DiscordCore();
    }

    public void onClientPrepare() {
    }

    public void onClientReady() {
    }
}