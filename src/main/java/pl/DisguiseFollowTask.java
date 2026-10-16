package pl;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class DisguiseFollowTask extends BukkitRunnable {
  final Player player;
  
  final Entity targetEntity;
  
  DisguiseFollowTask(Player paramPlayer, Entity paramEntity) {
        this.player = paramPlayer;
        this.targetEntity = paramEntity;
    }
  
  public void run() {
    try {
      if (this.player.isOnline())
        try {
          if (!this.targetEntity.isDead())
            try {
              if (!this.player.isDead()) {
                this.player.setCooldown(Material.NETHERITE_SWORD, 100);
                this.targetEntity.teleport((Entity)this.player);
                return;
              } 
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    IllusionDisguiseManager.revealPlayer(this.player);
    cancel();
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gt.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */