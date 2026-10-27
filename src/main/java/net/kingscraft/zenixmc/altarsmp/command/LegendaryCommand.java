package net.kingscraft.zenixmc.altarsmp.command;

import net.kingscraft.zenixmc.altarsmp.menu.LegendaryItemsMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LegendaryCommand implements CommandExecutor {

    public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, String @NotNull [] paramArrayOfString) {
        if (paramCommandSender instanceof Player player) {
            LegendaryItemsMenu.openLegendaryItemsMenu(player);
        }
        return false;
    }
}
