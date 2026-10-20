package net.kingscraft.zenixmc.altarsmp.trust;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class TrustManager {
  private File file = new File(AltarSMP.getInstance().getDataFolder(), a);

  public static FileConfiguration config;

  private static final String a = "trusts.yml";

  public TrustManager() {
    if (!this.file.exists())
      try {
        this.file.createNewFile();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    config = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
  }

  public void reload() {
    config = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
  }

  public void addTrust(Player paramPlayer1, Player paramPlayer2) {
    Set<String> set = getTrustedPlayers(paramPlayer1);
    set.add(paramPlayer2.getUniqueId().toString());
    config.set(paramPlayer1.getUniqueId().toString(), new ArrayList<>(set));
    save();
  }

  public void removeTrust(Player paramPlayer1, Player paramPlayer2) {
    Set<String> set = getTrustedPlayers(paramPlayer1);
    set.remove(paramPlayer2.getUniqueId().toString());
    config.set(paramPlayer1.getUniqueId().toString(), new ArrayList<>(set));
    save();
  }

  public static Set<String> getTrustedPlayers(Player paramPlayer) {
    List<? extends String> list = config.getStringList(paramPlayer.getUniqueId().toString());
    return new HashSet<>(list);
  }

  public static boolean isTrusted(Player paramPlayer1, Player paramPlayer2) {
    return getTrustedPlayers(paramPlayer1).contains(paramPlayer2.getUniqueId().toString());
  }

  public void save() {
    try {
      config.save(this.file);
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
  }

}
