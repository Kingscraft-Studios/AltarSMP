package pl;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764q implements CommandExecutor {
   final Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
   private static final String[] a;
   private static final String[] b;

   You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764q(Main var1) {
      this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = var1;
   }

   public boolean onCommand(CommandSender var1, Command var2, String var3, String[] var4) {
      if (!(var1 instanceof Player var5)) {
         var1.sendMessage(ChatColor.RED + "Only players can use this command.");
         return true;
      } else {
         Boolean var6 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a
            .getConfig()
            .getBoolean("offhand." + var5.getName(), true);
         this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().set("offhand." + var5.getName(), !var6);
         this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.saveConfig();
         if (!var6) {
            var5.sendMessage(ChatColor.GRAY + "Turned on Offhand to use ability");
         } else {
            var5.sendMessage(ChatColor.GRAY + "Turned off Offhand to use ability");
         }

         return true;
      }
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   static {
      a = new String[0];
      b = new String[0];
   }

}
