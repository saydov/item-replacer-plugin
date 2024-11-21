package ru.saydov.itemsreplacer;

import cloud.commandframework.Command;
import cloud.commandframework.bukkit.BukkitCommandManager;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import ru.saydov.itemsreplacer.utils.RegistrableDestroyable;

/**
 * @author saydov
 */
@Getter
@Singleton
public final class ItemReplacerCommand implements RegistrableDestroyable {

    @Inject
    private ItemReplacerPlugin plugin;

    @Inject
    private BukkitCommandManager<CommandSender> bukkitCommandManager;

    @Override
    public void register() {
        Command.Builder<CommandSender> builder = bukkitCommandManager
                .commandBuilder("itemreplacer", "ir")
                .permission("itemreplacer.admin");

        builder.handler(context -> {
            CommandSender sender = context.getSender();
            sender.sendMessage("Hello, world!");
        });
    }

    @Override
    public void destroy() {

    }
}
