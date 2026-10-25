package net.kingscraft.zenixmc.altarsmp.bossbar;

import org.bukkit.boss.BossBar;

public class PlayerBossBar {
  public BossBar bossBar;

  public String title;

  public long expiryTime;

  public long durationMillis;

  public int repeatCount;

  public boolean repeated = false;

  public Runnable onExpireCallback;
}
