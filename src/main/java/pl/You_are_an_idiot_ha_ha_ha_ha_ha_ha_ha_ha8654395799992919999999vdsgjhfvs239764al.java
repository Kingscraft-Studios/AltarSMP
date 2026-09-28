package pl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al implements Listener {
  public Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  public static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  public static HashMap<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  static final boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  
  private static final String[] a;
  
  private static final String[] b;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), a(-31276, 31621), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d);
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d * 20, 1));
    TextDisplay textDisplay = (TextDisplay)paramPlayer.getWorld().spawnEntity(paramPlayer.getLocation(), EntityType.TEXT_DISPLAY);
    textDisplay.setText(a(-31268, 25962));
    textDisplay.setBillboard(Display.Billboard.CENTER);
    Transformation transformation = textDisplay.getTransformation();
    transformation.getScale().set(1.0F, 1.0F, 1.0F);
    transformation.getTranslation().set(0.0D, 0.5D, 0.0D);
    textDisplay.setTransformation(transformation);
    paramPlayer.addPassenger((Entity)textDisplay);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ee(paramPlayer, textDisplay)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  @EventHandler(ignoreCancelled = true)
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Entity entity = paramEntityDamageByEntityEvent.getEntity();
    if (entity instanceof Player) {
      Player player = (Player)entity;
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), a(-31272, 19595))) {
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_BREEZE_CHARGE, 1.0F, 1.0F);
        player.getWorld().spawnParticle(Particle.DUST, player.getLocation().clone().add(0.0D, 1.0D, 0.0D), 50, 0.3D, 0.5D, 0.3D, new Particle.DustOptions(Color.fromRGB(200, 165, 100), 1.0F));
        int i = Main.getInstance().getConfig().getInt(a(-31266, 25586));
        int j = Math.min(((Integer)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getOrDefault(player.getUniqueId(), Integer.valueOf(0))).intValue() + (int)paramEntityDamageByEntityEvent.getDamage(), i);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.put(player.getUniqueId(), Integer.valueOf(j));
      } 
    } 
  }
  
  public static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    ItemStack itemStack = new ItemStack(Material.CLAY_BALL);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(8));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    int i = Main.getInstance().getConfig().getInt(a(-31274, 2423), 10);
    double d = Main.getInstance().getConfig().getDouble(a(-31265, 23628), 5.0D);
    RayTraceResult rayTraceResult = paramPlayer.getWorld().rayTraceBlocks(paramPlayer.getEyeLocation(), paramPlayer.getEyeLocation().getDirection(), 100.0D);
    try {
      if (rayTraceResult == null) {
        paramPlayer.sendMessage(a(-31271, 12068));
        return false;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h)
        try {
          if (rayTraceResult.getHitBlock() == null)
            throw new AssertionError(); 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Location location = rayTraceResult.getHitBlock().getLocation().add(0.0D, 1.0D, 0.0D);
    byte b = 10;
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764t.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location))
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramPlayer.getWorld().playSound(location, Sound.ENTITY_BREEZE_CHARGE, 1.0F, 0.8F);
    ItemDisplay itemDisplay = (ItemDisplay)location.getWorld().spawnEntity(location, EntityType.ITEM_DISPLAY);
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getScale().set(1.0F, 1.0F, 1.0F);
    transformation.getRightRotation().set((Quaternionfc)(new Quaternionf()).rotateX(3.1415927F));
    itemDisplay.setTransformation(transformation);
    itemDisplay.setRotation(180.0F, 0.0F);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764el(itemDisplay, b, location)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764em(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 2L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764en(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 3L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764eo(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 3L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ep(itemDisplay, b)).runTaskLater((Plugin)Main.getInstance(), 4L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764eq(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 5L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764er(itemDisplay, b)).runTaskLater((Plugin)Main.getInstance(), 6L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764es(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 18L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ef(itemDisplay, b)).runTaskLater((Plugin)Main.getInstance(), 20L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764eg(itemDisplay, paramPlayer, location, i, b, d)).runTaskLater((Plugin)Main.getInstance(), 27L);
    return true;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getWorld : ()Lorg/bukkit/World;
    //   4: astore_2
    //   5: new java/util/Random
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore_3
    //   13: new java/util/HashMap
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore #4
    //   22: iload_1
    //   23: ineg
    //   24: istore #5
    //   26: iload #5
    //   28: iload_1
    //   29: if_icmpgt -> 199
    //   32: iload_1
    //   33: ineg
    //   34: istore #6
    //   36: iload #6
    //   38: iload_1
    //   39: if_icmpgt -> 193
    //   42: iload #5
    //   44: iload #5
    //   46: imul
    //   47: iload #6
    //   49: iload #6
    //   51: imul
    //   52: iadd
    //   53: iload_1
    //   54: iload_1
    //   55: imul
    //   56: if_icmple -> 73
    //   59: goto -> 66
    //   62: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   65: athrow
    //   66: goto -> 187
    //   69: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   72: athrow
    //   73: iload #5
    //   75: iload #5
    //   77: imul
    //   78: iload #6
    //   80: iload #6
    //   82: imul
    //   83: iadd
    //   84: i2d
    //   85: invokestatic sqrt : (D)D
    //   88: invokestatic round : (D)J
    //   91: l2i
    //   92: istore #7
    //   94: aload_0
    //   95: invokevirtual clone : ()Lorg/bukkit/Location;
    //   98: iload #5
    //   100: i2d
    //   101: ldc2_w -1.0
    //   104: iload #6
    //   106: i2d
    //   107: invokevirtual add : (DDD)Lorg/bukkit/Location;
    //   110: astore #8
    //   112: aload #8
    //   114: invokevirtual getBlock : ()Lorg/bukkit/block/Block;
    //   117: astore #9
    //   119: aload #9
    //   121: invokeinterface getType : ()Lorg/bukkit/Material;
    //   126: invokevirtual isAir : ()Z
    //   129: ifeq -> 139
    //   132: goto -> 187
    //   135: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   138: athrow
    //   139: aload #9
    //   141: invokeinterface getType : ()Lorg/bukkit/Material;
    //   146: invokevirtual isItem : ()Z
    //   149: ifne -> 159
    //   152: goto -> 187
    //   155: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   158: athrow
    //   159: aload #4
    //   161: iload #7
    //   163: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   166: <illegal opcode> apply : ()Ljava/util/function/Function;
    //   171: invokeinterface computeIfAbsent : (Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;
    //   176: checkcast java/util/List
    //   179: aload #9
    //   181: invokeinterface add : (Ljava/lang/Object;)Z
    //   186: pop
    //   187: iinc #6, 1
    //   190: goto -> 36
    //   193: iinc #5, 1
    //   196: goto -> 26
    //   199: aload #4
    //   201: invokeinterface entrySet : ()Ljava/util/Set;
    //   206: invokeinterface iterator : ()Ljava/util/Iterator;
    //   211: astore #5
    //   213: aload #5
    //   215: invokeinterface hasNext : ()Z
    //   220: ifeq -> 292
    //   223: aload #5
    //   225: invokeinterface next : ()Ljava/lang/Object;
    //   230: checkcast java/util/Map$Entry
    //   233: astore #6
    //   235: aload #6
    //   237: invokeinterface getKey : ()Ljava/lang/Object;
    //   242: checkcast java/lang/Integer
    //   245: invokevirtual intValue : ()I
    //   248: istore #7
    //   250: aload #6
    //   252: invokeinterface getValue : ()Ljava/lang/Object;
    //   257: checkcast java/util/List
    //   260: astore #8
    //   262: invokestatic getScheduler : ()Lorg/bukkit/scheduler/BukkitScheduler;
    //   265: invokestatic getInstance : ()Lpl/Main;
    //   268: aload #8
    //   270: aload_2
    //   271: <illegal opcode> run : (Ljava/util/List;Lorg/bukkit/World;)Ljava/lang/Runnable;
    //   276: iload #7
    //   278: i2l
    //   279: ldc2_w 2
    //   282: lmul
    //   283: invokeinterface runTaskLater : (Lorg/bukkit/plugin/Plugin;Ljava/lang/Runnable;J)Lorg/bukkit/scheduler/BukkitTask;
    //   288: pop
    //   289: goto -> 213
    //   292: return
    // Exception table:
    //   from	to	target	type
    //   36	59	62	java/lang/MatchException
    //   42	69	69	java/lang/MatchException
    //   119	135	135	java/lang/MatchException
    //   139	155	155	java/lang/MatchException
  }
  
  private static void lambda$risingBlocks$1(List paramList, World paramWorld) {
    for (Block block : paramList) {
      Location location = block.getLocation().clone().add(0.5D, 0.5D, 0.5D);
      ItemDisplay itemDisplay = (ItemDisplay)paramWorld.spawnEntity(location, EntityType.ITEM_DISPLAY);
      itemDisplay.setItemStack(new ItemStack(block.getType()));
      itemDisplay.setBrightness(new Display.Brightness(15, 15));
      itemDisplay.setTeleportDuration(5);
      (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ej(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 2L);
    } 
  }
  
  private static List lambda$risingBlocks$0(Integer paramInteger) {
    return new ArrayList();
  }
  
  static {
    // Byte code:
    //   0: bipush #12
    //   2: anewarray java/lang/String
    //   5: astore #5
    //   7: iconst_0
    //   8: istore_3
    //   9: ldc 'Çü¢úEí=­Q¥õ¨»++µ6c?¨ÈK2ÄûñâÜÝJ"L➭n8>wÑþeïÝ+§~ºiZÂ*\\n:7Oø¡«Vúh¬­:z{ôÈ³À#1WF¼Gù%B®\\rÏV2µrià;äYÀûKª´] vwIs"zB¬å3x/?1:ý.xÎu!êñ«¯ìãeBðMÆP9EuAûr(§Â2>Ùâa9=2´¥AÄè§«PÜµ*¦zE·ª9Sh\Ðè'
    //   11: dup
    //   12: astore_2
    //   13: invokevirtual length : ()I
    //   16: istore #4
    //   18: bipush #33
    //   20: istore_1
    //   21: iconst_m1
    //   22: istore_0
    //   23: bipush #30
    //   25: iinc #0, 1
    //   28: aload_2
    //   29: iload_0
    //   30: dup
    //   31: iload_1
    //   32: iadd
    //   33: invokevirtual substring : (II)Ljava/lang/String;
    //   36: iconst_m1
    //   37: goto -> 143
    //   40: aload #5
    //   42: swap
    //   43: iload_3
    //   44: iinc #3, 1
    //   47: swap
    //   48: aastore
    //   49: iload_0
    //   50: iload_1
    //   51: iadd
    //   52: dup
    //   53: istore_0
    //   54: iload #4
    //   56: if_icmpge -> 68
    //   59: aload_2
    //   60: iload_0
    //   61: invokevirtual charAt : (I)C
    //   64: istore_1
    //   65: goto -> 23
    //   68: ldc 'uÛøYðt=b:i þç¿=Û7¶E±huþ¢ò8]EN÷¶0½'
    //   70: dup
    //   71: astore_2
    //   72: invokevirtual length : ()I
    //   75: istore #4
    //   77: bipush #25
    //   79: istore_1
    //   80: iconst_m1
    //   81: istore_0
    //   82: bipush #15
    //   84: iinc #0, 1
    //   87: aload_2
    //   88: iload_0
    //   89: dup
    //   90: iload_1
    //   91: iadd
    //   92: invokevirtual substring : (II)Ljava/lang/String;
    //   95: iconst_0
    //   96: goto -> 143
    //   99: aload #5
    //   101: swap
    //   102: iload_3
    //   103: iinc #3, 1
    //   106: swap
    //   107: aastore
    //   108: iload_0
    //   109: iload_1
    //   110: iadd
    //   111: dup
    //   112: istore_0
    //   113: iload #4
    //   115: if_icmpge -> 127
    //   118: aload_2
    //   119: iload_0
    //   120: invokevirtual charAt : (I)C
    //   123: istore_1
    //   124: goto -> 82
    //   127: aload #5
    //   129: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.a : [Ljava/lang/String;
    //   132: bipush #12
    //   134: anewarray java/lang/String
    //   137: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.b : [Ljava/lang/String;
    //   140: goto -> 300
    //   143: dup_x2
    //   144: pop
    //   145: invokevirtual toCharArray : ()[C
    //   148: dup_x1
    //   149: arraylength
    //   150: dup_x2
    //   151: pop
    //   152: iconst_0
    //   153: istore #6
    //   155: dup2_x1
    //   156: pop2
    //   157: dup_x2
    //   158: iconst_1
    //   159: if_icmpgt -> 260
    //   162: dup2
    //   163: swap
    //   164: iload #6
    //   166: dup2_x1
    //   167: caload
    //   168: swap
    //   169: iload #6
    //   171: bipush #7
    //   173: irem
    //   174: tableswitch default -> 242, 0 -> 212, 1 -> 217, 2 -> 222, 3 -> 227, 4 -> 232, 5 -> 237
    //   212: bipush #127
    //   214: goto -> 244
    //   217: bipush #61
    //   219: goto -> 244
    //   222: bipush #122
    //   224: goto -> 244
    //   227: bipush #51
    //   229: goto -> 244
    //   232: bipush #6
    //   234: goto -> 244
    //   237: bipush #45
    //   239: goto -> 244
    //   242: bipush #14
    //   244: ixor
    //   245: ixor
    //   246: i2c
    //   247: castore
    //   248: iinc #6, 1
    //   251: dup
    //   252: ifne -> 260
    //   255: dup2
    //   256: dup_x1
    //   257: goto -> 166
    //   260: dup2_x1
    //   261: pop2
    //   262: dup_x2
    //   263: iload #6
    //   265: if_icmpgt -> 162
    //   268: pop
    //   269: new java/lang/String
    //   272: dup_x1
    //   273: swap
    //   274: invokespecial <init> : ([C)V
    //   277: invokevirtual intern : ()Ljava/lang/String;
    //   280: swap
    //   281: pop
    //   282: swap
    //   283: tableswitch default -> 40, 0 -> 99
    //   300: ldc pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al
    //   302: invokevirtual desiredAssertionStatus : ()Z
    //   305: ifne -> 316
    //   308: iconst_1
    //   309: goto -> 317
    //   312: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   315: athrow
    //   316: iconst_0
    //   317: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h : Z
    //   320: invokestatic getInstance : ()Lpl/Main;
    //   323: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   326: sipush #-31269
    //   329: sipush #16202
    //   332: invokestatic a : (II)Ljava/lang/String;
    //   335: bipush #45
    //   337: invokevirtual getInt : (Ljava/lang/String;I)I
    //   340: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : I
    //   343: invokestatic getInstance : ()Lpl/Main;
    //   346: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   349: sipush #-31270
    //   352: sipush #21642
    //   355: invokestatic a : (II)Ljava/lang/String;
    //   358: bipush #45
    //   360: invokevirtual getInt : (Ljava/lang/String;I)I
    //   363: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : I
    //   366: invokestatic getInstance : ()Lpl/Main;
    //   369: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   372: sipush #-31267
    //   375: sipush #31121
    //   378: invokestatic a : (II)Ljava/lang/String;
    //   381: iconst_5
    //   382: invokevirtual getInt : (Ljava/lang/String;I)I
    //   385: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d : I
    //   388: sipush #-31275
    //   391: sipush #-2787
    //   394: invokestatic a : (II)Ljava/lang/String;
    //   397: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : Ljava/lang/String;
    //   400: sipush #-31273
    //   403: sipush #18872
    //   406: invokestatic a : (II)Ljava/lang/String;
    //   409: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f : Ljava/lang/String;
    //   412: new java/util/HashMap
    //   415: dup
    //   416: invokespecial <init> : ()V
    //   419: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g : Ljava/util/HashMap;
    //   422: return
    // Exception table:
    //   from	to	target	type
    //   300	312	312	java/lang/MatchException
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0xFFFF85DD) & 0xFFFF;
    if (b[i] == null) {
      char[] arrayOfChar = a[i].toCharArray();
      switch (arrayOfChar[0] & 0xFF) {
        case 0:
        
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
        
        case 20:
        
        case 21:
        
        case 22:
        
        case 23:
        
        case 24:
        
        case 25:
        
        case 26:
        
        case 27:
        
        case 28:
        
        case 29:
        
        case 30:
        
        case 31:
        
        case 32:
        
        case 33:
        
        case 34:
        
        case 35:
        
        case 36:
        
        case 37:
        
        case 38:
        
        case 39:
        
        case 40:
        
        case 41:
        
        case 42:
        
        case 43:
        
        case 44:
        
        case 45:
        
        case 46:
        
        case 47:
        
        case 48:
        
        case 49:
        
        case 50:
        
        case 51:
        
        case 52:
        
        case 53:
        
        case 54:
        
        case 55:
        
        case 56:
        
        case 57:
        
        case 58:
        
        case 59:
        
        case 60:
        
        case 61:
        
        case 62:
        
        case 63:
        
        case 64:
        
        case 65:
        
        case 66:
        
        case 67:
        
        case 68:
        
        case 69:
        
        case 70:
        
        case 71:
        
        case 72:
        
        case 73:
        
        case 74:
        
        case 75:
        
        case 76:
        
        case 77:
        
        case 78:
        
        case 79:
        
        case 80:
        
        case 81:
        
        case 82:
        
        case 83:
        
        case 84:
        
        case 85:
        
        case 86:
        
        case 87:
        
        case 88:
        
        case 89:
        
        case 90:
        
        case 91:
        
        case 92:
        
        case 93:
        
        case 94:
        
        case 95:
        
        case 96:
        
        case 97:
        
        case 98:
        
        case 99:
        
        case 100:
        
        case 101:
        
        case 102:
        
        case 103:
        
        case 104:
        
        case 105:
        
        case 106:
        
        case 107:
        
        case 108:
        
        case 109:
        
        case 110:
        
        case 111:
        
        case 112:
        
        case 113:
        
        case 114:
        
        case 115:
        
        case 116:
        
        case 117:
        
        case 118:
        
        case 119:
        
        case 120:
        
        case 121:
        
        case 122:
        
        case 123:
        
        case 124:
        
        case 125:
        
        case 126:
        
        case 127:
        
        case 128:
        
        case 129:
        
        case 130:
        
        case 131:
        
        case 132:
        
        case 133:
        
        case 134:
        
        case 135:
        
        case 136:
        
        case 137:
        
        case 138:
        
        case 139:
        
        case 140:
        
        case 141:
        
        case 142:
        
        case 143:
        
        case 144:
        
        case 145:
        
        case 146:
        
        case 147:
        
        case 148:
        
        case 149:
        
        case 150:
        
        case 151:
        
        case 152:
        
        case 153:
        
        case 154:
        
        case 155:
        
        case 156:
        
        case 157:
        
        case 158:
        
        case 159:
        
        case 160:
        
        case 161:
        
        case 162:
        
        case 163:
        
        case 164:
        
        case 165:
        
        case 166:
        
        case 167:
        
        case 168:
        
        case 169:
        
        case 170:
        
        case 171:
        
        case 172:
        
        case 173:
        
        case 174:
        
        case 175:
        
        case 176:
        
        case 177:
        
        case 178:
        
        case 179:
        
        case 180:
        
        case 181:
        
        case 182:
        
        case 183:
        
        case 184:
        
        case 185:
        
        case 186:
        
        case 187:
        
        case 188:
        
        case 189:
        
        case 190:
        
        case 191:
        
        case 192:
        
        case 193:
        
        case 194:
        
        case 195:
        
        case 196:
        
        case 197:
        
        case 198:
        
        case 199:
        
        case 200:
        
        case 201:
        
        case 202:
        
        case 203:
        
        case 204:
        
        case 205:
        
        case 206:
        
        case 207:
        
        case 208:
        
        case 209:
        
        case 210:
        
        case 211:
        
        case 212:
        
        case 213:
        
        case 214:
        
        case 215:
        
        case 216:
        
        case 217:
        
        case 218:
        
        case 219:
        
        case 220:
        
        case 221:
        
        case 222:
        
        case 223:
        
        case 224:
        
        case 225:
        
        case 226:
        
        case 227:
        
        case 228:
        
        case 229:
        
        case 230:
        
        case 231:
        
        case 232:
        
        case 233:
        
        case 234:
        
        case 235:
        
        case 236:
        
        case 237:
        
        case 238:
        
        case 239:
        
        case 240:
        
        case 241:
        
        case 242:
        
        case 243:
        
        case 244:
        
        case 245:
        
        case 246:
        
        case 247:
        
        case 248:
        
        case 249:
        
        case 250:
        
        case 251:
        
        case 252:
        
        case 253:
        
        case 254:
        
        default:
          break;
      } 
      char c = '';
      int j = (paramInt2 & 0xFF) - c;
      if (j < 0)
        j += 256; 
      int k = ((paramInt2 & 0xFFFF) >>> 8) - c;
      if (k < 0)
        k += 256; 
      for (byte b = 0; b < arrayOfChar.length; b++) {
        int m = b % 2;
        if (m == 0) {
          arrayOfChar[b] = (char)(arrayOfChar[b] ^ j);
          j = ((j >>> 3 | j << 5) ^ arrayOfChar[b]) & 0xFF;
        } else {
          arrayOfChar[b] = (char)(arrayOfChar[b] ^ k);
          k = ((k >>> 3 | k << 5) ^ arrayOfChar[b]) & 0xFF;
        } 
      } 
      b[i] = (new String(arrayOfChar)).intern();
    } 
    return b[i];
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */