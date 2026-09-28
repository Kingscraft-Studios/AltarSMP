package pl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab implements Listener {
  public Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public static NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  private static Map<UUID, UUID> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  private static final String[] a;
  
  private static final String[] b;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new NamespacedKey((Plugin)paramMain, a(-503, -12907));
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new NamespacedKey((Plugin)paramMain, a(-501, -9016));
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ItemStack paramItemStack) {
    try {
      if (paramItemStack.getType() != Material.NETHERITE_SWORD)
        return false; 
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
    try {
      if (!paramItemStack.hasItemMeta())
        return false; 
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
    ItemMeta itemMeta = paramItemStack.getItemMeta();
    try {
      if (itemMeta == null)
        return false; 
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
    try {
      if (!itemMeta.hasCustomModelData())
        return false; 
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
    try {
    
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
    return (itemMeta.getCustomModelData() == 2);
  }
  
  @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerDeathEvent paramPlayerDeathEvent) {
    Player player = paramPlayerDeathEvent.getEntity();
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player)) {
        paramPlayerDeathEvent.setCancelled(true);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
        (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764di(this, player)).runTaskLater((Plugin)Main.getInstance(), 2L);
      } 
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
  }
  
  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDeathEvent paramEntityDeathEvent) {
    LivingEntity livingEntity = paramEntityDeathEvent.getEntity();
    Player player = paramEntityDeathEvent.getEntity().getKiller();
    try {
      if (player == null)
        return; 
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
    ItemStack itemStack = player.getInventory().getItemInMainHand();
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack))
        return; 
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
    if (livingEntity instanceof Player) {
      Player player1 = (Player)livingEntity;
      ItemMeta itemMeta = itemStack.getItemMeta();
      try {
        if (itemMeta == null)
          return; 
      } catch (IllegalArgumentException illegalArgumentException) {
        throw a(null);
      } 
      PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
      persistentDataContainer.set(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, PersistentDataType.STRING, player1.getName());
      persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b);
      itemStack.setItemMeta(itemMeta);
      String str1 = player1.getName();
      String str2 = ChatColor.UNDERLINE.toString();
      String str3 = String.valueOf(ChatColor.RED);
      player.sendMessage(String.valueOf(ChatColor.DARK_RED) + String.valueOf(ChatColor.DARK_RED) + a(-507, -16480) + str3 + str2);
      player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.5F);
    } else {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, itemStack, livingEntity.getType());
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, ItemStack paramItemStack, EntityType paramEntityType) {
    ItemMeta itemMeta = paramItemStack.getItemMeta();
    try {
      if (itemMeta == null)
        return; 
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
    PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
    try {
      if (paramEntityType == EntityType.ENDER_DRAGON)
        return; 
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
    persistentDataContainer.set(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, PersistentDataType.STRING, paramEntityType.name());
    paramItemStack.setItemMeta(itemMeta);
    String str1 = paramEntityType.name();
    String str2 = ChatColor.UNDERLINE.toString();
    String str3 = String.valueOf(ChatColor.RED);
    paramPlayer.sendMessage(String.valueOf(ChatColor.DARK_RED) + String.valueOf(ChatColor.DARK_RED) + a(-500, 7210) + str3 + str2);
    paramPlayer.playSound((Entity)paramPlayer, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.2F);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractEvent paramPlayerInteractEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getPlayer : ()Lorg/bukkit/entity/Player;
    //   4: astore_2
    //   5: aload_1
    //   6: invokevirtual getItem : ()Lorg/bukkit/inventory/ItemStack;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnonnull -> 19
    //   14: return
    //   15: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   18: athrow
    //   19: aload_3
    //   20: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/inventory/ItemStack;)Z
    //   23: ifne -> 31
    //   26: return
    //   27: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   30: athrow
    //   31: aload_1
    //   32: invokevirtual getAction : ()Lorg/bukkit/event/block/Action;
    //   35: getstatic org/bukkit/event/block/Action.LEFT_CLICK_AIR : Lorg/bukkit/event/block/Action;
    //   38: if_acmpeq -> 58
    //   41: aload_1
    //   42: invokevirtual getAction : ()Lorg/bukkit/event/block/Action;
    //   45: getstatic org/bukkit/event/block/Action.LEFT_CLICK_BLOCK : Lorg/bukkit/event/block/Action;
    //   48: if_acmpne -> 122
    //   51: goto -> 58
    //   54: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   57: athrow
    //   58: aload_2
    //   59: invokeinterface isSneaking : ()Z
    //   64: ifeq -> 122
    //   67: goto -> 74
    //   70: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   73: athrow
    //   74: aload_2
    //   75: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)Z
    //   78: istore #4
    //   80: iload #4
    //   82: ifeq -> 119
    //   85: aload_2
    //   86: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)V
    //   89: aload_2
    //   90: invokeinterface getWorld : ()Lorg/bukkit/World;
    //   95: aload_2
    //   96: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   101: getstatic org/bukkit/Sound.ENTITY_ENDERMAN_TELEPORT : Lorg/bukkit/Sound;
    //   104: fconst_1
    //   105: ldc 0.8
    //   107: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   112: goto -> 119
    //   115: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   118: athrow
    //   119: goto -> 186
    //   122: aload_1
    //   123: invokevirtual getAction : ()Lorg/bukkit/event/block/Action;
    //   126: getstatic org/bukkit/event/block/Action.RIGHT_CLICK_AIR : Lorg/bukkit/event/block/Action;
    //   129: if_acmpeq -> 149
    //   132: aload_1
    //   133: invokevirtual getAction : ()Lorg/bukkit/event/block/Action;
    //   136: getstatic org/bukkit/event/block/Action.RIGHT_CLICK_BLOCK : Lorg/bukkit/event/block/Action;
    //   139: if_acmpne -> 186
    //   142: goto -> 149
    //   145: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   148: athrow
    //   149: aload_2
    //   150: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)Z
    //   153: ifeq -> 168
    //   156: goto -> 163
    //   159: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   162: athrow
    //   163: return
    //   164: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   167: athrow
    //   168: new pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dj
    //   171: dup
    //   172: aload_0
    //   173: aload_2
    //   174: invokespecial <init> : (Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab;Lorg/bukkit/entity/Player;)V
    //   177: invokestatic getInstance : ()Lpl/Main;
    //   180: lconst_0
    //   181: lconst_1
    //   182: invokevirtual runTaskTimer : (Lorg/bukkit/plugin/Plugin;JJ)Lorg/bukkit/scheduler/BukkitTask;
    //   185: pop
    //   186: return
    // Exception table:
    //   from	to	target	type
    //   10	15	15	java/lang/IllegalArgumentException
    //   19	27	27	java/lang/IllegalArgumentException
    //   31	51	54	java/lang/IllegalArgumentException
    //   41	67	70	java/lang/IllegalArgumentException
    //   80	112	115	java/lang/IllegalArgumentException
    //   122	142	145	java/lang/IllegalArgumentException
    //   132	156	159	java/lang/IllegalArgumentException
    //   149	164	164	java/lang/IllegalArgumentException
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerItemConsumeEvent paramPlayerItemConsumeEvent) {
    Player player = paramPlayerItemConsumeEvent.getPlayer();
    ItemMeta itemMeta = paramPlayerItemConsumeEvent.getItem().getItemMeta();
    PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayerItemConsumeEvent.getItem())) {
        try {
          paramPlayerItemConsumeEvent.setCancelled(true);
          (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dk(this, player)).runTaskLater((Plugin)Main.getInstance(), 1L);
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player)) {
            player.sendMessage(a(-512, 388));
            return;
          } 
        } catch (IllegalArgumentException illegalArgumentException) {
          throw a(null);
        } 
        boolean bool = Main.getInstance().getConfig().getBoolean(a(-499, 28702), false);
        if (bool) {
          ArrayList<EntityType> arrayList = new ArrayList();
          for (String str : Main.getInstance().getConfig().getStringList(a(-502, 1222))) {
            try {
              arrayList.add(EntityType.valueOf(str.toUpperCase()));
            } catch (IllegalArgumentException illegalArgumentException) {
              Main.getInstance().getLogger().warning(a(-504, 8769) + a(-504, 8769));
            } 
          } 
          int i = ThreadLocalRandom.current().nextInt(0, arrayList.size());
          EntityType entityType = arrayList.get(i);
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, entityType, (Player)null);
        } else {
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, persistentDataContainer);
        } 
      } 
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, PersistentDataContainer paramPersistentDataContainer) {
    if (paramPersistentDataContainer.has(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, PersistentDataType.STRING)) {
      String str = (String)paramPersistentDataContainer.get(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, PersistentDataType.STRING);
      try {
        if (str == null)
          return; 
      } catch (IllegalArgumentException illegalArgumentException) {
        throw a(null);
      } 
      Player player = Bukkit.getPlayer(str);
      try {
        if (player == null)
          return; 
      } catch (IllegalArgumentException illegalArgumentException) {
        throw a(null);
      } 
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, EntityType.PLAYER, player);
    } else if (paramPersistentDataContainer.has(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, PersistentDataType.STRING)) {
      String str = (String)paramPersistentDataContainer.get(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, PersistentDataType.STRING);
      EntityType entityType = EntityType.valueOf(str);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, entityType, (Player)null);
    } 
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.getPersistentDataContainer().remove(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c);
    itemMeta.getPersistentDataContainer().remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b);
    itemStack.setItemMeta(itemMeta);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    int i = Main.getInstance().getConfig().getInt(a(-508, 10949), 30);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), a(-506, -8226), i);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED), i, ChatColor.YELLOW);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageEvent paramEntityDamageEvent) {
    Player player;
    Entity entity = paramEntityDamageEvent.getEntity();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.containsKey(player.getUniqueId()))
        return; 
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
    try {
      if (paramEntityDamageEvent.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)
        paramEntityDamageEvent.setCancelled(true); 
    } catch (IllegalArgumentException illegalArgumentException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, EntityType paramEntityType) {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface getUniqueId : ()Ljava/util/UUID;
    //   6: sipush #-505
    //   9: sipush #10874
    //   12: invokestatic a : (II)Ljava/lang/String;
    //   15: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Ljava/util/UUID;Ljava/lang/String;)Z
    //   18: ifeq -> 26
    //   21: return
    //   22: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   25: athrow
    //   26: aload_0
    //   27: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)Z
    //   30: ifne -> 38
    //   33: return
    //   34: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   37: athrow
    //   38: aload_1
    //   39: ifnonnull -> 47
    //   42: return
    //   43: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   46: athrow
    //   47: iconst_1
    //   48: istore_2
    //   49: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ac.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : [I
    //   52: aload_1
    //   53: invokevirtual ordinal : ()I
    //   56: iaload
    //   57: tableswitch default -> 753, 1 -> 104, 2 -> 189, 3 -> 243, 4 -> 318, 5 -> 408, 6 -> 586, 7 -> 586, 8 -> 708
    //   104: aload_0
    //   105: iconst_1
    //   106: invokeinterface setInvulnerable : (Z)V
    //   111: aload_0
    //   112: invokeinterface getWorld : ()Lorg/bukkit/World;
    //   117: aload_0
    //   118: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   123: invokestatic getInstance : ()Lpl/Main;
    //   126: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   129: sipush #-498
    //   132: sipush #2092
    //   135: invokestatic a : (II)Ljava/lang/String;
    //   138: ldc2_w 3.0
    //   141: invokevirtual getDouble : (Ljava/lang/String;D)D
    //   144: d2f
    //   145: iconst_0
    //   146: iconst_0
    //   147: invokeinterface createExplosion : (Lorg/bukkit/Location;FZZ)Z
    //   152: pop
    //   153: aload_0
    //   154: invokeinterface getWorld : ()Lorg/bukkit/World;
    //   159: aload_0
    //   160: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   165: getstatic org/bukkit/Sound.ENTITY_CREEPER_PRIMED : Lorg/bukkit/Sound;
    //   168: fconst_1
    //   169: fconst_1
    //   170: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   175: aload_0
    //   176: iconst_0
    //   177: invokeinterface setInvulnerable : (Z)V
    //   182: goto -> 755
    //   185: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   188: athrow
    //   189: aload_0
    //   190: aconst_null
    //   191: bipush #30
    //   193: invokeinterface getTargetBlock : (Ljava/util/Set;I)Lorg/bukkit/block/Block;
    //   198: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   203: astore_3
    //   204: aload_0
    //   205: aload_3
    //   206: dconst_0
    //   207: dconst_1
    //   208: dconst_0
    //   209: invokevirtual add : (DDD)Lorg/bukkit/Location;
    //   212: invokeinterface teleport : (Lorg/bukkit/Location;)Z
    //   217: pop
    //   218: aload_0
    //   219: invokeinterface getWorld : ()Lorg/bukkit/World;
    //   224: aload_0
    //   225: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   230: getstatic org/bukkit/Sound.ENTITY_ENDERMAN_TELEPORT : Lorg/bukkit/Sound;
    //   233: fconst_1
    //   234: fconst_1
    //   235: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   240: goto -> 755
    //   243: aload_0
    //   244: ldc org/bukkit/entity/Fireball
    //   246: invokeinterface launchProjectile : (Ljava/lang/Class;)Lorg/bukkit/entity/Projectile;
    //   251: checkcast org/bukkit/entity/Fireball
    //   254: astore_3
    //   255: aload_3
    //   256: aload_0
    //   257: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   262: invokevirtual getDirection : ()Lorg/bukkit/util/Vector;
    //   265: invokestatic getInstance : ()Lpl/Main;
    //   268: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   271: sipush #-497
    //   274: bipush #-78
    //   276: invokestatic a : (II)Ljava/lang/String;
    //   279: ldc2_w 2.0
    //   282: invokevirtual getDouble : (Ljava/lang/String;D)D
    //   285: invokevirtual multiply : (D)Lorg/bukkit/util/Vector;
    //   288: invokeinterface setVelocity : (Lorg/bukkit/util/Vector;)V
    //   293: aload_0
    //   294: invokeinterface getWorld : ()Lorg/bukkit/World;
    //   299: aload_0
    //   300: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   305: getstatic org/bukkit/Sound.ENTITY_BLAZE_SHOOT : Lorg/bukkit/Sound;
    //   308: fconst_1
    //   309: fconst_1
    //   310: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   315: goto -> 755
    //   318: iconst_m1
    //   319: istore_3
    //   320: iload_3
    //   321: iconst_1
    //   322: if_icmpgt -> 383
    //   325: aload_0
    //   326: ldc org/bukkit/entity/WitherSkull
    //   328: invokeinterface launchProjectile : (Ljava/lang/Class;)Lorg/bukkit/entity/Projectile;
    //   333: checkcast org/bukkit/entity/WitherSkull
    //   336: astore #4
    //   338: aload #4
    //   340: fconst_2
    //   341: invokeinterface setYield : (F)V
    //   346: aload #4
    //   348: aload_0
    //   349: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   354: invokevirtual getDirection : ()Lorg/bukkit/util/Vector;
    //   357: iload_3
    //   358: bipush #15
    //   360: imul
    //   361: i2d
    //   362: invokestatic toRadians : (D)D
    //   365: invokevirtual rotateAroundY : (D)Lorg/bukkit/util/Vector;
    //   368: iconst_2
    //   369: invokevirtual multiply : (I)Lorg/bukkit/util/Vector;
    //   372: invokeinterface setVelocity : (Lorg/bukkit/util/Vector;)V
    //   377: iinc #3, 1
    //   380: goto -> 320
    //   383: aload_0
    //   384: invokeinterface getWorld : ()Lorg/bukkit/World;
    //   389: aload_0
    //   390: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   395: getstatic org/bukkit/Sound.ENTITY_WITHER_SHOOT : Lorg/bukkit/Sound;
    //   398: fconst_1
    //   399: fconst_1
    //   400: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   405: goto -> 755
    //   408: aload_0
    //   409: invokeinterface getEyeLocation : ()Lorg/bukkit/Location;
    //   414: astore_3
    //   415: aload_3
    //   416: invokevirtual getDirection : ()Lorg/bukkit/util/Vector;
    //   419: astore #4
    //   421: aconst_null
    //   422: astore #5
    //   424: dconst_0
    //   425: dstore #6
    //   427: dload #6
    //   429: ldc2_w 15.0
    //   432: dcmpg
    //   433: ifgt -> 503
    //   436: aload_3
    //   437: invokevirtual clone : ()Lorg/bukkit/Location;
    //   440: aload #4
    //   442: invokevirtual clone : ()Lorg/bukkit/util/Vector;
    //   445: dload #6
    //   447: invokevirtual multiply : (D)Lorg/bukkit/util/Vector;
    //   450: invokevirtual add : (Lorg/bukkit/util/Vector;)Lorg/bukkit/Location;
    //   453: astore #8
    //   455: aload #8
    //   457: invokevirtual getBlock : ()Lorg/bukkit/block/Block;
    //   460: invokeinterface getType : ()Lorg/bukkit/Material;
    //   465: invokevirtual isSolid : ()Z
    //   468: ifeq -> 492
    //   471: aload #8
    //   473: aload #4
    //   475: invokevirtual clone : ()Lorg/bukkit/util/Vector;
    //   478: ldc2_w 0.5
    //   481: invokevirtual multiply : (D)Lorg/bukkit/util/Vector;
    //   484: invokevirtual subtract : (Lorg/bukkit/util/Vector;)Lorg/bukkit/Location;
    //   487: astore #5
    //   489: goto -> 503
    //   492: dload #6
    //   494: ldc2_w 0.5
    //   497: dadd
    //   498: dstore #6
    //   500: goto -> 427
    //   503: aload #5
    //   505: ifnonnull -> 527
    //   508: aload_3
    //   509: invokevirtual clone : ()Lorg/bukkit/Location;
    //   512: aload #4
    //   514: invokevirtual clone : ()Lorg/bukkit/util/Vector;
    //   517: bipush #15
    //   519: invokevirtual multiply : (I)Lorg/bukkit/util/Vector;
    //   522: invokevirtual add : (Lorg/bukkit/util/Vector;)Lorg/bukkit/Location;
    //   525: astore #5
    //   527: aload #5
    //   529: astore #6
    //   531: aload_3
    //   532: aload #6
    //   534: invokevirtual distance : (Lorg/bukkit/Location;)D
    //   537: dstore #7
    //   539: aload_0
    //   540: invokeinterface getWorld : ()Lorg/bukkit/World;
    //   545: aload_3
    //   546: getstatic org/bukkit/Sound.ENTITY_WARDEN_SONIC_CHARGE : Lorg/bukkit/Sound;
    //   549: ldc 3.0
    //   551: fconst_1
    //   552: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   557: invokestatic getScheduler : ()Lorg/bukkit/scheduler/BukkitScheduler;
    //   560: invokestatic getInstance : ()Lpl/Main;
    //   563: aload_0
    //   564: aload_3
    //   565: dload #7
    //   567: aload #4
    //   569: <illegal opcode> run : (Lorg/bukkit/entity/Player;Lorg/bukkit/Location;DLorg/bukkit/util/Vector;)Ljava/lang/Runnable;
    //   574: ldc2_w 20
    //   577: invokeinterface runTaskLater : (Lorg/bukkit/plugin/Plugin;Ljava/lang/Runnable;J)Lorg/bukkit/scheduler/BukkitTask;
    //   582: pop
    //   583: goto -> 755
    //   586: aload_0
    //   587: ldc2_w 5.0
    //   590: ldc2_w 5.0
    //   593: ldc2_w 5.0
    //   596: invokeinterface getNearbyEntities : (DDD)Ljava/util/List;
    //   601: invokeinterface iterator : ()Ljava/util/Iterator;
    //   606: astore_3
    //   607: aload_3
    //   608: invokeinterface hasNext : ()Z
    //   613: ifeq -> 682
    //   616: aload_3
    //   617: invokeinterface next : ()Ljava/lang/Object;
    //   622: checkcast org/bukkit/entity/Entity
    //   625: astore #4
    //   627: aload #4
    //   629: instanceof org/bukkit/entity/LivingEntity
    //   632: ifeq -> 679
    //   635: aload #4
    //   637: aload_0
    //   638: if_acmpeq -> 679
    //   641: goto -> 648
    //   644: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   647: athrow
    //   648: aload #4
    //   650: checkcast org/bukkit/entity/LivingEntity
    //   653: new org/bukkit/potion/PotionEffect
    //   656: dup
    //   657: getstatic org/bukkit/potion/PotionEffectType.POISON : Lorg/bukkit/potion/PotionEffectType;
    //   660: bipush #100
    //   662: iconst_1
    //   663: invokespecial <init> : (Lorg/bukkit/potion/PotionEffectType;II)V
    //   666: invokeinterface addPotionEffect : (Lorg/bukkit/potion/PotionEffect;)Z
    //   671: pop
    //   672: goto -> 679
    //   675: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   678: athrow
    //   679: goto -> 607
    //   682: aload_0
    //   683: invokeinterface getWorld : ()Lorg/bukkit/World;
    //   688: aload_0
    //   689: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   694: getstatic org/bukkit/Sound.ENTITY_SPIDER_HURT : Lorg/bukkit/Sound;
    //   697: fconst_1
    //   698: ldc 0.8
    //   700: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   705: goto -> 755
    //   708: aload_0
    //   709: ldc org/bukkit/entity/Fireball
    //   711: invokeinterface launchProjectile : (Ljava/lang/Class;)Lorg/bukkit/entity/Projectile;
    //   716: checkcast org/bukkit/entity/Fireball
    //   719: astore_3
    //   720: aload_3
    //   721: ldc 3.0
    //   723: invokeinterface setYield : (F)V
    //   728: aload_0
    //   729: invokeinterface getWorld : ()Lorg/bukkit/World;
    //   734: aload_0
    //   735: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   740: getstatic org/bukkit/Sound.ENTITY_GHAST_SHOOT : Lorg/bukkit/Sound;
    //   743: fconst_1
    //   744: fconst_1
    //   745: invokeinterface playSound : (Lorg/bukkit/Location;Lorg/bukkit/Sound;FF)V
    //   750: goto -> 755
    //   753: iconst_0
    //   754: istore_2
    //   755: iload_2
    //   756: ifeq -> 770
    //   759: aload_0
    //   760: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)V
    //   763: goto -> 770
    //   766: invokestatic a : (Ljava/lang/IllegalArgumentException;)Ljava/lang/IllegalArgumentException;
    //   769: athrow
    //   770: return
    // Exception table:
    //   from	to	target	type
    //   0	22	22	java/lang/IllegalArgumentException
    //   26	34	34	java/lang/IllegalArgumentException
    //   38	43	43	java/lang/IllegalArgumentException
    //   49	185	185	java/lang/IllegalArgumentException
    //   627	641	644	java/lang/IllegalArgumentException
    //   635	672	675	java/lang/IllegalArgumentException
    //   755	763	766	java/lang/IllegalArgumentException
  }
  
  private static void lambda$useMobAbility$0(Player paramPlayer, Location paramLocation, double paramDouble, Vector paramVector) {
    paramPlayer.getWorld().playSound(paramLocation, Sound.ENTITY_WARDEN_SONIC_BOOM, 3.0F, 1.0F);
    double d1;
    for (d1 = 0.0D; d1 <= paramDouble; d1 += 0.3D) {
      Location location = paramLocation.clone().add(paramVector.clone().multiply(d1));
      paramPlayer.getWorld().spawnParticle(Particle.SONIC_BOOM, location, 1, 0.0D, 0.0D, 0.0D, 0.0D);
    } 
    HashSet<UUID> hashSet = new HashSet();
    double d2;
    for (d2 = 0.0D; d2 <= paramDouble; d2 += 0.5D) {
      Location location = paramLocation.clone().add(paramVector.clone().multiply(d2));
      for (Entity entity : location.getWorld().getNearbyEntities(location, 1.0D, 1.0D, 1.0D)) {
        try {
          if (entity instanceof LivingEntity)
            try {
              if (entity != paramPlayer && !hashSet.contains(entity.getUniqueId())) {
                LivingEntity livingEntity = (LivingEntity)entity;
                hashSet.add(entity.getUniqueId());
                livingEntity.setHealth(Math.max(0.0D, livingEntity.getHealth() - 10.0D));
                Vector vector = paramVector.clone().multiply(1.5D);
                vector.setY(0.4D);
                livingEntity.setVelocity(vector);
              } 
            } catch (IllegalArgumentException illegalArgumentException) {
              throw a(null);
            }  
        } catch (IllegalArgumentException illegalArgumentException) {
          throw a(null);
        } 
      } 
    } 
  }
  
  static {
    // Byte code:
    //   0: bipush #14
    //   2: anewarray java/lang/String
    //   5: astore #5
    //   7: iconst_0
    //   8: istore_3
    //   9: ldc 'Ý\\ndO¾í§=,¶Ì_Þ`(ÿZÄ\\tÞð|\\n5®Ô?Ïi£nðÍåf²þR¯Ê8Eö@²ö^*è]3µ®G ©ÈÎëæ\\r\myÈ ·¢wÃéÃèb» [o{\\n\\nà¢[ºÿx)~>>4aâÅÒZeOxlÅíu%UàÖÓÜ^\\rj³\\nÕ!oèïo&¿1\\nÂB4{Kjâoã¤­3¡ÜÛé¬ðx~ê#ë$ú± ¯æ ^b\\nC±oÏ[¹ì¯s\\n(ittb8\\fþ'
    //   11: dup
    //   12: astore_2
    //   13: invokevirtual length : ()I
    //   16: istore #4
    //   18: bipush #21
    //   20: istore_1
    //   21: iconst_m1
    //   22: istore_0
    //   23: bipush #17
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
    //   68: ldc 'ÅWßèÏ]I4(j­>µ²»¿½`¾(²Ýï\\r:1D°C¿Ñ¢;VÖ5'
    //   70: dup
    //   71: astore_2
    //   72: invokevirtual length : ()I
    //   75: istore #4
    //   77: bipush #16
    //   79: istore_1
    //   80: iconst_m1
    //   81: istore_0
    //   82: bipush #74
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
    //   129: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab.a : [Ljava/lang/String;
    //   132: bipush #14
    //   134: anewarray java/lang/String
    //   137: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab.b : [Ljava/lang/String;
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
    //   212: bipush #53
    //   214: goto -> 244
    //   217: bipush #117
    //   219: goto -> 244
    //   222: bipush #70
    //   224: goto -> 244
    //   227: bipush #7
    //   229: goto -> 244
    //   232: bipush #91
    //   234: goto -> 244
    //   237: bipush #101
    //   239: goto -> 244
    //   242: bipush #90
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
    //   300: new java/util/HashMap
    //   303: dup
    //   304: invokespecial <init> : ()V
    //   307: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d : Ljava/util/Map;
    //   310: return
  }
  
  private static IllegalArgumentException a(IllegalArgumentException paramIllegalArgumentException) {
    return paramIllegalArgumentException;
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0xFFFFFE0D) & 0xFFFF;
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
      byte b1 = 118;
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */