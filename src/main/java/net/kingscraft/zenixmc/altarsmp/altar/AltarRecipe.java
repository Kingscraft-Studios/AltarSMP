package net.kingscraft.zenixmc.altarsmp.altar;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import net.kingscraft.zenixmc.altarsmp.item.RecipeIngredient;

public record AltarRecipe(String name, ItemStack result, List<RecipeIngredient> ingredients) {

  @Override
  public List<RecipeIngredient> ingredients() {
    return new ArrayList<>(this.ingredients);
  }
}
