package ru.saydov.itemsreplacer.config.factory;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import ru.saydov.itemsreplacer.config.PersistentConfig;
import ru.saydov.itemsreplacer.config.SimpleYamlConfig;

/**
 * @author saydov
 */
public final class SimpleYamlConfigurationFactory extends AbstractConfigurationFactory {

    private final Plugin plugin;

    public SimpleYamlConfigurationFactory(final @NotNull Plugin plugin) {
        super(new Object2ObjectOpenHashMap<>());
        this.plugin = plugin;
    }

    @Override
    public @NotNull PersistentConfig create(@NotNull String name) {
        return SimpleYamlConfig.create(plugin, name);
    }
}
