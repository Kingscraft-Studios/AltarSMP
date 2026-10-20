package net.kingscraft.zenixmc.altarsmp.altars2.ability;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import net.kingscraft.zenixmc.altarsmp.altars2.ability.ancientblade.AncientBladeAbility;
import net.kingscraft.zenixmc.altarsmp.altars2.ability.dragonrend.DragonrendAbility;
import net.kingscraft.zenixmc.altarsmp.altars2.ability.omen.OmenAbility;
import net.kingscraft.zenixmc.altarsmp.altars2.ability.tidebreaker.TidebreakerAbility;
import net.kingscraft.zenixmc.altarsmp.altars2.ability.withersymbiote.WitherSymbioteAbility;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;

public final class Altars2AbilityDispatcher {
  private Altars2AbilityDispatcher() {
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
