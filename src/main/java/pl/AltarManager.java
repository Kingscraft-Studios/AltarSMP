package pl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class AltarManager {
  public Main plugin;
  
  public final Map<String, Altar> altars;
  
  public static final Pattern HEX_COLOR_PATTERN;
  
  private File altarsFile;
  
  private FileConfiguration altarsConfig;
  
  public static double rotationSpeed;
  
  
  
  public AltarManager(Main main) {
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
    }this.altarsConfig = (FileConfiguration)YamlConfiguration.loadConfiguration(this.altarsFile);
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
  
  public String translateColors(String text) {
    Matcher matcher = HEX_COLOR_PATTERN.matcher(text);
    StringBuffer stringBuffer = new StringBuffer(text.length() + 32);
    while (matcher.find()) {
      String str = matcher.group(1);
      matcher.appendReplacement(stringBuffer, ChatColor.of("#" + str).toString());
    } 
    return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(stringBuffer).toString());
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
  
  private String getMaterialDisplayName(String materialName) {
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
    List<String> arrayList = new ArrayList();
    List<Map<?, ?>> list = paramConfigurationSection.getMapList("recipes." + paramString + ".ingredients");
    for (Map map : list) {
      String str1 = map.get("material").toString();
      int i = ((Integer)map.get("amount")).intValue();
      String str2 = getMaterialDisplayName(str1);
      arrayList.add("§7" + i + "x §f" + str2);
    } 
    arrayList.add(str);
    Map<Object, Object> hashMap = new HashMap<>();
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
    return new Altar(paramString, str, arrayList, (Map)hashMap, d);
  }
  
  public AltarRecipe loadRecipe(String paramString, ConfigurationSection paramConfigurationSection) {
    AltarRecipeBuilder altarRecipeBuilder = new AltarRecipeBuilder(paramString);
    altarRecipeBuilder.material(Material.STONE);
    List list = paramConfigurationSection.getList("ingredients");
    if (list != null)
      for (Object map : list) {
        if (map instanceof Map) {
          Map map1 = (Map)map;
          String str = (String)map1.get("material");
          {
            if (str == null)
              continue; 
          }Material material = Material.getMaterial(str.toUpperCase());
          if (material == null)
            material = getItem(str).getType();
          int bool = 0;
          {
            bool = map1.containsKey("amount") ? ((Integer)map1.get("amount")).intValue() : 1;
          }int i = getCustomModelData(str.toUpperCase());
          altarRecipeBuilder.ingredient(material, bool, i);
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

  static {
    HEX_COLOR_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");
    rotationSpeed = Main.getInstance().getConfig().getDouble("settings.rotation_speed", 5.0D) * 0.01D;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764br.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */