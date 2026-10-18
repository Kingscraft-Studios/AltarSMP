package net.kingscraft.zenixmc.altarsmp.vampire;

import io.papermc.paper.world.MoonPhase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class VampireSunAndMoonTask extends BukkitRunnable {
  private static final String VampireSunAndMoonTask = "§cThe blood moon is rising.";

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (player.getWorld().getMoonPhase() == MoonPhase.FULL_MOON)
        {
          if (!VampireEventManager.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764k) {
            player.sendMessage(VampireSunAndMoonTask);
            if (VampireEventManager.isVampire(player))
              player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 18000, 4)); 

            VampireEventManager.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764k = true;
          } 
        }  

      if (VampireEventManager.isPale(player)) {
        if (player.getWorld().isClearWeather()) {
          player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 40, 0));
          continue;
        } 

        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 40, 0));
        continue;
      } 

      if (VampireEventManager.isVampire(player)) {
        if (!player.getWorld().isDayTime()) {
          player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 0));
          player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 40, 0));
          player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 40, 0));
          continue;
        } 

        if (player.getWorld().isDayTime())
          {
            if (VampireEventManager.isExposedToSun(player))
              player.setFireTicks(80); 
          }  

      } 

    } 
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gi.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */