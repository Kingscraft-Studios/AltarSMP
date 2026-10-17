package pl;

import java.util.ArrayList;
import java.util.Random;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

class CopperHelmetFragmentTask extends BukkitRunnable {
  final CopperHelmetEventManager eventManager;
  
  CopperHelmetFragmentTask(CopperHelmetEventManager copperHelmetEventManager) {
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
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gf.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */