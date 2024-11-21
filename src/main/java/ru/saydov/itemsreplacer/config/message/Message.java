package ru.saydov.itemsreplacer.config.message;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author saydov
 */
public interface Message {

    List<@NotNull String> getLines();

    @NotNull String getJoinedLines();

    @NotNull String asSingleLine();

    @NotNull Message format(final @NotNull Object... args);

    void send(final @NotNull CommandSender sender);

}