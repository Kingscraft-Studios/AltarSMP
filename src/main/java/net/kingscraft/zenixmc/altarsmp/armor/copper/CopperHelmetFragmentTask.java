package net.kingscraft.zenixmc.altarsmp.armor.copper;

import java.util.ArrayList;
import java.util.Random;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;

class CopperHelmetFragmentTask extends BukkitRunnable {
  public final CopperHelmetEventManager eventManager;

  public CopperHelmetFragmentTask(CopperHelmetEventManager copperHelmetEventManager) {
        this.eventManager = copperHelmetEventManager;
    }

  public void run() {
    ArrayList<Player> arrayList = new ArrayList(Bukkit.getOnlinePlayers());
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
    player.getInventory().addItem(new ItemStack[] { CustomItemRegistry.getHelmetShard() });
    Bukkit.broadcastMessage(String.valueOf(ChatColor.of("#B06736")) + "§lA Helmet Fragment has spawned!");
    Bukkit.broadcastMessage(String.valueOf(ChatColor.WHITE) + "(" + this.eventManager.eventCounter + "/5)");
  }



}
