package net.kingscraft.zenixmc.altarsmp.weapon.illusion.util;

import java.util.List;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;

/**
 * Central access point for every Wand of Illusion tuning value.
 *
 * <p>Everything lives under {@code illusion:} in config.yml. The old flat keys
 * are gone on purpose: delete the config and let the plugin generate a fresh
 * one.</p>
 */
public final class IllusionConfig {

  private static final List<String> DEFAULT_RANDOM_MOBS = List.of(
          "ENDERMAN", "CREEPER", "WARDEN", "BAT", "BLAZE", "IRON_GOLEM");

  private IllusionConfig() {
  }

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

  /** 0.25 = 25% of the mob's vanilla health. */
  public static double healthScale() {
    return clamp(config().getDouble("illusion.health.scale", 0.25D), 10.0D);
  }

  /** 0 or less disables the floor. */
  public static double healthFloor() {
    return Math.max(0.0D, config().getDouble("illusion.health.floor", 20.0D));
  }

  /** 0 or less disables the cap. */
  public static double healthMax() {
    return Math.max(0.0D, config().getDouble("illusion.health.max", 100.0D));
  }

  /** Absolute override in HP, or -1 when the mob uses the scale. */
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

  /** Percentage of the vanilla entity's melee damage used by empty-hand attacks. */
  public static double meleeScale() {
    return clamp(config().getDouble("illusion.melee.scale", 0.25D), 1.0D);
  }

  /** Damage of a real Evoker Fangs entity owned by a disguised Evoker. */
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

  /** Hostile mobs ignore a mob-disguised player. Captured-player disguises keep normal aggro. */
  public static boolean aggroImmunity() {
    return config().getBoolean("illusion.aggro-immunity", true);
  }

  /** Play a swing / spell animation on the fake entity when an ability fires. */
  public static boolean castAnimation() {
    return config().getBoolean("illusion.cast-animation", true);
  }

  /** The fake Wither must never show the vanilla boss bar. */
  public static boolean witherHideBossBar() {
    return config().getBoolean("illusion.wither.hide-boss-bar", true);
  }

  /** Strider disguises keep the player on top of lava as an always-on trait. */
  public static boolean striderLavaWalk() {
    return config().getBoolean("illusion.strider.lava-walk", true);
  }

  /** Movement-speed attribute while walking on lava (player base is 0.1). */
  public static double striderLavaSpeed() {
    return clamp(config().getDouble("illusion.strider.lava-speed", 0.175D), 1.0D);
  }

  /** Sonic Boom bypasses armour and shields. */
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
    return Math.max(0.0, Math.min(max, value));
  }
}
