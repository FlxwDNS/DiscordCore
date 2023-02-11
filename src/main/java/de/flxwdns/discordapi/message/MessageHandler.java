package de.flxwdns.discordapi.message;

import de.flxwdns.discordapi.DiscordCore;
import de.flxwdns.discordapi.message.embed.EmbedConstruct;
import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.component.ActionComponent;
import discord4j.core.object.component.ActionRow;
import discord4j.core.object.component.SelectMenu;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;

import java.util.ArrayList;
import java.util.List;

public final class MessageHandler {
    private final GatewayDiscordClient client;

    public MessageHandler() {
        client = DiscordCore.getClient();
    }

    public Message sendMessage(MessageChannel channel, String message) {
        return channel.createMessage(message).block();
    }

    public Message sendMessage(String channelId, String message) {
        return sendMessage(client.getChannelById(Snowflake.of(channelId)).ofType(MessageChannel.class).block(), message);
    }

    public Message sendEmbedConstruct(EmbedConstruct messageConstruct) {
        List<ActionComponent> components = new ArrayList<>();
        messageConstruct.getButtons().forEach(it -> {
            DiscordCore.getButtonHandler().addButton(it);
            components.add(it.getButton());
        });

        if(messageConstruct.getMenu() != null) {
            List<SelectMenu.Option> options = new ArrayList<>();
            messageConstruct.getMenu().getOptions().forEach(option -> options.add(option.getSelectMenu()));

            DiscordCore.getMenuHandler().addMenu(messageConstruct.getMenu());
            components.add(SelectMenu.of(messageConstruct.getMenu().getCustomId(), options).withPlaceholder(messageConstruct.getMenu().getPlaceholder()).withMinValues(messageConstruct.getMenu().getMinimumValues()).withMaxValues(messageConstruct.getMenu().getMaximumValues()));
        }

        return messageConstruct.getChannel().createMessage("").withEmbeds(messageConstruct.getEmbed()).withComponents(ActionRow.of(components)).block();
    }

    public InteractionApplicationCommandCallbackReplyMono getReplyEmbedConstruct(InteractionApplicationCommandCallbackReplyMono reply, EmbedCreateSpec embedSpec) {
        return reply.withEmbeds(embedSpec);
    }
}
