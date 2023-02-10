package de.flxwdns.test;

import de.flxwdns.discordapi.DiscordBot;
import de.flxwdns.discordapi.DiscordCore;
import de.flxwdns.discordapi.button.MessageButton;
import de.flxwdns.discordapi.message.MessageBuilder;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.component.Button;

import java.util.List;

public class Test extends DiscordBot {

    @Override
    public void initialize() {
        DiscordCore.getCommandHandler().addCommand(new OfferCommand());

        /*DiscordCore.getEventHandler().registerEvent(MessageCreateEvent.class, event -> {
            DiscordCore.getChannelHandler().sendEmbedWithButtons(event.getMessage().getChannel().block(), new MessageBuilder().description("test").build(), List.of(
                    new MessageButton(Button.danger("test_1", "Test"), event1 -> {

                    }),
                    new MessageButton(Button.primary("test_2", "Test2"), event1 -> {
                        event1.reply("test");
                    })
            ));
        });*/
    }

    @Override
    public String getToken() {
        return "OTMxMjYwNTk1NzYyNzg2MzE1.Gl-Pm2.yucIMl6bmMD6mbKrQwXkj_KbfZRvCPKQxHMkqc";
    }
}