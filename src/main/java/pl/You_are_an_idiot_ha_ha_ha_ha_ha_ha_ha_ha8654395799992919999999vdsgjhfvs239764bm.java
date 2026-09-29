package pl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Transformation;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bm implements Listener {
  public Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public final NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public final Map<Location, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new HashMap<>();
  
  public final NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bm(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new NamespacedKey((Plugin)paramMain, "altar_type");
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = new NamespacedKey((Plugin)paramMain, "altar_used");
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
  }
  
  public List<You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(String paramString) {
    ArrayList<You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1> arrayList = new ArrayList();
    for (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 : this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.values()) {
      {
        if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a().equalsIgnoreCase(paramString))
          arrayList.add(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1); 
      }} 
    return arrayList;
  }
  
  public boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(Location paramLocation) {
    Structure structure;
    BlockState blockState = paramLocation.getBlock().getState();
    if (blockState instanceof Structure) {
      structure = (Structure)blockState;
    } else {
      return false;
    } 
    return ((Boolean)structure.getPersistentDataContainer().getOrDefault(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d, PersistentDataType.BOOLEAN, Boolean.valueOf(false))).booleanValue();
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, boolean paramBoolean) {
    Structure structure;
    BlockState blockState = paramLocation.getBlock().getState();
    if (blockState instanceof Structure) {
      structure = (Structure)blockState;
    } else {
      return;
    } 
    structure.getPersistentDataContainer().set(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d, PersistentDataType.BOOLEAN, Boolean.valueOf(paramBoolean));
    structure.update();
  }
  
  public List<You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b2 paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b2) {
    ArrayList<You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4> arrayList = new ArrayList();
    for (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4 : paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b2.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a()) {
      int i = you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
      int j = 0;
      for (ItemStack itemStack : paramPlayer.getInventory().getContents()) {
        {
          if (itemStack != null && you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack))
            j += itemStack.getAmount(); 
        }} 
      {
        if (j < i)
          arrayList.add(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(), i - j, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b())); 
      }} 
    return arrayList;
  }
  
  public static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Material paramMaterial, int paramInt) {
    ItemStack itemStack = new ItemStack(paramMaterial);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(paramInt));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(String paramString) {
    {
      if (paramString != null)
        {
          if (!paramString.isEmpty()) {
            String[] arrayOfString = paramString.toLowerCase().split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (String str : arrayOfString) {
              {
                if (!str.isEmpty())
                  stringBuilder.append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).append(" "); 
              }} 
            return stringBuilder.toString().trim();
          } 
          return paramString;
        }}return paramString;
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, List<You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4> paramList) {
    {
      if (paramList.isEmpty())
        return; 
    }paramPlayer.sendMessage("§c§lMissing items:");
    for (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4 : paramList) {
      String str;
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = pl.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c));
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
        str = you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a().getItemMeta().getDisplayName();
      } else {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c));
        if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l != null) {
          str = you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0().getItemMeta().getDisplayName();
        } else {
          str = you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0().toString();
          str = str.toLowerCase().replace("_", " ");
          str = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(str);
        } 
      } 
      paramPlayer.sendMessage("§7- §7" + "§7- §7" + you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() + "x §f");
    } 
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, ItemStack paramItemStack) {
    String str1 = paramItemStack.getItemMeta().getDisplayName();
    String str3 = ChatColor.BOLD.toString();
    String str4 = String.valueOf(ChatColor.GOLD);
    String str5 = str1;
    String str6 = ChatColor.BOLD.toString();
    String str7 = ChatColor.BOLD.toString();
    String str8 = String.valueOf(ChatColor.GOLD);
    String str9 = paramPlayer.getName();
    String str10 = ChatColor.BOLD.toString();
    String str2 = String.valueOf(ChatColor.WHITE) + String.valueOf(ChatColor.WHITE) + str10 + str9 + str8 + str7 + " has crafted the " + str6 + str5 + str4 + str3;
    Bukkit.broadcastMessage(str2);
    for (Player player : Bukkit.getOnlinePlayers())
      player.playSound(player.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F); 
  }
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation) {
    return this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.get(paramLocation);
  }
  
  public static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v2(String paramString) {
    try {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.valueOf(paramString.toUpperCase());
      return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0();
    } catch (IllegalArgumentException illegalArgumentException) {
      try {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = pl.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.valueOf(paramString.toUpperCase());
        return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
      } catch (IllegalArgumentException illegalArgumentException1) {
        return new ItemStack(Material.NETHER_STAR);
      } 
    } 
  }
  
  public double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v3(String paramString) {
    try {
      switch (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bn.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a[You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.valueOf(paramString.toUpperCase()).ordinal()]) {
      
      } 
      return 1.0D;
    } catch (IllegalArgumentException illegalArgumentException) {
      return 1.0D;
    } 
  }
  
  public double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(String paramString) {
    try {
      {
        switch (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bn.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a[You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.valueOf(paramString.toUpperCase()).ordinal()]) {
          case 1:
          
          case 2:
          
          case 3:
          
          case 4:
          
          case 5:
          
          case 6:
          
          case 7:
          
          case 8:
          
          case 9:
          
          case 10:
          
          case 11:
          
          case 12:
          
          case 13:
          
          case 14:
          
          case 15:
          
          case 16:
          
          case 17:
          
          case 18:
          
          case 19:
          
        } 
      }return 1.75D;
    } catch (IllegalArgumentException illegalArgumentException) {
      return 1.75D;
    } 
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Location paramLocation) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.get(paramLocation);
    {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 == null)
        return; 
    }{
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, false);
      if (!you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0())
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1, paramLocation, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a()); 
    }}
  
  public boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Location paramLocation, String paramString) {
    Structure structure;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bs you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bs = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfigManager().You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v2(paramString);
    {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bs == null)
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
    structure.getPersistentDataContainer().set(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, PersistentDataType.STRING, paramString);
    structure.update();
    block.getChunk().addPluginChunkTicket((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1(paramString, paramLocation);
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(paramLocation))
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1, paramLocation, paramString); 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1, paramLocation, paramString, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bs.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1());
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.put(paramLocation, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, paramString);
    return true;
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(BlockBreakEvent paramBlockBreakEvent) {
    {
      if (paramBlockBreakEvent.getBlock().getType() != Material.STRUCTURE_BLOCK)
        return; 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramBlockBreakEvent.getBlock().getLocation());
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    FileConfiguration fileConfiguration = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfigManager().You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1();
    {
      if (!fileConfiguration.contains("altars"))
        return; 
    }for (String str1 : fileConfiguration.getConfigurationSection("altars").getKeys(false)) {
      String str2 = fileConfiguration.getString("altars." + "altars." + str1);
      World world = Bukkit.getWorld(str2);
      {
        if (world == null)
          continue; 
      }double d1 = fileConfiguration.getDouble("altars." + "altars." + str1);
      double d2 = fileConfiguration.getDouble("altars." + "altars." + str1);
      double d3 = fileConfiguration.getDouble("altars." + "altars." + str1);
      String str3 = fileConfiguration.getString("altars." + "altars." + str1);
      Location location = new Location(world, d1, d2, d3);
      {
        if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(location))
          continue; 
      }location.getChunk().load(true);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location, str3);
    } 
  }
  
  public boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(Location paramLocation) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(paramLocation);
    {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 == null)
        return false; 
    }you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove();
    BlockState blockState = paramLocation.getBlock().getState();
    if (blockState instanceof Structure) {
      Structure structure = (Structure)blockState;
      structure.getPersistentDataContainer().remove(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b);
      structure.update();
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramLocation);
    return true;
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.values().forEach(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1::You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.clear();
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1, Location paramLocation, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: aload_3
    //   2: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : (Ljava/lang/String;)D
    //   5: dstore #4
    //   7: aload_0
    //   8: aload_3
    //   9: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Ljava/lang/String;)D
    //   12: dstore #6
    //   14: aload_2
    //   15: invokevirtual clone : ()Lorg/bukkit/Location;
    //   18: ldc2_w 0.5
    //   21: dload #4
    //   23: ldc2_w 0.5
    //   26: invokevirtual add : (DDD)Lorg/bukkit/Location;
    //   29: astore #8
    //   31: aload_2
    //   32: invokevirtual getWorld : ()Lorg/bukkit/World;
    //   35: aload #8
    //   37: ldc org/bukkit/entity/ItemDisplay
    //   39: aload_3
    //   40: dload #6
    //   42: <illegal opcode> accept : (Ljava/lang/String;D)Ljava/util/function/Consumer;
    //   47: invokeinterface spawn : (Lorg/bukkit/Location;Ljava/lang/Class;Ljava/util/function/Consumer;)Lorg/bukkit/entity/Entity;
    //   52: checkcast org/bukkit/entity/ItemDisplay
    //   55: astore #9
    //   57: aload_1
    //   58: aload #9
    //   60: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/ItemDisplay;)V
    //   63: return
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1, Location paramLocation, String paramString, List<String> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: getfield You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Lpl/Main;
    //   4: invokevirtual getConfigManager : ()Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764br;
    //   7: aload_3
    //   8: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Ljava/lang/String;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bs;
    //   11: astore #5
    //   13: aload #5
    //   15: ifnull -> 47
    //   18: aload #5
    //   20: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : ()D
    //   23: dconst_0
    //   24: dcmpl
    //   25: ifle -> 47
    //   28: goto -> 35
    //   31: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   34: athrow
    //   35: aload #5
    //   37: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : ()D
    //   40: goto -> 57
    //   43: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   46: athrow
    //   47: aload_0
    //   48: getfield You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Lpl/Main;
    //   51: invokevirtual getConfigManager : ()Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764br;
    //   54: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : ()D
    //   57: dstore #6
    //   59: aload_2
    //   60: invokevirtual getWorld : ()Lorg/bukkit/World;
    //   63: astore #8
    //   65: iconst_0
    //   66: istore #9
    //   68: iload #9
    //   70: aload #4
    //   72: invokeinterface size : ()I
    //   77: if_icmpge -> 164
    //   80: aload #4
    //   82: aload #4
    //   84: invokeinterface size : ()I
    //   89: iconst_1
    //   90: isub
    //   91: iload #9
    //   93: isub
    //   94: invokeinterface get : (I)Ljava/lang/Object;
    //   99: checkcast java/lang/String
    //   102: astore #10
    //   104: aload_2
    //   105: invokevirtual clone : ()Lorg/bukkit/Location;
    //   108: ldc2_w 0.5
    //   111: dload #6
    //   113: iload #9
    //   115: i2d
    //   116: ldc2_w 0.25
    //   119: dmul
    //   120: dadd
    //   121: ldc2_w 0.5
    //   124: invokevirtual add : (DDD)Lorg/bukkit/Location;
    //   127: astore #11
    //   129: aload #8
    //   131: aload #11
    //   133: ldc org/bukkit/entity/TextDisplay
    //   135: aload #10
    //   137: <illegal opcode> accept : (Ljava/lang/String;)Ljava/util/function/Consumer;
    //   142: invokeinterface spawn : (Lorg/bukkit/Location;Ljava/lang/Class;Ljava/util/function/Consumer;)Lorg/bukkit/entity/Entity;
    //   147: checkcast org/bukkit/entity/TextDisplay
    //   150: astore #12
    //   152: aload_1
    //   153: aload #12
    //   155: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/TextDisplay;)V
    //   158: iinc #9, 1
    //   161: goto -> 68
    //   164: return
    // Exception table:
    //   from	to	target	type
    //   13	28	31	java/lang/IllegalArgumentException
    //   18	43	43	java/lang/IllegalArgumentException
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c() {
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764go(this)).runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 0L, 1L);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, String paramString) {
    FileConfiguration fileConfiguration = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfigManager().You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1();
    String str = paramLocation.getWorld().getName() + "_" + paramLocation.getWorld().getName() + "_" + paramLocation.getBlockX() + "_" + paramLocation.getBlockY();
    fileConfiguration.set("altars." + "altars." + str, paramLocation.getWorld().getName());
    fileConfiguration.set("altars." + "altars." + str, Double.valueOf(paramLocation.getX()));
    fileConfiguration.set("altars." + "altars." + str, Double.valueOf(paramLocation.getY()));
    fileConfiguration.set("altars." + "altars." + str, Double.valueOf(paramLocation.getZ()));
    fileConfiguration.set("altars." + "altars." + str, paramString);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfigManager().You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Location paramLocation) {
    FileConfiguration fileConfiguration = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfigManager().You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1();
    String str = paramLocation.getWorld().getName() + "_" + paramLocation.getWorld().getName() + "_" + paramLocation.getBlockX() + "_" + paramLocation.getBlockY();
    fileConfiguration.set("altars." + "altars.", null);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfigManager().You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
  }
  
  private static void lambda$spawnHologram$1(String paramString, TextDisplay paramTextDisplay) {
    paramTextDisplay.setShadowed(false);
    paramTextDisplay.setBillboard(Display.Billboard.CENTER);
    paramTextDisplay.setBackgroundColor(Color.fromARGB(0, 0, 0, 0));
    paramTextDisplay.setGravity(false);
    paramTextDisplay.setInvulnerable(true);
    paramTextDisplay.setText(ChatColor.translateAlternateColorCodes('&', paramString));
  }
  
  private static void lambda$spawnItemDisplay$0(String paramString, double paramDouble, ItemDisplay paramItemDisplay) {
    paramItemDisplay.setItemStack(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v2(paramString));
    paramItemDisplay.setInvulnerable(true);
    paramItemDisplay.setPersistent(true);
    Transformation transformation = paramItemDisplay.getTransformation();
    transformation.getScale().set(paramDouble);
    paramItemDisplay.setTransformation(transformation);
  }
  
  private static IllegalArgumentException a(IllegalArgumentException paramIllegalArgumentException) {
    return paramIllegalArgumentException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bm.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */