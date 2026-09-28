package pl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Transformation;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764am implements Listener {
  public Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public final Map<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new HashMap<>();
  
  public final Map<UUID, Long> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new HashMap<>();
  
  public static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  public static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764am(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    try {
      if (itemStack.getType() != Material.NETHERITE_SWORD)
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
      if (itemMeta == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemMeta.hasCustomModelData())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
    
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return (itemMeta.getCustomModelData() == 7);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, paramEntityDamageByEntityEvent.getEntity().getLocation().add(0.0D, 1.0D, 0.0D));
  }
  
  public static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    ItemStack itemStack = new ItemStack(Material.CLAY_BALL);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(6));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b() {
    ItemStack itemStack = new ItemStack(Material.CLAY_BALL);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(7));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    ArrayList arrayList = new ArrayList();
    paramPlayer.getWorld().playSound((Entity)paramPlayer, Sound.ENTITY_WARDEN_SONIC_CHARGE, 1.0F, 1.5F);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764et(paramPlayer, arrayList)).runTaskLater((Plugin)Main.getInstance(), 22L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ev(arrayList, paramPlayer)).runTaskLater((Plugin)Main.getInstance(), 22L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ex(arrayList)).runTaskLater((Plugin)Main.getInstance(), 38L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e0(paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation) {
    paramLocation.add(0.0D, 0.0D, 0.0D);
    World world = paramLocation.getWorld();
    ItemStack itemStack = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    ItemDisplay itemDisplay = (ItemDisplay)world.spawnEntity(paramLocation, EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(itemStack);
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getScale().set(0.35D, 0.35D, 0.35D);
    itemDisplay.setTransformation(transformation);
    itemDisplay.setInterpolationDelay(0);
    itemDisplay.setInterpolationDuration(22);
    itemDisplay.setTeleportDuration(22);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e1(paramLocation, itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 2L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e2(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 2L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e3(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 22L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    float f = 7.5F;
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 9, false, false, true));
    paramPlayer.getWorld().playSound((Entity)paramPlayer, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.5F);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BREEZE_WHIRL, 1.0F, 1.0F);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BREEZE_WHIRL, 1.0F, 1.0F);
    paramPlayer.setVelocity(paramPlayer.getLocation().getDirection().multiply(0.5D).setY(0.2D));
    ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawnEntity(paramPlayer.getLocation().add(0.0D, 1.0D, 0.0D), EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b());
    itemDisplay.setInterpolationDelay(0);
    itemDisplay.setInterpolationDuration(5);
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getScale().set(7.5F, 1.0F, 7.5F);
    transformation.getTranslation().set(0.0F, 0.0F, 0.0F);
    itemDisplay.setTransformation(transformation);
    paramPlayer.addPassenger((Entity)itemDisplay);
    itemDisplay.setRotation(0.0F, 0.0F);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e4(itemDisplay, paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 5L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e7(itemDisplay)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(Player paramPlayer) {
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764eu(paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static List<Block> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, int paramInt1, int paramInt2) {
    int i = paramInt1 / 2;
    int j = paramInt2 / 2;
    ArrayList<Block> arrayList = new ArrayList();
    Location location = paramPlayer.getLocation().getBlock().getLocation();
    for (int k = -i; k <= i; k++) {
      for (int m = -i; m <= i; m++) {
        int n = -j;
        try {
          while (n <= j) {
            arrayList.add(location.clone().add(k, n, m).getBlock());
            n++;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } 
    } 
    return arrayList;
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, double paramDouble, boolean paramBoolean1, boolean paramBoolean2) {
    byte b1 = 35;
    double d = 2.2D;
    for (byte b2 = 0; b2 < b1; b2++) {
      double d2;
      double d3;
      double d4;
      double d1 = b2 / b1;
      if (!paramBoolean1)
        d1 = 1.0D - d1; 
      if (paramBoolean2) {
        double d5 = (d1 - 0.5D) * d;
        d2 = Math.cos(paramDouble) * d5;
        d3 = (1.0D - d1) * d * 0.8D;
        d4 = Math.sin(paramDouble) * d5;
      } else {
        double d5 = (d1 - 0.5D) * d;
        d2 = Math.cos(paramDouble) * d5;
        try {
        
        } catch (MatchException matchException) {
          throw a(null);
        } 
        d3 = paramBoolean1 ? ((1.0D - d1) * d * 0.8D) : ((d1 - 1.0D) * d * 0.8D);
        d4 = Math.sin(paramDouble) * d5;
      } 
      Location location = paramLocation.clone().add(d2, d3, d4);
      paramLocation.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, location, 2, 0.0D, 0.0D, 0.0D, 0.0D);
      paramLocation.getWorld().spawnParticle(Particle.DUST, location, 2, 0.0D, 0.0D, 0.0D, 0.0D, new Particle.DustOptions(Color.WHITE, 1.0F));
    } 
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, Location paramLocation) {
    int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
    double d = Math.toRadians(paramPlayer.getLocation().getYaw());
    try {
      switch (i % 4) {
        case 0:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, d, true, false);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
          break;
        case 1:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, d, false, false);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
          break;
        case 2:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, d, true, true);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
          break;
        case 3:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, d, false, true);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
          break;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e(paramPlayer);
  }
  
  public int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    long l = System.currentTimeMillis();
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(paramPlayer.getUniqueId()))
        try {
          if (l - ((Long)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.get(paramPlayer.getUniqueId())).longValue() > 2500L)
            this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(paramPlayer.getUniqueId(), Integer.valueOf(0)); 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return ((Integer)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.getOrDefault(paramPlayer.getUniqueId(), Integer.valueOf(0))).intValue();
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e(Player paramPlayer) {
    int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(paramPlayer.getUniqueId(), Integer.valueOf(i + 1));
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.put(paramPlayer.getUniqueId(), Long.valueOf(System.currentTimeMillis()));
  }
  
  static {
    // Byte code:
    //   0: iconst_4
    //   1: anewarray java/lang/String
    //   4: astore_0
    //   5: iconst_0
    //   6: istore #4
    //   8: ldc '"[&"_&'
    //   10: dup
    //   11: astore_3
    //   12: invokevirtual length : ()I
    //   15: istore #5
    //   17: iconst_5
    //   18: istore_2
    //   19: iconst_m1
    //   20: istore_1
    //   21: bipush #34
    //   23: iinc #1, 1
    //   26: aload_3
    //   27: iload_1
    //   28: dup
    //   29: iload_2
    //   30: iadd
    //   31: invokevirtual substring : (II)Ljava/lang/String;
    //   34: iconst_m1
    //   35: goto -> 128
    //   38: aload_0
    //   39: swap
    //   40: iload #4
    //   42: iinc #4, 1
    //   45: swap
    //   46: aastore
    //   47: iload_1
    //   48: iload_2
    //   49: iadd
    //   50: dup
    //   51: istore_1
    //   52: iload #5
    //   54: if_icmpge -> 66
    //   57: aload_3
    //   58: iload_1
    //   59: invokevirtual charAt : (I)C
    //   62: istore_2
    //   63: goto -> 21
    //   66: ldc '\\nv%-.\:c:*Vc&5.g-'Vc<&-,]x'
    //   68: dup
    //   69: astore_3
    //   70: invokevirtual length : ()I
    //   73: istore #5
    //   75: bipush #20
    //   77: istore_2
    //   78: iconst_m1
    //   79: istore_1
    //   80: bipush #26
    //   82: iinc #1, 1
    //   85: aload_3
    //   86: iload_1
    //   87: dup
    //   88: iload_2
    //   89: iadd
    //   90: invokevirtual substring : (II)Ljava/lang/String;
    //   93: iconst_0
    //   94: goto -> 128
    //   97: aload_0
    //   98: swap
    //   99: iload #4
    //   101: iinc #4, 1
    //   104: swap
    //   105: aastore
    //   106: iload_1
    //   107: iload_2
    //   108: iadd
    //   109: dup
    //   110: istore_1
    //   111: iload #5
    //   113: if_icmpge -> 125
    //   116: aload_3
    //   117: iload_1
    //   118: invokevirtual charAt : (I)C
    //   121: istore_2
    //   122: goto -> 80
    //   125: goto -> 284
    //   128: dup_x2
    //   129: pop
    //   130: invokevirtual toCharArray : ()[C
    //   133: dup_x1
    //   134: arraylength
    //   135: dup_x2
    //   136: pop
    //   137: iconst_0
    //   138: istore #6
    //   140: dup2_x1
    //   141: pop2
    //   142: dup_x2
    //   143: iconst_1
    //   144: if_icmpgt -> 244
    //   147: dup2
    //   148: swap
    //   149: iload #6
    //   151: dup2_x1
    //   152: caload
    //   153: swap
    //   154: iload #6
    //   156: bipush #7
    //   158: irem
    //   159: tableswitch default -> 226, 0 -> 196, 1 -> 201, 2 -> 206, 3 -> 211, 4 -> 216, 5 -> 221
    //   196: bipush #115
    //   198: goto -> 228
    //   201: bipush #21
    //   203: goto -> 228
    //   206: bipush #101
    //   208: goto -> 228
    //   211: bipush #83
    //   213: goto -> 228
    //   216: bipush #88
    //   218: goto -> 228
    //   221: bipush #90
    //   223: goto -> 228
    //   226: bipush #35
    //   228: ixor
    //   229: ixor
    //   230: i2c
    //   231: castore
    //   232: iinc #6, 1
    //   235: dup
    //   236: ifne -> 244
    //   239: dup2
    //   240: dup_x1
    //   241: goto -> 151
    //   244: dup2_x1
    //   245: pop2
    //   246: dup_x2
    //   247: iload #6
    //   249: if_icmpgt -> 147
    //   252: pop
    //   253: new java/lang/String
    //   256: dup_x1
    //   257: swap
    //   258: invokespecial <init> : ([C)V
    //   261: invokevirtual intern : ()Ljava/lang/String;
    //   264: swap
    //   265: pop
    //   266: swap
    //   267: tableswitch default -> 38, 0 -> 97
    //   284: invokestatic getInstance : ()Lpl/Main;
    //   287: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   290: aload_0
    //   291: iconst_3
    //   292: aaload
    //   293: bipush #30
    //   295: invokevirtual getInt : (Ljava/lang/String;I)I
    //   298: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764am.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d : I
    //   301: invokestatic getInstance : ()Lpl/Main;
    //   304: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   307: aload_0
    //   308: iconst_2
    //   309: aaload
    //   310: bipush #60
    //   312: invokevirtual getInt : (Ljava/lang/String;I)I
    //   315: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764am.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : I
    //   318: aload_0
    //   319: iconst_1
    //   320: aaload
    //   321: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764am.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f : Ljava/lang/String;
    //   324: aload_0
    //   325: iconst_0
    //   326: aaload
    //   327: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764am.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g : Ljava/lang/String;
    //   330: return
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764am.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */