package net.kingscraft.zenixmc.altarsmp.item;

import net.kingscraft.zenixmc.altarsmp.weapon.frostscythe.FrostScytheAbilityListener;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.IllusionWandAbility;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class CustomItemRefreshTask extends BukkitRunnable {
  public final Player player;

  public CustomItemRefreshTask(Player player) {
    this.player = player;
  }

  public void run() {
    for (int slot = 0; slot < this.player.getInventory().getSize(); slot++) {
      ItemStack itemStack = this.player.getInventory().getItem(slot);
      if (itemStack == null) {
        continue;
      }
      if (FrostScytheAbilityListener.isFrostScythe(itemStack)) {
        this.player.getInventory().setItem(slot, CustomItemRegistry.getFrostScythe());
      } else if (IllusionWandAbility.isIllusionWand(itemStack)) {
        // Rebuilding the wand must not erase the mob/player it has captured.
        ItemStack refreshed = CustomItemRegistry.getIllusionWand();
        copyPersistentData(itemStack, refreshed);
        this.player.getInventory().setItem(slot, refreshed);
      }
    }
  }

  private static void copyPersistentData(ItemStack from, ItemStack to) {
    ItemMeta fromMeta = from.getItemMeta();
    ItemMeta toMeta = to.getItemMeta();
    if (fromMeta == null || toMeta == null) {
      return;
    }
    fromMeta.getPersistentDataContainer().copyTo(toMeta.getPersistentDataContainer(), true);
    to.setItemMeta(toMeta);
  }
}
