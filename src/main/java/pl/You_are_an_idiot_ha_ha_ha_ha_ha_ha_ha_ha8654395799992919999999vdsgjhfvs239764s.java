package pl;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764s implements CommandExecutor {
  
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764s(Main paramMain) {}
  
  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    if (paramCommandSender instanceof Player) {
      Player player = (Player)paramCommandSender;
      {
        if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
          player.sendMessage("You need to be holding a legendary in your mainhand");
          return true;
        } 
      }{
        if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 0) {
          player.sendMessage("You need to be holding a LEGENDARY in your mainhand");
          return true;
        } 
      }ArrayList<String> arrayList = new ArrayList();
      label35: for (Player player1 : Bukkit.getOnlinePlayers()) {
        {
          if (player1 == player)
            continue; 
        }byte b = 0;
        while (true) {
          {
            if (b < player1.getInventory().getSize()) {
              {
                if (Main.areSimilar(player1.getInventory().getItem(b), player.getInventory().getItemInMainHand()))
                  arrayList.add(player1.getDisplayName()); 
              }b++;
              continue;
            } 
          }continue label35;
        } 
      } 
      (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cn(this, player, arrayList)).runTaskLater((Plugin)Main.getInstance(), 1L);
    } 
    return true;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764s.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */