package ru.saydov.itemsreplacer.config.message;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.saydov.itemsreplacer.utils.ColorUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author saydov
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class SingleMessage implements Message {

    @Contract("_ -> new")
    public static @NotNull SingleMessage create(final @NotNull String message) {
        return new SingleMessage(ColorUtils.color(message));
    }

    private final @NotNull String message;

    @Override
    public List<@NotNull String> getLines() {
        return Collections.singletonList(message);
    }

    @Override
    public @NotNull String getJoinedLines() {
        return message;
    }

    @Override
    public @NotNull String asSingleLine() {
        return message;
    }

    @Override
    public @NotNull Message format(final @NotNull Object... args) {
        String cloned = message;

        for (int i = 0; i < args.length; i++) {
            cloned = cloned.replace("{" + i + "}",
                    args[i].toString());
        }

        return SingleMessage.create(cloned);
    }

    @Override
    public void send(final @NotNull CommandSender sender) {
        sender.sendMessage(message);
    }

}
