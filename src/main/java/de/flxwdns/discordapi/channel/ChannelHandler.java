package de.flxwdns.discordapi.channel;

import de.flxwdns.discordapi.DiscordCore;
import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.channel.GuildChannel;
import discord4j.core.object.entity.channel.TextChannel;
import discord4j.core.spec.TextChannelCreateSpec;
import discord4j.core.spec.VoiceChannelCreateSpec;

import java.util.Objects;

public final class ChannelHandler {

    public GuildChannel getChannel(String guildId, String channelId) {



        return DiscordCore.getClient().getGuildById(Snowflake.of(guildId)).block().getChannelById(Snowflake.of(channelId)).block();
    }

    public GuildChannel getChannelByName(String guildId, String channelName) {
        return DiscordCore.getClient().getGuildById(Snowflake.of(guildId)).block().getChannels().filter(it -> it.getName().equalsIgnoreCase(channelName)).blockFirst();
    }

    public GuildChannel createChannel(String guildId, TextChannelCreateSpec textChannel) {
        return DiscordCore.getClient().getGuildById(Snowflake.of(guildId)).block().createTextChannel(textChannel).block();
    }

    public GuildChannel createVoiceChannel(String guildId, VoiceChannelCreateSpec voiceChannel) {
        return DiscordCore.getClient().getGuildById(Snowflake.of(guildId)).block().createVoiceChannel(voiceChannel).block();
    }

    public Boolean isChannelPresent(String guildId, String channelId) {
        return getChannel(guildId, channelId) != null;
    }

    public Boolean isChannelByNamePresent(String guildId, String channelName) {
        return getChannelByName(guildId, channelName) != null;
    }
}
