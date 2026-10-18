package net.kingscraft.zenixmc.altarsmp.weapon.boneblade;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class BoneBladeSkeletalLeapSoundTask extends BukkitRunnable {
  public final Player player;

  public BoneBladeSkeletalLeapSoundTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_SKELETON_DEATH, 1.0F, 0.9F);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c2.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */