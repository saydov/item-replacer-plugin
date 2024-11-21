package ru.saydov.itemsreplacer.config.jackson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bukkit.Sound;
import ru.saydov.itemsreplacer.config.message.Message;

import java.util.Map;

/**
 * @author saydov
 */
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
public class JacksonObjectModel {

    private Sound sound;

    private Map<String, Message> messages;

}
