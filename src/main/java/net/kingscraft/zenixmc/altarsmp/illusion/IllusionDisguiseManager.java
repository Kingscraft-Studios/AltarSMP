package net.kingscraft.zenixmc.altarsmp.illusion;

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
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.armor.netherite.NetheriteSwordCooldownTask;
import net.kingscraft.zenixmc.altarsmp.core.mapping.EntityTypeSwitchMappings;

public class IllusionDisguiseManager implements Listener {
  public static final Map<UUID, UUID> disguisedEntityOwners;

  public static final Map<UUID, UUID> disguisedPlayerTargets;

  public static final Map<UUID, DisguiseEntityTask> activeDisguises;

  public static Set<UUID> flyingDisguisePlayers;

  public static NamespacedKey DISGUISE_BOSS_BAR_KEY;

  public static final NamespacedKey REAL_SKIN_VALUE_KEY;

  public static final NamespacedKey REAL_SKIN_SIGNATURE_KEY;

  public static final NamespacedKey REAL_OLD_NAME_KEY;

  public static void disguisePlayer(Player paramPlayer1, EntityType paramEntityType, Player paramPlayer2) {
    revealPlayer(paramPlayer1);
    Entity entity = null;
    String str = paramEntityType.toString().replace("_", " ");
    if (paramEntityType == EntityType.PLAYER) {
      disguiseIntoPlayer(paramPlayer1, paramPlayer2.getName());
      str = paramPlayer2.getName();
    } else {
      entity = paramPlayer1.getWorld().spawnEntity(paramPlayer1.getLocation(), paramEntityType);
      ((LivingEntity)entity).setAI(false);
      for (Player player : Bukkit.getOnlinePlayers())
        player.hidePlayer((Plugin)AltarSMP.getInstance(), paramPlayer1); 
      paramPlayer1.hideEntity((Plugin)AltarSMP.getInstance(), entity);
      paramPlayer1.setInvisible(true);
    } 
    BossBar keyedBossBar = Bukkit.createBossBar(DISGUISE_BOSS_BAR_KEY, "§e§lCurrently Disguised as §a§l" + str, BarColor.YELLOW, BarStyle.SOLID, new org.bukkit.boss.BarFlag[0]);
    keyedBossBar.setProgress(1.0D);
    keyedBossBar.addPlayer(paramPlayer1);
    paramPlayer1.getWorld().playSound(paramPlayer1.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1.0F, 1.0F);
    paramPlayer1.sendTitle(String.valueOf(ChatColor.GREEN) + "Disguised as:", String.valueOf(ChatColor.GOLD) + str);
    spawnRevealParticles(paramPlayer1);
    if (paramEntityType == EntityType.PLAYER) {
      BukkitTask bukkitTask = (new NetheriteSwordCooldownTask(paramPlayer1)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
      disguisedPlayerTargets.put(paramPlayer1.getUniqueId(), paramPlayer2.getUniqueId());
      activeDisguises.put(paramPlayer1.getUniqueId(), new DisguiseEntityTask((Entity)paramPlayer1, bukkitTask, (BossBar)keyedBossBar));
    } else {
      Entity entity1 = entity;
      BukkitTask bukkitTask = (new DisguiseFollowTask(paramPlayer1, entity1)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
      activeDisguises.put(paramPlayer1.getUniqueId(), new DisguiseEntityTask(entity, bukkitTask, (BossBar)keyedBossBar));
      disguisedEntityOwners.put(entity.getUniqueId(), paramPlayer1.getUniqueId());
      copyMobAttributes(paramPlayer1, paramEntityType);
    } 
  }

  public static void copyMobAttributes(Player paramPlayer, EntityType paramEntityType) {
    double d = getMobMaxHealth(paramEntityType);
    UUID uuid = paramPlayer.getUniqueId();
    paramPlayer.getAttribute(Attribute.MAX_HEALTH).setBaseValue(d);
    paramPlayer.setHealth(d);
    double d2 = getMobScale(paramEntityType);
    paramPlayer.getAttribute(Attribute.SCALE).setBaseValue(d2);
    boolean b = canMobFly(paramEntityType);
    if (b) {
      flyingDisguisePlayers.add(uuid);
      float f = paramEntityType == EntityType.WITHER ? 0.05F : 0.1F;
      paramPlayer.setFlySpeed(f);
      paramPlayer.setAllowFlight(true);
      Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> applyFlightBoost(paramPlayer, uuid), 5L);
    }
  }

  @EventHandler
  public void onPlayerChangedWorld(PlayerChangedWorldEvent paramPlayerChangedWorldEvent) {
    (new DisguiseWorldChangeTask(paramPlayerChangedWorldEvent)).runTaskLater((Plugin)AltarSMP.getInstance(), 2L);
  }

  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
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
      if (disguisedPlayerTargets.containsKey(player.getUniqueId()))
        return; 
    }
    DisguiseEntityTask disguiseEntityTask = activeDisguises.get(player.getUniqueId());
    {
      if (disguiseEntityTask == null)
        return; 
    }{
      if (disguiseEntityTask.entity() instanceof LivingEntity)
        ((LivingEntity)disguiseEntityTask.entity()).swingMainHand();
    }}

  @EventHandler
  public void onEntityDamage(EntityDamageEvent paramEntityDamageEvent) {
    Entity entity = paramEntityDamageEvent.getEntity();
    {
      if (entity instanceof Player)
        return; 
    }UUID uUID = disguisedEntityOwners.get(entity.getUniqueId());
    {
      if (uUID == null)
        return; 
    }
    DisguiseEntityTask disguiseEntityTask = activeDisguises.get(uUID);
    {
      if (disguiseEntityTask == null)
        return; 
    }Player player = Bukkit.getPlayer(uUID);
    {
      if (player == null)
        return; 
    }player.damage(paramEntityDamageEvent.getDamage(), paramEntityDamageEvent.getDamageSource());
    paramEntityDamageEvent.setDamage(0.0D);
  }

  public static void revealPlayer(Player paramPlayer) {
    DisguiseEntityTask disguiseEntityTask = activeDisguises.remove(paramPlayer.getUniqueId());
    {
      if (disguiseEntityTask == null)
        return; 
    }
    disguisedEntityOwners.remove(disguiseEntityTask.entity().getUniqueId());
    for (Player player : Bukkit.getOnlinePlayers())
      player.showPlayer((Plugin)AltarSMP.getInstance(), paramPlayer); 
    restorePlayerProfile(paramPlayer);
    paramPlayer.setInvisible(false);
    disguiseEntityTask.bossBar().removePlayer(paramPlayer);
    UUID uUID = paramPlayer.getUniqueId();
    {
      if (disguiseEntityTask.task() != null)
        disguiseEntityTask.task().cancel();
    }{
      if (disguiseEntityTask.entity().getType() != EntityType.PLAYER)
        disguiseEntityTask.entity().remove();
    }{
      paramPlayer.sendTitle("", String.valueOf(ChatColor.GREEN) + "You have been " + String.valueOf(ChatColor.RED) + "REVEALED" + String.valueOf(ChatColor.GREEN) + ".");
      spawnRevealParticles(paramPlayer);
      paramPlayer.getAttribute(Attribute.MAX_HEALTH).setBaseValue(20.0D);
      paramPlayer.setHealth(20.0D);
      paramPlayer.getAttribute(Attribute.SCALE).setBaseValue(1.0D);
      if (flyingDisguisePlayers.contains(uUID)) {
        paramPlayer.setFlying(false);
        paramPlayer.setAllowFlight(false);
        paramPlayer.setFlySpeed(0.1F);
        flyingDisguisePlayers.remove(uUID);
      } 
    }}

  public static void spawnRevealParticles(Player paramPlayer) {
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.5F);
    double d = 1.5D;
    int c = 1000;
    for (int b = 0; b < c; b++) {
      double d1 = Math.random() * 2.0D * Math.PI;
      double d2 = Math.acos(2.0D * Math.random() - 1.0D);
      double d3 = d * Math.sin(d2) * Math.cos(d1);
      double d4 = d * Math.sin(d2) * Math.sin(d1);
      double d5 = d * Math.cos(d2);
      paramPlayer.getWorld().spawnParticle(Particle.DUST, paramPlayer.getLocation().add(d3, d4 + 1.0D, d5), 1, new Particle.DustOptions(Color.fromRGB(0, 0, 0), 1.0F));
    } 
  }

  @EventHandler
  public static void onPlayerJoin(PlayerJoinEvent paramPlayerJoinEvent) {
    Player player = paramPlayerJoinEvent.getPlayer();
    for (Player player1 : Bukkit.getOnlinePlayers()) {
      {
        if (activeDisguises.containsKey(player1.getUniqueId()))
          player.hidePlayer((Plugin)AltarSMP.getInstance(), player1); 
      }} 
  }

  public static EntityType getDisguisedEntityType(Player paramPlayer) {
    DisguiseEntityTask disguiseEntityTask = activeDisguises.get(paramPlayer.getUniqueId());
    {

    }return (disguiseEntityTask == null) ? null : disguiseEntityTask.entity().getType();
  }

  public static boolean isDisguised(Player paramPlayer) {
    return activeDisguises.containsKey(paramPlayer.getUniqueId());
  }

  public static void disguiseIntoPlayer(Player paramPlayer, String paramString) {
    paramPlayer.setDisplayName(paramString);
    ProfileProperty profileProperty = getTextureProperty(paramPlayer.getPlayerProfile());
    if (profileProperty != null) {
      paramPlayer.getPersistentDataContainer().set(REAL_SKIN_VALUE_KEY, PersistentDataType.STRING, profileProperty.getValue());
      paramPlayer.getPersistentDataContainer().set(REAL_SKIN_SIGNATURE_KEY, PersistentDataType.STRING, profileProperty.getSignature() != null ? profileProperty.getSignature() : "");
      paramPlayer.getPersistentDataContainer().set(REAL_OLD_NAME_KEY, PersistentDataType.STRING, paramPlayer.getName());
    }
    Player player = Bukkit.getPlayerExact(paramString);
    if (player != null) {
      ProfileProperty profileProperty2 = getTextureProperty(player.getPlayerProfile());
      if (profileProperty2 != null) {
        applyPlayerProfile(paramPlayer, player.getName(), profileProperty2);
        return;
      }
    }
    PlayerProfile playerProfile = AltarSMP.getInstance().getServer().createProfile(paramString);
    AltarSMP.getInstance().getServer().getScheduler().runTaskAsynchronously(AltarSMP.getInstance(), () -> completePlayerProfileLookup(playerProfile, paramString, paramPlayer));
  }

  public static void restorePlayerProfile(Player paramPlayer) {
    if (paramPlayer == null || !paramPlayer.isOnline())
      return;
    PersistentDataContainer persistentDataContainer = paramPlayer.getPersistentDataContainer();
    String str1 = (String)persistentDataContainer.get(REAL_SKIN_VALUE_KEY, PersistentDataType.STRING);
    String str2 = (String)persistentDataContainer.get(REAL_SKIN_SIGNATURE_KEY, PersistentDataType.STRING);
    String str3 = (String)persistentDataContainer.get(REAL_OLD_NAME_KEY, PersistentDataType.STRING);
    {
      if (str3 == null || str3.isEmpty())
        str3 = paramPlayer.getName();
    }if (str1 == null || str1.isEmpty()) {
        persistentDataContainer.remove(REAL_SKIN_VALUE_KEY);
        persistentDataContainer.remove(REAL_SKIN_SIGNATURE_KEY);
        persistentDataContainer.remove(REAL_OLD_NAME_KEY);
        return;
      }
      try {
        ProfileProperty profileProperty = new ProfileProperty("textures", str1, (str2 == null || str2.isEmpty()) ? null : str2);
        PlayerProfile playerProfile = AltarSMP.getInstance().getServer().createProfile(paramPlayer.getUniqueId(), str3);

        if (playerProfile == null)
          return;
        playerProfile.clearProperties();
        playerProfile.setProperty(profileProperty);
        paramPlayer.setPlayerProfile(playerProfile);
      } catch (Exception exception) {
        exception.printStackTrace();
      }
      persistentDataContainer.remove(REAL_SKIN_VALUE_KEY);
      persistentDataContainer.remove(REAL_SKIN_SIGNATURE_KEY);
      persistentDataContainer.remove(REAL_OLD_NAME_KEY);
      for (Player player : Bukkit.getOnlinePlayers()) {
        {
          if (!player.isOnline())
            continue;
        }
        player.hidePlayer((Plugin)AltarSMP.getInstance(), paramPlayer);
        player.showPlayer((Plugin)AltarSMP.getInstance(), paramPlayer);
      } 
  }

  public static ProfileProperty getTextureProperty(PlayerProfile paramPlayerProfile) {
    for (ProfileProperty profileProperty : paramPlayerProfile.getProperties()) {
      {
        if ("textures".equals(profileProperty.getName()))
          return profileProperty; 
      }} 
    return null;
  }

  public static void applyPlayerProfile(Player paramPlayer, String paramString, ProfileProperty paramProfileProperty) {
    PlayerProfile playerProfile = AltarSMP.getInstance().getServer()
            .createProfile(paramPlayer.getUniqueId(), paramString);

    if (playerProfile == null)
      return;

    playerProfile.clearProperties();
    playerProfile.setProperty(paramProfileProperty);
    paramPlayer.setPlayerProfile(playerProfile);
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.hidePlayer((Plugin)AltarSMP.getInstance(), paramPlayer);
      player.showPlayer((Plugin)AltarSMP.getInstance(), paramPlayer);
    } 
  }

  @EventHandler
  public void onPlayerRespawn(PlayerRespawnEvent paramPlayerRespawnEvent) {
    Player player = paramPlayerRespawnEvent.getPlayer();
    UUID uuid = player.getUniqueId();
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> resetPlayerAttributes(player, uuid), 3L);
  }

  @EventHandler
  public void onPlayerToggleFlight(PlayerToggleFlightEvent paramPlayerToggleFlightEvent) {
    Player player = paramPlayerToggleFlightEvent.getPlayer();
    UUID uUID = player.getUniqueId();
    {
      if (!flyingDisguisePlayers.contains(uUID))
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

  public static double getMobMaxHealth(EntityType paramEntityType) {
    return switch (EntityTypeSwitchMappings.ENTITY_TYPE_MAPPING[paramEntityType.ordinal()]) {
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

  public static boolean canMobFly(EntityType paramEntityType) {
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

  public static double getMobScale(EntityType paramEntityType) {
    return switch (EntityTypeSwitchMappings.ENTITY_TYPE_MAPPING[paramEntityType.ordinal()]) {
      case 1, 2, 3 -> 0.5D;
      case 5, 6, 7, 8 -> 0.5D;
      case 4, 9, 10, 12 -> 0.6D;
      case 11 -> 0.7D;
      case 13, 14, 15, 16 -> 1.0D;
      default -> 1.0D;
    };
  }

  public static void resetPlayerAttributes(Player paramPlayer, UUID paramUUID) {
    {
      if (isDisguised(paramPlayer))
        revealPlayer(paramPlayer);
    }paramPlayer.getAttribute(Attribute.MAX_HEALTH).setBaseValue(20.0D);
    paramPlayer.getAttribute(Attribute.SCALE).setBaseValue(1.0D);
    paramPlayer.setFlySpeed(0.1F);
    paramPlayer.setAllowFlight(false);
    paramPlayer.setFlying(false);
    flyingDisguisePlayers.remove(paramUUID);
  }

  public static void completePlayerProfileLookup(PlayerProfile paramPlayerProfile, String paramString, Player paramPlayer) {
    try {
      paramPlayerProfile.complete(true);
    } catch (Exception e) {
    }
    ProfileProperty profileProperty = getTextureProperty(paramPlayerProfile);
    String str = paramPlayerProfile.getName() != null ? paramPlayerProfile.getName() : paramString;
    AltarSMP.getInstance().getServer().getScheduler().runTask(AltarSMP.getInstance(), () -> applyResolvedPlayerProfile(paramPlayer, profileProperty, paramString, str));
  }

  public static void applyResolvedPlayerProfile(Player paramPlayer, ProfileProperty paramProfileProperty, String paramString1, String paramString2) {
    {
      if (!paramPlayer.isOnline())
        return; 
    }{
      if (paramProfileProperty == null) {
        paramPlayer.sendMessage(((TextComponent)Component.text("Couldn't find a player named " + paramString1 + ".").color((TextColor)NamedTextColor.RED)).decoration(TextDecoration.ITALIC, false));
        return;
      } 
    }
    applyPlayerProfile(paramPlayer, paramString2, paramProfileProperty);
  }

  public static void applyFlightBoost(Player paramPlayer, UUID paramUUID) {
    {
      if (paramPlayer.isOnline()) {
        {
          if (!flyingDisguisePlayers.contains(paramUUID))
            return; 
        }} else {
        return;
      } 
    }if (paramPlayer.getGameMode() == GameMode.SURVIVAL || paramPlayer.getGameMode() == GameMode.ADVENTURE)
        paramPlayer.setVelocity(new Vector(0.0D, 0.5D, 0.0D));
  }

  static {
    disguisedEntityOwners = new HashMap<>();
    disguisedPlayerTargets = new HashMap<>();
    activeDisguises = new HashMap<>();
    flyingDisguisePlayers = new HashSet<>();
    DISGUISE_BOSS_BAR_KEY = new NamespacedKey("doomdisguise", "altarsmp");
    REAL_SKIN_VALUE_KEY = new NamespacedKey(AltarSMP.getInstance(), "real_skin_value");
    REAL_SKIN_SIGNATURE_KEY = new NamespacedKey(AltarSMP.getInstance(), "real_skin_signature");
    REAL_OLD_NAME_KEY = new NamespacedKey(AltarSMP.getInstance(), "real_old_name");
  }

}
