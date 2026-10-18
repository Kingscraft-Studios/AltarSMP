package net.kingscraft.zenixmc.altarsmp.weapon.cutlass;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;

public class CutlassParryActivationTask extends BukkitRunnable {
  public final Player player;
  
  private static final String ACTIVE_PARRY_COOLDOWN_KEY = "active_parry";
  
  public CutlassParryActivationTask(Player paramPlayer) {
        this.player = paramPlayer;
    }
  
  public void run() {
    try {
      if (CooldownManager.isOnCooldown(this.player.getUniqueId(), ACTIVE_PARRY_COOLDOWN_KEY))
        CutlassAbility.activateParry(this.player);
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cr.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */