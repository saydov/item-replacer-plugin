package ru.saydov.itemsreplacer.config.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.bukkit.Sound;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * @author saydov
 */
public final class JacksonSoundDeserializer extends StdDeserializer<Sound> {

    public JacksonSoundDeserializer() {
        super(Sound.class);
    }

    @Override
    public Sound deserialize(final @NotNull JsonParser parser,
                             final @NotNull DeserializationContext context
    ) throws JacksonDeserializerException {
        try {
            return Sound.valueOf(parser.getText());
        } catch (final IOException e) {
            throw new JacksonDeserializerException("Failed to deserialize Sound", e);
        }
    }
}
