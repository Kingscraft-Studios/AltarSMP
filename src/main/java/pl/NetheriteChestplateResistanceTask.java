package pl;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class NetheriteChestplateResistanceTask extends BukkitRunnable {
  final NetheriteChestplateComboAbility ability;
  
  NetheriteChestplateResistanceTask(NetheriteChestplateComboAbility netheriteChestplateComboAbility) {
        this.ability = netheriteChestplateComboAbility;
    }
  
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      try {
        if (NetheriteChestplateComboAbility.hasCustomNetheriteChestplate(player))
          this.ability.applyResistance(player);
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f8.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */