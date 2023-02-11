package de.flxwdns.discordapi;

import de.flxwdns.discordapi.button.ButtonHandler;
import de.flxwdns.discordapi.channel.ChannelHandler;
import de.flxwdns.discordapi.message.MessageHandler;
import de.flxwdns.discordapi.command.CommandHandler;
import de.flxwdns.discordapi.event.EventHandler;
import de.flxwdns.discordapi.menu.MenuHandler;
import discord4j.core.GatewayDiscordClient;
import org.jetbrains.annotations.NotNull;

public final class DiscordCore {
    private static ChannelHandler channelHandler;
    private static MessageHandler messageHandler;
    private static CommandHandler commandHandler;
    private static EventHandler eventHandler;
    private static ButtonHandler buttonHandler;
    private static MenuHandler menuHandler;
    private static GatewayDiscordClient client;

    public static void setChannelHandler(@NotNull ChannelHandler channelHandler) {
        DiscordCore.channelHandler = channelHandler;
    }
    public static void setMessageHandler(@NotNull MessageHandler messageHandler) {
        DiscordCore.messageHandler = messageHandler;
    }
    public static void setCommandHandler(@NotNull CommandHandler commandHandler) {
        DiscordCore.commandHandler = commandHandler;
    }
    public static void setEventHandler(@NotNull EventHandler eventHandler) {
        DiscordCore.eventHandler = eventHandler;
    }
    public static void setButtonHandler(@NotNull ButtonHandler buttonHandler) {
        DiscordCore.buttonHandler = buttonHandler;
    }
    public static void setMenuHandler(@NotNull MenuHandler menuHandler) {
        DiscordCore.menuHandler = menuHandler;
    }
    public static void setClient(@NotNull GatewayDiscordClient client) {
        DiscordCore.client = client;
    }

    public static ChannelHandler getChannelHandler() {
        return DiscordCore.channelHandler;
    }
    public static MessageHandler getMessageHandler() {
        return DiscordCore.messageHandler;
    }
    public static CommandHandler getCommandHandler() {
        return DiscordCore.commandHandler;
    }
    public static EventHandler getEventHandler() {
        return DiscordCore.eventHandler;
    }
    public static ButtonHandler getButtonHandler() {
        return DiscordCore.buttonHandler;
    }
    public static MenuHandler getMenuHandler() {
        return DiscordCore.menuHandler;
    }
    public static GatewayDiscordClient getClient() {
        return DiscordCore.client;
    }
}
