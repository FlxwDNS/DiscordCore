package de.flxwdns.discordapi;

import de.flxwdns.discordapi.channel.ChannelHandler;
import de.flxwdns.discordapi.command.CommandHandler;
import de.flxwdns.discordapi.event.EventHandler;
import org.jetbrains.annotations.NotNull;

public final class DiscordCore {
    private static ChannelHandler channelHandler;
    private static CommandHandler commandHandler;
    private static EventHandler eventHandler;

    public static void setChannelHandler(@NotNull ChannelHandler channelHandler) {
        DiscordCore.channelHandler = channelHandler;
    }
    public static void setCommandHandler(@NotNull CommandHandler commandHandler) {
        DiscordCore.commandHandler = commandHandler;
    }
    public static void setEventHandler(@NotNull EventHandler eventHandler) {
        DiscordCore.eventHandler = eventHandler;
    }

    public static ChannelHandler getChannelHandler() {
        return DiscordCore.channelHandler;
    }
    public static CommandHandler getCommandHandler() {
        return DiscordCore.commandHandler;
    }
    public static EventHandler getEventHandler() {
        return DiscordCore.eventHandler;
    }
}
