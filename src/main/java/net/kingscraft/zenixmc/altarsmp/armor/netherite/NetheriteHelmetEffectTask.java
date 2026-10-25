package net.kingscraft.zenixmc.altarsmp.armor.netherite;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class NetheriteHelmetEffectTask extends BukkitRunnable {
  public final NetheriteHelmetAbilityListener helmetAbilityListener;

  public NetheriteHelmetEffectTask(NetheriteHelmetAbilityListener netheriteHelmetAbilityListener) {
        this.helmetAbilityListener = netheriteHelmetAbilityListener;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (NetheriteHelmetAbilityListener.isCustomNetheriteHelmet(player)) {
        this.helmetAbilityListener.applyStrength(player);
        this.helmetAbilityListener.applyWaterBreathing(player);
        this.helmetAbilityListener.handleSneakAbility(player);
      } 

    } 
  }

}
