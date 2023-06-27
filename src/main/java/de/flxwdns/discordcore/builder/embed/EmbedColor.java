package de.flxwdns.discordcore.builder.embed;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

@Getter
@AllArgsConstructor
public enum EmbedColor {
    SUCCESS(Color.GREEN),
    INFO(Color.CYAN),
    ERROR(Color.RED);

    private final Color color;
}
