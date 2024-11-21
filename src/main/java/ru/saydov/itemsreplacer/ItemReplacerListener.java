package ru.saydov.itemsreplacer;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import ru.saydov.itemsreplacer.utils.RegistrableDestroyable;

/**
 * @author saydov
 */
@Singleton
@Slf4j
public final class ItemReplacerListener implements Listener, RegistrableDestroyable {

    @Inject
    private Plugin plugin;

    @Override
    public void register() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public void destroy() {
        HandlerList.unregisterAll(this);
    }

    private @NotNull ItemStack testItem() {
        final ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);

        if (itemStack.hasItemMeta()) {
            final @NotNull ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("Test Item");
            itemMeta.setLore(Lists.asList("Test Lore", new String[]{}));
            itemStack.setItemMeta(itemMeta);
        }

        return itemStack;
    }

    @EventHandler(ignoreCancelled = true)
    public void playerInventoryClick(final InventoryClickEvent event) {
        final @NotNull InventoryAction inventoryAction = event.getAction();

        switch (inventoryAction) {
            case PICKUP_ALL:
            case PICKUP_ONE:
            case PICKUP_SOME:
            case PICKUP_HALF: {
                log.info("Player {} picked up item {}", event.getWhoClicked().getName(),
                        event.getCurrentItem());
                break;
            }
        }
    }

}