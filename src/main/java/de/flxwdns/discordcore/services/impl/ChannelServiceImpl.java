package de.flxwdns.discordcore.services.impl;

import de.flxwdns.discordcore.injection.InjectionLayer;
import de.flxwdns.discordcore.services.ChannelService;
import de.flxwdns.discordcore.services.DefaultService;
import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.channel.GuildChannel;
import discord4j.core.spec.TextChannelCreateSpec;
import discord4j.core.spec.VoiceChannelCreateSpec;

public class ChannelServiceImpl implements ChannelService {
    private final GatewayDiscordClient client;

    public ChannelServiceImpl() {
        this.client = InjectionLayer.next(DefaultService.class).client();
    }

    @Override
    public GuildChannel getChannel(String guildId, String channelId) {
        return client.getGuildById(Snowflake.of(guildId)).block().getChannelById(Snowflake.of(channelId)).block();
    }

    @Override
    public GuildChannel getChannelFromName(String guildId, String name) {
        return client.getGuildById(Snowflake.of(guildId)).block().getChannels().filter(it -> it.getName().equalsIgnoreCase(name)).blockFirst();
    }

    @Override
    public GuildChannel createTextChannel(String guildId, TextChannelCreateSpec channel) {
        return client.getGuildById(Snowflake.of(guildId)).block().createTextChannel(channel).block();
    }

    @Override
    public GuildChannel createVoiceChannel(String guildId, VoiceChannelCreateSpec channel) {
        return client.getGuildById(Snowflake.of(guildId)).block().createVoiceChannel(channel).block();
    }

    @Override
    public boolean isChannelPresent(GuildChannel guildChannel) {
        return guildChannel != null;
    }
}
