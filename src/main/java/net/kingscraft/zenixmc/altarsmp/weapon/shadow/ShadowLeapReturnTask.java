package net.kingscraft.zenixmc.altarsmp.weapon.shadow;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class ShadowLeapReturnTask extends BukkitRunnable {
  public final Player player;

  public final Location targetLocation;

  public ShadowLeapReturnTask(ShadowBladeAbility shadowBladeAbility, Player paramPlayer, Location paramLocation) {
        this.player = paramPlayer;
        this.targetLocation = paramLocation;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (!player.equals(this.player))
        player.showPlayer((Plugin)AltarSMP.getInstance(), this.player);

    } 
    this.player.removePotionEffect(PotionEffectType.INVISIBILITY);
    this.player.teleport(this.targetLocation);
  }

}
