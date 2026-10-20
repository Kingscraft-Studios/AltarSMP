package net.kingscraft.zenixmc.altarsmp.weapon.shadow;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class ShadowLeapCleanupTask extends BukkitRunnable {
  public final Player player;

  private static final String a = "shadowBladeBorderLogic";

  public ShadowLeapCleanupTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    if (ShadowBladeAbility.leapLocations.containsKey(this.player.getUniqueId())) {
      for (Player player : Bukkit.getOnlinePlayers()) {
        if (!player.equals(this.player))
          player.showPlayer((Plugin)AltarSMP.getInstance(), this.player);

      } 
      this.player.removePotionEffect(PotionEffectType.INVISIBILITY);
      if (AltarSMP.getInstance().getConfig().getBoolean(a, true))
        this.player.setWorldBorder(null);

    } 
  }


}
