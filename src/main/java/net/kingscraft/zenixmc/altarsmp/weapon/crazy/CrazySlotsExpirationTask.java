package net.kingscraft.zenixmc.altarsmp.weapon.crazy;

import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class CrazySlotsExpirationTask extends BukkitRunnable {
  public final Player player;

  public final UUID playerUUID;

  public CrazySlotsExpirationTask(Player paramPlayer, UUID paramUUID) {
        this.player = paramPlayer;
        this.playerUUID = paramUUID;
    }

  public void run() {
    if (this.player.isOnline())
      {
        if (CrazySlotsListener.activeCrazySlots.containsKey(this.playerUUID))
          CrazySlotsListener.clearCrazySlots(this.player);
      }  

    CrazySlotsListener.expirationTasks.remove(this.playerUUID);
  }

}
