package ru.saydov.itemsreplacer.config.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.jetbrains.annotations.NotNull;
import ru.saydov.itemsreplacer.config.message.Message;
import ru.saydov.itemsreplacer.config.message.MultiMessage;
import ru.saydov.itemsreplacer.config.message.SingleMessage;

import java.io.IOException;

/**
 * @author saydov
 */
public final class JacksonMessageDeserializer extends StdDeserializer<Message> {

    public JacksonMessageDeserializer() {
        super(Message.class);
    }

    @Override
    public Message deserialize(final @NotNull JsonParser parser,
                             final @NotNull DeserializationContext context
    ) throws JacksonDeserializerException {
        try {
            if (parser.isExpectedStartArrayToken()) {
                return context.readValue(parser, MultiMessage.class);
            } else {
                return context.readValue(parser, SingleMessage.class);
            }
        } catch (final IOException e) {
            throw new JacksonDeserializerException("Failed to deserialize Message", e);
        }
    }
}
