package pl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a8 implements CommandExecutor, TabCompleter {
  public final You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bm You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public final You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764br You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a8(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bm paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bm, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764br paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764br) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bm;
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764br;
  }
  
  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    Player player;
    if (paramCommandSender instanceof Player) {
      player = (Player)paramCommandSender;
    } else {
      paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
      return true;
    } 
    {
      if (paramArrayOfString.length < 1) {
        player.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
        return true;
      } 
    }String str1 = paramArrayOfString[0].toLowerCase();
    {
      if (str1.equals("settings")) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bd.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
        return true;
      } 
    }{
      if (paramArrayOfString.length < 2) {
        player.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
        return true;
      } 
    }String str2 = paramArrayOfString[1];
    {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a().contains(str2)) {
        player.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED) + "Unknown altar type: ");
        return true;
      } 
    }String str3 = str1;
    byte b = -1;
    {
      switch (str3.hashCode()) {
        case 109638523:
          if (str3.equals("spawn"))
            b = 0; 
          break;
        case -934610812:
          if (str3.equals("remove"))
            b = 1; 
          break;
        case 108404047:
          if (str3.equals("reset"))
            b = 2; 
          break;
      } 
    }{
      byte b1;
      switch (b) {
        case 0:
          {
            if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player.getLocation().getBlock().getLocation(), str2)) {
              player.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN));
            } else {
              player.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
            } 
          }return true;
        case 1:
          b1 = 0;
          for (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 : this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(str2)) {
            {
              if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1()))
                b1++; 
            }} 
          player.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + "Removed " + b1);
          return true;
        case 2:
          b1 = 0;
          for (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 : this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(str2)) {
            this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a());
            b1++;
          } 
          player.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + "Reset " + b1);
          return true;
      } 
    }player.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
    return true;
  }
  
  public List<String> onTabComplete(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    ArrayList<String> arrayList = new ArrayList();
    {
      if (paramArrayOfString.length == 1) {
        arrayList.addAll(Arrays.asList(new String[] { "spawn", "remove", "reset", "settings" }));
      } else if (paramArrayOfString.length == 2) {
        String str = paramArrayOfString[1].toUpperCase();
        Objects.requireNonNull(arrayList);
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a().stream().filter(paramTab -> lambda$onTabComplete$0(str, paramTab)).forEach(arrayList::add);
      } 
    }return arrayList;
  }
  
  private static boolean lambda$onTabComplete$0(String paramString1, String paramString2) {
    return paramString2.toUpperCase().startsWith(paramString1);
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a8.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */