package ru.saydov.itemsreplacer.config;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.saydov.itemsreplacer.config.jackson.JacksonObjectMapper;
import ru.saydov.itemsreplacer.config.jackson.JacksonYamlObjectMapper;

/**
 * @author saydov
 */
public class SimpleYamlConfig extends AbstractConfig {

    @Contract("_, _ -> new")
    public static @NotNull AbstractConfig create(final @NotNull Plugin plugin, final @NotNull String name) {
        return new SimpleYamlConfig(plugin, new JacksonYamlObjectMapper(), name);
    }

    public SimpleYamlConfig(final @NotNull Plugin plugin,
                            final @NotNull JacksonObjectMapper mapper,
                            final @NotNull String name) {
        super(plugin, mapper, name, new Object2ObjectOpenHashMap<>());
    }
}
