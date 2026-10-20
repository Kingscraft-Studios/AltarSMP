package net.kingscraft.zenixmc.altarsmp.illusion;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class InventoryUpdateTask extends BukkitRunnable {
  public final Player player;

  public InventoryUpdateTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    this.player.updateInventory();
  }
}
