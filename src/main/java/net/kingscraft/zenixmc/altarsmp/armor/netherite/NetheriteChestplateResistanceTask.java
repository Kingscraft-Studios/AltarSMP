package net.kingscraft.zenixmc.altarsmp.armor.netherite;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class NetheriteChestplateResistanceTask extends BukkitRunnable {
  public final NetheriteChestplateComboAbility ability;

  public NetheriteChestplateResistanceTask(NetheriteChestplateComboAbility netheriteChestplateComboAbility) {
        this.ability = netheriteChestplateComboAbility;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (NetheriteChestplateComboAbility.hasCustomNetheriteChestplate(player))
        this.ability.applyResistance(player);

    } 
  }

}
