package net.kingscraft.zenixmc.altarsmp.core;

import org.bukkit.entity.EntityType;

public class MobAbilityTypeSwitchMappings {
  public static final int[] ENTITY_TYPE_MAPPING;

  static {
    ENTITY_TYPE_MAPPING = new int[EntityType.values().length];
    ENTITY_TYPE_MAPPING[EntityType.CREEPER.ordinal()] = 1;

    ENTITY_TYPE_MAPPING[EntityType.ENDERMAN.ordinal()] = 2;

    ENTITY_TYPE_MAPPING[EntityType.BLAZE.ordinal()] = 3;

    ENTITY_TYPE_MAPPING[EntityType.WITHER.ordinal()] = 4;

    ENTITY_TYPE_MAPPING[EntityType.WARDEN.ordinal()] = 5;

    ENTITY_TYPE_MAPPING[EntityType.SPIDER.ordinal()] = 6;

    ENTITY_TYPE_MAPPING[EntityType.CAVE_SPIDER.ordinal()] = 7;

    ENTITY_TYPE_MAPPING[EntityType.GHAST.ordinal()] = 8;

  }
}