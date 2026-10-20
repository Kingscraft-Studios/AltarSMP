package net.kingscraft.zenixmc.altarsmp.altars2.kill;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.kingscraft.zenixmc.altarsmp.altars2.Altars2;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;

public class Altars2KillListener implements Listener {

  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void onPlayerDeath(PlayerDeathEvent event) {
    Player killer = event.getPlayer().getKiller();
    if (killer == null) {
      return;
    }
    ItemStack itemStack = killer.getInventory().getItemInMainHand();
    if (CustomItem.fromItem(itemStack) != CustomItem.ANCIENTBLADE) {
      return;
    }
    Altars2.getKillTracker().incrementKillCount(killer);
    int kills = Altars2.getKillTracker().getKillCount(killer);
    killer.sendMessage("§cAncient Blade is now at " + kills + " kills");
    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta != null) {
      itemMeta.setLore(CustomItem.ANCIENTBLADE.getItem(killer).getItemMeta().getLore());
      itemStack.setItemMeta(itemMeta);
      killer.getInventory().setItemInMainHand(itemStack);
    }
  }
}
