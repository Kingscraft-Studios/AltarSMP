package net.kingscraft.zenixmc.altarsmp.bossbar;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.format.NamedTextColor;

class PlayerBossBarUpdater extends BukkitRunnable {

  public void run() {
    long l = System.currentTimeMillis();
    Iterator<Map.Entry<UUID, List<PlayerBossBar>>> iterator = BossBarManager.playerBars.entrySet().iterator();
    while (true) {
      List<PlayerBossBar> list;
      if (iterator.hasNext()) {
        Map.Entry<UUID, List<PlayerBossBar>> entry = iterator.next();
        Player player = Bukkit.getPlayer(entry.getKey());
        list = entry.getValue();
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
              d = Math.clamp(d, 0.0D, 1.0D);
              bar.bossBar.setProgress(d);
              if (l >= bar.expiryTime) {
                if (bar.repeatCount > 0)
                  if (!bar.repeated) {
                    bar.repeated = true;
                    bar.bossBar.setTitle(LegacyComponentSerializer.legacySection().serialize(BossBarManager.formatTitle(Component.text(bar.title), NamedTextColor.YELLOW)));
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
