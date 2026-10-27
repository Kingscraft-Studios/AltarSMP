package net.kingscraft.zenixmc.altarsmp.bossbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.event.bingo.BingoBarCountdownTask;

public class BossBarManager {
  public static final TextColor COPPER = TextColor.color(0xB06736);

  public static final List<BossBar> activeBars = new ArrayList<>();

  public static final Map<UUID, List<PlayerBossBar>> playerBars = new HashMap<>();

  public static BossBar bingoBar;

  public static BukkitRunnable bingoBarTask;

  public static BossBar eventBar;

  public static BukkitRunnable eventBarTask;

  public static int updateInterval = AltarSMP.getInstance().getConfig().getInt("bossbar_update_interval", 1);

  public static Component formatTitle(Component title, TextColor color) {
    return title.colorIfAbsent(color).decorate(TextDecoration.BOLD);
  }

  public static void startUpdater() {
    (new PlayerBossBarUpdater()).runTaskTimer(AltarSMP.getInstance(), 1L, 1L);
  }

  public static void createBar(Player paramPlayer, String paramString, int paramInt, NamedTextColor paramNamedTextColor) {
    createBar(paramPlayer, paramString, paramInt, paramNamedTextColor, BarColor.YELLOW);
  }

  public static void createBar(Player paramPlayer, String  paramString, int paramInt, NamedTextColor paramNamedTextColor, BarColor paramBarColor) {
    {
      if (paramPlayer != null)
        {
          if (paramPlayer.isOnline()) {
            removeBar(paramPlayer, paramString);
            BossBar bossBar = Bukkit.createBossBar(LegacyComponentSerializer.legacySection().serialize(formatTitle(Component.text(paramString), paramNamedTextColor)), paramBarColor, BarStyle.SOLID);
            bossBar.addPlayer(paramPlayer);
            bossBar.setProgress(1.0D);
            PlayerBossBar playerBossBar = new PlayerBossBar();
            playerBossBar.bossBar = bossBar;
            playerBossBar.title = paramString;
            playerBossBar.durationMillis = paramInt * 1000L;
            playerBossBar.expiryTime = System.currentTimeMillis() + playerBossBar.durationMillis;
            activeBars.add(bossBar);
            playerBars.computeIfAbsent(paramPlayer.getUniqueId(), uuid -> new ArrayList<>()).add(playerBossBar);
          }
        }}}

  public static void showBingoBar(String paramString, int paramInt, BarColor paramBarColor) {
    hideBingoBar();
    bingoBar = Bukkit.createBossBar(BossBarKeys.bossBarKey, LegacyComponentSerializer.legacySection().serialize(formatTitle(Component.text(paramString), COPPER)), paramBarColor, BarStyle.SOLID);
    bingoBar.setProgress(1.0D);
    for (Player player : Bukkit.getOnlinePlayers())
      bingoBar.addPlayer(player);
    bingoBarTask = new BingoBarCountdownTask(paramInt, paramString);
    bingoBarTask.runTaskTimer(AltarSMP.getInstance(), 0L, updateInterval);
  }

  public static void showEventBar(String paramString, int paramInt, BarColor paramBarColor) {
    hideEventBar();
    eventBar = Bukkit.createBossBar(BossBarKeys.bossBarKey, LegacyComponentSerializer.legacySection().serialize(formatTitle(Component.text(paramString), COPPER)), paramBarColor, BarStyle.SOLID);
    eventBar.setProgress(1.0D);
    for (Player player : Bukkit.getOnlinePlayers())
      eventBar.addPlayer(player);
    eventBarTask = new EventBarCountdownTask(paramInt, paramString);
    eventBarTask.runTaskTimer(AltarSMP.getInstance(), 0L, updateInterval);
  }

  public static void removeBar(Player paramPlayer, String paramString) {
    List<PlayerBossBar> list = playerBars.get(paramPlayer.getUniqueId());
    {
      if (list == null)
        return;
    }
    Iterator<PlayerBossBar> iterator = list.iterator();
    while (iterator.hasNext()) {
      PlayerBossBar bossbar = iterator.next();
      {
        if (bossbar.title.equals(paramString)) {
          bossbar.bossBar.removeAll();
          iterator.remove();
        }
      }}
    {
      if (list.isEmpty())
        playerBars.remove(paramPlayer.getUniqueId());
    }}

  public static void removeAllBars(Player paramPlayer) {
    List<PlayerBossBar> list = playerBars.remove(paramPlayer.getUniqueId());
    {
      if (list == null)
        return; 
    }
      list.forEach(bar -> bar.bossBar.removeAll());
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
