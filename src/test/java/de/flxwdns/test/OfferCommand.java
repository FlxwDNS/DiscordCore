package de.flxwdns.test;

import de.flxwdns.discordapi.DiscordCore;
import de.flxwdns.discordapi.button.MessageButton;
import de.flxwdns.discordapi.command.SlashCommand;
import de.flxwdns.discordapi.message.MessageBuilder;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.object.component.Button;
import discord4j.core.spec.InteractionApplicationCommandCallbackReplyMono;


import java.util.List;

public class OfferCommand extends SlashCommand {

    public OfferCommand() {
        super("offer", "Erstellt ein neues Angebot", List.of());
    }

    @Override
    public InteractionApplicationCommandCallbackReplyMono handle(ChatInputInteractionEvent event) {
        return DiscordCore.getChannelHandler().getReplyEmbedWithButtons(event.reply(), new MessageBuilder().description("test").build(), List.of(
                new MessageButton(Button.danger("test_1", "Test"), onClick -> {
                    return onClick.reply("test");
                }),
                new MessageButton(Button.primary("test_2", "Test2"), onClick -> {
                    return onClick.reply("test");
                }),
                new MessageButton(Button.link("https://test.de", "Test2"), onClick -> {
                    return onClick.reply("test");
                })
        ));
    }
}