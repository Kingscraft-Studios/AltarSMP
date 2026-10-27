package net.kingscraft.zenixmc.altarsmp.weapon.knightfall;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardHook;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import net.kingscraft.zenixmc.altarsmp.item.ItemUtility;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;
import net.kingscraft.zenixmc.altarsmp.weapon.wind.GrapplePullTask;
import net.kingscraft.zenixmc.altarsmp.weapon.wind.HammerProjectileTask;

public class KnightfallListener implements Listener {
  public final KnightFallKillTracker killTracker;

  public final Map<UUID, BukkitRunnable> cloakTasks = new HashMap<>();

  public static AltarSMP plugin;

  public static int speedAmplifier;

  public static HashMap<UUID, Integer> hookCharges;

  public static HashMap<UUID, BukkitTask> hookCooldownTasks;

  public static final boolean assertionsEnabled;

  static {
    assertionsEnabled = !KnightfallListener.class.desiredAssertionStatus();
    plugin = AltarSMP.getInstance();
    speedAmplifier = AltarSMP.getInstance().getConfig().getInt("KnightfallSpeedAmplifier", 1);
    hookCharges = new HashMap<>();
    hookCooldownTasks = new HashMap<>();
  }

  public KnightfallListener(KnightFallKillTracker killTracker) {
    this.killTracker = killTracker;
    (new CloakAutoStartTask(this, killTracker)).runTaskTimer(plugin, 0L, 20L);
  }

  public static boolean isKnightfall(ItemStack paramItemStack) {
    {
      if (paramItemStack == null)
        return false; 
    }

    ItemMeta itemMeta = paramItemStack.getItemMeta();

    {
      if (itemMeta == null)
        return false; 
    }

    return itemMeta.getPersistentDataContainer().equals(CustomItemRegistry.getKnightfall(null, false).getItemMeta().getPersistentDataContainer());
  }

  @EventHandler
  public void onMaceDamage(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    {
      if (paramEntityDamageByEntityEvent.isCancelled())
        return; 
    }
    Entity entity1 = paramEntityDamageByEntityEvent.getDamager();
    if (entity1 instanceof Player) {
      player = (Player)entity1;
    } else {
      return;
    } 
    int i = AltarSMP.getInstance().getConfig().getInt("knightfallDamageLimit", 12);
    {
      if (i == 0)
        return; 
    }
    {
      if (paramEntityDamageByEntityEvent.getFinalDamage() <= i)
        return; 
    }
    ItemStack itemStack = player.getInventory().getItemInMainHand();
    {
      if (!isKnightfall(itemStack))
        return; 
    }
    paramEntityDamageByEntityEvent.setDamage(0.0D);
    Entity entity2 = paramEntityDamageByEntityEvent.getEntity();
    if (entity2 instanceof LivingEntity livingEntity) {
        TrueDamage.apply(livingEntity, i, player, true);
    } 
  }

  @EventHandler(priority = EventPriority.LOWEST)
  public void onMaceCooldown(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player player) {
        ItemStack itemStack = player.getInventory().getItemInMainHand();
      {
        if (!isKnightfall(itemStack))
          return; 
      }
      String str = "knightfallCooldown";
      int i = AltarSMP.getInstance().getConfig().getInt(str, 0);
      {
        if (i == 0)
          return; 
      }
      {
        if (paramEntityDamageByEntityEvent.isCancelled())
          return; 
      }
      {
        if (paramEntityDamageByEntityEvent.getFinalDamage() <= 1.0D)
          return; 
      }
      {
        if (player.hasCooldown(Material.MACE)) {
          paramEntityDamageByEntityEvent.setCancelled(true);
          player.setVelocity(new Vector(0, 0, 0));
          player.setFallDistance(0.0F);
          player.sendMessage(Component.text("Your knightfall is still on cooldown", NamedTextColor.RED));
          return;
        } 
      }
      player.setCooldown(itemStack, i * 20);
    } 
  }

  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void onPlayerDeath(PlayerDeathEvent paramPlayerDeathEvent) {
    Player player = paramPlayerDeathEvent.getPlayer().getKiller();
    {
      if (player == null)
        return; 
    }
    {
      if (!isKnightfall(player.getInventory().getItemInMainHand()))
        return; 
    }
    this.killTracker.incrementKillCount(player);
    player.sendMessage(Component.text("Knightfall is now at " + this.killTracker.getKillCount(player) + " kills", NamedTextColor.RED));
    ItemStack itemStack = player.getInventory().getItemInMainHand();
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.lore(CustomItemRegistry.getKnightfall(player, false).getItemMeta().lore());
    itemMeta.setCustomModelDataComponent(CustomItemRegistry.getKnightfall(player, false).getItemMeta().getCustomModelDataComponent());
    itemStack.setItemMeta(itemMeta);
    player.getInventory().setItemInMainHand(itemStack);
  }

  public static void startCloak(Player paramPlayer, int paramInt) {
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, paramInt * 20, 1, true, false, false));
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 0.5F);
    paramPlayer.getWorld().spawnParticle(Particle.SQUID_INK, paramPlayer.getLocation(), 20, 0.0D, 0.0D, 0.0D, 0.0D);
    for (Player player : Bukkit.getOnlinePlayers())
      player.hidePlayer(AltarSMP.getInstance(), paramPlayer);
    (new CloakEndTask(paramInt, paramPlayer)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  @EventHandler
  public void onCloakChance(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    {
      if (!isKnightfall(player.getInventory().getItemInMainHand()))
        return; 
    }
    int i = AltarSMP.getInstance().getConfig().getInt("cloakChances", 10);
    int j = AltarSMP.getInstance().getConfig().getInt("cloakDuration", 3);
    Random random = new Random();
    {
      if (paramEntityDamageByEntityEvent.getEntity() instanceof LivingEntity)
        {
          if (random.nextInt(100) < i) {
            {
              if (player.getFallDistance() < 2.0F)
                return; 
            }
            findHookTargetBlock(player, j);
          } 
        }
    }
  }

  public void startCloakLoop(Player paramPlayer) {
    CloakSpeedTask clockSpeedTask = new CloakSpeedTask(this, paramPlayer);
    clockSpeedTask.runTaskTimer(plugin, 0L, 20L);
    this.cloakTasks.put(paramPlayer.getUniqueId(), clockSpeedTask);
  }

  public void stopCloakLoop(Player paramPlayer) {
    BukkitRunnable bukkitRunnable = this.cloakTasks.remove(paramPlayer.getUniqueId());
    {
      if (bukkitRunnable != null)
        bukkitRunnable.cancel(); 
    }
  }

  public static boolean throwHammer(Player paramPlayer) {
    {
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "hammerThrow"))
        return false; 
    }
    int i = plugin.getConfig().getInt("hammerThrowCooldown", 30);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "hammerThrow", i);
    double d1 = plugin.getConfig().getDouble("hammerThrowMaxDistance", 100.0D);
    double d2 = plugin.getConfig().getDouble("hammerThrowDamage", 6.0D);
    boolean bool = plugin.getConfig().getBoolean("hammerThrowStunShield", true);
    int j = plugin.getConfig().getInt("hammerThrowStunShieldDuration", 5) * 20;
    double d3 = plugin.getConfig().getDouble("hammerThrowSpeed", 1.5D);
    BossBarManager.createBar(paramPlayer, "Hammer Throw", i, NamedTextColor.YELLOW);
    Location location = paramPlayer.getEyeLocation();
    Vector vector = location.getDirection().normalize().clone();
    World world = paramPlayer.getWorld();
    ItemDisplay itemDisplay = (ItemDisplay)world.spawnEntity(location.clone().add(vector.clone().multiply(0.5D)), EntityType.ITEM_DISPLAY);
    ItemStack itemStack = CustomItemRegistry.getKnightfall(paramPlayer, false);
    itemDisplay.setItemStack(itemStack);
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getScale().set(1.0F, 1.0F, 1.0F);
    transformation.getLeftRotation().rotateX((float)Math.toRadians(90.0D));
    itemDisplay.setTransformation(transformation);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_CHAIN_BREAK, 1.0F, 0.1F);
    (new HammerProjectileTask(location, d1, paramPlayer, itemDisplay, vector, d3, world, bool, j, d2)).runTaskTimer(plugin, 3L, 1L);
    return true;
  }

  public static void chainEntity(LivingEntity paramLivingEntity, Player paramPlayer) {
    {
      if (WorldGuardHook.isBlocked(paramLivingEntity.getLocation()))
        return; 
    }
    (new ChainPullTask(paramLivingEntity, paramPlayer)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  public static void showHookCharges(Player paramPlayer) {
    BossBarManager.removeBar(paramPlayer, "Grappling Hook x1");
    BossBarManager.removeBar(paramPlayer, "Grappling Hook x2");
    BossBarManager.removeBar(paramPlayer, "Grappling Hook x3");
  }

  public static boolean useGrapplingHook(Player paramPlayer) {
    int i = AltarSMP.getInstance().getConfig().getInt("grapplingHookCooldown", 10);
    int j = AltarSMP.getInstance().getConfig().getInt("grapplingHookMaxDistance", 50);
    Location location = findHookTargetBlock(paramPlayer, j);
    {
      if (location == null)
        return false; 
    }
    {
      if (hookCharges.getOrDefault(paramPlayer.getUniqueId(), 0) >= 3)
        return false; 
    }
    BukkitTask bukkitTask = hookCooldownTasks.get(paramPlayer.getUniqueId());
    {
      if (bukkitTask != null)
        bukkitTask.cancel(); 
    }
    hookCharges.put(paramPlayer.getUniqueId(), hookCharges.getOrDefault(paramPlayer.getUniqueId(), 0) + 1);
    showHookCharges(paramPlayer);
    int k = hookCharges.getOrDefault(paramPlayer.getUniqueId(), 1);
    BossBarManager.createBar(paramPlayer, LegacyComponentSerializer.legacySection().serialize(Component.text()
        .append(Component.text("Grappling Hook ", NamedTextColor.YELLOW, TextDecoration.BOLD))
        .append(Component.text("x" + k, NamedTextColor.GOLD, TextDecoration.BOLD))
        .build()), i, NamedTextColor.YELLOW);
    startHookCooldown(paramPlayer, i);
    launchGrapple(location, paramPlayer, j);
    return true;
  }

  public static void launchGrapple(Location paramLocation, Player paramPlayer, int paramInt) {
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 2.0F);
    ItemStack itemStack = new ItemStack(ItemUtility.getChainMaterial());
    Location location1 = paramLocation.clone().add(0.0D, 1.0D, 0.0D);
    location1.getWorld().spawnParticle(Particle.GUST, location1, 0, 0.0D, 0.0D, 0.0D, 0.0D);
    location1.getWorld().spawnParticle(Particle.ITEM, location1, 120, 0.2D, 0.2D, 0.2D, 0.1D, itemStack);
    double d1 = AltarSMP.getInstance().getConfig().getDouble("grapplingHookStrength", 1.5D);
    int i = AltarSMP.getInstance().getConfig().getInt("grapplingHookLeapStrength", 1);
    double d2 = paramInt / d1;
    (new GrapplePullTask(paramPlayer, d2, location1, i, itemStack, d1)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  public static void startHookCooldown(Player paramPlayer, int paramInt) {
    BukkitTask bukkitTask = (new RestoreHookChargesTask(paramPlayer, paramInt)).runTaskLater(AltarSMP.getInstance(), (paramInt * 20L));
    hookCooldownTasks.put(paramPlayer.getUniqueId(), bukkitTask);
  }

  public static Location findHookTargetBlock(Player paramPlayer, int paramInt) {
    RayTraceResult rayTraceResult = paramPlayer.getWorld().rayTraceBlocks(paramPlayer.getEyeLocation(), paramPlayer.getEyeLocation().getDirection(), paramInt);
    {
      if (rayTraceResult == null) {
        paramPlayer.sendMessage(Component.text("No target block found!", NamedTextColor.RED));
        return null;
      }
    }
    {
      if (!assertionsEnabled) {
        if (rayTraceResult.getHitBlock() == null)
          throw new AssertionError();
      }
    }
    {
      if (WorldGuardHook.isBlocked(rayTraceResult.getHitBlock().getLocation()))
        return null;
    }
    return rayTraceResult.getHitBlock().getLocation().add(0.5D, 0.0D, 0.5D);
  }

}
