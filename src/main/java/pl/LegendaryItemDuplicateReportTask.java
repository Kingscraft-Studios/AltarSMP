package pl;

import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class LegendaryItemDuplicateReportTask extends BukkitRunnable {
  final Player player;
  
  final List duplicateOwners;
  
  private static final String OWNER_LABEL = " Owner:\n";
  
  LegendaryItemDuplicateReportTask(FindLegendaryItemDuplicatesCommand findLegendaryItemDuplicatesCommand, Player paramPlayer, List paramList) {
        this.player = paramPlayer;
        this.duplicateOwners = paramList;
    }
  
  public void run() {
    this.player.sendMessage(this.player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + OWNER_LABEL + String.valueOf(this.duplicateOwners));
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cn.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */