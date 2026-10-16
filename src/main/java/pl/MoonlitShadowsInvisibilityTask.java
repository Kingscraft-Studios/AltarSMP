package pl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

class MoonlitShadowsInvisibilityTask extends BukkitRunnable {
  int ticksElapsed;

  final int durationSeconds;

  final Player player;

  private static final String INVISIBLE_ACTION_BAR = "[INVISIBLE]";

  MoonlitShadowsInvisibilityTask(int paramInt, Player paramPlayer) {
        this.durationSeconds = paramInt;
        this.player = paramPlayer;
        this.ticksElapsed = 0;
    }

  public void run() {
    if (this.ticksElapsed >= this.durationSeconds * 20) {
      for (Player player : Bukkit.getOnlinePlayers())
        player.showPlayer((Plugin)Main.getInstance(), this.player);
      this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 0.5F);
      this.player.getWorld().spawnParticle(Particle.SQUID_INK, this.player.getLocation(), 20, 0.0D, 0.0D, 0.0D, 0.0D);
      cancel();
      return;
    }
    this.player.sendActionBar(ChatColor.RED.toString() + String.valueOf(ChatColor.BOLD) + INVISIBLE_ACTION_BAR);
    this.ticksElapsed++;
  }

}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fr.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */