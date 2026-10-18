package net.kingscraft.zenixmc.altarsmp.armor.copper;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class CopperChestplateLightningTask extends BukkitRunnable {
  public final Location stormCenter;

  public final int lightningRadius;

  private static final String lightningFine = "lightningFine";

  public CopperChestplateLightningTask(CopperChestplateEventManager copperChestplateEventManager, Location paramLocation, int paramInt) {
        this.stormCenter = paramLocation;
        this.lightningRadius = paramInt;
    }

  public void run() {
    boolean bool = AltarSMP.getInstance().getConfig().getBoolean(lightningFine, true);
    for (Player player : this.stormCenter.getNearbyPlayers(this.lightningRadius, this.lightningRadius, this.lightningRadius)) {
      if (bool) {
        cancel();
        return;
      } 

      player.getLocation().getWorld().strikeLightning(player.getLocation());
    } 
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ge.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */