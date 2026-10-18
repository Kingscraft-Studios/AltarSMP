package net.kingscraft.zenixmc.altarsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.event.crazy.CrazyRandomizerListener;

public class GiveRandomizerCommand implements CommandExecutor {
  private static final String SKIP = "Player not found or not online.";

  public GiveRandomizerCommand(CrazyRandomizerListener crazyRandomizerListener) {}

  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    Player player;
    if (paramArrayOfString.length == 0) {
      player = (Player)paramCommandSender;
    } else {
      player = Bukkit.getPlayer(paramArrayOfString[0]);
    } 
    if (player != null)
      {
        if (player.isOnline()) {
          player.getInventory().addItem(CrazyRandomizerListener.createCrazyRandomizerItem());
          return true;
        } 
        paramCommandSender.sendMessage(ChatColor.RED + SKIP);
        return true;
      }  

    paramCommandSender.sendMessage(ChatColor.RED + SKIP);
    return true;
  }


}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cg.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */