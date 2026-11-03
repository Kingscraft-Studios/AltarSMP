package net.kingscraft.zenixmc.altarsmp.weapon.illusion.util;

import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public final class IllusionMeleeDamage {

  private IllusionMeleeDamage() {
  }

  public static double damage(EntityType type, PiglinVariant variant) {
    double vanilla = vanillaDamage(type, variant);
    if (vanilla <= 0.0D) {
      return 0.0D;
    }
    return vanilla * IllusionConfig.meleeScale();
  }

  public static double vanillaDamage(EntityType type, PiglinVariant variant) {
    if (type == null || type == EntityType.PLAYER) {
      return 0.0D;
    }
    PiglinVariant resolved = resolveVariant(type, variant);
    if (type == EntityType.PIGLIN && resolved == PiglinVariant.NONE) {
      return 0.0D;
    }
    double base = 0.0D;
    if (type.hasDefaultAttributes()) {
      try {
        Attributable defaults = type.getDefaultAttributes();
        AttributeInstance attack = defaults.getAttribute(Attribute.ATTACK_DAMAGE);
        if (attack != null) {
          base = attack.getBaseValue();
        }
      } catch (IllegalArgumentException | UnsupportedOperationException ignored) {
        // Custom/unknown entity types simply have no melee bonus.
      }
    }
    if (base <= 0.0D) {
      return 0.0D;
    }
    ItemStack weapon = weapon(type, resolved);
    if (weapon != null) {
      base += weaponAttackDamage(weapon.getType());
    }
    return base;
  }

  public static ItemStack weapon(EntityType type, PiglinVariant variant) {
    if (type == null) {
      return null;
    }
    if (type == EntityType.PIGLIN) {
      return switch (resolveVariant(type, variant)) {
        case SWORD -> new ItemStack(Material.GOLDEN_SWORD);
        case CROSSBOW -> new ItemStack(Material.CROSSBOW);
        case NONE -> null;
      };
    }
    Material material = switch (type) {
      case WITHER_SKELETON -> Material.STONE_SWORD;
      case ZOMBIFIED_PIGLIN -> Material.GOLDEN_SWORD;
      case PIGLIN_BRUTE -> Material.GOLDEN_AXE;
      case VINDICATOR -> Material.IRON_AXE;
      case DROWNED -> Material.TRIDENT;
      default -> null;
    };
    return material == null ? null : new ItemStack(material);
  }

  public static PiglinVariant resolveVariant(EntityType type, PiglinVariant variant) {
    if (type != EntityType.PIGLIN) {
      return variant;
    }
    return variant == null ? PiglinVariant.SWORD : variant;
  }

  private static double weaponAttackDamage(Material material) {
    if (material == null || !material.isItem()) {
      return 0.0D;
    }
    double damage = 0.0D;
    for (AttributeModifier modifier : material.getDefaultAttributeModifiers(EquipmentSlot.HAND)
            .get(Attribute.ATTACK_DAMAGE)) {
      if (modifier.getOperation() == AttributeModifier.Operation.ADD_NUMBER) {
        damage += modifier.getAmount();
      }
    }
    return damage;
  }
}
