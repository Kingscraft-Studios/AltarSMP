package net.kingscraft.zenixmc.altarsmp.armor.knightfall;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
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
    KnightfallListener.hookCharges.put(this.player.getUniqueId(), Integer.valueOf(((Integer) KnightfallListener.hookCharges.getOrDefault(this.player.getUniqueId(), Integer.valueOf(1))).intValue() - 1));
    int i = ((Integer) KnightfallListener.hookCharges.getOrDefault(this.player.getUniqueId(), Integer.valueOf(1))).intValue();
      KnightfallListener.showHookCharges(this.player);
      if (i > 0) {
        BossBarManager.createBar(this.player, HOOK_LABEL + i, this.cooldownSeconds, ChatColor.YELLOW);
        KnightfallListener.startHookCooldown(this.player, this.cooldownSeconds);
      }
  }
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fy.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */