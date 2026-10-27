package net.kingscraft.zenixmc.altarsmp.weapon.wind;

import java.util.UUID;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;

class WindGustChargeTask extends BukkitRunnable {
  public int chargeTicks;

  public final UUID playerId;

  public final Player player;


  public WindGustChargeTask(UUID paramUUID, Player paramPlayer) {
        this.playerId = paramUUID;
        this.player = paramPlayer;
        this.chargeTicks = 0;
    }

  public void run() {
    {
      if (!WindweaverAbility.isCharging.getOrDefault(this.playerId, false)) {
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
          WindweaverAbility.gustChargeLevels.put(this.playerId, i);
            BossBarManager.createBar(this.player, "Charging", 7, NamedTextColor.WHITE, BarColor.WHITE);
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
