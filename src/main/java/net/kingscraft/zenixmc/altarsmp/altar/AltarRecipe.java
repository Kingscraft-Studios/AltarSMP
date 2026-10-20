package net.kingscraft.zenixmc.altarsmp.altar;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.RecipeIngredient;

public class AltarRecipe {
  public final String name;

  public final ItemStack result;

  public final List<RecipeIngredient> ingredients;

  public AltarRecipe(String paramString, ItemStack paramItemStack, List<RecipeIngredient> paramList) {
    this.name = paramString;
    this.result = paramItemStack;
    this.ingredients = paramList;
  }

  public List<RecipeIngredient> getIngredients() {
    return new ArrayList<>(this.ingredients);
  }
}
