package pl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad implements Listener {
  public Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public Set<Player> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new HashSet<>();
  
  private static final String[] a;
  
  private static final String[] b;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    try {
      if (itemStack.getType() != Material.CROSSBOW)
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
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractEvent paramPlayerInteractEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getPlayer : ()Lorg/bukkit/entity/Player;
    //   4: astore_2
    //   5: aload_2
    //   6: invokeinterface getInventory : ()Lorg/bukkit/inventory/PlayerInventory;
    //   11: invokeinterface getItemInMainHand : ()Lorg/bukkit/inventory/ItemStack;
    //   16: astore_3
    //   17: aload_2
    //   18: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)Z
    //   21: ifne -> 29
    //   24: return
    //   25: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   28: athrow
    //   29: aload_3
    //   30: invokevirtual getItemMeta : ()Lorg/bukkit/inventory/meta/ItemMeta;
    //   33: checkcast org/bukkit/inventory/meta/CrossbowMeta
    //   36: astore #4
    //   38: aload #4
    //   40: invokeinterface hasChargedProjectiles : ()Z
    //   45: ifne -> 53
    //   48: return
    //   49: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   52: athrow
    //   53: aload_1
    //   54: invokevirtual getAction : ()Lorg/bukkit/event/block/Action;
    //   57: getstatic org/bukkit/event/block/Action.RIGHT_CLICK_AIR : Lorg/bukkit/event/block/Action;
    //   60: if_acmpeq -> 85
    //   63: aload_1
    //   64: invokevirtual getAction : ()Lorg/bukkit/event/block/Action;
    //   67: getstatic org/bukkit/event/block/Action.RIGHT_CLICK_BLOCK : Lorg/bukkit/event/block/Action;
    //   70: if_acmpeq -> 85
    //   73: goto -> 80
    //   76: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   79: athrow
    //   80: return
    //   81: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   84: athrow
    //   85: aload_1
    //   86: iconst_1
    //   87: invokevirtual setCancelled : (Z)V
    //   90: aload #4
    //   92: aconst_null
    //   93: invokeinterface setChargedProjectiles : (Ljava/util/List;)V
    //   98: aload_3
    //   99: aload #4
    //   101: invokevirtual setItemMeta : (Lorg/bukkit/inventory/meta/ItemMeta;)Z
    //   104: pop
    //   105: aload_2
    //   106: invokeinterface isSneaking : ()Z
    //   111: ifne -> 142
    //   114: aload_2
    //   115: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   120: sipush #14171
    //   123: sipush #6854
    //   126: invokestatic a : (II)Ljava/lang/String;
    //   129: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Ljava/util/UUID;Ljava/lang/String;)Z
    //   132: ifeq -> 201
    //   135: goto -> 142
    //   138: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   141: athrow
    //   142: aload_2
    //   143: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   148: sipush #14175
    //   151: sipush #22779
    //   154: invokestatic a : (II)Ljava/lang/String;
    //   157: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Ljava/util/UUID;Ljava/lang/String;)Z
    //   160: ifne -> 201
    //   163: goto -> 170
    //   166: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   169: athrow
    //   170: aload_2
    //   171: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   176: sipush #14152
    //   179: sipush #3587
    //   182: invokestatic a : (II)Ljava/lang/String;
    //   185: dconst_0
    //   186: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Ljava/util/UUID;Ljava/lang/String;D)V
    //   189: aload_0
    //   190: aload_2
    //   191: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : (Lorg/bukkit/entity/Player;)V
    //   194: goto -> 205
    //   197: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   200: athrow
    //   201: aload_2
    //   202: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)V
    //   205: return
    // Exception table:
    //   from	to	target	type
    //   17	25	25	java/lang/MatchException
    //   38	49	49	java/lang/MatchException
    //   53	73	76	java/lang/MatchException
    //   63	81	81	java/lang/MatchException
    //   85	135	138	java/lang/MatchException
    //   114	163	166	java/lang/MatchException
    //   142	197	197	java/lang/MatchException
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface getWorld : ()Lorg/bukkit/World;
    //   6: astore_1
    //   7: aload_1
    //   8: aload_0
    //   9: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   14: getstatic org/bukkit/Sound.ENTITY_BLAZE_SHOOT : Lorg/bukkit/Sound;
    //   17: fconst_1
    //   18: ldc 0.8
    //   20: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   25: aload_1
    //   26: aload_0
    //   27: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   32: getstatic org/bukkit/Sound.ENTITY_WARDEN_SONIC_BOOM : Lorg/bukkit/Sound;
    //   35: fconst_1
    //   36: ldc 1.5
    //   38: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   43: aload_1
    //   44: aload_0
    //   45: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   50: getstatic org/bukkit/Sound.ENTITY_GENERIC_EXTINGUISH_FIRE : Lorg/bukkit/Sound;
    //   53: fconst_1
    //   54: fconst_1
    //   55: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   60: aload_1
    //   61: aload_0
    //   62: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   67: getstatic org/bukkit/Sound.ITEM_CROSSBOW_SHOOT : Lorg/bukkit/Sound;
    //   70: fconst_1
    //   71: fconst_0
    //   72: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   77: aload_0
    //   78: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   83: invokevirtual getDirection : ()Lorg/bukkit/util/Vector;
    //   86: invokevirtual normalize : ()Lorg/bukkit/util/Vector;
    //   89: astore_2
    //   90: aload_0
    //   91: invokeinterface getVelocity : ()Lorg/bukkit/util/Vector;
    //   96: astore_3
    //   97: aload_0
    //   98: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   103: invokevirtual clone : ()Lorg/bukkit/Location;
    //   106: dconst_0
    //   107: ldc2_w 1.6
    //   110: dconst_0
    //   111: invokevirtual add : (DDD)Lorg/bukkit/Location;
    //   114: aload_2
    //   115: invokevirtual clone : ()Lorg/bukkit/util/Vector;
    //   118: ldc2_w 1.5
    //   121: invokevirtual multiply : (D)Lorg/bukkit/util/Vector;
    //   124: invokevirtual add : (Lorg/bukkit/util/Vector;)Lorg/bukkit/Location;
    //   127: astore #4
    //   129: aload_2
    //   130: invokevirtual clone : ()Lorg/bukkit/util/Vector;
    //   133: new org/bukkit/util/Vector
    //   136: dup
    //   137: iconst_0
    //   138: iconst_1
    //   139: iconst_0
    //   140: invokespecial <init> : (III)V
    //   143: invokevirtual crossProduct : (Lorg/bukkit/util/Vector;)Lorg/bukkit/util/Vector;
    //   146: invokevirtual normalize : ()Lorg/bukkit/util/Vector;
    //   149: astore #5
    //   151: aload #4
    //   153: invokevirtual clone : ()Lorg/bukkit/Location;
    //   156: aload #5
    //   158: invokevirtual clone : ()Lorg/bukkit/util/Vector;
    //   161: iconst_2
    //   162: invokevirtual multiply : (I)Lorg/bukkit/util/Vector;
    //   165: invokevirtual add : (Lorg/bukkit/util/Vector;)Lorg/bukkit/Location;
    //   168: astore #6
    //   170: aload #4
    //   172: invokevirtual clone : ()Lorg/bukkit/Location;
    //   175: aload #5
    //   177: invokevirtual clone : ()Lorg/bukkit/util/Vector;
    //   180: iconst_2
    //   181: invokevirtual multiply : (I)Lorg/bukkit/util/Vector;
    //   184: invokevirtual subtract : (Lorg/bukkit/util/Vector;)Lorg/bukkit/Location;
    //   187: astore #7
    //   189: aload_1
    //   190: aload #4
    //   192: getstatic org/bukkit/entity/EntityType.ARROW : Lorg/bukkit/entity/EntityType;
    //   195: getstatic org/bukkit/event/entity/CreatureSpawnEvent$SpawnReason.CUSTOM : Lorg/bukkit/event/entity/CreatureSpawnEvent$SpawnReason;
    //   198: aload_0
    //   199: aload_2
    //   200: aload_3
    //   201: <illegal opcode> accept : (Lorg/bukkit/entity/Player;Lorg/bukkit/util/Vector;Lorg/bukkit/util/Vector;)Ljava/util/function/Consumer;
    //   206: invokeinterface spawnEntity : (Lorg/bukkit/Location;Lorg/bukkit/entity/EntityType;Lorg/bukkit/event/entity/CreatureSpawnEvent$SpawnReason;Ljava/util/function/Consumer;)Lorg/bukkit/entity/Entity;
    //   211: checkcast org/bukkit/entity/Arrow
    //   214: astore #8
    //   216: aload_1
    //   217: aload #6
    //   219: getstatic org/bukkit/entity/EntityType.ARROW : Lorg/bukkit/entity/EntityType;
    //   222: getstatic org/bukkit/event/entity/CreatureSpawnEvent$SpawnReason.CUSTOM : Lorg/bukkit/event/entity/CreatureSpawnEvent$SpawnReason;
    //   225: aload_0
    //   226: aload_2
    //   227: aload_3
    //   228: <illegal opcode> accept : (Lorg/bukkit/entity/Player;Lorg/bukkit/util/Vector;Lorg/bukkit/util/Vector;)Ljava/util/function/Consumer;
    //   233: invokeinterface spawnEntity : (Lorg/bukkit/Location;Lorg/bukkit/entity/EntityType;Lorg/bukkit/event/entity/CreatureSpawnEvent$SpawnReason;Ljava/util/function/Consumer;)Lorg/bukkit/entity/Entity;
    //   238: checkcast org/bukkit/entity/Arrow
    //   241: astore #9
    //   243: aload_1
    //   244: aload #7
    //   246: getstatic org/bukkit/entity/EntityType.ARROW : Lorg/bukkit/entity/EntityType;
    //   249: getstatic org/bukkit/event/entity/CreatureSpawnEvent$SpawnReason.CUSTOM : Lorg/bukkit/event/entity/CreatureSpawnEvent$SpawnReason;
    //   252: aload_0
    //   253: aload_2
    //   254: aload_3
    //   255: <illegal opcode> accept : (Lorg/bukkit/entity/Player;Lorg/bukkit/util/Vector;Lorg/bukkit/util/Vector;)Ljava/util/function/Consumer;
    //   260: invokeinterface spawnEntity : (Lorg/bukkit/Location;Lorg/bukkit/entity/EntityType;Lorg/bukkit/event/entity/CreatureSpawnEvent$SpawnReason;Ljava/util/function/Consumer;)Lorg/bukkit/entity/Entity;
    //   265: checkcast org/bukkit/entity/Arrow
    //   268: astore #10
    //   270: new pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dl
    //   273: dup
    //   274: aload #8
    //   276: aload #9
    //   278: aload #10
    //   280: aload_1
    //   281: invokespecial <init> : (Lorg/bukkit/entity/Arrow;Lorg/bukkit/entity/Arrow;Lorg/bukkit/entity/Arrow;Lorg/bukkit/World;)V
    //   284: invokestatic getInstance : ()Lpl/Main;
    //   287: lconst_0
    //   288: lconst_1
    //   289: invokevirtual runTaskTimer : (Lorg/bukkit/plugin/Plugin;JJ)Lorg/bukkit/scheduler/BukkitTask;
    //   292: pop
    //   293: return
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ProjectileHitEvent paramProjectileHitEvent) {
    // Byte code:
    //   0: invokestatic getInstance : ()Lpl/Main;
    //   3: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   6: sipush #14164
    //   9: sipush #23029
    //   12: invokestatic a : (II)Ljava/lang/String;
    //   15: ldc2_w 12.0
    //   18: invokevirtual getDouble : (Ljava/lang/String;D)D
    //   21: dstore_2
    //   22: aload_1
    //   23: invokevirtual getEntity : ()Lorg/bukkit/entity/Projectile;
    //   26: astore #5
    //   28: aload #5
    //   30: instanceof org/bukkit/entity/Arrow
    //   33: ifeq -> 46
    //   36: aload #5
    //   38: checkcast org/bukkit/entity/Arrow
    //   41: astore #4
    //   43: goto -> 47
    //   46: return
    //   47: aload #4
    //   49: invokeinterface getShooter : ()Lorg/bukkit/projectiles/ProjectileSource;
    //   54: astore #6
    //   56: aload #6
    //   58: instanceof org/bukkit/entity/Player
    //   61: ifeq -> 74
    //   64: aload #6
    //   66: checkcast org/bukkit/entity/Player
    //   69: astore #5
    //   71: goto -> 75
    //   74: return
    //   75: aload_1
    //   76: invokevirtual getHitEntity : ()Lorg/bukkit/entity/Entity;
    //   79: astore #7
    //   81: aload #7
    //   83: instanceof org/bukkit/entity/LivingEntity
    //   86: ifeq -> 99
    //   89: aload #7
    //   91: checkcast org/bukkit/entity/LivingEntity
    //   94: astore #6
    //   96: goto -> 100
    //   99: return
    //   100: aload #4
    //   102: sipush #14173
    //   105: sipush #-4486
    //   108: invokestatic a : (II)Ljava/lang/String;
    //   111: invokeinterface hasMetadata : (Ljava/lang/String;)Z
    //   116: ifne -> 145
    //   119: aload #4
    //   121: sipush #14168
    //   124: sipush #13466
    //   127: invokestatic a : (II)Ljava/lang/String;
    //   130: invokeinterface hasMetadata : (Ljava/lang/String;)Z
    //   135: ifeq -> 197
    //   138: goto -> 145
    //   141: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   144: athrow
    //   145: aload #6
    //   147: dload_2
    //   148: aload #5
    //   150: invokeinterface damage : (DLorg/bukkit/entity/Entity;)V
    //   155: aload #4
    //   157: sipush #14169
    //   160: sipush #-14280
    //   163: invokestatic a : (II)Ljava/lang/String;
    //   166: invokeinterface hasMetadata : (Ljava/lang/String;)Z
    //   171: ifeq -> 197
    //   174: goto -> 181
    //   177: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   180: athrow
    //   181: aload #6
    //   183: bipush #80
    //   185: invokeinterface setFireTicks : (I)V
    //   190: goto -> 197
    //   193: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   196: athrow
    //   197: return
    // Exception table:
    //   from	to	target	type
    //   100	138	141	java/lang/MatchException
    //   119	174	177	java/lang/MatchException
    //   145	190	193	java/lang/MatchException
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    int i = Main.getInstance().getConfig().getInt(a(14166, -27015), -1);
    try {
      if (i != -1)
        try {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer) > i) {
            paramPlayer.sendMessage(a(14160, -28613) + a(14160, -28613));
            paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
            return;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    int j = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getInt(a(14161, 5935), 45);
    paramPlayer.setVelocity(paramPlayer.getLocation().getDirection().normalize().multiply(-0.5D));
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 1.0F, 0.0F);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_WARDEN_SONIC_BOOM, 1.0F, 1.0F);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), a(14163, -23570), j);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dm(this, paramPlayer)).runTaskLater((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 5L);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, a(14165, -32160), j, ChatColor.YELLOW);
    Location location = paramPlayer.getEyeLocation();
    Vector vector1 = location.getDirection().normalize();
    ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawnEntity(location.add(vector1.clone().multiply(0.5D)), EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(new ItemStack(Material.MAGMA_BLOCK));
    itemDisplay.setTransformation(new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new AxisAngle4f((float)Math.toRadians(90.0D), 1.0F, 0.0F, 0.0F), new Vector3f(0.75F, 0.75F, 0.75F), new AxisAngle4f(0.0F, 0.0F, 0.0F, 1.0F)));
    double d = Main.getInstance().getConfig().getInt(a(14167, 24888), 2);
    Vector vector2 = vector1.multiply(d);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dn(this, vector2, itemDisplay, paramPlayer)).runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 0L, 1L);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Player paramPlayer) {
    int i = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getInt(a(14170, 18712), 4);
    paramLocation = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, 10).clone().subtract(0.0D, (i / 2), 0.0D);
    paramLocation.getWorld().spawnParticle(Particle.FLAME, paramLocation, 150, 0.0D, 0.0D, 0.0D, 0.5D);
    double d = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getDouble(a(14174, 6361), 8.0D);
    boolean bool = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getBoolean(a(14162, -17653), false);
    paramLocation.getWorld().playSound(paramLocation, Sound.ENTITY_GENERIC_EXPLODE, 5.0F, 0.0F);
    World world = paramLocation.getWorld();
    try {
      if (world == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Set<Material> set = Set.of(Material.BEDROCK, Material.END_PORTAL, Material.END_PORTAL_FRAME, Material.BARRIER, Material.COMMAND_BLOCK, Material.END_GATEWAY);
    Random random = new Random();
    int j;
    for (j = -i; j <= i; j++) {
      for (int k = -i; k <= i; k++) {
        for (int m = -i; m <= i; m++) {
          Location location = paramLocation.clone().add(j, k, m);
          Block block = location.getBlock();
          try {
            if (!set.contains(block.getType()))
              try {
                if (k <= i - 1) {
                  double d1 = location.distance(paramLocation);
                  try {
                    if (d1 <= i)
                      try {
                        if (random.nextDouble() <= 0.8D)
                          try {
                            if (!bool)
                              block.setType(Material.LAVA); 
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
    for (j = -i; j <= i; j++) {
      for (int k = -i; k <= i; k++) {
        for (int m = -i; m <= i; m++) {
          Location location = paramLocation.clone().add(j, k, m);
          Block block = location.getBlock();
          try {
            if (!set.contains(block.getType()))
              try {
                if (location.distance(paramLocation) <= i)
                  try {
                    if (k <= i - 1)
                      try {
                        if (random.nextDouble() <= 0.6D)
                          try {
                            if (!bool) {
                              block.setType(Material.MAGMA_BLOCK);
                            } else {
                              You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(block.getLocation(), Material.MAGMA_BLOCK.createBlockData());
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
      } 
    } 
    for (j = -i; j <= i; j++) {
      for (int k = -i; k <= i; k++) {
        for (int m = -i; m <= i; m++) {
          Location location = paramLocation.clone().add(j, k, m);
          Block block = location.getBlock();
          try {
            if (!set.contains(block.getType()))
              try {
                if (location.distance(paramLocation) <= i)
                  try {
                    if (random.nextDouble() <= 0.4D)
                      try {
                        if (!bool)
                          block.setType(Material.FIRE); 
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
      } 
    } 
    for (Entity entity : world.getNearbyEntities(paramLocation, i, i, i)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity)entity;
        try {
          if (livingEntity == paramPlayer)
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        try {
          if (Main.isTrusted(paramPlayer, (Entity)livingEntity))
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity, d, paramPlayer);
      } 
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, BlockData paramBlockData) {
    BlockDisplay blockDisplay = (BlockDisplay)paramLocation.getWorld().spawnEntity(paramLocation, EntityType.BLOCK_DISPLAY);
    blockDisplay.setBlock(paramBlockData);
    Transformation transformation = blockDisplay.getTransformation();
    transformation.getScale().set(1.01D, 1.01D, 1.01D);
    blockDisplay.setTransformation(transformation);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764do(blockDisplay)).runTaskLater((Plugin)Main.getInstance(), 100L);
  }
  
  public static Location You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, int paramInt) {
    paramLocation = paramLocation.set(paramLocation.getX(), paramLocation.getBlock().getLocation().getY() + 0.5D, paramLocation.getZ());
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation))
        return paramLocation; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    for (byte b = 1; b <= paramInt; b++) {
      Location location1 = paramLocation.clone().add(0.0D, b, 0.0D);
      try {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location1))
          return location1; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      Location location2 = paramLocation.clone().add(0.0D, -b, 0.0D);
      try {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location2))
          return location2; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
    return paramLocation;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation) {
    try {
      if (paramLocation.getBlock().getType() != Material.WATER)
        try {
          if (paramLocation.getBlock().getType() != Material.LAVA) {
            try {
              if (paramLocation.getBlock().getType().isSolid()) {
                try {
                  if (!paramLocation.clone().add(0.0D, 1.0D, 0.0D).getBlock().getType().isSolid())
                    return true; 
                } catch (MatchException matchException) {
                  throw a(null);
                } 
                return false;
              } 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            return false;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!paramLocation.clone().add(0.0D, 1.0D, 0.0D).getBlock().getType().isSolid())
        return true; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return false;
  }
  
  private static void lambda$passiveArrows$2(Player paramPlayer, Vector paramVector1, Vector paramVector2, Entity paramEntity) {
    Arrow arrow = (Arrow)paramEntity;
    arrow.setRotation(paramPlayer.getYaw(), paramPlayer.getPitch());
    arrow.setVelocity(paramVector1.clone().multiply(3).add(paramVector2));
    arrow.setDamage(0.0D);
    arrow.setShooter((ProjectileSource)paramPlayer);
    arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
    arrow.setMetadata(a(14172, -23097), (MetadataValue)new FixedMetadataValue((Plugin)Main.getInstance(), paramPlayer.getUniqueId().toString()));
  }
  
  private static void lambda$passiveArrows$1(Player paramPlayer, Vector paramVector1, Vector paramVector2, Entity paramEntity) {
    Arrow arrow = (Arrow)paramEntity;
    arrow.setRotation(paramPlayer.getYaw(), paramPlayer.getPitch());
    arrow.setVelocity(paramVector1.clone().multiply(3).add(paramVector2));
    arrow.setDamage(0.0D);
    arrow.setShooter((ProjectileSource)paramPlayer);
    arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
    arrow.setMetadata(a(14172, -23097), (MetadataValue)new FixedMetadataValue((Plugin)Main.getInstance(), paramPlayer.getUniqueId().toString()));
  }
  
  private static void lambda$passiveArrows$0(Player paramPlayer, Vector paramVector1, Vector paramVector2, Entity paramEntity) {
    Arrow arrow = (Arrow)paramEntity;
    arrow.setRotation(paramPlayer.getYaw(), paramPlayer.getPitch());
    arrow.setVelocity(paramVector1.clone().multiply(3).add(paramVector2));
    arrow.setDamage(0.0D);
    arrow.setShooter((ProjectileSource)paramPlayer);
    arrow.setPierceLevel(3);
    arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
    arrow.setMetadata(a(14169, -14280), (MetadataValue)new FixedMetadataValue((Plugin)Main.getInstance(), paramPlayer.getUniqueId().toString()));
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  static {
    // Byte code:
    //   0: bipush #17
    //   2: anewarray java/lang/String
    //   5: astore #5
    //   7: iconst_0
    //   8: istore_3
    //   9: ldc 'seg±&ÆÂFÆV\\fÉ9.ò®çKb÷Ãç3{\ÈÛ?­³~FØ'V¿×£J7íl^\ê;®Eï&·¯C½2\\f©º(õµ> L\\fSç,õtãüÑ¸Í\6b£Õ!-[étèÎ5~è¼¹WôØY?©ü°\\f=ðÞRMMg\\tPÆØxÈÚ?* ?qbP£A{·àÜ\\fÔFå¤K1½úÐxÚÄk~nÝ\\b?¡¾Ö®U<jDi­ý7¤cGÂ|Ç ÀÍ\\tý2ó@SSÅÈðÌØ"­R{nbx¥û\\nñ¥¸°l¶í'
    //   11: dup
    //   12: astore_2
    //   13: invokevirtual length : ()I
    //   16: istore #4
    //   18: bipush #12
    //   20: istore_1
    //   21: iconst_m1
    //   22: istore_0
    //   23: bipush #88
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
    //   68: ldc 'ÓW.ØÞ\\f-MÒ®fq2ÕÞ>¸¢/^ Ë&2!µÒØÉ'
    //   70: dup
    //   71: astore_2
    //   72: invokevirtual length : ()I
    //   75: istore #4
    //   77: bipush #11
    //   79: istore_1
    //   80: iconst_m1
    //   81: istore_0
    //   82: bipush #45
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
    //   129: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad.a : [Ljava/lang/String;
    //   132: bipush #17
    //   134: anewarray java/lang/String
    //   137: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad.b : [Ljava/lang/String;
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
    //   212: bipush #89
    //   214: goto -> 244
    //   217: bipush #72
    //   219: goto -> 244
    //   222: bipush #51
    //   224: goto -> 244
    //   227: bipush #109
    //   229: goto -> 244
    //   232: bipush #92
    //   234: goto -> 244
    //   237: bipush #95
    //   239: goto -> 244
    //   242: bipush #9
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
    //   300: return
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0x3758) & 0xFFFF;
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
      byte b1 = 57;
      int j = (paramInt2 & 0xFF) - b1;
      if (j < 0)
        j += 256; 
      int k = ((paramInt2 & 0xFFFF) >>> 8) - b1;
      if (k < 0)
        k += 256; 
      for (byte b2 = 0; b2 < arrayOfChar.length; b2++) {
        int m = b2 % 2;
        if (m == 0) {
          arrayOfChar[b2] = (char)(arrayOfChar[b2] ^ j);
          j = ((j >>> 3 | j << 5) ^ arrayOfChar[b2]) & 0xFF;
        } else {
          arrayOfChar[b2] = (char)(arrayOfChar[b2] ^ k);
          k = ((k >>> 3 | k << 5) ^ arrayOfChar[b2]) & 0xFF;
        } 
      } 
      b[i] = (new String(arrayOfChar)).intern();
    } 
    return b[i];
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */