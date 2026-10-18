package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

class EarthShatterRisingBlockRemovalTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public EarthShatterRisingBlockRemovalTask(ItemDisplay paramItemDisplay) {
        this.itemDisplay = paramItemDisplay;
    }

  public void run() {
    this.itemDisplay.remove();
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ek.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */