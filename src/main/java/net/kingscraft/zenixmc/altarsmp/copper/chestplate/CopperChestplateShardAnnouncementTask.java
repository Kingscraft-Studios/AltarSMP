package net.kingscraft.zenixmc.altarsmp.copper.chestplate;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kingscraft.zenixmc.altarsmp.altar.AltarRitualListener;

class CopperChestplateShardAnnouncementTask extends BukkitRunnable {
  private static final TextColor COPPER = TextColor.color(0xB06736);
  public final CopperChestplateEventManager eventManager;

  public CopperChestplateShardAnnouncementTask(CopperChestplateEventManager copperChestplateEventManager) {
        this.eventManager = copperChestplateEventManager;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (AltarRitualListener.isCopperChestplatePlayer(player)) {
          cancel();
          return;
        } 
      }boolean bool = false;
      for (ItemStack itemStack : player.getInventory().getContents()) {
        if (this.eventManager.isChestplateShard(itemStack)) {
          bool = true;
          break;
        } 
      } 
      if (bool) {
        Bukkit.broadcast(Component.text()
            .append(Component.text(player.getName(), COPPER, TextDecoration.BOLD))
            .append(Component.text(" has the "))
            .append(Component.text("Chestplate Shard", COPPER, TextDecoration.BOLD))
            .append(Component.text(" in the " + this.eventManager.getWorldDisplayName(player.getWorld())
                + " at (" + player.getLocation().getBlockX() + ", " + player.getLocation().getBlockY() + ", " + player.getLocation().getBlockZ() + ")"))
            .build());
      } 
    } 
  }



}
