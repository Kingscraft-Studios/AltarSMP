package net.kingscraft.zenixmc.altarsmp.weapon.shade;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

class ShadeOrbCleanupTask extends BukkitRunnable {
  public final ShadeOrbInterpolateTask parent;

  public ShadeOrbCleanupTask(ShadeOrbInterpolateTask parent) {
        this.parent = parent;
    }

  public void run() {
    for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.parent.orbs)
      itemDisplay.remove(); 
    this.parent.orbs.clear();
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ez.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */