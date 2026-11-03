package net.kingscraft.zenixmc.altarsmp.weapon.illusion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import net.kingscraft.zenixmc.altarsmp.weapon.illusion.util.PiglinVariant;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.ability.IllusionAbilities;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.ability.IllusionAbilityFamily;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.ability.IllusionAbilityRegistry;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.passive.IllusionPassiveService;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.util.IllusionConfig;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.util.IllusionMeleeDamage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.EvokerFangs;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class IllusionWandAbility implements Listener {

  public static NamespacedKey STORED_MOB_KEY;
  public static NamespacedKey STORED_PLAYER_NAME_KEY;
  public static NamespacedKey STORED_PIGLIN_VARIANT_KEY;

  private static final Map<UUID, Long> LAST_ACTIVATION = new HashMap<>();
  static final Set<UUID> CHARGING = new HashSet<>();

  public final AltarSMP plugin;

  public IllusionWandAbility(AltarSMP plugin) {
    this.plugin = plugin;
    STORED_MOB_KEY = new NamespacedKey(plugin, "stored_mob");
    STORED_PLAYER_NAME_KEY = new NamespacedKey(plugin, "stored_player_name");
    STORED_PIGLIN_VARIANT_KEY = new NamespacedKey(plugin, "stored_piglin_variant");
  }

  public static boolean isIllusionWand(ItemStack itemStack) {
    if (itemStack == null || itemStack.getType() != Material.NETHERITE_SWORD || !itemStack.hasItemMeta()) {
      return false;
    }
    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta == null) {
      return false;
    }
    List<Float> floats = itemMeta.getCustomModelDataComponent().getFloats();
    return !floats.isEmpty() && floats.getFirst() == 2.0F;
  }
  public static ItemStack findWand(Player player) {
    if (player == null) {
      return null;
    }
    ItemStack offHand = player.getInventory().getItemInOffHand();
    if (isIllusionWand(offHand)) {
      return offHand;
    }
    ItemStack mainHand = player.getInventory().getItemInMainHand();
    if (isIllusionWand(mainHand)) {
      return mainHand;
    }
    for (ItemStack stack : player.getInventory().getContents()) {
      if (isIllusionWand(stack)) {
        return stack;
      }
    }
    return null;
  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void onPlayerDeath(PlayerDeathEvent event) {
    Player player = event.getEntity();
    if (!IllusionDisguiseManager.isDisguised(player)) {
      return;
    }
    // Never cancel death. Just drop the disguise; the captured mob stays in the wand.
    IllusionDisguiseManager.revealPlayer(player, false);
  }

  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void onEntityDeath(EntityDeathEvent event) {
    LivingEntity dead = event.getEntity();
    Player killer = dead.getKiller();
    if (killer == null || dead.equals(killer)) {
      return;
    }
    if (IllusionDisguiseManager.disguisedEntityOwners.containsKey(dead.getUniqueId())) {
      return;
    }
    ItemStack wand = findWand(killer);
    if (wand == null) {
      return;
    }
    if (dead instanceof Player victim) {
      capturePlayer(killer, wand, victim);
    } else {
      PiglinVariant variant = null;
      if (dead instanceof Piglin piglin && piglin.getEquipment() != null) {
        variant = PiglinVariant.fromItem(piglin.getEquipment().getItemInMainHand());
        if (variant == PiglinVariant.NONE) {
          variant = PiglinVariant.fromItem(piglin.getEquipment().getItemInOffHand());
        }
      }
      storeCapturedMob(killer, wand, dead.getType(), variant);
    }
  }

  private static void capturePlayer(Player killer, ItemStack wand, Player victim) {
    ItemMeta itemMeta = wand.getItemMeta();
    if (itemMeta == null) {
      return;
    }
    PersistentDataContainer container = itemMeta.getPersistentDataContainer();
    String existing = container.get(STORED_PLAYER_NAME_KEY, PersistentDataType.STRING);
    if (IllusionConfig.keepCapturedMob() && victim.getName().equals(existing)) {
      return;
    }
    container.set(STORED_PLAYER_NAME_KEY, PersistentDataType.STRING, victim.getName());
    container.remove(STORED_MOB_KEY);
    container.remove(STORED_PIGLIN_VARIANT_KEY);
    wand.setItemMeta(itemMeta);

    killer.sendMessage(Component.text()
            .append(Component.text("» You captured ", NamedTextColor.DARK_RED))
            .append(Component.text(victim.getName(), NamedTextColor.RED, TextDecoration.UNDERLINED))
            .build());
    killer.playSound(killer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.5F);
  }

  public static void storeCapturedMob(Player player, ItemStack wand, EntityType type) {
    storeCapturedMob(player, wand, type, null);
  }

  public static void storeCapturedMob(Player player, ItemStack wand, EntityType type,
                                      PiglinVariant variant) {
    if (player == null || wand == null || type == null || !IllusionConfig.enabled()) {
      return;
    }
    if (type == EntityType.ENDER_DRAGON) {
      player.sendMessage(Component.text("The Ender Dragon cannot be captured.", NamedTextColor.RED));
      return;
    }
    if (type == EntityType.PLAYER || !type.isSpawnable() || type.getEntityClass() == null
            || !LivingEntity.class.isAssignableFrom(type.getEntityClass())) {
      return;
    }
    PiglinVariant resolvedVariant = IllusionMeleeDamage.resolveVariant(type, variant);
    ItemMeta itemMeta = wand.getItemMeta();
    if (itemMeta == null) {
      return;
    }
    PersistentDataContainer container = itemMeta.getPersistentDataContainer();
    String existingPlayer = container.get(STORED_PLAYER_NAME_KEY, PersistentDataType.STRING);
    String existingMob = container.get(STORED_MOB_KEY, PersistentDataType.STRING);
    String existingVariantName = container.get(STORED_PIGLIN_VARIANT_KEY, PersistentDataType.STRING);
    if (IllusionConfig.keepCapturedMob()
            && existingPlayer == null
            && type.name().equals(existingMob)
            && (type != EntityType.PIGLIN
                || resolvedVariant.name().equals(existingVariantName))) {
      // Same mob already captured: keep it instead of replacing it with itself.
      return;
    }
    container.set(STORED_MOB_KEY, PersistentDataType.STRING, type.name());
    container.remove(STORED_PLAYER_NAME_KEY);
    if (type == EntityType.PIGLIN) {
      container.set(STORED_PIGLIN_VARIANT_KEY, PersistentDataType.STRING, resolvedVariant.name());
    } else {
      container.remove(STORED_PIGLIN_VARIANT_KEY);
    }
    wand.setItemMeta(itemMeta);

    player.sendMessage(Component.text()
            .append(Component.text("» You captured a ", NamedTextColor.DARK_RED))
            .append(Component.text(type.name().replace('_', ' '), NamedTextColor.RED, TextDecoration.UNDERLINED))
            .build());
    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.2F);
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    Player player = event.getPlayer();
    ItemStack itemStack = event.getItem();
    if (!isIllusionWand(itemStack)) {
      return;
    }
    if (!IllusionConfig.enabled()) {
      return;
    }
    Action action = event.getAction();
    if ((action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) && player.isSneaking()) {
      if (IllusionDisguiseManager.isDisguised(player)) {
        IllusionDisguiseManager.revealPlayer(player);
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 0.8F);
      }
      return;
    }
    if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
      // Right-click is disguise-only. Active abilities are offhand-swap only.
      if (IllusionDisguiseManager.isDisguised(player)) {
        return;
      }
      if (action == Action.RIGHT_CLICK_BLOCK) {
        event.setCancelled(true);
      }
      if (!CHARGING.add(player.getUniqueId())) {
        return;
      }
      new IllusionWandChargeTask(player).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
    }
  }

  @EventHandler
  public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
    Player player = event.getPlayer();
    if (!isIllusionWand(event.getItem())) {
      return;
    }
    event.setCancelled(true);
    player.updateInventory();
    activateDisguise(player);
  }

  public static void activateDisguise(Player player) {
    if (player == null || !IllusionConfig.enabled()) {
      return;
    }
    if (IllusionDisguiseManager.isDisguised(player)) {
      return;
    }
    long now = System.currentTimeMillis();
    Long last = LAST_ACTIVATION.get(player.getUniqueId());
    if (last != null && now - last < 750L) {
      return;
    }
    if (IllusionConfig.randomMobMode()) {
      disguiseAsRandomMob(player);
      LAST_ACTIVATION.put(player.getUniqueId(), now);
      return;
    }
    ItemStack wand = findWand(player);
    if (wand == null) {
      player.sendMessage(Component.text("You are not holding the Wand of Illusion.", NamedTextColor.RED));
      return;
    }
    boolean disguised = restoreCapturedMob(player, wand);
    if (disguised) {
      LAST_ACTIVATION.put(player.getUniqueId(), now);
    }
  }

  private static void disguiseAsRandomMob(Player player) {
    List<String> configured = IllusionConfig.randomMobTypes();
    List<EntityType> types = new ArrayList<>();
    for (String name : configured) {
      try {
        EntityType type = EntityType.valueOf(name.toUpperCase(Locale.ROOT));
        if (type != EntityType.PLAYER && type != EntityType.ENDER_DRAGON
                && type.isSpawnable() && type.getEntityClass() != null
                && LivingEntity.class.isAssignableFrom(type.getEntityClass())) {
          types.add(type);
        }
      } catch (IllegalArgumentException exception) {
        AltarSMP.getInstance().getLogger().warning("Invalid EntityType in illusion.random-mobs: " + name);
      }
    }
    if (types.isEmpty()) {
      player.sendMessage(Component.text("No valid random mobs are configured.", NamedTextColor.RED));
      return;
    }
    EntityType type = types.get(ThreadLocalRandom.current().nextInt(types.size()));
    IllusionDisguiseManager.disguisePlayer(player, type, null);
  }

  public static boolean restoreCapturedMob(Player player, ItemStack wand) {
    if (player == null) {
      return false;
    }
    // The stack from PlayerItemConsumeEvent can be a copy, so always re-read the
    // wand that is actually in the inventory.
    ItemStack held = findWand(player);
    if (held != null) {
      wand = held;
    }
    if (!isIllusionWand(wand)) {
      player.sendMessage(Component.text("You are not holding the Wand of Illusion.", NamedTextColor.RED));
      return false;
    }
    ItemMeta itemMeta = wand.getItemMeta();
    if (itemMeta == null) {
      return false;
    }
    PersistentDataContainer container = itemMeta.getPersistentDataContainer();

    String storedPlayerName = container.get(STORED_PLAYER_NAME_KEY, PersistentDataType.STRING);
    if (storedPlayerName != null && !storedPlayerName.isEmpty()) {
      Player target = Bukkit.getPlayerExact(storedPlayerName);
      if (target == null) {
        player.sendMessage(Component.text("The captured player " + storedPlayerName + " is not online.",
                NamedTextColor.RED));
        return false;
      }
      IllusionDisguiseManager.disguisePlayer(player, EntityType.PLAYER, target);
      if (IllusionDisguiseManager.isDisguised(player)) {
        consumeIfNeeded(wand);
        return true;
      }
      return false;
    }

    String storedMob = container.get(STORED_MOB_KEY, PersistentDataType.STRING);
    if (storedMob == null || storedMob.isEmpty()) {
      player.sendMessage(Component.text("This wand has not captured a mob yet.", NamedTextColor.RED));
      return false;
    }
    EntityType type;
    try {
      type = EntityType.valueOf(storedMob.toUpperCase(Locale.ROOT));
    } catch (IllegalArgumentException exception) {
      player.sendMessage(Component.text("The captured mob is no longer valid.", NamedTextColor.RED));
      return false;
    }
    PiglinVariant variant = null;
    if (type == EntityType.PIGLIN) {
      String storedVariant = container.get(STORED_PIGLIN_VARIANT_KEY, PersistentDataType.STRING);
      variant = storedVariant == null ? PiglinVariant.SWORD : PiglinVariant.fromName(storedVariant);
    }
    IllusionDisguiseManager.disguisePlayer(player, type, null, variant);
    if (IllusionDisguiseManager.isDisguised(player)) {
      consumeIfNeeded(wand);
      return true;
    }
    return false;
  }

  private static void consumeIfNeeded(ItemStack wand) {
    if (IllusionConfig.keepCapturedMob()) {
      return;
    }
    ItemMeta itemMeta = wand.getItemMeta();
    if (itemMeta == null) {
      return;
    }
    PersistentDataContainer container = itemMeta.getPersistentDataContainer();
    container.remove(STORED_MOB_KEY);
    container.remove(STORED_PLAYER_NAME_KEY);
    container.remove(STORED_PIGLIN_VARIANT_KEY);
    wand.setItemMeta(itemMeta);
  }

  public static void startAbilityCooldown(Player player) {
    int cooldown = IllusionConfig.abilityCooldown();
    CooldownManager.setCooldown(player.getUniqueId(), "mobAbility", cooldown);
    BossBarManager.createBar(player, "Illusion Ability", cooldown, NamedTextColor.RED);
  }

  @EventHandler
  public void onEntityDamage(EntityDamageEvent event) {
    if (!(event.getEntity() instanceof Player player)) {
      return;
    }
    if (!IllusionDisguiseManager.isDisguised(player)) {
      return;
    }
    // Only a Creeper disguise is immune to explosions.
    if (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION
            && IllusionDisguiseManager.getDisguisedEntityType(player) == EntityType.CREEPER) {
      event.setCancelled(true);
      return;
    }
    // Landing on the strider lava-walk platform must not deal fall damage.
    if (event.getCause() == EntityDamageEvent.DamageCause.FALL
            && IllusionDisguiseManager.getDisguisedEntityType(player) == EntityType.STRIDER
            && IllusionPassiveService.isOnOrFallingIntoLava(player)) {
      event.setCancelled(true);
    }
  }

  @EventHandler(priority = EventPriority.HIGHEST)
  public void onIllusionProjectileExplode(EntityExplodeEvent event) {
    Entity entity = event.getEntity();
    if (IllusionAbilities.isIllusionProjectile(entity)) {
      event.blockList().clear();
    }
  }

  @EventHandler(priority = EventPriority.HIGHEST)
  public void onIllusionProjectileHit(ProjectileHitEvent event) {
    Projectile projectile = event.getEntity();
    // A projectile only gets one stored-damage application.
    if (IllusionAbilities.hasAppliedProjectileDamage(projectile)) {
      return;
    }
    double damage = IllusionAbilities.projectileDamage(projectile);
    if (damage <= 0.0D) {
      return;
    }
    if (!(projectile.getShooter() instanceof Player player)) {
      return;
    }
    Entity hitEntity = event.getHitEntity();
    // Resolve a fake disguise shell to the player it represents.
    LivingEntity hit = IllusionDisguiseManager.disguiseOwner(hitEntity);
    if (hit == null && hitEntity instanceof LivingEntity living) {
      hit = living;
    }
    if (hit == null || !IllusionAbilities.isEnemy(player, hit)) {
      return;
    }
    if (hit instanceof Player target && !IllusionDisguiseManager.canBeHurt(target)) {
      return;
    }
    // Mark before damaging so a re-entrant hit cannot apply this twice, and so
    // the shell proxy knows this projectile's vanilla hit must not be forwarded.
    IllusionAbilities.consumeProjectileDamage(projectile);
    IllusionAbilities.markProjectileDamageApplied(projectile);
    // The projectile's own vanilla hit may have started damage i-frames, which
    // would swallow this stored damage. Clear them so the ability always lands.
    hit.setNoDamageTicks(0);
    hit.damage(damage, player);
  }

  @EventHandler(priority = EventPriority.LOWEST)
  public void onEvokerFangsDamage(EntityDamageByEntityEvent event) {
    if (!(event.getDamager() instanceof EvokerFangs fangs)) {
      return;
    }
    if (!(fangs.getOwner() instanceof Player player)) {
      return;
    }
    if (!IllusionDisguiseManager.isMobDisguise(player)
            || IllusionDisguiseManager.getDisguisedEntityType(player) != EntityType.EVOKER) {
      return;
    }
    event.setDamage(EntityDamageEvent.DamageModifier.BASE, IllusionConfig.evokerFangsDamage());
  }

  public static void useMobAbility(Player player, EntityType type) {
    if (player == null || !IllusionConfig.enabled()) {
      return;
    }
    if (!IllusionDisguiseManager.isDisguised(player)) {
      return;
    }
    if (CooldownManager.isOnCooldown(player.getUniqueId(), "mobAbility")) {
      int remaining = Math.max(1, CooldownManager.getRemainingSeconds(player.getUniqueId(), "mobAbility"));
      player.sendActionBar(Component.text("Ability on cooldown: " + remaining + "s", NamedTextColor.GRAY));
      return;
    }
    EntityType disguiseType = type != null ? type : IllusionDisguiseManager.getDisguisedEntityType(player);
    if (disguiseType == null) {
      return;
    }
    PiglinVariant variant = IllusionDisguiseManager.getPiglinVariant(player);
    IllusionAbilityFamily family = IllusionAbilityRegistry.family(disguiseType, variant);
    if (family.isPassive() || disguiseType == EntityType.PLAYER) {
      String message = disguiseType == EntityType.STRIDER
              ? "Lava Walk is always active (passive)."
              : "This disguise has no active ability.";
      player.sendActionBar(Component.text(message, NamedTextColor.GRAY));
      player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.2F);
      return;
    }
    if (!IllusionAbilities.activate(player, disguiseType, family)) {
      return;
    }
    int delay = IllusionAbilities.activationCooldownDelay(disguiseType, family);
    if (delay > 0) {
      // Multi-shot abilities lock briefly, then start the normal cooldown once
      // the last projectile has been fired.
      int lockSeconds = Math.max(1, (delay + 19) / 20);
      CooldownManager.setCooldown(player.getUniqueId(), "mobAbility", lockSeconds);
      BossBarManager.createBar(player, "Illusion Ability", lockSeconds, NamedTextColor.RED);
      IllusionDisguiseManager.sendDisguiseBar(player);
      Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
        if (player.isOnline() && IllusionDisguiseManager.isDisguised(player)) {
          startAbilityCooldown(player);
          IllusionDisguiseManager.sendDisguiseBar(player);
        }
      }, delay);
      return;
    }
    startAbilityCooldown(player);
    IllusionDisguiseManager.sendDisguiseBar(player);
  }
}
