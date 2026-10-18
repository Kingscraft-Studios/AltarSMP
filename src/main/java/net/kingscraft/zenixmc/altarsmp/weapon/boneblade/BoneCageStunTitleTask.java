package net.kingscraft.zenixmc.altarsmp.weapon.boneblade;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class BoneCageStunTitleTask extends BukkitRunnable {
  public final LivingEntity target;
  
  private static final String STUNNED_MESSAGE = "Stunned!";
  
  public BoneCageStunTitleTask(LivingEntity paramLivingEntity) {
        this.target = paramLivingEntity;
    }
  
  public void run() {
    try {
      if (!BoneBladeAbility.boneCageDisplays.containsKey(this.target)) {
        cancel();
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    if (this.target instanceof Player) {
      Player player = (Player)this.target;
      player.sendTitle("", String.valueOf(ChatColor.YELLOW) + STUNNED_MESSAGE, 0, 10, 0);
    } 
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c7.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */