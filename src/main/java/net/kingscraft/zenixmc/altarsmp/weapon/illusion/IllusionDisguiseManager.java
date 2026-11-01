package net.kingscraft.zenixmc.altarsmp.weapon.illusion;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.attribute.IllusionAttributeService;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.flight.IllusionFlightService;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.passive.IllusionPassiveService;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.util.IllusionConfig;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.ability.IllusionAbilityRegistry;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Evoker;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitTask;

public class IllusionDisguiseManager implements Listener {
  public static final Map<UUID, UUID> disguisedEntityOwners = new HashMap<>();

  public static final Map<UUID, UUID> disguisedPlayerTargets = new HashMap<>();

  public static final Map<UUID, DisguiseEntityTask> activeDisguises = new HashMap<>();

  private static final Map<UUID, Boolean> PREVIOUS_INVISIBLE = new HashMap<>();

  /**
   * Invisibility hides the player model and name tag, but vanilla still renders
   * armour and held items. These slots are masked for every other viewer while
   * the disguise is active, then restored on reveal.
   */
  private static final EquipmentSlot[] EQUIPMENT_SLOTS = {
          EquipmentSlot.HAND, EquipmentSlot.OFF_HAND,
          EquipmentSlot.HEAD, EquipmentSlot.CHEST,
          EquipmentSlot.LEGS, EquipmentSlot.FEET
  };

  private static final ItemStack EMPTY_ITEM = new ItemStack(Material.AIR);

  /**
   * Keyed boss bar created by older plugin versions. Disguises no longer use a
   * boss bar at all; the status line is action-bar text.
   */
  @Deprecated
  public static final NamespacedKey DISGUISE_BOSS_BAR_KEY = new NamespacedKey("doomdisguise", "altarsmp");

  public static final NamespacedKey REAL_SKIN_VALUE_KEY = new NamespacedKey(AltarSMP.getInstance(), "real_skin_value");

  public static final NamespacedKey REAL_SKIN_SIGNATURE_KEY = new NamespacedKey(AltarSMP.getInstance(), "real_skin_signature");

  public static final NamespacedKey REAL_OLD_NAME_KEY = new NamespacedKey(AltarSMP.getInstance(), "real_old_name");

  public IllusionDisguiseManager() {
    // Older versions created a single persistent boss bar with this key.
    Bukkit.removeBossBar(DISGUISE_BOSS_BAR_KEY);
  }

  public static void disguisePlayer(Player player, EntityType type, Player target) {
    if (player == null || type == null) {
      return;
    }
    if (!IllusionConfig.enabled()) {
      player.sendMessage(Component.text("The Wand of Illusion is disabled.", NamedTextColor.RED));
      return;
    }

    revealPlayer(player);

    if (type == EntityType.PLAYER) {
      if (target == null || !target.isOnline()) {
        player.sendMessage(Component.text("That player is no longer available.", NamedTextColor.RED));
        return;
      }
      disguiseIntoPlayer(player, target.getName());
      disguisedPlayerTargets.put(player.getUniqueId(), target.getUniqueId());
      activeDisguises.put(player.getUniqueId(), new DisguiseEntityTask(player, null));
      playDisguiseEffects(player, target.getName());
      return;
    }

    if (type == EntityType.ENDER_DRAGON) {
      player.sendMessage(Component.text("The Ender Dragon cannot be disguised as.", NamedTextColor.RED));
      return;
    }
    if (!type.isSpawnable() || type.getEntityClass() == null
        || !LivingEntity.class.isAssignableFrom(type.getEntityClass())) {
      player.sendMessage(Component.text("That mob cannot be disguised as.", NamedTextColor.RED));
      return;
    }

    Entity entity = player.getWorld().spawnEntity(player.getLocation(), type);
    if (!(entity instanceof LivingEntity livingEntity)) {
      entity.remove();
      player.sendMessage(Component.text("That mob cannot be disguised as.", NamedTextColor.RED));
      return;
    }
    livingEntity.setAI(false);
    livingEntity.setSilent(true);
    livingEntity.setPersistent(false);
    livingEntity.setRemoveWhenFarAway(false);
    livingEntity.setCanPickupItems(false);
    livingEntity.setCollidable(false);
    livingEntity.setInvulnerable(false);
    livingEntity.setPortalCooldown(Integer.MAX_VALUE);
    livingEntity.setCustomNameVisible(false);
    if (livingEntity.getEquipment() != null) {
      livingEntity.getEquipment().clear();
    }
    if (livingEntity instanceof Wither wither) {
      // Skip the spawn animation so the real Wither model is visible, and make
      // sure the fake boss never puts a boss bar on everyone's screen.
      wither.setInvulnerableTicks(0);
      if (IllusionConfig.witherHideBossBar() && wither.getBossBar() != null) {
        wither.getBossBar().setVisible(false);
      }
    }

    player.hideEntity(AltarSMP.getInstance(), entity);
    PREVIOUS_INVISIBLE.put(player.getUniqueId(), player.isInvisible());
    // Invisibility keeps the player in TAB and keeps the entity alive while the
    // fake mob is rendered on top of it.
    player.setInvisible(true);
    hideEquipment(player);

    BukkitTask task = new DisguiseFollowTask(player, entity).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
    activeDisguises.put(player.getUniqueId(), new DisguiseEntityTask(entity, task));
    disguisedEntityOwners.put(entity.getUniqueId(), player.getUniqueId());

    IllusionAttributeService.apply(player, type);
    IllusionPassiveService.apply(player, type);
    IllusionFlightService.apply(player, type);

    if (type != EntityType.PLAYER && IllusionConfig.aggroImmunity()) {
      clearMobTargets(player);
    }

    playDisguiseEffects(player, displayName(type));
  }

  public static void revealPlayer(Player player) {
    revealPlayer(player, true);
  }

  public static void revealPlayer(Player player, boolean announce) {
    if (player == null) {
      return;
    }

    DisguiseEntityTask disguise = activeDisguises.remove(player.getUniqueId());
    IllusionFlightService.clear(player);
    IllusionPassiveService.clear(player);
    IllusionAttributeService.clear(player);
    if (disguise == null) {
      return;
    }

    disguisedPlayerTargets.remove(player.getUniqueId());
    if (disguise.entity() != null) {
      disguisedEntityOwners.remove(disguise.entity().getUniqueId());
    }
    if (disguise.task() != null) {
      disguise.task().cancel();
    }
    if (disguise.entity() != null && disguise.entity().getType() != EntityType.PLAYER) {
      disguise.entity().remove();
    }

    restorePlayerProfile(player);
    player.setInvisible(PREVIOUS_INVISIBLE.getOrDefault(player.getUniqueId(), false));
    PREVIOUS_INVISIBLE.remove(player.getUniqueId());
    refreshEquipment(player);
    if (announce) {
      player.showTitle(Title.title(
              Component.empty(),
              Component.text()
                      .append(Component.text("You have been ", NamedTextColor.GREEN))
                      .append(Component.text("REVEALED", NamedTextColor.RED))
                      .append(Component.text(".", NamedTextColor.GREEN))
                      .build()));
    }
    spawnRevealParticles(player);
  }

  @EventHandler
  public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
    new DisguiseWorldChangeTask(event).runTaskLater(AltarSMP.getInstance(), 2L);
  }

  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
    if (!(event.getDamager() instanceof Player player)) {
      return;
    }
    if (disguisedPlayerTargets.containsKey(player.getUniqueId())) {
      return;
    }
    DisguiseEntityTask disguise = activeDisguises.get(player.getUniqueId());
    if (disguise != null && disguise.entity() instanceof LivingEntity livingEntity) {
      livingEntity.swingMainHand();
    }
  }

  /**
   * The fake mob is a visual shell and never takes real damage. Only another
   * player (or that player's projectile) can damage it, and that hit is routed
   * to the real owner. Environmental and mob damage is dropped because the real
   * player already takes those hits directly.
   */
  @EventHandler(priority = EventPriority.HIGHEST)
  public void onEntityDamage(EntityDamageEvent event) {
    Entity entity = event.getEntity();
    UUID ownerId = disguisedEntityOwners.get(entity.getUniqueId());
    if (ownerId == null) {
      return;
    }
    // Always cancel: the disguise entity must never lose health, die, or show
    // its own hurt tint. Player damage is animated on the owner instead.
    boolean wasCancelled = event.isCancelled();
    event.setCancelled(true);
    if (wasCancelled || !(event instanceof EntityDamageByEntityEvent byEntity)) {
      return;
    }
    Player owner = Bukkit.getPlayer(ownerId);
    if (owner == null || !owner.isOnline() || !canBeHurt(owner)) {
      return;
    }
    Player attacker = playerSource(byEntity.getDamager());
    if (attacker == null || attacker.getUniqueId().equals(ownerId)) {
      return;
    }
    // Forward the pre-armour value: the shell has no gear, so its own armour
    // step must not reduce the hit a second time before the owner is damaged.
    owner.damage(baseDamage(event), byEntity.getDamageSource());
  }

  private static double baseDamage(EntityDamageEvent event) {
    try {
      double base = event.getDamage(EntityDamageEvent.DamageModifier.BASE);
      if (base > 0.0D) {
        return base;
      }
    } catch (UnsupportedOperationException | IllegalArgumentException ignored) {
      // Some custom damage sources do not expose modifiers; fall back below.
    }
    return event.getDamage();
  }

  /** Returns the player behind a fake disguise entity, or null if not a shell. */
  public static Player disguiseOwner(Entity entity) {
    if (entity == null) {
      return null;
    }
    UUID ownerId = disguisedEntityOwners.get(entity.getUniqueId());
    if (ownerId == null) {
      return null;
    }
    Player owner = Bukkit.getPlayer(ownerId);
    return owner != null && owner.isOnline() ? owner : null;
  }

  private static Player playerSource(Entity damager) {
    if (damager instanceof Player player) {
      return player;
    }
    if (damager instanceof Projectile projectile
        && projectile.getShooter() instanceof Player player) {
      return player;
    }
    return null;
  }

  /** Animate the fake mob when the real player actually takes a hit. */
  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void onPlayerDamaged(EntityDamageEvent event) {
    if (!(event.getEntity() instanceof Player player)) {
      return;
    }
    if (!canBeHurt(player)) {
      return;
    }
    DisguiseEntityTask disguise = activeDisguises.get(player.getUniqueId());
    if (disguise != null && disguise.entity() instanceof LivingEntity livingEntity
        && !livingEntity.equals(player)) {
      livingEntity.playHurtAnimation(0.0F);
    }
  }

  /**
   * Hostile mobs ignore mob disguises (but not captured-player disguises), and
   * never target the fake entity itself.
   */
  @EventHandler(priority = EventPriority.HIGHEST)
  public void onEntityTarget(EntityTargetEvent event) {
    Entity target = event.getTarget();
    if (target == null) {
      return;
    }
    if (disguisedEntityOwners.containsKey(target.getUniqueId())) {
      event.setCancelled(true);
      return;
    }
    if (!(target instanceof Player player) || !IllusionConfig.aggroImmunity()) {
      return;
    }
    if (isMobDisguise(player)) {
      event.setCancelled(true);
    }
  }

  /** A fake Wither (or any exploding disguise) must never damage terrain. */
  @EventHandler(priority = EventPriority.HIGHEST)
  public void onDisguiseExplode(EntityExplodeEvent event) {
    if (disguisedEntityOwners.containsKey(event.getEntity().getUniqueId())) {
      event.setCancelled(true);
      event.blockList().clear();
    }
  }

  public static void spawnRevealParticles(Player player) {
    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.5F);
    player.getWorld().spawnParticle(
        Particle.DUST,
        player.getLocation().add(0.0D, 1.0D, 0.0D),
        120,
        0.7D, 1.1D, 0.7D,
        0.0D,
        new Particle.DustOptions(Color.fromRGB(0, 0, 0), 1.0F));
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    Player joining = event.getPlayer();
    for (Player online : Bukkit.getOnlinePlayers()) {
      if (online.equals(joining)) {
        continue;
      }
      if (isMobDisguise(online)) {
        hideEquipmentFor(online, joining);
      }
    }
    // Disguise state is in-memory and cleared on quit, but keep this path safe.
    if (isMobDisguise(joining)) {
      joining.setInvisible(true);
      hideEquipment(joining);
    }
  }

  public static EntityType getDisguisedEntityType(Player player) {
    DisguiseEntityTask disguise = activeDisguises.get(player.getUniqueId());
    return disguise == null || disguise.entity() == null ? null : disguise.entity().getType();
  }

  public static boolean isDisguised(Player player) {
    return activeDisguises.containsKey(player.getUniqueId());
  }

  public static boolean isMobDisguise(Player player) {
    if (player == null || !activeDisguises.containsKey(player.getUniqueId())) {
      return false;
    }
    return getDisguisedEntityType(player) != EntityType.PLAYER;
  }

  public static boolean canBeHurt(Player player) {
    if (player == null || !player.isOnline() || player.isDead() || player.isInvulnerable()) {
      return false;
    }
    GameMode mode = player.getGameMode();
    return mode != GameMode.CREATIVE && mode != GameMode.SPECTATOR;
  }

  /** Drives the fake entity's attack / spell animation when an ability fires. */
  public static void playCastAnimation(Player player, EntityType type) {
    DisguiseEntityTask disguise = activeDisguises.get(player.getUniqueId());
    if (disguise == null || !(disguise.entity() instanceof LivingEntity living)) {
      return;
    }
    living.swingMainHand();
    if (living instanceof Evoker evoker) {
      evoker.setCurrentSpell(Evoker.Spell.FANGS);
      Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
        if (evoker.isValid() && !evoker.isDead()) {
          evoker.setCurrentSpell(Evoker.Spell.NONE);
        }
      }, 30L);
    }
  }

  /** Periodic upkeep for state vanilla can silently turn back on. */
  public static void maintainDisguiseState(Player player) {
    clearMobTargets(player);
    DisguiseEntityTask disguise = activeDisguises.get(player.getUniqueId());
    if (disguise != null && disguise.entity() instanceof Wither wither
        && IllusionConfig.witherHideBossBar() && wither.getBossBar() != null) {
      wither.getBossBar().setVisible(false);
    }
  }

  public static void clearMobTargets(Player player) {
    if (player == null || !player.isOnline()
        || !IllusionConfig.aggroImmunity() || !isMobDisguise(player)) {
      return;
    }
    for (Entity nearby : player.getNearbyEntities(32.0D, 32.0D, 32.0D)) {
      if (nearby instanceof Mob mob && player.equals(mob.getTarget())) {
        mob.setTarget(null);
      }
    }
  }

  static void hideEquipment(Player player) {
    for (Player online : Bukkit.getOnlinePlayers()) {
      if (!online.equals(player)) {
        hideEquipmentFor(player, online);
      }
    }
  }

  private static void hideEquipmentFor(Player disguised, Player viewer) {
    for (EquipmentSlot slot : EQUIPMENT_SLOTS) {
      viewer.sendEquipmentChange(disguised, slot, EMPTY_ITEM);
    }
  }

  private static void refreshEquipment(Player player) {
    for (Player online : Bukkit.getOnlinePlayers()) {
      if (online.equals(player)) {
        continue;
      }
      for (EquipmentSlot slot : EQUIPMENT_SLOTS) {
        online.sendEquipmentChange(player, slot, equipmentItem(player, slot));
      }
    }
  }

  private static ItemStack equipmentItem(Player player, EquipmentSlot slot) {
    ItemStack item = switch (slot) {
      case HAND -> player.getInventory().getItemInMainHand();
      case OFF_HAND -> player.getInventory().getItemInOffHand();
      case HEAD -> player.getInventory().getHelmet();
      case CHEST -> player.getInventory().getChestplate();
      case LEGS -> player.getInventory().getLeggings();
      case FEET -> player.getInventory().getBoots();
      default -> null;
    };
    return item == null ? EMPTY_ITEM : item;
  }

  public static void disguiseIntoPlayer(Player player, String targetName) {
    player.displayName(Component.text(targetName));
    player.getPersistentDataContainer().set(REAL_OLD_NAME_KEY, PersistentDataType.STRING, player.getName());

    ProfileProperty profileProperty = getTextureProperty(player.getPlayerProfile());
    if (profileProperty != null) {
      player.getPersistentDataContainer().set(REAL_SKIN_VALUE_KEY, PersistentDataType.STRING, profileProperty.getValue());
      player.getPersistentDataContainer().set(REAL_SKIN_SIGNATURE_KEY, PersistentDataType.STRING,
          profileProperty.getSignature() != null ? profileProperty.getSignature() : "");
    }

    Player onlineTarget = Bukkit.getPlayerExact(targetName);
    if (onlineTarget != null) {
      ProfileProperty targetTexture = getTextureProperty(onlineTarget.getPlayerProfile());
      if (targetTexture != null) {
        applyPlayerProfile(player, onlineTarget.getName(), targetTexture);
        return;
      }
    }

    PlayerProfile playerProfile = AltarSMP.getInstance().getServer().createProfile(targetName);
    AltarSMP.getInstance().getServer().getScheduler().runTaskAsynchronously(AltarSMP.getInstance(),
        () -> completePlayerProfileLookup(playerProfile, targetName, player));
  }

  public static void restorePlayerProfile(Player player) {
    if (player == null || !player.isOnline()) {
      return;
    }
    PersistentDataContainer container = player.getPersistentDataContainer();
    String skinValue = container.get(REAL_SKIN_VALUE_KEY, PersistentDataType.STRING);
    String skinSignature = container.get(REAL_SKIN_SIGNATURE_KEY, PersistentDataType.STRING);
    String oldName = container.get(REAL_OLD_NAME_KEY, PersistentDataType.STRING);
    if (oldName != null && !oldName.isEmpty()) {
      player.displayName(Component.text(oldName));
    }

    if (skinValue != null && !skinValue.isEmpty()) {
      try {
        ProfileProperty profileProperty = new ProfileProperty("textures", skinValue,
            skinSignature == null || skinSignature.isEmpty() ? null : skinSignature);
        String profileName = oldName == null || oldName.isEmpty() ? player.getName() : oldName;
        PlayerProfile playerProfile = AltarSMP.getInstance().getServer().createProfile(player.getUniqueId(), profileName);
        playerProfile.clearProperties();
        playerProfile.setProperty(profileProperty);
        player.setPlayerProfile(playerProfile);
      } catch (Exception exception) {
        exception.printStackTrace();
      }
    }

    container.remove(REAL_SKIN_VALUE_KEY);
    container.remove(REAL_SKIN_SIGNATURE_KEY);
    container.remove(REAL_OLD_NAME_KEY);
  }

  public static ProfileProperty getTextureProperty(PlayerProfile playerProfile) {
    if (playerProfile == null) {
      return null;
    }
    for (ProfileProperty property : playerProfile.getProperties()) {
      if ("textures".equals(property.getName())) {
        return property;
      }
    }
    return null;
  }

  public static void applyPlayerProfile(Player player, String profileName, ProfileProperty profileProperty) {
    if (player == null || !player.isOnline()) {
      return;
    }
    PlayerProfile playerProfile = AltarSMP.getInstance().getServer().createProfile(player.getUniqueId(), profileName);
    playerProfile.clearProperties();
    playerProfile.setProperty(profileProperty);
    // setPlayerProfile re-registers the player with the server, so the old
    // hide/show refresh loop is unnecessary (and used to flicker TAB).
    player.setPlayerProfile(playerProfile);
  }

  @EventHandler
  public void onPlayerRespawn(PlayerRespawnEvent event) {
    Player player = event.getPlayer();
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> resetPlayerAttributes(player), 3L);
  }

  /**
   * Disguise state is in-memory, so it is gone after a relog. Clean it up on
   * quit as well so infinite passive effects, invisibility and flight flags are
   * never written back to the player's saved data.
   */
  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
    Player player = event.getPlayer();
    DisguiseEntityTask disguise = activeDisguises.remove(player.getUniqueId());
    IllusionFlightService.clear(player);
    IllusionPassiveService.clear(player);
    IllusionAttributeService.clear(player);
    if (PREVIOUS_INVISIBLE.containsKey(player.getUniqueId())) {
      player.setInvisible(PREVIOUS_INVISIBLE.getOrDefault(player.getUniqueId(), false));
      PREVIOUS_INVISIBLE.remove(player.getUniqueId());
    }
    if (disguise == null) {
      return;
    }
    disguisedPlayerTargets.remove(player.getUniqueId());
    if (disguise.entity() != null) {
      if (disguise.entity().getType() != EntityType.PLAYER) {
        disguisedEntityOwners.remove(disguise.entity().getUniqueId());
        disguise.entity().remove();
      }
    }
    if (disguise.task() != null) {
      disguise.task().cancel();
    }
  }

  @EventHandler(priority = EventPriority.HIGHEST)
  public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
    Player player = event.getPlayer();
    if (!IllusionFlightService.isFlyManaged(player)) {
      return;
    }
    GameMode gameMode = player.getGameMode();
    if (gameMode == GameMode.CREATIVE || gameMode == GameMode.SPECTATOR) {
      return;
    }
    if (!player.getAllowFlight()) {
      player.setAllowFlight(true);
    }
    event.setCancelled(false);
  }

  public static void resetPlayerAttributes(Player player) {
    if (player == null) {
      return;
    }
    if (isDisguised(player)) {
      revealPlayer(player);
    }
    IllusionFlightService.clear(player);
    IllusionPassiveService.clear(player);
    IllusionAttributeService.clear(player);
  }

  public static void completePlayerProfileLookup(PlayerProfile playerProfile, String requestedName, Player player) {
    try {
      playerProfile.complete(true);
    } catch (Exception ignored) {
    }
    ProfileProperty profileProperty = getTextureProperty(playerProfile);
    String resolvedName = playerProfile.getName() != null ? playerProfile.getName() : requestedName;
    AltarSMP.getInstance().getServer().getScheduler().runTask(AltarSMP.getInstance(),
        () -> applyResolvedPlayerProfile(player, profileProperty, requestedName, resolvedName));
  }

  public static void applyResolvedPlayerProfile(Player player, ProfileProperty profileProperty,
                                                String requestedName, String resolvedName) {
    if (player == null || !player.isOnline()) {
      return;
    }
    if (!isDisguised(player) || getDisguisedEntityType(player) != EntityType.PLAYER) {
      return;
    }
    if (profileProperty == null) {
      player.sendMessage(Component.text("Couldn't find a player named " + requestedName + ".")
          .color(NamedTextColor.RED)
          .decoration(TextDecoration.ITALIC, false));
      return;
    }
    applyPlayerProfile(player, resolvedName, profileProperty);
  }

  public static void sendDisguiseBar(Player player) {
    if (player == null || !player.isOnline()) {
      return;
    }
    EntityType type = getDisguisedEntityType(player);
    if (type == null) {
      return;
    }
    boolean hasActiveAbility = type != EntityType.PLAYER
            && !IllusionAbilityRegistry.family(type).isPassive();
    String ability;
    if (type == EntityType.PLAYER) {
      ability = "None";
    } else if (type == EntityType.STRIDER) {
      ability = "Lava Walk (passive)";
    } else {
      ability = IllusionAbilityRegistry.family(type).displayName();
    }
    player.sendActionBar(Component.text()
            .append(Component.text("Disguised: ", NamedTextColor.GRAY))
            .append(Component.text(displayName(type), NamedTextColor.LIGHT_PURPLE))
            .append(Component.text(" | Ability: ", NamedTextColor.GRAY))
            .append(Component.text(ability, NamedTextColor.AQUA))
            .append(Component.text(hasActiveAbility
                    ? " | Offhand | " + IllusionConfig.abilityCooldown() + "s" : "", NamedTextColor.DARK_GRAY))
            .build());
  }

  private static void playDisguiseEffects(Player player, String targetName) {
    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1.0F, 1.0F);
    player.showTitle(Title.title(
            Component.text("Disguised as:", NamedTextColor.GREEN),
            Component.text(targetName, NamedTextColor.GOLD)));
    spawnRevealParticles(player);
    sendDisguiseBar(player);
  }

  private static String displayName(EntityType type) {
    return type.name().toLowerCase(Locale.ROOT).replace('_', ' ');
  }
}
