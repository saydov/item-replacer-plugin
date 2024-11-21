package ru.saydov.itemsreplacer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import ru.saydov.itemsreplacer.config.message.Message;
import ru.saydov.itemsreplacer.config.message.MessageNotFoundException;
import ru.saydov.itemsreplacer.config.replacer.ReplaceItemBuilder;
import ru.saydov.itemsreplacer.utils.RegistrableDestroyable;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author saydov
 */
public interface PersistentConfig extends RegistrableDestroyable {

    @NotNull String name();

    @NotNull Map<String, Message> messages();

    @NotNull Optional<Message> findMessage(final @NotNull String key);

    default @NotNull Message getMessage(final @NotNull String key) throws MessageNotFoundException {
        return findMessage(key).orElseThrow(MessageNotFoundException::new);
    }

    @NotNull ObjectMapper mapper();

    @NotNull Set<ReplaceItemBuilder> replaceItems();

    boolean isIllegal(final @NotNull String material);

    void save();

    void reload();

}
