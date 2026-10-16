package pl;

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

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag implements Listener {
  public static Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  private static final NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  public static final Set<Location> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  static FileConfiguration You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag() {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = Main.getInstance();
    Bukkit.getScheduler().runTaskTimer((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag::lambda$new$0, 0L, 20L);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
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
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(Player paramPlayer) {
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
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    {
      if (!(paramEntityDamageByEntityEvent.getDamager() instanceof Player))
        return; 
    }Player player = (Player)paramEntityDamageByEntityEvent.getDamager();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player))
        return; 
    }
      CombatEffectUtils.spawnDualParticleRings((LivingEntity)player, Particle.FLAME, Particle.CRIT, Sound.ITEM_TRIDENT_THROW, 0.7F);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
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
    }double d = Main.getInstance().getConfig().getDouble("holyLanceRadius", 3.0D);
    Location location2 = location1;
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, 1.0F, 1.0F);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location2, d);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dr(location2, paramPlayer, d)).runTaskLater((Plugin)Main.getInstance(), 20L);
    return true;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ds(paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, double paramDouble) {
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dt(paramDouble, paramLocation)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Location paramLocation, double paramDouble) {
    float f1 = 30.0F;
    float f2 = (float)paramDouble / 2.0F;
    Location location = paramLocation.clone().add(0.0D, 0.0D, 0.0D);
    paramLocation.getWorld().spawnParticle(Particle.BLOCK, location, 30, 0.5D, 0.3D, 0.5D, 0.0D, Material.DIRT.createBlockData());
    ItemDisplay itemDisplay = (ItemDisplay)paramLocation.getWorld().spawn(location, ItemDisplay.class, paramDisplay -> lambda$lanceVisual$2(f2, paramDisplay));
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764du(itemDisplay)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Player paramPlayer) {
    double d1 = Main.getInstance().getConfig().getDouble("holyLanceDamage", 6.0D);
    double d2 = Main.getInstance().getConfig().getDouble("holyLanceRadius", 3.0D);
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
          if (Main.isTrusted(paramPlayer, (Entity)livingEntity))
            continue; 
        }
          TrueDamage.apply(livingEntity, d1, paramPlayer);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, livingEntity);
      } 
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 2.0F, 0.8F);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_SOUL_SOIL_BREAK, 1.5F, 0.6F);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getLocation(), 0.125D, Particle.SOUL_FIRE_FLAME);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getLocation(), 0.4D, Particle.FLAME);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getLocation(), 0.6D, Particle.FLAME);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "scorchingPending", 10.0D);
    BossBarManager.createBar(paramPlayer, "§6§l!! §e§lSCORCHING §6§l!!", 10, ChatColor.YELLOW, BarColor.YELLOW);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(BlockFromToEvent paramBlockFromToEvent) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.contains(paramBlockFromToEvent.getBlock().getLocation()))
        {
          if (paramBlockFromToEvent.getBlock().getType() == Material.LAVA)
            paramBlockFromToEvent.setCancelled(true); 
        }}}
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerArmSwingEvent paramPlayerArmSwingEvent) {
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
    int i = Main.getInstance().getConfig().getInt("scorchingCooldown", 30);
    CooldownManager.setCooldown(player.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, i);
    BossBarManager.createBar(player, "Scorching Blade", i, ChatColor.YELLOW);
    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1.5F, 0.5F);
    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1.5F, 0.8F);
    Vector vector1 = player.getEyeLocation().getDirection().normalize();
    Vector vector2 = vector1.clone().crossProduct(new Vector(0, 1, 0)).normalize();
    HashSet<FallingBlock> hashSet = new HashSet();
    for (byte b = 0; b < 40; b++) {
      double d1 = b * 0.3D - 6.0D;
      Location location = player.getEyeLocation().clone().add(vector2.clone().multiply(d1));
      double d2 = 0.03D;
      Vector vector = vector1.clone().add(vector2.clone().multiply(d1 * 0.03D)).add(new Vector(0.0D, d1 * d2, 0.0D)).normalize().multiply(2);
      FallingBlock fallingBlock = (FallingBlock)player.getWorld().spawnEntity(location, EntityType.FALLING_BLOCK);
      fallingBlock.setBlockData(Material.FIRE.createBlockData());
      fallingBlock.setDropItem(false);
      fallingBlock.setCancelDrop(true);
      fallingBlock.getPersistentDataContainer().set(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d, PersistentDataType.BYTE, Byte.valueOf((byte)1));
      fallingBlock.setVelocity(vector);
      hashSet.add(fallingBlock);
    } 
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dv(this, hashSet, player)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, LivingEntity paramLivingEntity) {
    {
      if (Main.isTrusted(paramPlayer, (Entity)paramLivingEntity))
        return; 
    }int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.getInt("hollowedFlamesDamage", 1);
    int j = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.getInt("hollowedFlamesDuration", 4);
    if (paramLivingEntity instanceof Player) {
      Player player = (Player)paramLivingEntity;
      BossBarManager.createBar(player, "§6§l!! §e§lHALLOWED FLAMES §6§l!!", j, ChatColor.RED);
    } 
    paramLivingEntity.getWorld().spawnParticle(Particle.FLAME, paramLivingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 50, 0.5D, 1.0D, 0.5D, 0.1D);
    paramLivingEntity.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, paramLivingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 50, 0.5D, 1.0D, 0.5D, 0.1D);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dw(j, paramLivingEntity, i, paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Location paramLocation, Player paramPlayer) {
    Block block = paramLocation.getBlock();
    byte b = 0;
    {
      while (b < 3)
        b++; 
    }ArrayList arrayList = new ArrayList();
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dx(arrayList, block)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
    double d = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getDouble("scorchingDamage", 6.0D);
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
          if (Main.isTrusted(paramPlayer, (Entity)livingEntity))
            continue; 
        }
          TrueDamage.apply(livingEntity, d, paramPlayer);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, livingEntity);
        livingEntity.getWorld().spawnParticle(Particle.FLAME, livingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 12, 0.4D, 0.5D, 0.4D, 0.0D);
        livingEntity.getWorld().spawnParticle(Particle.LAVA, livingEntity.getLocation(), 5, 0.3D, 0.3D, 0.3D, 0.0D);
        livingEntity.getWorld().spawnParticle(Particle.CRIT, livingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 8, 0.3D, 0.5D, 0.3D, 0.1D);
        CooldownManager.setCooldown(livingEntity.getUniqueId(), "damaged", 1.0D);
        break;
      } 
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, double paramDouble, Particle paramParticle) {
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
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player) || You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(player)) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 0, false, false, false));
      } 
    } 
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = "hyperion_scorching";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = "hyperion_thunderstrike";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = new NamespacedKey(Main.getInstance(), "fire_block");
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = new HashSet<>();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = Main.getInstance().getConfig();
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */