package de.flxwdns.discordcore.register;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClientCfg {
    @NotNull String token();

    @NotNull String[] ownerId() default {"769860621981319188"};
}
