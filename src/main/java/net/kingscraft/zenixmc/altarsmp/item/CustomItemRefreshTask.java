package net.kingscraft.zenixmc.altarsmp.item;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.illusion.IllusionWandAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.frostscythe.FrostScytheAbilityListener;

public class CustomItemRefreshTask extends BukkitRunnable {
  public final Player player;
  
  public CustomItemRefreshTask(AltarSMP paramAltarSMP, Player paramPlayer) {
        this.player = paramPlayer;
    }
  
  public void run() {
    for (int b = 0; b < this.player.getInventory().getSize(); b++) {
      ItemStack itemStack = this.player.getInventory().getItem(b);
      try {
        if (itemStack != null)
          try {
            if (FrostScytheAbilityListener.isFrostScythe(itemStack)) {
              this.player.getInventory().setItem(b, CustomItemRegistry.getFrostScythe());
            } else {
              try {
                if (IllusionWandAbility.isIllusionWand(itemStack))
                  this.player.getInventory().setItem(b, CustomItemRegistry.getIllusionWand());
              } catch (MatchException matchException) {
                throw a(null);
              } 
            } 
          } catch (MatchException matchException) {
            throw a(null);
          }  
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cp.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */