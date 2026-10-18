package net.kingscraft.zenixmc.altarsmp.illusion;

import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class DisguiseWorldChangeTask extends BukkitRunnable {
  public final PlayerChangedWorldEvent event;
  
  public DisguiseWorldChangeTask(IllusionDisguiseManager illusionDisguiseManager, PlayerChangedWorldEvent paramPlayerChangedWorldEvent) {
        this.event = paramPlayerChangedWorldEvent;
    }
  
  public void run() {
    IllusionDisguiseManager.revealPlayer(this.event.getPlayer());
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gu.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */