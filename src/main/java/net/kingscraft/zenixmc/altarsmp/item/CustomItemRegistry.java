package net.kingscraft.zenixmc.altarsmp.item;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.kingscraft.zenixmc.altarsmp.altarS2.AltarS2;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;
import org.bukkit.inventory.meta.components.EquippableComponent;
import org.bukkit.persistence.PersistentDataType;
import java.util.HashMap;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.weapon.knightfall.KnightFallKillTracker;
import net.kingscraft.zenixmc.altarsmp.util.ColorUtil;

public class CustomItemRegistry {
  public static FileConfiguration messagesConfig;

  public static int quickChargeLevel;

  private static final TextColor COPPER = TextColor.color(0xB06736);

  public static final Map<String, List<Component>> loreCache;

  public static ItemStack boneBlade;

  public static ItemStack vulcanCrossbow;

  public static ItemStack nukeRemote;

  public static ItemStack strikerBow;

  public static ItemStack bloodlust;

  public static ItemStack crazySlots;

  public static ItemStack hyperion;

  public static ItemStack nightpiercer;

  public static ItemStack pureBlade;

  public static ItemStack earthGauntlet;

  public static ItemStack witheredBone;

  public static ItemStack shadowBlade;

  public static ItemStack cutlass;

  public static ItemStack paladinAxe;

  public static ItemStack windweaver;

  public static ItemStack paleCannon;

  public static ItemStack echo;

  public static ItemStack eclipse;

  public static ItemStack knightfall;

  public static ItemStack wardenHeart;

  public static ItemStack weaponHandle;

  public static ItemStack vulcanSkull;

  public static ItemStack illusionCore;

  public static ItemStack hyperionShard;

  public static ItemStack vampireShard;

  public static ItemStack paleShard;

  public static ItemStack copperHelmet;

  public static ItemStack copperChestplate;

  public static ItemStack copperLeggings;

  public static ItemStack copperBoots;

  public static ItemStack copperPickaxe;

  public static ItemStack contagionSignal;

  public static ItemStack tidebreaker;

  public static ItemStack ancientBlade;

  public static ItemStack witherSymbiote;

  public static ItemStack omen;

  public static ItemStack dragonrend;


  public static void loadMessages() {
    AltarSMP main = AltarSMP.getInstance();
    File file = new File(main.getDataFolder(), "messages.yml");
    {
      if (!file.exists())
        main.saveResource("messages.yml", false); 
    }YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
    InputStream inputStream = main.getResource("messages.yml");
    if (inputStream != null) {
      YamlConfiguration yamlConfiguration1 = YamlConfiguration.loadConfiguration(new InputStreamReader(inputStream));
      yamlConfiguration.setDefaults(yamlConfiguration1);
      yamlConfiguration.options().copyDefaults(true);
      try {
        yamlConfiguration.save(file);
      } catch (IOException iOException) {
        throw new RuntimeException(iOException);
      } 
    } 
    {
      if (!file.exists())
        AltarSMP.getInstance().saveResource("messages.yml", false); 
    }
    messagesConfig = YamlConfiguration.loadConfiguration(file);
  }

  public static List<Component> getLore(String paramString) {
    return loreCache.computeIfAbsent(paramString, CustomItemRegistry::loadLore);
  }

  private static void setCustomModelData(ItemMeta itemMeta, int value) {
    CustomModelDataComponent component = itemMeta.getCustomModelDataComponent();
    component.setFloats(List.of((float) value));
    itemMeta.setCustomModelDataComponent(component);
  }

  private static Component gradientBold(String text, TextColor... colors) {
    TextComponent.Builder builder = Component.text();
    for (int i = 0; i < text.length(); i++)
      builder.append(Component.text(text.charAt(i), colors[i], TextDecoration.BOLD));
    return builder.build();
  }

  public static ItemStack getBoneBlade() {
    {
      if (boneBlade != null)
        return boneBlade;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.displayName(gradientBold("Bone Blade",
        TextColor.color(0xeac492), TextColor.color(0xeed7b0), TextColor.color(0xf1e6ca),
        TextColor.color(0xf4f0e0), TextColor.color(0xf7f5f4), TextColor.color(0xf6efdf),
        TextColor.color(0xf5e5c6), TextColor.color(0xf4dcb4), TextColor.color(0xf3d4a9),
        TextColor.color(0xf3d9a7)));
    itemMeta.lore(getLore("bone_blade"));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    setCustomModelData(itemMeta, 1);
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
    itemMeta.displayName(gradientBold("Vulcan's Crossbow",
        TextColor.color(0xff4500), TextColor.color(0xff5a17), TextColor.color(0xff6e2f),
        TextColor.color(0xff8144), TextColor.color(0xff9257), TextColor.color(0xffa068),
        TextColor.color(0xffab6f), TextColor.color(0xffb067), TextColor.color(0xffa462),
        TextColor.color(0xff9257), TextColor.color(0xff8144), TextColor.color(0xff6e2f),
        TextColor.color(0xff5a17), TextColor.color(0xff4500), TextColor.color(0xff4500),
        TextColor.color(0xff4500), TextColor.color(0xff4500)));
    itemMeta.addEnchant(Enchantment.QUICK_CHARGE, quickChargeLevel, true);
    setCustomModelData(itemMeta, 1);
    itemMeta.setUnbreakable(true);
    itemMeta.lore(getLore("vulcan_crossbow"));
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
    itemMeta.displayName(Component.text("Nuke Remote", NamedTextColor.RED, TextDecoration.BOLD));
    setCustomModelData(itemMeta, 12);
    itemMeta.setUnbreakable(true);
    itemMeta.lore(getLore("nuke_remote"));
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
    itemMeta.displayName(Component.text("Striker Bow", NamedTextColor.RED, TextDecoration.BOLD));
    setCustomModelData(itemMeta, 1);
    itemMeta.setUnbreakable(true);
    itemMeta.addEnchant(Enchantment.POWER, 5, true);
    itemMeta.lore(getLore("striker"));
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
        (AltarSMP.getInstance()).bloodLustKillTracker.setKillCount(paramPlayer, 10);
    }itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
    setCustomModelData(itemMeta, 3);
    itemMeta.displayName(gradientBold("Bloodlust",
        TextColor.color(0x8b0000), TextColor.color(0x9e0000), TextColor.color(0xb10000),
        TextColor.color(0xc40000), TextColor.color(0xd70000), TextColor.color(0xea0000),
        TextColor.color(0xf50000), TextColor.color(0xff0000), TextColor.color(0xd20000)));
    itemMeta.lore(getLore("bloodlust"));
    itemMeta.setUnbreakable(true);
    itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
    itemMeta.setHideTooltip(true);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemStack.setItemMeta(itemMeta);
    bloodlust = itemStack;
    return itemStack;
  }

  public static ItemStack getFrostScythe() {
    ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    {
      if (AltarSMP.getInstance().getConfig().getBoolean("holdForThrowFrostScythe", true))
        ItemUtility.setConsumableData(itemStack, "frostScytheChargeDuration");
    }ItemMeta itemMeta = itemStack.getItemMeta();
    setCustomModelData(itemMeta, 4);
    itemMeta.setUnbreakable(true);
    itemMeta.displayName(gradientBold("Frost Scythe",
        TextColor.color(0xbfffff), TextColor.color(0xc9ffff), TextColor.color(0xd3ffff),
        TextColor.color(0xddffff), TextColor.color(0xe7ffff), TextColor.color(0xf1ffff),
        TextColor.color(0xffffff), TextColor.color(0xf1ffff), TextColor.color(0xe7ffff),
        TextColor.color(0xddffff), TextColor.color(0xd3ffff), TextColor.color(0xc9ffff)));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.lore(getLore("frost_scythe"));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "frost"));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  public static ItemStack getIllusionWand() {
    ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemUtility.setConsumableData(itemStack, "IllusionWandChargeDuration");
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.displayName(gradientBold("Wand of Illusion",
        TextColor.color(0x872BA8), TextColor.color(0x932EAB), TextColor.color(0x9E31AE),
        TextColor.color(0xA934B1), TextColor.color(0xB237B4), TextColor.color(0xBC3AB7),
        TextColor.color(0xC138B6), TextColor.color(0xB73AC0), TextColor.color(0xAC3CC9),
        TextColor.color(0xA03FCF), TextColor.color(0x943FCC), TextColor.color(0x883FC9),
        TextColor.color(0x7D3FCA), TextColor.color(0x803CC6), TextColor.color(0x8539C2),
        TextColor.color(0x993CBE)));
    itemMeta.lore(getLore("illusion_wand"));
    setCustomModelData(itemMeta, 2);
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
    setCustomModelData(itemMeta, 4);
    itemMeta.setMaxStackSize(1);
    itemMeta.displayName(Component.text("Crazy Slots", NamedTextColor.GOLD, TextDecoration.BOLD));
    itemMeta.setUnbreakable(true);
    itemMeta.lore(getLore("crazy_slots"));
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
    setCustomModelData(itemMeta, 6);
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
    itemMeta.lore(getLore("hyperion"));
    itemMeta.displayName(gradientBold("Hyperion",
        NamedTextColor.WHITE, NamedTextColor.YELLOW, NamedTextColor.GOLD,
        TextColor.color(0xE27B41), TextColor.color(0xE27B41), NamedTextColor.GOLD,
        NamedTextColor.YELLOW, NamedTextColor.WHITE));
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
    itemMeta.lore(getLore("nightpiercer"));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    setCustomModelData(itemMeta, 5);
    itemMeta.setUnbreakable(true);
    itemMeta.displayName(gradientBold("Nightpiercer",
        TextColor.color(0x55131d), TextColor.color(0x5d1823), TextColor.color(0x652029),
        TextColor.color(0x6d2830), TextColor.color(0x753037), TextColor.color(0x7d383e),
        TextColor.color(0x86333d), TextColor.color(0x7d383e), TextColor.color(0x753037),
        TextColor.color(0x6d2830), TextColor.color(0x652029), TextColor.color(0x5d1823)));
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
    itemMeta.lore(getLore("pure_blade"));
    itemMeta.setUnbreakable(true);
    setCustomModelData(itemMeta, 7);
    itemMeta.displayName(Component.text("Pure Blade", NamedTextColor.WHITE, TextDecoration.BOLD));
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
    itemMeta.lore(getLore("earth_gauntlet"));
    setCustomModelData(itemMeta, 8);
    itemMeta.setUnbreakable(true);
    itemMeta.displayName(ColorUtil.translateColors("&#FACA8C&lE&#FBD39F&la&#FCDCB2&lr&#FDE5C6&lt&#FDEDD9&lh &#FFFFFF&lG&#FEF7EF&la&#FEF0DE&lu&#FDE8CE&ln&#FCE1BD&lt&#FBD9AD&ll&#FBD29C&le&#FACA8C&lt"));
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
    itemMeta.lore(getLore("withered_bone"));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    setCustomModelData(itemMeta, 9);
    itemMeta.setUnbreakable(true);
    itemMeta.displayName(ColorUtil.translateColors("&#424242&lW&#424242&li&#424242&lt&#424242&lh&#4C4C4C&le&#555555&lr&#5F5F5F&le&#686868&ld &#7C7C7C&lB&#858585&lo&#8F8F8F&ln&#989898&le &#ACACAC&lB&#B5B5B5&ll&#BFBFBF&la&#C8C8C8&ld&#D2D2D2&le"));
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
    itemMeta.lore(getLore("shadow_blade"));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    setCustomModelData(itemMeta, 10);
    itemMeta.setUnbreakable(true);
    itemMeta.displayName(gradientBold("ѕʜᴀᴅᴏᴡ ʙʟᴀᴅᴇ",
        TextColor.color(0x1a1a1a), TextColor.color(0x242424), TextColor.color(0x2e2e2e),
        TextColor.color(0x383838), TextColor.color(0x424242), TextColor.color(0x4c4c4c),
        TextColor.color(0x4c4c4c), TextColor.color(0x565656), TextColor.color(0x606060),
        TextColor.color(0x6a6a6a), TextColor.color(0x747474), TextColor.color(0x888888)));
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
    itemMeta.lore(getLore("cutlass"));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    setCustomModelData(itemMeta, 11);
    itemMeta.setUnbreakable(true);
    itemMeta.displayName(ColorUtil.translateColors("&#65CFF5&lC&#98DFF8&lu&#CCEFFC&lt&#FFFFFF&ll&#CCEFFC&la&#98DFF8&ls&#65CFF5&ls"));
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
    itemMeta.lore(getLore("paladin_axe"));
    itemMeta.addEnchant(Enchantment.SHARPNESS, 5, true);
    itemMeta.addEnchant(Enchantment.EFFICIENCY, 5, true);
    setCustomModelData(itemMeta, 2);
    itemMeta.setUnbreakable(true);
    itemMeta.displayName(ColorUtil.translateColors("&#EEB215&lP&#F0BA2C&la&#F1C144&ll&#F3C95B&la&#F5D173&ld&#F7D98A&li&#F8E0A1&ln&#FAE8B9&l'&#FCF0D0&ls &#FFFFFF&lB&#FDF6E5&la&#FBEECB&lt&#F9E5B1&lt&#F7DD97&ll&#F6D47D&le &#F2C349&lA&#F0BB2F&lx&#EEB215&le"));
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
    itemMeta.displayName(gradientBold("ᴡɪɴᴅᴡᴇᴀᴠᴇʀ",
        TextColor.color(0x78C5C0), TextColor.color(0x90CFCA), TextColor.color(0xA9D8D5),
        TextColor.color(0xC1E2DF), TextColor.color(0xDAEBEA), TextColor.color(0xF2F5F4),
        TextColor.color(0xD4E9E7), TextColor.color(0xB5DDDA), TextColor.color(0x97D1CD),
        TextColor.color(0x78C5C0)));
    setCustomModelData(itemMeta, 12);
    itemMeta.lore(getLore("windweaver"));
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
    itemMeta.displayName(gradientBold("Pale Cannon",
        TextColor.color(0x9A9999), TextColor.color(0xA4928A), TextColor.color(0xAE8A7B),
        TextColor.color(0xB8836C), TextColor.color(0xB8836C), TextColor.color(0xCC744E),
        TextColor.color(0xC27B5D), TextColor.color(0xB8836C), TextColor.color(0xAE8A7B),
        TextColor.color(0xA4928A), TextColor.color(0x9A9999)));
    setCustomModelData(itemMeta, 2);
    itemMeta.lore(getLore("pale_cannon"));
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
    itemMeta.displayName(Component.text("Echo", TextColor.color(0x00A9A8), TextDecoration.BOLD));
    setCustomModelData(itemMeta, 13);
    itemMeta.lore(getLore("echo"));
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
    itemMeta.displayName(Component.text("Eclipse", NamedTextColor.WHITE, TextDecoration.BOLD));
    setCustomModelData(itemMeta, 14);
    itemMeta.lore(getLore("eclipse"));
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
        (AltarSMP.getInstance()).knightFallKillTracker.setKillCount(paramPlayer, 10);
        itemMeta.addEnchant(Enchantment.WIND_BURST, 1, true);
        itemMeta.addEnchant(Enchantment.DENSITY, 5, true);
        i = 10;
      }
    }if (paramPlayer != null)
      i = (AltarSMP.getInstance()).knightFallKillTracker.getKillCount(paramPlayer);
    String str = String.valueOf(i);
    {
      if (i >= 10) {
        setCustomModelData(itemMeta, 3);
      } else {
        {
          if (i >= 4) {
            setCustomModelData(itemMeta, 2);
          } else {
            setCustomModelData(itemMeta, 1);
          }
        }}
    }itemMeta.displayName(Component.text("Knightfall", NamedTextColor.WHITE, TextDecoration.BOLD));
    ArrayList<Component> arrayList = new ArrayList<>(getLore("knightfall"));
    arrayList.replaceAll(paramComponent -> replaceKnightfallKills(str, paramComponent));
    itemMeta.lore(arrayList);
    itemMeta.setUnbreakable(true);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "pure"));
    itemMeta.getPersistentDataContainer().set(new NamespacedKey("altarsmp", "knightfall"), PersistentDataType.BOOLEAN, true);
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
    setCustomModelData(itemMeta, 5);
    itemMeta.displayName(gradientBold("Warden's Heart",
        TextColor.color(0x009999), TextColor.color(0x00a3a3), TextColor.color(0x00adad),
        TextColor.color(0x00b7b7), TextColor.color(0x00c1c1), TextColor.color(0x00cbcb),
        TextColor.color(0x00d5d5), TextColor.color(0x22cccc), TextColor.color(0x00c5c5),
        TextColor.color(0x00b5b5), TextColor.color(0x00a7a7), TextColor.color(0x009f9f),
        TextColor.color(0x009797), TextColor.color(0x008f8f)));
    itemMeta.addEnchant(Enchantment.MENDING, 1, true);
    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "ancient"));
    itemMeta.lore(List.of(Component.text("Used to forge Mythical Weapons", NamedTextColor.GRAY)));
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
    setCustomModelData(itemMeta, 9);
    itemMeta.displayName(Component.text("Weapon Handle", NamedTextColor.RED));
    itemMeta.lore(getLore("weapon_handle"));
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
    setCustomModelData(itemMeta, 3);
    itemMeta.displayName(Component.text("Vulcan's Skull", NamedTextColor.RED));
    itemMeta.lore(getLore("vulcans_skull"));
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
    setCustomModelData(itemMeta, 1);
    itemMeta.displayName(Component.text("Illusion Core", NamedTextColor.LIGHT_PURPLE));
    itemMeta.lore(getLore("illusion_core"));
    itemMeta.addEnchant(Enchantment.MENDING, 1, true);
    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
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
    itemMeta.displayName(Component.text("Hyperion Shard", NamedTextColor.GOLD, TextDecoration.BOLD));
    setCustomModelData(itemMeta, 3);
    itemMeta.lore(List.of(Component.text("Used to forge the Hyperion", NamedTextColor.GRAY)));
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
    itemMeta.displayName(Component.text("Vampire Shard", NamedTextColor.DARK_RED, TextDecoration.BOLD));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemMeta.lore(List.of(Component.text("Used to forge Nightpiercer", NamedTextColor.GRAY)));
    setCustomModelData(itemMeta, 1);
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
    itemMeta.displayName(Component.text("Pale Shard", NamedTextColor.GRAY, TextDecoration.BOLD));
    setCustomModelData(itemMeta, 2);
    itemMeta.lore(List.of(Component.text("Used to forge the Pale Cannon", NamedTextColor.GRAY)));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "pure"));
    itemStack.setItemMeta(itemMeta);
    paleShard = itemStack;
    return itemStack;
  }

  public static ItemStack getChestplateShard() {
    ItemStack itemStack = new ItemStack(Material.AMETHYST_SHARD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    setCustomModelData(itemMeta, 66);
    itemMeta.displayName(Component.text("Chestplate Shard", COPPER, TextDecoration.BOLD));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "gold"));
    itemMeta.lore(List.of(Component.text("Used to forge the Copper Chestplate", NamedTextColor.GRAY)));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  public static ItemStack getHelmetShard() {
    ItemStack itemStack = new ItemStack(Material.AMETHYST_SHARD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    setCustomModelData(itemMeta, 67);
    itemMeta.displayName(Component.text("Helmet Shard", COPPER, TextDecoration.BOLD));
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "gold"));
    itemMeta.lore(List.of(Component.text("Used to forge the Copper Helmet", NamedTextColor.GRAY)));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  public static ItemStack getCopperHelmet() {
    {
      if (copperHelmet != null)
        return copperHelmet;
    }ItemStack itemStack = new ItemStack(Material.NETHERITE_HELMET);
    ItemMeta itemMeta = itemStack.getItemMeta();
    setCustomModelData(itemMeta, 1);
    itemMeta.displayName(Component.text("Copper Helmet", COPPER));
    EquippableComponent equippableComponent = itemMeta.getEquippable();
    equippableComponent.setSlot(EquipmentSlot.HEAD);
    equippableComponent.setModel(new NamespacedKey("custom", "copper"));
    itemMeta.setItemModel(new NamespacedKey("custom", "copper_helmet"));
    itemMeta.setEquippable(equippableComponent);
    itemMeta.setTooltipStyle(new NamespacedKey("minecraft", "red"));
    itemMeta.lore(getLore("copper_helmet"));
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
    setCustomModelData(itemMeta, 1);
    EquippableComponent equippableComponent = itemMeta.getEquippable();
    equippableComponent.setSlot(EquipmentSlot.CHEST);
    equippableComponent.setModel(new NamespacedKey("custom", "copper"));
    itemMeta.setItemModel(new NamespacedKey("custom", "copper_chestplate"));
    itemMeta.setEquippable(equippableComponent);
    itemMeta.displayName(Component.text("Copper Chestplate", COPPER));
    itemMeta.lore(getLore("copper_chestplate"));
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
    setCustomModelData(itemMeta, 1);
    EquippableComponent equippableComponent = itemMeta.getEquippable();
    equippableComponent.setSlot(EquipmentSlot.LEGS);
    equippableComponent.setModel(new NamespacedKey("custom", "copper"));
    itemMeta.setItemModel(new NamespacedKey("custom", "copper_leggings"));
    itemMeta.setEquippable(equippableComponent);
    itemMeta.displayName(Component.text("Copper Leggings", COPPER));
    itemMeta.lore(getLore("copper_leggings"));
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
    itemMeta.displayName(Component.text("Copper Boots", COPPER));
    itemMeta.lore(getLore("copper_boots"));
    setCustomModelData(itemMeta, 1);
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
    setCustomModelData(itemMeta, 1);
    itemMeta.displayName(Component.text("Copper Pickaxe", COPPER));
    itemMeta.lore(getLore("copper_pickaxe"));
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
    itemMeta.displayName(Component.text("Contagion Signal", NamedTextColor.GREEN));
    setCustomModelData(itemMeta, 3278542);
    itemStack.setItemMeta(itemMeta);
    copperPickaxe = itemStack;
    return itemStack;
  }

  public static Component replaceKnightfallKills(String paramString1, Component paramString2) {
    return paramString2.replaceText(TextReplacementConfig.builder()
        .matchLiteral("<kills>")
        .replacement(paramString1)
        .build());
  }

  public static ItemStack getTidebreaker() {
    if (tidebreaker != null)
      return tidebreaker;
    tidebreaker = buildSeasonTwoLegendary(Material.NETHERITE_SWORD, "Tidebreaker", "#55ffff", "#00aaee", "altar:item/tidebreaker", "minecraft:tidebreaker", "tidebreaker");
    return tidebreaker;
  }

  public static ItemStack getAncientBlade() {
    return getAncientBlade(null);
  }

  public static ItemStack getAncientBlade(Player paramPlayer) {
    ItemStack itemStack = buildSeasonTwoLegendary(Material.NETHERITE_SWORD, "Ancient Blade", "#55ffff", "#005555", "altar:item/ancientblade", "minecraft:ancient", "ancient_blade");
    int kills = 0;
    if (paramPlayer != null && AltarS2.isEnabled())
      kills = AltarS2.getKillTracker().getKillCount(paramPlayer);
    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta == null)
      return itemStack;
    List<Component> lore = itemMeta.lore();
    if (lore != null) {
      List<Component> updated = new ArrayList<>(lore);
      for (int i = 0; i < updated.size(); i++)
        updated.set(i, replaceKnightfallKills(String.valueOf(kills), updated.get(i)));
      itemMeta.lore(updated);
    }
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  public static ItemStack getWitherSymbiote() {
    if (witherSymbiote != null)
      return witherSymbiote;
    witherSymbiote = buildSeasonTwoLegendary(Material.NETHERITE_SWORD, "Wither Symbiote", "#555555", "#111111", "altar:item/withersymbiote", null, "wither_symbiote");
    return witherSymbiote;
  }

  public static ItemStack getOmen() {
    if (omen != null)
      return omen;
    omen = buildSeasonTwoLegendary(Material.NETHERITE_SPEAR, "Omen", "#55ffaa", "#00aa55", "altar:item/omen", "minecraft:omen", "omen");
    return omen;
  }

  public static ItemStack getDragonrend() {
    if (dragonrend != null)
      return dragonrend;
    dragonrend = buildSeasonTwoLegendary(Material.NETHERITE_SWORD, "Dragonrend", "#ff55ff", "#aa00aa", "altar:item/dragonrend", "minecraft:dragon", "dragonrend");
    return dragonrend;
  }

  private static ItemStack buildSeasonTwoLegendary(Material material, String displayName, String fromHex, String toHex, String itemModel, String tooltipStyle, String loreKey) {
    ItemStack itemStack = new ItemStack(material);
    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta == null)
      return itemStack;
    itemMeta.displayName(ColorUtil.gradient(displayName, fromHex, toHex));
    itemMeta.lore(getLore(loreKey));
    int sharpness = AltarSMP.getInstance().getConfig().getInt("sharpness", 7);
    itemMeta.addEnchant(Enchantment.SHARPNESS, sharpness, true);
    itemMeta.addEnchant(Enchantment.LOOTING, 3, true);
    itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
    itemMeta.setUnbreakable(true);
    itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
    itemMeta.setHideTooltip(true);
    itemMeta.setItemModel(NamespacedKey.fromString(itemModel));
    if (tooltipStyle != null)
      itemMeta.setTooltipStyle(NamespacedKey.fromString(tooltipStyle));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  public static ItemStack getDragonHeart() {
    return buildSeasonTwoItem(Material.CLAY_BALL, "Dragon Heart", "#580085", "#92058F", "altar:item/dragon");
  }

  public static ItemStack getSoulInABottle() {
    return buildSeasonTwoItem(Material.CLAY_BALL, "Soul in a Bottle", "#10B1C8", "#0F6199", "altar:item/soul");
  }

  public static ItemStack getFragmentOfTheSea() {
    return buildSeasonTwoItem(Material.PRISMARINE_SHARD, "Fragment of the Sea", "#10B1C8", "#0F6199", null);
  }

  public static ItemStack getNetheriteHarness() {
    ItemStack itemStack = new ItemStack(Material.PURPLE_HARNESS);
    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta == null)
      return itemStack;
    itemMeta.displayName(Component.text("Netherite Harness", NamedTextColor.BLACK, TextDecoration.BOLD));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  public static ItemStack getAmethystAxe() {
    return buildSeasonTwoItem(Material.NETHERITE_AXE, "Amethyst Axe", "#E087FF", "#E087FF", "custom:amethyst_axe", true);
  }

  public static ItemStack getAmethystPickaxe() {
    return buildSeasonTwoItem(Material.NETHERITE_PICKAXE, "Amethyst Pickaxe", "#E087FF", "#E087FF", "custom:amethyst_pickaxe", true);
  }

  public static ItemStack getVoidClock() {
    return buildSeasonTwoItem(Material.CLAY_BALL, "Void Clock", "#55ffff", "#555555", "altar:item/void1");
  }

  private static ItemStack buildSeasonTwoItem(Material material, String displayName, String fromHex, String toHex, String itemModel) {
    return buildSeasonTwoItem(material, displayName, fromHex, toHex, itemModel, false);
  }

  private static ItemStack buildSeasonTwoItem(Material material, String displayName, String fromHex, String toHex, String itemModel, boolean unbreakable) {
    ItemStack itemStack = new ItemStack(material);
    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta == null)
      return itemStack;
    itemMeta.displayName(fromHex == null || toHex == null
            ? Component.text(displayName)
            : ColorUtil.gradient(displayName, fromHex, toHex));
    if (itemModel != null)
      itemMeta.setItemModel(NamespacedKey.fromString(itemModel));
    if (unbreakable) {
      itemMeta.setUnbreakable(true);
      itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
    }
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  public static List<Component> loadLore(String paramString) {
    return messagesConfig.getStringList("weapons." + paramString).stream().map(CustomItemRegistry::translateLoreColors).toList();
  }

  public static Component translateLoreColors(String paramString) {
    return LegacyComponentSerializer.legacyAmpersand().deserialize(paramString);
  }

  static {
    quickChargeLevel = AltarSMP.getInstance().getConfig().getInt("preEnchantedVulcanQuickchargeLevel", 1);
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
    tidebreaker = null;
    ancientBlade = null;
    witherSymbiote = null;
    omen = null;
    dragonrend = null;
  }

}
