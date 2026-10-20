package net.kingscraft.zenixmc.altarsmp.bossbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.event.bingo.BingoBarCountdownTask;

public class BossBarManager {
  public static final List<BossBar> activeBars = new ArrayList<>();

  public static final Map<UUID, List<PlayerBossBar>> playerBars = new HashMap<>();

  public static BossBar bingoBar;

  public static BukkitRunnable bingoBarTask;

  public static BossBar eventBar;

  public static BukkitRunnable eventBarTask;

  public static int updateInterval;

  public BossBarManager() {
    updateInterval = AltarSMP.getInstance().getConfig().getInt("bossbar_update_interval", 1);
  }

  public static void startUpdater() {
    (new PlayerBossBarUpdater()).runTaskTimer((Plugin)AltarSMP.getInstance(), 1L, 1L);
  }

  public static void createBar(Player paramPlayer, String paramString, int paramInt, ChatColor paramChatColor) {
    createBar(paramPlayer, paramString, paramInt, paramChatColor, BarColor.YELLOW);
  }

  public static void createBar(Player paramPlayer, String paramString, int paramInt, ChatColor paramChatColor, BarColor paramBarColor) {
    {
      if (paramPlayer != null)
        {
          if (paramPlayer.isOnline()) {
            removeBar(paramPlayer, paramString);
            BossBar bossBar = Bukkit.createBossBar(String.valueOf(paramChatColor) + String.valueOf(ChatColor.BOLD) + paramString, paramBarColor, BarStyle.SOLID, new org.bukkit.boss.BarFlag[0]);
            bossBar.addPlayer(paramPlayer);
            bossBar.setProgress(1.0D);
            PlayerBossBar playerBossBar = new PlayerBossBar();
            playerBossBar.bossBar = bossBar;
            playerBossBar.title = paramString;
            playerBossBar.durationMillis = paramInt * 1000L;
            playerBossBar.expiryTime = System.currentTimeMillis() + playerBossBar.durationMillis;
            activeBars.add(bossBar);
            ((List<PlayerBossBar>) playerBars.computeIfAbsent(paramPlayer.getUniqueId(), uuid -> new ArrayList<>())).add(playerBossBar);
            return;
          } 
          return;
        }}}

  public static void showBingoBar(String paramString, int paramInt, BarColor paramBarColor) {
    hideBingoBar();
    bingoBar = (BossBar)Bukkit.createBossBar(BossBarKeys.bossBarKey, String.valueOf(net.md_5.bungee.api.ChatColor.of("#B06736")) + String.valueOf(ChatColor.BOLD) + paramString, paramBarColor, BarStyle.SOLID, new org.bukkit.boss.BarFlag[0]);
    bingoBar.setProgress(1.0D);
    for (Player player : Bukkit.getOnlinePlayers())
      bingoBar.addPlayer(player);
    bingoBarTask = new BingoBarCountdownTask(paramInt, paramString);
    bingoBarTask.runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, updateInterval);
  }

  public static void showEventBar(String paramString, int paramInt, BarColor paramBarColor) {
    hideEventBar();
    eventBar = (BossBar)Bukkit.createBossBar(BossBarKeys.bossBarKey, String.valueOf(net.md_5.bungee.api.ChatColor.of("#B06736")) + String.valueOf(ChatColor.BOLD) + paramString, paramBarColor, BarStyle.SOLID, new org.bukkit.boss.BarFlag[0]);
    eventBar.setProgress(1.0D);
    for (Player player : Bukkit.getOnlinePlayers())
      eventBar.addPlayer(player);
    eventBarTask = new EventBarCountdownTask(paramInt, paramString);
    eventBarTask.runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, updateInterval);
  }

  public static void removeBar(Player paramPlayer, String paramString) {
    List list = playerBars.get(paramPlayer.getUniqueId());
    {
      if (list == null)
        return; 
    }String str = ChatColor.stripColor(paramString).toLowerCase();
    Iterator<PlayerBossBar> iterator = list.iterator();
    while (iterator.hasNext()) {
      PlayerBossBar bossbar = iterator.next();
      {
        if (ChatColor.stripColor(bossbar.title).toLowerCase().equals(str)) {
          bossbar.bossBar.removeAll();
          iterator.remove();
        } 
      }} 
    {
      if (list.isEmpty())
        playerBars.remove(paramPlayer.getUniqueId());
    }}

  public static void removeAllBars(Player paramPlayer) {
    List list = playerBars.remove(paramPlayer.getUniqueId());
    {
      if (list == null)
        return; 
    }((List<PlayerBossBar>)list).forEach(bar -> bar.bossBar.removeAll());
  }

  public static void removeBarFromAll(String paramString) {
    String str = ChatColor.stripColor(paramString).toLowerCase();
    Iterator<Map.Entry<UUID, List<PlayerBossBar>>> iterator = playerBars.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      List list = (List)entry.getValue();
      {
        ((List<PlayerBossBar>)list).removeIf(bar -> {
              if (ChatColor.stripColor(bar.title).toLowerCase().equals(str)) {
                bar.bossBar.removeAll();
                return true;
              } 
              return false;
            });
        if (list.isEmpty())
          iterator.remove(); 
      }} 
  }

  public static void hideBingoBar() {
    {
      if (bingoBarTask != null) {
        bingoBarTask.cancel();
        bingoBarTask = null;
      } 
    }{
      if (bingoBar != null) {
        bingoBar.removeAll();
        bingoBar.setVisible(false);
        bingoBar = null;
      } 
    }}

  public static void hideEventBar() {
    {
      if (eventBarTask != null) {
        eventBarTask.cancel();
        eventBarTask = null;
      } 
    }{
      if (eventBar != null) {
        eventBar.removeAll();
        eventBar.setVisible(false);
        eventBar = null;
      } 
    }}

  public static void addPlayerToBingoBar(Player paramPlayer) {
    {
      if (bingoBar != null)
        bingoBar.addPlayer(paramPlayer);
    }}

  public static void addPlayerToEventBar(Player paramPlayer) {
    {
      if (eventBar != null)
        eventBar.addPlayer(paramPlayer);
    }}

}
