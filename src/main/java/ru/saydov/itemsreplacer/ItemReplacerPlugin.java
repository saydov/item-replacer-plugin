package ru.saydov.itemsreplacer;

import cloud.commandframework.bukkit.BukkitCommandManager;
import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.extern.slf4j.Slf4j;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;
import org.jetbrains.annotations.NotNull;
import ru.saydov.itemsreplacer.config.factory.ConfigurationFactory;
import ru.saydov.itemsreplacer.guice.GuiceLoader;

/**
 * @author saydov
 */
@Plugin(name = "ItemReplacer", version = "1.0")
@Description("A plugin that replaces illegal items in the player's inventory")
@Author("saydov")
@Slf4j
public final class ItemReplacerPlugin extends JavaPlugin {

    private Injector injector;

    @Override
    public void onEnable() {
        injector = Guice.createInjector(new GuiceLoader(this));

        final @NotNull ConfigurationFactory configurationFactory = injector.getInstance(ConfigurationFactory.class);
        configurationFactory.create("config.yaml");
        configurationFactory.register();

        //registerCommands();
        injector.getInstance(ItemReplacerListener.class).register();
        injector.getInstance(ItemReplacerTask.class).register();
    }

    private void registerCommands() {
        @SuppressWarnings("unchecked")
        final BukkitCommandManager<CommandSender> commandManager = injector.getInstance(BukkitCommandManager.class);

        if (commandManager != null) {
            injector.getInstance(ItemReplacerCommand.class).register();
        }
    }

    @Override
    public void onDisable() {
        injector.getInstance(ItemReplacerCommand.class).destroy();
        injector.getInstance(ItemReplacerListener.class).destroy();
        injector.getInstance(ItemReplacerTask.class).destroy();
        injector.getInstance(ConfigurationFactory.class).destroy();
    }
}
