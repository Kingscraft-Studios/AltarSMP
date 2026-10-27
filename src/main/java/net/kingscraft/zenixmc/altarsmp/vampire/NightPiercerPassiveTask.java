package net.kingscraft.zenixmc.altarsmp.vampire;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class NightPiercerPassiveTask extends BukkitRunnable {
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (VampireListener.isHoldingNightPiercer(player)) {
        long l = player.getWorld().getTime();
        boolean flag = l >= 13000L && l <= 23000L;
        if (flag) {
          player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0, true, false));
        } 
      } 
    } 
  }
}
