package net.kingscraft.zenixmc.altarsmp.legendary;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import org.jetbrains.annotations.NotNull;

public class FindLegendaryItemDuplicatesCommand implements CommandExecutor {

  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, String @NotNull [] paramArrayOfString) {
    if (paramCommandSender instanceof Player player) {
      {
        if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
          player.sendMessage("You need to be holding a legendary in your mainhand");
          return true;
        } 
      }
      {
        if (player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 0) {
          player.sendMessage("You need to be holding a LEGENDARY in your mainhand");
          return true;
        } 
      }
      ArrayList<String> arrayList = new ArrayList<>();
      label35: for (Player player1 : Bukkit.getOnlinePlayers()) {
        {
          if (player1 == player)
            continue; 
        }int b = 0;
        while (true) {
          {
            if (b < player1.getInventory().getSize()) {
              {
                if (AltarSMP.areSimilar(player1.getInventory().getItem(b), player.getInventory().getItemInMainHand()))
                  arrayList.add(player1.getDisplayName()); 
              }b++;
              continue;
            } 
          }continue label35;
        } 
      } 
      (new LegendaryItemDuplicateReportTask(player, arrayList)).runTaskLater(AltarSMP.getInstance(), 1L);
    } 
    return true;
  }


}
