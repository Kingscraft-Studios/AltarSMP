package pl;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class BoneBladeSkeletalLeapImpactSoundTask extends BukkitRunnable {
  final Player player;
  
  BoneBladeSkeletalLeapImpactSoundTask(Player paramPlayer) {
        this.player = paramPlayer;
    }
  
  public void run() {
    this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_SKELETON_DEATH, 1.0F, 1.0F);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c3.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */