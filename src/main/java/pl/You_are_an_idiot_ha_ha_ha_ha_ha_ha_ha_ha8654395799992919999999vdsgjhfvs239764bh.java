package pl;

import java.util.Random;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh implements CommandExecutor, Listener {
  public int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = 0;
  
  
  
  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String[] paramArrayOfString) {
    Player player;
    if (paramCommandSender instanceof Player) {
      player = (Player)paramCommandSender;
    } else {
      return true;
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    player.sendMessage(String.valueOf(ChatColor.GREEN) + "You have started the Copper Helmet event, 5 random players will get the Helmet Fragment which is needed for copper helmet altar");
    player.sendMessage(String.valueOf(ChatColor.GOLD) + "Use /altar spawn copperhelmet to spawn the altar for copper helmet");
    return false;
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    int i = Main.getInstance().getConfig().getInt("helmetEventAnnouncePeriod", 60);
    int j = Main.getInstance().getConfig().getInt("helmetEventFragmentGivePeriod", 30);
    Random random = new Random();
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gf(this)).runTaskTimer((Plugin)Main.getInstance(), 0L, (j * 20));
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gg(this)).runTaskTimer((Plugin)Main.getInstance(), 0L, (i * 20));
  }
  
  public String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(World paramWorld) {
    String str = paramWorld.getName();
    byte b = -1;
    {
      switch (str.hashCode()) {
        case 113318802:
          if (str.equals("world"))
            b = 0; 
          break;
        case 1865466277:
          if (str.equals("world_nether"))
            b = 1; 
          break;
        case -1198266272:
          if (str.equals("world_the_end"))
            b = 2; 
          break;
      } 
    }{
      switch (b) {
        case 0:
          return "Overworld";
        case 1:
          return "Nether";
        case 2:
          return "End";
      } 
    }return paramWorld.getName();
  }
  
  public boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ItemStack paramItemStack) {
    return Main.areSimilar(paramItemStack, CustomItemRegistry.getHelmetShard());
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */