package net.kingscraft.zenixmc.altarsmp.command;

import net.kingscraft.zenixmc.altarsmp.core.TrustManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TrustCommand implements CommandExecutor {
  public final TrustManager trustManager;

  public TrustCommand(TrustManager trustManager) {
    this.trustManager = trustManager;
  }

  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, String @NotNull [] paramArrayOfString) {
    {
      if (!(paramCommandSender instanceof Player)) {
        paramCommandSender.sendMessage(Component.text("Only players can use this command.", NamedTextColor.RED));
        return true;
      }
    }Player player1 = (Player)paramCommandSender;
    {
      if (paramArrayOfString.length == 1)
      {
        if (paramArrayOfString[0].equalsIgnoreCase("reload")) {
          paramCommandSender.sendMessage(Component.text("Trust configuration reloaded successfully.", NamedTextColor.GREEN));
          return true;
        }
      }}{
      if (paramArrayOfString.length != 1) {
        player1.sendMessage(Component.text("Usage: /" + paramString + " <player>", NamedTextColor.RED));
        return true;
      }
    }Player player2 = Bukkit.getPlayer(paramArrayOfString[0]);
    {
      if (player2 == null) {
        player1.sendMessage(Component.text("Player not found.", NamedTextColor.RED));
        return true;
      }
    }{
      if (paramString.equalsIgnoreCase("trust")) {
        {
          if (TrustManager.isTrusted(player1, player2)) {
            player1.sendMessage(Component.text(player2.getName() + " is already trusted.", NamedTextColor.YELLOW));
          } else {
            this.trustManager.addTrust(player1, player2);
            player1.sendMessage(Component.text("You have trusted " + player2.getName() + ".", NamedTextColor.GREEN));
          }
        }} else {
        {
          if (paramString.equalsIgnoreCase("untrust"))
          {
            if (!TrustManager.isTrusted(player1, player2)) {
              player1.sendMessage(Component.text(player2.getName() + " is not trusted.", NamedTextColor.YELLOW));
            } else {
              this.trustManager.removeTrust(player1, player2);
              player1.sendMessage(Component.text("You have untrusted " + player2.getName() + ".", NamedTextColor.RED));
            }
          }}}
    }
    return true;
  }


}
