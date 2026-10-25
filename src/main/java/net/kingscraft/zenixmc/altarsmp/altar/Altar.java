package net.kingscraft.zenixmc.altarsmp.altar;

import java.util.List;
import java.util.Map;

public record Altar(String name, String displayName, List<String> ingredientDisplay, Map<String, AltarRecipe> recipes,
                    double hologramHeight) {

  public Map<String, AltarRecipe> getRecipe() {
    return this.recipes;
  }
}
