package net.kingscraft.zenixmc.altarsmp.armor.knightfall;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class CloakEndTask extends BukkitRunnable {
  public int ticks;

  public final int durationSeconds;

  public final Player player;

  private static final String INVISIBLE_LABEL = "[ INVISIBLE ]";

  public CloakEndTask(int paramInt, Player paramPlayer) {
        this.durationSeconds = paramInt;
        this.player = paramPlayer;
        this.ticks = 0;
    }

  public void run() {
    if (this.ticks >= this.durationSeconds * 20) {
      for (Player player : Bukkit.getOnlinePlayers())
        player.showPlayer((Plugin)AltarSMP.getInstance(), this.player);
      this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 0.5F);
      this.player.getWorld().spawnParticle(Particle.SQUID_INK, this.player.getLocation(), 20, 0.0D, 0.0D, 0.0D, 0.0D);
      cancel();
      return;
    } 
    this.player.sendActionBar(ChatColor.RED.toString() + String.valueOf(ChatColor.BOLD) + INVISIBLE_LABEL);
    this.ticks++;
  }
}
