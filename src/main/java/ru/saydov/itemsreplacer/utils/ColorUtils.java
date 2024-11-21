package ru.saydov.itemsreplacer.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@UtilityClass
public class ColorUtils {

    private static final Pattern HEX_PATTERN = Pattern.compile("#[a-fA-F0-9]{6}");

    public @NotNull List<String> color(final @NotNull List<String> text) {
        return text.stream()
                .map(ColorUtils::color)
                .collect(Collectors.toList());
    }

    public @NotNull String color(final @NotNull String text) {
        final @NotNull Matcher matcher = HEX_PATTERN.matcher(text);

        if (matcher.find()) {
           //return matcher.replaceAll(match -> ChatColor.getByChar(match.group()).toString());
        }

        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
