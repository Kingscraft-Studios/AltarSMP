package net.kingscraft.zenixmc.altarsmp.command;

import net.kingscraft.zenixmc.altarsmp.listener.AbilityInputListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AbilityCommand implements CommandExecutor {

    public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, String @NotNull [] paramArrayOfString) {
        if (paramCommandSender instanceof Player player) {
            {
                if (paramCommand.getName().equals("ability1")) {
                    AbilityInputListener.activateMainHandAbility(player);
                    return true;
                }
            }{
                if (paramCommand.getName().equals("ability2")) {
                    AbilityInputListener.activateOffhandAbility(player);
                    return true;
                }
            }}
        return true;
    }
}
