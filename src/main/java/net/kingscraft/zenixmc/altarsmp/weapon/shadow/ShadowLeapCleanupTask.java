package net.kingscraft.zenixmc.altarsmp.weapon.shadow;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class ShadowLeapCleanupTask extends BukkitRunnable {
  public final Player player;

  private static final String a = "shadowBladeBorderLogic";
  
  public ShadowLeapCleanupTask(Player paramPlayer) {
        this.player = paramPlayer;
    }
  
  public void run() {
    if (ShadowBladeAbility.leapLocations.containsKey(this.player.getUniqueId())) {
      for (Player player : Bukkit.getOnlinePlayers()) {
        try {
          if (!player.equals(this.player))
            player.showPlayer((Plugin)AltarSMP.getInstance(), this.player);
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } 
      try {
        this.player.removePotionEffect(PotionEffectType.INVISIBILITY);
        if (AltarSMP.getInstance().getConfig().getBoolean(a, true))
          this.player.setWorldBorder(null);
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e_.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */