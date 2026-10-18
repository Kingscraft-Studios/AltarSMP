package net.kingscraft.zenixmc.altarsmp.altar;

import java.util.List;
import java.util.Map;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

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
  
  public String getDisplayName() {
    return this.displayName;
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bs.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */