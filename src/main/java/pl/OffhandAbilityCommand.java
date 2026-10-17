package pl;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

class OffhandAbilityCommand implements CommandExecutor {
   final Main plugin;
   OffhandAbilityCommand(Main var1) {
      this.plugin = var1;
   }

   public boolean onCommand(CommandSender var1, Command var2, String var3, String[] var4) {
      if (!(var1 instanceof Player var5)) {
         var1.sendMessage(ChatColor.RED + "Only players can use this command.");
         return true;
      } else {
         Boolean var6 = this.plugin
            .getConfig()
            .getBoolean("offhand." + var5.getName(), true);
         this.plugin.getConfig().set("offhand." + var5.getName(), !var6);
         this.plugin.saveConfig();
         if (!var6) {
            var5.sendMessage(ChatColor.GRAY + "Turned on Offhand to use ability");
         } else {
            var5.sendMessage(ChatColor.GRAY + "Turned off Offhand to use ability");
         }

         return true;
      }
   }

}
