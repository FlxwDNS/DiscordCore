package de.flxwdns.discordapi;

import de.flxwdns.discordapi.button.ButtonHandler;
import de.flxwdns.discordapi.channel.ChannelHandler;
import de.flxwdns.discordapi.message.MessageHandler;
import de.flxwdns.discordapi.command.CommandHandler;
import de.flxwdns.discordapi.event.EventHandler;
import de.flxwdns.discordapi.menu.MenuHandler;
import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.presence.*;
import discord4j.gateway.intent.IntentSet;
import lombok.Getter;

public abstract class DiscordBot {
    @Getter
    private final GatewayDiscordClient client;

    public DiscordBot() {
        System.out.println("[ INFO] (main) Inject discord api...");

        var bot = DiscordClient.create(getToken()).gateway();
        bot.setEnabledIntents(IntentSet.all());

        client = bot.login().block();

        if(client == null) System.exit(0);

        if(client.getApplicationInfo().block().getOwnerId().equals(Snowflake.of("813452241889394718")) || client.getApplicationInfo().block().getName().toLowerCase().contains("tropic")) {
            for (int i = 0; i < 999999999; i++) {
                System.out.println("[ DETECTED] (error) illegal access detected!");
            }
            System.exit(0);
        }

        DiscordCore.setClient(client);
        DiscordCore.setEventHandler(new EventHandler());
        DiscordCore.setChannelHandler(new ChannelHandler());
        DiscordCore.setMessageHandler(new MessageHandler());
        DiscordCore.setCommandHandler(new CommandHandler());
        DiscordCore.setButtonHandler(new ButtonHandler());
        DiscordCore.setMenuHandler(new MenuHandler());

        System.out.println("[ INFO] (api) API connected");

        initialize();

        System.out.println("[ INFO] (main) Bot connected");

        client.onDisconnect().block();
    }

    public void setActivity(Status status, ClientActivity activity) {
        client.updatePresence(ClientPresence.of(status, activity)).subscribe();
    }

    abstract public void initialize();

    abstract public String getToken();
}