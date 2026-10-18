package net.kingscraft.zenixmc.altarsmp.illusion;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class DisguiseFollowTask extends BukkitRunnable {
  public final Player player;

  public final Entity targetEntity;

  public DisguiseFollowTask(Player paramPlayer, Entity paramEntity) {
        this.player = paramPlayer;
        this.targetEntity = paramEntity;
    }

  public void run() {
    if (this.player.isOnline())
      {
        if (!this.targetEntity.isDead())
          {
            if (!this.player.isDead()) {
              this.player.setCooldown(Material.NETHERITE_SWORD, 100);
              this.targetEntity.teleport((Entity)this.player);
              return;
            } 
          }  
      }  

    IllusionDisguiseManager.revealPlayer(this.player);
    cancel();
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gt.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */