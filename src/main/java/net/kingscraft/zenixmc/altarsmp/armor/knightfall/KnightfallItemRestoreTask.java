package net.kingscraft.zenixmc.altarsmp.armor.knightfall;

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
        itemMeta.setLore(CustomItemRegistry.getKnightfall(this.player, false).getItemMeta().getLore());
        itemMeta.setCustomModelData(CustomItemRegistry.getKnightfall(this.player, false).getItemMeta().getCustomModelData());
        itemStack.setItemMeta(itemMeta);
        this.player.getInventory().setItem(b, itemStack);
      }
    } 
  }
}
