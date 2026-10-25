package net.kingscraft.zenixmc.altarsmp.bossbar;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.util.TimeUtils;

class EventBarCountdownTask extends BukkitRunnable {
  public int elapsedTicks;

  public final int totalTicks;

  public final int durationSeconds;

  public final String title;


  public EventBarCountdownTask(int paramInt, String paramString) {
        this.durationSeconds = paramInt;
        this.totalTicks = this.durationSeconds * 20;
        this.title = paramString;
        this.elapsedTicks = 0;
    }

  public void run() {
    {
      if (BossBarManager.eventBar == null) {
        cancel();
        return;
      } 
    }
    this.elapsedTicks += BossBarManager.updateInterval;
    int i = Math.max(0, this.totalTicks - this.elapsedTicks);
    {
      BossBarManager.eventBar.setTitle(net.md_5.bungee.api.ChatColor.of("#B06736") + String.valueOf(ChatColor.BOLD) + this.title + " " + net.md_5.bungee.api.ChatColor.of("#B06736") + ChatColor.BOLD + TimeUtils.formatMmSs(i));
      BossBarManager.eventBar.setProgress(Math.max(0.0D, 1.0D - (double)this.elapsedTicks / (double)this.totalTicks));
      if (this.elapsedTicks >= this.totalTicks) {
        BossBarManager.hideEventBar();
        cancel();
      } 
    }
  }

}
