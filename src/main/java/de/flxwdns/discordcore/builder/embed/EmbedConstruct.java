package de.flxwdns.discordcore.builder.embed;

import de.flxwdns.discordcore.injection.InjectionLayer;
import de.flxwdns.discordcore.services.DefaultService;
import discord4j.common.util.Snowflake;
import discord4j.core.object.component.Button;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public final class EmbedConstruct {
    private final MessageChannel channel;
    private final EmbedCreateSpec embed;
    private final List<Button> buttons;

    public EmbedConstruct(String channelId, EmbedCreateSpec embed, List<Button> buttons) {
        this(InjectionLayer.next(DefaultService.class).client().getChannelById(Snowflake.of(channelId)).ofType(MessageChannel.class).block(), embed, buttons);
    }

    public EmbedConstruct(String channelId, EmbedCreateSpec embed) {
        this(InjectionLayer.next(DefaultService.class).client().getChannelById(Snowflake.of(channelId)).ofType(MessageChannel.class).block(), embed, List.of());
    }
}
