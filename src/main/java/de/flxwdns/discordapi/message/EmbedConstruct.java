package de.flxwdns.discordapi.message;

import de.flxwdns.discordapi.DiscordCore;
import de.flxwdns.discordapi.button.MessageButton;
import de.flxwdns.discordapi.menu.MessageMenu;
import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import lombok.Getter;

import java.util.List;

@Getter
public final class EmbedConstruct {
    private final MessageChannel channel;
    private final EmbedCreateSpec embed;

    private final List<MessageButton> buttons;
    private final MessageMenu menu;

    public EmbedConstruct(MessageChannel channel, EmbedCreateSpec embed, List<MessageButton> buttons, MessageMenu menu) {
        this.channel = channel;
        this.embed = embed;

        this.buttons = buttons;
        this.menu = menu;
    }

    public EmbedConstruct(String channelId, EmbedCreateSpec embed) {
        this(DiscordCore.getClient().getChannelById(Snowflake.of(channelId)).ofType(MessageChannel.class).block(), embed, List.of(), null);
    }

    public EmbedConstruct(String channelId, EmbedCreateSpec embed, List<MessageButton> buttons) {
        this(DiscordCore.getClient().getChannelById(Snowflake.of(channelId)).ofType(MessageChannel.class).block(), embed, buttons, null);
    }

    public EmbedConstruct(String channelId, EmbedCreateSpec embed, MessageMenu menu) {
        this(DiscordCore.getClient().getChannelById(Snowflake.of(channelId)).ofType(MessageChannel.class).block(), embed, List.of(), menu);
    }
}
