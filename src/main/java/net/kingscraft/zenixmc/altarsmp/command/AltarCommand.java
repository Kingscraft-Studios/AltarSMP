package net.kingscraft.zenixmc.altarsmp.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import net.kingscraft.zenixmc.altarsmp.altar.AltarController;
import net.kingscraft.zenixmc.altarsmp.altar.AltarInstance;
import net.kingscraft.zenixmc.altarsmp.altar.AltarManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kingscraft.zenixmc.altarsmp.menu.LegendaryItemConfigMenu;

public record AltarCommand(AltarController altarController, AltarManager altarManager) implements CommandExecutor, TabCompleter {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player player)) {
      sender.sendMessage(Component.text("Only players can use this command!", NamedTextColor.RED));
      return true;
    }

    if (args.length < 1) {
      player.sendMessage(Component.text("Usage: /altar <spawn|remove|reset|settings> <type>", NamedTextColor.RED));
      return true;
    }

    String action = args[0].toLowerCase();

    // Settings does not require a second argument
    if (action.equals("settings")) {
      LegendaryItemConfigMenu.openConfigMenu(player);
      return true;
    }

    // All other actions require a type argument
    if (args.length < 2) {
      player.sendMessage(Component.text("Usage: /altar <spawn|remove|reset> <type>", NamedTextColor.RED));
      return true;
    }

    String altarType = args[1];

    if (!this.altarManager.getAltarNames().contains(altarType)) {
      player.sendMessage(Component.text("Unknown altar type: " + altarType, NamedTextColor.RED));
      return true;
    }

    return switch (action) {
      case "spawn" -> {
        boolean success = this.altarController.createAltar(player.getLocation().getBlock().getLocation(), altarType);
        if (success) {
          player.sendMessage(Component.text("Altar spawned!", NamedTextColor.GREEN));
        } else {
          player.sendMessage(Component.text("Failed to spawn altar!", NamedTextColor.RED));
        }
        yield true;
      }
      case "remove" -> {
        int removedCount = 0;
        for (AltarInstance altarInstance : this.altarController.getAltarsByType(altarType)) {
          if (this.altarController.removeAltar(altarInstance.getLocation())) {
            removedCount++;
          }
        }
        player.sendMessage(Component.text("Removed " + removedCount + " altar(s).", NamedTextColor.GREEN));
        yield true;
      }
      case "reset" -> {
        int resetCount = this.altarController.getAltarsByType(altarType).size();
        // Note: If you have a specific reset method in your controller, call it here instead.
        // e.g., this.altarController.resetAltars(altarType);

        player.sendMessage(Component.text("Reset " + resetCount + " altar(s).", NamedTextColor.GREEN));
        yield true;
      }
      default -> {
        player.sendMessage(Component.text("Usage: /altar <spawn|remove|reset> <type>", NamedTextColor.RED));
        yield true;
      }
    };
  }

  public List<String> onTabComplete(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    ArrayList<String> arrayList = new ArrayList<>();
    {
      if (paramArrayOfString.length == 1) {
        arrayList.addAll(Arrays.asList("spawn", "remove", "reset", "settings"));
      } else if (paramArrayOfString.length == 2) {
        String str = paramArrayOfString[1].toUpperCase();
        Objects.requireNonNull(arrayList);
        this.altarManager.getAltarNames().stream().filter(paramTab -> isValidTab(str, paramTab)).forEach(arrayList::add);
      }
    }
    return arrayList;
  }

  public static boolean isValidTab(String paramString1, String paramString2) {
    return paramString2.toUpperCase().startsWith(paramString1);
  }

}
