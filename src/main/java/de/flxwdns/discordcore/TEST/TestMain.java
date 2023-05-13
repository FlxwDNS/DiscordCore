package de.flxwdns.discordcore.TEST;

import de.flxwdns.discordcore.injection.InjectionLayer;
import de.flxwdns.discordcore.register.BotClient;
import de.flxwdns.discordcore.register.ClientCfg;
import de.flxwdns.discordcore.services.ChannelService;
import de.flxwdns.discordcore.services.DefaultService;
import discord4j.core.object.presence.ClientActivity;
import discord4j.core.object.presence.Status;
import discord4j.core.spec.TextChannelCreateSpec;

import java.util.Random;

@ClientCfg(token = "")
public class TestMain extends BotClient {

    public TestMain() {
    }

    @Override
    public void onClientPrepare() {
    }

    @Override
    public void onClientReady() {
        InjectionLayer.next(DefaultService.class).updateStatus(Status.IDLE, ClientActivity.playing("Nothing"));

        InjectionLayer.next(ChannelService.class).createTextChannel("1106897084751282178", TextChannelCreateSpec.of("Test " + new Random().nextInt(9999)));
    }
}
