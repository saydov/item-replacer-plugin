package ru.saydov.itemsreplacer.config.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

/**
 * @author saydov
 */
public class JacksonYamlObjectMapper extends JacksonObjectMapper {

    public JacksonYamlObjectMapper() {
        super(new YAMLMapper()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        );
    }
}
