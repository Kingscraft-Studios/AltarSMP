package net.kingscraft.zenixmc.altarsmp.altarS2.weapon.omen;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class OmenConjuringBuffTask extends BukkitRunnable {
  private final UUID casterId;
  private final long expiry;

  OmenConjuringBuffTask(UUID casterId, long expiry) {
    this.casterId = casterId;
    this.expiry = expiry;
  }

  @Override
  public void run() {
    Player caster = Bukkit.getPlayer(casterId);
    if (caster == null || !caster.isOnline() || caster.isDead() || System.currentTimeMillis() > expiry) {
      OmenAbility.endConjuring(casterId);
    }
  }
}
