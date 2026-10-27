package net.kingscraft.zenixmc.altarsmp.copper.helmet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class CopperHelmetEffectTask extends BukkitRunnable {
  public final CopperHelmetAbilityListener helmetAbilityListener;

  public CopperHelmetEffectTask(CopperHelmetAbilityListener copperHelmetAbilityListener) {
        this.helmetAbilityListener = copperHelmetAbilityListener;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (CopperHelmetAbilityListener.isCustomNetheriteHelmet(player)) {
        this.helmetAbilityListener.applyStrength(player);
        this.helmetAbilityListener.applyWaterBreathing(player);
        this.helmetAbilityListener.handleSneakAbility(player);
      } 

    } 
  }

}
