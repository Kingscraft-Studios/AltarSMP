package pl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a9 implements CommandExecutor {
  
  
  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    {
      if (paramArrayOfString.length == 0) {
        if (paramCommandSender instanceof Player) {
          Player player1 = (Player)paramCommandSender;
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player1);
          player1.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN));
          player1.setCooldown(Material.CROSSBOW, 1);
        } else {
          paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
        } 
        return true;
      } 
    }Player player = Bukkit.getPlayer(paramArrayOfString[0]);
    {
      if (player != null)
        {
          if (player.isOnline()) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
            player.setCooldown(Material.CROSSBOW, 1);
            paramCommandSender.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + "Cooldowns cleared for " + player.getName());
            return true;
          } 
        }}paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED) + "Player '" + paramArrayOfString[0]);
    return true;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId());
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764at.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.put(paramPlayer.getUniqueId(), Integer.valueOf(0));
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764at.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.get(paramPlayer.getUniqueId()) != null)
        ((BukkitTask)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764at.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.get(paramPlayer.getUniqueId())).cancel(); 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.removeIf(paramBar3 -> lambda$removeAllCooldowns$0(paramPlayer, paramBar3));
  }
  
  private static boolean lambda$removeAllCooldowns$0(Player paramPlayer, BossBar paramBossBar) {
    paramBossBar.removePlayer(paramPlayer);
    return true;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a9.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */