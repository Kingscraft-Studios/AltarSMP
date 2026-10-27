package net.kingscraft.zenixmc.altarsmp.altarS2.core;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import net.kingscraft.zenixmc.altarsmp.altarS2.weapon.ancientblade.AncientBladeAbility;
import net.kingscraft.zenixmc.altarsmp.altarS2.weapon.dragonrend.DragonrendAbility;
import net.kingscraft.zenixmc.altarsmp.altarS2.weapon.omen.OmenAbility;
import net.kingscraft.zenixmc.altarsmp.altarS2.weapon.tidebreaker.TidebreakerAbility;
import net.kingscraft.zenixmc.altarsmp.altarS2.weapon.withersymbiote.WitherSymbioteAbility;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;

public final class AltarS2AbilityDispatcher {
  private AltarS2AbilityDispatcher() {
  }

  public static boolean dispatchMainHand(Player player) {
    CustomItem weapon = resolve(player);
    if (weapon == null) {
      return false;
    }
    return switch (weapon) {
      case TIDEBREAKER -> TidebreakerAbility.stormcall(player);
      case ANCIENTBLADE -> AncientBladeAbility.presence(player);
      case WITHERSYMBIOTE -> WitherSymbioteAbility.infection(player);
      case OMEN -> OmenAbility.vaultOmen(player);
      case DRAGONREND -> DragonrendAbility.armHypersonic(player);
      default -> false;
    };
  }

  public static boolean dispatchOffhand(Player player) {
    CustomItem weapon = resolve(player);
    if (weapon == null) {
      return false;
    }
    return switch (weapon) {
      case TIDEBREAKER -> TidebreakerAbility.risingTide(player);
      case ANCIENTBLADE -> AncientBladeAbility.unyieldingDarkness(player);
      case WITHERSYMBIOTE -> WitherSymbioteAbility.rampage(player);
      case OMEN -> OmenAbility.ominousConjuring(player);
      case DRAGONREND -> DragonrendAbility.infiniteVoid(player);
      default -> false;
    };
  }

  private static CustomItem resolve(Player player) {
    ItemStack item = player.getInventory().getItemInMainHand();
    CustomItem weapon = CustomItem.fromItem(item);
    if (weapon == null) {
      weapon = CustomItem.fromItem(player.getInventory().getItemInOffHand());
    }
    return weapon;
  }
}
