package net.kingscraft.zenixmc.altarsmp.core.mapping;

import org.bukkit.entity.EntityType;

public class EntityTypeSwitchMappings {
  public static final int[] ENTITY_TYPE_MAPPING = new int[EntityType.values().length];

  static {
    ENTITY_TYPE_MAPPING[EntityType.BAT.ordinal()] = 1;
    ENTITY_TYPE_MAPPING[EntityType.SILVERFISH.ordinal()] = 2;
    ENTITY_TYPE_MAPPING[EntityType.ENDERMITE.ordinal()] = 3;
    ENTITY_TYPE_MAPPING[EntityType.CHICKEN.ordinal()] = 4;
    ENTITY_TYPE_MAPPING[EntityType.COD.ordinal()] = 5;
    ENTITY_TYPE_MAPPING[EntityType.SALMON.ordinal()] = 6;
    ENTITY_TYPE_MAPPING[EntityType.TROPICAL_FISH.ordinal()] = 7;
    ENTITY_TYPE_MAPPING[EntityType.PUFFERFISH.ordinal()] = 8;
    ENTITY_TYPE_MAPPING[EntityType.PARROT.ordinal()] = 9;
    ENTITY_TYPE_MAPPING[EntityType.RABBIT.ordinal()] = 10;
    ENTITY_TYPE_MAPPING[EntityType.CAVE_SPIDER.ordinal()] = 11;
    ENTITY_TYPE_MAPPING[EntityType.BEE.ordinal()] = 12;
    ENTITY_TYPE_MAPPING[EntityType.SPIDER.ordinal()] = 13;
    ENTITY_TYPE_MAPPING[EntityType.ZOMBIE.ordinal()] = 14;
    ENTITY_TYPE_MAPPING[EntityType.SKELETON.ordinal()] = 15;
    ENTITY_TYPE_MAPPING[EntityType.CREEPER.ordinal()] = 16;
    ENTITY_TYPE_MAPPING[EntityType.ENDERMAN.ordinal()] = 17;
    ENTITY_TYPE_MAPPING[EntityType.BLAZE.ordinal()] = 18;
    ENTITY_TYPE_MAPPING[EntityType.WITCH.ordinal()] = 19;
    ENTITY_TYPE_MAPPING[EntityType.IRON_GOLEM.ordinal()] = 20;
    ENTITY_TYPE_MAPPING[EntityType.RAVAGER.ordinal()] = 21;
    ENTITY_TYPE_MAPPING[EntityType.WARDEN.ordinal()] = 22;
    ENTITY_TYPE_MAPPING[EntityType.WITHER.ordinal()] = 23;
  } 
}
