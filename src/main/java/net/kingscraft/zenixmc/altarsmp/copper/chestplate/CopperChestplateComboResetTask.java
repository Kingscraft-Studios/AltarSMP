package net.kingscraft.zenixmc.altarsmp.copper.chestplate;

import java.util.UUID;
import org.bukkit.scheduler.BukkitRunnable;

class CopperChestplateComboResetTask extends BukkitRunnable {
  public final UUID playerId;

  public final CopperChestplateComboAbility ability;

  public CopperChestplateComboResetTask(CopperChestplateComboAbility copperChestplateComboAbility, UUID paramUUID) {
        this.ability = copperChestplateComboAbility;
        this.playerId = paramUUID;
    }

  public void run() {
    this.ability.activeComboPlayers.remove(this.playerId);
  }
}
