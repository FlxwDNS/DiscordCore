package de.flxwdns.discordapi.message.embed;

import de.flxwdns.discordapi.message.ColorType;
import discord4j.core.spec.EmbedCreateFields;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;

import java.time.Instant;
import java.util.List;

public final class EmbedBuilder {
    private final EmbedCreateSpec.Builder builder;

    public EmbedBuilder() {
        builder = EmbedCreateSpec.builder();
    }

    public EmbedBuilder title(String title) {
        builder.title(title);

        return this;
    }

    public EmbedBuilder description(String description) {
        builder.description(description);
        return this;
    }

    public EmbedBuilder image(String image) {
        builder.image(image);
        return this;
    }

    public EmbedBuilder thumbnail(String url) {
        builder.thumbnail(url);
        return this;
    }

    public EmbedBuilder url(String url) {
        builder.url(url);
        return this;
    }

    public EmbedBuilder footer(EmbedCreateFields.Footer footer) {
        builder.footer(footer);
        return this;
    }

    public EmbedBuilder timestamp(Instant instant) {
        builder.timestamp(instant);
        return this;
    }

    public EmbedBuilder nowTimestamp() {
        builder.timestamp(Instant.now());
        return this;
    }

    public EmbedBuilder author(EmbedCreateFields.Author author) {
        builder.author(author);
        return this;
    }

    public EmbedBuilder fields(List<EmbedCreateFields.Field> fields) {
        fields.forEach(it -> builder.addField(it));

        return this;
    }

    public EmbedBuilder color(ColorType color) {
        return color(color.getColor());
    }

    public EmbedBuilder color(java.awt.Color color) {
        builder.color(Color.of(color.getRGB()));
        return this;
    }

    public EmbedCreateSpec toEmbed() {
        return builder.build();
    }
}
