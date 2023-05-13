package de.flxwdns.discordcore.services.impl;

import de.flxwdns.discordcore.injection.InjectionLayer;
import de.flxwdns.discordcore.register.BotClient;
import de.flxwdns.discordcore.register.ClientCfg;
import de.flxwdns.discordcore.services.DefaultService;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.presence.ClientActivity;
import discord4j.core.object.presence.ClientPresence;
import discord4j.core.object.presence.Status;
import discord4j.gateway.intent.IntentSet;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class DefaultServiceImpl implements DefaultService {
    private final GatewayDiscordClient client;

    public DefaultServiceImpl() {
        // Define configuration
        var clientCfg = InjectionLayer.next(BotClient.class).getClass().getAnnotation(ClientCfg.class);

        // Create Gateway instance
        var bot = DiscordClient.create(clientCfg.token()).gateway();
        bot.setEnabledIntents(IntentSet.all());

        // Run onClientPrepare function
        InjectionLayer.next(BotClient.class).onClientPrepare();

        this.client = bot.login().block();

        // Throw when client is null
        if(client == null) {
            throw new RuntimeException("Client is null!");
        }
    }

    @Override
    public GatewayDiscordClient client() {
        return client;
    }

    @Override
    public void updateStatus(Status status, ClientActivity clientActivity) {
        client.updatePresence(ClientPresence.of(status, clientActivity)).subscribe();
    }
}
