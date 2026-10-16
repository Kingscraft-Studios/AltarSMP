package pl;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

class ShadowBladePassiveTask extends BukkitRunnable {
  ShadowBladePassiveTask(ShadowBladeAbility shadowBladeAbility) {}
  
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      try {
        if (ShadowBladeAbility.hasShadowBlade(player))
          player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1, true, true, true)); 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e8.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */