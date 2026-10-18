package net.kingscraft.zenixmc.altarsmp.bingo;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class BingoEventCountdownTask extends BukkitRunnable {
  public final BingoEventManager bingoEventManager;
  
  public BingoEventCountdownTask(BingoEventManager bingoEventManager) {
        this.bingoEventManager = bingoEventManager;
    }
  
  public void run() {
    try {
      if (!this.bingoEventManager.isBingoRunning) {
        cancel();
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      this.bingoEventManager.remainingTimeTicks -= 20;
      if (this.bingoEventManager.remainingTimeTicks <= 0) {
        this.bingoEventManager.stopBingoEvent();
        cancel();
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    for (Player player : Bukkit.getOnlinePlayers())
      this.bingoEventManager.checkPlayerQuests(player);
    this.bingoEventManager.updateBingoScoreboards();
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gc.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */