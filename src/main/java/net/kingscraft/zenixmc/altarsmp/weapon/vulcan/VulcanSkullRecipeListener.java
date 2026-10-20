package net.kingscraft.zenixmc.altarsmp.weapon.vulcan;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;

public class VulcanSkullRecipeListener implements Listener {
  public AltarSMP plugin;

  public VulcanSkullRecipeListener(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
    ConfigurationSection configurationSection = paramAltarSMP.getConfig().getConfigurationSection("VulcansSkull");
    {
      if (configurationSection != null && configurationSection.getBoolean("enabled")) {
        List list = configurationSection.getStringList("shape");
        ItemStack itemStack = CustomItemRegistry.getVulcanSkull();
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey((Plugin)paramAltarSMP, "skull_crafting"), itemStack);
        shapedRecipe.shape((String[])list.toArray((Object[])new String[0]));
        ConfigurationSection configurationSection1 = configurationSection.getConfigurationSection("ingredients");
        if (configurationSection1 != null)
          for (String str : configurationSection1.getKeys(false)) {
            char c = str.charAt(0);
            Material material = Material.matchMaterial(configurationSection1.getString(str));
            {
              if (material != null)
                shapedRecipe.setIngredient(c, material); 
            }}  
        Bukkit.addRecipe((Recipe)shapedRecipe);
      } 
    }}



}
