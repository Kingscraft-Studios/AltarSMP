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

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b6 implements Listener {
  public Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b6(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
    ConfigurationSection configurationSection = paramMain.getConfig().getConfigurationSection("VulcansSkull");
    {
      if (configurationSection != null && configurationSection.getBoolean("enabled")) {
        List list = configurationSection.getStringList("shape");
        ItemStack itemStack = CustomItemRegistry.getVulcanSkull();
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey((Plugin)paramMain, "skull_crafting"), itemStack);
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
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b6.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */