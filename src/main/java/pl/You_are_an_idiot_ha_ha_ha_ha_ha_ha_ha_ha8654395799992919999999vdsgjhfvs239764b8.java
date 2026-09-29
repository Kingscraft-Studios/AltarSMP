package pl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b8 implements CommandExecutor {
  private final You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9 You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b8(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9 paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9;
  }
  
  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    {
      if (!(paramCommandSender instanceof Player)) {
        paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
        return true;
      } 
    }Player player1 = (Player)paramCommandSender;
    {
      if (paramArrayOfString.length == 1)
        {
          if (paramArrayOfString[0].equalsIgnoreCase("reload")) {
            paramCommandSender.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN));
            return true;
          } 
        }}{
      if (paramArrayOfString.length != 1) {
        player1.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED) + "Usage: /" + paramString);
        return true;
      } 
    }Player player2 = Bukkit.getPlayer(paramArrayOfString[0]);
    {
      if (player2 == null) {
        player1.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
        return true;
      } 
    }{
      if (paramString.equalsIgnoreCase("trust")) {
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player1, player2)) {
            player1.sendMessage(String.valueOf(ChatColor.YELLOW) + String.valueOf(ChatColor.YELLOW) + player2.getName());
          } else {
            this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player1, player2);
            player1.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + "You have trusted " + player2.getName());
          } 
        }} else {
        {
          if (paramString.equalsIgnoreCase("untrust"))
            {
              if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player1, player2)) {
                player1.sendMessage(String.valueOf(ChatColor.YELLOW) + String.valueOf(ChatColor.YELLOW) + player2.getName());
              } else {
                this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player1, player2);
                player1.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED) + "You have untrusted " + player2.getName());
              } 
            }}} 
    }return true;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b8.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */