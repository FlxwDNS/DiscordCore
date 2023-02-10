package de.flxwdns.discordapi.channel;

import de.flxwdns.discordapi.button.MessageButton;
import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public final class ChannelHandler {
    private final GatewayDiscordClient client;

    public void sendMessage(MessageChannel channel, String message) {
        channel.createMessage(message).block();
    }

    /*public void sendButtons(MessageChannel channel, List<MessageButton> buttons) {
        channel.createMessage(embedCreateSpec).block();
    }*/

    public void sendEmbed(MessageChannel channel, EmbedCreateSpec embedCreateSpec) {
        channel.createMessage(embedCreateSpec).block();
    }

    public void sendEmbed(String channelId, EmbedCreateSpec embedCreateSpec) {
        sendEmbed(client.getChannelById(Snowflake.of(channelId)).ofType(MessageChannel.class).block(), embedCreateSpec);
    }
}
