package de.flxwdns.discordapi.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

@Getter
@AllArgsConstructor
public enum ColorType {

    SUCCESS(Color.GREEN),
    INFO(Color.CYAN),
    ERROR(Color.RED);

    private final Color color;

}
