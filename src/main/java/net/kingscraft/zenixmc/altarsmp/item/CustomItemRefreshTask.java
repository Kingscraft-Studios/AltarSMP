package net.kingscraft.zenixmc.altarsmp.item;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.illusion.IllusionWandAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.frostscythe.FrostScytheAbilityListener;

public class CustomItemRefreshTask extends BukkitRunnable {
  public final Player player;

  public CustomItemRefreshTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    for (int b = 0; b < this.player.getInventory().getSize(); b++) {
      ItemStack itemStack = this.player.getInventory().getItem(b);
      if (itemStack != null)
        {
          if (FrostScytheAbilityListener.isFrostScythe(itemStack)) {
            this.player.getInventory().setItem(b, CustomItemRegistry.getFrostScythe());
          } else {
            if (IllusionWandAbility.isIllusionWand(itemStack))
              this.player.getInventory().setItem(b, CustomItemRegistry.getIllusionWand());

          } 
        }  

    } 
  }

}
