package net.kingscraft.zenixmc.altarsmp.bossbar;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class PlayerBossBarUpdater extends BukkitRunnable {

  public void run() {
    long l = System.currentTimeMillis();
    Iterator<Map.Entry<UUID, List<PlayerBossBar>>> iterator = BossBarManager.playerBars.entrySet().iterator();
    while (true) {
      List<PlayerBossBar> list;
      if (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        Player player = Bukkit.getPlayer((UUID)entry.getKey());
        list = (List)entry.getValue();
        if (player != null) {
          if (player.isOnline()) {
            Iterator<PlayerBossBar> iterator1 = list.iterator();
            while (iterator1.hasNext()) {
              PlayerBossBar bar = iterator1.next();
              if (bar.durationMillis <= 0L) {
                bar.bossBar.removeAll();
                iterator1.remove();
                continue;
              } 
              double d = (bar.expiryTime - l) / (double)bar.durationMillis;
              d = Math.max(0.0D, Math.min(1.0D, d));
              bar.bossBar.setProgress(d);
              if (l >= bar.expiryTime) {
                if (bar.repeatCount > 0)
                  if (!bar.repeated) {
                    bar.repeated = true;
                    bar.bossBar.setTitle(String.valueOf(ChatColor.YELLOW) + String.valueOf(ChatColor.BOLD) + bar.title);
                    bar.bossBar.setColor(BarColor.YELLOW);
                    bar.expiryTime = System.currentTimeMillis() + bar.repeatCount * 1000L;
                    bar.durationMillis = bar.repeatCount * 1000L;
                    if (bar.onExpireCallback != null)
                      bar.onExpireCallback.run(); 
                    continue;
                  } 
                bar.bossBar.removeAll();
                iterator1.remove();
              } 
            } 
            if (list.isEmpty())
              iterator.remove(); 
            continue;
          } 
          list.forEach(bar1 -> bar1.bossBar.removeAll());
          iterator.remove();
          continue;
        } 
      } else {
        break;
      } 
      list.forEach(bar2 -> bar2.bossBar.removeAll());
      iterator.remove();
    } 
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gp.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
