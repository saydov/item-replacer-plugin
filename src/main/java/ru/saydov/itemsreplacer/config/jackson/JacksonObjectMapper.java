package ru.saydov.itemsreplacer.config.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.bukkit.Sound;
import org.jetbrains.annotations.NotNull;
import ru.saydov.itemsreplacer.config.jackson.deserializer.JacksonMessageDeserializer;
import ru.saydov.itemsreplacer.config.jackson.deserializer.JacksonSoundDeserializer;
import ru.saydov.itemsreplacer.config.message.Message;
import ru.saydov.itemsreplacer.utils.RegistrableDestroyable;

/**
 * @author saydov
 */
@RequiredArgsConstructor(onConstructor_ = @NotNull)
public abstract class JacksonObjectMapper implements RegistrableDestroyable {

    @Accessors(fluent = true)
    private final ObjectMapper mapper;

    @Override
    public void register() {
        mapper.registerModule(new SimpleModule()
                .addDeserializer(Sound.class, new JacksonSoundDeserializer())
                .addDeserializer(Message.class, new JacksonMessageDeserializer())
        );
    }

    @Override
    public void destroy() {
        mapper.getRegisteredModuleIds().clear();
    }

    public @NotNull ObjectMapper toObjectMapper() {
        return mapper;
    }
}
