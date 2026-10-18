package net.kingscraft.zenixmc.altarsmp.altar;

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
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.legendary.LegendaryItemConfigMenu;

public class AltarCommand implements CommandExecutor, TabCompleter {
  public final AltarController altarController;

  public final AltarManager altarManager;

  public AltarCommand(AltarController altarController, AltarManager altarManager) {
    this.altarController = altarController;
    this.altarManager = altarManager;
  }

  @Override
  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    Player player;
    if (paramCommandSender instanceof Player) {
      player = (Player)paramCommandSender;
    } else {
      paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + "Only players can use this command!");
      return true;
    } 
    {
      if (paramArrayOfString.length < 1) {
        player.sendMessage(String.valueOf(ChatColor.RED) + "Usage: /altar <spawn|remove|reset|settings> <type>");
        return true;
      } 
    }String str1 = paramArrayOfString[0].toLowerCase();
    {
      if (str1.equals("settings")) {
        LegendaryItemConfigMenu.openConfigMenu(player);
        return true;
      } 
    }{
      if (paramArrayOfString.length < 2) {
        player.sendMessage(String.valueOf(ChatColor.RED) + "Usage: /altar <spawn|remove|reset> <type>");
        return true;
      } 
    }String str2 = paramArrayOfString[1];
    {
      if (!this.altarManager.getAltarNames().contains(str2)) {
    player.sendMessage(String.valueOf(ChatColor.RED) + "Unknown altar type: " + str2);
        return true;
      } 
    }String str3 = str1;
    int b = -1;
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
      switch (b) {
        case 0:
          {
            if (this.altarController.createAltar(player.getLocation().getBlock().getLocation(), str2)) {
              player.sendMessage(String.valueOf(ChatColor.GREEN) + "Altar spawned!");
            } else {
              player.sendMessage(String.valueOf(ChatColor.RED) + "Failed to spawn altar!");
            } 
          }return true;
        case 1:
          {
          int b1 = 0;
          for (AltarInstance altarInstance : this.altarController.getAltarsByType(str2)) {
            {
              if (this.altarController.removeAltar(altarInstance.getLocation()))
                b1++; 
            }} 
          player.sendMessage(String.valueOf(ChatColor.GREEN) + "Removed " + b1 + " altar(s).");
          return true;
          }
        case 2:
          {
          int b1 = 0;
          for (AltarInstance altarInstance : this.altarController.getAltarsByType(str2)) {
            this.altarController.getAltarsByType(altarInstance.getType());
            b1++;
          } 
          player.sendMessage(String.valueOf(ChatColor.GREEN) + "Reset " + b1 + " altar(s).");
          return true;
          }
      } 
    }player.sendMessage(String.valueOf(ChatColor.RED) + "Usage: /altar <spawn|remove|reset> <type>");
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
        // Changed the method reference name to avoid collision
        this.altarManager.getAltarNames().stream().filter(paramTab -> isValidTab(str, paramTab)).forEach(arrayList::add);
      }
    }return arrayList;
  }

  public static boolean isValidTab(String paramString1, String paramString2) {
    return paramString2.toUpperCase().startsWith(paramString1);
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a8.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */