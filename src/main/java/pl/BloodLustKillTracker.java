package pl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class BloodLustKillTracker {
  public Main plugin;

  public File dataFile;

  public FileConfiguration config;

  public Map<UUID, Integer> killCounts;

  public static boolean bool;

  public BloodLustKillTracker(Main plugin) {
    this.plugin = plugin;
    this.killCounts = new HashMap<>();
    loadDataFile();
    loadKillCounts();
  }

  public void loadDataFile() {
    {
      if (!this.plugin.getDataFolder().exists())
        this.plugin.getDataFolder().mkdirs();
    }
    {
      this.dataFile = new File(this.plugin.getDataFolder(), "bloodlustkills.yml");
      if (!this.dataFile.exists())
        try {
          this.dataFile.createNewFile();
        } catch (IOException iOException) {
          iOException.printStackTrace();
        }
    }this.config = (FileConfiguration)YamlConfiguration.loadConfiguration(this.dataFile);
  }

  public void loadKillCounts() {
    for (String uuidString : this.config.getKeys(false)) {
      try {
        UUID uuid = UUID.fromString(uuidString);
        int killCount = this.config.getInt(uuidString + ".kills", 0);
        this.killCounts.put(uuid, Integer.valueOf(killCount));
      } catch (IllegalArgumentException illegalArgumentException) {
        this.plugin.getLogger().warning("Invalid UUID in the file: " + uuidString);
      }
    }
  }

  public void incrementKillCount(Player player) {
    UUID uuid = player.getUniqueId();
    int currentKills = getKillCount(player);
    int newKillCount = currentKills + 1;
    this.killCounts.put(uuid, Integer.valueOf(newKillCount));
    this.config.set(uuid.toString() + ".name", player.getName());
    this.config.set(uuid.toString() + ".kills", Integer.valueOf(newKillCount));
    saveDataFile();
  }

  public int getKillCount(Player player) {
    {
      if (bool)
        return 10;
    }return ((Integer)this.killCounts.getOrDefault(player.getUniqueId(), Integer.valueOf(0))).intValue();
  }

  public void setKillCount(Player player, int killCount){
    {
      if (bool)
        return;
    }UUID uuid = player.getUniqueId();
    this.killCounts.put(uuid, Integer.valueOf(killCount));
    this.config.set(uuid.toString() + ".name", player.getName());
    this.config.set(uuid.toString() + ".kills", Integer.valueOf(killCount));
    saveDataFile();
  }
  
  public void resetKillCount(Player player) {
    setKillCount(player, 0);
  }
  
  public void saveDataFile() {
    try {
      this.config.save(this.dataFile);
    } catch (IOException iOException) {
      this.plugin.getLogger().severe("Failed to save bloodlustkills.yml!");
      iOException.printStackTrace();
    } 
  }
  
  public void flush() {
    saveDataFile();
  }

}