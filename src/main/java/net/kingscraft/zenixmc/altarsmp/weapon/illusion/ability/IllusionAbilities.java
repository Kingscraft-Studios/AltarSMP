package net.kingscraft.zenixmc.altarsmp.weapon.illusion.ability;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.DisguiseEntityTask;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.IllusionDisguiseManager;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.util.IllusionConfig;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.util.IllusionVisuals;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.EvokerFangs;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.LlamaSpit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.entity.SmallFireball;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.entity.Trident;
import org.bukkit.entity.WindCharge;
import org.bukkit.entity.WitherSkull;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.util.Vector;

/**
 * The ability implementations behind every {@link IllusionAbilityFamily}.
 * Everything uses vanilla particles and sounds.
 */
public final class IllusionAbilities {

  private IllusionAbilities() {
  }

  public static boolean activate(Player player, EntityType type) {
    IllusionAbilityFamily family = IllusionAbilityRegistry.family(type);
    if (family.isPassive() || type == EntityType.PLAYER) {
      return false;
    }
    if (IllusionConfig.castAnimation()) {
      IllusionDisguiseManager.playCastAnimation(player, type);
    }
    switch (family) {
      case FIREBALL -> fireball(player, type);
      case EXPLODE -> explode(player);
      case TELEPORT -> teleport(player);
      case SONIC_BOOM -> sonicBoomCharge(player);
      case WITHER_SKULL -> witherSkulls(player);
      case POISON_BITE -> poisonBite(player, type);
      case ARROW_VOLLEY -> arrowVolley(player, type);
      case TRIDENT -> trident(player);
      case MELEE_BURST -> meleeBurst(player, type);
      case CHARGE -> charge(player, type);
      case SUMMON_FANGS -> summonFangs(player);
      case HEX -> hex(player, type);
      case LEVITATE -> levitate(player);
      case LASER -> laser(player, type);
      case WIND_CHARGE -> windBurst(player);
      case LEAP -> leap(player, type);
      case INK -> inkCloud(player, type);
      case SNOWBALL -> snowballVolley(player);
      case SPIT -> spit(player);
      case FLY_DASH -> flyDash(player, type);
      case SLAM -> slam(player, type);
      case STAMPEDE -> stampede(player, type);
      case FEATHER -> feather(player);
      case GUARD -> guard(player, type);
      case HEAL -> heal(player, type);
      case AQUATIC_DASH -> aquaticDash(player);
      case SNIFF -> sniff(player);
      case TRADE -> trade(player);
      default -> {
        return false;
      }
    }
    return true;
  }

  public static String displayName(EntityType type) {
    return IllusionAbilityRegistry.family(type).displayName();
  }

  /** True while the player is still disguised and alive, used by delayed tasks. */
  public static boolean isStillActive(Player player) {
    return player != null && player.isOnline() && !player.isDead()
            && IllusionDisguiseManager.isDisguised(player);
  }

  public static boolean isIllusionProjectile(Entity entity) {
    if (entity == null) {
      return false;
    }
    return entity.getPersistentDataContainer().has(projectileKey(), PersistentDataType.BYTE);
  }

  private static void tag(Entity entity) {
    if (entity != null) {
      entity.getPersistentDataContainer().set(projectileKey(), PersistentDataType.BYTE, (byte) 1);
    }
  }

  private static NamespacedKey projectileKey() {
    return new NamespacedKey(AltarSMP.getInstance(), "illusion_projectile");
  }

  private static NamespacedKey projectileDamageKey() {
    return new NamespacedKey(AltarSMP.getInstance(), "illusion_projectile_damage");
  }

  /**
   * Projectiles that cannot carry a damage value themselves (snowball, egg,
   * llama spit, wind charge, small fireball, shulker bullet) store one here and
   * the {@code ProjectileHitEvent} handler applies it. Arrows and tridents use
   * their own damage field instead.
   */
  private static void setProjectileDamage(Projectile projectile, double damage) {
    if (projectile == null) {
      return;
    }
    tag(projectile);
    projectile.getPersistentDataContainer().set(projectileDamageKey(), PersistentDataType.DOUBLE, damage);
  }

  public static double projectileDamage(Entity projectile) {
    if (projectile == null) {
      return 0.0D;
    }
    Double value = projectile.getPersistentDataContainer().get(projectileDamageKey(), PersistentDataType.DOUBLE);
    return value == null ? 0.0D : value;
  }

  public static void consumeProjectileDamage(Entity projectile) {
    if (projectile != null) {
      projectile.getPersistentDataContainer().remove(projectileDamageKey());
    }
  }

  private static void scheduleDespawn(Entity entity, long ticks) {
    if (entity == null) {
      return;
    }
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), entity::remove, ticks);
  }

  private static double scaled(double base) {
    return base * IllusionConfig.abilityDamageScale();
  }

  // ------------------------------------------------------------------
  // Fire
  // ------------------------------------------------------------------

  private static void fireball(Player player, EntityType type) {
    Vector direction = player.getEyeLocation().getDirection().normalize();
    double strength = IllusionConfig.fireballStrength();
    if (type == EntityType.GHAST || type == EntityType.HAPPY_GHAST) {
      LargeFireball fireball = player.launchProjectile(LargeFireball.class);
      tag(fireball);
      fireball.setYield(3.0F);
      fireball.setIsIncendiary(false);
      fireball.setVelocity(direction.multiply(strength * 0.75D));
      IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_GHAST_SHOOT, 1.0F, 1.0F);
      IllusionVisuals.muzzle(player, Particle.LAVA);
    } else {
      SmallFireball fireball = player.launchProjectile(SmallFireball.class);
      fireball.setYield(1.0F);
      fireball.setIsIncendiary(false);
      setProjectileDamage(fireball, scaled(3.0D));
      fireball.setVelocity(direction.multiply(strength));
      IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F);
      IllusionVisuals.muzzle(player, Particle.FLAME);
    }
    IllusionVisuals.burst(player.getEyeLocation(), Particle.SMALL_FLAME, 8, 0.25D);
  }

  private static void explode(Player player) {
    Location origin = player.getLocation().clone();
    player.getWorld().playSound(origin, Sound.ENTITY_CREEPER_PRIMED, 1.0F, 1.0F);
    IllusionVisuals.burst(origin.clone().add(0.0D, 1.0D, 0.0D), Particle.SMOKE, 30, 0.7D);
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      if (!isStillActive(player)) {
        return;
      }
      Location location = player.getLocation();
      World world = location.getWorld();
      world.playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
      world.spawnParticle(Particle.EXPLOSION_EMITTER, location, 1);
      world.createExplosion(player, location, (float) IllusionConfig.creeperExplosionStrength(),
              false, false, true);
    }, 20L);
  }

  private static void witherSkulls(Player player) {
    Vector direction = player.getEyeLocation().getDirection().normalize();
    for (int offset = -1; offset <= 1; offset++) {
      WitherSkull skull = player.launchProjectile(WitherSkull.class);
      tag(skull);
      skull.setCharged(false);
      skull.setYield(1.5F);
      skull.setVelocity(direction.clone().rotateAroundY(Math.toRadians(offset * 12.0D)).multiply(1.7D));
    }
    IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1.0F, 1.0F);
    IllusionVisuals.muzzle(player, Particle.SOUL_FIRE_FLAME);
  }

  // ------------------------------------------------------------------
  // Movement
  // ------------------------------------------------------------------

  private static void teleport(Player player) {
    Location origin = player.getLocation().clone();
    Block block = player.getTargetBlockExact(30);
    Location destination;
    if (block == null) {
      destination = origin.clone().add(origin.getDirection().normalize().multiply(8.0D));
    } else if (block.getType().isAir()) {
      destination = block.getLocation().add(0.5D, 0.0D, 0.5D);
    } else {
      destination = block.getLocation().add(0.5D, 1.0D, 0.5D);
    }
    IllusionVisuals.burst(origin.clone().add(0.0D, 1.0D, 0.0D), Particle.PORTAL, 40, 0.5D);
    IllusionVisuals.sound(origin, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
    player.teleport(destination);
    IllusionVisuals.burst(destination.clone().add(0.0D, 1.0D, 0.0D), Particle.PORTAL, 40, 0.5D);
    IllusionVisuals.sound(destination, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 0.8F);
  }

  private static void sonicBoomCharge(Player player) {
    Location eye = player.getEyeLocation().clone();
    Vector direction = eye.getDirection().normalize();
    Location end = eye.clone().add(direction.clone().multiply(15.0D));
    for (double travelled = 0.5D; travelled <= 15.0D; travelled += 0.5D) {
      Location point = eye.clone().add(direction.clone().multiply(travelled));
      if (point.getBlock().getType().isSolid()) {
        end = point;
        break;
      }
    }
    double distance = eye.distance(end);
    IllusionVisuals.sound(eye, Sound.ENTITY_WARDEN_SONIC_CHARGE, 2.0F, 1.0F);
    IllusionVisuals.burst(eye, Particle.SCULK_SOUL, 12, 0.2D);
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(),
            () -> sonicBoom(player, eye, direction, distance), 20L);
  }

  private static void sonicBoom(Player player, Location start, Vector direction, double distance) {
    if (!isStillActive(player)) {
      return;
    }
    World world = player.getWorld();
    world.playSound(start, Sound.ENTITY_WARDEN_SONIC_BOOM, 3.0F, 1.0F);
    Set<UUID> hit = new HashSet<>();
    for (double travelled = 0.0D; travelled <= distance; travelled += 0.3D) {
      Location point = start.clone().add(direction.clone().multiply(travelled));
      world.spawnParticle(Particle.SONIC_BOOM, point, 1, 0.0D, 0.0D, 0.0D, 0.0D);
      for (Entity entity : world.getNearbyEntities(point, 1.2D, 1.2D, 1.2D)) {
        if (!(entity instanceof LivingEntity living) || !isEnemy(player, living)) {
          continue;
        }
        if (hit.add(living.getUniqueId())) {
          // Sonic Boom is fixed true damage: it bypasses armour and shields.
          TrueDamage.apply(living, IllusionConfig.sonicBoomDamage(), player, true);
          Vector push = direction.clone().multiply(1.5D);
          push.setY(0.4D);
          living.setVelocity(push);
        }
      }
    }
  }

  private static void windBurst(Player player) {
    Vector direction = player.getEyeLocation().getDirection().normalize();
    WindCharge charge = player.launchProjectile(WindCharge.class);
    setProjectileDamage(charge, scaled(4.0D));
    charge.setVelocity(direction.multiply(1.6D));
    player.setVelocity(player.getVelocity().add(new Vector(0.0D, 0.55D, 0.0D)));
    IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_BREEZE_SHOOT, 1.0F, 1.0F);
    IllusionVisuals.muzzle(player, Particle.GUST);
  }

  private static void leap(Player player, EntityType type) {
    Vector direction = horizontalDirection(player);
    player.setVelocity(direction.multiply(0.9D).setY(0.9D));
    Sound sound = switch (type) {
      case MAGMA_CUBE -> Sound.ENTITY_MAGMA_CUBE_JUMP;
      case RABBIT -> Sound.ENTITY_RABBIT_JUMP;
      case FROG -> Sound.ENTITY_FROG_LONG_JUMP;
      case CAT -> Sound.ENTITY_CAT_PURR;
      case OCELOT -> Sound.ENTITY_OCELOT_AMBIENT;
      default -> Sound.ENTITY_SLIME_JUMP;
    };
    IllusionVisuals.sound(player.getLocation(), sound, 1.0F, 1.0F);
    Particle particle = type == EntityType.MAGMA_CUBE ? Particle.LAVA : Particle.ITEM_SLIME;
    IllusionVisuals.burst(player.getLocation(), particle, 15, 0.4D);
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      if (!isStillActive(player)) {
        return;
      }
      damageNearby(player, player.getLocation(), 4.0D, scaled(5.0D), living -> {
        if (type == EntityType.MAGMA_CUBE) {
          living.setFireTicks(Math.max(living.getFireTicks(), 60));
        }
      }, 0.35D);
      IllusionVisuals.sound(player.getLocation(), sound, 1.0F, 0.8F);
    }, 10L);
  }

  private static void flyDash(Player player, EntityType type) {
    Vector direction = player.getEyeLocation().getDirection().normalize();
    player.setVelocity(direction.multiply(1.4D).add(new Vector(0.0D, 0.3D, 0.0D)));
    Particle particle = switch (type) {
      case VEX -> Particle.SOUL;
      case PHANTOM -> Particle.ASH;
      case BEE -> Particle.CRIT;
      default -> Particle.CLOUD;
    };
    IllusionVisuals.dashTrail(player, particle);
    IllusionVisuals.sound(player.getLocation(), dashSound(type), 1.0F, 1.0F);
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      if (!isStillActive(player)) {
        return;
      }
      damageNearby(player, player.getLocation(), 3.0D, scaled(dashDamage(type)), null, 0.25D);
    }, 3L);
  }

  // ------------------------------------------------------------------
  // Ranged
  // ------------------------------------------------------------------

  private static void poisonBite(Player player, EntityType type) {
    LivingEntity target = target(player, 4.5D);
    Particle particle = type == EntityType.CAVE_SPIDER ? Particle.ITEM_COBWEB : Particle.ITEM_SLIME;
    if (target != null) {
      target.damage(scaled(type == EntityType.CAVE_SPIDER ? 6.0D : 5.0D), player);
      target.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
              100, type == EntityType.CAVE_SPIDER ? 1 : 0));
      if (type == EntityType.CAVE_SPIDER) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 80, 1));
      }
      IllusionVisuals.burst(target.getLocation().add(0.0D, 1.0D, 0.0D), particle, 20, 0.5D);
    } else {
      damageNearby(player, player.getLocation(), 3.5D, scaled(4.0D), living ->
              living.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 0)), 0.0D);
      IllusionVisuals.ring(player.getLocation(), particle, 18, 2.5D);
    }
    IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_SPIDER_HURT, 1.0F, 0.8F);
  }

  private static void arrowVolley(Player player, EntityType type) {
    Vector base = player.getEyeLocation().getDirection().normalize().multiply(2.2D);
    for (int offset = -1; offset <= 1; offset++) {
      Arrow arrow = player.launchProjectile(Arrow.class);
      tag(arrow);
      arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
      arrow.setDamage(scaled(5.0D));
      arrow.setVelocity(base.clone().rotateAroundY(Math.toRadians(offset * 6.0D))
              .add(new Vector(0.0D, 0.04D, 0.0D)));
      scheduleDespawn(arrow, 200L);
      switch (type) {
        case STRAY -> arrow.addCustomEffect(new PotionEffect(PotionEffectType.SLOWNESS, 100, 0), true);
        case BOGGED -> arrow.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 100, 0), true);
        case PARCHED -> arrow.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 120, 0), true);
        default -> {
        }
      }
    }
    IllusionVisuals.sound(player.getLocation(),
            type == EntityType.PILLAGER ? Sound.ITEM_CROSSBOW_SHOOT : Sound.ENTITY_ARROW_SHOOT, 1.0F, 1.0F);
    IllusionVisuals.muzzle(player, Particle.CRIT);
  }

  private static void trident(Player player) {
    Trident trident = player.launchProjectile(Trident.class);
    tag(trident);
    trident.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
    trident.setDamage(scaled(8.0D));
    trident.setVelocity(player.getEyeLocation().getDirection().normalize().multiply(1.8D));
    scheduleDespawn(trident, 200L);
    IllusionVisuals.sound(player.getLocation(), Sound.ITEM_TRIDENT_THROW, 1.0F, 1.0F);
    IllusionVisuals.muzzle(player, Particle.BUBBLE);
  }

  private static void laser(Player player, EntityType type) {
    LivingEntity target = target(player, 20.0D);
    if (target == null) {
      IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_GUARDIAN_ATTACK, 1.0F, 0.6F);
      return;
    }
    Location from = player.getEyeLocation().clone();
    Location to = target.getEyeLocation().clone();
    IllusionVisuals.line(from, to, Particle.END_ROD, 0.35D);
    IllusionVisuals.sound(from, Sound.ENTITY_GUARDIAN_ATTACK, 1.0F, 1.0F);
    long delay = type == EntityType.ELDER_GUARDIAN ? 25L : 15L;
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      if (!isStillActive(player) || !target.isValid() || target.isDead()) {
        return;
      }
      IllusionVisuals.line(from, target.getEyeLocation(), Particle.ELECTRIC_SPARK, 0.35D);
      target.damage(scaled(type == EntityType.ELDER_GUARDIAN ? 11.0D : 8.0D), player);
      if (type == EntityType.ELDER_GUARDIAN) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 200, 2));
        IllusionVisuals.sound(from, Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1.0F, 1.0F);
      }
    }, delay);
  }

  private static void levitate(Player player) {
    LivingEntity target = target(player, 20.0D);
    if (target != null) {
      ShulkerBullet bullet = player.launchProjectile(ShulkerBullet.class);
      setProjectileDamage(bullet, scaled(3.0D));
      bullet.setTarget(target);
      bullet.setVelocity(player.getEyeLocation().getDirection().normalize().multiply(1.2D));
    }
    IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_SHULKER_SHOOT, 1.0F, 1.0F);
    IllusionVisuals.muzzle(player, Particle.END_ROD);
  }

  private static void snowballVolley(Player player) {
    Vector base = player.getEyeLocation().getDirection().normalize().multiply(1.9D);
    for (int offset = -2; offset <= 2; offset++) {
      Snowball snowball = player.launchProjectile(Snowball.class);
      setProjectileDamage(snowball, scaled(3.0D));
      snowball.setVelocity(base.clone().rotateAroundY(Math.toRadians(offset * 5.0D))
              .add(new Vector(0.0D, 0.03D, 0.0D)));
    }
    IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 1.0F);
    IllusionVisuals.muzzle(player, Particle.ITEM_SNOWBALL);
  }

  private static void spit(Player player) {
    LlamaSpit spit = player.launchProjectile(LlamaSpit.class);
    setProjectileDamage(spit, scaled(4.0D));
    spit.setVelocity(player.getEyeLocation().getDirection().normalize().multiply(1.4D));
    IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_LLAMA_SPIT, 1.0F, 1.0F);
    IllusionVisuals.muzzle(player, Particle.SPIT);
  }

  // ------------------------------------------------------------------
  // Melee
  // ------------------------------------------------------------------

  private static void meleeBurst(Player player, EntityType type) {
    Vector direction = horizontalDirection(player);
    player.setVelocity(player.getVelocity().add(direction.multiply(0.75D)).setY(0.18D));
    double damage = switch (type) {
      case WITHER_SKELETON -> 10.0D;
      case VINDICATOR, PIGLIN_BRUTE, POLAR_BEAR -> 9.0D;
      case WOLF, FOX, PANDA -> 7.0D;
      default -> 8.0D;
    };
    IllusionVisuals.sound(player.getLocation(), meleeSound(type), 1.0F, 1.0F);
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      if (!isStillActive(player)) {
        return;
      }
      IllusionVisuals.burst(player.getLocation().add(0.0D, 1.0D, 0.0D), Particle.SWEEP_ATTACK, 6, 0.8D);
      damageNearby(player, player.getLocation(), 3.5D, scaled(damage), living -> {
        switch (type) {
          case WITHER_SKELETON -> living.addPotionEffect(
                  new PotionEffect(PotionEffectType.WITHER, 100, 0));
          case HUSK -> living.addPotionEffect(
                  new PotionEffect(PotionEffectType.HUNGER, 120, 0));
          case WOLF -> living.addPotionEffect(
                  new PotionEffect(PotionEffectType.SLOWNESS, 60, 0));
          default -> {
          }
        }
      }, 0.25D);
    }, 2L);
  }

  private static void charge(Player player, EntityType type) {
    Vector direction = horizontalDirection(player);
    player.setVelocity(direction.multiply(1.35D).setY(0.25D));
    IllusionVisuals.sound(player.getLocation(), chargeSound(type), 1.0F, 1.0F);
    Particle particle = switch (type) {
      case GOAT -> Particle.CRIT;
      case CAMEL, CAMEL_HUSK -> Particle.CLOUD;
      default -> Particle.SMOKE;
    };
    IllusionVisuals.dashTrail(player, particle);
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      if (!isStillActive(player)) {
        return;
      }
      damageNearby(player, player.getLocation(), 3.2D, scaled(10.0D), null, 0.55D);
      IllusionVisuals.sound(player.getLocation(), chargeImpactSound(type), 1.0F, 1.0F);
    }, 4L);
  }

  private static void slam(Player player, EntityType type) {
    Location origin = player.getLocation().clone();
    player.setVelocity(new Vector(0.0D, 0.55D, 0.0D));
    IllusionVisuals.sound(origin, Sound.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 0.7F);
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      if (!isStillActive(player)) {
        return;
      }
      Location location = player.getLocation();
      World world = location.getWorld();
      world.spawnParticle(Particle.CLOUD, location, 35, 1.6D, 0.2D, 1.6D, 0.08D);
      world.spawnParticle(Particle.CRIT, location, 20, 1.2D, 0.2D, 1.2D, 0.08D);
      world.playSound(location, Sound.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 0.8F);
      damageNearby(player, location, 4.5D, scaled(type == EntityType.COPPER_GOLEM ? 7.0D : 9.0D), null, 0.7D);
    }, 8L);
  }

  private static void stampede(Player player, EntityType type) {
    Vector direction = horizontalDirection(player);
    player.setVelocity(direction.multiply(1.15D).setY(0.2D));
    Sound sound = switch (type) {
      case PIG -> Sound.ENTITY_PIG_AMBIENT;
      case SHEEP -> Sound.ENTITY_SHEEP_AMBIENT;
      default -> Sound.ENTITY_COW_AMBIENT;
    };
    IllusionVisuals.sound(player.getLocation(), sound, 1.0F, 0.8F);
    IllusionVisuals.burst(player.getLocation(), Particle.CLOUD, 18, 0.6D);
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      if (!isStillActive(player)) {
        return;
      }
      damageNearby(player, player.getLocation(), 3.0D, scaled(5.0D), null, 0.4D);
      IllusionVisuals.sound(player.getLocation(), sound, 1.0F, 1.0F);
    }, 4L);
  }

  // ------------------------------------------------------------------
  // Support / utility
  // ------------------------------------------------------------------

  private static void feather(Player player) {
    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,
            200, 0, true, false, false));
    Vector base = player.getEyeLocation().getDirection().normalize().multiply(1.6D);
    for (int offset = -1; offset <= 1; offset++) {
      Egg egg = player.launchProjectile(Egg.class);
      setProjectileDamage(egg, scaled(3.0D));
      egg.setVelocity(base.clone().rotateAroundY(Math.toRadians(offset * 8.0D)));
    }
    IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.0F, 1.0F);
    IllusionVisuals.muzzle(player, Particle.CLOUD);
  }

  private static void guard(Player player, EntityType type) {
    player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE,
            100, 1, true, false, false));
    Sound sound = type == EntityType.ARMADILLO
            ? Sound.ENTITY_ARMADILLO_ROLL : Sound.ENTITY_TURTLE_AMBIENT_LAND;
    IllusionVisuals.sound(player.getLocation(), sound, 1.0F, 1.0F);
    IllusionVisuals.burst(player.getLocation().add(0.0D, 1.0D, 0.0D), Particle.CRIT, 20, 0.6D);
  }

  private static void heal(Player player, EntityType type) {
    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,
            80, 1, true, false, false));
    AttributeInstance health = player.getAttribute(Attribute.MAX_HEALTH);
    if (health != null) {
      player.setHealth(Math.min(health.getValue(), player.getHealth() + 4.0D));
    }
    Sound sound = type == EntityType.AXOLOTL
            ? Sound.ENTITY_AXOLOTL_SPLASH : Sound.ENTITY_MOOSHROOM_MILK;
    IllusionVisuals.sound(player.getLocation(), sound, 1.0F, 1.0F);
    IllusionVisuals.burst(player.getLocation().add(0.0D, 1.0D, 0.0D), Particle.HEART, 12, 0.7D);
  }

  private static void aquaticDash(Player player) {
    Vector direction = player.getEyeLocation().getDirection().normalize();
    player.setVelocity(direction.multiply(1.5D));
    player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE,
            80, 0, true, false, false));
    player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,
            120, 0, true, false, false));
    IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_DOLPHIN_JUMP, 1.0F, 1.0F);
    IllusionVisuals.burst(player.getLocation(), Particle.BUBBLE, 30, 0.6D);
  }

  private static void sniff(Player player) {
    for (Entity entity : player.getNearbyEntities(12.0D, 8.0D, 12.0D)) {
      if (entity instanceof LivingEntity living && isEnemy(player, living)) {
        living.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,
                140, 0, true, false, false));
      }
    }
    IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_SNIFFER_SNIFFING, 1.0F, 1.0F);
    IllusionVisuals.burst(player.getLocation().add(0.0D, 1.0D, 0.0D), Particle.COMPOSTER, 30, 1.0D);
  }

  private static void trade(Player player) {
    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
            120, 0, true, false, false));
    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,
            80, 0, true, false, false));
    IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 1.0F, 1.0F);
    IllusionVisuals.burst(player.getLocation().add(0.0D, 1.0D, 0.0D), Particle.HAPPY_VILLAGER, 25, 0.8D);
  }

  // ------------------------------------------------------------------
  // Magic / utility
  // ------------------------------------------------------------------

  private static void summonFangs(Player player) {
    LivingEntity target = target(player, 20.0D);
    Block targetBlock = player.getTargetBlockExact(15);
    Location center;
    if (target != null) {
      center = target.getLocation();
    } else if (targetBlock != null) {
      center = targetBlock.getLocation().add(0.5D, 0.0D, 0.5D);
    } else {
      center = player.getLocation();
    }
    World world = player.getWorld();
    world.playSound(center, Sound.ENTITY_EVOKER_PREPARE_ATTACK, 1.0F, 1.0F);
    IllusionVisuals.burst(center.clone().add(0.0D, 0.5D, 0.0D), Particle.WITCH, 30, 1.2D);
    // Let the fake Evoker finish raising its arms before the fangs erupt.
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      if (!isStillActive(player) || !player.getWorld().equals(world)) {
        return;
      }
      for (int i = 0; i < 6; i++) {
        double angle = (Math.PI * 2.0D / 6.0D) * i;
        Location location = center.clone().add(Math.cos(angle) * 1.6D, 0.0D, Math.sin(angle) * 1.6D);
        world.spawn(location, EvokerFangs.class, fangs -> {
          fangs.setOwner(player);
          fangs.setAttackDelay(4 + (int) (Math.random() * 4));
        });
      }
      world.playSound(center, Sound.ENTITY_EVOKER_CAST_SPELL, 1.0F, 1.0F);
    }, 12L);
  }

  private static void hex(Player player, EntityType type) {
    LivingEntity target = target(player, 15.0D);
    Location center = target != null ? target.getLocation() : player.getLocation();
    if (type == EntityType.WITCH) {
      ThrownPotion potion = player.launchProjectile(ThrownPotion.class);
      tag(potion);
      ItemStack item = new ItemStack(Material.SPLASH_POTION);
      PotionMeta meta = (PotionMeta) item.getItemMeta();
      if (meta != null) {
        meta.setBasePotionType(PotionType.POISON);
        item.setItemMeta(meta);
      }
      potion.setItem(item);
      potion.setVelocity(player.getEyeLocation().getDirection().normalize().multiply(0.9D));
      IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_WITCH_THROW, 1.0F, 1.0F);
    } else {
      IllusionVisuals.sound(player.getLocation(), Sound.ENTITY_ILLUSIONER_PREPARE_BLINDNESS, 1.0F, 1.0F);
    }
    for (Entity entity : center.getWorld().getNearbyEntities(center, 5.0D, 5.0D, 5.0D)) {
      if (!(entity instanceof LivingEntity living) || !isEnemy(player, living)) {
        continue;
      }
      living.damage(scaled(5.0D), player);
      living.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 120, 0));
      living.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 100, 1));
      living.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 0));
    }
    IllusionVisuals.burst(center.clone().add(0.0D, 1.0D, 0.0D), Particle.WITCH, 35, 1.3D);
  }

  private static void inkCloud(Player player, EntityType type) {
    Particle particle = type == EntityType.GLOW_SQUID
            ? Particle.GLOW_SQUID_INK : Particle.SQUID_INK;
    IllusionVisuals.burst(player.getLocation().add(0.0D, 1.0D, 0.0D), particle, 50, 1.5D);
    IllusionVisuals.sound(player.getLocation(),
            type == EntityType.GLOW_SQUID ? Sound.ENTITY_GLOW_SQUID_SQUIRT : Sound.ENTITY_SQUID_SQUIRT,
            1.0F, 1.0F);
    for (Entity entity : player.getNearbyEntities(6.0D, 6.0D, 6.0D)) {
      if (!(entity instanceof LivingEntity living) || !isEnemy(player, living)) {
        continue;
      }
      living.damage(scaled(3.0D), player);
      living.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 140, 0));
      living.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 100, 1));
    }
  }

  // ------------------------------------------------------------------
  // Helpers
  // ------------------------------------------------------------------

  private static LivingEntity target(Player player, double range) {
    Entity entity = player.getTargetEntity((int) Math.ceil(range));
    // Aiming at a disguise shell should treat the hit as that player.
    Player shellOwner = IllusionDisguiseManager.disguiseOwner(entity);
    if (shellOwner != null) {
      entity = shellOwner;
    }
    return entity instanceof LivingEntity living && isEnemy(player, living) ? living : null;
  }

  public static boolean isEnemy(Player player, LivingEntity entity) {
    if (entity.equals(player) || entity.isDead() || entity instanceof ArmorStand) {
      return false;
    }
    // Fake disguise shells are visual only. Damaging them would route a second
    // hit to the same owner, who is already a real entity in range.
    if (IllusionDisguiseManager.disguisedEntityOwners.containsKey(entity.getUniqueId())) {
      return false;
    }
    DisguiseEntityTask own = IllusionDisguiseManager.activeDisguises.get(player.getUniqueId());
    if (own != null && own.entity() != null && own.entity().equals(entity)) {
      return false;
    }
    if (entity instanceof Player other) {
      GameMode mode = other.getGameMode();
      return mode != GameMode.CREATIVE && mode != GameMode.SPECTATOR;
    }
    return true;
  }

  private static void damageNearby(Player player, Location center, double radius, double damage,
                                   Consumer<LivingEntity> extra, double knockUp) {
    World world = center.getWorld();
    if (world == null) {
      return;
    }
    for (Entity entity : world.getNearbyEntities(center, radius, radius, radius)) {
      if (!(entity instanceof LivingEntity living) || !isEnemy(player, living)) {
        continue;
      }
      living.damage(damage, player);
      if (extra != null) {
        extra.accept(living);
      }
      if (knockUp > 0.0D) {
        Vector push = living.getLocation().toVector().subtract(center.toVector());
        if (push.lengthSquared() > 0.001D) {
          push.normalize().multiply(0.5D);
        } else {
          push = new Vector(0.0D, 0.0D, 0.0D);
        }
        push.setY(knockUp);
        living.setVelocity(push);
      }
    }
  }

  private static Vector horizontalDirection(Player player) {
    Vector direction = player.getLocation().getDirection().setY(0.0D);
    if (direction.lengthSquared() < 1.0E-4D) {
      return new Vector(0.0D, 0.0D, 1.0D);
    }
    return direction.normalize();
  }

  private static Sound meleeSound(EntityType type) {
    return switch (type) {
      case WOLF -> Sound.ENTITY_WOLF_GROWL;
      case POLAR_BEAR -> Sound.ENTITY_POLAR_BEAR_WARNING;
      case ZOMBIE, HUSK, ZOMBIE_VILLAGER, ZOMBIFIED_PIGLIN -> Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR;
      case PIGLIN, PIGLIN_BRUTE -> Sound.ENTITY_PIGLIN_ANGRY;
      case VINDICATOR -> Sound.ENTITY_VINDICATOR_AMBIENT;
      case WITHER_SKELETON -> Sound.ENTITY_WITHER_SKELETON_AMBIENT;
      case ENDERMITE -> Sound.ENTITY_ENDERMITE_AMBIENT;
      case SILVERFISH -> Sound.ENTITY_SILVERFISH_AMBIENT;
      case FOX -> Sound.ENTITY_FOX_AGGRO;
      case PANDA -> Sound.ENTITY_PANDA_BITE;
      default -> Sound.ENTITY_PLAYER_ATTACK_SWEEP;
    };
  }

  private static Sound chargeSound(EntityType type) {
    return switch (type) {
      case RAVAGER -> Sound.ENTITY_RAVAGER_ROAR;
      case HOGLIN -> Sound.ENTITY_HOGLIN_ATTACK;
      case ZOGLIN -> Sound.ENTITY_ZOGLIN_ATTACK;
      case GOAT -> Sound.ENTITY_GOAT_PREPARE_RAM;
      case CAMEL, CAMEL_HUSK -> Sound.ENTITY_CAMEL_DASH;
      case DONKEY -> Sound.ENTITY_DONKEY_ANGRY;
      case MULE -> Sound.ENTITY_MULE_ANGRY;
      default -> Sound.ENTITY_HORSE_GALLOP;
    };
  }

  private static Sound chargeImpactSound(EntityType type) {
    return switch (type) {
      case RAVAGER -> Sound.ENTITY_RAVAGER_ATTACK;
      case GOAT -> Sound.ENTITY_GOAT_RAM_IMPACT;
      case HOGLIN -> Sound.ENTITY_HOGLIN_ATTACK;
      case ZOGLIN -> Sound.ENTITY_ZOGLIN_ATTACK;
      default -> Sound.ENTITY_PLAYER_ATTACK_STRONG;
    };
  }

  private static Sound dashSound(EntityType type) {
    return switch (type) {
      case BAT -> Sound.ENTITY_BAT_TAKEOFF;
      case PARROT -> Sound.ENTITY_PARROT_FLY;
      case BEE -> Sound.ENTITY_BEE_LOOP_AGGRESSIVE;
      case PHANTOM -> Sound.ENTITY_PHANTOM_SWOOP;
      case VEX -> Sound.ENTITY_VEX_CHARGE;
      case ALLAY -> Sound.ENTITY_ALLAY_AMBIENT_WITH_ITEM;
      default -> Sound.ENTITY_ENDERMAN_TELEPORT;
    };
  }

  private static double dashDamage(EntityType type) {
    return switch (type) {
      case PHANTOM -> 8.0D;
      case VEX -> 7.0D;
      default -> 5.0D;
    };
  }
}
