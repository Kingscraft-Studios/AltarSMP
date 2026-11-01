package net.kingscraft.zenixmc.altarsmp.weapon.illusion.ability;

import java.util.EnumMap;
import java.util.Map;
import org.bukkit.entity.Ambient;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Golem;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Raider;
import org.bukkit.entity.Slime;
import org.bukkit.entity.WaterMob;

/**
 * Maps every vanilla {@link EntityType} to an {@link IllusionAbilityFamily}.
 *
 * <p>Unknown/future mobs still work through Bukkit interface fallbacks, so a
 * new 1.22 mob automatically inherits a sensible ability family.</p>
 */
public final class IllusionAbilityRegistry {

  private static final Map<EntityType, IllusionAbilityFamily> FAMILIES = new EnumMap<>(EntityType.class);

  static {
    // Fire
    map(IllusionAbilityFamily.FIREBALL,
            EntityType.BLAZE, EntityType.GHAST, EntityType.HAPPY_GHAST);
    map(IllusionAbilityFamily.EXPLODE, EntityType.CREEPER);
    map(IllusionAbilityFamily.TELEPORT, EntityType.ENDERMAN);
    map(IllusionAbilityFamily.SONIC_BOOM, EntityType.WARDEN);
    map(IllusionAbilityFamily.WITHER_SKULL, EntityType.WITHER, EntityType.ENDER_DRAGON);

    // Arthropods
    map(IllusionAbilityFamily.POISON_BITE, EntityType.SPIDER, EntityType.CAVE_SPIDER);

    // Ranged
    map(IllusionAbilityFamily.ARROW_VOLLEY,
            EntityType.SKELETON, EntityType.STRAY, EntityType.BOGGED, EntityType.PARCHED,
            EntityType.PILLAGER);
    map(IllusionAbilityFamily.TRIDENT, EntityType.DROWNED);
    map(IllusionAbilityFamily.LASER, EntityType.GUARDIAN, EntityType.ELDER_GUARDIAN);
    map(IllusionAbilityFamily.LEVITATE, EntityType.SHULKER);
    map(IllusionAbilityFamily.SNOWBALL, EntityType.SNOW_GOLEM);
    map(IllusionAbilityFamily.SPIT, EntityType.LLAMA, EntityType.TRADER_LLAMA);

    // Melee brawlers. Wither skeletons deliberately live here (not with the
    // Wither): they hit harder and apply Wither on hit.
    map(IllusionAbilityFamily.MELEE_BURST,
            EntityType.ZOMBIE, EntityType.HUSK, EntityType.ZOMBIE_VILLAGER,
            EntityType.WITHER_SKELETON, EntityType.ENDERMITE, EntityType.SILVERFISH,
            EntityType.CREAKING, EntityType.VINDICATOR,
            EntityType.PIGLIN, EntityType.PIGLIN_BRUTE, EntityType.ZOMBIFIED_PIGLIN,
            EntityType.WOLF, EntityType.POLAR_BEAR, EntityType.FOX, EntityType.PANDA);

    // Chargers / mounts
    map(IllusionAbilityFamily.CHARGE,
            EntityType.RAVAGER, EntityType.HOGLIN, EntityType.ZOGLIN,
            EntityType.GOAT, EntityType.CAMEL, EntityType.CAMEL_HUSK,
            EntityType.HORSE, EntityType.SKELETON_HORSE, EntityType.ZOMBIE_HORSE,
            EntityType.DONKEY, EntityType.MULE);
    map(IllusionAbilityFamily.STAMPEDE,
            EntityType.PIG, EntityType.COW, EntityType.SHEEP);

    // Magic
    map(IllusionAbilityFamily.SUMMON_FANGS, EntityType.EVOKER);
    map(IllusionAbilityFamily.HEX, EntityType.WITCH, EntityType.ILLUSIONER);
    map(IllusionAbilityFamily.WIND_CHARGE, EntityType.BREEZE);

    // Movement
    map(IllusionAbilityFamily.LEAP,
            EntityType.SLIME, EntityType.MAGMA_CUBE, EntityType.RABBIT, EntityType.FROG,
            EntityType.CAT, EntityType.OCELOT);
    map(IllusionAbilityFamily.INK, EntityType.SQUID, EntityType.GLOW_SQUID);
    map(IllusionAbilityFamily.FLY_DASH,
            EntityType.BAT, EntityType.PARROT, EntityType.BEE, EntityType.PHANTOM,
            EntityType.VEX, EntityType.ALLAY);
    map(IllusionAbilityFamily.FEATHER, EntityType.CHICKEN);
    map(IllusionAbilityFamily.AQUATIC_DASH,
            EntityType.DOLPHIN, EntityType.COD, EntityType.SALMON, EntityType.TROPICAL_FISH,
            EntityType.PUFFERFISH, EntityType.TADPOLE);

    // Heavy
    map(IllusionAbilityFamily.SLAM,
            EntityType.IRON_GOLEM, EntityType.COPPER_GOLEM, EntityType.GIANT);

    // Support / utility
    map(IllusionAbilityFamily.GUARD, EntityType.TURTLE, EntityType.ARMADILLO);
    map(IllusionAbilityFamily.HEAL, EntityType.AXOLOTL, EntityType.MOOSHROOM);
    map(IllusionAbilityFamily.SNIFF, EntityType.SNIFFER);
    map(IllusionAbilityFamily.TRADE, EntityType.VILLAGER, EntityType.WANDERING_TRADER);
    // Striders have no active ability: lava walking is an always-on passive.
    map(IllusionAbilityFamily.PASSIVE, EntityType.STRIDER, EntityType.PLAYER);
  }

  private IllusionAbilityRegistry() {
  }

  public static IllusionAbilityFamily family(EntityType type) {
    if (type == null) {
      return IllusionAbilityFamily.PASSIVE;
    }
    IllusionAbilityFamily family = FAMILIES.get(type);
    return family != null ? family : fallback(type);
  }

  private static IllusionAbilityFamily fallback(EntityType type) {
    Class<? extends Entity> entityClass;
    try {
      entityClass = type.getEntityClass();
    } catch (Throwable ignored) {
      return IllusionAbilityFamily.PASSIVE;
    }
    if (entityClass == null) {
      return IllusionAbilityFamily.PASSIVE;
    }
    // Raider extends Monster, so check it first.
    if (Raider.class.isAssignableFrom(entityClass)) {
      return IllusionAbilityFamily.ARROW_VOLLEY;
    }
    if (Boss.class.isAssignableFrom(entityClass)) {
      return IllusionAbilityFamily.WITHER_SKULL;
    }
    if (Monster.class.isAssignableFrom(entityClass)) {
      return IllusionAbilityFamily.MELEE_BURST;
    }
    if (Slime.class.isAssignableFrom(entityClass)) {
      return IllusionAbilityFamily.LEAP;
    }
    if (Golem.class.isAssignableFrom(entityClass)) {
      return IllusionAbilityFamily.SLAM;
    }
    if (WaterMob.class.isAssignableFrom(entityClass)) {
      return IllusionAbilityFamily.AQUATIC_DASH;
    }
    if (Ambient.class.isAssignableFrom(entityClass)) {
      return IllusionAbilityFamily.FLY_DASH;
    }
    if (Animals.class.isAssignableFrom(entityClass)) {
      return IllusionAbilityFamily.STAMPEDE;
    }
    return IllusionAbilityFamily.PASSIVE;
  }

  private static void map(IllusionAbilityFamily family, EntityType... types) {
    for (EntityType type : types) {
      FAMILIES.put(type, family);
    }
  }
}
