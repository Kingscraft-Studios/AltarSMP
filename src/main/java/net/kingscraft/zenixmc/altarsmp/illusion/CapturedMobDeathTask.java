package net.kingscraft.zenixmc.altarsmp.illusion;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CapturedMobDeathTask extends BukkitRunnable {
  public final Player player;

  public CapturedMobDeathTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    this.player.setHealth(0.0D);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764di.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */