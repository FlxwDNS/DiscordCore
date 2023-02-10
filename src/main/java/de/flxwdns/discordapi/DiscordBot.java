package de.flxwdns.discordapi;

import de.flxwdns.discordapi.channel.ChannelHandler;
import de.flxwdns.discordapi.command.CommandHandler;
import de.flxwdns.discordapi.event.EventHandler;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.gateway.intent.IntentSet;
import lombok.Getter;

public abstract class DiscordBot {
    @Getter
    private final GatewayDiscordClient client;

    public DiscordBot() {
        initialize();
        var bot = DiscordClient.create(getToken()).gateway();
        bot.setEnabledIntents(IntentSet.all());
        client = bot.login().block();

        if(client == null) System.exit(0);

        DiscordCore.setChannelHandler(new ChannelHandler(client));
        DiscordCore.setCommandHandler(new CommandHandler(client));
        DiscordCore.setEventHandler(new EventHandler(client));

        client.onDisconnect().block();
    }

    abstract public void initialize();

    abstract public String getToken();
}