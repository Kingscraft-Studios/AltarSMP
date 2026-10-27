package net.kingscraft.zenixmc.altarsmp.altarS2.weapon.omen;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

final class OmenParticles {
  private OmenParticles() {
  }

  static void vaultImpact(World world, Location center) {
    world.spawnParticle(Particle.COPPER_FIRE_FLAME, center, 90, 0.42, 0.3, 0.42, 0.26);
    world.spawnParticle(Particle.COPPER_FIRE_FLAME, center.clone().add(0.0, 0.16, 0.0), 45, 0.62, 0.38, 0.62, 0.312);
    world.spawnParticle(Particle.TRIAL_SPAWNER_DETECTION, center.clone().add(0.0, 0.12, 0.0), 32, 0.5, 0.18, 0.5, 0.02);
    world.spawnParticle(Particle.ELECTRIC_SPARK, center, 24, 0.35, 0.24, 0.35, 0.08);
    new BukkitRunnable() {
      private int tick;

      @Override
      public void run() {
        spawnImpactRing(world, center, tick);
        tick++;
        if (tick >= 3) {
          cancel();
        }
      }
    }.runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  private static void spawnImpactRing(World world, Location center, int tick) {
    world.spawnParticle(Particle.COPPER_FIRE_FLAME, center, 18, 0.18, 0.12, 0.18, 0.01);
    double ringRadius = 3.0;
    Location top = center.clone().add(0.0, 1.5 + 0.12 + tick * 0.08, 0.0);
    Location[] points = new Location[3];
    for (int i = 0; i < 3; i++) {
      double angle = (-Math.PI / 2.0) + i * Math.PI * 2.0 / 3.0;
      points[i] = top.clone().add(Math.cos(angle) * ringRadius, 0.0, Math.sin(angle) * ringRadius);
    }
    for (int i = 0; i < 3; i++) {
      copperLine(world, points[i], points[(i + 1) % 3]);
    }
  }

  private static void copperLine(World world, Location from, Location to) {
    Vector difference = to.toVector().subtract(from.toVector());
    double length = difference.length();
    if (length <= 0.01) {
      return;
    }
    Vector step = difference.clone().normalize().multiply(0.08);
    Location location = from.clone();
    for (double traveled = 0.0; traveled <= length; traveled += 0.08) {
      world.spawnParticle(Particle.COPPER_FIRE_FLAME, location, 4, 0.02, 0.02, 0.02, 0.0);
      location.add(step);
    }
  }

  static void copperTrail(World world, Location from, Location to) {
    Vector difference = to.toVector().subtract(from.toVector());
    double length = difference.length();
    if (length <= 0.01) {
      return;
    }
    Vector step = difference.clone().normalize().multiply(0.08);
    Location location = from.clone();
    for (double traveled = 0.0; traveled <= length; traveled += 0.08) {
      world.spawnParticle(Particle.COPPER_FIRE_FLAME, location, 8, 0.04, 0.04, 0.04, 0.0);
      location.add(step);
    }
  }

  static void soulTrail(World world, Location from, Location to) {
    Vector difference = to.toVector().subtract(from.toVector());
    double length = difference.length();
    if (length <= 0.01) {
      return;
    }
    Vector step = difference.clone().normalize().multiply(0.14);
    Location location = from.clone();
    for (double traveled = 0.0; traveled <= length; traveled += 0.14) {
      world.spawnParticle(Particle.SOUL_FIRE_FLAME, location, 2, 0.03, 0.03, 0.03, 0.0);
      location.add(step);
    }
  }

  static void zoneRing(World world, Location center, double radius, int tick) {
    double rotation = tick * 0.045;
    for (int i = 0; i < 48; i++) {
      double angle = Math.PI * 2.0 * i / 48.0 + rotation;
      double x = Math.cos(angle) * radius;
      double z = Math.sin(angle) * radius;
      for (int layer = 0; layer < 3; layer++) {
        Location location = center.clone().add(x, 0.15 + layer * 0.3, z);
        world.spawnParticle(Particle.TRIAL_SPAWNER_DETECTION, location, 1, 0.025, 0.025, 0.025, 0.0);
      }
    }
  }

  static void zoneCollapse(World world, Location center, double radius) {
    for (int i = 0; i < 64; i++) {
      double angle = Math.PI * 2.0 * i / 64.0;
      Location location = center.clone().add(Math.cos(angle) * radius, 0.08, Math.sin(angle) * radius);
      Vector inward = center.toVector().subtract(location.toVector());
      inward.setY(0.0);
      if (inward.lengthSquared() > 0.001) {
        inward.normalize().multiply(0.18);
        world.spawnParticle(Particle.COPPER_FIRE_FLAME, location, 0, inward.getX(), 0.0, inward.getZ(), 1.0);
      }
    }
  }

  static void tetherVisual(World world, Location center, Player target, double radius, int tick) {
    zoneRing(world, center, radius, tick);
    double offsetY = 0.32;
    Location from = center.clone().add(0.0, offsetY, 0.0);
    Location to = target.getLocation().clone().add(0.0, offsetY, 0.0);
    Vector difference = to.toVector().subtract(from.toVector());
    double length = difference.length();
    if (length <= 0.12) {
      return;
    }
    Vector step = difference.clone().normalize().multiply(0.22);
    Location location = from.clone();
    for (double traveled = 0.0; traveled <= length; traveled += 0.22) {
      world.spawnParticle(Particle.COPPER_FIRE_FLAME, location, 1, 0.0, 0.0, 0.0, 0.0);
      location.add(step);
    }
  }

  static void casterRing(World world, Player player) {
    Location center = player.getLocation().add(0.0, 0.95, 0.0);
    for (int i = 0; i < 72; i++) {
      double angle = Math.PI * 2.0 * i / 72.0;
      Vector direction = new Vector(Math.cos(angle), 0.0, Math.sin(angle));
      world.spawnParticle(Particle.SOUL_FIRE_FLAME, center, 0, direction.getX() * 1.15, 0.015, direction.getZ() * 1.15, 1.0);
    }
  }

  static void ambientEndRod(World world, Location center) {
    for (int i = 0; i < 200; i++) {
      double angle = Math.random() * Math.PI * 2.0;
      double distance = Math.random() * 20.0;
      double x = Math.cos(angle) * distance;
      double z = Math.sin(angle) * distance;
      double y = Math.random() * 20.0;
      world.spawnParticle(Particle.END_ROD, center.clone().add(x, y, z), 1, 0.0, 0.0, 0.0, 0.0);
    }
  }
}
