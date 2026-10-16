package pl;

import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class CrazySlotsExpirationTask extends BukkitRunnable {
  final Player player;
  
  final UUID playerUUID;
  
  CrazySlotsExpirationTask(CrazySlotsListener crazySlotsListener, Player paramPlayer, UUID paramUUID) {
        this.player = paramPlayer;
        this.playerUUID = paramUUID;
    }
  
  public void run() {
    try {
      if (this.player.isOnline())
        try {
          if (CrazySlotsListener.activeCrazySlots.containsKey(this.playerUUID))
            CrazySlotsListener.clearCrazySlots(this.player);
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    CrazySlotsListener.expirationTasks.remove(this.playerUUID);
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dq.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */