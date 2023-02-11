import de.flxwdns.discordapi.DiscordBot;
import de.flxwdns.discordapi.DiscordCore;
import de.flxwdns.discordapi.menu.MenuOption;
import de.flxwdns.discordapi.menu.MessageMenu;
import de.flxwdns.discordapi.message.EmbedBuilder;
import de.flxwdns.discordapi.message.EmbedConstruct;
import discord4j.core.object.component.SelectMenu;

import java.util.List;

public class test2 extends DiscordBot {
    @Override
    public void initialize() {
        DiscordCore.getChannelHandler().sendEmbedConstruct(new EmbedConstruct("1071127020311945238", new EmbedBuilder().description("test").toEmbed(),
                new MessageMenu("test_id", List.of(
                        new MenuOption(SelectMenu.Option.of("test" , "test1"), event -> {
                            DiscordCore.getChannelHandler().sendMessage(event.getInteraction().getChannel().block(), "test1 is enabled");
                        }, event -> {
                            DiscordCore.getChannelHandler().sendMessage(event.getInteraction().getChannel().block(), "test1 is disabled");
                        }),
                        new MenuOption(SelectMenu.Option.of("test2" , "t2"), event -> {
                            DiscordCore.getChannelHandler().sendMessage(event.getInteraction().getChannel().block(), "test2 is enabled");
                        }, event -> {
                            DiscordCore.getChannelHandler().sendMessage(event.getInteraction().getChannel().block(), "test2 is disabled");
                        })
                ), event -> {
                    return event.reply("CLICKED ON MENU");
                })
        ));
    }

    @Override
    public String getToken() {
        return "OTMxMjYwNTk1NzYyNzg2MzE1.Gl-Pm2.yucIMl6bmMD6mbKrQwXkj_KbfZRvCPKQxHMkqc";
    }
}
