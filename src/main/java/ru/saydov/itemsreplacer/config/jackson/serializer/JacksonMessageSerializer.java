package ru.saydov.itemsreplacer.config.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.saydov.itemsreplacer.config.message.Message;

import java.io.IOException;

/**
 * @author saydov
 */
public class JacksonMessageSerializer extends StdSerializer<Message> {
    protected JacksonMessageSerializer(Class<Message> t) {
        super(t);
    }

    @Override
    public void serialize(Message message, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

    }
}
