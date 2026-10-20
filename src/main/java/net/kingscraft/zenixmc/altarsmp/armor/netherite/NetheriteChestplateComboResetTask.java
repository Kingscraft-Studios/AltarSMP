package net.kingscraft.zenixmc.altarsmp.armor.netherite;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import java.util.UUID;
import org.bukkit.scheduler.BukkitRunnable;

class NetheriteChestplateComboResetTask extends BukkitRunnable {
  public final UUID playerId;

  public final NetheriteChestplateComboAbility ability;

  public NetheriteChestplateComboResetTask(NetheriteChestplateComboAbility netheriteChestplateComboAbility, UUID paramUUID) {
        this.ability = netheriteChestplateComboAbility;
        this.playerId = paramUUID;
    }

  public void run() {
    this.ability.activeComboPlayers.remove(this.playerId);
  }
}
