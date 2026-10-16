package pl;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.scheduler.BukkitRunnable;

class FrostScytheInventoryUpdateTask extends BukkitRunnable {
  final PlayerItemConsumeEvent consumeEvent ;
  
  FrostScytheInventoryUpdateTask(FrostScytheAbilityListener frostScytheAbilityListener, PlayerItemConsumeEvent paramPlayerItemConsumeEvent) {
        this.consumeEvent = paramPlayerItemConsumeEvent;
    }
  
  public void run() {
    this.consumeEvent.getPlayer().updateInventory();
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c9.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */