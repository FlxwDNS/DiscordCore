package de.flxwdns.discordapi.channel;

import de.flxwdns.discordapi.DiscordCore;
import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.spec.TextChannelCreateSpec;
import discord4j.core.spec.VoiceChannelCreateSpec;

public final class ChannelHandler {

    public Channel createChannel(String guildId, TextChannelCreateSpec textChannel) {
        return DiscordCore.getClient().getGuildById(Snowflake.of(guildId)).block().createTextChannel(textChannel).block();
    }

    public Channel createVoiceChannel(String guildId, VoiceChannelCreateSpec voiceChannel) {
        return DiscordCore.getClient().getGuildById(Snowflake.of(guildId)).block().createVoiceChannel(voiceChannel).block();
    }
}
