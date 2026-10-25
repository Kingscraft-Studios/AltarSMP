package net.kingscraft.zenixmc.altarsmp.altars2.ability.omen;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

class OmenConjuringProjectileTask extends BukkitRunnable {
  private final UUID casterId;
  private final Vector step;
  private final double range;
  private final int level;
  private Location current;
  private double traveled;

  OmenConjuringProjectileTask(UUID casterId, Location origin, Vector direction, double range, int level) {
    this.casterId = casterId;
    this.step = direction.clone().normalize().multiply(OmenAbility.PROJECTILE_SPEED);
    this.range = range;
    this.level = level;
    this.current = origin.clone();
  }

  @Override
  public void run() {
    Player caster = Bukkit.getPlayer(casterId);
    if (caster == null || !caster.isOnline() || caster.isDead()) {
      cancel();
      return;
    }
    World world = current.getWorld();
    if (world == null) {
      cancel();
      return;
    }
    Location from = current.clone();
    Location to = current.clone().add(step);
    LivingEntity directHit = OmenAbility.traceEntities(world, caster, from, to);
    Location hitCenter = directHit == null ? null : directHit.getLocation().add(0.0, directHit.getHeight() * 0.55, 0.0);
    Location blockHit = null;
    if (hitCenter == null) {
      blockHit = OmenAbility.traceBlocks(from, to);
    } else {
      Location candidate = OmenAbility.traceBlocks(from, to);
      if (candidate != null && candidate.distanceSquared(from) < hitCenter.distanceSquared(from)) {
        blockHit = candidate;
        directHit = null;
        hitCenter = null;
      }
    }
    Location resolved = hitCenter != null ? hitCenter : blockHit;
    Location destination = resolved != null ? resolved : to;
    OmenParticles.soulTrail(world, from, destination);
    current = destination;
    traveled += from.distance(destination);
    if (resolved != null || traveled >= range) {
      OmenAbility.onConjuringImpact(resolved != null ? resolved : current.clone(), caster, directHit, level);
      cancel();
    }
  }
}
