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

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb implements Listener {
  private static final Map<UUID, UUID> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  private static final Map<UUID, UUID> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  private static final Map<UUID, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  public static Set<UUID> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  static NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  private static final NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  private static final NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  private static final NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  
  private static final String[] a;
  
  private static final String[] b;
  
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
    KeyedBossBar keyedBossBar = Bukkit.createBossBar(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e, a(17541, 7489) + a(17541, 7489), BarColor.YELLOW, BarStyle.SOLID, new org.bukkit.boss.BarFlag[0]);
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
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(player.getUniqueId()))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.get(player.getUniqueId());
    try {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f() instanceof LivingEntity)
        ((LivingEntity)you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f()).swingMainHand(); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageEvent paramEntityDamageEvent) {
    Entity entity = paramEntityDamageEvent.getEntity();
    try {
      if (entity instanceof Player)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    UUID uUID = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.get(entity.getUniqueId());
    try {
      if (uUID == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.get(uUID);
    try {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Player player = Bukkit.getPlayer(uUID);
    try {
      if (player == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    player.damage(paramEntityDamageEvent.getDamage(), paramEntityDamageEvent.getDamageSource());
    paramEntityDamageEvent.setDamage(0.0D);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(paramPlayer.getUniqueId());
    try {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.remove(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f().getUniqueId());
    for (Player player : Bukkit.getOnlinePlayers())
      player.showPlayer((Plugin)Main.getInstance(), paramPlayer); 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer);
    paramPlayer.setInvisible(false);
    you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h().removePlayer(paramPlayer);
    UUID uUID = paramPlayer.getUniqueId();
    try {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g() != null)
        you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g().cancel(); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f().getType() != EntityType.PLAYER)
        you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f().remove(); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      a(17537, -5954);
      paramPlayer.sendTitle("", String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + a(17537, -5954) + String.valueOf(ChatColor.RED) + a(17550, -30677) + String.valueOf(ChatColor.GREEN));
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
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
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
      try {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(player1.getUniqueId()))
          player.hidePlayer((Plugin)Main.getInstance(), player1); 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
  }
  
  public static EntityType You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.get(paramPlayer.getUniqueId());
    try {
    
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm == null) ? null : you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cm.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f().getType();
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
    try {
      if (paramPlayer != null) {
        try {
          if (!paramPlayer.isOnline())
            return; 
        } catch (Exception exception) {
          throw a(null);
        } 
      } else {
        return;
      } 
    } catch (Exception exception) {
      throw a(null);
    } 
    PersistentDataContainer persistentDataContainer = paramPlayer.getPersistentDataContainer();
    String str1 = (String)persistentDataContainer.get(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f, PersistentDataType.STRING);
    String str2 = (String)persistentDataContainer.get(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g, PersistentDataType.STRING);
    String str3 = (String)persistentDataContainer.get(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h, PersistentDataType.STRING);
    try {
      if (str3 == null || str3.isEmpty())
        str3 = paramPlayer.getName(); 
    } catch (Exception exception) {
      throw a(null);
    } 
    try {
      if (str1 != null)
        try {
          if (!str1.isEmpty()) {
            try {
              try {
              
              } catch (Exception exception) {
                throw a(null);
              } 
              ProfileProperty profileProperty = new ProfileProperty(a(17549, 6873), str1, (str2 == null || str2.isEmpty()) ? null : str2);
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
              try {
                if (!player.isOnline())
                  continue; 
              } catch (Exception exception) {
                throw a(null);
              } 
              player.hidePlayer((Plugin)Main.getInstance(), paramPlayer);
              player.showPlayer((Plugin)Main.getInstance(), paramPlayer);
            } 
            return;
          } 
          persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f);
          persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g);
          persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h);
          return;
        } catch (Exception exception) {
          throw a(null);
        }  
    } catch (Exception exception) {
      throw a(null);
    } 
    persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f);
    persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g);
    persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h);
  }
  
  private static ProfileProperty You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerProfile paramPlayerProfile) {
    for (ProfileProperty profileProperty : paramPlayerProfile.getProperties()) {
      try {
        if (a(17536, 25674).equals(profileProperty.getName()))
          return profileProperty; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
    return null;
  }
  
  private static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, String paramString, ProfileProperty paramProfileProperty) {
    PlayerProfile playerProfile = Main.getInstance().getServer().createProfile(paramPlayer.getUniqueId(), paramString);
    try {
      if (playerProfile == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    playerProfile.clearProperties();
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
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.contains(uUID))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    GameMode gameMode = player.getGameMode();
    try {
      if (gameMode != GameMode.CREATIVE)
        try {
          if (gameMode != GameMode.SPECTATOR) {
            try {
              if (!paramPlayerToggleFlightEvent.isFlying()) {
                player.setFlying(false);
              } else {
                player.setFlying(true);
                player.setVelocity(player.getVelocity().setY(0.5D));
              } 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            return;
          } 
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityType paramEntityType) {
    try {
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
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return 20.0D;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(EntityType paramEntityType) {
    try {
      if (paramEntityType != EntityType.BAT)
        try {
          if (paramEntityType != EntityType.PARROT)
            try {
              if (paramEntityType != EntityType.BEE)
                try {
                  if (paramEntityType != EntityType.PHANTOM)
                    try {
                      if (paramEntityType != EntityType.GHAST)
                        try {
                          if (paramEntityType != EntityType.BLAZE)
                            try {
                              if (paramEntityType != EntityType.VEX)
                                try {
                                  if (paramEntityType != EntityType.ALLAY) {
                                    try {
                                      if (paramEntityType == EntityType.WITHER);
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
  
  public static double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(EntityType paramEntityType) {
    try {
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
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return 1.0D;
  }
  
  private static void lambda$attributeReset$3(Player paramPlayer, UUID paramUUID) {
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(paramPlayer))
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramPlayer.getAttribute(Attribute.MAX_HEALTH).setBaseValue(20.0D);
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
    try {
      if (!paramPlayer.isOnline())
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramProfileProperty == null) {
        paramPlayer.sendMessage(((TextComponent)Component.text(a(17548, 3187) + a(17548, 3187) + paramString1).color((TextColor)NamedTextColor.RED)).decoration(TextDecoration.ITALIC, false));
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, paramString2, paramProfileProperty);
  }
  
  private static void lambda$copyMobAttributes$0(Player paramPlayer, UUID paramUUID) {
    try {
      if (paramPlayer.isOnline()) {
        try {
          if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.contains(paramUUID))
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
      if (paramPlayer.getGameMode() != GameMode.SURVIVAL) {
        try {
          if (paramPlayer.getGameMode() == GameMode.ADVENTURE) {
            paramPlayer.setVelocity(new Vector(0.0D, 0.5D, 0.0D));
            return;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramPlayer.setVelocity(new Vector(0.0D, 0.5D, 0.0D));
  }
  
  static {
    // Byte code:
    //   0: bipush #12
    //   2: anewarray java/lang/String
    //   5: astore #5
    //   7: iconst_0
    //   8: istore_3
    //   9: ldc 'Ó~tp¾®d^MÛgáDKlç8q7âÞ6*Éºýá_Ip`\\rëiÿÙ ×Mmtóî\\faªm\\n\\n¼Hí\\b&=®Sû~õ:¥&¤¸=ìpï+aK¼ö<hNWÕrÚ<~áÉé:\\t3úR5Où`Ê#`ì£¸*¶ß%ÕÖíc½óè*ç°0$1\\by¤þ'Y«º'
    //   11: dup
    //   12: astore_2
    //   13: invokevirtual length : ()I
    //   16: istore #4
    //   18: bipush #8
    //   20: istore_1
    //   21: iconst_m1
    //   22: istore_0
    //   23: bipush #11
    //   25: iinc #0, 1
    //   28: aload_2
    //   29: iload_0
    //   30: dup
    //   31: iload_1
    //   32: iadd
    //   33: invokevirtual substring : (II)Ljava/lang/String;
    //   36: iconst_m1
    //   37: goto -> 142
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
    //   68: ldc '\ëìÆÜë*\\rm#Ì¯÷2(«Pû'
    //   70: dup
    //   71: astore_2
    //   72: invokevirtual length : ()I
    //   75: istore #4
    //   77: bipush #8
    //   79: istore_1
    //   80: iconst_m1
    //   81: istore_0
    //   82: iconst_4
    //   83: iinc #0, 1
    //   86: aload_2
    //   87: iload_0
    //   88: dup
    //   89: iload_1
    //   90: iadd
    //   91: invokevirtual substring : (II)Ljava/lang/String;
    //   94: iconst_0
    //   95: goto -> 142
    //   98: aload #5
    //   100: swap
    //   101: iload_3
    //   102: iinc #3, 1
    //   105: swap
    //   106: aastore
    //   107: iload_0
    //   108: iload_1
    //   109: iadd
    //   110: dup
    //   111: istore_0
    //   112: iload #4
    //   114: if_icmpge -> 126
    //   117: aload_2
    //   118: iload_0
    //   119: invokevirtual charAt : (I)C
    //   122: istore_1
    //   123: goto -> 82
    //   126: aload #5
    //   128: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.a : [Ljava/lang/String;
    //   131: bipush #12
    //   133: anewarray java/lang/String
    //   136: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.b : [Ljava/lang/String;
    //   139: goto -> 300
    //   142: dup_x2
    //   143: pop
    //   144: invokevirtual toCharArray : ()[C
    //   147: dup_x1
    //   148: arraylength
    //   149: dup_x2
    //   150: pop
    //   151: iconst_0
    //   152: istore #6
    //   154: dup2_x1
    //   155: pop2
    //   156: dup_x2
    //   157: iconst_1
    //   158: if_icmpgt -> 260
    //   161: dup2
    //   162: swap
    //   163: iload #6
    //   165: dup2_x1
    //   166: caload
    //   167: swap
    //   168: iload #6
    //   170: bipush #7
    //   172: irem
    //   173: tableswitch default -> 242, 0 -> 212, 1 -> 217, 2 -> 222, 3 -> 227, 4 -> 232, 5 -> 237
    //   212: bipush #112
    //   214: goto -> 244
    //   217: bipush #125
    //   219: goto -> 244
    //   222: bipush #89
    //   224: goto -> 244
    //   227: bipush #18
    //   229: goto -> 244
    //   232: bipush #118
    //   234: goto -> 244
    //   237: bipush #38
    //   239: goto -> 244
    //   242: bipush #85
    //   244: ixor
    //   245: ixor
    //   246: i2c
    //   247: castore
    //   248: iinc #6, 1
    //   251: dup
    //   252: ifne -> 260
    //   255: dup2
    //   256: dup_x1
    //   257: goto -> 165
    //   260: dup2_x1
    //   261: pop2
    //   262: dup_x2
    //   263: iload #6
    //   265: if_icmpgt -> 161
    //   268: pop
    //   269: new java/lang/String
    //   272: dup_x1
    //   273: swap
    //   274: invokespecial <init> : ([C)V
    //   277: invokevirtual intern : ()Ljava/lang/String;
    //   280: swap
    //   281: pop
    //   282: swap
    //   283: tableswitch default -> 40, 0 -> 98
    //   300: new java/util/HashMap
    //   303: dup
    //   304: invokespecial <init> : ()V
    //   307: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Ljava/util/Map;
    //   310: new java/util/HashMap
    //   313: dup
    //   314: invokespecial <init> : ()V
    //   317: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : Ljava/util/Map;
    //   320: new java/util/HashMap
    //   323: dup
    //   324: invokespecial <init> : ()V
    //   327: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : Ljava/util/Map;
    //   330: new java/util/HashSet
    //   333: dup
    //   334: invokespecial <init> : ()V
    //   337: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d : Ljava/util/Set;
    //   340: new org/bukkit/NamespacedKey
    //   343: dup
    //   344: sipush #17543
    //   347: sipush #-18301
    //   350: invokestatic a : (II)Ljava/lang/String;
    //   353: sipush #17540
    //   356: sipush #-20105
    //   359: invokestatic a : (II)Ljava/lang/String;
    //   362: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   365: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : Lorg/bukkit/NamespacedKey;
    //   368: new org/bukkit/NamespacedKey
    //   371: dup
    //   372: invokestatic getInstance : ()Lpl/Main;
    //   375: sipush #17538
    //   378: sipush #-30959
    //   381: invokestatic a : (II)Ljava/lang/String;
    //   384: invokespecial <init> : (Lorg/bukkit/plugin/Plugin;Ljava/lang/String;)V
    //   387: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f : Lorg/bukkit/NamespacedKey;
    //   390: new org/bukkit/NamespacedKey
    //   393: dup
    //   394: invokestatic getInstance : ()Lpl/Main;
    //   397: sipush #17539
    //   400: sipush #-2704
    //   403: invokestatic a : (II)Ljava/lang/String;
    //   406: invokespecial <init> : (Lorg/bukkit/plugin/Plugin;Ljava/lang/String;)V
    //   409: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g : Lorg/bukkit/NamespacedKey;
    //   412: new org/bukkit/NamespacedKey
    //   415: dup
    //   416: invokestatic getInstance : ()Lpl/Main;
    //   419: sipush #17551
    //   422: sipush #1490
    //   425: invokestatic a : (II)Ljava/lang/String;
    //   428: invokespecial <init> : (Lorg/bukkit/plugin/Plugin;Ljava/lang/String;)V
    //   431: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h : Lorg/bukkit/NamespacedKey;
    //   434: return
  }
  
  private static Exception a(Exception paramException) {
    return paramException;
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0x4484) & 0xFFFF;
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
      byte b1 = 40;
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */