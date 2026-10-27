package net.kingscraft.zenixmc.altarsmp.altar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Structure;
import org.bukkit.block.structure.UsageMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Display;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Transformation;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemIds;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemType;
import net.kingscraft.zenixmc.altarsmp.item.RecipeIngredient;

public class AltarController implements Listener {
  public AltarSMP plugin;

  public final NamespacedKey altarTypeKey;

  public final Map<Location, AltarInstance> altars = new HashMap<>();

  public final NamespacedKey altarUsedKey;


  public AltarController(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
    this.altarTypeKey = new NamespacedKey(paramAltarSMP, "altar_type");
    this.altarUsedKey = new NamespacedKey(paramAltarSMP, "altar_used");
    startUpdateTask();
  }

  public List<AltarInstance> getAltarsByType(String paramString) {
    ArrayList<AltarInstance> arrayList = new ArrayList<>();
    for (AltarInstance altarInstance : this.altars.values()) {
      {
        if (altarInstance.getType().equalsIgnoreCase(paramString))
          arrayList.add(altarInstance);
      }} 
    return arrayList;
  }

  public boolean isAltarUsed(Location paramLocation) {
    Structure structure;
    BlockState blockState = paramLocation.getBlock().getState();
    if (blockState instanceof Structure) {
      structure = (Structure)blockState;
    } else {
      return false;
    } 
    return structure.getPersistentDataContainer().getOrDefault(this.altarUsedKey, PersistentDataType.BOOLEAN, false);
  }

  public void setAltarUsed(Location paramLocation, boolean paramBoolean) {
    Structure structure;
    BlockState blockState = paramLocation.getBlock().getState();
    if (blockState instanceof Structure) {
      structure = (Structure)blockState;
    } else {
      return;
    } 
    structure.getPersistentDataContainer().set(this.altarUsedKey, PersistentDataType.BOOLEAN, paramBoolean);
    structure.update();
  }

  public List<RecipeIngredient> getMissingIngredients(Player paramPlayer, AltarRecipe altarRecipe) {
    ArrayList<RecipeIngredient> arrayList = new ArrayList<>();
    for (RecipeIngredient recipeIngredient : altarRecipe.ingredients()) {
      int i = recipeIngredient.getAmount();
      int j = 0;
      for (ItemStack itemStack : paramPlayer.getInventory().getContents()) {
        {
          if (itemStack != null && recipeIngredient.matches(itemStack))
            j += itemStack.getAmount(); 
        }} 
      {
        if (j < i)
          arrayList.add(new RecipeIngredient(recipeIngredient.getMaterial(), i - j, recipeIngredient.getCustomModelData()));
      }} 
    return arrayList;
  }

  public static ItemStack createCustomModelItem(Material paramMaterial, int paramInt) {
    ItemStack itemStack = new ItemStack(paramMaterial);
    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta != null) {
      AltarManager.applyCustomModelData(itemMeta, paramInt);
      itemStack.setItemMeta(itemMeta);
    }
    return itemStack;
  }

  public void sendMissingIngredients(Player paramPlayer, List<RecipeIngredient> paramList) {
    if (paramList.isEmpty())
      return;
    paramPlayer.sendMessage(Component.text("Missing items:", NamedTextColor.RED, TextDecoration.BOLD));
    for (RecipeIngredient ingredient : paramList) {
      paramPlayer.sendMessage(Component.text()
          .append(Component.text("- " + ingredient.getAmount() + "x ", NamedTextColor.GRAY))
          .append(getIngredientDisplayName(ingredient).colorIfAbsent(NamedTextColor.WHITE))
          .build());
    }
  }

  private static Component getIngredientDisplayName(RecipeIngredient ingredient) {
    ItemStack referenceItem = createCustomModelItem(ingredient.getMaterial(), ingredient.getCustomModelData());
    CustomItemType itemType = CustomItemType.fromItem(referenceItem);
    if (itemType != null)
      return AltarManager.getItemDisplayName(itemType.getItem());
    CustomItem customItem = CustomItem.fromItem(referenceItem);
    if (customItem != null)
      return AltarManager.getItemDisplayName(customItem.getItem());
    return AltarManager.getItemDisplayName(referenceItem);
  }

  public void broadcastCraftAnnouncement(Player paramPlayer, ItemStack paramItemStack) {
    Component itemName = AltarManager.getItemDisplayName(paramItemStack);
    Bukkit.broadcast(Component.text()
        .append(Component.text(paramPlayer.getName(), NamedTextColor.WHITE, TextDecoration.BOLD))
        .append(Component.text(" has crafted the ", NamedTextColor.GOLD))
        .append(itemName.colorIfAbsent(NamedTextColor.GOLD).decorate(TextDecoration.BOLD))
        .append(Component.text("!", NamedTextColor.GOLD))
        .build());
    for (Player player : Bukkit.getOnlinePlayers())
      player.playSound(player.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F); 
  }

  public AltarInstance getAltarInstance(Location paramLocation) {
    return this.altars.get(paramLocation);
  }

  public static ItemStack createItemStack(String paramString) {
    try {
      CustomItem customItem = CustomItem.valueOf(paramString.toUpperCase());
      return customItem.getItem();
    } catch (IllegalArgumentException illegalArgumentException) {
      try {
        CustomItemType customItem = CustomItemType.valueOf(paramString.toUpperCase());
        return customItem.getItem();
      } catch (IllegalArgumentException illegalArgumentException1) {
        return new ItemStack(Material.NETHER_STAR);
      } 
    } 
  }

  public double getItemDisplayOffsetY() {
    return 1.0D;
  }

  public double getItemDisplayScale(String paramString) {
    try {
      return switch (CustomItemIds.ID_BY_ITEM[CustomItem.valueOf(paramString.toUpperCase()).ordinal()]) {
          case 1, 6, 11 -> 2.75D;
          case 2, 8, 9, 12, 13, 14, 15 -> 2.0D;
          case 4, 19 -> 2.3D;
          case 5, 7, 21, 24 -> 2.25D;
          case 10, 16 -> 2.5D;
          case 17 -> 1.85D;
          case 18 -> 2.1D;
          case 20, 22 -> 2.9D;
          case 23 -> 2.8D;
          default -> 1.75D;
        };
    } catch (IllegalArgumentException illegalArgumentException) {
      return 1.75D;
    } 
  }

  public boolean createAltar(Location paramLocation, String paramString) {
    Structure structure;
    Altar altar = this.plugin.getConfigManager().getAltar(paramString);
    {
      if (altar == null)
        return false; 
    }Block block = paramLocation.getBlock();
    block.setType(Material.STRUCTURE_BLOCK);
    BlockState blockState = block.getState();
    if (blockState instanceof Structure) {
      structure = (Structure)blockState;
    } else {
      return false;
    } 
    structure.setUsageMode(UsageMode.LOAD);
    structure.getPersistentDataContainer().set(this.altarTypeKey, PersistentDataType.STRING, paramString);
    structure.update();
    block.getChunk().addPluginChunkTicket(this.plugin);
    AltarInstance altarInstance = new AltarInstance(paramString, paramLocation);
    {
      if (!isAltarUsed(paramLocation))
        spawnItemDisplay(altarInstance, paramLocation, paramString);
    }
    spawnHologram(altarInstance, paramLocation, paramString, altar.ingredientDisplay());
    this.altars.put(paramLocation, altarInstance);
    saveAltar(paramLocation, paramString);
    return true;
  }

  @EventHandler
  public void onBlockBreak(BlockBreakEvent paramBlockBreakEvent) {
    {
      if (paramBlockBreakEvent.getBlock().getType() != Material.STRUCTURE_BLOCK)
        return; 
    }
    removeAltar(paramBlockBreakEvent.getBlock().getLocation());
  }

  public void loadAltars() {
    FileConfiguration fileConfiguration = this.plugin.getConfigManager().getAltarConfig();
    {
      if (!fileConfiguration.contains("altars"))
        return; 
    }for (String str1 : fileConfiguration.getConfigurationSection("altars").getKeys(false)) {
      String str2 = fileConfiguration.getString("altars." + str1 + ".world");
      World world = Bukkit.getWorld(str2);
      {
        if (world == null)
          continue; 
      }double d1 = fileConfiguration.getDouble("altars." + str1 + ".x");
      double d2 = fileConfiguration.getDouble("altars." + str1 + ".y");
      double d3 = fileConfiguration.getDouble("altars." + str1 + ".z");
      String str3 = fileConfiguration.getString("altars." + str1 + ".type");
      Location location = new Location(world, d1, d2, d3);
      {
        if (this.altars.containsKey(location))
          continue; 
      }location.getChunk().load(true);
      createAltar(location, str3);
    } 
  }

  public boolean removeAltar(Location paramLocation) {
    AltarInstance altarInstance = this.altars.remove(paramLocation);
    {
      if (altarInstance == null)
        return false; 
    }
    altarInstance.removeAllEntities();
    BlockState blockState = paramLocation.getBlock().getState();
    if (blockState instanceof Structure structure) {
      structure.getPersistentDataContainer().remove(this.altarTypeKey);
      structure.update();
    } 
    deleteAltarFromConfig(paramLocation);
    return true;
  }

  public void removeAllAltars() {
    this.altars.values().forEach(AltarInstance::removeAllEntities);
    this.altars.clear();
  }

  public void spawnItemDisplay(AltarInstance altarInstance, Location paramLocation, String paramString) {
    double d1 = getItemDisplayScale(paramString);
    double d2 = getItemDisplayOffsetY();
    Location location = paramLocation.clone().add(0.5D, d1, 0.5D);
    ItemDisplay itemDisplay = paramLocation.getWorld().spawn(location, ItemDisplay.class, display -> configureItemDisplay(paramString, d2, display));
    altarInstance.setItemDisplay(itemDisplay);
  }

  public void spawnHologram(AltarInstance altarInstance, Location paramLocation, String paramString, List<Component> paramList) {
    Altar bs = this.plugin.getConfigManager().getAltar(paramString);
    double d = (bs != null && bs.hologramHeight() > 0.0D) ? bs.hologramHeight() : this.plugin.getConfigManager().getHologramHeight();
    World world = paramLocation.getWorld();
    for (int i = 0; i < paramList.size(); i++) {
      Component component = paramList.get(paramList.size() - 1 - i);
      Location location = paramLocation.clone().add(0.5D, d + i * 0.25D, 0.5D);
      TextDisplay textDisplay = world.spawn(location, TextDisplay.class, display -> configureHologram(component, display));
      altarInstance.addHologram(textDisplay);
    }
  }

  public void startUpdateTask() {
    (new ItemDisplayRotationTask(this)).runTaskTimer(this.plugin, 0L, 1L);
  }

  public void saveAltar(Location paramLocation, String paramString) {
    FileConfiguration fileConfiguration = this.plugin.getConfigManager().getAltarConfig();
    String str = paramLocation.getWorld().getName() + "_" + paramLocation.getBlockX() + "_" + paramLocation.getBlockY() + "_" + paramLocation.getBlockZ();
    fileConfiguration.set("altars." + str + ".world", paramLocation.getWorld().getName());
    fileConfiguration.set("altars." + str + ".x", paramLocation.getX());
    fileConfiguration.set("altars." + str + ".y", paramLocation.getY());
    fileConfiguration.set("altars." + str + ".z", paramLocation.getZ());
    fileConfiguration.set("altars." + str + ".type", paramString);
    this.plugin.getConfigManager().saveAltarConfig();
  }

  public void deleteAltarFromConfig(Location paramLocation) {
    FileConfiguration fileConfiguration = this.plugin.getConfigManager().getAltarConfig();
    String str = paramLocation.getWorld().getName() + "_" + paramLocation.getBlockX() + "_" + paramLocation.getBlockY() + "_" + paramLocation.getBlockZ();
    fileConfiguration.set("altars." + str, null);
    this.plugin.getConfigManager().saveAltarConfig();
  }

  public static void configureHologram(Component paramComponent, TextDisplay paramTextDisplay) {
    paramTextDisplay.setShadowed(false);
    paramTextDisplay.setBillboard(Display.Billboard.CENTER);
    paramTextDisplay.setBackgroundColor(Color.fromARGB(0, 0, 0, 0));
    paramTextDisplay.setGravity(false);
    paramTextDisplay.setInvulnerable(true);
    paramTextDisplay.text(paramComponent);
  }

  public static void configureItemDisplay(String paramString, double paramDouble, ItemDisplay paramItemDisplay) {
    paramItemDisplay.setItemStack(createItemStack(paramString));
    paramItemDisplay.setInvulnerable(true);
    paramItemDisplay.setPersistent(true);
    Transformation transformation = paramItemDisplay.getTransformation();
    transformation.getScale().set(paramDouble);
    paramItemDisplay.setTransformation(transformation);
  }


}
