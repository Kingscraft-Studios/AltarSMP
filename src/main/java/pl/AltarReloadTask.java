package pl;

import org.bukkit.scheduler.BukkitRunnable;

class AltarReloadTask extends BukkitRunnable {
  final Main plugin;
  
  AltarReloadTask(Main paramMain) {
        this.plugin = paramMain;
    }
  
  public void run() {
    this.plugin.altarController.loadAltars();
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764co.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */