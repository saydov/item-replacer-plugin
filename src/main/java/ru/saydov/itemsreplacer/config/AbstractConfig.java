package ru.saydov.itemsreplacer.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.saydov.itemsreplacer.config.jackson.JacksonObjectMapper;
import ru.saydov.itemsreplacer.config.message.Message;
import ru.saydov.itemsreplacer.config.replacer.ReplaceItemBuilder;

import java.io.File;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author saydov
 */
@Getter
@RequiredArgsConstructor
@Slf4j
@Accessors(fluent = true)
public abstract class AbstractConfig implements PersistentConfig {

    private final @NotNull Plugin plugin;
    private final @NotNull JacksonObjectMapper mapper;

    private final @NotNull String name;
    private final @NotNull Map<String, Message> messages;

    private @Nullable File file;

    @Override
    public @NotNull ObjectMapper mapper() {
        return mapper.toObjectMapper();
    }

    @Override
    public @NotNull Optional<Message> findMessage(@NotNull String key) {
        return Optional.ofNullable(messages.get(key));
    }

    @Override
    public void register() {
        if (file == null) {
            file = new File(plugin.getDataFolder(), name);
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (final Exception e) {
                log.error("Failed to create file", e);
            }
        }

        mapper.register();

        reload();
    }

    @Override
    public void reload() {
        messages.clear();
        register();
    }

    @Override
    public void save() {
        try {
            mapper().writerWithDefaultPrettyPrinter()
                    .writeValueAsString(messages);
        } catch (final JsonProcessingException e) {
            log.error("Failed to save messages", e);
        }
    }

    @Override
    public @NotNull Set<ReplaceItemBuilder> replaceItems() {
        return Set.of();
    }

    @Override
    public boolean isIllegal(@NotNull String material) {
        return false;
    }

    @Override
    public void destroy() {
        mapper.destroy();
    }
}
