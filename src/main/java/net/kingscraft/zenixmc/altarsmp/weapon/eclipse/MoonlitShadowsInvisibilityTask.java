package net.kingscraft.zenixmc.altarsmp.weapon.eclipse;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class MoonlitShadowsInvisibilityTask extends BukkitRunnable {
  public int ticksElapsed;

  public final int durationSeconds;

  public final Player player;

  private static final String INVISIBLE_ACTION_BAR = "[INVISIBLE]";

  public MoonlitShadowsInvisibilityTask(int paramInt, Player paramPlayer) {
        this.durationSeconds = paramInt;
        this.player = paramPlayer;
        this.ticksElapsed = 0;
    }

  public void run() {
    if (this.ticksElapsed >= this.durationSeconds * 20) {
      for (Player player : Bukkit.getOnlinePlayers())
        player.showPlayer(AltarSMP.getInstance(), this.player);
      this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 0.5F);
      this.player.getWorld().spawnParticle(Particle.SQUID_INK, this.player.getLocation(), 20, 0.0D, 0.0D, 0.0D, 0.0D);
      cancel();
      return;
    }
    this.player.sendActionBar(Component.text(INVISIBLE_ACTION_BAR, NamedTextColor.RED, TextDecoration.BOLD));
    this.ticksElapsed++;
  }

}
