package pl;

import java.util.List;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

class CrazyRandomizerAnimationTask extends BukkitRunnable {
  int ticksRemaining;
  
  final List itemDisplays;
  
  final Player player;
  
  final World originalWorld;
  
  final List randomizerItems;
  
  final int selectedItemIndex;
  
  CrazyRandomizerAnimationTask(List paramList1, Player paramPlayer, World paramWorld, List paramList2, int paramInt) {
        this.itemDisplays = paramList1;
        this.player = paramPlayer;
        this.originalWorld = paramWorld;
        this.randomizerItems = paramList2;
        this.selectedItemIndex = paramInt;
        this.ticksRemaining = 35;
    }
  
  public void run() {
    if (this.ticksRemaining < 0) {
      for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.itemDisplays)
        CrazyRandomizerListener.shrinkItemDisplay(itemDisplay);
      try {
        if (this.player.getWorld() == this.originalWorld) {
          this.player.getInventory().addItem(new ItemStack[] { (ItemStack)this.randomizerItems.get(this.selectedItemIndex) });
          this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
          this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      cancel();
      return;
    } 
    for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.itemDisplays) {
      itemDisplay.setTeleportDuration(2);
      itemDisplay.setRotation((this.ticksRemaining * 10), 0.0F);
    } 
    this.ticksRemaining--;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hg.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */