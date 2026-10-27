package net.kingscraft.zenixmc.altarsmp.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class KillTracker {
  protected final AltarSMP plugin;
  protected final String fileName;
  protected File dataFile;
  protected FileConfiguration config;
  protected final Map<UUID, Integer> killCounts;

  public KillTracker(AltarSMP plugin, String fileName) {
    this.plugin = plugin;
    this.fileName = fileName;
    this.killCounts = new HashMap<>();
    loadDataFile();
    loadKillCounts();
  }

  protected boolean forceMax() {
    return false;
  }

  protected void loadDataFile() {
    if (!this.plugin.getDataFolder().exists()) {
      this.plugin.getDataFolder().mkdirs();
    }
    this.dataFile = new File(this.plugin.getDataFolder(), this.fileName);
    if (!this.dataFile.exists()) {
      try {
        this.dataFile.createNewFile();
      } catch (IOException exception) {
        exception.printStackTrace();
      }
    }
    this.config = YamlConfiguration.loadConfiguration(this.dataFile);
  }

  protected void loadKillCounts() {
    for (String key : this.config.getKeys(false)) {
      try {
        UUID uuid = UUID.fromString(key);
        this.killCounts.put(uuid, this.config.getInt(key + ".kills", 0));
      } catch (IllegalArgumentException exception) {
        this.plugin.getLogger().warning("Invalid UUID in the file: " + key);
      }
    }
  }

  public void incrementKillCount(Player player) {
    UUID uuid = player.getUniqueId();
    int newKillCount = getKillCount(player) + 1;
    this.killCounts.put(uuid, newKillCount);
    this.config.set(uuid + ".name", player.getName());
    this.config.set(uuid + ".kills", newKillCount);
    saveDataFile();
  }

  public int getKillCount(Player player) {
    if (forceMax()) {
      return 10;
    }
    return this.killCounts.getOrDefault(player.getUniqueId(), 0);
  }

  public void setKillCount(Player player, int killCount) {
    if (forceMax()) {
      return;
    }
    UUID uuid = player.getUniqueId();
    this.killCounts.put(uuid, killCount);
    this.config.set(uuid + ".name", player.getName());
    this.config.set(uuid + ".kills", killCount);
    saveDataFile();
  }

  public void resetKillCount(Player player) {
    setKillCount(player, 0);
  }

  public void saveDataFile() {
    try {
      this.config.save(this.dataFile);
    } catch (IOException exception) {
      this.plugin.getLogger().severe("Failed to save " + this.fileName + "!");
      exception.printStackTrace();
    }
  }

  public void flush() {
    saveDataFile();
  }
}
