package net.kingscraft.zenixmc.altarsmp.legendary;

import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class LegendaryItemDuplicateReportTask extends BukkitRunnable {
  public final Player player;

  public final List<String> duplicateOwners;

  private static final String OWNER_LABEL = " Owner:\n";

  public LegendaryItemDuplicateReportTask(Player paramPlayer, List<String> paramList) {
        this.player = paramPlayer;
        this.duplicateOwners = paramList;
    }

  public void run() {
    this.player.sendMessage(this.player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + OWNER_LABEL + this.duplicateOwners);
  }

}
