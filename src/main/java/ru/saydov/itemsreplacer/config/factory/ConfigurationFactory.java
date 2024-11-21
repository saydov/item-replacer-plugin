package ru.saydov.itemsreplacer.config.factory;

import org.jetbrains.annotations.NotNull;
import ru.saydov.itemsreplacer.config.PersistentConfig;
import ru.saydov.itemsreplacer.utils.RegistrableDestroyable;

import java.util.Map;
import java.util.Optional;

/**
 * @author saydov
 */
public interface ConfigurationFactory extends RegistrableDestroyable {

    @NotNull Map<String, PersistentConfig> configs();

    @NotNull PersistentConfig create(final @NotNull String name);

    @NotNull Optional<PersistentConfig> findConfig(final @NotNull String name);

    default @NotNull PersistentConfig get(final @NotNull String name) throws ConfigNotFoundException {
        return findConfig(name).orElseThrow(ConfigNotFoundException::new);
    }

    default @NotNull PersistentConfig getOrCreate(final @NotNull String name) {
        return findConfig(name).orElseGet(() -> create(name));
    }

    void remove(@NotNull String name);

    void save(@NotNull String name);

    void saveAll();

    void reload(@NotNull String name);

    void reloadAll();

}
