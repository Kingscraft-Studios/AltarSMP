package net.kingscraft.zenixmc.altarsmp.copper.helmet;

import java.util.ArrayList;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;

class CopperHelmetFragmentTask extends BukkitRunnable {
  private static final TextColor COPPER = TextColor.color(0xB06736);
  public final CopperHelmetEventManager eventManager;

  public CopperHelmetFragmentTask(CopperHelmetEventManager copperHelmetEventManager) {
        this.eventManager = copperHelmetEventManager;
    }

  public void run() {
    ArrayList<Player> arrayList = new ArrayList<>(Bukkit.getOnlinePlayers());
    {
      if (arrayList.isEmpty())
        return; 
    }Player player = arrayList.get((new Random()).nextInt(arrayList.size()));
    {
      if (this.eventManager.eventCounter >= 5) {
        this.eventManager.eventCounter = 0;
        cancel();
        return;
      } 
    }this.eventManager.eventCounter++;
    player.getInventory().addItem(CustomItemRegistry.getHelmetShard());
    Bukkit.broadcast(Component.text("A Helmet Fragment has spawned!", COPPER, TextDecoration.BOLD));
    Bukkit.broadcast(Component.text("(" + this.eventManager.eventCounter + "/5)", NamedTextColor.WHITE));
  }



}
