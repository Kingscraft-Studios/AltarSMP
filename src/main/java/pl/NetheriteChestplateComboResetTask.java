package pl;

import java.util.UUID;
import org.bukkit.scheduler.BukkitRunnable;

class NetheriteChestplateComboResetTask extends BukkitRunnable {
  final UUID playerId;
  
  final NetheriteChestplateComboAbility ability;
  
  NetheriteChestplateComboResetTask(NetheriteChestplateComboAbility netheriteChestplateComboAbility, UUID paramUUID) {
        this.ability = netheriteChestplateComboAbility;
        this.playerId = paramUUID;
    }
  
  public void run() {
    this.ability.activeComboPlayers.remove(this.playerId);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f9.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */