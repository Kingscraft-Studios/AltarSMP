package pl;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeIngredient {
  public final Material material;
  
  public final int amount;
  
  public final int customModelData;
  
  public RecipeIngredient(Material paramMaterial, int paramInt1, int paramInt2) {
    this.material = paramMaterial;
    this.amount = paramInt1;
    this.customModelData = paramInt2;
  }
  
  public Material getMaterial() {
    return this.material;
  }
  
  public int getAmount() {
    return this.amount;
  }
  
  public int getCustomModelData() {
    return this.customModelData;
  }
  
  public boolean hasCustomModelData() {
    return this.customModelData > 0;
  }

  public boolean matches(ItemStack item) {
    if (item == null || item.getType() != material)
      return false;

    if (!hasCustomModelData())
      return true;

    ItemMeta meta = item.getItemMeta();

    return meta != null
            && meta.hasCustomModelData()
            && meta.getCustomModelData() == customModelData;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */