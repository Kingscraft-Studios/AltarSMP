package pl;

import io.papermc.paper.world.MoonPhase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

class VampireSunAndMoonTask extends BukkitRunnable {
  private static final String VampireSunAndMoonTask = "§cThe blood moon is rising.";
  
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      try {
        if (player.getWorld().getMoonPhase() == MoonPhase.FULL_MOON)
          try {
            if (!VampireEventManager.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764k) {
              try {
                player.sendMessage(VampireSunAndMoonTask);
                if (VampireEventManager.isVampire(player))
                  player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 18000, 4)); 
              } catch (MatchException matchException) {
                throw a(null);
              } 
              VampireEventManager.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764k = true;
            } 
          } catch (MatchException matchException) {
            throw a(null);
          }  
      } catch (MatchException matchException) {
        throw a(null);
      } 
      try {
        if (VampireEventManager.isPale(player)) {
          try {
            if (player.getWorld().isClearWeather()) {
              player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 40, 0));
              continue;
            } 
          } catch (MatchException matchException) {
            throw a(null);
          } 
          player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 40, 0));
          continue;
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      try {
        if (VampireEventManager.isVampire(player)) {
          try {
            if (!player.getWorld().isDayTime()) {
              player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 0));
              player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 40, 0));
              player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 40, 0));
              continue;
            } 
          } catch (MatchException matchException) {
            throw a(null);
          } 
          try {
            if (player.getWorld().isDayTime())
              try {
                if (VampireEventManager.isExposedToSun(player))
                  player.setFireTicks(80); 
              } catch (MatchException matchException) {
                throw a(null);
              }  
          } catch (MatchException matchException) {
            throw a(null);
          } 
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gi.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */