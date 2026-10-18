package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

public class EarthShatterDisplayDescendTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public final int descentHeight;

  public EarthShatterDisplayDescendTask(ItemDisplay paramItemDisplay, int paramInt) {
        this.itemDisplay = paramItemDisplay;
        this.descentHeight = paramInt;
    }

  public void run() {
    this.itemDisplay.teleport(this.itemDisplay.getLocation().subtract(0.0D, this.descentHeight, 0.0D));
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ef.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */