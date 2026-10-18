package net.kingscraft.zenixmc.altarsmp.illusion;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class IllusionWandChargeTask extends BukkitRunnable {
  final int chargeDurationTicks = AltarSMP.getInstance().getConfig().getInt(CHARGE_DURATION_CONFIG_KEY, 1) * 20;
  
  public int chargeTicks;
  
  public final Player player;
  
  private static final String CHARGE_DURATION_CONFIG_KEY = "IllusionWandChargeDuration";
  
  public IllusionWandChargeTask(IllusionWandAbility illusionWandAbility, Player paramPlayer) {
        this.player = paramPlayer;
        this.chargeTicks = 0;
    }
  
  public void run() {
    try {
      if (this.player.isHandRaised())
        try {
          if (this.chargeTicks < this.chargeDurationTicks) {
            try {
              if (this.chargeTicks == 0)
                this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_WARDEN_SONIC_CHARGE, 1.0F, 1.0F);
            } catch (MatchException matchException) {
              throw a(null);
            } 
            this.chargeTicks++;
            return;
          } 
          this.player.stopSound(Sound.ENTITY_WARDEN_SONIC_CHARGE);
          cancel();
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.player.stopSound(Sound.ENTITY_WARDEN_SONIC_CHARGE);
    cancel();
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dj.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */