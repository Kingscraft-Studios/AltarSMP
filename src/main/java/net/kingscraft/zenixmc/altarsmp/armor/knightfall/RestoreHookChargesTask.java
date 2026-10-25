package net.kingscraft.zenixmc.altarsmp.armor.knightfall;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;

public class RestoreHookChargesTask extends BukkitRunnable {
  public final Player player;

  public final int cooldownSeconds;

  private static final String HOOK_LABEL = "Grappling Hook §6§lx";

  public RestoreHookChargesTask(Player paramPlayer, int paramInt) {
        this.player = paramPlayer;
        this.cooldownSeconds = paramInt;
    }

  public void run() {
    KnightfallListener.hookCharges.put(this.player.getUniqueId(), KnightfallListener.hookCharges.getOrDefault(this.player.getUniqueId(), 1) - 1);
    int i = KnightfallListener.hookCharges.getOrDefault(this.player.getUniqueId(), 1);
      KnightfallListener.showHookCharges(this.player);
      if (i > 0) {
        BossBarManager.createBar(this.player, HOOK_LABEL + i, this.cooldownSeconds, ChatColor.YELLOW);
        KnightfallListener.startHookCooldown(this.player, this.cooldownSeconds);
      }
  }
}
