package net.kingscraft.zenixmc.altarsmp.weapon.shadow;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

class ShadowBladePassiveTask extends BukkitRunnable {

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (ShadowBladeAbility.hasShadowBlade(player))
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1, true, true, true)); 

    } 
  }

}
