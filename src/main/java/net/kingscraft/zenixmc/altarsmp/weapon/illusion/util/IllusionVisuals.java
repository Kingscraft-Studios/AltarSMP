package net.kingscraft.zenixmc.altarsmp.weapon.illusion.util;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public final class IllusionVisuals {

  private IllusionVisuals() {
  }

  public static void sound(Location location, Sound sound, float volume, float pitch) {
    if (location.getWorld() != null) {
      location.getWorld().playSound(location, sound, volume, pitch);
    }
  }

  public static void burst(Location location, Particle particle, int count, double spread) {
    World world = location.getWorld();
    if (world == null) {
      return;
    }
    world.spawnParticle(particle, location, count, spread, spread, spread, 0.02D);
  }

  public static void burstDirectional(Location location, Particle particle, int count, double spread, double speed) {
    World world = location.getWorld();
    if (world == null) {
      return;
    }
    world.spawnParticle(particle, location, count, spread, spread, spread, speed);
  }

  public static void ring(Location center, Particle particle, int points, double radius) {
    World world = center.getWorld();
    if (world == null) {
      return;
    }
    for (int i = 0; i < points; i++) {
      double angle = (Math.PI * 2.0D / points) * i;
      double x = Math.cos(angle) * radius;
      double z = Math.sin(angle) * radius;
      world.spawnParticle(particle, center.clone().add(x, 0.1D, z), 1, 0.0D, 0.0D, 0.0D, 0.0D);
    }
  }

  public static void line(Location from, Location to, Particle particle, double step) {
    World world = from.getWorld();
    if (world == null) {
      return;
    }
    Vector direction = to.toVector().subtract(from.toVector());
    double length = direction.length();
    if (length < 0.001D) {
      return;
    }
    direction.normalize();
    for (double travelled = 0.0D; travelled <= length; travelled += step) {
      Location point = from.clone().add(direction.clone().multiply(travelled));
      world.spawnParticle(particle, point, 1, 0.0D, 0.0D, 0.0D, 0.0D);
    }
  }

  public static void dust(Location location, Color color) {
    World world = location.getWorld();
    if (world == null) {
      return;
    }
    world.spawnParticle(Particle.DUST, location, 1,
        new Particle.DustOptions(color, 1.0F));
  }

  public static void muzzle(Player player, Particle particle) {
    Location eye = player.getEyeLocation();
    Vector direction = eye.getDirection();
    Location muzzle = eye.clone().add(direction.clone().multiply(0.6D));
    burstDirectional(muzzle, particle, 6, 0.08D, 0.02D);
  }

  public static void dashTrail(Player player, Particle particle) {
    World world = player.getWorld();
    world.spawnParticle(particle, player.getLocation().add(0.0D, 1.0D, 0.0D), 18,
        0.35D, 0.5D, 0.35D, 0.04D);
  }
}
