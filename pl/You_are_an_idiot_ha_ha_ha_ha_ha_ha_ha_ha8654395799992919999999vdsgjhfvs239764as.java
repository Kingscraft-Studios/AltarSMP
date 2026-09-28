package pl;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764as implements Listener {
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ItemStack paramItemStack1, ItemStack paramItemStack2) {
    try {
      if (paramItemStack1 != null) {
        try {
          if (paramItemStack2 == null)
            return false; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } else {
        return false;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramItemStack1.getType() != paramItemStack2.getType())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    ItemMeta itemMeta1 = paramItemStack1.getItemMeta();
    ItemMeta itemMeta2 = paramItemStack2.getItemMeta();
    try {
      if (itemMeta1 == null)
        try {
          if (itemMeta2 == null)
            return true; 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemMeta1 != null) {
        try {
          if (itemMeta2 == null)
            return false; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } else {
        return false;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!paramItemStack1.getItemMeta().getDisplayName().equals(paramItemStack2.getItemMeta().getDisplayName()))
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemMeta1.hasCustomModelData())
        try {
          if (itemMeta2.hasCustomModelData()) {
            try {
            
            } catch (MatchException matchException) {
              throw a(null);
            } 
            return (itemMeta1.getCustomModelData() == itemMeta2.getCustomModelData());
          } 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemMeta1.hasCustomModelData())
        try {
          if (!itemMeta2.hasCustomModelData());
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return false;
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EnchantItemEvent paramEnchantItemEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getItem : ()Lorg/bukkit/inventory/ItemStack;
    //   4: astore_2
    //   5: aload_1
    //   6: invokevirtual getEnchanter : ()Lorg/bukkit/entity/Player;
    //   9: astore_3
    //   10: aload_2
    //   11: aload_3
    //   12: iconst_0
    //   13: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : (Lorg/bukkit/entity/Player;Z)Lorg/bukkit/inventory/ItemStack;
    //   16: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/inventory/ItemStack;Lorg/bukkit/inventory/ItemStack;)Z
    //   19: ifne -> 27
    //   22: return
    //   23: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   26: athrow
    //   27: aload_1
    //   28: invokevirtual getEnchantsToAdd : ()Ljava/util/Map;
    //   31: getstatic org/bukkit/enchantments/Enchantment.DENSITY : Lorg/bukkit/enchantments/Enchantment;
    //   34: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   39: ifne -> 64
    //   42: aload_1
    //   43: invokevirtual getEnchantsToAdd : ()Ljava/util/Map;
    //   46: getstatic org/bukkit/enchantments/Enchantment.BREACH : Lorg/bukkit/enchantments/Enchantment;
    //   49: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   54: ifeq -> 98
    //   57: goto -> 64
    //   60: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   63: athrow
    //   64: invokestatic getInstance : ()Lpl/Main;
    //   67: getfield killTracker2 : Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au;
    //   70: aload_3
    //   71: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)I
    //   74: bipush #8
    //   76: if_icmpge -> 98
    //   79: goto -> 86
    //   82: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   85: athrow
    //   86: aload_1
    //   87: iconst_1
    //   88: invokevirtual setCancelled : (Z)V
    //   91: goto -> 98
    //   94: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   97: athrow
    //   98: aload_1
    //   99: invokevirtual getEnchantsToAdd : ()Ljava/util/Map;
    //   102: getstatic org/bukkit/enchantments/Enchantment.WIND_BURST : Lorg/bukkit/enchantments/Enchantment;
    //   105: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   110: ifeq -> 146
    //   113: invokestatic getInstance : ()Lpl/Main;
    //   116: getfield killTracker2 : Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au;
    //   119: aload_3
    //   120: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)I
    //   123: iconst_2
    //   124: if_icmpge -> 146
    //   127: goto -> 134
    //   130: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   133: athrow
    //   134: aload_1
    //   135: iconst_1
    //   136: invokevirtual setCancelled : (Z)V
    //   139: goto -> 146
    //   142: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   145: athrow
    //   146: return
    // Exception table:
    //   from	to	target	type
    //   10	23	23	java/lang/MatchException
    //   27	57	60	java/lang/MatchException
    //   42	79	82	java/lang/MatchException
    //   64	91	94	java/lang/MatchException
    //   98	127	130	java/lang/MatchException
    //   113	139	142	java/lang/MatchException
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PrepareAnvilEvent paramPrepareAnvilEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getResult : ()Lorg/bukkit/inventory/ItemStack;
    //   4: astore_2
    //   5: aload_1
    //   6: invokevirtual getView : ()Lorg/bukkit/inventory/view/AnvilView;
    //   9: invokeinterface getPlayer : ()Lorg/bukkit/entity/HumanEntity;
    //   14: checkcast org/bukkit/entity/Player
    //   17: astore_3
    //   18: aload_2
    //   19: ifnonnull -> 27
    //   22: return
    //   23: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   26: athrow
    //   27: aload_2
    //   28: aload_3
    //   29: iconst_0
    //   30: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : (Lorg/bukkit/entity/Player;Z)Lorg/bukkit/inventory/ItemStack;
    //   33: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/inventory/ItemStack;Lorg/bukkit/inventory/ItemStack;)Z
    //   36: ifne -> 44
    //   39: return
    //   40: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   43: athrow
    //   44: aload_2
    //   45: getstatic org/bukkit/enchantments/Enchantment.DENSITY : Lorg/bukkit/enchantments/Enchantment;
    //   48: invokevirtual containsEnchantment : (Lorg/bukkit/enchantments/Enchantment;)Z
    //   51: ifne -> 71
    //   54: aload_2
    //   55: getstatic org/bukkit/enchantments/Enchantment.BREACH : Lorg/bukkit/enchantments/Enchantment;
    //   58: invokevirtual containsEnchantment : (Lorg/bukkit/enchantments/Enchantment;)Z
    //   61: ifeq -> 121
    //   64: goto -> 71
    //   67: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   70: athrow
    //   71: invokestatic getInstance : ()Lpl/Main;
    //   74: getfield killTracker2 : Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au;
    //   77: aload_3
    //   78: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)I
    //   81: bipush #8
    //   83: if_icmpge -> 121
    //   86: goto -> 93
    //   89: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   92: athrow
    //   93: aload_2
    //   94: getstatic org/bukkit/enchantments/Enchantment.DENSITY : Lorg/bukkit/enchantments/Enchantment;
    //   97: invokevirtual removeEnchantment : (Lorg/bukkit/enchantments/Enchantment;)I
    //   100: pop
    //   101: aload_2
    //   102: getstatic org/bukkit/enchantments/Enchantment.BREACH : Lorg/bukkit/enchantments/Enchantment;
    //   105: invokevirtual removeEnchantment : (Lorg/bukkit/enchantments/Enchantment;)I
    //   108: pop
    //   109: aload_1
    //   110: aload_2
    //   111: invokevirtual setResult : (Lorg/bukkit/inventory/ItemStack;)V
    //   114: goto -> 121
    //   117: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   120: athrow
    //   121: aload_2
    //   122: getstatic org/bukkit/enchantments/Enchantment.WIND_BURST : Lorg/bukkit/enchantments/Enchantment;
    //   125: invokevirtual containsEnchantment : (Lorg/bukkit/enchantments/Enchantment;)Z
    //   128: ifeq -> 172
    //   131: invokestatic getInstance : ()Lpl/Main;
    //   134: getfield killTracker2 : Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au;
    //   137: aload_3
    //   138: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)I
    //   141: iconst_2
    //   142: if_icmpge -> 172
    //   145: goto -> 152
    //   148: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   151: athrow
    //   152: aload_2
    //   153: getstatic org/bukkit/enchantments/Enchantment.WIND_BURST : Lorg/bukkit/enchantments/Enchantment;
    //   156: invokevirtual removeEnchantment : (Lorg/bukkit/enchantments/Enchantment;)I
    //   159: pop
    //   160: aload_1
    //   161: aload_2
    //   162: invokevirtual setResult : (Lorg/bukkit/inventory/ItemStack;)V
    //   165: goto -> 172
    //   168: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   171: athrow
    //   172: return
    // Exception table:
    //   from	to	target	type
    //   18	23	23	java/lang/MatchException
    //   27	40	40	java/lang/MatchException
    //   44	64	67	java/lang/MatchException
    //   54	86	89	java/lang/MatchException
    //   71	114	117	java/lang/MatchException
    //   121	145	148	java/lang/MatchException
    //   131	165	168	java/lang/MatchException
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764as.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */