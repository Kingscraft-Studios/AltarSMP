package net.kingscraft.zenixmc.altarsmp.copper.helmet;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import org.jspecify.annotations.NonNull;

public class CopperHelmetEventManager implements CommandExecutor, Listener {
  public int eventCounter = 0;

  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String @NonNull [] paramArrayOfString) {
    Player player;
    if (paramCommandSender instanceof Player) {
      player = (Player)paramCommandSender;
    } else {
      return true;
    } 
    startHelmetEvent();
    player.sendMessage(Component.text("You have started the Copper Helmet event, 5 random players will get the Helmet Fragment which is needed for copper helmet altar", NamedTextColor.GREEN));
    player.sendMessage(Component.text("Use /altar spawn copperhelmet to spawn the altar for copper helmet", NamedTextColor.GOLD));
    return false;
  }

  public void startHelmetEvent() {
    int i = AltarSMP.getInstance().getConfig().getInt("helmetEventAnnouncePeriod", 60);
    int j = AltarSMP.getInstance().getConfig().getInt("helmetEventFragmentGivePeriod", 30);
    (new CopperHelmetFragmentTask(this)).runTaskTimer(AltarSMP.getInstance(), 0L, (j * 20L));
    (new CopperHelmetFragmentAnnouncementTask(this)).runTaskTimer(AltarSMP.getInstance(), 0L, (i * 20L));
  }

  public String getWorldDisplayName(World paramWorld) {
    return switch (paramWorld.getName()) {
      case "world" -> "Overworld";
      case "world_nether" -> "Nether";
      case "world_the_end" -> "End";
      default -> paramWorld.getName();
    };
  }

  public boolean isHelmetFragment(ItemStack paramItemStack) {
    return AltarSMP.areSimilar(paramItemStack, CustomItemRegistry.getHelmetShard());
  }


}
