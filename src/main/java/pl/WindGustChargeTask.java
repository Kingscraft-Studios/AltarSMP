package pl;

import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class WindGustChargeTask extends BukkitRunnable {
  int chargeTicks;
  
  final int MAX_CHARGE_LEVEL = 7;
  
  final int TICKS_PER_CHARGE_LEVEL = 20;
  
  final int MAX_CHARGE_TICKS = 140;
  
  final UUID playerId;
  
  final Player player;
  
  
  
  WindGustChargeTask(UUID paramUUID, Player paramPlayer) {
        this.playerId = paramUUID;
        this.player = paramPlayer;
        this.chargeTicks = 0;
    }
  
  public void run() {
    {
      if (!((Boolean) WindweaverAbility.isCharging.getOrDefault(this.playerId, Boolean.valueOf(false))).booleanValue()) {
        finishCharging();
        return;
      } 
    }{
      if (this.chargeTicks > 600) {
        WindweaverAbility.cancelWindGustCharge(this.player);
        BossBarManager.removeBar(this.player, "Charging");
        finishCharging();
        return;
      } 
    }{
      if (this.player.isSneaking()) {
        if (this.chargeTicks < 140) {
          this.chargeTicks++;
          int i = this.chargeTicks / 20;
          WindweaverAbility.gustChargeLevels.put(this.playerId, Integer.valueOf(i));
          double d = i / 7.0D;
          BossBarManager.createBar(this.player, "Charging", 7, ChatColor.WHITE, BarColor.WHITE);
        } 
      } else {
        WindweaverAbility.cancelWindGustCharge(this.player);
        BossBarManager.removeBar(this.player, "Charging");
        finishCharging();
      } 
    }}
  
  public void finishCharging() {
    cancel();
    WindweaverAbility.chargeTasks.remove(this.playerId);
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ff.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */