package net.kingscraft.zenixmc.altarsmp.altar;

import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class AltarReloadTask extends BukkitRunnable {
  public final AltarSMP plugin;
  
  public AltarReloadTask(AltarSMP paramAltarSMP) {
        this.plugin = paramAltarSMP;
    }
  
  public void run() {
    this.plugin.altarController.loadAltars();
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764co.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */