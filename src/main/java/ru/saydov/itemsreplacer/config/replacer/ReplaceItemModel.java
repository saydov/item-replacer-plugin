package ru.saydov.itemsreplacer.config.replacer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author saydov
 */
@RequiredArgsConstructor
@Getter
public class ReplaceItemModel {

    private final String material;
    private final String displayName;
    private final String lore;


}
