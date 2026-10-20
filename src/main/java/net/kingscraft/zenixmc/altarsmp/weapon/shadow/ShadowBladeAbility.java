package net.kingscraft.zenixmc.altarsmp.weapon.shadow;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.cooldown.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardHook;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import net.kingscraft.zenixmc.altarsmp.util.CombatEffectUtils;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public class ShadowBladeAbility implements Listener {
  public static int leapCooldown;

  public static int daggerCooldown;

  public static final HashMap<UUID, Location> leapLocations;

  public static final HashMap<UUID, BukkitRunnable> leapTasks;

  private Map<UUID, Integer> backstabCounts = new HashMap<>();

  private Map<UUID, Long> lastBackstabTimes = new HashMap<>();


  public ShadowBladeAbility() {
    (new ShadowBladePassiveTask(this)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 20L);
  }

  public static boolean hasShadowBlade(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    return AltarSMP.areSimilar(itemStack, CustomItemRegistry.getShadowBlade());
  }

  public static void activateShadowLeap(Player paramPlayer) {
    {
      if (leapLocations.containsKey(paramPlayer.getUniqueId()))
        return; 
    }{
      if (leapTasks.containsKey(paramPlayer.getUniqueId()))
        return; 
    }{
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "shadwoleap"))
        return; 
    }paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 0.6F);
    Location location = paramPlayer.getEyeLocation().clone();
    for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (!player.equals(paramPlayer))
          player.hidePlayer((Plugin)AltarSMP.getInstance(), paramPlayer); 
      }} 
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20, 1, true, false, false));
    String str1 = ChatColor.BOLD.toString();
    String str2 = String.valueOf(ChatColor.GRAY);
    String str3 = ChatColor.BOLD.toString();
    String str4 = String.valueOf(ChatColor.WHITE);
    String str5 = ChatColor.BOLD.toString();
    BossBarManager.createBar(paramPlayer, String.valueOf(ChatColor.GRAY) + str5 + "! " + str4 + str3 + "INVISIBLE " + str2 + str1 + "!", 1, ChatColor.YELLOW);
    if (AltarSMP.getInstance().getConfig().getBoolean("shadowBladeBorderLogic", true)) {
      WorldBorder worldBorder = Bukkit.createWorldBorder();
      worldBorder.setCenter(paramPlayer.getLocation());
      worldBorder.setSize(5.9999968E7D);
      worldBorder.setWarningDistance(59999968);
      paramPlayer.setWorldBorder(worldBorder);
    } 
    ShadowLeapTask shadowLeapTask = new ShadowLeapTask(location, paramPlayer);
    (new ShadowLeapCleanupTask(paramPlayer)).runTaskLater((Plugin)AltarSMP.getInstance(), 20L);
    leapTasks.put(paramPlayer.getUniqueId(), shadowLeapTask);
    leapLocations.put(paramPlayer.getUniqueId(), location.clone());
    shadowLeapTask.runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }

  public static void spawnShadowParticles(Player paramPlayer, Location paramLocation) {
    {
      if (paramLocation == null)
        return; 
    }for (int b = 0; b < 100; b++) {
      double d1 = Math.random() * 2.0D * Math.PI;
      double d2 = Math.random() * Math.PI;
      double d3 = 1.5D * Math.sin(d2) * Math.cos(d1);
      double d4 = 1.5D * Math.sin(d2) * Math.sin(d1);
      double d5 = 1.5D * Math.cos(d2);
      paramLocation.getWorld().spawnParticle(Particle.SQUID_INK, paramLocation.clone().add(d3, d4, d5), 1, 0.0D, 0.0D, 0.0D, 0.0D);
    } 
    (new ShadowLeapTeleportTask(paramPlayer, paramLocation)).runTaskLater((Plugin)AltarSMP.getInstance(), 5L);
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent paramPlayerInteractEvent) {
    Player player = paramPlayerInteractEvent.getPlayer();
    if ((paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK || paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR)
        && hasShadowBlade(player)
        && leapLocations.containsKey(player.getUniqueId())) {
      if (CooldownManager.isOnCooldown(player.getUniqueId(), "shadwoleap")) {
        paramPlayerInteractEvent.setCancelled(true);
        return;
      }
      Location location = leapLocations.get(player.getUniqueId());
      BukkitRunnable bukkitRunnable = leapTasks.get(player.getUniqueId());
      if (bukkitRunnable != null) {
        bukkitRunnable.cancel();
      }
      if (location != null) {
        for (int i = 0; i < 100; i++) {
          double d = Math.random() * 2.0D * Math.PI;
          double d2 = Math.random() * Math.PI;
          double d3 = 1.5D * Math.sin(d2) * Math.cos(d);
          double d4 = 1.5D * Math.sin(d2) * Math.sin(d);
          double d5 = 1.5D * Math.cos(d2);
          location.getWorld().spawnParticle(Particle.SQUID_INK, location.clone().add(d3, d4, d5), 1, 0.0D, 0.0D, 0.0D, 0.0D);
        }
        new ShadowLeapReturnTask(this, player, location).runTaskLater(AltarSMP.getInstance(), 5L);
      }
      leapLocations.remove(player.getUniqueId());
      leapTasks.remove(player.getUniqueId());
      for (Player player2 : Bukkit.getOnlinePlayers()) {
        if (!player2.equals(player)) {
          player2.showPlayer(AltarSMP.getInstance(), player);
        }
      }
      player.removePotionEffect(PotionEffectType.INVISIBILITY);
      player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 0.6F);
      player.swingMainHand();
      player.updateInventory();
      if (AltarSMP.getInstance().getConfig().getBoolean("shadowBladeBorderLogic", true)) {
        player.setWorldBorder(null);
      }
      BossBarManager.createBar(player, "Shadow Leap", leapCooldown, ChatColor.YELLOW);
      BossBarManager.removeBar(player, String.valueOf(ChatColor.GRAY) + ChatColor.BOLD.toString() + "! " + String.valueOf(ChatColor.WHITE) + ChatColor.BOLD.toString() + "INVISIBLE " + String.valueOf(ChatColor.GRAY) + ChatColor.BOLD.toString() + "!");
      CooldownManager.setCooldown(player.getUniqueId(), "shadwoleap", leapCooldown);
      paramPlayerInteractEvent.setCancelled(true);
    }
  }

  public static void spawnBackstabEffect(Player paramPlayer) {
    CombatEffectUtils.playSoundAndParticleEffect((LivingEntity)paramPlayer, Particle.DUST, new Particle.DustOptions(Color.BLACK, 1.0F), (Sound)null, 1.0F);
  }

  public static void activateShadowDaggers(Player paramPlayer) {
    {
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "daggers"))
        return; 
    }
    spawnBackstabEffect(paramPlayer);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "daggers", daggerCooldown);
    BossBarManager.createBar(paramPlayer, "Shadow Daggers", daggerCooldown, ChatColor.YELLOW);
    Vector vector = paramPlayer.getLocation().getDirection();
    Location location = paramPlayer.getLocation();
    double d = AltarSMP.getInstance().getConfig().getInt("shadowDaggerDistance", 10);
    for (Entity entity : paramPlayer.getWorld().getNearbyEntities(location, d, d, d)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity)entity;
        {
          if (livingEntity.equals(paramPlayer))
            continue; 
        }Vector vector1 = livingEntity.getLocation().toVector().subtract(location.toVector());
        {
          if (vector.dot(vector1.normalize()) > 0.0D && vector1.length() <= d) {
            Location location1 = livingEntity.getLocation().clone();
            livingEntity.getWorld().spawnParticle(Particle.SQUID_INK, location1.add(0.0D, 1.0D, 0.0D), 15, 0.2D, 0.2D, 0.2D, 0.01D);
            livingEntity.getWorld().playSound(livingEntity.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 5.0F, 0.7F);
            TrueDamage.apply(livingEntity, AltarSMP.getInstance().getConfig().getInt("shadowDaggerDamage"), paramPlayer);
            livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 60, 1, true, true, true));
            livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0, true, true, true));
          } 
        }} 
    } 
  }

  public void recordBackstab(Player paramPlayer) {
    int i = getBackstabCount(paramPlayer);
    this.backstabCounts.put(paramPlayer.getUniqueId(), Integer.valueOf(i + 1));
    this.lastBackstabTimes.put(paramPlayer.getUniqueId(), Long.valueOf(System.currentTimeMillis()));
  }

  public int getBackstabCount(Player paramPlayer) {
    long l = System.currentTimeMillis();
    {
      if (this.lastBackstabTimes.containsKey(paramPlayer.getUniqueId()))
        {
          if (l - ((Long)this.lastBackstabTimes.get(paramPlayer.getUniqueId())).longValue() > 2500L)
            this.backstabCounts.put(paramPlayer.getUniqueId(), Integer.valueOf(0));
        }}return ((Integer)this.backstabCounts.getOrDefault(paramPlayer.getUniqueId(), Integer.valueOf(0))).intValue();
  }

  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    {
      if (!hasShadowBlade(player))
        return; 
    }{
      CombatEffectUtils.spawnDualParticleRings((LivingEntity)player, Particle.CRIT, null, Particle.ITEM, new ItemStack(Material.BLACK_CONCRETE), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 2.0F);
      if (!isBackstab(paramEntityDamageByEntityEvent))
        return; 
    }{
      if (ThreadLocalRandom.current().nextInt(100) < 30) {
        performBackstab(paramEntityDamageByEntityEvent.getEntity(), player);
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 0.1F);
      } 
    }}

  public static boolean isBackstab(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Entity entity1 = paramEntityDamageByEntityEvent.getEntity();
    Entity entity2 = paramEntityDamageByEntityEvent.getDamager();
    Vector vector1 = entity1.getLocation().getDirection().setY(0).normalize();
    Vector vector2 = entity2.getLocation().toVector().subtract(entity1.getLocation().toVector()).setY(0).normalize();
    {

    }return (vector1.dot(vector2) < -0.5D);
  }

  public static void performBackstab(Entity paramEntity, Player paramPlayer) {
    {
      if (WorldGuardHook.isBlocked(paramEntity.getLocation()))
        return; 
    }(new ShadowDaggerPullTask(paramEntity, paramPlayer)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }

  static {
    leapCooldown = AltarSMP.getInstance().getConfig().getInt("ShadowBladeLeapCooldown", 30);
    daggerCooldown = AltarSMP.getInstance().getConfig().getInt("ShadowBladeDaggerCooldown", 15);
    leapLocations = new HashMap<>();
    leapTasks = new HashMap<>();
  }

}
