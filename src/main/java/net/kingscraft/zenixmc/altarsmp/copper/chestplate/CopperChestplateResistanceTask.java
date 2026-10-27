package net.kingscraft.zenixmc.altarsmp.copper.chestplate;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class CopperChestplateResistanceTask extends BukkitRunnable {
  public final CopperChestplateComboAbility ability;

  public CopperChestplateResistanceTask(CopperChestplateComboAbility copperChestplateComboAbility) {
        this.ability = copperChestplateComboAbility;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (CopperChestplateComboAbility.hasCustomNetheriteChestplate(player))
        this.ability.applyResistance(player);

    } 
  }

}
