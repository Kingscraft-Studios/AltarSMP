package pl;

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

public class WeaponHandleRecipeListener implements Listener {
  public Main plugin;
  
  public WeaponHandleRecipeListener(Main paramMain) {
    this.plugin = paramMain;
    ConfigurationSection configurationSection = paramMain.getConfig().getConfigurationSection("WeaponHandle");
    {
      if (configurationSection != null && configurationSection.getBoolean("enabled")) {
        List list = configurationSection.getStringList("shape");
        ItemStack itemStack = CustomItemRegistry.getWeaponHandle();
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey((Plugin)paramMain, "handle_crafting"), itemStack);
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
    }
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b7.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */