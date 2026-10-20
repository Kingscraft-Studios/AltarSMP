package net.kingscraft.zenixmc.altarsmp.event.bingo;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.util.TimeUtils;

public class BingoBarCountdownTask extends BukkitRunnable {
  public int elapsedTicks;

  public final int totalTicks;

  public final int durationSeconds;

  public final String title;


  public BingoBarCountdownTask(int paramInt, String paramString) {
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
      BossBarManager.bingoBar.setTitle(net.md_5.bungee.api.ChatColor.of("#B06736") + String.valueOf(ChatColor.BOLD) + this.title + " " + net.md_5.bungee.api.ChatColor.of("#B06736") + ChatColor.BOLD + TimeUtils.formatMmSs(i));
      BossBarManager.bingoBar.setProgress(Math.max(0.0D, 1.0D - (double)this.elapsedTicks / (double)this.totalTicks));
      if (this.elapsedTicks >= this.totalTicks) {
        BossBarManager.hideBingoBar();
        cancel();
      } 
    }
  }

}
