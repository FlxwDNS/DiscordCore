package de.flxwdns.discordapi;

import de.flxwdns.discordapi.button.MessageButton;
import de.flxwdns.discordapi.message.MessageBuilder;
import discord4j.core.object.component.Button;

import java.util.List;

public final class Test extends DiscordBot {

    @Override
    public void initialize() {
        new MessageBuilder().buttons(List.of(
                new MessageButton(Button.primary("id", "Click to me"), event -> {
                    event.reply("test");
                })
        ));
    }

    @Override
    public String getToken() {
        return "Test";
    }
}
