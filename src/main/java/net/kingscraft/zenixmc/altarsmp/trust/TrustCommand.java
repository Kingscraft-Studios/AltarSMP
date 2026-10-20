package net.kingscraft.zenixmc.altarsmp.trust;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class TrustCommand implements CommandExecutor {
  public final TrustManager trustManager;

  public TrustCommand(TrustManager trustManager) {
    this.trustManager = trustManager;
  }

  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    {
      if (!(paramCommandSender instanceof Player)) {
        paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + "Only players can use this command.");
        return true;
      } 
    }Player player1 = (Player)paramCommandSender;
    {
      if (paramArrayOfString.length == 1)
        {
          if (paramArrayOfString[0].equalsIgnoreCase("reload")) {
            paramCommandSender.sendMessage(String.valueOf(ChatColor.GREEN) + "Trust configuration reloaded successfully.");
            return true;
          } 
        }}{
      if (paramArrayOfString.length != 1) {
        player1.sendMessage(String.valueOf(ChatColor.RED) + "Usage: /" + paramString + " <player>");
        return true;
      } 
    }Player player2 = Bukkit.getPlayer(paramArrayOfString[0]);
    {
      if (player2 == null) {
        player1.sendMessage(String.valueOf(ChatColor.RED) + "Player not found.");
        return true;
      } 
    }{
      if (paramString.equalsIgnoreCase("trust")) {
        {
          if (TrustManager.isTrusted(player1, player2)) {
            player1.sendMessage(String.valueOf(ChatColor.YELLOW) + player2.getName() + " is already trusted.");
          } else {
            this.trustManager.addTrust(player1, player2);
            player1.sendMessage(String.valueOf(ChatColor.GREEN) + "You have trusted " + player2.getName() + ".");
          } 
        }} else {
        {
          if (paramString.equalsIgnoreCase("untrust"))
            {
              if (!TrustManager.isTrusted(player1, player2)) {
                player1.sendMessage(String.valueOf(ChatColor.YELLOW) + player2.getName() + " is not trusted.");
              } else {
                this.trustManager.removeTrust(player1, player2);
                player1.sendMessage(String.valueOf(ChatColor.RED) + "You have untrusted " + player2.getName() + ".");
              } 
            }}} 
    }
    return true;
  }


}
