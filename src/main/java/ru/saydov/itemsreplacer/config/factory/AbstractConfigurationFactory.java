package ru.saydov.itemsreplacer.config.factory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import ru.saydov.itemsreplacer.config.PersistentConfig;

import java.util.Map;
import java.util.Optional;

/**
 * @author saydov
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED, onConstructor_ = @NotNull)
public abstract class AbstractConfigurationFactory implements ConfigurationFactory {

    @Accessors(fluent = true)
    private final @NotNull Map<String, PersistentConfig> configs;

    @Override
    public void register() {
        configs.forEach((name, config) -> config.register());
    }

    @Override
    public void destroy() {
        configs.forEach((name, config) -> config.destroy());
    }

    @Override
    public @NotNull Optional<PersistentConfig> findConfig(@NotNull String name) {
        return Optional.ofNullable(configs.get(name));
    }

    @Override
    public void reload(@NotNull String name) {
        findConfig(name).ifPresent(PersistentConfig::reload);
    }

    @Override
    public void reloadAll() {
        configs.forEach((name, config) -> config.reload());
    }

    @Override
    public void remove(@NotNull String name) {
        findConfig(name).ifPresent(PersistentConfig::destroy);
    }

    @Override
    public void save(@NotNull String name) {
        findConfig(name).ifPresent(PersistentConfig::save);
    }

    @Override
    public void saveAll() {
        configs.forEach((name, config) -> config.save());
    }
}
