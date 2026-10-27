package net.kingscraft.zenixmc.altarsmp.weapon.boneblade;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class BoneBladeSkeletalLeapImpactSoundTask extends BukkitRunnable {
  public final Player player;

  public BoneBladeSkeletalLeapImpactSoundTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_SKELETON_DEATH, 1.0F, 1.0F);
  }
}
