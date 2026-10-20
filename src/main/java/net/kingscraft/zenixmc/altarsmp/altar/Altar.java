package net.kingscraft.zenixmc.altarsmp.altar;

import java.util.List;
import java.util.Map;

public class Altar {
  public final String name;

  public final String displayName;

  public final List<String> ingredientDisplay;

  public final Map<String, AltarRecipe> recipes;

  public final double hologramHeight;

  public Altar(String paramString1, String paramString2, List<String> paramList, Map<String, AltarRecipe> paramMap, double paramDouble) {
    this.name = paramString1;
    this.displayName = paramString2;
    this.ingredientDisplay = paramList;
    this.recipes = paramMap;
    this.hologramHeight = paramDouble;
  }

  public String getName() {
    return this.name;
  }

  public List<String> getIngredientDisplay() {
    return this.ingredientDisplay;
  }

  public Map<String, AltarRecipe> getRecipe() {
    return this.recipes;
  }

  public double getHologramHeight() {
    return this.hologramHeight;
  }
}
