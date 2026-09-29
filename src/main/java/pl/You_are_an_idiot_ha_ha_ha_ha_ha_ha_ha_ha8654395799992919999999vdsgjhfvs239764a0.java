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

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = false;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = Main.getInstance().getConfig().getDouble("copperLeggingsMaxDamage", 30.0D);
  }
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getLeggings();
    {
      if (itemStack == null)
        return false; 
    }{
      if (itemStack.getType() != Material.NETHERITE_LEGGINGS)
        return false; 
    }{
      if (!itemStack.hasItemMeta())
        return false; 
    }ItemMeta itemMeta = itemStack.getItemMeta();
    {
      if (itemMeta == null)
        return false; 
    }{
      if (!itemMeta.hasCustomModelData())
        return false; 
    }{
    
    }return (itemMeta.getCustomModelData() == 1);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerMoveEvent paramPlayerMoveEvent) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    }Player player = paramPlayerMoveEvent.getPlayer();
    UUID uUID = player.getUniqueId();
    {
      if (player.getVelocity().getY() >= 0.8D) {
        {
          if (player.isOnGround())
            return; 
        }} else {
        return;
      } 
    }{
      if (paramPlayerMoveEvent.getFrom().getBlockY() == paramPlayerMoveEvent.getTo().getBlockY())
        return; 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player)) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(uUID);
        return;
      } 
    }double d = player.getLocation().getY();
    {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(uUID)) {
        {
          if (player.getVelocity().getY() > 0.8D)
            {
              if (!player.isOnGround()) {
                this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(uUID, Double.valueOf(d));
                this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.put(uUID, Long.valueOf(System.currentTimeMillis()));
              } 
            }}return;
      } 
    }Long long_ = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.get(uUID);
    {
      if (long_ != null)
        {
          if (System.currentTimeMillis() - long_.longValue() <= 10000L) {
            {
              this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.compute(uUID, (paramK, paramV) -> lambda$onMove$0(d, paramK, paramV));
              if (!player.isOnGround())
                return; 
            }double d1 = ((Double)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.get(uUID)).doubleValue();
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(uUID);
            double d2 = d1 - d;
            {
              if (d2 < 5.0D)
                return; 
            }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, player.getLocation(), d2);
            return;
          } 
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(uUID);
          return;
        }}You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(uUID);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageEvent paramEntityDamageEvent) {
    Player player;
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    }Entity entity = paramEntityDamageEvent.getEntity();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    {
      if (paramEntityDamageEvent.getCause() != EntityDamageEvent.DamageCause.FALL)
        return; 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player))
        return; 
    }double d = player.getFallDistance();
    Location location = player.getLocation().clone();
    {
      paramEntityDamageEvent.setCancelled(true);
      if (d < 5.0D)
        return; 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, location, d);
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
          {
            if (paramLocation.getWorld() == location.getWorld())
              {
                if (location.distance(paramLocation) <= paramDouble) {
                  Material material = location.getBlock().getType();
                  {
                    if (material != Material.AIR)
                      {
                        if (material != Material.BEDROCK)
                          {
                            if (material != Material.OBSIDIAN)
                              {
                                if (material != Material.BARRIER)
                                  {
                                    if (!material.name().contains("COMMAND"))
                                      {
                                        if (Math.random() < 0.5D)
                                          location.getBlock().breakNaturally(); 
                                      }}}}}}} 
              }}} 
      } 
    } 
  }
  
  private static Double lambda$onMove$0(double paramDouble, UUID paramUUID, Double paramDouble1) {
    return Double.valueOf(Math.max(paramDouble1.doubleValue(), paramDouble));
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */