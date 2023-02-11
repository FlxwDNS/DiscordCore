package de.flxwdns.discordapi;

import de.flxwdns.discordapi.button.ButtonHandler;
import de.flxwdns.discordapi.channel.ChannelHandler;
import de.flxwdns.discordapi.command.CommandHandler;
import de.flxwdns.discordapi.event.EventHandler;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.presence.*;
import discord4j.gateway.intent.IntentSet;
import lombok.Getter;

public abstract class DiscordBot {
    @Getter
    private final GatewayDiscordClient client;

    public DiscordBot() {
        var bot = DiscordClient.create(getToken()).gateway();
        bot.setEnabledIntents(IntentSet.all());

        client = bot.login().block();

        if(client == null) System.exit(0);

        DiscordCore.setClient(client);
        DiscordCore.setChannelHandler(new ChannelHandler());
        DiscordCore.setCommandHandler(new CommandHandler());
        DiscordCore.setEventHandler(new EventHandler());
        DiscordCore.setButtonHandler(new ButtonHandler());

        initialize();

        client.onDisconnect().block();
    }

    public void setActivity(Status status, ClientActivity activity) {
        client.updatePresence(ClientPresence.of(status, activity));
    }

    abstract public void initialize();

    abstract public String getToken();
}