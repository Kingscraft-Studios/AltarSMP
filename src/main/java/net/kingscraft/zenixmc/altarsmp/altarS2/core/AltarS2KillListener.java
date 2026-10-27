package net.kingscraft.zenixmc.altarsmp.altarS2.core;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kingscraft.zenixmc.altarsmp.altarS2.AltarS2;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;

public class AltarS2KillListener implements Listener {

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
    AltarS2.getKillTracker().incrementKillCount(killer);
    int kills = AltarS2.getKillTracker().getKillCount(killer);
    killer.sendMessage(Component.text("Ancient Blade is now at " + kills + " kills", NamedTextColor.RED));
    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta != null) {
      itemMeta.lore(CustomItem.ANCIENTBLADE.getItem(killer).getItemMeta().lore());
      itemStack.setItemMeta(itemMeta);
      killer.getInventory().setItemInMainHand(itemStack);
    }
  }
}
