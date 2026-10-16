package pl;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

class BingoBarCountdownTask extends BukkitRunnable {
  int elapsedTicks;
  
  final int totalTicks;

  final int durationSeconds;
  
  final String title;
  
  
  
  BingoBarCountdownTask(int paramInt, String paramString) {
        this.durationSeconds = paramInt;
        this.totalTicks = this.durationSeconds * 20;
        this.title = paramString;
        this.elapsedTicks = 0;
    }
  
  public void run() {
    {
      if (BossBarManager.bingoBar == null) {
        cancel();
        return;
      } 
    }
    this.elapsedTicks += BossBarManager.updateInterval;
    int i = Math.max(0, this.totalTicks - this.elapsedTicks);
    {
      BossBarManager.bingoBar.setTitle(String.valueOf(ChatColor.valueOf("#B06736")) + String.valueOf(ChatColor.valueOf("#B06736")) + String.valueOf(ChatColor.BOLD) + " " + this.title + String.valueOf(ChatColor.valueOf("#B06736")) + String.valueOf(ChatColor.BOLD) + TimeUtils.formatMmSs(i));
      BossBarManager.bingoBar.setProgress(Math.max(0.0D, 1.0D - this.elapsedTicks / this.totalTicks));
      if (this.elapsedTicks >= this.totalTicks) {
        BossBarManager.hideBingoBar();
        cancel();
      } 
    }
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gq.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */