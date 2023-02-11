package de.flxwdns.discordapi.channel.builder;

import de.flxwdns.discordapi.DiscordCore;
import discord4j.common.util.Snowflake;
import discord4j.core.spec.TextChannelCreateSpec;

public final class ChannelHandler {

    public void createChannel(String guildId, TextChannelCreateSpec textChannel) {
        DiscordCore.getClient().getGuildById(Snowflake.of(guildId)).block().createTextChannel(textChannel).subscribe();
    }
}
