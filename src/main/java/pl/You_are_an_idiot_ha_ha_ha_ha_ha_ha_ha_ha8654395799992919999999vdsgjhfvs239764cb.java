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
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(paramPlayer1);
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
    BossBar keyedBossBar = Bukkit.createBossBar(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e, "§e§lCurrently Disguised as §a§l" + str, BarColor.YELLOW, BarStyle.SOLID, new org.bukkit.boss.BarFlag[0]);
    keyedBossBar.setProgress(1.0D);
    keyedBossBar.addPlayer(paramPlayer1);
    paramPlayer1.getWorld().playSound(paramPlayer1.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1.0F, 1.0F);
    paramPlayer1.sendTitle(String.valueOf(ChatColor.GREEN) + "Disguised as:", String.valueOf(ChatColor.GOLD) + str);
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
    double d = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramEntityType);
    UUID uuid = paramPlayer.getUniqueId();
    paramPlayer.getAttribute(Attribute.MAX_HEALTH).setBaseValue(d);
    paramPlayer.setHealth(d);
    double d2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramEntityType);
    paramPlayer.getAttribute(Attribute.SCALE).setBaseValue(d2);
    boolean b = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(paramEntityType);
    if (b) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.add(uuid);
      float f = paramEntityType == EntityType.WITHER ? 0.05F : 0.1F;
      paramPlayer.setFlySpeed(f);
      paramPlayer.setAllowFlight(true);
      Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> lambda$copyMobAttributes$0(paramPlayer, uuid), 5L);
    }
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
      paramPlayer.sendTitle("", String.valueOf(ChatColor.GREEN) + "You have been " + String.valueOf(ChatColor.RED) + "REVEALED" + String.valueOf(ChatColor.GREEN) + ".");
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
    char c = 1000;
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
    paramPlayer.setDisplayName(paramString);
    ProfileProperty profileProperty = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getPlayerProfile());
    if (profileProperty != null) {
      paramPlayer.getPersistentDataContainer().set(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f, PersistentDataType.STRING, profileProperty.getValue());
      paramPlayer.getPersistentDataContainer().set(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g, PersistentDataType.STRING, profileProperty.getSignature() != null ? profileProperty.getSignature() : "");
      paramPlayer.getPersistentDataContainer().set(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h, PersistentDataType.STRING, paramPlayer.getName());
    }
    Player player = Bukkit.getPlayerExact(paramString);
    if (player != null) {
      ProfileProperty profileProperty2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getPlayerProfile());
      if (profileProperty2 != null) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, player.getName(), profileProperty2);
        return;
      }
    }
    PlayerProfile playerProfile = Main.getInstance().getServer().createProfile(paramString);
    Main.getInstance().getServer().getScheduler().runTaskAsynchronously(Main.getInstance(), () -> lambda$disguiseIntoPlayer$2(playerProfile, paramString, paramPlayer));
  }

  private static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    if (paramPlayer == null || !paramPlayer.isOnline())
      return;
    PersistentDataContainer persistentDataContainer = paramPlayer.getPersistentDataContainer();
    String str1 = (String)persistentDataContainer.get(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f, PersistentDataType.STRING);
    String str2 = (String)persistentDataContainer.get(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g, PersistentDataType.STRING);
    String str3 = (String)persistentDataContainer.get(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h, PersistentDataType.STRING);
    {
      if (str3 == null || str3.isEmpty())
        str3 = paramPlayer.getName();
    }if (str1 == null || str1.isEmpty()) {
        persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f);
        persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g);
        persistentDataContainer.remove(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h);
        return;
      }
      try {
        ProfileProperty profileProperty = new ProfileProperty("textures", str1, (str2 == null || str2.isEmpty()) ? null : str2);
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
    Player player = paramPlayerRespawnEvent.getPlayer();
    UUID uuid = player.getUniqueId();
    Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> lambda$attributeReset$3(player, uuid), 3L);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerToggleFlightEvent paramPlayerToggleFlightEvent) {
    Player player = paramPlayerToggleFlightEvent.getPlayer();
    UUID uUID = player.getUniqueId();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.contains(uUID))
        return; 
    }GameMode gameMode = player.getGameMode();
    if (gameMode == GameMode.CREATIVE || gameMode == GameMode.SPECTATOR)
      return;
    if (!paramPlayerToggleFlightEvent.isFlying()) {
      player.setFlying(false);
    } else {
      player.setFlying(true);
      player.setVelocity(player.getVelocity().setY(0.5D));
    } 
  }
  
  public static double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityType paramEntityType) {
    return switch (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cc.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a[paramEntityType.ordinal()]) {
      case 1, 2, 3 -> 6.0D;
      case 4, 5, 6, 7, 8 -> 6.0D;
      case 9, 10 -> 6.0D;
      case 11, 12 -> 10.0D;
      case 13, 14, 15, 16 -> 20.0D;
      case 17, 18, 19 -> 20.0D;
      case 20, 21 -> 30.0D;
      case 22 -> 30.0D;
      case 23 -> 30.0D;
      default -> 20.0D;
    };
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
    return switch (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cc.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a[paramEntityType.ordinal()]) {
      case 1, 2, 3 -> 0.5D;
      case 5, 6, 7, 8 -> 0.5D;
      case 4, 9, 10, 12 -> 0.6D;
      case 11 -> 0.7D;
      case 13, 14, 15, 16 -> 1.0D;
      default -> 1.0D;
    };
  }
  
  private static void lambda$attributeReset$3(Player paramPlayer, UUID paramUUID) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(paramPlayer))
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(paramPlayer); 
    }paramPlayer.getAttribute(Attribute.MAX_HEALTH).setBaseValue(20.0D);
    paramPlayer.getAttribute(Attribute.SCALE).setBaseValue(1.0D);
    paramPlayer.setFlySpeed(0.1F);
    paramPlayer.setAllowFlight(false);
    paramPlayer.setFlying(false);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(paramUUID);
  }
  
  private static void lambda$disguiseIntoPlayer$2(PlayerProfile paramPlayerProfile, String paramString, Player paramPlayer) {
    try {
      paramPlayerProfile.complete(true);
    } catch (Exception e) {
    }
    ProfileProperty profileProperty = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayerProfile);
    String str = paramPlayerProfile.getName() != null ? paramPlayerProfile.getName() : paramString;
    Main.getInstance().getServer().getScheduler().runTask(Main.getInstance(), () -> lambda$disguiseIntoPlayer$1(paramPlayer, profileProperty, paramString, str));
  }
  
  private static void lambda$disguiseIntoPlayer$1(Player paramPlayer, ProfileProperty paramProfileProperty, String paramString1, String paramString2) {
    {
      if (!paramPlayer.isOnline())
        return; 
    }{
      if (paramProfileProperty == null) {
        paramPlayer.sendMessage(((TextComponent)Component.text("Couldn't find a player named " + paramString1 + ".").color((TextColor)NamedTextColor.RED)).decoration(TextDecoration.ITALIC, false));
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
    }if (paramPlayer.getGameMode() == GameMode.SURVIVAL || paramPlayer.getGameMode() == GameMode.ADVENTURE)
        paramPlayer.setVelocity(new Vector(0.0D, 0.5D, 0.0D));
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