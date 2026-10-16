package pl;

import org.bukkit.entity.EntityType;

class MobAbilityTypeSwitchMappings {
  static final int[] ENTITY_TYPE_MAPPING;

  static {
    ENTITY_TYPE_MAPPING = new int[EntityType.values().length];
    try {
      ENTITY_TYPE_MAPPING[EntityType.CREEPER.ordinal()] = 1;
    } catch (NoSuchFieldError e) {
    }
    try {
      ENTITY_TYPE_MAPPING[EntityType.ENDERMAN.ordinal()] = 2;
    } catch (NoSuchFieldError e) {
    }
    try {
      ENTITY_TYPE_MAPPING[EntityType.BLAZE.ordinal()] = 3;
    } catch (NoSuchFieldError e) {
    }
    try {
      ENTITY_TYPE_MAPPING[EntityType.WITHER.ordinal()] = 4;
    } catch (NoSuchFieldError e) {
    }
    try {
      ENTITY_TYPE_MAPPING[EntityType.WARDEN.ordinal()] = 5;
    } catch (NoSuchFieldError e) {
    }
    try {
      ENTITY_TYPE_MAPPING[EntityType.SPIDER.ordinal()] = 6;
    } catch (NoSuchFieldError e) {
    }
    try {
      ENTITY_TYPE_MAPPING[EntityType.CAVE_SPIDER.ordinal()] = 7;
    } catch (NoSuchFieldError e) {
    }
    try {
      ENTITY_TYPE_MAPPING[EntityType.GHAST.ordinal()] = 8;
    } catch (NoSuchFieldError e) {
    }
  }
}