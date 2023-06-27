package de.flxwdns.discordcore.services;

import de.flxwdns.discordcore.builder.embed.EmbedConstruct;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;

public interface MessageService {

    Message sendMessage(MessageChannel channel, String message);
    Message sendMessage(String channelId, String message);

    Message sendEmbed(EmbedConstruct construct);
  //InteractionApplicationCommandCallbackReplyMono getReplyEmbedConstruct(InteractionApplicationCommandCallbackReplyMono reply, EmbedCreateSpec embedCreateSpec);
}
