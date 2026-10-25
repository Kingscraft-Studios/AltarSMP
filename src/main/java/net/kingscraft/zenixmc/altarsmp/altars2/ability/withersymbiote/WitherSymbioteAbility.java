package net.kingscraft.zenixmc.altarsmp.altars2.ability.withersymbiote;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.cooldown.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardHook;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public final class WitherSymbioteAbility {
  static final String INFECTION_COOLDOWN_KEY = "withersymbiote_infection";

  static final String RAMPAGE_COOLDOWN_KEY = "withersymbiote_rampage";

  private static final String INFECTION_BAR_TITLE = "Wither Infection";

  private static final String RAMPAGE_BAR_TITLE = "Rampage";

  private static final double RAMPAGE_EXIT_DAMAGE = 6.0;

  private static final Map<UUID, Long> armedCasters = new ConcurrentHashMap<>();

  private static final Map<UUID, InfectionState> infections = new ConcurrentHashMap<>();

  private static final Map<UUID, RampageState> rampages = new ConcurrentHashMap<>();

  private WitherSymbioteAbility() {
  }

  public static boolean infection(Player player) {
    UUID id = player.getUniqueId();
    InfectionState active = findInfectionByCaster(id);
    if (active != null) {
      if (active.incubating) {
        playDeny(player);
      } else {
        detonate(active);
      }
      return true;
    }
    if (isArmed(id) || isRampaging(id) || CooldownManager.isOnCooldown(id, INFECTION_COOLDOWN_KEY)) {
      playDeny(player);
      return true;
    }
    arm(player);
    return true;
  }

  public static boolean rampage(Player player) {
    UUID id = player.getUniqueId();
    if (isRampaging(id) || isArmed(id) || findInfectionByCaster(id) != null || CooldownManager.isOnCooldown(id, RAMPAGE_COOLDOWN_KEY)) {
      playDeny(player);
      return true;
    }
    startRampage(player);
    return true;
  }

  private static void arm(Player player) {
    int seconds = configInt("infection_time_to_infect", 10);
    armedCasters.put(player.getUniqueId(), System.currentTimeMillis() + seconds * 1000L);
    player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, seconds * 20, 0, true, false, true));
    Location loc = player.getLocation();
    World world = loc.getWorld();
    world.playSound(loc, Sound.ENTITY_WITHER_AMBIENT, 0.65F, 0.65F);
    spawnArmRing(loc.clone().add(0.0, 2.0, 0.0));
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> spawnArmRing(loc.clone().add(0.0, 2.0, 0.0)), 6L);
    BossBarManager.createBar(player, INFECTION_BAR_TITLE, seconds, ChatColor.GREEN);
  }

  private static void spawnArmRing(Location loc) {
    World world = loc.getWorld();
    if (world == null) {
      return;
    }
    for (int i = 0; i < 24; i++) {
      double angle = (Math.PI * 2) * i / 24;
      world.spawnParticle(Particle.SQUID_INK, loc, 1, Math.cos(angle) * 0.45, 0.02, Math.sin(angle) * 0.45, 0.02);
    }
  }

  static boolean isArmed(UUID id) {
    Long expiry = armedCasters.get(id);
    if (expiry == null) {
      return false;
    }
    if (expiry <= System.currentTimeMillis()) {
      armedCasters.remove(id);
      return false;
    }
    return true;
  }

  static boolean isRampaging(UUID id) {
    return rampages.containsKey(id);
  }

  static void infectTarget(Player damager, Player victim) {
    UUID casterId = damager.getUniqueId();
    UUID victimId = victim.getUniqueId();
    if (victimId.equals(casterId)) {
      return;
    }
    armedCasters.remove(casterId);
    BossBarManager.removeBar(damager, INFECTION_BAR_TITLE);
    int delayTicks = configInt("infection_delay", 1) * 20;
    int timeoutTicks = configInt("infection_time_before_timeout_detonate", 20) * 20;
    InfectionState state = new InfectionState(casterId, victimId, delayTicks, timeoutTicks);
    infections.put(victimId, state);
    applyInfectionEffects(victim, delayTicks + timeoutTicks);
    playInfectSound(victim);
    spawnInfectParticles(victim);
    BossBarManager.createBar(damager, INFECTION_BAR_TITLE, (delayTicks + timeoutTicks) / 20, ChatColor.GREEN);
    state.task = new BukkitRunnable() {
      @Override
      public void run() {
        tickInfection(state);
      }
    }.runTaskTimer(AltarSMP.getInstance(), 1L, 1L);
  }

  private static void tickInfection(InfectionState state) {
    InfectionState current = infections.get(state.victimId);
    if (current != state) {
      state.task.cancel();
      return;
    }
    Player caster = Bukkit.getPlayer(state.casterId);
    Player victim = Bukkit.getPlayer(state.victimId);
    if (caster == null || !caster.isOnline() || victim == null || !victim.isValid() || victim.isDead()) {
      clearInfection(state);
      return;
    }
    state.ticks++;
    if (state.incubating) {
      if (state.ticks >= state.delayTicks) {
        state.incubating = false;
        state.ticks = 0;
      }
      return;
    }
    if (state.ticks >= state.timeoutTicks) {
      detonate(state);
    }
  }

  private static void clearInfection(InfectionState state) {
    if (infections.get(state.victimId) == state) {
      infections.remove(state.victimId);
    }
    if (state.task != null) {
      state.task.cancel();
    }
    Player victim = Bukkit.getPlayer(state.victimId);
    if (victim != null) {
      removeInfectionEffects(victim);
    }
    Player caster = Bukkit.getPlayer(state.casterId);
    if (caster != null) {
      BossBarManager.removeBar(caster, INFECTION_BAR_TITLE);
    }
  }

  private static void detonate(InfectionState state) {
    if (infections.get(state.victimId) == state) {
      infections.remove(state.victimId);
    }
    if (state.task != null) {
      state.task.cancel();
    }
    Player victim = Bukkit.getPlayer(state.victimId);
    Player caster = Bukkit.getPlayer(state.casterId);
    if (victim == null || !victim.isValid() || victim.isDead()) {
      if (caster != null) {
        BossBarManager.removeBar(caster, INFECTION_BAR_TITLE);
      }
      return;
    }
    Location loc = victim.getLocation().add(0.0, Math.max(0.8, victim.getHeight()) * 0.55, 0.0);
    World world = loc.getWorld();
    world.playSound(loc, Sound.ENTITY_WITHER_HURT, 1.25F, 0.65F);
    world.playSound(loc, Sound.ENTITY_SQUID_SQUIRT, 1.35F, 0.55F);
    spawnDetonationRing(loc);
    removeInfectionEffects(victim);
    if (caster != null && caster.isOnline() && !WorldGuardHook.isBlocked(victim.getLocation())) {
      double damage = configDouble("infection_detonate_damage", 6.0D);
      victim.setNoDamageTicks(0);
      TrueDamage.apply(victim, damage, caster);
      victim.setNoDamageTicks(0);
    }
    if (caster != null && caster.isOnline()) {
      int cooldown = configInt("infection_cooldown", 40);
      CooldownManager.setCooldown(state.casterId, INFECTION_COOLDOWN_KEY, cooldown);
      BossBarManager.createBar(caster, INFECTION_BAR_TITLE, cooldown, ChatColor.YELLOW);
    }
  }

  private static void spawnDetonationRing(Location loc) {
    World world = loc.getWorld();
    if (world == null) {
      return;
    }
    for (int i = 0; i < 16; i++) {
      double angle = (Math.PI * 2) * i / 16;
      double x = Math.cos(angle) * 0.32;
      double z = Math.sin(angle) * 0.32;
      double y = 0.12 + i % 4 * 0.05;
      world.spawnParticle(Particle.SQUID_INK, loc, 0, x, y, z, 0.05);
    }
  }

  static void tryPassOn(Player damager, LivingEntity target) {
    InfectionState state = infections.get(damager.getUniqueId());
    if (state == null || state.incubating || !(target instanceof Player newVictim)) {
      return;
    }
    UUID newId = newVictim.getUniqueId();
    if (newId.equals(state.casterId) || newId.equals(state.victimId)) {
      return;
    }
    removeInfectionEffects(damager);
    infections.remove(state.victimId);
    state.victimId = newId;
    state.incubating = false;
    state.ticks = 0;
    infections.put(newId, state);
    applyInfectionEffects(newVictim, state.timeoutTicks);
    playInfectSound(newVictim);
    spawnInfectParticles(newVictim);
  }

  private static void applyInfectionEffects(LivingEntity entity, int durationTicks) {
    entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, durationTicks, 0, true, false, true));
    entity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, durationTicks, 0, true, false, true));
  }

  private static void removeInfectionEffects(LivingEntity entity) {
    entity.removePotionEffect(PotionEffectType.GLOWING);
    entity.removePotionEffect(PotionEffectType.WEAKNESS);
  }

  private static void playInfectSound(LivingEntity entity) {
    entity.getWorld().playSound(entity.getLocation(), Sound.ENTITY_WITHER_HURT, 1.0F, 0.75F);
  }

  private static void spawnInfectParticles(LivingEntity entity) {
    Location loc = entity.getLocation().add(0.0, Math.max(0.8, entity.getHeight()) * 0.55, 0.0);
    World world = loc.getWorld();
    if (world == null) {
      return;
    }
    world.spawnParticle(Particle.SQUID_INK, loc, 12, 0.25, 0.35, 0.25, 0.03);
    world.spawnParticle(Particle.SMOKE, loc, 3, 0.12, 0.18, 0.12, 0.01);
  }

  private static void startRampage(Player player) {
    UUID id = player.getUniqueId();
    int maxBars = configInt("rampage_max_bars", 50);
    int startBars = configInt("rampage_start_bars", 25);
    int interval = Math.max(1, configInt("rampage_bar_lose_interval", 5));
    int hungerAmp = configInt("rampage_hunger_amp", 1);
    double extraHealth = configDouble("rampage_extra_health", 6.0D);
    double speedMultiplier = configDouble("rampage_speed_multiplier", 1.5D);
    RampageState state = new RampageState(player, maxBars, interval, hungerAmp);
    state.bars = Math.max(0, Math.min(startBars, maxBars));
    NamespacedKey healthKey = new NamespacedKey(AltarSMP.getInstance(), "wither_symbiote_rampage_health");
    AttributeInstance healthAttr = player.getAttribute(Attribute.MAX_HEALTH);
    if (healthAttr != null) {
      healthAttr.addTransientModifier(new AttributeModifier(healthKey, extraHealth, Operation.ADD_NUMBER));
    }
    if (!player.isDead()) {
      player.setHealth(Math.min(player.getMaxHealth(), player.getHealth() + extraHealth));
    }
    NamespacedKey speedKey = new NamespacedKey(AltarSMP.getInstance(), "wither_symbiote_rampage_speed");
    AttributeInstance speedAttr = player.getAttribute(Attribute.MOVEMENT_SPEED);
    if (speedAttr != null) {
      speedAttr.addTransientModifier(new AttributeModifier(speedKey, speedMultiplier - 1.0D, Operation.ADD_SCALAR));
    }
    if (hungerAmp >= 0) {
      player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 100, hungerAmp, true, false, true));
    }
    player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 40, 0, true, false, true));
    Location loc = player.getLocation();
    World world = loc.getWorld();
    world.playSound(loc, Sound.ENTITY_WITHER_SPAWN, 0.55F, 1.65F);
    world.playSound(loc, Sound.ENTITY_SQUID_SQUIRT, 1.2F, 0.55F);
    spawnRampageRing(loc.clone().add(0.0, 1.0, 0.0));
    breakWebs(player);
    refreshRampageBar(state, player);
    updateRampageActionBar(state, player);
    rampages.put(id, state);
    state.task = new BukkitRunnable() {
      @Override
      public void run() {
        tickRampage(id);
      }
    }.runTaskTimer(AltarSMP.getInstance(), interval, interval);
  }

  private static void spawnRampageRing(Location loc) {
    World world = loc.getWorld();
    if (world == null) {
      return;
    }
    for (int i = 0; i < 32; i++) {
      double angle = (Math.PI * 2) * i / 32;
      double y = -0.12 + i % 9 * 0.04;
      world.spawnParticle(Particle.SQUID_INK, loc, 0, Math.cos(angle) * 0.42, y, Math.sin(angle) * 0.42, 0.8D);
    }
  }

  private static void tickRampage(UUID id) {
    RampageState state = rampages.get(id);
    if (state == null) {
      return;
    }
    Player player = Bukkit.getPlayer(id);
    if (player == null || !player.isOnline() || player.isDead()) {
      endRampage(id, false);
      return;
    }
    if (state.bars <= 0) {
      endRampage(id, true);
      return;
    }
    state.bars -= 1;
    state.ticks += state.interval;
    state.runs++;
    if (state.bars <= 0) {
      endRampage(id, true);
      return;
    }
    int websEvery = Math.max(1, 80 / state.interval);
    if (state.runs % websEvery == 0) {
      breakWebs(player);
    }
    if (state.hungerAmp >= 0) {
      int hungerEvery = Math.max(1, 100 / state.interval);
      if (state.runs % hungerEvery == 0) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 120, state.hungerAmp, true, false, true));
      }
    }
    updateRampageActionBar(state, player);
  }

  static void gainRampageBars(Player player) {
    RampageState state = rampages.get(player.getUniqueId());
    if (state == null) {
      return;
    }
    state.bars = Math.min(state.maxBars, state.bars + configInt("rampage_bars_gained_from_hit", 5));
    double lifesteal = configDouble("rampage_lifesteal_hp", 1.0D);
    if (lifesteal > 0.0D && !player.isDead()) {
      player.setHealth(Math.min(player.getMaxHealth(), player.getHealth() + lifesteal));
    }
    refreshRampageBar(state, player);
    updateRampageActionBar(state, player);
  }

  static void loseRampageBar(Player player) {
    RampageState state = rampages.get(player.getUniqueId());
    if (state == null) {
      return;
    }
    state.bars = Math.max(0, state.bars - 1);
    updateRampageActionBar(state, player);
  }

  private static void endRampage(UUID id, boolean applyNegatives) {
    RampageState state = rampages.remove(id);
    if (state == null) {
      return;
    }
    if (state.task != null) {
      state.task.cancel();
    }
    Player player = Bukkit.getPlayer(id);
    if (player == null) {
      return;
    }
    NamespacedKey speedKey = new NamespacedKey(AltarSMP.getInstance(), "wither_symbiote_rampage_speed");
    AttributeInstance speedAttr = player.getAttribute(Attribute.MOVEMENT_SPEED);
    if (speedAttr != null && speedAttr.getModifier(speedKey) != null) {
      speedAttr.removeModifier(speedKey);
    }
    NamespacedKey healthKey = new NamespacedKey(AltarSMP.getInstance(), "wither_symbiote_rampage_health");
    AttributeInstance healthAttr = player.getAttribute(Attribute.MAX_HEALTH);
    if (healthAttr != null) {
      if (healthAttr.getModifier(healthKey) != null) {
        healthAttr.removeModifier(healthKey);
      }
      if (state.originalMaxHealth >= 0.0D && Math.abs(healthAttr.getBaseValue() - state.originalMaxHealth) > 1.0E-6D) {
        healthAttr.setBaseValue(state.originalMaxHealth);
      }
      double maxHealth = healthAttr.getValue();
      if (player.getHealth() > maxHealth) {
        player.setHealth(Math.max(0.0D, maxHealth));
      }
    }
    if (player.getWalkSpeed() > state.originalWalkSpeed) {
      player.setWalkSpeed((float)state.originalWalkSpeed);
    }
    player.sendActionBar("");
    BossBarManager.removeBar(player, RAMPAGE_BAR_TITLE);
    if (!applyNegatives) {
      return;
    }
    int negativeSeconds = configInt("rampage_negatives_duration", 5);
    if (negativeSeconds > 0 && !player.isDead()) {
      Location loc = player.getLocation();
      World world = loc.getWorld();
      world.playSound(loc, Sound.ENTITY_WITHER_AMBIENT, 1.15F, 0.55F);
      world.playSound(loc, Sound.ENTITY_WITHER_HURT, 1.0F, 0.75F);
      int negativeTicks = negativeSeconds * 20;
      player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, negativeTicks, 1, true, false, true));
      player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, negativeTicks, 1, true, false, true));
      player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, negativeTicks, 1, true, false, true));
      player.setHealth(Math.max(1.0D, player.getHealth() - RAMPAGE_EXIT_DAMAGE));
    }
    int cooldown = configInt("rampage_cooldown", 120);
    CooldownManager.setCooldown(id, RAMPAGE_COOLDOWN_KEY, cooldown);
    BossBarManager.createBar(player, RAMPAGE_BAR_TITLE, cooldown, ChatColor.DARK_PURPLE);
  }

  private static void refreshRampageBar(RampageState state, Player player) {
    int seconds = Math.max(1, (int)Math.ceil(state.bars * state.interval / 20.0D));
    BossBarManager.createBar(player, RAMPAGE_BAR_TITLE, seconds, ChatColor.DARK_PURPLE);
  }

  private static void updateRampageActionBar(RampageState state, Player player) {
    player.sendActionBar(buildBars(state.bars, state.maxBars));
  }

  private static String buildBars(int bars, int max) {
    double fraction = max <= 0 ? 0.0D : bars / (double)max;
    int scaled = Math.clamp((int) Math.round(fraction * 40.0D), 0, 40);
    String color;
    if (fraction > 0.6D) {
      color = String.valueOf(ChatColor.GREEN);
    } else if (fraction > 0.4D) {
      color = String.valueOf(ChatColor.YELLOW);
    } else if (fraction > 0.2D) {
      color = String.valueOf(ChatColor.GOLD);
    } else {
      color = String.valueOf(ChatColor.RED);
    }
    int first = Math.min(scaled, 20);
    int second = Math.max(0, scaled - 20);
      return color +
              "|".repeat(first) +
              ChatColor.DARK_GRAY +
              "|".repeat(20 - first) +
              ChatColor.GRAY +
              "|" +
              color +
              "|".repeat(second) +
              ChatColor.DARK_GRAY +
              "|".repeat(20 - second);
  }

  private static void breakWebs(Player player) {
    World world = player.getWorld();
    Location loc = player.getLocation();
    int baseX = loc.getBlockX();
    int baseY = loc.getBlockY();
    int baseZ = loc.getBlockZ();
    for (int x = -2; x <= 2; x++) {
      for (int y = -2; y <= 2; y++) {
        for (int z = -2; z <= 2; z++) {
          if (x * x + y * y + z * z > 5.0625D) {
            continue;
          }
          if (world.getBlockAt(baseX + x, baseY + y, baseZ + z).getType() == Material.COBWEB) {
            world.getBlockAt(baseX + x, baseY + y, baseZ + z).setType(Material.AIR, false);
          }
        }
      }
    }
  }

  static void handleQuit(Player player) {
    UUID id = player.getUniqueId();
    armedCasters.remove(id);
    InfectionState asVictim = infections.get(id);
    if (asVictim != null) {
      clearInfection(asVictim);
    }
    InfectionState asCaster = findInfectionByCaster(id);
    if (asCaster != null) {
      clearInfection(asCaster);
    }
    endRampage(id, false);
  }

  static void handleJoin(Player player) {
    int infectionRemaining = CooldownManager.getRemainingSeconds(player.getUniqueId(), INFECTION_COOLDOWN_KEY);
    if (infectionRemaining > 0) {
      BossBarManager.createBar(player, INFECTION_BAR_TITLE, infectionRemaining, ChatColor.YELLOW);
    }
    int rampageRemaining = CooldownManager.getRemainingSeconds(player.getUniqueId(), RAMPAGE_COOLDOWN_KEY);
    if (rampageRemaining > 0) {
      BossBarManager.createBar(player, RAMPAGE_BAR_TITLE, rampageRemaining, ChatColor.DARK_PURPLE);
    }
  }

  private static InfectionState findInfectionByCaster(UUID casterId) {
    for (InfectionState state : infections.values()) {
      if (state.casterId.equals(casterId)) {
        return state;
      }
    }
    return null;
  }

  private static void playDeny(Player player) {
    player.getWorld().playSound(player.getLocation(), "altar:tick", 1.0F, 0.7F);
  }

  private static int configInt(String key, int def) {
    return AltarSMP.getInstance().getConfig().getInt("withersymbiote." + key, def);
  }

  private static double configDouble(String key, double def) {
    return AltarSMP.getInstance().getConfig().getDouble("withersymbiote." + key, def);
  }

  static final class InfectionState {
    final UUID casterId;
    final int delayTicks;
    final int timeoutTicks;
    UUID victimId;
    boolean incubating = true;
    int ticks;
    BukkitTask task;

    InfectionState(UUID casterId, UUID victimId, int delayTicks, int timeoutTicks) {
      this.casterId = casterId;
      this.victimId = victimId;
      this.delayTicks = delayTicks;
      this.timeoutTicks = timeoutTicks;
    }
  }

  static final class RampageState {
    final UUID playerId;
    final int maxBars;
    final int interval;
    final int hungerAmp;
    final double originalMaxHealth;
    final double originalWalkSpeed;
    int bars;
    int ticks;
    int runs;
    BukkitTask task;

    RampageState(Player player, int maxBars, int interval, int hungerAmp) {
      this.playerId = player.getUniqueId();
      this.maxBars = maxBars;
      this.interval = interval;
      this.hungerAmp = hungerAmp;
      this.originalWalkSpeed = player.getWalkSpeed();
      AttributeInstance healthAttr = player.getAttribute(Attribute.MAX_HEALTH);
      this.originalMaxHealth = healthAttr != null ? healthAttr.getBaseValue() : -1.0D;
    }
  }
}
