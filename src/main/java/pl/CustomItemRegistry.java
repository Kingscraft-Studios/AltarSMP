package pl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.EquippableComponent;
import org.bukkit.persistence.PersistentDataType;
import java.util.HashMap;

public class CustomItemRegistry {
  private static FileConfiguration messagesConfig;
  
  private static int quickChargeLevel;
  
  private static final Map<String, List<String>> loreCache;
  
  static ItemStack boneBlade;
  
  static ItemStack vulcanCrossbow;
  
  static ItemStack nukeRemote;
  
  static ItemStack strikerBow;
  
  static ItemStack bloodlust;
  
  static ItemStack crazySlots;
  
  static ItemStack hyperion;
  
  static ItemStack nightpiercer;
  
  static ItemStack pureBlade;
  
  static ItemStack earthGauntlet;
  
  static ItemStack witheredBone;
  
  static ItemStack shadowBlade;
  
  static ItemStack cutlass;
  
  static ItemStack paladinAxe;
  
  static ItemStack windweaver;
  
  static ItemStack paleCannon;
  
  static ItemStack echo;
  
  static ItemStack eclipse;
  
  static ItemStack knightfall;
  
  static ItemStack wardenHeart;
  
  static ItemStack weaponHandle;
  
  static ItemStack vulcanSkull;
  
  static ItemStack illusionCore;
  
  static ItemStack hyperionShard;
  
  static ItemStack vampireShard;
  
  static ItemStack paleShard;
  
  static ItemStack copperHelmet;
  
  static ItemStack copperChestplate;
  
  static ItemStack copperLeggings;
  
  static ItemStack copperBoots;
  
  static ItemStack copperPickaxe;
  
  static ItemStack contagionSignal;
  
  
  
  public static void loadMessages() {
    Main main = Main.getInstance();
    File file = new File(main.getDataFolder(), "messages.yml");
    {
      if (!file.exists())
        main.saveResource("messages.yml", false); 
    }YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
    InputStream inputStream = main.getResource("messages.yml");
    if (inputStream != null) {
      YamlConfiguration yamlConfiguration1 = YamlConfiguration.loadConfiguration(new InputStreamReader(inputStream));
      yamlConfiguration.setDefaults((Configuration)yamlConfiguration1);
      yamlConfiguration.options().copyDefaults(true);
      try {
        yamlConfiguration.save(file);
      } catch (IOException iOException) {
        throw new RuntimeException(iOException);
      } 
    } 
    {
      if (!file.exists())
        Main.getInstance().saveResource("messages.yml", false); 
    }
    messagesConfig = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
  }
  
  private static List<String> getLore(String paramString) {
    return loreCache.computeIfAbsent(paramString, paramKey1 -> loadLore(paramKey1));
  }
  
  public static ItemStack getBoneBlade() {
    {
      if (boneBlade != null)
        return boneBlade;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    String str =String.valueOf(ChatColor.of("#eac492")) + String.valueOf(ChatColor.BOLD) + "B" + String.valueOf(ChatColor.of("#eed7b0")) + String.valueOf(ChatColor.BOLD) + "o" + String.valueOf(ChatColor.of("#f1e6ca")) + String.valueOf(ChatColor.BOLD) + "n" + String.valueOf(ChatColor.of("#f4f0e0")) + String.valueOf(ChatColor.BOLD) + "e" + String.valueOf(ChatColor.of("#f7f5f4")) + String.valueOf(ChatColor.BOLD) + " " + String.valueOf(ChatColor.of("#f6efdf")) + String.valueOf(ChatColor.BOLD) + "B" + String.valueOf(ChatColor.of("#f5e5c6")) + String.valueOf(ChatColor.BOLD) + "l" + String.valueOf(ChatColor.of("#f4dcb4")) + String.valueOf(ChatColor.BOLD) + "a" + String.valueOf(ChatColor.of("#f3d4a9")) + String.valueOf(ChatColor.BOLD) + "d" + String.valueOf(ChatColor.of("#f3d9a7")) + String.valueOf(ChatColor.BOLD) + "e";
    itemMeta.setLore(getLore("bone_blade"));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    itemMeta.setDisplayName(str);
    itemMeta.setCustomModelData(Integer.valueOf(1));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "bone"));
    itemMeta.setUnbreakable(true);
    itemStack.setItemMeta(itemMeta);
    boneBlade = itemStack;
    return itemStack;
  }
  
  public static ItemStack getVulcanCrossbow() {
    {
      if (vulcanCrossbow != null)
        return vulcanCrossbow;
    }ItemStack itemStack = new ItemStack(Material.CROSSBOW);
    ItemMeta itemMeta = itemStack.getItemMeta();
    String str =String.valueOf(ChatColor.of("#ff4500")) + String.valueOf(ChatColor.BOLD) + "V" + String.valueOf(ChatColor.of("#ff5a17")) + String.valueOf(ChatColor.BOLD) + "u" + String.valueOf(ChatColor.of("#ff6e2f")) + String.valueOf(ChatColor.BOLD) + "l" + String.valueOf(ChatColor.of("#ff8144")) + String.valueOf(ChatColor.BOLD) + "c" + String.valueOf(ChatColor.of("#ff9257")) + String.valueOf(ChatColor.BOLD) + "a" + String.valueOf(ChatColor.of("#ffa068")) + String.valueOf(ChatColor.BOLD) + "n" + String.valueOf(ChatColor.of("#ffab6f")) + String.valueOf(ChatColor.BOLD) + "'" + String.valueOf(ChatColor.of("#ffb067")) + String.valueOf(ChatColor.BOLD) + "s" + String.valueOf(ChatColor.of("#ffa462")) + String.valueOf(ChatColor.BOLD) + " " + String.valueOf(ChatColor.of("#ff9257")) + String.valueOf(ChatColor.BOLD) + "C" + String.valueOf(ChatColor.of("#ff8144")) + String.valueOf(ChatColor.BOLD) + "r" + String.valueOf(ChatColor.of("#ff6e2f")) + String.valueOf(ChatColor.BOLD) + "o" + String.valueOf(ChatColor.of("#ff5a17")) + String.valueOf(ChatColor.BOLD) + "s" + String.valueOf(ChatColor.of("#ff4500")) + String.valueOf(ChatColor.BOLD) + "s" + String.valueOf(ChatColor.of("#ff4500")) + String.valueOf(ChatColor.BOLD) + "b" + String.valueOf(ChatColor.of("#ff4500")) + String.valueOf(ChatColor.BOLD) + "o" + String.valueOf(ChatColor.of("#ff4500")) + String.valueOf(ChatColor.BOLD) + "w";
    itemMeta.addEnchant(Enchantment.QUICK_CHARGE, quickChargeLevel, true);
    itemMeta.setDisplayName(str);
    itemMeta.setCustomModelData(Integer.valueOf(1));
    itemMeta.setUnbreakable(true);
    itemMeta.setLore(getLore("vulcan_crossbow"));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "vulcan"));
    itemStack.setItemMeta(itemMeta);
    vulcanCrossbow = itemStack;
    return itemStack;
  }
  
  public static ItemStack getNukeRemote() {
    {
      if (nukeRemote != null)
        return nukeRemote;
    }ItemStack itemStack = new ItemStack(Material.CLAY_BALL);
    ItemMeta itemMeta = itemStack.getItemMeta();
    String str = "§c§lNuke Remote";
    itemMeta.setDisplayName(str);
    itemMeta.setCustomModelData(Integer.valueOf(12));
    itemMeta.setUnbreakable(true);
    itemMeta.setLore(getLore("nuke_remote"));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemStack.setItemMeta(itemMeta);
    nukeRemote = itemStack;
    return itemStack;
  }
  
  public static ItemStack getStrikerBow() {
    {
      if (strikerBow != null)
        return strikerBow;
    }ItemStack itemStack = new ItemStack(Material.BOW);
    ItemMeta itemMeta = itemStack.getItemMeta();
    String str = "§c§lStriker Bow";
    itemMeta.setDisplayName(str);
    itemMeta.setCustomModelData(Integer.valueOf(1));
    itemMeta.setUnbreakable(true);
    itemMeta.addEnchant(Enchantment.POWER, 5, true);
    itemMeta.setLore(getLore("striker"));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemStack.setItemMeta(itemMeta);
    strikerBow = itemStack;
    return itemStack;
  }
  
  public static ItemStack getBloodlust(Player paramPlayer, boolean paramBoolean) {
    {
      if (bloodlust != null)
        return bloodlust;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    {
      if (paramBoolean)
        (Main.getInstance()).bloodLustKillTracker.setKillCount(paramPlayer, 10);
    }itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
    itemMeta.setCustomModelData(Integer.valueOf(3));
    String str =String.valueOf(ChatColor.of("#8b0000")) + String.valueOf(ChatColor.BOLD) + "B" + String.valueOf(ChatColor.of("#9e0000")) + String.valueOf(ChatColor.BOLD) + "l" + String.valueOf(ChatColor.of("#b10000")) + String.valueOf(ChatColor.BOLD) + "o" + String.valueOf(ChatColor.of("#c40000")) + String.valueOf(ChatColor.BOLD) + "o" + String.valueOf(ChatColor.of("#d70000")) + String.valueOf(ChatColor.BOLD) + "d" + String.valueOf(ChatColor.of("#ea0000")) + String.valueOf(ChatColor.BOLD) + "l" + String.valueOf(ChatColor.of("#f50000")) + String.valueOf(ChatColor.BOLD) + "u" + String.valueOf(ChatColor.of("#ff0000")) + String.valueOf(ChatColor.BOLD) + "s" + String.valueOf(ChatColor.of("#d20000")) + String.valueOf(ChatColor.BOLD) + "t";
    itemMeta.setDisplayName(str);
    itemMeta.setLore(getLore("bloodlust"));
    itemMeta.setUnbreakable(true);
    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ADDITIONAL_TOOLTIP });
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemStack.setItemMeta(itemMeta);
    bloodlust = itemStack;
    return itemStack;
  }
  
  public static ItemStack getFrostScythe() {
    ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    {
      if (Main.getInstance().getConfig().getBoolean("holdForThrowFrostScythe", true))
        ItemUtility.setConsumableData(itemStack, "frostScytheChargeDuration");
    }ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(4));
    itemMeta.setUnbreakable(true);
    String str =String.valueOf(ChatColor.of("#bfffff")) + String.valueOf(ChatColor.BOLD) + "F" + String.valueOf(ChatColor.of("#c9ffff")) + String.valueOf(ChatColor.BOLD) + "r" + String.valueOf(ChatColor.of("#d3ffff")) + String.valueOf(ChatColor.BOLD) + "o" + String.valueOf(ChatColor.of("#ddffff")) + String.valueOf(ChatColor.BOLD) + "s" + String.valueOf(ChatColor.of("#e7ffff")) + String.valueOf(ChatColor.BOLD) + "t" + String.valueOf(ChatColor.of("#f1ffff")) + String.valueOf(ChatColor.BOLD) + " " + String.valueOf(ChatColor.of("#ffffff")) + String.valueOf(ChatColor.BOLD) + "S" + String.valueOf(ChatColor.of("#f1ffff")) + String.valueOf(ChatColor.BOLD) + "c" + String.valueOf(ChatColor.of("#e7ffff")) + String.valueOf(ChatColor.BOLD) + "y" + String.valueOf(ChatColor.of("#ddffff")) + String.valueOf(ChatColor.BOLD) + "t" + String.valueOf(ChatColor.of("#d3ffff")) + String.valueOf(ChatColor.BOLD) + "h" + String.valueOf(ChatColor.of("#c9ffff")) + String.valueOf(ChatColor.BOLD) + "e";
    itemMeta.setDisplayName(str);
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.setLore(getLore("frost_scythe"));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "frost"));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static ItemStack getIllusionWand() {
    ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemUtility.setConsumableData(itemStack, "IllusionWandChargeDuration");
    ItemMeta itemMeta = itemStack.getItemMeta();
    String str =String.valueOf(ChatColor.of("#872BA8")) + String.valueOf(ChatColor.BOLD) + "W" + String.valueOf(ChatColor.of("#932EAB")) + String.valueOf(ChatColor.BOLD) + "a" + String.valueOf(ChatColor.of("#9E31AE")) + String.valueOf(ChatColor.BOLD) + "n" + String.valueOf(ChatColor.of("#A934B1")) + String.valueOf(ChatColor.BOLD) + "d" + String.valueOf(ChatColor.of("#B237B4")) + String.valueOf(ChatColor.BOLD) + " " + String.valueOf(ChatColor.of("#BC3AB7")) + String.valueOf(ChatColor.BOLD) + "o" + String.valueOf(ChatColor.of("#C138B6")) + String.valueOf(ChatColor.BOLD) + "f" + String.valueOf(ChatColor.of("#B73AC0")) + String.valueOf(ChatColor.BOLD) + " " + String.valueOf(ChatColor.of("#AC3CC9")) + String.valueOf(ChatColor.BOLD) + "I" + String.valueOf(ChatColor.of("#A03FCF")) + String.valueOf(ChatColor.BOLD) + "l" + String.valueOf(ChatColor.of("#943FCC")) + String.valueOf(ChatColor.BOLD) + "l" + String.valueOf(ChatColor.of("#883FC9")) + String.valueOf(ChatColor.BOLD) + "u" + String.valueOf(ChatColor.of("#7D3FCA")) + String.valueOf(ChatColor.BOLD) + "s" + String.valueOf(ChatColor.of("#803CC6")) + String.valueOf(ChatColor.BOLD) + "i" + String.valueOf(ChatColor.of("#8539C2")) + String.valueOf(ChatColor.BOLD) + "o" + String.valueOf(ChatColor.of("#993CBE")) + String.valueOf(ChatColor.BOLD) + "n";
    itemMeta.setDisplayName(str);
    itemMeta.setLore(getLore("illusion_wand"));
    itemMeta.setCustomModelData(Integer.valueOf(2));
    itemMeta.setUnbreakable(true);
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "purple"));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static ItemStack getCrazySlots() {
    {
      if (crazySlots != null)
        return crazySlots;
    }ItemStack itemStack = new ItemStack(Material.CLAY_BALL);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(4));
    itemMeta.setMaxStackSize(Integer.valueOf(1));
    itemMeta.setDisplayName(String.valueOf(ChatColor.GOLD) + ChatColor.BOLD.toString() + "Crazy Slots");
    itemMeta.setUnbreakable(true);
    itemMeta.setLore(getLore("crazy_slots"));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "gold"));
    itemStack.setItemMeta(itemMeta);
    crazySlots = itemStack;
    return itemStack;
  }
  
  public static ItemStack getHyperion() {
    {
      if (hyperion != null)
        return hyperion;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setUnbreakable(true);
    itemMeta.setCustomModelData(Integer.valueOf(6));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
    itemMeta.setLore(getLore("hyperion"));
    String str2 = String.valueOf(ChatColor.BOLD);
    String str3 = String.valueOf(ChatColor.WHITE);
    String str4 = String.valueOf(ChatColor.BOLD);
    String str5 = String.valueOf(ChatColor.YELLOW);
    String str6 = String.valueOf(ChatColor.BOLD);
    String str7 = String.valueOf(ChatColor.GOLD);
    String str8 = String.valueOf(ChatColor.BOLD);
    String str9 = String.valueOf(ChatColor.of("#E27B41"));
    String str10 = String.valueOf(ChatColor.BOLD);
    String str11 = String.valueOf(ChatColor.GOLD);
    String str12 = String.valueOf(ChatColor.BOLD);
    String str13 = String.valueOf(ChatColor.YELLOW);
    String str14 = String.valueOf(ChatColor.BOLD);
    String str1 =String.valueOf(ChatColor.WHITE) + String.valueOf(ChatColor.BOLD) + "H" + String.valueOf(ChatColor.YELLOW) + String.valueOf(ChatColor.BOLD) + "y" + String.valueOf(ChatColor.GOLD) + String.valueOf(ChatColor.BOLD) + "p" + String.valueOf(ChatColor.of("#E27B41")) + String.valueOf(ChatColor.BOLD) + "er" + String.valueOf(ChatColor.GOLD) + String.valueOf(ChatColor.BOLD) + "i" + String.valueOf(ChatColor.YELLOW) + String.valueOf(ChatColor.BOLD) + "o" + String.valueOf(ChatColor.WHITE) + String.valueOf(ChatColor.BOLD) + "n";
    itemMeta.setDisplayName(str1);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "gold"));
    itemStack.setItemMeta(itemMeta);
    hyperion = itemStack;
    return itemStack;
  }
  
  public static ItemStack getNightpiercer() {
    {
      if (nightpiercer != null)
        return nightpiercer;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setLore(getLore("nightpiercer"));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    itemMeta.setCustomModelData(Integer.valueOf(5));
    itemMeta.setUnbreakable(true);
    String str =String.valueOf(ChatColor.of("#55131d")) + String.valueOf(ChatColor.BOLD) + "N" + String.valueOf(ChatColor.of("#5d1823")) + String.valueOf(ChatColor.BOLD) + "i" + String.valueOf(ChatColor.of("#652029")) + String.valueOf(ChatColor.BOLD) + "g" + String.valueOf(ChatColor.of("#6d2830")) + String.valueOf(ChatColor.BOLD) + "h" + String.valueOf(ChatColor.of("#753037")) + String.valueOf(ChatColor.BOLD) + "t" + String.valueOf(ChatColor.of("#7d383e")) + String.valueOf(ChatColor.BOLD) + "p" + String.valueOf(ChatColor.of("#86333d")) + String.valueOf(ChatColor.BOLD) + "i" + String.valueOf(ChatColor.of("#7d383e")) + String.valueOf(ChatColor.BOLD) + "e" + String.valueOf(ChatColor.of("#753037")) + String.valueOf(ChatColor.BOLD) + "r" + String.valueOf(ChatColor.of("#6d2830")) + String.valueOf(ChatColor.BOLD) + "c" + String.valueOf(ChatColor.of("#652029")) + String.valueOf(ChatColor.BOLD) + "e" + String.valueOf(ChatColor.of("#5d1823")) + String.valueOf(ChatColor.BOLD) + "r";
    itemMeta.setDisplayName(str);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemStack.setItemMeta(itemMeta);
    nightpiercer = itemStack;
    return itemStack;
  }
  
  public static ItemStack getPureBlade() {
    {
      if (pureBlade != null)
        return pureBlade;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    itemMeta.setLore(getLore("pure_blade"));
    itemMeta.setUnbreakable(true);
    itemMeta.setCustomModelData(Integer.valueOf(7));
    itemMeta.setDisplayName(String.valueOf(ChatColor.WHITE) + ChatColor.BOLD.toString() + "Pure Blade");
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "pure"));
    itemStack.setItemMeta(itemMeta);
    pureBlade = itemStack;
    return itemStack;
  }
  
  public static ItemStack getEarthGauntlet() {
    {
      if (earthGauntlet != null)
        return earthGauntlet;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    itemMeta.setLore(getLore("earth_gauntlet"));
    itemMeta.setCustomModelData(Integer.valueOf(8));
    itemMeta.setUnbreakable(true);
    String str = ColorUtil.translateColors("&#FACA8C&lE&#FBD39F&la&#FCDCB2&lr&#FDE5C6&lt&#FDEDD9&lh &#FFFFFF&lG&#FEF7EF&la&#FEF0DE&lu&#FDE8CE&ln&#FCE1BD&lt&#FBD9AD&ll&#FBD29C&le&#FACA8C&lt");
    itemMeta.setDisplayName(ChatColor.BOLD.toString() + str);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "earth"));
    itemStack.setItemMeta(itemMeta);
    earthGauntlet = itemStack;
    return itemStack;
  }
  
  public static ItemStack getWitheredBone() {
    {
      if (witheredBone != null)
        return witheredBone;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setLore(getLore("withered_bone"));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    itemMeta.setCustomModelData(Integer.valueOf(9));
    itemMeta.setUnbreakable(true);
    String str = ColorUtil.translateColors("&#424242&lW&#424242&li&#424242&lt&#424242&lh&#4C4C4C&le&#555555&lr&#5F5F5F&le&#686868&ld &#7C7C7C&lB&#858585&lo&#8F8F8F&ln&#989898&le &#ACACAC&lB&#B5B5B5&ll&#BFBFBF&la&#C8C8C8&ld&#D2D2D2&le");
    itemMeta.setDisplayName(ChatColor.BOLD.toString() + str);
    itemStack.setItemMeta(itemMeta);
    witheredBone = itemStack;
    return itemStack;
  }
  
  public static ItemStack getShadowBlade() {
    {
      if (shadowBlade != null)
        return shadowBlade;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setLore(getLore("shadow_blade"));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.setCustomModelData(Integer.valueOf(10));
    itemMeta.setUnbreakable(true);
    String str2 = String.valueOf(ChatColor.BOLD);
    String str3 = String.valueOf(ChatColor.of("#888888"));
    String str4 = String.valueOf(ChatColor.BOLD);
    String str5 = String.valueOf(ChatColor.of("#747474"));
    String str6 = String.valueOf(ChatColor.BOLD);
    String str7 = String.valueOf(ChatColor.of("#6a6a6a"));
    String str8 = String.valueOf(ChatColor.BOLD);
    String str9 = String.valueOf(ChatColor.of("#606060"));
    String str10 = String.valueOf(ChatColor.BOLD);
    String str11 = String.valueOf(ChatColor.of("#565656"));
    String str12 = String.valueOf(ChatColor.BOLD);
    String str13 = String.valueOf(ChatColor.of("#4c4c4c"));
    String str14 = String.valueOf(ChatColor.BOLD);
    String str15 = String.valueOf(ChatColor.of("#424242"));
    String str16 = String.valueOf(ChatColor.BOLD);
    String str17 = String.valueOf(ChatColor.of("#383838"));
    String str18 = String.valueOf(ChatColor.BOLD);
    String str19 = String.valueOf(ChatColor.of("#2e2e2e"));
    String str20 = String.valueOf(ChatColor.BOLD);
    String str21 = String.valueOf(ChatColor.of("#242424"));
    String str22 = String.valueOf(ChatColor.BOLD);
    String str1 =String.valueOf(ChatColor.of("#1a1a1a")) + String.valueOf(ChatColor.BOLD) + "ѕ" + String.valueOf(ChatColor.of("#242424")) + String.valueOf(ChatColor.BOLD) + "ʜ" + String.valueOf(ChatColor.of("#2e2e2e")) + String.valueOf(ChatColor.BOLD) + "ᴀ" + String.valueOf(ChatColor.of("#383838")) + String.valueOf(ChatColor.BOLD) + "ᴅ" + String.valueOf(ChatColor.of("#424242")) + String.valueOf(ChatColor.BOLD) + "ᴏ" + String.valueOf(ChatColor.of("#4c4c4c")) + String.valueOf(ChatColor.BOLD) + "ᴡ " + String.valueOf(ChatColor.of("#565656")) + String.valueOf(ChatColor.BOLD) + "ʙ" + String.valueOf(ChatColor.of("#606060")) + String.valueOf(ChatColor.BOLD) + "ʟ" + String.valueOf(ChatColor.of("#6a6a6a")) + String.valueOf(ChatColor.BOLD) + "ᴀ" + String.valueOf(ChatColor.of("#747474")) + String.valueOf(ChatColor.BOLD) + "ᴅ" + String.valueOf(ChatColor.of("#888888")) + String.valueOf(ChatColor.BOLD) + "ᴇ";
    itemMeta.setDisplayName(ChatColor.BOLD.toString() + str1);
    itemStack.setItemMeta(itemMeta);
    shadowBlade = itemStack;
    return itemStack;
  }
  
  public static ItemStack getCutlass() {
    {
      if (cutlass != null)
        return cutlass;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setLore(getLore("cutlass"));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    itemMeta.setCustomModelData(Integer.valueOf(11));
    itemMeta.setUnbreakable(true);
    String str = ColorUtil.translateColors("&#65CFF5&lC&#98DFF8&lu&#CCEFFC&lt&#FFFFFF&ll&#CCEFFC&la&#98DFF8&ls&#65CFF5&ls");
    itemMeta.setDisplayName(String.valueOf(ChatColor.BOLD) + str);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "frost"));
    itemStack.setItemMeta(itemMeta);
    cutlass = itemStack;
    return itemStack;
  }
  
  public static ItemStack getPaladinAxe() {
    {
      if (paladinAxe != null)
        return paladinAxe;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_AXE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setLore(getLore("paladin_axe"));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.EFFICIENCY, 5, true);
    itemMeta.setCustomModelData(Integer.valueOf(2));
    itemMeta.setUnbreakable(true);
    String str = ColorUtil.translateColors("&#EEB215&lP&#F0BA2C&la&#F1C144&ll&#F3C95B&la&#F5D173&ld&#F7D98A&li&#F8E0A1&ln&#FAE8B9&l'&#FCF0D0&ls &#FFFFFF&lB&#FDF6E5&la&#FBEECB&lt&#F9E5B1&lt&#F7DD97&ll&#F6D47D&le &#F2C349&lA&#F0BB2F&lx&#EEB215&le");
    itemMeta.setDisplayName(str);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "gold"));
    itemStack.setItemMeta(itemMeta);
    paladinAxe = itemStack;
    return itemStack;
  }
  
  public static ItemStack getWindweaver() {
    {
      if (windweaver != null)
        return windweaver;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    String str = "§x§7§8§C§5§C§0§lᴡ§x§9§0§C§F§C§A§lɪ§x§A§9§D§8§D§5§lɴ§x§C§1§E§2§D§F§lᴅ§x§D§A§E§B§E§A§lᴡ§x§F§2§F§5§F§4§lᴇ§x§D§4§E§9§E§7§lᴀ§x§B§5§D§D§D§A§lᴠ§x§9§7§D§1§C§D§lᴇ§x§7§8§C§5§C§0§lʀ";
    itemMeta.setDisplayName(str);
    itemMeta.setCustomModelData(Integer.valueOf(12));
    itemMeta.setLore(getLore("windweaver"));
    itemMeta.setUnbreakable(true);
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "pure"));
    itemStack.setItemMeta(itemMeta);
    windweaver = itemStack;
    return itemStack;
  }
  
  public static ItemStack getPaleCannon() {
    {
      if (paleCannon != null)
        return paleCannon;
    }ItemStack itemStack = new ItemStack(Material.CROSSBOW);
    ItemMeta itemMeta = itemStack.getItemMeta();
    String str = "§x§9§A§9§9§9§9§lP§x§A§4§9§2§8§A§la§x§A§E§8§A§7§B§ll§x§B§8§8§3§6§C§le §x§C§C§7§4§4§E§lC§x§C§2§7§B§5§D§la§x§B§8§8§3§6§C§ln§x§A§E§8§A§7§B§ln§x§A§4§9§2§8§A§lo§x§9§A§9§9§9§9§ln";
    itemMeta.setDisplayName(str);
    itemMeta.setCustomModelData(Integer.valueOf(2));
    itemMeta.setLore(getLore("pale_cannon"));
    itemMeta.setUnbreakable(true);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "gold"));
    itemMeta.addEnchant(Enchantment.QUICK_CHARGE, 3, true);
    itemStack.setItemMeta(itemMeta);
    paleCannon = itemStack;
    return itemStack;
  }
  
  public static ItemStack getEcho() {
    {
      if (echo != null)
        return echo;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    String str = "§x§0§0§A§9§A§8§lEcho";
    itemMeta.setDisplayName(str);
    itemMeta.setCustomModelData(Integer.valueOf(13));
    itemMeta.setLore(getLore("echo"));
    itemMeta.setUnbreakable(true);
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "ancient"));
    itemStack.setItemMeta(itemMeta);
    echo = itemStack;
    return itemStack;
  }
  
  public static ItemStack getEclipse() {
    {
      if (eclipse != null)
        return eclipse;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    String str = "§f§lEclipse";
    itemMeta.setDisplayName(str);
    itemMeta.setCustomModelData(Integer.valueOf(14));
    itemMeta.setLore(getLore("eclipse"));
    itemMeta.setUnbreakable(true);
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "pure"));
    itemStack.setItemMeta(itemMeta);
    eclipse = itemStack;
    return itemStack;
  }
  
  public static ItemStack getKnightfall(Player paramPlayer, boolean paramBoolean) {
    {
      if (paramPlayer == null)
        {
          if (knightfall != null)
            return knightfall;
        }}ItemStack itemStack = new ItemStack(Material.MACE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    int i = 0;
    {
      if (paramBoolean || KnightFallKillTracker.bool) {
        (Main.getInstance()).knightFallKillTracker.setKillCount(paramPlayer, 10);
        itemMeta.addEnchant(Enchantment.WIND_BURST, 1, true);
        itemMeta.addEnchant(Enchantment.DENSITY, 5, true);
        i = 10;
      } 
    }if (paramPlayer != null)
      i = (Main.getInstance()).knightFallKillTracker.getKillCount(paramPlayer);
    String str = String.valueOf(i);
    {
      if (i >= 10) {
        itemMeta.setCustomModelData(Integer.valueOf(3));
      } else {
        {
          if (i >= 4) {
            itemMeta.setCustomModelData(Integer.valueOf(2));
          } else {
            itemMeta.setCustomModelData(Integer.valueOf(1));
          } 
        }} 
    }itemMeta.setDisplayName("§f§lKnightfall");
    ArrayList<String> arrayList = new ArrayList<>(getLore("knightfall"));
    arrayList.replaceAll(paramS -> replaceKnightfallKills(str, paramS));
    itemMeta.setLore(arrayList);
    itemMeta.setUnbreakable(true);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "pure"));
    itemMeta.getPersistentDataContainer().set(new NamespacedKey("altarsmp", "knightfall"), PersistentDataType.BOOLEAN, Boolean.valueOf(true));
    itemStack.setItemMeta(itemMeta);
    knightfall = itemStack;
    return itemStack;
  }
  
  public static ItemStack getWardenHeart() {
    {
      if (wardenHeart != null)
        return wardenHeart;
    }ItemStack itemStack = new ItemStack(Material.PAPER);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(5));
    String str =String.valueOf(ChatColor.of("#009999")) + String.valueOf(ChatColor.BOLD) + "W" + String.valueOf(ChatColor.of("#00a3a3")) + String.valueOf(ChatColor.BOLD) + "a" + String.valueOf(ChatColor.of("#00adad")) + String.valueOf(ChatColor.BOLD) + "r" + String.valueOf(ChatColor.of("#00b7b7")) + String.valueOf(ChatColor.BOLD) + "d" + String.valueOf(ChatColor.of("#00c1c1")) + String.valueOf(ChatColor.BOLD) + "e" + String.valueOf(ChatColor.of("#00cbcb")) + String.valueOf(ChatColor.BOLD) + "n" + String.valueOf(ChatColor.of("#00d5d5")) + String.valueOf(ChatColor.BOLD) + "'" + String.valueOf(ChatColor.of("#22cccc")) + String.valueOf(ChatColor.BOLD) + "s" + String.valueOf(ChatColor.of("#00c5c5")) + String.valueOf(ChatColor.BOLD) + " " + String.valueOf(ChatColor.of("#00b5b5")) + String.valueOf(ChatColor.BOLD) + "H" + String.valueOf(ChatColor.of("#00a7a7")) + String.valueOf(ChatColor.BOLD) + "e" + String.valueOf(ChatColor.of("#009f9f")) + String.valueOf(ChatColor.BOLD) + "a" + String.valueOf(ChatColor.of("#009797")) + String.valueOf(ChatColor.BOLD) + "r" + String.valueOf(ChatColor.of("#008f8f")) + String.valueOf(ChatColor.BOLD) + "t";
    itemMeta.setDisplayName(str);
    itemMeta.addEnchant(Enchantment.MENDING, 1, true);
    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "ancient"));
    itemMeta.setLore(List.of("§7Used to forge Mythical Weapons"));
    itemStack.setItemMeta(itemMeta);
    wardenHeart = itemStack;
    return itemStack;
  }
  
  public static ItemStack getWeaponHandle() {
    {
      if (weaponHandle != null)
        return weaponHandle;
    }ItemStack itemStack = new ItemStack(Material.PAPER);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(9));
    itemMeta.setDisplayName(String.valueOf(ChatColor.RED) + "Weapon Handle");
    itemMeta.setLore(getLore("weapon_handle"));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemStack.setItemMeta(itemMeta);
    weaponHandle = itemStack;
    return itemStack;
  }
  
  public static ItemStack getVulcanSkull() {
    {
      if (vulcanSkull != null)
        return vulcanSkull;
    }ItemStack itemStack = new ItemStack(Material.CLAY_BALL);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(3));
    itemMeta.setDisplayName(String.valueOf(ChatColor.RED) + "Vulcan's Skull");
    itemMeta.setLore(getLore("vulcans_skull"));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "vulcan"));
    itemStack.setItemMeta(itemMeta);
    vulcanSkull = itemStack;
    return itemStack;
  }
  
  public static ItemStack getIllusionCore() {
    {
      if (illusionCore != null)
        return illusionCore;
    }ItemStack itemStack = new ItemStack(Material.CLAY_BALL);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(1));
    itemMeta.setDisplayName(String.valueOf(ChatColor.LIGHT_PURPLE) + "Illusion Core");
    itemMeta.setLore(getLore("illusion_core"));
    itemMeta.addEnchant(Enchantment.MENDING, 1, true);
    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "purple"));
    itemStack.setItemMeta(itemMeta);
    illusionCore = itemStack;
    return itemStack;
  }
  
  public static ItemStack getHyperionShard() {
    {
      if (hyperionShard != null)
        return hyperionShard;
    }ItemStack itemStack = new ItemStack(Material.PAPER);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(String.valueOf(ChatColor.GOLD) + ChatColor.BOLD.toString() + "Hyperion Shard");
    itemMeta.setCustomModelData(Integer.valueOf(3));
    itemMeta.setLore(List.of("§7Used to forge the Hyperion"));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "gold"));
    itemStack.setItemMeta(itemMeta);
    hyperionShard = itemStack;
    return itemStack;
  }
  
  public static ItemStack getVampireShard() {
    {
      if (vampireShard != null)
        return vampireShard;
    }ItemStack itemStack = new ItemStack(Material.PAPER);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(String.valueOf(ChatColor.DARK_RED) + ChatColor.BOLD.toString() + "Vampire Shard");
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemMeta.setLore(List.of("§7Used to forge Nightpiercer"));
    itemMeta.setCustomModelData(Integer.valueOf(1));
    itemStack.setItemMeta(itemMeta);
    vampireShard = itemStack;
    return itemStack;
  }
  
  public static ItemStack getPaleShard() {
    {
      if (paleShard != null)
        return paleShard;
    }ItemStack itemStack = new ItemStack(Material.PAPER);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(String.valueOf(ChatColor.GRAY) + ChatColor.BOLD.toString() + "Pale Shard");
    itemMeta.setCustomModelData(Integer.valueOf(2));
    itemMeta.setLore(List.of("§7Used to forge the Pale Cannon"));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "pure"));
    itemStack.setItemMeta(itemMeta);
    paleShard = itemStack;
    return itemStack;
  }
  
  public static ItemStack getChestplateShard() {
    ItemStack itemStack = new ItemStack(Material.AMETHYST_SHARD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(66));
    itemMeta.setDisplayName(String.valueOf(ChatColor.of("#B06736")) + "§lChestplate Shard");
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "gold"));
    itemMeta.setLore(List.of("§7Used to forge the Copper Chestplate"));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static ItemStack getHelmetShard() {
    ItemStack itemStack = new ItemStack(Material.AMETHYST_SHARD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(67));
    itemMeta.setDisplayName(String.valueOf(ChatColor.of("#B06736")) + "§lHelmet Shard");
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "gold"));
    itemMeta.setLore(List.of("§7Used to forge the Copper Helmet"));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static ItemStack getCopperHelmet() {
    {
      if (copperHelmet != null)
        return copperHelmet;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_HELMET);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(1));
    itemMeta.setDisplayName(String.valueOf(ChatColor.of("#B06736")) + "Copper Helmet");
    EquippableComponent equippableComponent = itemMeta.getEquippable();
    equippableComponent.setSlot(EquipmentSlot.HEAD);
    equippableComponent.setModel(new NamespacedKey("custom", "copper"));
    itemMeta.setItemModel(new NamespacedKey("custom", "copper_helmet"));
    itemMeta.setEquippable(equippableComponent);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemMeta.setLore(getLore("copper_helmet"));
    itemMeta.setUnbreakable(true);
    itemMeta.addEnchant(Enchantment.PROTECTION, 4, true);
    itemMeta.addEnchant(Enchantment.RESPIRATION, 3, true);
    itemMeta.addEnchant(Enchantment.AQUA_AFFINITY, 1, true);
    itemMeta.addEnchant(Enchantment.UNBREAKING, 3, true);
    itemStack.setItemMeta(itemMeta);
    copperHelmet = itemStack;
    return itemStack;
  }
  
  public static ItemStack getCopperChestplate() {
    {
      if (copperChestplate != null)
        return copperChestplate; 
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_CHESTPLATE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(1));
    EquippableComponent equippableComponent = itemMeta.getEquippable();
    equippableComponent.setSlot(EquipmentSlot.CHEST);
    equippableComponent.setModel(new NamespacedKey("custom", "copper"));
    itemMeta.setItemModel(new NamespacedKey("custom", "copper_chestplate"));
    itemMeta.setEquippable(equippableComponent);
    itemMeta.setDisplayName(String.valueOf(ChatColor.of("#B06736")) + "Copper Chestplate");
    itemMeta.setLore(getLore("copper_chestplate"));
    itemMeta.setUnbreakable(true);
    itemMeta.addEnchant(Enchantment.PROTECTION, 4, true);
    itemMeta.addEnchant(Enchantment.MENDING, 1, true);
    itemMeta.addEnchant(Enchantment.UNBREAKING, 3, true);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemStack.setItemMeta(itemMeta);
    copperChestplate = itemStack;
    return itemStack;
  }
  
  public static ItemStack getCopperLeggings() {
    {
      if (copperLeggings != null)
        return copperLeggings;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_LEGGINGS);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(1));
    EquippableComponent equippableComponent = itemMeta.getEquippable();
    equippableComponent.setSlot(EquipmentSlot.LEGS);
    equippableComponent.setModel(new NamespacedKey("custom", "copper"));
    itemMeta.setItemModel(new NamespacedKey("custom", "copper_leggings"));
    itemMeta.setEquippable(equippableComponent);
    itemMeta.setDisplayName(String.valueOf(ChatColor.of("#B06736")) + "Copper Leggings");
    itemMeta.setLore(getLore("copper_leggings"));
    itemMeta.setUnbreakable(true);
    itemMeta.addEnchant(Enchantment.PROTECTION, 4, true);
    itemMeta.addEnchant(Enchantment.MENDING, 1, true);
    itemMeta.addEnchant(Enchantment.UNBREAKING, 3, true);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemStack.setItemMeta(itemMeta);
    copperLeggings = itemStack;
    return itemStack;
  }
  
  public static ItemStack getCopperBoots() {
    {
      if (copperBoots != null)
        return copperBoots;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_BOOTS);
    ItemMeta itemMeta = itemStack.getItemMeta();
    EquippableComponent equippableComponent = itemMeta.getEquippable();
    equippableComponent.setSlot(EquipmentSlot.FEET);
    equippableComponent.setModel(new NamespacedKey("custom", "copper"));
    itemMeta.setItemModel(new NamespacedKey("custom", "copper_boots"));
    itemMeta.setEquippable(equippableComponent);
    itemMeta.setDisplayName(String.valueOf(ChatColor.of("#B06736")) + "Copper Boots");
    itemMeta.setLore(getLore("copper_boots"));
    itemMeta.setCustomModelData(Integer.valueOf(1));
    itemMeta.setUnbreakable(true);
    itemMeta.addEnchant(Enchantment.PROTECTION, 4, true);
    itemMeta.addEnchant(Enchantment.FEATHER_FALLING, 4, true);
    itemMeta.addEnchant(Enchantment.SOUL_SPEED, 3, true);
    itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);
    itemMeta.addEnchant(Enchantment.UNBREAKING, 3, true);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemStack.setItemMeta(itemMeta);
    copperBoots = itemStack;
    return itemStack;
  }
  
  public static ItemStack getCopperPickaxe() {
    {
      if (copperPickaxe != null)
        return copperPickaxe;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_PICKAXE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(1));
    itemMeta.setDisplayName(String.valueOf(ChatColor.of("#B06736")) + "Copper Pickaxe");
    itemMeta.setLore(getLore("copper_pickaxe"));
    itemMeta.setUnbreakable(true);
    itemMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
    itemMeta.addEnchant(Enchantment.EFFICIENCY, 5, true);
    itemMeta.addEnchant(Enchantment.MENDING, 1, true);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemStack.setItemMeta(itemMeta);
    copperPickaxe = itemStack;
    return itemStack;
  }
  
  public static ItemStack getContagionSignal() {
    {
      if (contagionSignal != null)
        return contagionSignal;
    }ItemStack itemStack = new ItemStack(Material.PRISMARINE_SHARD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setItemModel(new NamespacedKey("minecraft", "contag"));
    itemMeta.setDisplayName("§aContagion Signal");
    itemMeta.setCustomModelData(Integer.valueOf(3278542));
    itemStack.setItemMeta(itemMeta);
    copperPickaxe = itemStack;
    return itemStack;
  }
  
  private static String replaceKnightfallKills(String paramString1, String paramString2) {
    return paramString2.replace("<kills>", paramString1);
  }
  
  private static List loadLore(String paramString) {
    return messagesConfig.getStringList("weapons." + paramString).stream().map(paramLore1 -> translateLoreColors(paramLore1)).toList();
  }
  
  private static String translateLoreColors(String paramString) {
    return paramString.replace("&", "§");
  }

  static {
    quickChargeLevel = Main.getInstance().getConfig().getInt("preEnchantedVulcanQuickchargeLevel", 1);
    loreCache = new HashMap<>();
    boneBlade = null;
    vulcanCrossbow = null;
    nukeRemote = null;
    strikerBow = null;
    bloodlust = null;
    crazySlots = null;
    hyperion = null;
    nightpiercer = null;
    pureBlade = null;
    earthGauntlet = null;
    witheredBone = null;
    shadowBlade = null;
    cutlass = null;
    paladinAxe = null;
    windweaver = null;
    paleCannon = null;
    echo = null;
    eclipse = null;
    knightfall = null;
    wardenHeart = null;
    weaponHandle = null;
    vulcanSkull = null;
    illusionCore = null;
    hyperionShard = null;
    vampireShard = null;
    paleShard = null;
    copperHelmet = null;
    copperChestplate = null;
    copperLeggings = null;
    copperBoots = null;
    copperPickaxe = null;
    contagionSignal = null;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */