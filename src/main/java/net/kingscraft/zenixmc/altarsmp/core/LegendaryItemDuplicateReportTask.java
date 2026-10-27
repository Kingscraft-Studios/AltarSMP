package net.kingscraft.zenixmc.altarsmp.core;

import java.util.List;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LegendaryItemDuplicateReportTask extends BukkitRunnable {
  public final Player player;

  public final List<String> duplicateOwners;

  private static final String OWNER_LABEL = " Owner:\n";

  public LegendaryItemDuplicateReportTask(Player paramPlayer, List<String> paramList) {
        this.player = paramPlayer;
        this.duplicateOwners = paramList;
    }

  public void run() {
      this.player.sendMessage(this.player.getInventory().getItemInMainHand().getItemMeta().displayName().append(Component.text(OWNER_LABEL + this.duplicateOwners)));
  }

}
