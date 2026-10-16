package pl;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class NetheriteChestplateComboDamageTask extends BukkitRunnable {
  final LivingEntity target;
  
  final Player attacker;
  
  NetheriteChestplateComboDamageTask(NetheriteChestplateComboAbility netheriteChestplateComboAbility, LivingEntity paramLivingEntity, Player paramPlayer) {
        this.target = paramLivingEntity;
        this.attacker = paramPlayer;
    }
  
  public void run() {
    try {
      if (this.target.isValid())
        try {
          if (!this.target.isDead())
            TrueDamage.apply(this.target, NetheriteChestplateComboAbility.MAX_DAMAGE, this.attacker);
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f_.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */