package pl;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class BoneBladeSkeletalLeapSoundTask extends BukkitRunnable {
  final Player player;
  
  BoneBladeSkeletalLeapSoundTask(Player paramPlayer) {
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