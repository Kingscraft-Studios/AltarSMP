package pl;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gg extends BukkitRunnable {
  final You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gg(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh;
    }
  
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bk.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player)) {
          cancel();
          return;
        } 
      }boolean bool = false;
      for (ItemStack itemStack : player.getInventory().getContents()) {
        if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack)) {
          bool = true;
          break;
        } 
      } 
      if (bool) {
        int i = player.getLocation().getBlockZ();
        int j = player.getLocation().getBlockY();
        int k = player.getLocation().getBlockX();
        String str1 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getWorld());
        String str2 = String.valueOf(ChatColor.of("#B06736"));
        String str3 = player.getName();
        String str4 = ChatColor.BOLD.toString();
        Bukkit.broadcastMessage(String.valueOf(ChatColor.of("#B06736")) + String.valueOf(ChatColor.of("#B06736")) + str4 + str3 + " §rhas a " + str2 + "§lHelmet Fragment§r in the " + str1 + " at (" + k + ", " + j + ", " + i);
      } 
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gg.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */