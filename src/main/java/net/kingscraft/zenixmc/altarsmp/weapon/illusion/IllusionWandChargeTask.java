package net.kingscraft.zenixmc.altarsmp.weapon.illusion;

import net.kingscraft.zenixmc.altarsmp.weapon.illusion.util.IllusionConfig;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class IllusionWandChargeTask extends BukkitRunnable {

  final int chargeDurationTicks = IllusionConfig.chargeDurationSeconds() * 20;

  public int chargeTicks;

  public final Player player;

  public IllusionWandChargeTask(Player player) {
    this.player = player;
    this.chargeTicks = 0;
  }

  @Override
  public void run() {
    if (!this.player.isOnline()) {
      finish();
      cancel();
      return;
    }
    if (this.player.isHandRaised()
            && IllusionWandAbility.isIllusionWand(this.player.getInventory().getItemInMainHand())) {
      if (this.chargeTicks < this.chargeDurationTicks) {
        if (this.chargeTicks == 0) {
          this.player.getWorld().playSound(this.player.getLocation(),
                  Sound.ENTITY_WARDEN_SONIC_CHARGE, 1.0F, 1.0F);
        }
        this.chargeTicks++;
        return;
      }
      this.player.stopSound(Sound.ENTITY_WARDEN_SONIC_CHARGE);
      finish();
      cancel();
      IllusionWandAbility.activateDisguise(this.player);
      return;
    }

    this.player.stopSound(Sound.ENTITY_WARDEN_SONIC_CHARGE);
    finish();
    cancel();
  }

  private void finish() {
    IllusionWandAbility.CHARGING.remove(this.player.getUniqueId());
  }
}
