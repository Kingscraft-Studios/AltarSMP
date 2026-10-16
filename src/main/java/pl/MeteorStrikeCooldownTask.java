package pl;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class MeteorStrikeCooldownTask extends BukkitRunnable {
  final Player player;
  
  MeteorStrikeCooldownTask(Player paramPlayer) {
        this.player = paramPlayer;
    }
  
  public void run() {
    {
      if (CooldownManager.isOnCooldown(this.player.getUniqueId(), "used_meteor")) {
        BossBarManager.createBar(this.player, "Meteor Strike", EarthGauntletAbility.meteorStrikeCooldown, ChatColor.YELLOW);
        CooldownManager.setCooldown(this.player.getUniqueId(), EarthGauntletAbility.meteorStrikeCooldownKey, EarthGauntletAbility.meteorStrikeCooldown);
      } 
    }}
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cq.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */