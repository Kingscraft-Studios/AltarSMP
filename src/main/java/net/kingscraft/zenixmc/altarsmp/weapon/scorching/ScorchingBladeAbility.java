package net.kingscraft.zenixmc.altarsmp.weapon.scorching;

import io.papermc.paper.event.player.PlayerArmSwingEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.boss.BarColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.task.BurningDamageTask;
import net.kingscraft.zenixmc.altarsmp.task.ElectricSparkEffectTask;
import net.kingscraft.zenixmc.altarsmp.task.ElectricSparkRingTask;
import net.kingscraft.zenixmc.altarsmp.util.CombatEffectUtils;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;
import net.kingscraft.zenixmc.altarsmp.weapon.holylance.HolyLanceDetonationTask;
import net.kingscraft.zenixmc.altarsmp.weapon.holylance.HolyLanceDisplayAnimationTask;

public class ScorchingBladeAbility implements Listener {
  public static AltarSMP plugin;
  
  public static String SCORCHING_BLADE_COOLDOWN_KEY;
  
  public static String THUNDERSTRIKE_COOLDOWN_KEY;
  
  public static final NamespacedKey FIRE_BLOCK_KEY;
  
  public static final Set<Location> FIRE_BLOCK_LOCATIONS;
  
  public static FileConfiguration config;
  
  
  
  public ScorchingBladeAbility() {
    plugin = AltarSMP.getInstance();
    Bukkit.getScheduler().runTaskTimer((Plugin) plugin, ScorchingBladeAbility::lambda$new$0, 0L, 20L);
  }
  
  public static boolean isScorchingBladeInMainHand(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    {
      if (itemStack == null)
        return false; 
    }{
      if (itemStack.getType() != Material.NETHERITE_SWORD)
        return false; 
    }{
      if (!itemStack.hasItemMeta())
        return false; 
    }ItemMeta itemMeta = itemStack.getItemMeta();
    {
      if (itemMeta == null)
        return false; 
    }{
      if (!itemMeta.hasCustomModelData())
        return false; 
    }{
    
    }return (itemMeta.getCustomModelData() == 6);
  }
  
  public static boolean isScorchingBladeInOffHand(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInOffHand();
    {
      if (itemStack == null)
        return false; 
    }{
      if (itemStack.getType() != Material.NETHERITE_SWORD)
        return false; 
    }{
      if (!itemStack.hasItemMeta())
        return false; 
    }ItemMeta itemMeta = itemStack.getItemMeta();
    {
      if (itemMeta == null)
        return false; 
    }{
      if (!itemMeta.hasCustomModelData())
        return false; 
    }{
    
    }return (itemMeta.getCustomModelData() == 6);
  }
  
  @EventHandler
  public void onScorchingBladeDamage(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    {
      if (!(paramEntityDamageByEntityEvent.getDamager() instanceof Player))
        return; 
    }Player player = (Player)paramEntityDamageByEntityEvent.getDamager();
    {
      if (!isScorchingBladeInMainHand(player))
        return; 
    }
      CombatEffectUtils.spawnDualParticleRings((LivingEntity)player, Particle.FLAME, Particle.CRIT, Sound.ITEM_TRIDENT_THROW, 0.7F);
  }
  
  public static boolean activateThunderstrike(Player paramPlayer) {
    Location location1 = null;
    RayTraceResult rayTraceResult = paramPlayer.getWorld().rayTraceEntities(paramPlayer.getEyeLocation(), paramPlayer.getEyeLocation().getDirection(), 100.0D, 0.25D, paramEnt -> lambda$activateThunderstrike$1(paramPlayer, paramEnt));
    {
      if (rayTraceResult != null && rayTraceResult.getHitEntity() != null) {
        location1 = rayTraceResult.getHitEntity().getLocation().clone().subtract(0.0D, 0.5D, 0.0D);
      } else {
        rayTraceResult = paramPlayer.getWorld().rayTraceBlocks(paramPlayer.getEyeLocation(), paramPlayer.getEyeLocation().getDirection(), 100.0D);
        {
          if (rayTraceResult != null && rayTraceResult.getHitBlock() != null)
            location1 = rayTraceResult.getHitBlock().getLocation().clone().add(0.0D, 0.5D, 0.0D); 
        }} 
    }{
      if (location1 == null)
        return false; 
    }double d = AltarSMP.getInstance().getConfig().getDouble("holyLanceRadius", 3.0D);
    Location location2 = location1;
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, 1.0F, 1.0F);
    startThunderstrikeCharge(paramPlayer);
    startHolyLanceDescent(location2, d);
    (new HolyLanceDetonationTask(location2, paramPlayer, d)).runTaskLater((Plugin)AltarSMP.getInstance(), 20L);
    return true;
  }
  
  public static void startThunderstrikeCharge(Player paramPlayer) {
    (new ElectricSparkEffectTask(paramPlayer)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }
  
  public static void startHolyLanceDescent(Location paramLocation, double paramDouble) {
    (new ElectricSparkRingTask(paramDouble, paramLocation)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }
  
  public static void spawnHolyLanceVisual(Location paramLocation, double paramDouble) {
    float f1 = 30.0F;
    float f2 = (float)paramDouble / 2.0F;
    Location location = paramLocation.clone().add(0.0D, 0.0D, 0.0D);
    paramLocation.getWorld().spawnParticle(Particle.BLOCK, location, 30, 0.5D, 0.3D, 0.5D, 0.0D, Material.DIRT.createBlockData());
    ItemDisplay itemDisplay = (ItemDisplay)paramLocation.getWorld().spawn(location, ItemDisplay.class, paramDisplay -> lambda$lanceVisual$2(f2, paramDisplay));
    (new HolyLanceDisplayAnimationTask(itemDisplay)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }
  
  public static void detonateHolyLance(Location paramLocation, Player paramPlayer) {
    double d1 = AltarSMP.getInstance().getConfig().getDouble("holyLanceDamage", 6.0D);
    double d2 = AltarSMP.getInstance().getConfig().getDouble("holyLanceRadius", 3.0D);
    paramLocation.getWorld().spawnParticle(Particle.FLAME, paramLocation, 32, 1.0D, 0.5D, 1.0D, 0.05D);
    paramLocation.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, paramLocation, 32, 1.0D, 0.5D, 1.0D, 0.05D);
    paramLocation.getWorld().spawnParticle(Particle.ITEM, paramLocation, 300, 0.0D, 0.0D, 0.0D, 0.5D, new ItemStack(Material.DIRT));
    paramLocation.getWorld().spawnParticle(Particle.DUST, paramLocation, 32, 1.0D, 0.5D, 1.0D, 0.0D, new Particle.DustOptions(Color.fromRGB(185, 187, 90), 1.0F));
    for (Entity entity : paramLocation.getNearbyEntities(d2, d2, d2)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity)entity;
        {
          if (!livingEntity.isValid())
            continue; 
        }{
          if (livingEntity == paramPlayer)
            continue; 
        }{
          if (AltarSMP.isTrusted(paramPlayer, (Entity)livingEntity))
            continue; 
        }
          TrueDamage.apply(livingEntity, d1, paramPlayer);
        applyHallowedFlames(paramPlayer, livingEntity);
      } 
    } 
  }
  
  public static void activateScorchingBlade(Player paramPlayer) {
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 2.0F, 0.8F);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_SOUL_SOIL_BREAK, 1.5F, 0.6F);
    spawnParticleRing(paramPlayer.getLocation(), 0.125D, Particle.SOUL_FIRE_FLAME);
    spawnParticleRing(paramPlayer.getLocation(), 0.4D, Particle.FLAME);
    spawnParticleRing(paramPlayer.getLocation(), 0.6D, Particle.FLAME);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "scorchingPending", 10.0D);
    BossBarManager.createBar(paramPlayer, "§6§l!! §e§lSCORCHING §6§l!!", 10, ChatColor.YELLOW, BarColor.YELLOW);
  }
  
  @EventHandler
  public void onLavaFlow(BlockFromToEvent paramBlockFromToEvent) {
    {
      if (FIRE_BLOCK_LOCATIONS.contains(paramBlockFromToEvent.getBlock().getLocation()))
        {
          if (paramBlockFromToEvent.getBlock().getType() == Material.LAVA)
            paramBlockFromToEvent.setCancelled(true); 
        }}}
  
  @EventHandler
  public void onPlayerArmSwing(PlayerArmSwingEvent paramPlayerArmSwingEvent) {
    {
      if (paramPlayerArmSwingEvent.getHand() != EquipmentSlot.HAND)
        return; 
    }Player player = paramPlayerArmSwingEvent.getPlayer();
    {
      if (!CooldownManager.isOnCooldown(player.getUniqueId(), "scorchingPending"))
        return; 
    }
    CooldownManager.setCooldown(player.getUniqueId(), "scorchingPending", 0.0D);
    BossBarManager.removeBar(player, "!! SCORCHING !!");
    int i = AltarSMP.getInstance().getConfig().getInt("scorchingCooldown", 30);
    CooldownManager.setCooldown(player.getUniqueId(), SCORCHING_BLADE_COOLDOWN_KEY, i);
    BossBarManager.createBar(player, "Scorching Blade", i, ChatColor.YELLOW);
    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1.5F, 0.5F);
    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1.5F, 0.8F);
    Vector vector1 = player.getEyeLocation().getDirection().normalize();
    Vector vector2 = vector1.clone().crossProduct(new Vector(0, 1, 0)).normalize();
    HashSet<FallingBlock> hashSet = new HashSet();
    for (int b = 0; b < 40; b++) {
      double d1 = b * 0.3D - 6.0D;
      Location location = player.getEyeLocation().clone().add(vector2.clone().multiply(d1));
      double d2 = 0.03D;
      Vector vector = vector1.clone().add(vector2.clone().multiply(d1 * 0.03D)).add(new Vector(0.0D, d1 * d2, 0.0D)).normalize().multiply(2);
      FallingBlock fallingBlock = (FallingBlock)player.getWorld().spawnEntity(location, EntityType.FALLING_BLOCK);
      fallingBlock.setBlockData(Material.FIRE.createBlockData());
      fallingBlock.setDropItem(false);
      fallingBlock.setCancelDrop(true);
      fallingBlock.getPersistentDataContainer().set(FIRE_BLOCK_KEY, PersistentDataType.BYTE, Byte.valueOf((byte)1));
      fallingBlock.setVelocity(vector);
      hashSet.add(fallingBlock);
    } 
    (new ScorchingBladeProjectileTask(this, hashSet, player)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }
  
  public static void applyHallowedFlames(Player paramPlayer, LivingEntity paramLivingEntity) {
    {
      if (AltarSMP.isTrusted(paramPlayer, (Entity)paramLivingEntity))
        return; 
    }int i = config.getInt("hollowedFlamesDamage", 1);
    int j = config.getInt("hollowedFlamesDuration", 4);
    if (paramLivingEntity instanceof Player) {
      Player player = (Player)paramLivingEntity;
      BossBarManager.createBar(player, "§6§l!! §e§lHALLOWED FLAMES §6§l!!", j, ChatColor.RED);
    } 
    paramLivingEntity.getWorld().spawnParticle(Particle.FLAME, paramLivingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 50, 0.5D, 1.0D, 0.5D, 0.1D);
    paramLivingEntity.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, paramLivingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 50, 0.5D, 1.0D, 0.5D, 0.1D);
    (new BurningDamageTask(j, paramLivingEntity, i, paramPlayer)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }
  
  public static void detonateScorchingBlade(Location paramLocation, Player paramPlayer) {
    Block block = paramLocation.getBlock();
    int b = 0;
    {
      while (b < 3)
        b++; 
    }ArrayList arrayList = new ArrayList();
    (new ScorchingBladeLavaColumnTask(arrayList, block)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
    double d = plugin.getConfig().getDouble("scorchingDamage", 6.0D);
    for (Entity entity : paramLocation.getNearbyEntities(2.5D, 2.5D, 2.5D)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity)entity;
        {
          if (livingEntity == paramPlayer)
            continue; 
        }{
          if (CooldownManager.isOnCooldown(livingEntity.getUniqueId(), "damaged"))
            continue; 
        }{
          if (AltarSMP.isTrusted(paramPlayer, (Entity)livingEntity))
            continue; 
        }
          TrueDamage.apply(livingEntity, d, paramPlayer);
        applyHallowedFlames(paramPlayer, livingEntity);
        livingEntity.getWorld().spawnParticle(Particle.FLAME, livingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 12, 0.4D, 0.5D, 0.4D, 0.0D);
        livingEntity.getWorld().spawnParticle(Particle.LAVA, livingEntity.getLocation(), 5, 0.3D, 0.3D, 0.3D, 0.0D);
        livingEntity.getWorld().spawnParticle(Particle.CRIT, livingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 8, 0.3D, 0.5D, 0.3D, 0.1D);
        CooldownManager.setCooldown(livingEntity.getUniqueId(), "damaged", 1.0D);
        break;
      } 
    } 
  }
  
  public static void spawnParticleRing(Location paramLocation, double paramDouble, Particle paramParticle) {
    Vector vector = new Vector(paramDouble, 0.0D, 0.0D);
    int i = 0;
    for (i = 0; i < 360; i += Math.max(1, (int)(Math.random() * 5.0D))) {
      Vector vector1 = vector.clone().rotateAroundY(Math.toRadians(i));
      Location location = paramLocation.clone().add(vector1).add(0.0D, 0.0D, 0.0D);
      double d1 = vector1.getX() * 500000.0D;
      double d2 = vector1.getY() * 500000.0D;
      double d3 = vector1.getZ() * 500000.0D;
      paramLocation.getWorld().spawnParticle(paramParticle, location, 0, d1, d2, d3, 6.0E-7D);
    } 
  }
  
  private static void lambda$lanceVisual$2(float paramFloat, ItemDisplay paramItemDisplay) {
    ItemStack itemStack = new ItemStack(Material.WHITE_CONCRETE);
    paramItemDisplay.setBrightness(new Display.Brightness(15, 15));
    paramItemDisplay.setItemStack(itemStack);
    paramItemDisplay.setRotation(0.0F, 0.0F);
    Transformation transformation = new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new AxisAngle4f(0.0F, 0.0F, 0.0F, 0.0F), new Vector3f(paramFloat, 15.0F, paramFloat), new AxisAngle4f(0.0F, 0.0F, 0.0F, 0.0F));
    paramItemDisplay.setTransformation(transformation);
  }
  
  private static boolean lambda$activateThunderstrike$1(Player paramPlayer, Entity paramEntity) {
    {
      if (paramEntity instanceof LivingEntity)
        {
          if (!paramEntity.equals(paramPlayer));
        }}return false;
  }
  
  private static void lambda$new$0() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (isScorchingBladeInMainHand(player) || isScorchingBladeInOffHand(player)) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 0, false, false, false));
      } 
    } 
  }

  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

  static {
    SCORCHING_BLADE_COOLDOWN_KEY = "hyperion_scorching";
    THUNDERSTRIKE_COOLDOWN_KEY = "hyperion_thunderstrike";
    FIRE_BLOCK_KEY = new NamespacedKey(AltarSMP.getInstance(), "fire_block");
    FIRE_BLOCK_LOCATIONS = new HashSet<>();
    config = AltarSMP.getInstance().getConfig();
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */