package net.kingscraft.zenixmc.altarsmp.listener;

import java.util.List;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemType;

public class SeasonTwoRecipeListener implements Listener {
  private static final List<String> RECIPE_KEYS = List.of(
      "strength", "harness", "soul_in_a_bottle",
      "firework", "amethyst_pickaxe", "amethyst_axe");

  public AltarSMP plugin;

  public SeasonTwoRecipeListener(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
    for (String key : RECIPE_KEYS) {
      ConfigurationSection section = paramAltarSMP.getConfig().getConfigurationSection(key);
      if (section == null || !section.getBoolean("enabled", true)) {
        continue;
      }
      ItemStack result = resultFor(key);
      if (result == null) {
        paramAltarSMP.getLogger().warning("No result item for recipe '" + key + "', skipping.");
        continue;
      }
      NamespacedKey recipeKey = new NamespacedKey(paramAltarSMP, "altars2_" + key);
      Recipe recipe = section.getString("type", "shaped").equalsIgnoreCase("shapeless")
          ? buildShapeless(paramAltarSMP, section, recipeKey, result)
          : buildShaped(paramAltarSMP, section, recipeKey, result);
      if (recipe == null) {
        continue;
      }
      Bukkit.removeRecipe(recipeKey);
      Bukkit.addRecipe(recipe);
    }
  }

  private Recipe buildShapeless(AltarSMP plugin, ConfigurationSection section, NamespacedKey recipeKey, ItemStack result) {
    List<String> ingredients = section.getStringList("ingredients");
    if (ingredients.isEmpty()) {
      return null;
    }
    ShapelessRecipe recipe = new ShapelessRecipe(recipeKey, result);
    for (String ingredient : ingredients) {
      Material material = Material.getMaterial(ingredient.toUpperCase());
      if (material == null) {
        plugin.getLogger().warning("Unknown material '" + ingredient + "' in recipe " + recipeKey.getKey());
        continue;
      }
      recipe.addIngredient(material);
    }
    return recipe;
  }

  private Recipe buildShaped(AltarSMP plugin, ConfigurationSection section, NamespacedKey recipeKey, ItemStack result) {
    List<String> shape = section.getStringList("shape");
    ConfigurationSection ingredients = section.getConfigurationSection("ingredients");
    if (shape.isEmpty() || ingredients == null) {
      return null;
    }
    ShapedRecipe recipe = new ShapedRecipe(recipeKey, result);
    recipe.shape(shape.toArray(new String[0]));
    for (String ingredientKey : ingredients.getKeys(false)) {
      if (ingredientKey.length() != 1) {
        continue;
      }
      Material material = Material.getMaterial(ingredients.getString(ingredientKey, "").toUpperCase());
      if (material == null) {
        plugin.getLogger().warning("Unknown material '" + ingredients.getString(ingredientKey, "") + "' in recipe " + recipeKey.getKey());
        continue;
      }
      recipe.setIngredient(ingredientKey.charAt(0), material);
    }
    return recipe;
  }

  private ItemStack resultFor(String key) {
    return switch (key) {
      case "soul_in_a_bottle" -> CustomItemType.SOUL_IN_A_BOTTLE.getItem();
      case "harness" -> CustomItemType.NETHERITE_HARNESS.getItem();
      case "amethyst_pickaxe" -> CustomItemType.AMETHYST_PICKAXE.getItem();
      case "amethyst_axe" -> CustomItemType.AMETHYST_AXE.getItem();
      case "strength" -> strengthPotion();
      case "firework" -> new ItemStack(Material.FIREWORK_ROCKET, 16);
      default -> null;
    };
  }

  private ItemStack strengthPotion() {
    ItemStack stack = new ItemStack(Material.SPLASH_POTION);
    if (stack.getItemMeta() instanceof PotionMeta meta) {
      meta.displayName(Component.text("Strength Potion", NamedTextColor.RED));
      meta.addCustomEffect(new PotionEffect(PotionEffectType.STRENGTH, 9600, 1, false, true, true), true);
      stack.setItemMeta(meta);
    }
    return stack;
  }
}
