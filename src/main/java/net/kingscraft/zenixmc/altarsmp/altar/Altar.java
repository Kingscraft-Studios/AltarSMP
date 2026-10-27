package net.kingscraft.zenixmc.altarsmp.altar;

import java.util.List;
import java.util.Map;
import net.kyori.adventure.text.Component;

public record Altar(String name, Component displayName, List<Component> ingredientDisplay, Map<String, AltarRecipe> recipes, double hologramHeight) {

  public Map<String, AltarRecipe> getRecipe() {
    return this.recipes;
  }
}
