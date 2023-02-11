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
    private final List<MessageMenu> menus;

    public EmbedConstruct(MessageChannel channel, EmbedCreateSpec embed, List<MessageButton> buttons, List<MessageMenu> menus) {
        this.channel = channel;
        this.embed = embed;

        this.buttons = buttons;
        this.menus = menus;
    }

    public EmbedConstruct(String channelId, EmbedCreateSpec embed) {
        this(DiscordCore.getClient().getChannelById(Snowflake.of(channelId)).ofType(MessageChannel.class).block(), embed, List.of(), List.of());
    }

    public EmbedConstruct(String channelId, EmbedCreateSpec embed, List<MessageButton> buttons) {
        this(DiscordCore.getClient().getChannelById(Snowflake.of(channelId)).ofType(MessageChannel.class).block(), embed, buttons, List.of());
    }

    public EmbedConstruct(String channelId, EmbedCreateSpec embed, List<MessageButton> buttons, List<MessageMenu> menus) {
        this(DiscordCore.getClient().getChannelById(Snowflake.of(channelId)).ofType(MessageChannel.class).block(), embed, buttons, menus);
    }
}
