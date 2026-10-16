package pl;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class NetheriteHelmetEffectTask extends BukkitRunnable {
  final NetheriteHelmetAbilityListener helmetAbilityListener;
  
  NetheriteHelmetEffectTask(NetheriteHelmetAbilityListener netheriteHelmetAbilityListener) {
        this.helmetAbilityListener = netheriteHelmetAbilityListener;
    }
  
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      try {
        if (NetheriteHelmetAbilityListener.isCustomNetheriteHelmet(player)) {
          this.helmetAbilityListener.applyStrength(player);
          this.helmetAbilityListener.applyWaterBreathing(player);
          this.helmetAbilityListener.handleSneakAbility(player);
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ga.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */