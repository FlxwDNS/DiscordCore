package de.flxwdns.discordapi.channel.builder;

import de.flxwdns.discordapi.DiscordCore;
import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.spec.TextChannelCreateSpec;

public final class ChannelHandler {

    public Channel createChannel(String guildId, TextChannelCreateSpec textChannel) {
        return DiscordCore.getClient().getGuildById(Snowflake.of(guildId)).block().createTextChannel(textChannel).block();
    }
}
