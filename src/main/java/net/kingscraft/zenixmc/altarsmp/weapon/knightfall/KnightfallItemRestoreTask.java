package net.kingscraft.zenixmc.altarsmp.weapon.knightfall;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;

class KnightfallItemRestoreTask extends BukkitRunnable {
  public final Player player;

  public KnightfallItemRestoreTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    for (int b = 0; b < this.player.getInventory().getSize(); b++) {
      ItemStack itemStack = this.player.getInventory().getItem(b);
      if (KnightfallListener.isKnightfall(itemStack)) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.lore(CustomItemRegistry.getKnightfall(this.player, false).getItemMeta().lore());
        itemMeta.setCustomModelDataComponent(CustomItemRegistry.getKnightfall(this.player, false).getItemMeta().getCustomModelDataComponent());
        itemStack.setItemMeta(itemMeta);
        this.player.getInventory().setItem(b, itemStack);
      }
    } 
  }
}
