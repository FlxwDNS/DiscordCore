package de.flxwdns.discordcore.builder.channel;

import discord4j.rest.util.PermissionSet;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class ChannelPermission {
    private final String id;
    private final Boolean isMember;
    private final PermissionSet allowed;
    private final PermissionSet denied;

}
