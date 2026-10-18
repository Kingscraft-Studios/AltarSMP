package net.kingscraft.zenixmc.altarsmp.legendary;

import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class LegendaryItemDuplicateReportTask extends BukkitRunnable {
  public final Player player;
  
  public final List duplicateOwners;
  
  private static final String OWNER_LABEL = " Owner:\n";
  
  public LegendaryItemDuplicateReportTask(FindLegendaryItemDuplicatesCommand findLegendaryItemDuplicatesCommand, Player paramPlayer, List paramList) {
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