package net.kingscraft.zenixmc.altarsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.kingscraft.zenixmc.altarsmp.armor.knightfall.KnightfallListener;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.cooldown.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.event.crazy.CrazySlotsListener;
import org.jspecify.annotations.NonNull;

public class ClearCooldownsCommand implements CommandExecutor {

  public boolean onCommand(@NonNull CommandSender paramCommandSender, @NonNull Command paramCommand, @NonNull String paramString, String[] paramArrayOfString) {
    {
      if (paramArrayOfString.length == 0) {
        if (paramCommandSender instanceof Player player1) {
          clearAllCooldowns(player1);
          player1.sendMessage(ChatColor.GREEN + "Your cooldowns have been cleared!");
          player1.setCooldown(Material.CROSSBOW, 1);
        } else {
          paramCommandSender.sendMessage(ChatColor.RED + "Only players can clear their own cooldowns.");
        } 
        return true;
      } 
    }Player player = Bukkit.getPlayer(paramArrayOfString[0]);
    {
      if (player != null && player.isOnline()) {
        clearAllCooldowns(player);
        player.setCooldown(Material.CROSSBOW, 1);
        paramCommandSender.sendMessage(ChatColor.GREEN + "Cooldowns cleared for " + player.getName() + "!");
      } else {
        paramCommandSender.sendMessage(ChatColor.RED + "Player '" + paramArrayOfString[0] + "' not found or not online.");
      } 
    }return true;
  }

  public static void clearAllCooldowns(Player paramPlayer) {
    {
      CooldownManager.clearExpiries(paramPlayer.getUniqueId());
      CrazySlotsListener.clearCrazySlots(paramPlayer);
      KnightfallListener.hookCharges.put(paramPlayer.getUniqueId(), 0);
      if (KnightfallListener.hookCooldownTasks.get(paramPlayer.getUniqueId()) != null)
        KnightfallListener.hookCooldownTasks.get(paramPlayer.getUniqueId()).cancel();
    }
    BossBarManager.activeBars.removeIf(paramBar3 -> removeAllCooldowns(paramPlayer, paramBar3));
  }

  public static boolean removeAllCooldowns(Player paramPlayer, BossBar paramBossBar) {
    paramBossBar.removePlayer(paramPlayer);
    return true;
  }


}
