package de.flxwdns.discordapi.channel;

import de.flxwdns.discordapi.DiscordCore;
import de.flxwdns.discordapi.button.MessageButton;
import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.component.ActionComponent;
import discord4j.core.object.component.ActionRow;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
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

    public void sendEmbedWithButtons(MessageChannel channel, EmbedCreateSpec embedCreateSpec, List<MessageButton> buttons) {
        List<ActionComponent> components = new ArrayList<>();
        buttons.forEach(it -> {
            DiscordCore.getButtonHandler().addButton(it);
            components.add(it.getButton());
        });

        channel.createMessage("").withEmbeds(embedCreateSpec).withComponents(ActionRow.of(components)).block();
    }

    public void sendEmbedWithButtons(String channelId, EmbedCreateSpec embedCreateSpec, List<MessageButton> buttons) {
        sendEmbedWithButtons(client.getChannelById(Snowflake.of(channelId)).ofType(MessageChannel.class).block(), embedCreateSpec, buttons);
    }

    public InteractionApplicationCommandCallbackReplyMono getReplyEmbedWithButtons(InteractionApplicationCommandCallbackReplyMono reply, EmbedCreateSpec embedCreateSpec, List<MessageButton> buttons) {
        List<ActionComponent> components = new ArrayList<>();
        buttons.forEach(it -> {
            DiscordCore.getButtonHandler().addButton(it);
            components.add(it.getButton());
        });

        return reply.withEmbeds(embedCreateSpec).withComponents(ActionRow.of(components));
    }
}
