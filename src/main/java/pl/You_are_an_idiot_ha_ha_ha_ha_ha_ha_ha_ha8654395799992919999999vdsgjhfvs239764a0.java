package pl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0 implements Listener {
  private final Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  private final Map<UUID, Double> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new HashMap<>();
  
  private final Map<UUID, Boolean> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new HashMap<>();
  
  private final Map<UUID, Long> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = new HashMap<>();
  
  private static final boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  static double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  private static final String[] a;
  
  private static final String[] b;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getLeggings();
    try {
      if (itemStack == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemStack.getType() != Material.NETHERITE_LEGGINGS)
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
    return (itemMeta.getCustomModelData() == 1);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerMoveEvent paramPlayerMoveEvent) {
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Player player = paramPlayerMoveEvent.getPlayer();
    UUID uUID = player.getUniqueId();
    try {
      if (player.getVelocity().getY() >= 0.8D) {
        try {
          if (player.isOnGround())
            return; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } else {
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramPlayerMoveEvent.getFrom().getBlockY() == paramPlayerMoveEvent.getTo().getBlockY())
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player)) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(uUID);
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    double d = player.getLocation().getY();
    try {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(uUID)) {
        try {
          if (player.getVelocity().getY() > 0.8D)
            try {
              if (!player.isOnGround()) {
                this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(uUID, Double.valueOf(d));
                this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.put(uUID, Long.valueOf(System.currentTimeMillis()));
              } 
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        } 
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Long long_ = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.get(uUID);
    try {
      if (long_ != null)
        try {
          if (System.currentTimeMillis() - long_.longValue() <= 10000L) {
            try {
              this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.compute(uUID, (paramK, paramV) -> lambda$onMove$0(d, paramK, paramV));
              if (!player.isOnGround())
                return; 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            double d1 = ((Double)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.get(uUID)).doubleValue();
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(uUID);
            double d2 = d1 - d;
            try {
              if (d2 < 5.0D)
                return; 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, player.getLocation(), d2);
            return;
          } 
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(uUID);
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(uUID);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageEvent paramEntityDamageEvent) {
    Player player;
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Entity entity = paramEntityDamageEvent.getEntity();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    try {
      if (paramEntityDamageEvent.getCause() != EntityDamageEvent.DamageCause.FALL)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    double d = player.getFallDistance();
    Location location = player.getLocation().clone();
    try {
      paramEntityDamageEvent.setCancelled(true);
      if (d < 5.0D)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, location, d);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(UUID paramUUID) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.remove(paramUUID);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(paramUUID);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(paramUUID);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, Location paramLocation, double paramDouble) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual getWorld : ()Lorg/bukkit/World;
    //   4: astore #5
    //   6: aload #5
    //   8: ifnonnull -> 16
    //   11: return
    //   12: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   15: athrow
    //   16: dload_3
    //   17: ldc2_w 5.0
    //   20: ddiv
    //   21: ldc2_w 1.5
    //   24: invokestatic pow : (DD)D
    //   27: ldc2_w 15.0
    //   30: dmul
    //   31: dstore #6
    //   33: dload #6
    //   35: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f : D
    //   38: invokestatic min : (DD)D
    //   41: dstore #6
    //   43: dload_3
    //   44: ldc2_w 4.0
    //   47: ddiv
    //   48: ldc2_w 8.0
    //   51: invokestatic min : (DD)D
    //   54: dstore #8
    //   56: dload_3
    //   57: ldc2_w 5.0
    //   60: dcmpl
    //   61: iflt -> 152
    //   64: dload_3
    //   65: ldc2_w 10.0
    //   68: dcmpg
    //   69: ifge -> 152
    //   72: goto -> 79
    //   75: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   78: athrow
    //   79: aload #5
    //   81: aload_2
    //   82: getstatic org/bukkit/Sound.ENTITY_GENERIC_EXPLODE : Lorg/bukkit/Sound;
    //   85: ldc 0.5
    //   87: ldc 1.2
    //   89: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   94: aload #5
    //   96: getstatic org/bukkit/Particle.EXPLOSION : Lorg/bukkit/Particle;
    //   99: aload_2
    //   100: iconst_1
    //   101: invokeinterface spawnParticle : (Lorg/bukkit/Particle;Lorg/bukkit/Location;I)V
    //   106: aload #5
    //   108: getstatic org/bukkit/Particle.BLOCK : Lorg/bukkit/Particle;
    //   111: aload_2
    //   112: invokevirtual clone : ()Lorg/bukkit/Location;
    //   115: dconst_0
    //   116: ldc2_w 0.1
    //   119: dconst_0
    //   120: invokevirtual add : (DDD)Lorg/bukkit/Location;
    //   123: bipush #30
    //   125: ldc2_w 0.5
    //   128: ldc2_w 0.1
    //   131: ldc2_w 0.5
    //   134: getstatic org/bukkit/Material.DIRT : Lorg/bukkit/Material;
    //   137: invokevirtual createBlockData : ()Lorg/bukkit/block/data/BlockData;
    //   140: invokeinterface spawnParticle : (Lorg/bukkit/Particle;Lorg/bukkit/Location;IDDDLjava/lang/Object;)V
    //   145: goto -> 460
    //   148: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   151: athrow
    //   152: dload_3
    //   153: ldc2_w 10.0
    //   156: dcmpl
    //   157: iflt -> 277
    //   160: dload_3
    //   161: ldc2_w 90.0
    //   164: dcmpg
    //   165: ifge -> 277
    //   168: goto -> 175
    //   171: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   174: athrow
    //   175: aload #5
    //   177: aload_2
    //   178: getstatic org/bukkit/Sound.ENTITY_GENERIC_EXPLODE : Lorg/bukkit/Sound;
    //   181: fconst_1
    //   182: ldc 0.9
    //   184: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   189: aload #5
    //   191: getstatic org/bukkit/Particle.EXPLOSION : Lorg/bukkit/Particle;
    //   194: aload_2
    //   195: iconst_3
    //   196: ldc2_w 0.5
    //   199: ldc2_w 0.1
    //   202: ldc2_w 0.5
    //   205: invokeinterface spawnParticle : (Lorg/bukkit/Particle;Lorg/bukkit/Location;IDDD)V
    //   210: aload #5
    //   212: getstatic org/bukkit/Particle.BLOCK : Lorg/bukkit/Particle;
    //   215: aload_2
    //   216: invokevirtual clone : ()Lorg/bukkit/Location;
    //   219: dconst_0
    //   220: ldc2_w 0.1
    //   223: dconst_0
    //   224: invokevirtual add : (DDD)Lorg/bukkit/Location;
    //   227: bipush #60
    //   229: dconst_1
    //   230: ldc2_w 0.1
    //   233: dconst_1
    //   234: getstatic org/bukkit/Material.STONE : Lorg/bukkit/Material;
    //   237: invokevirtual createBlockData : ()Lorg/bukkit/block/data/BlockData;
    //   240: invokeinterface spawnParticle : (Lorg/bukkit/Particle;Lorg/bukkit/Location;IDDDLjava/lang/Object;)V
    //   245: aload #5
    //   247: getstatic org/bukkit/Particle.CAMPFIRE_COSY_SMOKE : Lorg/bukkit/Particle;
    //   250: aload_2
    //   251: bipush #20
    //   253: ldc2_w 0.5
    //   256: ldc2_w 0.1
    //   259: ldc2_w 0.5
    //   262: ldc2_w 0.05
    //   265: invokeinterface spawnParticle : (Lorg/bukkit/Particle;Lorg/bukkit/Location;IDDDD)V
    //   270: goto -> 460
    //   273: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   276: athrow
    //   277: dload_3
    //   278: ldc2_w 90.0
    //   281: dcmpl
    //   282: iflt -> 460
    //   285: aload #5
    //   287: aload_2
    //   288: getstatic org/bukkit/Sound.ENTITY_GENERIC_EXPLODE : Lorg/bukkit/Sound;
    //   291: fconst_2
    //   292: ldc 0.7
    //   294: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   299: aload #5
    //   301: aload_2
    //   302: getstatic org/bukkit/Sound.ENTITY_DRAGON_FIREBALL_EXPLODE : Lorg/bukkit/Sound;
    //   305: ldc 1.5
    //   307: ldc 0.8
    //   309: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   314: aload #5
    //   316: getstatic org/bukkit/Particle.EXPLOSION : Lorg/bukkit/Particle;
    //   319: aload_2
    //   320: bipush #8
    //   322: dconst_1
    //   323: ldc2_w 0.2
    //   326: dconst_1
    //   327: invokeinterface spawnParticle : (Lorg/bukkit/Particle;Lorg/bukkit/Location;IDDD)V
    //   332: aload #5
    //   334: getstatic org/bukkit/Particle.EXPLOSION : Lorg/bukkit/Particle;
    //   337: aload_2
    //   338: iconst_2
    //   339: invokeinterface spawnParticle : (Lorg/bukkit/Particle;Lorg/bukkit/Location;I)V
    //   344: aload #5
    //   346: getstatic org/bukkit/Particle.BLOCK : Lorg/bukkit/Particle;
    //   349: aload_2
    //   350: invokevirtual clone : ()Lorg/bukkit/Location;
    //   353: dconst_0
    //   354: ldc2_w 0.1
    //   357: dconst_0
    //   358: invokevirtual add : (DDD)Lorg/bukkit/Location;
    //   361: bipush #100
    //   363: ldc2_w 2.0
    //   366: ldc2_w 0.2
    //   369: ldc2_w 2.0
    //   372: getstatic org/bukkit/Material.STONE : Lorg/bukkit/Material;
    //   375: invokevirtual createBlockData : ()Lorg/bukkit/block/data/BlockData;
    //   378: invokeinterface spawnParticle : (Lorg/bukkit/Particle;Lorg/bukkit/Location;IDDDLjava/lang/Object;)V
    //   383: aload #5
    //   385: getstatic org/bukkit/Particle.CAMPFIRE_COSY_SMOKE : Lorg/bukkit/Particle;
    //   388: aload_2
    //   389: bipush #40
    //   391: dconst_1
    //   392: ldc2_w 0.5
    //   395: dconst_1
    //   396: ldc2_w 0.1
    //   399: invokeinterface spawnParticle : (Lorg/bukkit/Particle;Lorg/bukkit/Location;IDDDD)V
    //   404: aload #5
    //   406: getstatic org/bukkit/Particle.LAVA : Lorg/bukkit/Particle;
    //   409: aload_2
    //   410: bipush #15
    //   412: ldc2_w 1.5
    //   415: ldc2_w 0.1
    //   418: ldc2_w 1.5
    //   421: invokeinterface spawnParticle : (Lorg/bukkit/Particle;Lorg/bukkit/Location;IDDD)V
    //   426: dload_3
    //   427: ldc2_w 10.0
    //   430: ddiv
    //   431: ldc2_w 4.0
    //   434: invokestatic min : (DD)D
    //   437: dstore #10
    //   439: invokestatic getScheduler : ()Lorg/bukkit/scheduler/BukkitScheduler;
    //   442: aload_0
    //   443: getfield You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Lpl/Main;
    //   446: dload #10
    //   448: aload_2
    //   449: <illegal opcode> run : (DLorg/bukkit/Location;)Ljava/lang/Runnable;
    //   454: invokeinterface runTask : (Lorg/bukkit/plugin/Plugin;Ljava/lang/Runnable;)Lorg/bukkit/scheduler/BukkitTask;
    //   459: pop
    //   460: aload #5
    //   462: aload_2
    //   463: dload #8
    //   465: dload #8
    //   467: dload #8
    //   469: invokeinterface getNearbyEntities : (Lorg/bukkit/Location;DDD)Ljava/util/Collection;
    //   474: astore #10
    //   476: aload #10
    //   478: invokeinterface iterator : ()Ljava/util/Iterator;
    //   483: astore #11
    //   485: aload #11
    //   487: invokeinterface hasNext : ()Z
    //   492: ifeq -> 699
    //   495: aload #11
    //   497: invokeinterface next : ()Ljava/lang/Object;
    //   502: checkcast org/bukkit/entity/Entity
    //   505: astore #12
    //   507: aload #12
    //   509: instanceof org/bukkit/entity/LivingEntity
    //   512: ifeq -> 485
    //   515: aload #12
    //   517: checkcast org/bukkit/entity/LivingEntity
    //   520: astore #13
    //   522: aload #12
    //   524: aload_1
    //   525: invokeinterface equals : (Ljava/lang/Object;)Z
    //   530: ifeq -> 540
    //   533: goto -> 485
    //   536: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   539: athrow
    //   540: aload_2
    //   541: invokevirtual getWorld : ()Lorg/bukkit/World;
    //   544: aload #13
    //   546: invokeinterface getWorld : ()Lorg/bukkit/World;
    //   551: if_acmpeq -> 561
    //   554: goto -> 485
    //   557: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   560: athrow
    //   561: aload #13
    //   563: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   568: aload_2
    //   569: invokevirtual distance : (Lorg/bukkit/Location;)D
    //   572: dstore #14
    //   574: dload #14
    //   576: dload #8
    //   578: dcmpl
    //   579: ifle -> 589
    //   582: goto -> 485
    //   585: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   588: athrow
    //   589: dconst_0
    //   590: dload #6
    //   592: ldc2_w 1.5
    //   595: dload #14
    //   597: dload #8
    //   599: ddiv
    //   600: dsub
    //   601: dmul
    //   602: invokestatic max : (DD)D
    //   605: dstore #16
    //   607: dload #16
    //   609: dconst_0
    //   610: dcmpg
    //   611: ifgt -> 621
    //   614: goto -> 485
    //   617: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   620: athrow
    //   621: aload #13
    //   623: dload #16
    //   625: aload_1
    //   626: invokeinterface damage : (DLorg/bukkit/entity/Entity;)V
    //   631: aload #13
    //   633: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   638: invokevirtual toVector : ()Lorg/bukkit/util/Vector;
    //   641: aload_2
    //   642: invokevirtual toVector : ()Lorg/bukkit/util/Vector;
    //   645: invokevirtual subtract : (Lorg/bukkit/util/Vector;)Lorg/bukkit/util/Vector;
    //   648: astore #18
    //   650: aload #18
    //   652: invokevirtual lengthSquared : ()D
    //   655: ldc2_w 1.0E-4
    //   658: dcmpl
    //   659: ifle -> 696
    //   662: aload #18
    //   664: invokevirtual normalize : ()Lorg/bukkit/util/Vector;
    //   667: ldc2_w 0.5
    //   670: invokevirtual multiply : (D)Lorg/bukkit/util/Vector;
    //   673: ldc2_w 0.3
    //   676: invokevirtual setY : (D)Lorg/bukkit/util/Vector;
    //   679: pop
    //   680: aload #13
    //   682: aload #18
    //   684: invokeinterface setVelocity : (Lorg/bukkit/util/Vector;)V
    //   689: goto -> 696
    //   692: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   695: athrow
    //   696: goto -> 485
    //   699: return
    // Exception table:
    //   from	to	target	type
    //   6	12	12	java/lang/MatchException
    //   56	72	75	java/lang/MatchException
    //   64	148	148	java/lang/MatchException
    //   152	168	171	java/lang/MatchException
    //   160	273	273	java/lang/MatchException
    //   522	536	536	java/lang/MatchException
    //   540	557	557	java/lang/MatchException
    //   574	585	585	java/lang/MatchException
    //   607	617	617	java/lang/MatchException
    //   650	689	692	java/lang/MatchException
  }
  
  private static void lambda$triggerShockwave$1(double paramDouble, Location paramLocation) {
    for (int i = -((int)paramDouble); i <= paramDouble; i++) {
      for (byte b = -1; b <= 1; b++) {
        for (int j = -((int)paramDouble); j <= paramDouble; j++) {
          Location location = paramLocation.clone().add(i, b, j);
          try {
            if (paramLocation.getWorld() == location.getWorld())
              try {
                if (location.distance(paramLocation) <= paramDouble) {
                  Material material = location.getBlock().getType();
                  try {
                    if (material != Material.AIR)
                      try {
                        if (material != Material.BEDROCK)
                          try {
                            if (material != Material.OBSIDIAN)
                              try {
                                if (material != Material.BARRIER)
                                  try {
                                    if (!material.name().contains(a(-20581, 19434)))
                                      try {
                                        if (Math.random() < 0.5D)
                                          location.getBlock().breakNaturally(); 
                                      } catch (MatchException matchException) {
                                        throw a(null);
                                      }  
                                  } catch (MatchException matchException) {
                                    throw a(null);
                                  }  
                              } catch (MatchException matchException) {
                                throw a(null);
                              }  
                          } catch (MatchException matchException) {
                            throw a(null);
                          }  
                      } catch (MatchException matchException) {
                        throw a(null);
                      }  
                  } catch (MatchException matchException) {
                    throw a(null);
                  } 
                } 
              } catch (MatchException matchException) {
                throw a(null);
              }  
          } catch (MatchException matchException) {
            throw a(null);
          } 
        } 
      } 
    } 
  }
  
  private static Double lambda$onMove$0(double paramDouble, UUID paramUUID, Double paramDouble1) {
    return Double.valueOf(Math.max(paramDouble1.doubleValue(), paramDouble));
  }
  
  static {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray java/lang/String
    //   4: astore #5
    //   6: iconst_0
    //   7: istore_3
    //   8: ldc 'ÁZ¬0t½/k`QE.N+LIàÿÆ+Ý÷p'
    //   10: dup
    //   11: astore_2
    //   12: invokevirtual length : ()I
    //   15: istore #4
    //   17: bipush #7
    //   19: istore_1
    //   20: iconst_m1
    //   21: istore_0
    //   22: bipush #51
    //   24: iinc #0, 1
    //   27: aload_2
    //   28: iload_0
    //   29: dup
    //   30: iload_1
    //   31: iadd
    //   32: invokevirtual substring : (II)Ljava/lang/String;
    //   35: iconst_m1
    //   36: goto -> 82
    //   39: aload #5
    //   41: swap
    //   42: iload_3
    //   43: iinc #3, 1
    //   46: swap
    //   47: aastore
    //   48: iload_0
    //   49: iload_1
    //   50: iadd
    //   51: dup
    //   52: istore_0
    //   53: iload #4
    //   55: if_icmpge -> 67
    //   58: aload_2
    //   59: iload_0
    //   60: invokevirtual charAt : (I)C
    //   63: istore_1
    //   64: goto -> 22
    //   67: aload #5
    //   69: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0.a : [Ljava/lang/String;
    //   72: iconst_2
    //   73: anewarray java/lang/String
    //   76: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0.b : [Ljava/lang/String;
    //   79: goto -> 227
    //   82: dup_x2
    //   83: pop
    //   84: invokevirtual toCharArray : ()[C
    //   87: dup_x1
    //   88: arraylength
    //   89: dup_x2
    //   90: pop
    //   91: iconst_0
    //   92: istore #6
    //   94: dup2_x1
    //   95: pop2
    //   96: dup_x2
    //   97: iconst_1
    //   98: if_icmpgt -> 200
    //   101: dup2
    //   102: swap
    //   103: iload #6
    //   105: dup2_x1
    //   106: caload
    //   107: swap
    //   108: iload #6
    //   110: bipush #7
    //   112: irem
    //   113: tableswitch default -> 182, 0 -> 152, 1 -> 157, 2 -> 162, 3 -> 167, 4 -> 172, 5 -> 177
    //   152: bipush #98
    //   154: goto -> 184
    //   157: bipush #18
    //   159: goto -> 184
    //   162: bipush #81
    //   164: goto -> 184
    //   167: bipush #27
    //   169: goto -> 184
    //   172: bipush #31
    //   174: goto -> 184
    //   177: bipush #57
    //   179: goto -> 184
    //   182: bipush #15
    //   184: ixor
    //   185: ixor
    //   186: i2c
    //   187: castore
    //   188: iinc #6, 1
    //   191: dup
    //   192: ifne -> 200
    //   195: dup2
    //   196: dup_x1
    //   197: goto -> 105
    //   200: dup2_x1
    //   201: pop2
    //   202: dup_x2
    //   203: iload #6
    //   205: if_icmpgt -> 101
    //   208: pop
    //   209: new java/lang/String
    //   212: dup_x1
    //   213: swap
    //   214: invokespecial <init> : ([C)V
    //   217: invokevirtual intern : ()Ljava/lang/String;
    //   220: swap
    //   221: pop
    //   222: swap
    //   223: pop
    //   224: goto -> 39
    //   227: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : Z
    //   230: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : Z
    //   233: invokestatic getInstance : ()Lpl/Main;
    //   236: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   239: sipush #-20582
    //   242: sipush #26003
    //   245: invokestatic a : (II)Ljava/lang/String;
    //   248: ldc2_w 30.0
    //   251: invokevirtual getDouble : (Ljava/lang/String;D)D
    //   254: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f : D
    //   257: return
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0xFFFFAF9B) & 0xFFFF;
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
      char c = '»';
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */