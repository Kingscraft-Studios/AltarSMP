package pl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an implements Listener {
  static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public static final HashMap<UUID, Location> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  public static final HashMap<UUID, BukkitRunnable> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  private Map<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = new HashMap<>();
  
  private Map<UUID, Long> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = new HashMap<>();
  
  private static final String[] a;
  
  private static final String[] b;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an() {
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e8(this)).runTaskTimer((Plugin)Main.getInstance(), 0L, 20L);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    return Main.areSimilar(itemStack, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764m());
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(paramPlayer.getUniqueId()))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.containsKey(paramPlayer.getUniqueId()))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), a(-7357, -12186)))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 0.6F);
    Location location = paramPlayer.getEyeLocation().clone();
    for (Player player : Bukkit.getOnlinePlayers()) {
      try {
        if (!player.equals(paramPlayer))
          player.hidePlayer((Plugin)Main.getInstance(), paramPlayer); 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20, 1, true, false, false));
    String str1 = ChatColor.BOLD.toString();
    String str2 = String.valueOf(ChatColor.GRAY);
    String str3 = ChatColor.BOLD.toString();
    String str4 = String.valueOf(ChatColor.WHITE);
    String str5 = ChatColor.BOLD.toString();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, String.valueOf(ChatColor.GRAY) + String.valueOf(ChatColor.GRAY) + str5 + a(-7355, -7643) + str4 + str3 + a(-7352, 32177) + str2 + str1, 1, ChatColor.YELLOW);
    if (Main.getInstance().getConfig().getBoolean(a(-7350, 30052), true)) {
      WorldBorder worldBorder = Bukkit.createWorldBorder();
      worldBorder.setCenter(paramPlayer.getLocation());
      worldBorder.setSize(5.9999968E7D);
      worldBorder.setWarningDistance(59999968);
      paramPlayer.setWorldBorder(worldBorder);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e9 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e9 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e9(location, paramPlayer);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e_(paramPlayer)).runTaskLater((Plugin)Main.getInstance(), 20L);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.put(paramPlayer.getUniqueId(), you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e9);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.put(paramPlayer.getUniqueId(), location.clone());
    you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e9.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, Location paramLocation) {
    try {
      if (paramLocation == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    for (byte b = 0; b < 100; b++) {
      double d1 = Math.random() * 2.0D * Math.PI;
      double d2 = Math.random() * Math.PI;
      double d3 = 1.5D * Math.sin(d2) * Math.cos(d1);
      double d4 = 1.5D * Math.sin(d2) * Math.sin(d1);
      double d5 = 1.5D * Math.cos(d2);
      paramLocation.getWorld().spawnParticle(Particle.SQUID_INK, paramLocation.clone().add(d3, d4, d5), 1, 0.0D, 0.0D, 0.0D, 0.0D);
    } 
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fa(paramPlayer, paramLocation)).runTaskLater((Plugin)Main.getInstance(), 5L);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractEvent paramPlayerInteractEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getPlayer : ()Lorg/bukkit/entity/Player;
    //   4: astore_2
    //   5: aload_1
    //   6: invokevirtual getAction : ()Lorg/bukkit/event/block/Action;
    //   9: getstatic org/bukkit/event/block/Action.RIGHT_CLICK_BLOCK : Lorg/bukkit/event/block/Action;
    //   12: if_acmpeq -> 32
    //   15: aload_1
    //   16: invokevirtual getAction : ()Lorg/bukkit/event/block/Action;
    //   19: getstatic org/bukkit/event/block/Action.RIGHT_CLICK_AIR : Lorg/bukkit/event/block/Action;
    //   22: if_acmpne -> 588
    //   25: goto -> 32
    //   28: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   31: athrow
    //   32: aload_2
    //   33: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)Z
    //   36: ifeq -> 588
    //   39: goto -> 46
    //   42: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   45: athrow
    //   46: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : Ljava/util/HashMap;
    //   49: aload_2
    //   50: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   55: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   58: ifeq -> 588
    //   61: goto -> 68
    //   64: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   67: athrow
    //   68: aload_2
    //   69: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   74: sipush #-7359
    //   77: sipush #27784
    //   80: invokestatic a : (II)Ljava/lang/String;
    //   83: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Ljava/util/UUID;Ljava/lang/String;)Z
    //   86: ifne -> 583
    //   89: goto -> 96
    //   92: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   95: athrow
    //   96: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : Ljava/util/HashMap;
    //   99: aload_2
    //   100: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   105: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   108: checkcast org/bukkit/Location
    //   111: astore_3
    //   112: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d : Ljava/util/HashMap;
    //   115: aload_2
    //   116: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   121: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast org/bukkit/scheduler/BukkitRunnable
    //   127: astore #4
    //   129: aload #4
    //   131: ifnull -> 146
    //   134: aload #4
    //   136: invokevirtual cancel : ()V
    //   139: goto -> 146
    //   142: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   145: athrow
    //   146: aload_3
    //   147: ifnull -> 287
    //   150: iconst_0
    //   151: istore #5
    //   153: iload #5
    //   155: bipush #100
    //   157: if_icmpge -> 263
    //   160: invokestatic random : ()D
    //   163: ldc2_w 2.0
    //   166: dmul
    //   167: ldc2_w 3.141592653589793
    //   170: dmul
    //   171: dstore #6
    //   173: invokestatic random : ()D
    //   176: ldc2_w 3.141592653589793
    //   179: dmul
    //   180: dstore #8
    //   182: ldc2_w 1.5
    //   185: dload #8
    //   187: invokestatic sin : (D)D
    //   190: dmul
    //   191: dload #6
    //   193: invokestatic cos : (D)D
    //   196: dmul
    //   197: dstore #10
    //   199: ldc2_w 1.5
    //   202: dload #8
    //   204: invokestatic sin : (D)D
    //   207: dmul
    //   208: dload #6
    //   210: invokestatic sin : (D)D
    //   213: dmul
    //   214: dstore #12
    //   216: ldc2_w 1.5
    //   219: dload #8
    //   221: invokestatic cos : (D)D
    //   224: dmul
    //   225: dstore #14
    //   227: aload_3
    //   228: invokevirtual getWorld : ()Lorg/bukkit/World;
    //   231: getstatic org/bukkit/Particle.SQUID_INK : Lorg/bukkit/Particle;
    //   234: aload_3
    //   235: invokevirtual clone : ()Lorg/bukkit/Location;
    //   238: dload #10
    //   240: dload #12
    //   242: dload #14
    //   244: invokevirtual add : (DDD)Lorg/bukkit/Location;
    //   247: iconst_1
    //   248: dconst_0
    //   249: dconst_0
    //   250: dconst_0
    //   251: dconst_0
    //   252: invokeinterface spawnParticle : (Lorg/bukkit/Particle;Lorg/bukkit/Location;IDDDD)V
    //   257: iinc #5, 1
    //   260: goto -> 153
    //   263: aload_3
    //   264: astore #5
    //   266: new pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fb
    //   269: dup
    //   270: aload_0
    //   271: aload_2
    //   272: aload #5
    //   274: invokespecial <init> : (Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an;Lorg/bukkit/entity/Player;Lorg/bukkit/Location;)V
    //   277: invokestatic getInstance : ()Lpl/Main;
    //   280: ldc2_w 5
    //   283: invokevirtual runTaskLater : (Lorg/bukkit/plugin/Plugin;J)Lorg/bukkit/scheduler/BukkitTask;
    //   286: pop
    //   287: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : Ljava/util/HashMap;
    //   290: aload_2
    //   291: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   296: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   299: pop
    //   300: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d : Ljava/util/HashMap;
    //   303: aload_2
    //   304: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   309: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   312: pop
    //   313: invokestatic getOnlinePlayers : ()Ljava/util/Collection;
    //   316: invokeinterface iterator : ()Ljava/util/Iterator;
    //   321: astore #5
    //   323: aload #5
    //   325: invokeinterface hasNext : ()Z
    //   330: ifeq -> 377
    //   333: aload #5
    //   335: invokeinterface next : ()Ljava/lang/Object;
    //   340: checkcast org/bukkit/entity/Player
    //   343: astore #6
    //   345: aload #6
    //   347: aload_2
    //   348: invokeinterface equals : (Ljava/lang/Object;)Z
    //   353: ifne -> 374
    //   356: aload #6
    //   358: invokestatic getInstance : ()Lpl/Main;
    //   361: aload_2
    //   362: invokeinterface showPlayer : (Lorg/bukkit/plugin/Plugin;Lorg/bukkit/entity/Player;)V
    //   367: goto -> 374
    //   370: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   373: athrow
    //   374: goto -> 323
    //   377: aload_2
    //   378: getstatic org/bukkit/potion/PotionEffectType.INVISIBILITY : Lorg/bukkit/potion/PotionEffectType;
    //   381: invokeinterface removePotionEffect : (Lorg/bukkit/potion/PotionEffectType;)V
    //   386: aload_2
    //   387: invokeinterface getWorld : ()Lorg/bukkit/World;
    //   392: aload_2
    //   393: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   398: getstatic org/bukkit/Sound.ENTITY_ENDERMAN_TELEPORT : Lorg/bukkit/Sound;
    //   401: fconst_1
    //   402: ldc 0.6
    //   404: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   409: aload_2
    //   410: invokeinterface swingMainHand : ()V
    //   415: aload_2
    //   416: invokeinterface updateInventory : ()V
    //   421: invokestatic getInstance : ()Lpl/Main;
    //   424: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   427: sipush #-7351
    //   430: sipush #-23006
    //   433: invokestatic a : (II)Ljava/lang/String;
    //   436: iconst_1
    //   437: invokevirtual getBoolean : (Ljava/lang/String;Z)Z
    //   440: ifeq -> 457
    //   443: aload_2
    //   444: aconst_null
    //   445: invokeinterface setWorldBorder : (Lorg/bukkit/WorldBorder;)V
    //   450: goto -> 457
    //   453: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   456: athrow
    //   457: aload_2
    //   458: sipush #-7356
    //   461: sipush #-10757
    //   464: invokestatic a : (II)Ljava/lang/String;
    //   467: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : I
    //   470: getstatic org/bukkit/ChatColor.YELLOW : Lorg/bukkit/ChatColor;
    //   473: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;Ljava/lang/String;ILorg/bukkit/ChatColor;)V
    //   476: aload_2
    //   477: getstatic org/bukkit/ChatColor.GRAY : Lorg/bukkit/ChatColor;
    //   480: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   483: getstatic org/bukkit/ChatColor.BOLD : Lorg/bukkit/ChatColor;
    //   486: invokevirtual toString : ()Ljava/lang/String;
    //   489: getstatic org/bukkit/ChatColor.WHITE : Lorg/bukkit/ChatColor;
    //   492: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   495: getstatic org/bukkit/ChatColor.BOLD : Lorg/bukkit/ChatColor;
    //   498: invokevirtual toString : ()Ljava/lang/String;
    //   501: getstatic org/bukkit/ChatColor.GRAY : Lorg/bukkit/ChatColor;
    //   504: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   507: getstatic org/bukkit/ChatColor.BOLD : Lorg/bukkit/ChatColor;
    //   510: invokevirtual toString : ()Ljava/lang/String;
    //   513: astore #16
    //   515: astore #17
    //   517: astore #18
    //   519: astore #19
    //   521: astore #20
    //   523: aload #20
    //   525: sipush #-7348
    //   528: sipush #16114
    //   531: invokestatic a : (II)Ljava/lang/String;
    //   534: aload #19
    //   536: aload #18
    //   538: sipush #-7353
    //   541: sipush #-24228
    //   544: invokestatic a : (II)Ljava/lang/String;
    //   547: aload #17
    //   549: aload #16
    //   551: ldc '!'
    //   553: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   558: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;Ljava/lang/String;)V
    //   561: aload_2
    //   562: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   567: sipush #-7359
    //   570: sipush #27784
    //   573: invokestatic a : (II)Ljava/lang/String;
    //   576: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : I
    //   579: i2d
    //   580: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Ljava/util/UUID;Ljava/lang/String;D)V
    //   583: aload_1
    //   584: iconst_1
    //   585: invokevirtual setCancelled : (Z)V
    //   588: return
    // Exception table:
    //   from	to	target	type
    //   5	25	28	java/lang/MatchException
    //   15	39	42	java/lang/MatchException
    //   32	61	64	java/lang/MatchException
    //   46	89	92	java/lang/MatchException
    //   129	139	142	java/lang/MatchException
    //   345	367	370	java/lang/MatchException
    //   377	450	453	java/lang/MatchException
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764v.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a((LivingEntity)paramPlayer, Particle.DUST, new Particle.DustOptions(Color.BLACK, 1.0F), (Sound)null, 1.0F);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), a(-7358, 7288)))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), a(-7347, -18753), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, a(-7360, -25946), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, ChatColor.YELLOW);
    Vector vector = paramPlayer.getLocation().getDirection();
    Location location = paramPlayer.getLocation();
    double d = Main.getInstance().getConfig().getInt(a(-7354, -157), 10);
    for (Entity entity : paramPlayer.getWorld().getNearbyEntities(location, d, d, d)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity)entity;
        try {
          if (livingEntity.equals(paramPlayer))
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        Vector vector1 = livingEntity.getLocation().toVector().subtract(location.toVector());
        try {
          if (vector.dot(vector1.normalize()) > 0.0D && vector1.length() <= d) {
            Location location1 = livingEntity.getLocation().clone();
            livingEntity.getWorld().spawnParticle(Particle.SQUID_INK, location1.add(0.0D, 1.0D, 0.0D), 15, 0.2D, 0.2D, 0.2D, 0.01D);
            livingEntity.getWorld().playSound(livingEntity.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 5.0F, 0.7F);
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity, Main.getInstance().getConfig().getInt(a(-7349, 25961)), paramPlayer);
            livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 60, 1, true, true, true));
            livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0, true, true, true));
          } 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } 
    } 
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(Player paramPlayer) {
    int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.put(paramPlayer.getUniqueId(), Integer.valueOf(i + 1));
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.put(paramPlayer.getUniqueId(), Long.valueOf(System.currentTimeMillis()));
  }
  
  private int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    long l = System.currentTimeMillis();
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.containsKey(paramPlayer.getUniqueId()))
        try {
          if (l - ((Long)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.get(paramPlayer.getUniqueId())).longValue() > 2500L)
            this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.put(paramPlayer.getUniqueId(), Integer.valueOf(0)); 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return ((Integer)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getOrDefault(paramPlayer.getUniqueId(), Integer.valueOf(0))).intValue();
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
    try {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764v.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a((LivingEntity)player, Particle.CRIT, null, Particle.ITEM, new ItemStack(Material.BLACK_CONCRETE), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 2.0F);
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramEntityDamageByEntityEvent))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (ThreadLocalRandom.current().nextInt(100) < 30) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramEntityDamageByEntityEvent.getEntity(), player);
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 0.1F);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Entity entity1 = paramEntityDamageByEntityEvent.getEntity();
    Entity entity2 = paramEntityDamageByEntityEvent.getDamager();
    Vector vector1 = entity1.getLocation().getDirection().setY(0).normalize();
    Vector vector2 = entity2.getLocation().toVector().subtract(entity1.getLocation().toVector()).setY(0).normalize();
    try {
    
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return (vector1.dot(vector2) < -0.5D);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Entity paramEntity, Player paramPlayer) {
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764t.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramEntity.getLocation()))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fc(paramEntity, paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  static {
    // Byte code:
    //   0: bipush #16
    //   2: anewarray java/lang/String
    //   5: astore #5
    //   7: iconst_0
    //   8: istore_3
    //   9: ldc 'eoÏIy«7Ìk¾ÙG=WázìZAFÞ|süÔwZ7ý\\b¬ûãLÌ)': j;Ý0Ç+ ÑUSÔv¸q>n\\nò;ÆöCÂ©åÔ,ÍùÁ+­£\\rÓ3ñ-@µ&f¸áï¨xkûy?gÃáhï¤Þ& ÅCÄE<?Ï\\b\\nc¶iG¶«»~'ötò :.;ý÷}Û\\nÈ³Nü9Or~{·Ûøçd»ðÇUz'
    //   11: dup
    //   12: astore_2
    //   13: invokevirtual length : ()I
    //   16: istore #4
    //   18: bipush #7
    //   20: istore_1
    //   21: iconst_m1
    //   22: istore_0
    //   23: bipush #43
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
    //   68: ldc 'Ä¶\\fúòG^mo¿Ë'
    //   70: dup
    //   71: astore_2
    //   72: invokevirtual length : ()I
    //   75: istore #4
    //   77: bipush #10
    //   79: istore_1
    //   80: iconst_m1
    //   81: istore_0
    //   82: bipush #54
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
    //   129: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.a : [Ljava/lang/String;
    //   132: bipush #16
    //   134: anewarray java/lang/String
    //   137: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.b : [Ljava/lang/String;
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
    //   212: bipush #77
    //   214: goto -> 244
    //   217: bipush #123
    //   219: goto -> 244
    //   222: bipush #11
    //   224: goto -> 244
    //   227: bipush #119
    //   229: goto -> 244
    //   232: bipush #113
    //   234: goto -> 244
    //   237: bipush #18
    //   239: goto -> 244
    //   242: bipush #88
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
    //   300: invokestatic getInstance : ()Lpl/Main;
    //   303: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   306: sipush #-7346
    //   309: sipush #-13224
    //   312: invokestatic a : (II)Ljava/lang/String;
    //   315: bipush #30
    //   317: invokevirtual getInt : (Ljava/lang/String;I)I
    //   320: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : I
    //   323: invokestatic getInstance : ()Lpl/Main;
    //   326: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   329: sipush #-7345
    //   332: sipush #9725
    //   335: invokestatic a : (II)Ljava/lang/String;
    //   338: bipush #15
    //   340: invokevirtual getInt : (Ljava/lang/String;I)I
    //   343: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : I
    //   346: new java/util/HashMap
    //   349: dup
    //   350: invokespecial <init> : ()V
    //   353: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : Ljava/util/HashMap;
    //   356: new java/util/HashMap
    //   359: dup
    //   360: invokespecial <init> : ()V
    //   363: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d : Ljava/util/HashMap;
    //   366: return
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0xFFFFE34D) & 0xFFFF;
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
      char c = 'â';
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */