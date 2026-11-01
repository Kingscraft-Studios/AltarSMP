package net.kingscraft.zenixmc.altarsmp.weapon.illusion.attribute;

import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.util.IllusionConfig;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

/**
 * Applies the disguise attribute pool.
 *
 * <p>Health is scaled for every mob. Horse-family disguises additionally roll a
 * vanilla horse movement speed and jump strength so they feel like a mount.
 * Attack damage, armor, attack speed, knockback resistance, step height and
 * reach stay exactly as the player's own gear defines them.</p>
 *
 * <p>{@code target = clamp(vanillaHealth * scale, floor, max)}, except horses,
 * which roll {@code health-min..health-max}. Every value is added as a transient
 * modifier, so removing it on reveal restores the exact original stats and never
 * permanently changes the player.</p>
 */
public final class IllusionAttributeService {

  private static final Set<EntityType> HORSE_FAMILY = EnumSet.of(
          EntityType.HORSE, EntityType.SKELETON_HORSE, EntityType.ZOMBIE_HORSE,
          EntityType.DONKEY, EntityType.MULE);

  // Every attribute this service may write, so a reveal always cleans up fully.
  private static final Attribute[] LEGACY_TRACKED = {
          Attribute.MAX_HEALTH,
          Attribute.ATTACK_DAMAGE,
          Attribute.MOVEMENT_SPEED,
          Attribute.JUMP_STRENGTH,
          Attribute.ATTACK_SPEED,
          Attribute.ARMOR,
          Attribute.ARMOR_TOUGHNESS,
          Attribute.KNOCKBACK_RESISTANCE,
          Attribute.ATTACK_KNOCKBACK,
          Attribute.STEP_HEIGHT,
          Attribute.ENTITY_INTERACTION_RANGE,
          Attribute.FALL_DAMAGE_MULTIPLIER
  };

  private IllusionAttributeService() {
  }

  public static boolean isHorse(EntityType type) {
    return type != null && HORSE_FAMILY.contains(type);
  }

  public static void apply(Player player, EntityType type) {
    if (player == null) {
      return;
    }
    clear(player);
    if (type == null || type == EntityType.PLAYER) {
      return;
    }

    applyHealth(player, type);
    if (isHorse(type)) {
      applyHorseSpeed(player);
      applyHorseJump(player);
    }
  }

  private static void applyHealth(Player player, EntityType type) {
    AttributeInstance health = player.getAttribute(Attribute.MAX_HEALTH);
    if (health == null) {
      return;
    }
    double target = targetHealth(type);
    if (target <= 0.0D) {
      return;
    }

    double ratio = health.getValue() > 0.0D
            ? clamp(player.getHealth() / health.getValue(), 0.0D, 1.0D)
            : 1.0D;

    applyExact(health, Attribute.MAX_HEALTH, target);

    double newMax = health.getValue();
    if (!player.isDead()) {
      player.setHealth(clamp(ratio * newMax, 1.0D, newMax));
    }
  }

  private static void applyHorseSpeed(Player player) {
    AttributeInstance speed = player.getAttribute(Attribute.MOVEMENT_SPEED);
    if (speed == null) {
      return;
    }
    applyExact(speed, Attribute.MOVEMENT_SPEED,
            randomBetween(IllusionConfig.horseSpeedMin(), IllusionConfig.horseSpeedMax()));
  }

  private static void applyHorseJump(Player player) {
    AttributeInstance jump = player.getAttribute(Attribute.JUMP_STRENGTH);
    if (jump == null) {
      return;
    }
    applyExact(jump, Attribute.JUMP_STRENGTH,
            randomBetween(IllusionConfig.horseJumpMin(), IllusionConfig.horseJumpMax()));
  }

  private static void applyExact(AttributeInstance instance, Attribute attribute, double target) {
    NamespacedKey key = key(attribute);
    if (instance.getModifier(key) != null) {
      instance.removeModifier(key);
    }
    // Use the current value, not the base value: other plugins/items may add
    // modifiers and the disguise must still land on exactly target.
    double delta = target - instance.getValue();
    if (Math.abs(delta) > 1.0E-6D) {
      instance.addTransientModifier(new AttributeModifier(key, delta, Operation.ADD_NUMBER));
    }
  }

  public static void clear(Player player) {
    if (player == null) {
      return;
    }
    AttributeInstance health = player.getAttribute(Attribute.MAX_HEALTH);
    if (health != null) {
      double ratio = health.getValue() > 0.0D
              ? clamp(player.getHealth() / health.getValue(), 0.0D, 1.0D)
              : 1.0D;
      NamespacedKey key = key(Attribute.MAX_HEALTH);
      if (health.getModifier(key) != null) {
        health.removeModifier(key);
      }
      double restored = health.getValue();
      // Always rescale so the health percentage survives the reveal, even when
      // the restored pool is larger than the player's current health.
      if (!player.isDead()) {
        player.setHealth(clamp(ratio * restored, 1.0D, restored));
      }
    }
    for (Attribute attribute : LEGACY_TRACKED) {
      if (attribute == Attribute.MAX_HEALTH) {
        continue;
      }
      AttributeInstance instance = player.getAttribute(attribute);
      if (instance == null) {
        continue;
      }
      NamespacedKey key = key(attribute);
      if (instance.getModifier(key) != null) {
        instance.removeModifier(key);
      }
    }
  }

  /** Adds zero fall damage for flying / cat-like / chicken disguises. */
  public static void applyFallDamageImmunity(Player player) {
    if (player == null) {
      return;
    }
    AttributeInstance instance = player.getAttribute(Attribute.FALL_DAMAGE_MULTIPLIER);
    if (instance == null) {
      return;
    }
    NamespacedKey key = key(Attribute.FALL_DAMAGE_MULTIPLIER);
    if (instance.getModifier(key) != null) {
      instance.removeModifier(key);
    }
    double base = instance.getBaseValue();
    if (Math.abs(base) < 1.0E-6D) {
      return;
    }
    instance.addTransientModifier(new AttributeModifier(key, -base, Operation.ADD_NUMBER));
  }

  public static void clearFallDamageImmunity(Player player) {
    if (player == null) {
      return;
    }
    AttributeInstance instance = player.getAttribute(Attribute.FALL_DAMAGE_MULTIPLIER);
    if (instance == null) {
      return;
    }
    NamespacedKey key = key(Attribute.FALL_DAMAGE_MULTIPLIER);
    if (instance.getModifier(key) != null) {
      instance.removeModifier(key);
    }
  }

  private static double targetHealth(EntityType type) {
    double target = IllusionConfig.healthOverride(type);
    if (target <= 0.0D) {
      if (isHorse(type) && IllusionConfig.horseRandomHealth()) {
        target = randomBetween(IllusionConfig.horseHealthMin(), IllusionConfig.horseHealthMax());
      } else {
        Attributable defaults = defaults(type);
        if (defaults == null) {
          return -1.0D;
        }
        AttributeInstance vanilla = defaults.getAttribute(Attribute.MAX_HEALTH);
        if (vanilla == null) {
          return -1.0D;
        }
        target = vanilla.getBaseValue() * IllusionConfig.healthScale();
      }
    }
    double floor = IllusionConfig.healthFloor();
    double max = IllusionConfig.healthMax();
    if (floor > 0.0D) {
      target = Math.max(target, floor);
    }
    if (max > 0.0D) {
      target = Math.min(target, max);
    }
    return Math.max(1.0D, target);
  }

  private static double randomBetween(double first, double second) {
    double min = Math.min(first, second);
    double max = Math.max(first, second);
    if (Math.abs(max - min) < 1.0E-9D) {
      return min;
    }
    return ThreadLocalRandom.current().nextDouble(min, max);
  }

  private static Attributable defaults(EntityType type) {
    if (!type.hasDefaultAttributes()) {
      return null;
    }
    try {
      return type.getDefaultAttributes();
    } catch (IllegalArgumentException exception) {
      return null;
    }
  }

  private static NamespacedKey key(Attribute attribute) {
    return new NamespacedKey(AltarSMP.getInstance(), "illusion_" + attribute.getKey().getKey());
  }

  private static double clamp(double value, double min, double max) {
    return Math.max(min, Math.min(max, value));
  }
}
