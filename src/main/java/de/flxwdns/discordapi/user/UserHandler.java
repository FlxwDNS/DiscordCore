package de.flxwdns.discordapi.user;

import de.flxwdns.discordapi.DiscordCore;
import discord4j.common.util.Snowflake;

public final class UserHandler {

    public User getUser(String userId) {
        return new User(DiscordCore.getClient().getUserById(Snowflake.of(userId)).block());
    }

    public User getUser(discord4j.core.object.entity.User user) {
        return new User(user);
    }
}
