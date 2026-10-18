package net.kingscraft.zenixmc.altarsmp.weapon.holylance;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dr.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */