package net.kingscraft.zenixmc.altarsmp.copper.boots;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class CopperBootsEffectRefreshTask extends BukkitRunnable {
  public final CopperBootsSpeedAbility ability;

  public CopperBootsEffectRefreshTask(CopperBootsSpeedAbility copperBootsSpeedAbility) {
        this.ability = copperBootsSpeedAbility;
    }

  public void run() {
    for (Player player : this.ability.copperBootsPlayers) {
      if (player != null) {
        if (!player.isOnline())
          continue; 

        this.ability.updatePlayerEffects(player, false);
      } 
    } 
  }

}
