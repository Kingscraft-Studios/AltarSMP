package net.kingscraft.zenixmc.altarsmp.event.crazy;

import java.util.List;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

class CrazyRandomizerAnimationTask extends BukkitRunnable {
  public int ticksRemaining;

  public final List<ItemDisplay> itemDisplays;

  public final Player player;

  public final World originalWorld;

  public final List<ItemStack> randomizerItems;

  public final int selectedItemIndex;

  public CrazyRandomizerAnimationTask(List<ItemDisplay> paramList1, Player paramPlayer, World paramWorld, List<ItemStack> paramList2, int paramInt) {
        this.itemDisplays = paramList1;
        this.player = paramPlayer;
        this.originalWorld = paramWorld;
        this.randomizerItems = paramList2;
        this.selectedItemIndex = paramInt;
        this.ticksRemaining = 35;
    }

  public void run() {
    if (this.ticksRemaining < 0) {
      for (ItemDisplay itemDisplay : this.itemDisplays)
        CrazyRandomizerListener.shrinkItemDisplay(itemDisplay);
      if (this.player.getWorld() == this.originalWorld) {
        this.player.getInventory().addItem(this.randomizerItems.get(this.selectedItemIndex));
        this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
        this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
      } 

      cancel();
      return;
    } 
    for (ItemDisplay itemDisplay : this.itemDisplays) {
      itemDisplay.setTeleportDuration(2);
      itemDisplay.setRotation((this.ticksRemaining * 10), 0.0F);
    } 
    this.ticksRemaining--;
  }

}
