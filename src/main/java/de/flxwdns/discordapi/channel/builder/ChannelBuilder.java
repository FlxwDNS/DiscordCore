package de.flxwdns.discordapi.channel.builder;

import discord4j.common.util.Snowflake;
import discord4j.core.object.PermissionOverwrite;
import discord4j.core.spec.TextChannelCreateSpec;

import java.util.ArrayList;
import java.util.List;

public final class ChannelBuilder {
    private final TextChannelCreateSpec.Builder builder;

    public ChannelBuilder() {
        builder = TextChannelCreateSpec.builder();
    }

    public ChannelBuilder name(String name) {
        builder.name(name);
        return this;
    }

    public ChannelBuilder category(String categoryId) {
        builder.parentId(Snowflake.of(categoryId));
        return this;
    }

    public ChannelBuilder permissions(List<ChannelPermission> permissions) {
        List<PermissionOverwrite> permissionOverwrites = new ArrayList<>();

        permissions.forEach(permission -> {
            if(permission.getIsMember()) permissionOverwrites.add(PermissionOverwrite.forMember(Snowflake.of(permission.getId()), permission.getAllowed(), permission.getDenied()));
            else permissionOverwrites.add(PermissionOverwrite.forRole(Snowflake.of(permission.getId()), permission.getAllowed(), permission.getDenied()));
        });
        builder.permissionOverwrites(permissionOverwrites);
        return this;
    }

    public ChannelBuilder topic(String topic) {
        builder.topic(topic);
        return this;
    }

    public ChannelBuilder nsfw(Boolean value) {
        builder.nsfw(value);
        return this;
    }

    public TextChannelCreateSpec toChannel() {
        return builder.build();
    }
}
