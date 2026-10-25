package net.kingscraft.zenixmc.altarsmp.altar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemType;

public class AltarManager {
  public AltarSMP plugin;

  public final Map<String, Altar> altars;

  public File altarsFile;

  public FileConfiguration altarsConfig;

  public static double rotationSpeed = AltarSMP.getInstance().getConfig().getDouble("settings.rotation_speed", 5.0D) * 0.01D;


  public AltarManager(AltarSMP main) {
    this.plugin = main;
    this.altars = new HashMap<>();
    loadAltars();
    loadAltarConfig();
  }

  public void loadAltarConfig() {
    {
      this.altarsFile = new File(this.plugin.getDataFolder(), "altars.yml");
      if (!this.altarsFile.exists()) {
        this.altarsFile.getParentFile().mkdirs();
        this.plugin.saveResource("altars.yml", false);
      } 
    }this.altarsConfig = YamlConfiguration.loadConfiguration(this.altarsFile);
  }

  public FileConfiguration getAltarConfig() {
    return this.altarsConfig;
  }

  public void saveAltarConfig() {
    try {
      this.altarsConfig.save(this.altarsFile);
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
  }

  public void loadAltars() {
    ConfigurationSection configurationSection = this.plugin.getConfig().getConfigurationSection("altars");
    {
      if (configurationSection == null)
        return; 
    }for (String str : configurationSection.getKeys(false)) {
      ConfigurationSection configurationSection1 = configurationSection.getConfigurationSection(str);
      {
        if (configurationSection1 == null)
          continue; 
      }
      Altar altar = loadAltar(str, configurationSection1);
      {
        if (altar != null)
          this.altars.put(str, altar);
      }} 
  }

  public String getMaterialDisplayName(String materialName) {
    {
      if (getItem(materialName).getType() != Material.NETHER_STAR)
        return getItem(materialName).getItemMeta().getDisplayName();
    }String str = materialName.toLowerCase().replace("_", " ");
    StringBuilder stringBuilder = new StringBuilder();
    for (String str1 : str.split(" "))
      stringBuilder.append(Character.toUpperCase(str1.charAt(0))).append(str1.substring(1)).append(" "); 
    return stringBuilder.toString().trim();
  }

  public Altar loadAltar(String paramString, ConfigurationSection paramConfigurationSection) {
    String str = AltarController.createItemStack(paramString).getItemMeta().getDisplayName();
    double d = paramConfigurationSection.getDouble("hologram-height", 3.0D);
    List<String> arrayList = new ArrayList<>();
    List<Map<?, ?>> list = paramConfigurationSection.getMapList("recipes." + paramString + ".ingredients");
    for (Map<?, ?> map : list) {
      String str1 = map.get("material").toString();
      int i = (Integer) map.get("amount");
      String str2 = getMaterialDisplayName(str1);
      arrayList.add("§7" + i + "x §f" + str2);
    } 
    arrayList.add(str);
    Map<String, AltarRecipe> hashMap = new HashMap<>();
    ConfigurationSection configurationSection = paramConfigurationSection.getConfigurationSection("recipes");
    if (configurationSection != null)
      for (String str1 : configurationSection.getKeys(false)) {
        ConfigurationSection configurationSection1 = configurationSection.getConfigurationSection(str1);
        if (configurationSection1 != null) {
          AltarRecipe altarRecipe = loadRecipe(str1, configurationSection1);
          {
            if (altarRecipe != null)
              hashMap.put(str1, altarRecipe);
          }} 
      }  
    return new Altar(paramString, str, arrayList, hashMap, d);
  }

  public AltarRecipe loadRecipe(String paramString, ConfigurationSection paramConfigurationSection) {
    AltarRecipeBuilder altarRecipeBuilder = new AltarRecipeBuilder(paramString);
    altarRecipeBuilder.material(Material.STONE);
    List<?> list = paramConfigurationSection.getList("ingredients");
    if (list != null)
      for (Object map : list) {
        if (map instanceof Map<?, ?> map1) {
          String str = (String)map1.get("material");
          {
            if (str == null)
              continue; 
          }Material material = Material.getMaterial(str.toUpperCase());
          ItemStack referenceItem = getItem(str);
          if (material == null)
            material = referenceItem.getType();
          ItemMeta referenceMeta = referenceItem.getItemMeta();
          int customModelData = referenceMeta != null && referenceMeta.hasCustomModelData() ? referenceMeta.getCustomModelData() : 0;
          String itemModel = referenceMeta != null && referenceMeta.hasItemModel() ? referenceMeta.getItemModel().toString() : null;
          int bool;
          {
            bool = map1.containsKey("amount") ? (Integer) map1.get("amount") : 1;
          }
          altarRecipeBuilder.ingredient(material, bool, customModelData, itemModel);
        } 
      }  
    return altarRecipeBuilder.build();
  }

  public static int getCustomModelData(String paramString) {
    {
      if (getItem(paramString).getItemMeta().hasCustomModelData())
        return getItem(paramString).getItemMeta().getCustomModelData();
    }return 0;
  }

  public static ItemStack getItem(String paramString) {
    try {
      return CustomItemType.valueOf(paramString.toUpperCase()).getItem();
    } catch (IllegalArgumentException illegalArgumentException) {
      try {
        return CustomItem.valueOf(paramString.toUpperCase()).getItem();
      } catch (IllegalArgumentException illegalArgumentException1) {
        return new ItemStack(Material.NETHER_STAR);
      } 
    } 
  }

  public Altar getAltar(String paramString) {
    return this.altars.get(paramString);
  }

  public Set<String> getAltarNames() {
    return this.altars.keySet();
  }

  public static double getRotationSpeed() {
    return rotationSpeed;
  }

  public double getHologramHeight() {
    return this.plugin.getConfig().getDouble("settings.hologram_height", 3.0D);
  }

}
