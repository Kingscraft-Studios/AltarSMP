package net.kingscraft.zenixmc.altarsmp.event.bingo;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class BingoEventCountdownTask extends BukkitRunnable {
  public final BingoEventManager bingoEventManager;

  public BingoEventCountdownTask(BingoEventManager bingoEventManager) {
        this.bingoEventManager = bingoEventManager;
    }

  public void run() {
    if (!this.bingoEventManager.isBingoRunning) {
      cancel();
      return;
    } 

    this.bingoEventManager.remainingTimeTicks -= 20;
    if (this.bingoEventManager.remainingTimeTicks <= 0) {
      this.bingoEventManager.stopBingoEvent();
      cancel();
      return;
    } 

    for (Player player : Bukkit.getOnlinePlayers())
      this.bingoEventManager.checkPlayerQuests(player);
    this.bingoEventManager.updateBingoScoreboards();
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gc.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */