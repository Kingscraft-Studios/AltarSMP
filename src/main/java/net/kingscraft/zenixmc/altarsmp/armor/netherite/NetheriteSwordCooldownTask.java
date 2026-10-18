package net.kingscraft.zenixmc.altarsmp.armor.netherite;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class NetheriteSwordCooldownTask extends BukkitRunnable {
  public final Player player;
  
  public NetheriteSwordCooldownTask(Player paramPlayer) {
        this.player = paramPlayer;
    }
  
  public void run() {
    try {
      if (!this.player.isOnline()) {
        cancel();
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.player.setCooldown(Material.NETHERITE_SWORD, 100);
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gs.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */