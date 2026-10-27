package net.kingscraft.zenixmc.altarsmp.copper.pickaxe;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

class CopperOreVeinMinerStatusTask extends BukkitRunnable {
  public final CopperPickaxeListener veinMinerListener;

  public CopperOreVeinMinerStatusTask(CopperPickaxeListener copperPickaxeListener) {
        this.veinMinerListener = copperPickaxeListener;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (CopperPickaxeListener.isCopperPickaxe(player)) {
        UUID uUID = player.getUniqueId();
        boolean bool = this.veinMinerListener.veinMinerEnabled.getOrDefault(uUID, true);
        {
          if (bool) {
            player.sendActionBar(Component.text()
                .append(Component.text("3x3 Mining: ", NamedTextColor.GOLD))
                .append(Component.text("Enabled", NamedTextColor.GREEN))
                .build());
            continue;
          } 
        }player.sendActionBar(Component.text()
            .append(Component.text("3x3 Mining: ", NamedTextColor.GOLD))
            .append(Component.text("Disabled", NamedTextColor.RED))
            .build());
      } 
    } 
  }



}
