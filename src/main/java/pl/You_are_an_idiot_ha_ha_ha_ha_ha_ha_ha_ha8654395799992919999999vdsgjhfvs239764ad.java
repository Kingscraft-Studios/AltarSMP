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
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    {
      if (itemStack.getType() != Material.CROSSBOW)
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
    int i = Main.getInstance().getConfig().getInt("legendaryLimit", -1);
    {
      if (i != -1)
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer) > i) {
            paramPlayer.sendMessage("§eThe legendary limit is " + "§eThe legendary limit is ");
            paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
            return;
          } 
        }}int j = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getInt("vulcansWrathCooldown", 45);
    paramPlayer.setVelocity(paramPlayer.getLocation().getDirection().normalize().multiply(-0.5D));
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 1.0F, 0.0F);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_WARDEN_SONIC_BOOM, 1.0F, 1.0F);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), "vulcan_powershot", j);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dm(this, paramPlayer)).runTaskLater((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 5L);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "Vulcan's Wrath", j, ChatColor.YELLOW);
    Location location = paramPlayer.getEyeLocation();
    Vector vector1 = location.getDirection().normalize();
    ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawnEntity(location.add(vector1.clone().multiply(0.5D)), EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(new ItemStack(Material.MAGMA_BLOCK));
    itemDisplay.setTransformation(new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new AxisAngle4f((float)Math.toRadians(90.0D), 1.0F, 0.0F, 0.0F), new Vector3f(0.75F, 0.75F, 0.75F), new AxisAngle4f(0.0F, 0.0F, 0.0F, 1.0F)));
    double d = Main.getInstance().getConfig().getInt("vulcanPower", 2);
    Vector vector2 = vector1.multiply(d);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dn(this, vector2, itemDisplay, paramPlayer)).runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 0L, 1L);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Player paramPlayer) {
    int i = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getInt("vulcanExplosionRadius", 4);
    paramLocation = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, 10).clone().subtract(0.0D, (i / 2), 0.0D);
    paramLocation.getWorld().spawnParticle(Particle.FLAME, paramLocation, 150, 0.0D, 0.0D, 0.0D, 0.5D);
    double d = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getDouble("vulcansWrathDamage", 8.0D);
    boolean bool = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getBoolean("vulcanWrathVisual", false);
    paramLocation.getWorld().playSound(paramLocation, Sound.ENTITY_GENERIC_EXPLODE, 5.0F, 0.0F);
    World world = paramLocation.getWorld();
    {
      if (world == null)
        return; 
    }Set<Material> set = Set.of(Material.BEDROCK, Material.END_PORTAL, Material.END_PORTAL_FRAME, Material.BARRIER, Material.COMMAND_BLOCK, Material.END_GATEWAY);
    Random random = new Random();
    int j;
    for (j = -i; j <= i; j++) {
      for (int k = -i; k <= i; k++) {
        for (int m = -i; m <= i; m++) {
          Location location = paramLocation.clone().add(j, k, m);
          Block block = location.getBlock();
          {
            if (!set.contains(block.getType()))
              {
                if (k <= i - 1) {
                  double d1 = location.distance(paramLocation);
                  {
                    if (d1 <= i)
                      {
                        if (random.nextDouble() <= 0.8D)
                          {
                            if (!bool)
                              block.setType(Material.LAVA); 
                          }}}} 
              }}} 
      } 
    } 
    for (j = -i; j <= i; j++) {
      for (int k = -i; k <= i; k++) {
        for (int m = -i; m <= i; m++) {
          Location location = paramLocation.clone().add(j, k, m);
          Block block = location.getBlock();
          {
            if (!set.contains(block.getType()))
              {
                if (location.distance(paramLocation) <= i)
                  {
                    if (k <= i - 1)
                      {
                        if (random.nextDouble() <= 0.6D)
                          {
                            if (!bool) {
                              block.setType(Material.MAGMA_BLOCK);
                            } else {
                              You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(block.getLocation(), Material.MAGMA_BLOCK.createBlockData());
                            } 
                          }}}}}} 
      } 
    } 
    for (j = -i; j <= i; j++) {
      for (int k = -i; k <= i; k++) {
        for (int m = -i; m <= i; m++) {
          Location location = paramLocation.clone().add(j, k, m);
          Block block = location.getBlock();
          {
            if (!set.contains(block.getType()))
              {
                if (location.distance(paramLocation) <= i)
                  {
                    if (random.nextDouble() <= 0.4D)
                      {
                        if (!bool)
                          block.setType(Material.FIRE); 
                      }}}}} 
      } 
    } 
    for (Entity entity : world.getNearbyEntities(paramLocation, i, i, i)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity)entity;
        {
          if (livingEntity == paramPlayer)
            continue; 
        }{
          if (Main.isTrusted(paramPlayer, (Entity)livingEntity))
            continue; 
        }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity, d, paramPlayer);
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
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation))
        return paramLocation; 
    }for (byte b = 1; b <= paramInt; b++) {
      Location location1 = paramLocation.clone().add(0.0D, b, 0.0D);
      {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location1))
          return location1; 
      }Location location2 = paramLocation.clone().add(0.0D, -b, 0.0D);
      {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location2))
          return location2; 
      }} 
    return paramLocation;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation) {
    {
      if (paramLocation.getBlock().getType() != Material.WATER)
        {
          if (paramLocation.getBlock().getType() != Material.LAVA) {
            {
              if (paramLocation.getBlock().getType().isSolid()) {
                {
                  if (!paramLocation.clone().add(0.0D, 1.0D, 0.0D).getBlock().getType().isSolid())
                    return true; 
                }return false;
              } 
            }return false;
          } 
        }}{
      if (!paramLocation.clone().add(0.0D, 1.0D, 0.0D).getBlock().getType().isSolid())
        return true; 
    }return false;
  }
  
  private static void lambda$passiveArrows$2(Player paramPlayer, Vector paramVector1, Vector paramVector2, Entity paramEntity) {
    Arrow arrow = (Arrow)paramEntity;
    arrow.setRotation(paramPlayer.getYaw(), paramPlayer.getPitch());
    arrow.setVelocity(paramVector1.clone().multiply(3).add(paramVector2));
    arrow.setDamage(0.0D);
    arrow.setShooter((ProjectileSource)paramPlayer);
    arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
    arrow.setMetadata("passive_side", (MetadataValue)new FixedMetadataValue((Plugin)Main.getInstance(), paramPlayer.getUniqueId().toString()));
  }
  
  private static void lambda$passiveArrows$1(Player paramPlayer, Vector paramVector1, Vector paramVector2, Entity paramEntity) {
    Arrow arrow = (Arrow)paramEntity;
    arrow.setRotation(paramPlayer.getYaw(), paramPlayer.getPitch());
    arrow.setVelocity(paramVector1.clone().multiply(3).add(paramVector2));
    arrow.setDamage(0.0D);
    arrow.setShooter((ProjectileSource)paramPlayer);
    arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
    arrow.setMetadata("passive_side", (MetadataValue)new FixedMetadataValue((Plugin)Main.getInstance(), paramPlayer.getUniqueId().toString()));
  }
  
  private static void lambda$passiveArrows$0(Player paramPlayer, Vector paramVector1, Vector paramVector2, Entity paramEntity) {
    Arrow arrow = (Arrow)paramEntity;
    arrow.setRotation(paramPlayer.getYaw(), paramPlayer.getPitch());
    arrow.setVelocity(paramVector1.clone().multiply(3).add(paramVector2));
    arrow.setDamage(0.0D);
    arrow.setShooter((ProjectileSource)paramPlayer);
    arrow.setPierceLevel(3);
    arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
    arrow.setMetadata("passive_main", (MetadataValue)new FixedMetadataValue((Plugin)Main.getInstance(), paramPlayer.getUniqueId().toString()));
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */