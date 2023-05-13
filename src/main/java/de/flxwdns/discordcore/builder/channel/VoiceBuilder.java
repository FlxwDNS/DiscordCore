package de.flxwdns.discordcore.builder.channel;

import discord4j.common.util.Snowflake;
import discord4j.core.object.PermissionOverwrite;
import discord4j.core.spec.VoiceChannelCreateSpec;

import java.util.ArrayList;
import java.util.List;

public final class VoiceBuilder {
    private final VoiceChannelCreateSpec.Builder builder;

    public VoiceBuilder() {
        builder = VoiceChannelCreateSpec.builder();
    }

    public VoiceBuilder name(String name) {
        builder.name(name);
        return this;
    }

    public VoiceBuilder category(String categoryId) {
        builder.parentId(Snowflake.of(categoryId));
        return this;
    }

    public VoiceBuilder permissions(List<ChannelPermission> permissions) {
        List<PermissionOverwrite> permissionOverwrites = new ArrayList<>();

        permissions.forEach(permission -> {
            if(permission.getIsMember()) permissionOverwrites.add(PermissionOverwrite.forMember(Snowflake.of(permission.getId()), permission.getAllowed(), permission.getDenied()));
            else permissionOverwrites.add(PermissionOverwrite.forRole(Snowflake.of(permission.getId()), permission.getAllowed(), permission.getDenied()));
        });
        builder.permissionOverwrites(permissionOverwrites);
        return this;
    }

    public VoiceChannelCreateSpec toVoice() {
        return builder.build();
    }
}
