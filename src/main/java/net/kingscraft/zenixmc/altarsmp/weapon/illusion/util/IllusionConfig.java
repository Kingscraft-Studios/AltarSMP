package net.kingscraft.zenixmc.altarsmp.weapon.illusion.util;

import java.util.List;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;

public final class IllusionConfig {

  private static final List<String> DEFAULT_RANDOM_MOBS = List.of("ENDERMAN", "CREEPER", "WARDEN", "BAT", "BLAZE", "IRON_GOLEM");

  private static FileConfiguration config() {
    return AltarSMP.getInstance().getConfig();
  }

  public static boolean enabled() {
    return config().getBoolean("illusion.enabled", true);
  }

  public static boolean keepCapturedMob() {
    return config().getBoolean("illusion.keep-captured-mob", true);
  }

  public static int abilityCooldown() {
    return Math.max(1, config().getInt("illusion.ability-cooldown", 10));
  }

  public static double healthScale() {
    return clamp(config().getDouble("illusion.health.scale", 0.25D), 10.0D);
  }

  public static double healthFloor() {
    return Math.max(0.0D, config().getDouble("illusion.health.floor", 20.0D));
  }

  public static double healthMax() {
    return Math.max(0.0D, config().getDouble("illusion.health.max", 100.0D));
  }

  public static double healthOverride(EntityType type) {
    if (type == null) {
      return -1.0D;
    }
    return config().getDouble("illusion.health.overrides." + type.name(), -1.0D);
  }

  public static boolean passivesEnabled() {
    return config().getBoolean("illusion.passives", true);
  }

  public static double abilityDamageScale() {
    return clamp(config().getDouble("illusion.ability-damage-scale", 1.0D), 10.0D);
  }

  public static double meleeScale() {
    return clamp(config().getDouble("illusion.melee.scale", 0.25D), 1.0D);
  }

  public static double evokerFangsDamage() {
    return Math.max(0.0D, config().getDouble("illusion.evoker.fangs-damage", 6.0D));
  }

  public static int blazeVolleyCount() {
    return Math.max(1, config().getInt("illusion.blaze.volley-count", 3));
  }

  public static int blazeVolleyInterval() {
    return Math.max(1, config().getInt("illusion.blaze.volley-interval", 5));
  }

  public static boolean flightEnabled() {
    return config().getBoolean("illusion.flight.enabled", true);
  }

  public static double flySpeed() {
    return clamp(config().getDouble("illusion.flight.speed", 0.1D), 1.0D);
  }

  public static boolean noFallDamage() {
    return config().getBoolean("illusion.flight.no-fall-damage", true);
  }

  public static boolean aggroImmunity() {
    return config().getBoolean("illusion.aggro-immunity", true);
  }

  public static boolean castAnimation() {
    return config().getBoolean("illusion.cast-animation", true);
  }

  public static boolean witherHideBossBar() {
    return config().getBoolean("illusion.wither.hide-boss-bar", true);
  }

  public static boolean striderLavaWalk() {
    return config().getBoolean("illusion.strider.lava-walk", true);
  }

  public static double sonicBoomDamage() {
    return Math.max(0.0D, config().getDouble("illusion.sonic-boom-damage", 20.0D));
  }

  public static boolean horseRandomHealth() {
    return config().getBoolean("illusion.horse.random-health", true);
  }

  public static double horseHealthMin() {
    return config().getDouble("illusion.horse.health-min", 20.0D);
  }

  public static double horseHealthMax() {
    return config().getDouble("illusion.horse.health-max", 30.0D);
  }

  public static double horseSpeedMin() {
    return config().getDouble("illusion.horse.speed-min", 0.1125D);
  }

  public static double horseSpeedMax() {
    return config().getDouble("illusion.horse.speed-max", 0.3375D);
  }

  public static double horseJumpMin() {
    return config().getDouble("illusion.horse.jump-min", 0.4D);
  }

  public static double horseJumpMax() {
    return config().getDouble("illusion.horse.jump-max", 1.0D);
  }

  public static double creeperExplosionStrength() {
    return config().getDouble("illusion.creeper-explosion-strength", 3.0D);
  }

  public static double fireballStrength() {
    return config().getDouble("illusion.fireball-strength", 2.0D);
  }

  public static int chargeDurationSeconds() {
    return Math.max(1, config().getInt("illusion.charge-duration", 2));
  }

  public static boolean randomMobMode() {
    return config().getBoolean("illusion.random-mob", false);
  }

  public static List<String> randomMobTypes() {
    List<String> configured = config().getStringList("illusion.random-mobs");
    return configured.isEmpty() ? DEFAULT_RANDOM_MOBS : configured;
  }

  private static double clamp(double value, double max) {
    return Math.clamp(value, 0.0, max);
  }
}
