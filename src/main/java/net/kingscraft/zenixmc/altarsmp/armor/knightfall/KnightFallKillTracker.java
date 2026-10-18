package net.kingscraft.zenixmc.altarsmp.armor.knightfall;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class KnightFallKillTracker {
  public AltarSMP plugin;
  
  public File dataFile;
  
  public FileConfiguration config;
  
  public Map<UUID, Integer> killCounts;
  
  public static boolean bool;
  
  
  static {
    bool = AltarSMP.getInstance().getConfig().getBoolean("nimlot", false);
  }
  
  public KnightFallKillTracker(AltarSMP plugin) {
    this.plugin = plugin;
    this.killCounts = new HashMap<>();
    loadDataFile();
    loadKillCount();
  }
  
  public void loadDataFile() {
    {
      if (!this.plugin.getDataFolder().exists())
        this.plugin.getDataFolder().mkdirs();
    }{
      this.dataFile = new File(this.plugin.getDataFolder(), "knightfallkills.yml");
      if (!this.dataFile.exists())
        try {
          this.dataFile.createNewFile();
        } catch (IOException iOException) {
          iOException.printStackTrace();
        }  
    }this.config = (FileConfiguration)YamlConfiguration.loadConfiguration(this.dataFile);
  }
  
  public void loadKillCount() {
    for (String str : this.config.getKeys(false)) {
      try {
        UUID uUID = UUID.fromString(str);
        int i = this.config.getInt(str + ".kills", 0);
        this.killCounts.put(uUID, Integer.valueOf(i));
      } catch (IllegalArgumentException illegalArgumentException) {
        this.plugin.getLogger().warning("Invalid UUID in the file: " + str);
      } 
    } 
  }
  
  public void incrementKillCount(Player paramPlayer) {
    UUID uUID = paramPlayer.getUniqueId();
    int i = getKillCount(paramPlayer);
    int j = i + 1;
    this.killCounts.put(uUID, Integer.valueOf(j));
    this.config.set(uUID.toString() + ".name", paramPlayer.getName());
    this.config.set(uUID.toString() + ".kills", Integer.valueOf(j));
    saveDataFile();
  }
  
  public int getKillCount(Player paramPlayer) {
    {
      if (bool)
        return 10; 
    }return ((Integer)this.killCounts.getOrDefault(paramPlayer.getUniqueId(), Integer.valueOf(0))).intValue();
  }
  
  public void setKillCount(Player paramPlayer, int paramInt) {
    {
      if (bool)
        return; 
    }UUID uUID = paramPlayer.getUniqueId();
    this.killCounts.put(uUID, Integer.valueOf(paramInt));
    this.config.set(uUID.toString() + ".name", paramPlayer.getName());
    this.config.set(uUID.toString() + ".kills", Integer.valueOf(paramInt));
    saveDataFile();
    (new KnightfallItemRestoreTask(this, paramPlayer)).runTaskLater((Plugin)AltarSMP.getInstance(), 1L);
  }
  
  public void resetKillCount(Player paramPlayer) {
    setKillCount(paramPlayer, 0);
  }
  
  public void saveDataFile() {
    try {
      this.config.save(this.dataFile);
    } catch (IOException iOException) {
      this.plugin.getLogger().severe("Failed to save knightfallkills.yml!");
      iOException.printStackTrace();
    } 
  }
  
  public void flush() {
    saveDataFile();
  }}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */