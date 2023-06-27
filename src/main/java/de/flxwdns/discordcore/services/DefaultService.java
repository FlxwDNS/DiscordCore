package de.flxwdns.discordcore.services;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.presence.ClientActivity;
import discord4j.core.object.presence.Status;

public interface DefaultService {
    GatewayDiscordClient client();

    boolean isLogging();

    void updateStatus(Status status, ClientActivity clientActivity);
    void enableLogging();
}