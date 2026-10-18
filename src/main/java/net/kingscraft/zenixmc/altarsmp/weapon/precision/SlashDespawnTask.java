package net.kingscraft.zenixmc.altarsmp.weapon.precision;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

public class SlashDespawnTask extends BukkitRunnable {
  public final ItemDisplay display;

  public SlashDespawnTask(ItemDisplay paramItemDisplay) {
        this.display = paramItemDisplay;
    }

  public void run() {
    this.display.remove();
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e3.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */