package ru.saydov.itemsreplacer.config.message;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.saydov.itemsreplacer.utils.ColorUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author saydov
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class MultiMessage implements Message {

    @Contract("_ -> new")
    public static @NotNull MultiMessage create(final @NotNull List<String> lines) {
        return new MultiMessage(lines.stream()
                .map(ColorUtils::color)
                .collect(Collectors.toList()));
    }
    
    private final @NotNull List<String> lines;

    @Override
    public @NotNull List<@NotNull String> getLines() {
        return lines;
    }

    @Override
    public @NotNull String getJoinedLines() {
        return String.join("\n", lines);
    }

    @Override
    public @NotNull String asSingleLine() {
        return String.join(" ", lines);
    }

    @Override
    public @NotNull Message format(final @NotNull Object... args) {
        List<String> cloned = new ArrayList<>(lines);

        for (int i = 0; i < cloned.size(); i++) {
            for (int j = 0; j < args.length; j++) {
                cloned.set(i, cloned.get(i)
                        .replaceAll("\\{" + j + "}", args[j].toString()));
            }
        }

        return MultiMessage.create(cloned);
    }

    @Override
    public void send(final @NotNull CommandSender sender) {
        lines.forEach(sender::sendMessage);
    }

}
