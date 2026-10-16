package pl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

class ShadowLeapReturnTask extends BukkitRunnable {
  final Player player;
  
  final Location targetLocation;
  
  ShadowLeapReturnTask(ShadowBladeAbility shadowBladeAbility, Player paramPlayer, Location paramLocation) {
        this.player = paramPlayer;
        this.targetLocation = paramLocation;
    }
  
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      try {
        if (!player.equals(this.player))
          player.showPlayer((Plugin)Main.getInstance(), this.player);
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
    this.player.removePotionEffect(PotionEffectType.INVISIBILITY);
    this.player.teleport(this.targetLocation);
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fb.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */