package net.kingscraft.zenixmc.altarsmp.weapon.holylance;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.scheduler.BukkitRunnable;

class HolyLanceDespawnTask extends BukkitRunnable {
  public final HolyLanceTask parent;

  public HolyLanceDespawnTask(HolyLanceTask parent) {
        this.parent = parent;
    }

  public void run() {
    this.parent.display.remove();
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e6.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */