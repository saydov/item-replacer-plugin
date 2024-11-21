package ru.saydov.itemsreplacer.config.replacer;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.bukkit.Material;

import java.util.List;

/**
 * @author saydov
 */
@RequiredArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class ReplaceItemBuilder {

    private final Material material;
    private final String displayName;
    private final List<String> lore;

}
