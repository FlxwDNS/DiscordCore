package de.flxwdns.discordapi.message;

import de.flxwdns.discordapi.button.MessageButton;
import discord4j.core.spec.EmbedCreateFields;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;

import java.time.Instant;
import java.util.List;

public final class MessageBuilder {
    private EmbedCreateSpec.Builder builder;

    public MessageBuilder() {
        // Default Layout
        builder = EmbedCreateSpec.builder();
    }

    public MessageBuilder title(String title) {
        builder.title(title);
        return this;
    }

    public MessageBuilder description(String description) {
        builder.description(description);
        return this;
    }

    public MessageBuilder image(String image) {
        builder.image(image);
        return this;
    }

    public MessageBuilder thumbnail(String url) {
        builder.thumbnail(url);
        return this;
    }

    public MessageBuilder url(String url) {
        builder.url(url);
        return this;
    }

    public MessageBuilder footer(EmbedCreateFields.Footer footer) {
        builder.footer(footer);
        return this;
    }

    public MessageBuilder timestamp(Instant instant) {
        builder.timestamp(instant);
        return this;
    }

    public MessageBuilder nowTimestamp() {
        builder.timestamp(Instant.now());
        return this;
    }

    public MessageBuilder author(EmbedCreateFields.Author author) {
        builder.author(author);
        return this;
    }

    public MessageBuilder fields(List<EmbedCreateFields.Field> fields) {
        fields.forEach(it -> builder.addField(it));

        return this;
    }

    public MessageBuilder color(ColorType color) {
        return color(color.getColor());
    }

    public MessageBuilder color(java.awt.Color color) {
        builder.color(Color.of(color.getRGB()));
        return this;
    }

    public EmbedCreateSpec build() {
        return builder.build();
    }
}
