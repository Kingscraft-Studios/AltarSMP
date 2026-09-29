package pl;

import io.papermc.paper.world.MoonPhase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gi extends BukkitRunnable {
  private static final String a = "§cThe blood moon is rising.";
  
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      try {
        if (player.getWorld().getMoonPhase() == MoonPhase.FULL_MOON)
          try {
            if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764k) {
              try {
                player.sendMessage(a);
                if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c__v0(player))
                  player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 18000, 4)); 
              } catch (MatchException matchException) {
                throw a(null);
              } 
              You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764k = true;
            } 
          } catch (MatchException matchException) {
            throw a(null);
          }  
      } catch (MatchException matchException) {
        throw a(null);
      } 
      try {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(player)) {
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
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c__v0(player)) {
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
                if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(player))
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