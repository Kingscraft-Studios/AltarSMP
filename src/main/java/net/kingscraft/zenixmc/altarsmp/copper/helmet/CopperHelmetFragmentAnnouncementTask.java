package net.kingscraft.zenixmc.altarsmp.copper.helmet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kingscraft.zenixmc.altarsmp.altar.AltarRitualListener;

class CopperHelmetFragmentAnnouncementTask extends BukkitRunnable {
  private static final TextColor COPPER = TextColor.color(0xB06736);
  public final CopperHelmetEventManager eventManager;

  public CopperHelmetFragmentAnnouncementTask(CopperHelmetEventManager copperHelmetEventManager) {
        this.eventManager = copperHelmetEventManager;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (AltarRitualListener.isCopperHelmetPlayer(player)) {
          cancel();
          return;
        } 
      }boolean bool = false;
      for (ItemStack itemStack : player.getInventory().getContents()) {
        if (this.eventManager.isHelmetFragment(itemStack)) {
          bool = true;
          break;
        } 
      } 
      if (bool) {
        Bukkit.broadcast(Component.text()
            .append(Component.text(player.getName(), COPPER, TextDecoration.BOLD))
            .append(Component.text(" has a "))
            .append(Component.text("Helmet Fragment", COPPER, TextDecoration.BOLD))
            .append(Component.text(" in the " + this.eventManager.getWorldDisplayName(player.getWorld())
                + " at (" + player.getLocation().getBlockX() + ", " + player.getLocation().getBlockY() + ", " + player.getLocation().getBlockZ() + ")"))
            .build());
      } 
    } 
  }



}
