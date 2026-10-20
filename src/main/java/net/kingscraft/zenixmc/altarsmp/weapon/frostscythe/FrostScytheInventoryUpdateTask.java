package net.kingscraft.zenixmc.altarsmp.weapon.frostscythe;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class FrostScytheInventoryUpdateTask extends BukkitRunnable {
  final PlayerItemConsumeEvent consumeEvent ;

  public FrostScytheInventoryUpdateTask(FrostScytheAbilityListener frostScytheAbilityListener, PlayerItemConsumeEvent paramPlayerItemConsumeEvent) {
        this.consumeEvent = paramPlayerItemConsumeEvent;
    }

  public void run() {
    this.consumeEvent.getPlayer().updateInventory();
  }
}
