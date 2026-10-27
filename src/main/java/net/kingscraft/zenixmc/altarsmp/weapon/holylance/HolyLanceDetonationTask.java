package net.kingscraft.zenixmc.altarsmp.weapon.holylance;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.weapon.scorching.ScorchingBladeAbility;

public class HolyLanceDetonationTask extends BukkitRunnable {
  public final Location location;

  public final Player player;

  public final double radius;

  public HolyLanceDetonationTask(Location paramLocation, Player paramPlayer, double paramDouble) {
        this.location = paramLocation;
        this.player = paramPlayer;
        this.radius = paramDouble;
    }

  public void run() {
    ScorchingBladeAbility.detonateHolyLance(this.location, this.player);
    ScorchingBladeAbility.spawnHolyLanceVisual(this.location, this.radius);
    this.player.getWorld().playSound(this.player.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, 1.0F, 1.0F);
    this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
  }
}
