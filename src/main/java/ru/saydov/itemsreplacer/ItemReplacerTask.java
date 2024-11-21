package ru.saydov.itemsreplacer;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import ru.saydov.itemsreplacer.config.PersistentConfig;
import ru.saydov.itemsreplacer.config.factory.ConfigurationFactory;
import ru.saydov.itemsreplacer.utils.RegistrableDestroyable;

/**
 * @author saydov
 */
@Singleton
public final class ItemReplacerTask implements RegistrableDestroyable, Runnable {

    @Inject
    private Plugin plugin;
    @Inject
    private ConfigurationFactory configurationFactory;

    private PersistentConfig persistentConfig;

    @Override
    public void register() {
        persistentConfig = configurationFactory.getOrCreate("config.yaml");

        plugin.getServer().getScheduler()
                .runTaskTimerAsynchronously(plugin, this, 0L, 10L);
    }

    @Override
    public void destroy() {
        plugin.getServer().getScheduler().cancelTasks(plugin);
    }

    @Override
    public void run() {
        for (final Player player : plugin.getServer().getOnlinePlayers()) {
            player.getInventory().forEach(item -> {
                if (item == null) {
                    return;
                }

               /* persistentConfig.findMessage("item-replacer")
                        .ifPresent(message -> {
                            if (item.getItemMeta().getDisplayName().equals(message.content())) {
                                player.sendMessage("Item replaced!");
                                player.getInventory().remove(item);
                            }
                        }); */
            });
        }
    }
}
