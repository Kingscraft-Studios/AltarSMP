package net.kingscraft.zenixmc.altarsmp.altar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.kingscraft.zenixmc.altarsmp.item.RecipeIngredient;

public class AltarRecipeBuilder {
  public String name;

  public Material material;

  public String displayName;

  public List<String> lore = new ArrayList<>();

  public Map<Enchantment, Integer> enchantments = new HashMap<>();

  public int customModelData = 0;

  public List<RecipeIngredient> ingredients = new ArrayList<>();

  public AltarRecipeBuilder(String paramString) {
    this.name = paramString;
  }

  public AltarRecipeBuilder material(Material paramMaterial) {
    this.material = paramMaterial;
    return this;
  }

  public void ingredient(Material paramMaterial, int paramInt1, int paramInt2, String itemModel) {
    this.ingredients.add(new RecipeIngredient(paramMaterial, paramInt1, paramInt2, itemModel));
  }

  public AltarRecipe build() {
    ItemStack itemStack = new ItemStack(this.material);
    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta != null) {
      if (this.displayName != null)
        itemMeta.setDisplayName(this.displayName);

      if (!this.lore.isEmpty())
        itemMeta.setLore(this.lore);

      if (this.customModelData > 0)
        itemMeta.setCustomModelData(this.customModelData);

      itemStack.setItemMeta(itemMeta);
    }

    for (Map.Entry<Enchantment, Integer> entry : this.enchantments.entrySet())
      itemStack.addUnsafeEnchantment(entry.getKey(), entry.getValue());
    return new AltarRecipe(this.name, itemStack, this.ingredients);
  }
}
