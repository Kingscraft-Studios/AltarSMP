package net.kingscraft.zenixmc.altarsmp.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeIngredient {
  public final Material material;

  public final int amount;

  public final int customModelData;

  public final String itemModel;

  public RecipeIngredient(Material paramMaterial, int paramInt1, int paramInt2) {
    this(paramMaterial, paramInt1, paramInt2, null);
  }

  public RecipeIngredient(Material paramMaterial, int paramInt1, int paramInt2, String itemModel) {
    this.material = paramMaterial;
    this.amount = paramInt1;
    this.customModelData = paramInt2;
    this.itemModel = itemModel;
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

  public boolean hasItemModel() {
    return this.itemModel != null;
  }

  public boolean matches(ItemStack item) {
    if (item == null || item.getType() != material)
      return false;

    ItemMeta meta = item.getItemMeta();

    if (hasItemModel()) {
      if (meta == null || !meta.hasItemModel())
        return false;

      if (!itemModel.equals(meta.getItemModel().toString()))
        return false;
    }

    if (hasCustomModelData()) {
      if (meta == null || !meta.hasCustomModelData())
        return false;

      return meta.getCustomModelData() == customModelData;
    }

    return true;
  }
}
