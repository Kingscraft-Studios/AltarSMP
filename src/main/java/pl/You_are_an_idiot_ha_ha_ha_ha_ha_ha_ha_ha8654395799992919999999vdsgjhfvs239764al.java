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

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = !You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.class.desiredAssertionStatus();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = Main.getInstance().getConfig().getInt("paladinEarthShatterCooldown", 45);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = Main.getInstance().getConfig().getInt("paladinStalwartAbsorptionCooldown", 45);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = Main.getInstance().getConfig().getInt("paladinStalwartAbsorptionDuration", 5);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = "paladinEarthShatter";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = "paladinStalwartAbsorption";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = new HashMap<>();
  }
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), "StalwartAbsorption", You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d);
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d * 20, 1));
    TextDisplay textDisplay = (TextDisplay)paramPlayer.getWorld().spawnEntity(paramPlayer.getLocation(), EntityType.TEXT_DISPLAY);
    textDisplay.setText("§60 §c❤");
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
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), "StalwartAbsorption")) {
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_BREEZE_CHARGE, 1.0F, 1.0F);
        player.getWorld().spawnParticle(Particle.DUST, player.getLocation().clone().add(0.0D, 1.0D, 0.0D), 50, 0.3D, 0.5D, 0.3D, new Particle.DustOptions(Color.fromRGB(200, 165, 100), 1.0F));
        int i = Main.getInstance().getConfig().getInt("absorptionDamageLimit");
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
    int i = Main.getInstance().getConfig().getInt("earthShatterRadius", 10);
    double d = Main.getInstance().getConfig().getDouble("earthShatterDamage", 5.0D);
    RayTraceResult rayTraceResult = paramPlayer.getWorld().rayTraceBlocks(paramPlayer.getEyeLocation(), paramPlayer.getEyeLocation().getDirection(), 100.0D);
    {
      if (rayTraceResult == null) {
        paramPlayer.sendMessage("§cNo target found!");
        return false;
      } 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h)
        {
          if (rayTraceResult.getHitBlock() == null)
            throw new AssertionError(); 
        }}Location location = rayTraceResult.getHitBlock().getLocation().add(0.0D, 1.0D, 0.0D);
    byte b = 10;
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764t.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location))
        return false; 
    }paramPlayer.getWorld().playSound(location, Sound.ENTITY_BREEZE_CHARGE, 1.0F, 0.8F);
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
    for (Block block : (Iterable<Block>)(Iterable<?>)paramList) {
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

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */