package pl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

class GiveRandomizerCommand implements CommandExecutor {
  private static final String SKIP = "Player not found or not online.";
  
  GiveRandomizerCommand(CrazyRandomizerListener crazyRandomizerListener) {}
  
  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    Player player;
    if (paramArrayOfString.length == 0) {
      player = (Player)paramCommandSender;
    } else {
      player = Bukkit.getPlayer(paramArrayOfString[0]);
    } 
    try {
      if (player != null)
        try {
          if (player.isOnline()) {
            player.getInventory().addItem(CrazyRandomizerListener.createCrazyRandomizerItem());
            return true;
          } 
          paramCommandSender.sendMessage(ChatColor.RED + SKIP);
          return true;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramCommandSender.sendMessage(ChatColor.RED + SKIP);
    return true;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cg.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */