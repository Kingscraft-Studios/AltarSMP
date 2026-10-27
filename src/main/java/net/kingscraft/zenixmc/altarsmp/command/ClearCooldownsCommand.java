package net.kingscraft.zenixmc.altarsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kingscraft.zenixmc.altarsmp.weapon.knightfall.KnightfallListener;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.weapon.crazy.CrazySlotsListener;
import org.bukkit.scheduler.BukkitTask;
import org.jspecify.annotations.NonNull;

import java.util.UUID;

public class ClearCooldownsCommand implements CommandExecutor {

  public boolean onCommand(@NonNull CommandSender paramCommandSender, @NonNull Command paramCommand, @NonNull String paramString, String[] paramArrayOfString) {
    {
      if (paramArrayOfString.length == 0) {
        if (paramCommandSender instanceof Player player1) {
          clearAllCooldowns(player1);
          player1.sendMessage(Component.text("Your cooldowns have been cleared!", NamedTextColor.GREEN));
          player1.setCooldown(Material.CROSSBOW, 1);
        } else {
          paramCommandSender.sendMessage(Component.text("Only players can clear their own cooldowns.", NamedTextColor.RED));
        } 
        return true;
      } 
    }Player player = Bukkit.getPlayer(paramArrayOfString[0]);
    {
      if (player != null && player.isOnline()) {
        clearAllCooldowns(player);
        player.setCooldown(Material.CROSSBOW, 1);
        paramCommandSender.sendMessage(Component.text("Cooldowns cleared for " + player.getName() + "!", NamedTextColor.GREEN));
      } else {
        paramCommandSender.sendMessage(Component.text("Player '" + paramArrayOfString[0] + "' not found or not online.", NamedTextColor.RED));
      } 
    }return true;
  }

  public static void clearAllCooldowns(Player player) {
    UUID id = player.getUniqueId();

    CooldownManager.clearExpiries(id);
    CrazySlotsListener.clearCrazySlots(player);
    KnightfallListener.hookCharges.put(id, 0);

    BukkitTask task = KnightfallListener.hookCooldownTasks.get(id);
    if (task != null) {
      task.cancel();
    }

    BossBarManager.activeBars.forEach(bar -> bar.removePlayer(player));
    BossBarManager.activeBars.clear();
  }


}
