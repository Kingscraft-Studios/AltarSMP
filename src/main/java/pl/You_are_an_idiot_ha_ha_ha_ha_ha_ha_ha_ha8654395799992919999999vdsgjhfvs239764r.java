package pl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764r implements CommandExecutor {
  
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764r(Main paramMain) {}
  
  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    {
      if (paramArrayOfString.length < 1) {
        paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
        return true;
      } 
    }Player player = Bukkit.getPlayer(paramArrayOfString[0]);
    {
      if (player != null)
        {
          if (player.isOnline()) {
            player.getInventory().addItem(new ItemStack[] { You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() });
            return true;
          } 
          paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
          return true;
        }}paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
    return true;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764r.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */