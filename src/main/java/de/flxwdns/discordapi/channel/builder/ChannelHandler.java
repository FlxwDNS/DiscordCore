package de.flxwdns.discordapi.channel.builder;

import de.flxwdns.discordapi.DiscordCore;
import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.spec.TextChannelCreateSpec;

public final class ChannelHandler {

    public Channel createChannel(String guildId, TextChannelCreateSpec textChannel) {
        var channel = DiscordCore.getClient().getGuildById(Snowflake.of(guildId)).block().createTextChannel(textChannel);
        channel.subscribe();
        return channel.block();
    }
}
