package net.kingscraft.zenixmc.altarsmp.event.bingo;

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
