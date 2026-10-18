package net.kingscraft.zenixmc.altarsmp.task;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.illusion.IllusionWandAbility;

public class InventoryUpdateTask extends BukkitRunnable {
  public final Player player;
  
  public InventoryUpdateTask(IllusionWandAbility illusionWandAbility, Player paramPlayer) {
        this.player = paramPlayer;
    }
  
  public void run() {
    this.player.updateInventory();
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dk.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */