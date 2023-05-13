package de.flxwdns.discordcore.services;

import discord4j.core.object.entity.channel.GuildChannel;
import discord4j.core.spec.TextChannelCreateSpec;
import discord4j.core.spec.VoiceChannelCreateSpec;

public interface ChannelService {

    GuildChannel getChannel(String guildId, String channelId);
    GuildChannel getChannelFromName(String guildId, String name);

    GuildChannel createTextChannel(String guildId, TextChannelCreateSpec channel);
    GuildChannel createVoiceChannel(String guildId, VoiceChannelCreateSpec channel);

    boolean isChannelPresent(GuildChannel guildChannel);
}
