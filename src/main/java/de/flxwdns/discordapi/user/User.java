package de.flxwdns.discordapi.user;

import de.flxwdns.discordapi.DiscordCore;
import de.flxwdns.discordapi.message.embed.EmbedConstruct;
import discord4j.common.util.Snowflake;
import discord4j.core.object.component.ActionComponent;
import discord4j.core.object.component.ActionRow;
import discord4j.core.object.component.SelectMenu;
import discord4j.core.object.entity.Member;
import discord4j.discordjson.json.UserData;
import discord4j.rest.util.Image;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public final class User {
    private final discord4j.core.object.entity.User member;

    public discord4j.core.object.entity.User getDefaultMember() {
        return member;
    }

    public UserData getData() {
        return member.getUserData();
    }

    public String getMention() {
        return member.getMention();
    }

    public String getName() {
        return member.getUsername();
    }

    public String getTag() {
        return member.getTag();
    }

    public Image getBanner() {
        return member.getBanner().block();
    }

    public Image getAvatar() {
        return member.getAvatar().block();
    }
    
    public Member getAsGuildMember(String guildId) {
        return DiscordCore.getClient().getGuildById(Snowflake.of(guildId)).block().getMemberById(member.getId()).block();
    }

    public void sendMessage(String message) {
        member.getPrivateChannel().block().createMessage(message).block();
    }

    public void sendEmbedConstruct(EmbedConstruct embedConstruct) {
        List<ActionComponent> components = new ArrayList<>(embedConstruct.getButtons());

        if(embedConstruct.getMenu() != null) {
            List<SelectMenu.Option> options = new ArrayList<>();
            embedConstruct.getMenu().getOptions().forEach(option -> options.add(option.getSelectMenu()));

            DiscordCore.getMenuHandler().addMenu(embedConstruct.getMenu());
            components.add(SelectMenu.of(embedConstruct.getMenu().getCustomId(), options).withPlaceholder(embedConstruct.getMenu().getPlaceholder()).withMinValues(embedConstruct.getMenu().getMinimumValues()).withMaxValues(embedConstruct.getMenu().getMaximumValues()));
        }
        member.getPrivateChannel().block().createMessage("").withEmbeds(embedConstruct.getEmbed()).withComponents(ActionRow.of(components)).block();
    }
}
