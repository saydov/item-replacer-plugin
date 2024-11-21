package ru.saydov.itemsreplacer.guice;

import cloud.commandframework.bukkit.BukkitCommandManager;
import cloud.commandframework.execution.AsynchronousCommandExecutionCoordinator;
import com.google.inject.AbstractModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import ru.saydov.itemsreplacer.ItemReplacerPlugin;
import ru.saydov.itemsreplacer.config.factory.ConfigurationFactory;
import ru.saydov.itemsreplacer.config.factory.SimpleYamlConfigurationFactory;

import java.util.function.Function;

/**
 * @author saydov
 */
@Slf4j
@RequiredArgsConstructor
public final class GuiceLoader extends AbstractModule {

    private final @NotNull ItemReplacerPlugin plugin;

    @Override
    protected void configure() {
        bind(Plugin.class).toInstance(plugin);
        bind(BukkitAudiences.class).toInstance(BukkitAudiences.create(plugin));
        bind(ConfigurationFactory.class).toInstance(new SimpleYamlConfigurationFactory(plugin));

        /*try {
            bind(BukkitCommandManager.class).toInstance(createCommandManager());
        } catch (CommandManagerNotLoadedException e) {
            log.info("§cFailed to initialize BukkitCommandManager", e);
        } */
    }

    private @NotNull BukkitCommandManager<CommandSender> createCommandManager() throws CommandManagerNotLoadedException {
        try {
            final Function<CommandSender, CommandSender> identity = Function.identity();

            return new BukkitCommandManager<>(plugin,
                    AsynchronousCommandExecutionCoordinator.<CommandSender>builder()
                    .withAsynchronousParsing()
                    .build(), identity, identity);
        } catch (final Exception e) {
            throw new CommandManagerNotLoadedException();
        }
    }
}
