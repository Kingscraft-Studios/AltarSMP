package net.kingscraft.zenixmc.altarsmp.altar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
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
        if (this.altarsFile.getParentFile().mkdirs())
          plugin.getLogger().severe("Failed to create Directory");
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
      plugin.getLogger().severe("An Error Occurred while trying to save altars.yml: " + iOException);
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

  public static Component getItemDisplayName(ItemStack itemStack) {
    if (itemStack != null) {
      ItemMeta itemMeta = itemStack.getItemMeta();
      if (itemMeta != null && itemMeta.hasDisplayName()) {
        Component displayName = itemMeta.displayName();
        if (displayName != null)
          return displayName;
      }
      return Component.text(formatMaterialName(itemStack.getType().name()));
    }
    return Component.empty();
  }

  public static Component getMaterialDisplayName(String materialName) {
    ItemStack itemStack = getItem(materialName);
    if (itemStack.getType() != Material.NETHER_STAR)
      return getItemDisplayName(itemStack);
    return Component.text(formatMaterialName(materialName));
  }

  private static String formatMaterialName(String materialName) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String str : materialName.toLowerCase().replace("_", " ").split(" ")) {
      if (!str.isEmpty())
        stringBuilder.append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).append(' ');
    }
    return stringBuilder.toString().trim();
  }

  public Altar loadAltar(String paramString, ConfigurationSection paramConfigurationSection) {
    Component displayName = getItemDisplayName(AltarController.createItemStack(paramString));
    double d = paramConfigurationSection.getDouble("hologram-height", 3.0D);
    List<Component> arrayList = new ArrayList<>();
    List<Map<?, ?>> list = paramConfigurationSection.getMapList("recipes." + paramString + ".ingredients");
    for (Map<?, ?> map : list) {
      String str1 = map.get("material").toString();
      int i = (int) map.get("amount");
      arrayList.add(Component.text()
          .append(Component.text(i + "x ", NamedTextColor.GRAY))
          .append(getMaterialDisplayName(str1).colorIfAbsent(NamedTextColor.WHITE))
          .build());
    } 
    arrayList.add(displayName);
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
    return new Altar(paramString, displayName, arrayList, hashMap, d);
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
          int customModelData = getCustomModelData(referenceMeta);
          String itemModel = (referenceMeta != null && referenceMeta.hasItemModel()) ? referenceMeta.getItemModel().toString() : null;
          int bool;
          {
            bool = map1.containsKey("amount") ? (int) map1.get("amount") : 1;
          }
          altarRecipeBuilder.ingredient(material, bool, customModelData, itemModel);
        } 
      }  
    return altarRecipeBuilder.build();
  }

  public static void applyCustomModelData(ItemMeta itemMeta, int customModelData) {
    if (itemMeta == null || customModelData <= 0)
      return;
    CustomModelDataComponent component = itemMeta.getCustomModelDataComponent();
    component.setFloats(List.of((float) customModelData));
    itemMeta.setCustomModelDataComponent(component);
  }

  public static int getCustomModelData(ItemMeta itemMeta) {
    if (itemMeta == null)
      return 0;
    CustomModelDataComponent component = itemMeta.getCustomModelDataComponent();
    if (component.getFloats() != null && !component.getFloats().isEmpty())
      return Math.round(component.getFloats().getFirst());
    return 0;
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
