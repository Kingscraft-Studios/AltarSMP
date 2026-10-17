package pl;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class CopperChestplateLightningTask extends BukkitRunnable {
  final Location stormCenter;
  
  final int lightningRadius;
  
  private static final String lightningFine = "lightningFine";
  
  CopperChestplateLightningTask(CopperChestplateEventManager copperChestplateEventManager, Location paramLocation, int paramInt) {
        this.stormCenter = paramLocation;
        this.lightningRadius = paramInt;
    }
  
  public void run() {
    boolean bool = Main.getInstance().getConfig().getBoolean(lightningFine, true);
    for (Player player : this.stormCenter.getNearbyPlayers(this.lightningRadius, this.lightningRadius, this.lightningRadius)) {
      try {
        if (bool) {
          cancel();
          return;
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      player.getLocation().getWorld().strikeLightning(player.getLocation());
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ge.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */