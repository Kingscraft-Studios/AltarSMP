package net.kingscraft.zenixmc.altarsmp.weapon.frostscythe;

import java.util.List;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class FrostScytheBladeChargingTask extends BukkitRunnable {
  public int ticksElapsed;

  public final List<ItemDisplay> bladeDisplays;

  public final Player player;

  public FrostScytheBladeChargingTask(List<ItemDisplay> paramList, Player paramPlayer) {
        this.bladeDisplays = paramList;
        this.player = paramPlayer;
        this.ticksElapsed = 0;
    }

  public void run() {
    if (this.ticksElapsed >= 23) {
      FrostScytheAbilityListener.scheduleIceBladeLaunches(this.bladeDisplays, this.player);
      cancel();
      return;
    }

      for (ItemDisplay itemDisplay : this.bladeDisplays) {
          itemDisplay.setTeleportDuration(2);
          itemDisplay.setRotation(this.player.getYaw(), 0.0F);
      }
    this.player.getWorld().spawnParticle(Particle.TRIAL_SPAWNER_DETECTION_OMINOUS, this.player.getEyeLocation(), 2, 0.2D, 0.2D, 0.2D, 0.0D);
    if (this.ticksElapsed % 10 == 0)
      this.player.getWorld().playSound(this.player.getLocation(), Sound.BLOCK_GLASS_HIT, 0.5F, 1.0F + this.ticksElapsed / 23.0F);

    this.ticksElapsed++;
  }

}
