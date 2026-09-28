package pl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ax implements Listener {
  private static final Set<Material> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  private final Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public final Map<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new HashMap<>();
  
  public final Set<Player> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = Collections.newSetFromMap(new WeakHashMap<>());
  
  private final Map<Player, Boolean> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = new WeakHashMap<>();
  
  private BukkitTask You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  private BukkitTask You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  public boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  
  private static final String a;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ax(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = paramMain;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.getConfig().getBoolean(a, true);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b() {
    for (Player player : Bukkit.getOnlinePlayers())
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player); 
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c() {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e();
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f6(this)).runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, 0L, 1L);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f7(this)).runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, 0L, 10L);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerJoinEvent paramPlayerJoinEvent) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayerJoinEvent.getPlayer());
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerQuitEvent paramPlayerQuitEvent) {
    Player player = paramPlayerQuitEvent.getPlayer();
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(player);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.remove(player);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(player.getUniqueId());
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerMoveEvent paramPlayerMoveEvent) {
    try {
      if (paramPlayerMoveEvent.getTo() == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramPlayerMoveEvent.getFrom().getBlockX() == paramPlayerMoveEvent.getTo().getBlockX())
        try {
          if (paramPlayerMoveEvent.getFrom().getBlockY() == paramPlayerMoveEvent.getTo().getBlockY())
            try {
              if (paramPlayerMoveEvent.getFrom().getBlockZ() == paramPlayerMoveEvent.getTo().getBlockZ())
                return; 
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Player player = paramPlayerMoveEvent.getPlayer();
    try {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.contains(player))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, true);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer)) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.add(paramPlayer);
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.putIfAbsent(paramPlayer, Boolean.valueOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer)));
      } else {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(paramPlayer);
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.remove(paramPlayer);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, boolean paramBoolean) {
    try {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.contains(paramPlayer))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    boolean bool1 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
    boolean bool2 = ((Boolean)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getOrDefault(paramPlayer, Boolean.valueOf(false))).booleanValue();
    try {
      if (paramBoolean)
        try {
          if (bool1 == bool2) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer, bool1);
            return;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.put(paramPlayer, Boolean.valueOf(bool1));
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer, bool1);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer, boolean paramBoolean) {
    try {
      if (paramBoolean) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, PotionEffectType.SPEED, 60, 3);
      } else {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, PotionEffectType.SPEED, 60, 2);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h)
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, PotionEffectType.FIRE_RESISTANCE, 60, 0); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer, boolean paramBoolean) {
    try {
      if (paramBoolean) {
        paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 3, false, false, false));
      } else {
        paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 2, false, false, false));
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h)
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, PotionEffectType.FIRE_RESISTANCE, 60, 0); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, PotionEffectType paramPotionEffectType, int paramInt1, int paramInt2) {
    PotionEffect potionEffect = paramPlayer.getPotionEffect(paramPotionEffectType);
    try {
      if (potionEffect != null)
        try {
          if (potionEffect.getAmplifier() == paramInt2)
            try {
              if (potionEffect.getDuration() > 20)
                return; 
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramPlayer.addPotionEffect(new PotionEffect(paramPotionEffectType, paramInt1, paramInt2, false, false, false));
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getBoots();
    try {
      if (itemStack == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemStack.getType() != Material.NETHERITE_BOOTS)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemStack.hasItemMeta())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    ItemMeta itemMeta = itemStack.getItemMeta();
    try {
      if (itemMeta != null)
        try {
          if (itemMeta.hasCustomModelData())
            try {
              if (itemMeta.getCustomModelData() == 1);
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return false;
  }
  
  public boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    Block block = paramPlayer.getLocation().getBlock().getRelative(0, -1, 0);
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.contains(block.getType());
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f() {
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f != null) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.cancel();
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = null;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g != null) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.cancel();
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = null;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  static {
    // Byte code:
    //   0: bipush #46
    //   2: ldc 'T.t7$^X2p#>2qB4t8$W_z/2'
    //   4: iconst_m1
    //   5: goto -> 14
    //   8: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ax.a : Ljava/lang/String;
    //   11: goto -> 154
    //   14: dup_x2
    //   15: pop
    //   16: invokevirtual toCharArray : ()[C
    //   19: dup_x1
    //   20: arraylength
    //   21: dup_x2
    //   22: pop
    //   23: iconst_0
    //   24: istore_0
    //   25: dup2_x1
    //   26: pop2
    //   27: dup_x2
    //   28: iconst_1
    //   29: if_icmpgt -> 128
    //   32: dup2
    //   33: swap
    //   34: iload_0
    //   35: dup2_x1
    //   36: caload
    //   37: swap
    //   38: iload_0
    //   39: bipush #7
    //   41: irem
    //   42: tableswitch default -> 110, 0 -> 80, 1 -> 85, 2 -> 90, 3 -> 95, 4 -> 100, 5 -> 105
    //   80: bipush #31
    //   82: goto -> 112
    //   85: bipush #110
    //   87: goto -> 112
    //   90: bipush #59
    //   92: goto -> 112
    //   95: bipush #95
    //   97: goto -> 112
    //   100: bipush #117
    //   102: goto -> 112
    //   105: bipush #111
    //   107: goto -> 112
    //   110: bipush #54
    //   112: ixor
    //   113: ixor
    //   114: i2c
    //   115: castore
    //   116: iinc #0, 1
    //   119: dup
    //   120: ifne -> 128
    //   123: dup2
    //   124: dup_x1
    //   125: goto -> 35
    //   128: dup2_x1
    //   129: pop2
    //   130: dup_x2
    //   131: iload_0
    //   132: if_icmpgt -> 32
    //   135: pop
    //   136: new java/lang/String
    //   139: dup_x1
    //   140: swap
    //   141: invokespecial <init> : ([C)V
    //   144: invokevirtual intern : ()Ljava/lang/String;
    //   147: swap
    //   148: pop
    //   149: swap
    //   150: pop
    //   151: goto -> 8
    //   154: getstatic org/bukkit/Material.COPPER_BLOCK : Lorg/bukkit/Material;
    //   157: bipush #15
    //   159: anewarray org/bukkit/Material
    //   162: dup
    //   163: iconst_0
    //   164: getstatic org/bukkit/Material.CUT_COPPER : Lorg/bukkit/Material;
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: getstatic org/bukkit/Material.EXPOSED_COPPER : Lorg/bukkit/Material;
    //   173: aastore
    //   174: dup
    //   175: iconst_2
    //   176: getstatic org/bukkit/Material.EXPOSED_CUT_COPPER : Lorg/bukkit/Material;
    //   179: aastore
    //   180: dup
    //   181: iconst_3
    //   182: getstatic org/bukkit/Material.WEATHERED_COPPER : Lorg/bukkit/Material;
    //   185: aastore
    //   186: dup
    //   187: iconst_4
    //   188: getstatic org/bukkit/Material.WEATHERED_CUT_COPPER : Lorg/bukkit/Material;
    //   191: aastore
    //   192: dup
    //   193: iconst_5
    //   194: getstatic org/bukkit/Material.OXIDIZED_COPPER : Lorg/bukkit/Material;
    //   197: aastore
    //   198: dup
    //   199: bipush #6
    //   201: getstatic org/bukkit/Material.OXIDIZED_CUT_COPPER : Lorg/bukkit/Material;
    //   204: aastore
    //   205: dup
    //   206: bipush #7
    //   208: getstatic org/bukkit/Material.WAXED_COPPER_BLOCK : Lorg/bukkit/Material;
    //   211: aastore
    //   212: dup
    //   213: bipush #8
    //   215: getstatic org/bukkit/Material.WAXED_CUT_COPPER : Lorg/bukkit/Material;
    //   218: aastore
    //   219: dup
    //   220: bipush #9
    //   222: getstatic org/bukkit/Material.WAXED_EXPOSED_COPPER : Lorg/bukkit/Material;
    //   225: aastore
    //   226: dup
    //   227: bipush #10
    //   229: getstatic org/bukkit/Material.WAXED_EXPOSED_CUT_COPPER : Lorg/bukkit/Material;
    //   232: aastore
    //   233: dup
    //   234: bipush #11
    //   236: getstatic org/bukkit/Material.WAXED_WEATHERED_COPPER : Lorg/bukkit/Material;
    //   239: aastore
    //   240: dup
    //   241: bipush #12
    //   243: getstatic org/bukkit/Material.WAXED_WEATHERED_CUT_COPPER : Lorg/bukkit/Material;
    //   246: aastore
    //   247: dup
    //   248: bipush #13
    //   250: getstatic org/bukkit/Material.WAXED_OXIDIZED_COPPER : Lorg/bukkit/Material;
    //   253: aastore
    //   254: dup
    //   255: bipush #14
    //   257: getstatic org/bukkit/Material.WAXED_OXIDIZED_CUT_COPPER : Lorg/bukkit/Material;
    //   260: aastore
    //   261: invokestatic of : (Ljava/lang/Enum;[Ljava/lang/Enum;)Ljava/util/EnumSet;
    //   264: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ax.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Ljava/util/Set;
    //   267: return
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ax.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */