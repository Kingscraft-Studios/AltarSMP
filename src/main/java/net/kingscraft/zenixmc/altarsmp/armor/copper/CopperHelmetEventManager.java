package net.kingscraft.zenixmc.altarsmp.armor.copper;

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
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;

public class CopperHelmetEventManager implements CommandExecutor, Listener {
  public int eventCounter = 0;

  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String[] paramArrayOfString) {
    Player player;
    if (paramCommandSender instanceof Player) {
      player = (Player)paramCommandSender;
    } else {
      return true;
    } 
    startHelmetEvent();
    player.sendMessage(String.valueOf(ChatColor.GREEN) + "You have started the Copper Helmet event, 5 random players will get the Helmet Fragment which is needed for copper helmet altar");
    player.sendMessage(String.valueOf(ChatColor.GOLD) + "Use /altar spawn copperhelmet to spawn the altar for copper helmet");
    return false;
  }

  public void startHelmetEvent() {
    int i = AltarSMP.getInstance().getConfig().getInt("helmetEventAnnouncePeriod", 60);
    int j = AltarSMP.getInstance().getConfig().getInt("helmetEventFragmentGivePeriod", 30);
    Random random = new Random();
    (new CopperHelmetFragmentTask(this)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, (j * 20));
    (new CopperHelmetFragmentAnnouncementTask(this)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, (i * 20));
  }

  public String getWorldDisplayName(World paramWorld) {
    String str = paramWorld.getName();
    int b = -1;
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

  public boolean isHelmetFragment(ItemStack paramItemStack) {
    return AltarSMP.areSimilar(paramItemStack, CustomItemRegistry.getHelmetShard());
  }


}
