package net.kingscraft.zenixmc.altarsmp.weapon.vulcan;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class VulcanChargedCrossbowCleanupTask extends BukkitRunnable {
  public final Player player;

  public final VulcanGauntletAbility ability;

  public VulcanChargedCrossbowCleanupTask(VulcanGauntletAbility vulcanGauntletAbility, Player paramPlayer) {
        this.ability = vulcanGauntletAbility;
        this.player = paramPlayer;
    }

  public void run() {
    this.ability.chargedCrossbowUsers.remove(this.player);
  }
}
