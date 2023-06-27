package de.flxwdns.discordcore.services.impl;

import de.flxwdns.discordcore.builder.embed.EmbedConstruct;
import de.flxwdns.discordcore.injection.InjectionLayer;
import de.flxwdns.discordcore.services.DefaultService;
import de.flxwdns.discordcore.services.MessageService;
import discord4j.common.util.Snowflake;
import discord4j.core.object.component.ActionComponent;
import discord4j.core.object.component.ActionRow;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImplMessageService implements MessageService {
    @Override
    public Message sendMessage(MessageChannel channel, String message) {
        return channel.createMessage(message).block();
    }

    @Override
    public Message sendMessage(String channelId, String message) {
        return sendMessage(Objects.requireNonNull(InjectionLayer.next(DefaultService.class).client().getChannelById(Snowflake.of(channelId)).ofType(MessageChannel.class).block()), message);
    }

    @Override
    public Message sendEmbed(EmbedConstruct construct) {
        List<ActionComponent> components = new ArrayList<>(construct.getButtons());

        /*if(messageConstruct.getMenu() != null) {
            List<SelectMenu.Option> options = new ArrayList<>();
            messageConstruct.getMenu().getOptions().forEach(option -> options.add(option.getSelectMenu()));

            DiscordCore.getMenuHandler().addMenu(messageConstruct.getMenu());
            components.add(SelectMenu.of(messageConstruct.getMenu().getCustomId(), options).withPlaceholder(messageConstruct.getMenu().getPlaceholder()).withMinValues(messageConstruct.getMenu().getMinimumValues()).withMaxValues(messageConstruct.getMenu().getMaximumValues()));
        }*/

        return construct.getChannel().createMessage("").withEmbeds(construct.getEmbed()).withComponents(ActionRow.of(components)).block();
    }
}
