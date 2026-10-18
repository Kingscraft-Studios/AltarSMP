package net.kingscraft.zenixmc.altarsmp.armor.netherite;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f8.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */