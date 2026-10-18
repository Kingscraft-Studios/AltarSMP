package net.kingscraft.zenixmc.altarsmp.command;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class SetKillsCommand implements CommandExecutor, TabCompleter {
  
  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String[] paramArrayOfString) {
    int i;
    Player player;
    {
      if (paramArrayOfString.length < 2) {
        paramCommandSender.sendMessage("§c/setkills <bloodlust/knightfall> <num> <player>");
        return true;
      } 
    }String str = paramArrayOfString[0];
    try {
      i = Integer.parseInt(paramArrayOfString[1]);
    } catch (NumberFormatException numberFormatException) {
      paramCommandSender.sendMessage("§cInvalid number.");
      return true;
    } 
    if (paramArrayOfString.length >= 3) {
      player = Bukkit.getPlayer(paramArrayOfString[2]);
      {
        if (player == null) {
          paramCommandSender.sendMessage("§cThat player is not online");
          return true;
        } 
      }} else {
      Player player1;
      if (paramCommandSender instanceof Player) {
        player1 = (Player)paramCommandSender;
      } else {
        paramCommandSender.sendMessage("§cYou must specify a player.");
        return true;
      } 
      player = player1;
    } 
    {
      if (str.equalsIgnoreCase("bloodlust")) {
        (AltarSMP.getInstance()).bloodLustKillTracker.setKillCount(player, i);
      } else {
        {
          if (str.equalsIgnoreCase("knightfall")) {
            (AltarSMP.getInstance()).knightFallKillTracker.setKillCount(player, i);
          } else {
            paramCommandSender.sendMessage("§c/setkills <bloodlust/knightfall> <num> <player>");
            return true;
          } 
        }} 
    }paramCommandSender.sendMessage("§aKills updated.");
    return true;
  }
  
  @Nullable
  public List<String> onTabComplete(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String[] paramArrayOfString) {
    {
      if (paramArrayOfString.length == 3)
        return null; 
    }{
      if (paramArrayOfString.length == 2)
        return List.of("2", "4", "6", "8", "10"); 
    }{
      if (paramArrayOfString.length == 1)
        return List.of("bloodlust", "knightfall"); 
    }return List.of();
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ba.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */