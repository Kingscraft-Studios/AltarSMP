package net.kingscraft.zenixmc.altarsmp.altars2.ability.omen;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

class OmenVaultBoltTask extends BukkitRunnable {
  private final UUID casterId;
  private final World world;
  private final Location end;
  private final Vector direction;
  private final double totalDistance;
  private Location current;
  private double traveled;

  OmenVaultBoltTask(UUID casterId, Location start, Location end) {
    this.casterId = casterId;
    this.world = start.getWorld();
    this.end = end.clone();
    Vector difference = end.toVector().subtract(start.toVector());
    this.totalDistance = difference.length();
    this.direction = difference.clone().normalize();
    this.current = start.clone();
  }

  @Override
  public void run() {
    Player caster = Bukkit.getPlayer(casterId);
    if (caster == null || !caster.isOnline() || caster.isDead() || world == null) {
      cancel();
      return;
    }
    double step = Math.min(OmenAbility.BOLT_SPEED, totalDistance - traveled);
    Location next = current.clone().add(direction.clone().multiply(step));
    OmenParticles.copperTrail(world, current, next);
    current = next;
    traveled += step;
    if (traveled >= totalDistance) {
      OmenAbility.onVaultImpact(casterId, end);
      cancel();
    }
  }
}
