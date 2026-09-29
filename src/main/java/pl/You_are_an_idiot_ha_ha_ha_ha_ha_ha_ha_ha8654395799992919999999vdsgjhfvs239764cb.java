package pl;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import java.util.HashMap;
import java.util.HashSet;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb implements Listener {
  private static final Map<UUID, UUID> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  private static final Map<UUID, UUID> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  private static final Map<UUID, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  public static Set<UUID> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  static NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  private static final NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  private static final NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  private static final NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  
  
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer1, EntityType paramEntityType, Player paramPlayer2) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer1);
    Entity entity = null;
    String str = paramEntityType.toString().replace("_", " ");
    if (paramEntityType == EntityType.PLAYER) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer1, paramPlayer2.getName());
      str = paramPlayer2.getName();
    } else {
      entity = paramPlayer1.getWorld().spawnEntity(paramPlayer1.getLocation(), paramEntityType);
      ((LivingEntity)entity).setAI(false);
      for (Player player : Bukkit.getOnlinePlayers())
        player.hidePlayer((Plugin)Main.getInstance(), paramPlayer1); 
      paramPlayer1.hideEntity((Plugin)Main.getInstance(), entity);
      paramPlayer1.setInvisible(true);
    } 
    KeyedBossBar keyedBossBar = Bukkit.createBossBar(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e, "§e§lCurrently Disguised as §a§l" + "§e§lCurrently Disguised as §a§l", BarColor.YELLOW, BarStyle.SOLID, new org.bukkit.boss.BarFlag[0]);
    keyedBossBar.setProgress(1.0D);
    keyedBossBar.addPlayer(paramPlayer1);
    paramPlayer1.getWorld().playSound(paramPlayer1.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1.0F, 1.0F);
    paramPlayer1.sendTitle(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN), String.valueOf(ChatColor.GOLD) + String.valueOf(ChatColor.GOLD));
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer1);
    if (paramEntityType == EntityType.PLAYER) {
      BukkitTask bukkitTask = (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gs(paramPlayer1)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(paramPlayer1.getUniqueId(), paramPlayer2.getUniqueId());
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.put(paramPlayer1.getUniqueId(), new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm((Entity)paramPlayer1, bukkitTask, (BossBar)keyedBossBar));
    } else {
      Entity entity1 = entity;
      BukkitTask bukkitTask = (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gt(paramPlayer1, entity1)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.put(paramPlayer1.getUniqueId(), new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm(entity, bukkitTask, (BossBar)keyedBossBar));
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.put(entity.getUniqueId(), paramPlayer1.getUniqueId());
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer1, paramEntityType);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, EntityType paramEntityType) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/EntityType;)D
    //   4: dstore_2
    //   5: aload_0
    //   6: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   11: astore #4
    //   13: aload_0
    //   14: getstatic org/bukkit/attribute/Attribute.MAX_HEALTH : Lorg/bukkit/attribute/Attribute;
    //   17: invokeinterface getAttribute : (Lorg/bukkit/attribute/Attribute;)Lorg/bukkit/attribute/AttributeInstance;
    //   22: dload_2
    //   23: invokeinterface setBaseValue : (D)V
    //   28: aload_0
    //   29: dload_2
    //   30: invokeinterface setHealth : (D)V
    //   35: aload_1
    //   36: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : (Lorg/bukkit/entity/EntityType;)D
    //   39: dstore #5
    //   41: aload_0
    //   42: getstatic org/bukkit/attribute/Attribute.SCALE : Lorg/bukkit/attribute/Attribute;
    //   45: invokeinterface getAttribute : (Lorg/bukkit/attribute/Attribute;)Lorg/bukkit/attribute/AttributeInstance;
    //   50: dload #5
    //   52: invokeinterface setBaseValue : (D)V
    //   57: aload_1
    //   58: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/EntityType;)Z
    //   61: istore #7
    //   63: iload #7
    //   65: ifeq -> 144
    //   68: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d : Ljava/util/Set;
    //   71: aload #4
    //   73: invokeinterface add : (Ljava/lang/Object;)Z
    //   78: pop
    //   79: aload_1
    //   80: getstatic org/bukkit/entity/EntityType.WITHER : Lorg/bukkit/entity/EntityType;
    //   83: if_acmpne -> 102
    //   86: goto -> 93
    //   89: invokestatic a : (Ljava/lang/Exception;)Ljava/lang/Exception;
    //   92: athrow
    //   93: ldc 0.05
    //   95: goto -> 104
    //   98: invokestatic a : (Ljava/lang/Exception;)Ljava/lang/Exception;
    //   101: athrow
    //   102: ldc 0.1
    //   104: fstore #8
    //   106: aload_0
    //   107: fload #8
    //   109: invokeinterface setFlySpeed : (F)V
    //   114: aload_0
    //   115: iconst_1
    //   116: invokeinterface setAllowFlight : (Z)V
    //   121: invokestatic getScheduler : ()Lorg/bukkit/scheduler/BukkitScheduler;
    //   124: invokestatic getInstance : ()Lpl/Main;
    //   127: aload_0
    //   128: aload #4
    //   130: <illegal opcode> run : (Lorg/bukkit/entity/Player;Ljava/util/UUID;)Ljava/lang/Runnable;
    //   135: ldc2_w 5
    //   138: invokeinterface runTaskLater : (Lorg/bukkit/plugin/Plugin;Ljava/lang/Runnable;J)Lorg/bukkit/scheduler/BukkitTask;
    //   143: pop
    //   144: return
    // Exception table:
    //   from	to	target	type
    //   63	86	89	java/lang/MatchException
    //   68	98	98	java/lang/MatchException
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerChangedWorldEvent paramPlayerChangedWorldEvent) {
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gu(this, paramPlayerChangedWorldEvent)).runTaskLater((Plugin)Main.getInstance(), 2L);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    Entity entity1 = paramEntityDamageByEntityEvent.getDamager();
    if (entity1 instanceof Player) {
      player = (Player)entity1;
    } else {
      return;
    } 
    Entity entity2 = paramEntityDamageByEntityEvent.getEntity();
    if (entity2 instanceof LivingEntity) {
      LivingEntity livingEntity = (LivingEntity)entity2;
    } else {
      return;
    } 
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(player.getUniqueId()))
        return; 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.get(player.getUniqueId());
    {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm == null)
        return; 
    }{
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f() instanceof LivingEntity)
        ((LivingEntity)you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f()).swingMainHand(); 
    }}
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageEvent paramEntityDamageEvent) {
    Entity entity = paramEntityDamageEvent.getEntity();
    {
      if (entity instanceof Player)
        return; 
    }UUID uUID = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.get(entity.getUniqueId());
    {
      if (uUID == null)
        return; 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.get(uUID);
    {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm == null)
        return; 
    }Player player = Bukkit.getPlayer(uUID);
    {
      if (player == null)
        return; 
    }player.damage(paramEntityDamageEvent.getDamage(), paramEntityDamageEvent.getDamageSource());
    paramEntityDamageEvent.setDamage(0.0D);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(paramPlayer.getUniqueId());
    {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm == null)
        return; 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.remove(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f().getUniqueId());
    for (Player player : Bukkit.getOnlinePlayers())
      player.showPlayer((Plugin)Main.getInstance(), paramPlayer); 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer);
    paramPlayer.setInvisible(false);
    you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h().removePlayer(paramPlayer);
    UUID uUID = paramPlayer.getUniqueId();
    {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g() != null)
        you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g().cancel(); 
    }{
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f().getType() != EntityType.PLAYER)
        you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f().remove(); 
    }{
      paramPlayer.sendTitle("", String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + "You have been " + String.valueOf(ChatColor.RED) + "REVEALED" + String.valueOf(ChatColor.GREEN));
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
      paramPlayer.getAttribute(Attribute.MAX_HEALTH).setBaseValue(20.0D);
      paramPlayer.setHealth(20.0D);
      paramPlayer.getAttribute(Attribute.SCALE).setBaseValue(1.0D);
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.contains(uUID)) {
        paramPlayer.setFlying(false);
        paramPlayer.setAllowFlight(false);
        paramPlayer.setFlySpeed(0.1F);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(uUID);
      } 
    }}
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.5F);
    double d = 1.5D;
    char c = 'Ϩ';
    for (byte b = 0; b < c; b++) {
      double d1 = Math.random() * 2.0D * Math.PI;
      double d2 = Math.acos(2.0D * Math.random() - 1.0D);
      double d3 = d * Math.sin(d2) * Math.cos(d1);
      double d4 = d * Math.sin(d2) * Math.sin(d1);
      double d5 = d * Math.cos(d2);
      paramPlayer.getWorld().spawnParticle(Particle.DUST, paramPlayer.getLocation().add(d3, d4 + 1.0D, d5), 1, new Particle.DustOptions(Color.fromRGB(0, 0, 0), 1.0F));
    } 
  }
  
  @EventHandler
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerJoinEvent paramPlayerJoinEvent) {
    Player player = paramPlayerJoinEvent.getPlayer();
    for (Player player1 : Bukkit.getOnlinePlayers()) {
      {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(player1.getUniqueId()))
          player.hidePlayer((Plugin)Main.getInstance(), player1); 
      }} 
  }
  
  public static EntityType You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.get(paramPlayer.getUniqueId());
    {
    
    }return (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm == null) ? null : you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f().getType();
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(Player paramPlayer) {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(paramPlayer.getUniqueId());
  }
  
  private static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokeinterface setDisplayName : (Ljava/lang/String;)V
    //   7: aload_0
    //   8: invokeinterface getPlayerProfile : ()Lcom/destroystokyo/paper/profile/PlayerProfile;
    //   13: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lcom/destroystokyo/paper/profile/PlayerProfile;)Lcom/destroystokyo/paper/profile/ProfileProperty;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull -> 109
    //   21: aload_0
    //   22: invokeinterface getPersistentDataContainer : ()Lorg/bukkit/persistence/PersistentDataContainer;
    //   27: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f : Lorg/bukkit/NamespacedKey;
    //   30: getstatic org/bukkit/persistence/PersistentDataType.STRING : Lorg/bukkit/persistence/PersistentDataType;
    //   33: aload_2
    //   34: invokevirtual getValue : ()Ljava/lang/String;
    //   37: invokeinterface set : (Lorg/bukkit/NamespacedKey;Lorg/bukkit/persistence/PersistentDataType;Ljava/lang/Object;)V
    //   42: aload_0
    //   43: invokeinterface getPersistentDataContainer : ()Lorg/bukkit/persistence/PersistentDataContainer;
    //   48: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g : Lorg/bukkit/NamespacedKey;
    //   51: getstatic org/bukkit/persistence/PersistentDataType.STRING : Lorg/bukkit/persistence/PersistentDataType;
    //   54: aload_2
    //   55: invokevirtual getSignature : ()Ljava/lang/String;
    //   58: ifnonnull -> 77
    //   61: goto -> 68
    //   64: invokestatic a : (Ljava/lang/Exception;)Ljava/lang/Exception;
    //   67: athrow
    //   68: ldc ''
    //   70: goto -> 81
    //   73: invokestatic a : (Ljava/lang/Exception;)Ljava/lang/Exception;
    //   76: athrow
    //   77: aload_2
    //   78: invokevirtual getSignature : ()Ljava/lang/String;
    //   81: invokeinterface set : (Lorg/bukkit/NamespacedKey;Lorg/bukkit/persistence/PersistentDataType;Ljava/lang/Object;)V
    //   86: aload_0
    //   87: invokeinterface getPersistentDataContainer : ()Lorg/bukkit/persistence/PersistentDataContainer;
    //   92: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h : Lorg/bukkit/NamespacedKey;
    //   95: getstatic org/bukkit/persistence/PersistentDataType.STRING : Lorg/bukkit/persistence/PersistentDataType;
    //   98: aload_0
    //   99: invokeinterface getName : ()Ljava/lang/String;
    //   104: invokeinterface set : (Lorg/bukkit/NamespacedKey;Lorg/bukkit/persistence/PersistentDataType;Ljava/lang/Object;)V
    //   109: aload_1
    //   110: invokestatic getPlayerExact : (Ljava/lang/String;)Lorg/bukkit/entity/Player;
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull -> 151
    //   118: aload_3
    //   119: invokeinterface getPlayerProfile : ()Lcom/destroystokyo/paper/profile/PlayerProfile;
    //   124: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lcom/destroystokyo/paper/profile/PlayerProfile;)Lcom/destroystokyo/paper/profile/ProfileProperty;
    //   127: astore #4
    //   129: aload #4
    //   131: ifnull -> 151
    //   134: aload_0
    //   135: aload_3
    //   136: invokeinterface getName : ()Ljava/lang/String;
    //   141: aload #4
    //   143: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;Ljava/lang/String;Lcom/destroystokyo/paper/profile/ProfileProperty;)V
    //   146: return
    //   147: invokestatic a : (Ljava/lang/Exception;)Ljava/lang/Exception;
    //   150: athrow
    //   151: invokestatic getInstance : ()Lpl/Main;
    //   154: invokevirtual getServer : ()Lorg/bukkit/Server;
    //   157: aload_1
    //   158: invokeinterface createProfile : (Ljava/lang/String;)Lcom/destroystokyo/paper/profile/PlayerProfile;
    //   163: astore #4
    //   165: invokestatic getInstance : ()Lpl/Main;
    //   168: invokevirtual getServer : ()Lorg/bukkit/Server;
    //   171: invokeinterface getScheduler : ()Lorg/bukkit/scheduler/BukkitScheduler;
    //   176: invokestatic getInstance : ()Lpl/Main;
    //   179: aload #4
    //   181: aload_1
    //   182: aload_0
    //   183: <illegal opcode> run : (Lcom/destroystokyo/paper/profile/PlayerProfile;Ljava/lang/String;Lorg/bukkit/entity/Player;)Ljava/lang/Runnable;
    //   188: invokeinterface runTaskAsynchronously : (Lorg/bukkit/plugin/Plugin;Ljava/lang/Runnable;)Lorg/bukkit/scheduler/BukkitTask;
    //   193: pop
    //   194: return
    // Exception table:
    //   from	to	target	type
    //   17	61	64	java/lang/MatchException
    //   21	73	73	java/lang/MatchException
    //   129	147	147	java/lang/MatchException
  }
  
  private static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    {
      if (paramPlayer != null) {
        {
          if (!paramPlayer.isOnline())
            return; 
        }} else {
        return;
      } 
    }PersistentDataContainer persistentDataContainer = paramPlayer.getPersistentDataContainer();
    String str1 = (String)persistentDataContainer.get(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f, PersistentDataType.STRING);
    String str2 = (String)persistentDataContainer.get(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g, PersistentDataType.STRING);
    String str3 = (String)persistentDataContainer.get(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h, PersistentDataType.STRING);
    {
      if (str3 == null || str3.isEmpty())
        str3 = paramPlayer.getName(); 
    }{
      if (str1 != null)
        {
          if (!str1.isEmpty()) {
            try {
              {
              
              }ProfileProperty profileProperty = new ProfileProperty("textures", str1, (str2 == null || str2.isEmpty()) ? null : str2);
              PlayerProfile playerProfile = Main.getInstance().getServer().createProfile(paramPlayer.getUniqueId(), str3);
              if (playerProfile == null)
                return; 
              playerProfile.clearProperties();
              playerProfile.setProperty(profileProperty);
              playerProfile.setName(str3);
              paramPlayer.setPlayerProfile(playerProfile);
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
            persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f);
            persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g);
            persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h);
            for (Player player : Bukkit.getOnlinePlayers()) {
              {
                if (!player.isOnline())
                  continue; 
              }player.hidePlayer((Plugin)Main.getInstance(), paramPlayer);
              player.showPlayer((Plugin)Main.getInstance(), paramPlayer);
            } 
            return;
          } 
          persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f);
          persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g);
          persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h);
          return;
        }}persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f);
    persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g);
    persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h);
  }
  
  private static ProfileProperty You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerProfile paramPlayerProfile) {
    for (ProfileProperty profileProperty : paramPlayerProfile.getProperties()) {
      {
        if ("textures".equals(profileProperty.getName()))
          return profileProperty; 
      }} 
    return null;
  }
  
  private static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, String paramString, ProfileProperty paramProfileProperty) {
    PlayerProfile playerProfile = Main.getInstance().getServer().createProfile(paramPlayer.getUniqueId(), paramString);
    {
      if (playerProfile == null)
        return; 
    }playerProfile.clearProperties();
    playerProfile.setProperty(paramProfileProperty);
    playerProfile.setName(paramString);
    paramPlayer.setPlayerProfile(playerProfile);
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.hidePlayer((Plugin)Main.getInstance(), paramPlayer);
      player.showPlayer((Plugin)Main.getInstance(), paramPlayer);
    } 
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerRespawnEvent paramPlayerRespawnEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getPlayer : ()Lorg/bukkit/entity/Player;
    //   4: astore_2
    //   5: aload_2
    //   6: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   11: astore_3
    //   12: invokestatic getScheduler : ()Lorg/bukkit/scheduler/BukkitScheduler;
    //   15: invokestatic getInstance : ()Lpl/Main;
    //   18: aload_2
    //   19: aload_3
    //   20: <illegal opcode> run : (Lorg/bukkit/entity/Player;Ljava/util/UUID;)Ljava/lang/Runnable;
    //   25: ldc2_w 3
    //   28: invokeinterface runTaskLater : (Lorg/bukkit/plugin/Plugin;Ljava/lang/Runnable;J)Lorg/bukkit/scheduler/BukkitTask;
    //   33: pop
    //   34: return
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerToggleFlightEvent paramPlayerToggleFlightEvent) {
    Player player = paramPlayerToggleFlightEvent.getPlayer();
    UUID uUID = player.getUniqueId();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.contains(uUID))
        return; 
    }GameMode gameMode = player.getGameMode();
    {
      if (gameMode != GameMode.CREATIVE)
        {
          if (gameMode != GameMode.SPECTATOR) {
            {
              if (!paramPlayerToggleFlightEvent.isFlying()) {
                player.setFlying(false);
              } else {
                player.setFlying(true);
                player.setVelocity(player.getVelocity().setY(0.5D));
              } 
            }return;
          } 
          return;
        }}}
  
  public static double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityType paramEntityType) {
    {
      switch (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cc.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a[paramEntityType.ordinal()]) {
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
        
      } 
    }return 20.0D;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(EntityType paramEntityType) {
    if (paramEntityType != EntityType.BAT) {
      if (paramEntityType != EntityType.PARROT) {
        if (paramEntityType != EntityType.BEE) {
          if (paramEntityType != EntityType.PHANTOM) {
            if (paramEntityType != EntityType.GHAST) {
              if (paramEntityType != EntityType.BLAZE) {
                if (paramEntityType != EntityType.VEX) {
                  if (paramEntityType != EntityType.ALLAY) {
                    if (paramEntityType != EntityType.WITHER) {
                      return false;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return true;
  }
  
  public static double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(EntityType paramEntityType) {
    {
      switch (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cc.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a[paramEntityType.ordinal()]) {
        case 1:
        case 2:
        case 3:
        
        case 4:
        case 9:
        case 10:
        case 12:
        
        case 11:
        
        case 5:
        case 6:
        case 7:
        case 8:
        
        case 13:
        case 14:
        case 15:
        case 16:
        
      } 
    }return 1.0D;
  }
  
  private static void lambda$attributeReset$3(Player paramPlayer, UUID paramUUID) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(paramPlayer))
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer); 
    }paramPlayer.getAttribute(Attribute.MAX_HEALTH).setBaseValue(20.0D);
    paramPlayer.getAttribute(Attribute.SCALE).setBaseValue(1.0D);
    paramPlayer.setFlySpeed(0.1F);
    paramPlayer.setAllowFlight(false);
    paramPlayer.setFlying(false);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(paramUUID);
  }
  
  private static void lambda$disguiseIntoPlayer$2(PlayerProfile paramPlayerProfile, String paramString, Player paramPlayer) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokeinterface complete : (Z)Z
    //   7: pop
    //   8: goto -> 12
    //   11: astore_3
    //   12: aload_0
    //   13: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lcom/destroystokyo/paper/profile/PlayerProfile;)Lcom/destroystokyo/paper/profile/ProfileProperty;
    //   16: astore_3
    //   17: aload_0
    //   18: invokeinterface getName : ()Ljava/lang/String;
    //   23: ifnull -> 39
    //   26: aload_0
    //   27: invokeinterface getName : ()Ljava/lang/String;
    //   32: goto -> 40
    //   35: invokestatic a : (Ljava/lang/Exception;)Ljava/lang/Exception;
    //   38: athrow
    //   39: aload_1
    //   40: astore #4
    //   42: invokestatic getInstance : ()Lpl/Main;
    //   45: invokevirtual getServer : ()Lorg/bukkit/Server;
    //   48: invokeinterface getScheduler : ()Lorg/bukkit/scheduler/BukkitScheduler;
    //   53: invokestatic getInstance : ()Lpl/Main;
    //   56: aload_2
    //   57: aload_3
    //   58: aload_1
    //   59: aload #4
    //   61: <illegal opcode> run : (Lorg/bukkit/entity/Player;Lcom/destroystokyo/paper/profile/ProfileProperty;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Runnable;
    //   66: invokeinterface runTask : (Lorg/bukkit/plugin/Plugin;Ljava/lang/Runnable;)Lorg/bukkit/scheduler/BukkitTask;
    //   71: pop
    //   72: return
    // Exception table:
    //   from	to	target	type
    //   0	8	11	java/lang/Exception
    //   17	35	35	java/lang/Exception
  }
  
  private static void lambda$disguiseIntoPlayer$1(Player paramPlayer, ProfileProperty paramProfileProperty, String paramString1, String paramString2) {
    {
      if (!paramPlayer.isOnline())
        return; 
    }{
      if (paramProfileProperty == null) {
        paramPlayer.sendMessage(((TextComponent)Component.text("Couldn't find a player named " + "Couldn't find a player named " + paramString1).color((TextColor)NamedTextColor.RED)).decoration(TextDecoration.ITALIC, false));
        return;
      } 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, paramString2, paramProfileProperty);
  }
  
  private static void lambda$copyMobAttributes$0(Player paramPlayer, UUID paramUUID) {
    {
      if (paramPlayer.isOnline()) {
        {
          if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.contains(paramUUID))
            return; 
        }} else {
        return;
      } 
    }{
      if (paramPlayer.getGameMode() != GameMode.SURVIVAL) {
        {
          if (paramPlayer.getGameMode() == GameMode.ADVENTURE) {
            paramPlayer.setVelocity(new Vector(0.0D, 0.5D, 0.0D));
            return;
          } 
        }return;
      } 
    }paramPlayer.setVelocity(new Vector(0.0D, 0.5D, 0.0D));
  }

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = new HashMap<>();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new HashMap<>();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new HashMap<>();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = new HashSet<>();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = new NamespacedKey("doomdisguise", "altarsmp");
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = new NamespacedKey(Main.getInstance(), "real_skin_value");
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = new NamespacedKey(Main.getInstance(), "real_skin_signature");
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = new NamespacedKey(Main.getInstance(), "real_old_name");
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */