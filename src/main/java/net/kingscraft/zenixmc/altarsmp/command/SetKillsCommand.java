package net.kingscraft.zenixmc.altarsmp.command;

import java.util.List;

import net.kingscraft.zenixmc.altarsmp.altarS2.AltarS2;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import org.jspecify.annotations.NonNull;

public class SetKillsCommand implements CommandExecutor, TabCompleter {

  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String @NonNull [] paramArrayOfString) {
    int i;
    Player player;
    {
      if (paramArrayOfString.length < 2) {
        paramCommandSender.sendMessage(Component.text("/setkills <bloodlust/knightfall/ancientblade> <num> <player>", NamedTextColor.RED));
        return true;
      } 
    }String str = paramArrayOfString[0];
    try {
      i = Integer.parseInt(paramArrayOfString[1]);
    } catch (NumberFormatException numberFormatException) {
      paramCommandSender.sendMessage(Component.text("Invalid number.", NamedTextColor.RED));
      return true;
    } 
    if (paramArrayOfString.length >= 3) {
      player = Bukkit.getPlayer(paramArrayOfString[2]);
      {
        if (player == null) {
          paramCommandSender.sendMessage(Component.text("That player is not online", NamedTextColor.RED));
          return true;
        } 
      }} else {
      Player player1;
      if (paramCommandSender instanceof Player) {
        player1 = (Player)paramCommandSender;
      } else {
        paramCommandSender.sendMessage(Component.text("You must specify a player.", NamedTextColor.RED));
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
            {
              if (str.equalsIgnoreCase("ancientblade")) {
                AltarS2.getKillTracker().setKillCount(player, i);
              } else {
                paramCommandSender.sendMessage(Component.text("/setkills <bloodlust/knightfall/ancientblade> <num> <player>", NamedTextColor.RED));
                return true;
              } 
            }} 
        }} 
    }paramCommandSender.sendMessage(Component.text("Kills updated.", NamedTextColor.GREEN));
    return true;
  }

  @Nullable
  public List<String> onTabComplete(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String @NonNull [] paramArrayOfString) {
    {
      if (paramArrayOfString.length == 3)
        return null; 
    }{
      if (paramArrayOfString.length == 2)
        return List.of("2", "4", "6", "8", "10"); 
    }{
      if (paramArrayOfString.length == 1)
        return List.of("bloodlust", "knightfall", "ancientblade");
    }return List.of();
  }


}
