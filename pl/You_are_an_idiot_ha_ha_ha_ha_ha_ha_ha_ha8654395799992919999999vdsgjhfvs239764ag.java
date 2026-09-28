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
  
  private static final String[] a;
  
  private static final String[] b;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag() {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = Main.getInstance();
    Bukkit.getScheduler().runTaskTimer((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag::lambda$new$0, 0L, 20L);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    try {
      if (itemStack == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemStack.getType() != Material.NETHERITE_SWORD)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemStack.hasItemMeta())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    ItemMeta itemMeta = itemStack.getItemMeta();
    try {
      if (itemMeta == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemMeta.hasCustomModelData())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
    
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return (itemMeta.getCustomModelData() == 6);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInOffHand();
    try {
      if (itemStack == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemStack.getType() != Material.NETHERITE_SWORD)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemStack.hasItemMeta())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    ItemMeta itemMeta = itemStack.getItemMeta();
    try {
      if (itemMeta == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemMeta.hasCustomModelData())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
    
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return (itemMeta.getCustomModelData() == 6);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    try {
      if (!(paramEntityDamageByEntityEvent.getDamager() instanceof Player))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Player player = (Player)paramEntityDamageByEntityEvent.getDamager();
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764v.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a((LivingEntity)player, Particle.FLAME, Particle.CRIT, Sound.ITEM_TRIDENT_THROW, 0.7F);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    Location location1 = null;
    RayTraceResult rayTraceResult = paramPlayer.getWorld().rayTraceEntities(paramPlayer.getEyeLocation(), paramPlayer.getEyeLocation().getDirection(), 100.0D, 0.25D, paramPlayer::lambda$activateThunderstrike$1);
    try {
      if (rayTraceResult != null && rayTraceResult.getHitEntity() != null) {
        location1 = rayTraceResult.getHitEntity().getLocation().clone().subtract(0.0D, 0.5D, 0.0D);
      } else {
        rayTraceResult = paramPlayer.getWorld().rayTraceBlocks(paramPlayer.getEyeLocation(), paramPlayer.getEyeLocation().getDirection(), 100.0D);
        try {
          if (rayTraceResult != null && rayTraceResult.getHitBlock() != null)
            location1 = rayTraceResult.getHitBlock().getLocation().clone().add(0.0D, 0.5D, 0.0D); 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (location1 == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    double d = Main.getInstance().getConfig().getDouble(a(27945, -25171), 3.0D);
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
    ItemDisplay itemDisplay = (ItemDisplay)paramLocation.getWorld().spawn(location, ItemDisplay.class, f2::lambda$lanceVisual$2);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764du(itemDisplay)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Player paramPlayer) {
    double d1 = Main.getInstance().getConfig().getDouble(a(27936, -19940), 6.0D);
    double d2 = Main.getInstance().getConfig().getDouble(a(27950, -7839), 3.0D);
    paramLocation.getWorld().spawnParticle(Particle.FLAME, paramLocation, 32, 1.0D, 0.5D, 1.0D, 0.05D);
    paramLocation.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, paramLocation, 32, 1.0D, 0.5D, 1.0D, 0.05D);
    paramLocation.getWorld().spawnParticle(Particle.ITEM, paramLocation, 300, 0.0D, 0.0D, 0.0D, 0.5D, new ItemStack(Material.DIRT));
    paramLocation.getWorld().spawnParticle(Particle.DUST, paramLocation, 32, 1.0D, 0.5D, 1.0D, 0.0D, new Particle.DustOptions(Color.fromRGB(185, 187, 90), 1.0F));
    for (Entity entity : paramLocation.getNearbyEntities(d2, d2, d2)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity)entity;
        try {
          if (!livingEntity.isValid())
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        try {
          if (livingEntity == paramPlayer)
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        try {
          if (Main.isTrusted(paramPlayer, (Entity)livingEntity))
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity, d1, paramPlayer);
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
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), a(27949, -12808), 10.0D);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, a(27942, 7319), 10, ChatColor.YELLOW, BarColor.YELLOW);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(BlockFromToEvent paramBlockFromToEvent) {
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.contains(paramBlockFromToEvent.getBlock().getLocation()))
        try {
          if (paramBlockFromToEvent.getBlock().getType() == Material.LAVA)
            paramBlockFromToEvent.setCancelled(true); 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerArmSwingEvent paramPlayerArmSwingEvent) {
    try {
      if (paramPlayerArmSwingEvent.getHand() != EquipmentSlot.HAND)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Player player = paramPlayerArmSwingEvent.getPlayer();
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), a(27939, -25741)))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), a(27949, -12808), 0.0D);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, a(27947, -15409));
    int i = Main.getInstance().getConfig().getInt(a(27938, 24182), 30);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, i);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, a(27941, -9273), i, ChatColor.YELLOW);
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
    try {
      if (Main.isTrusted(paramPlayer, (Entity)paramLivingEntity))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.getInt(a(27937, 23931), 1);
    int j = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.getInt(a(27962, 1079), 4);
    if (paramLivingEntity instanceof Player) {
      Player player = (Player)paramLivingEntity;
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, a(27946, 16466), j, ChatColor.RED);
    } 
    paramLivingEntity.getWorld().spawnParticle(Particle.FLAME, paramLivingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 50, 0.5D, 1.0D, 0.5D, 0.1D);
    paramLivingEntity.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, paramLivingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 50, 0.5D, 1.0D, 0.5D, 0.1D);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dw(j, paramLivingEntity, i, paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Location paramLocation, Player paramPlayer) {
    Block block = paramLocation.getBlock();
    byte b = 0;
    try {
      while (b < 3)
        b++; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    ArrayList arrayList = new ArrayList();
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dx(arrayList, block)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
    double d = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getDouble(a(27948, -3147), 6.0D);
    for (Entity entity : paramLocation.getNearbyEntities(2.5D, 2.5D, 2.5D)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity)entity;
        try {
          if (livingEntity == paramPlayer)
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        try {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity.getUniqueId(), a(27943, -2402)))
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        try {
          if (Main.isTrusted(paramPlayer, (Entity)livingEntity))
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity, d, paramPlayer);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, livingEntity);
        livingEntity.getWorld().spawnParticle(Particle.FLAME, livingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 12, 0.4D, 0.5D, 0.4D, 0.0D);
        livingEntity.getWorld().spawnParticle(Particle.LAVA, livingEntity.getLocation(), 5, 0.3D, 0.3D, 0.3D, 0.0D);
        livingEntity.getWorld().spawnParticle(Particle.CRIT, livingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 8, 0.3D, 0.5D, 0.3D, 0.1D);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity.getUniqueId(), a(27951, 21782), 1.0D);
        break;
      } 
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, double paramDouble, Particle paramParticle) {
    Vector vector = new Vector(paramDouble, 0.0D, 0.0D);
    int i;
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
    try {
      if (paramEntity instanceof LivingEntity)
        try {
          if (!paramEntity.equals(paramPlayer));
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return false;
  }
  
  private static void lambda$new$0() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      try {
        if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player)) {
          try {
            if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player))
              continue; 
          } catch (MatchException matchException) {
            throw a(null);
          } 
          continue;
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      continue;
      SYNTHETIC_LOCAL_VARIABLE_1.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 0, false, false, false));
    } 
  }
  
  static {
    // Byte code:
    //   0: bipush #18
    //   2: anewarray java/lang/String
    //   5: astore #5
    //   7: iconst_0
    //   8: istore_3
    //   9: ldc '~s7í9Yî+àBo½!Gùr¬&Õèì7ñÆÎ\\r}]CH%~<.aæSÐ°èkÇ^¬÷"I÷ªÍòßú0d}°¹6À:ËÒòh·Ù±N%cuÙ,Ð¦§|æÈ~~;xÐYÄÃ«ß_,¡U(ØþÏDÝQ½§ÀèjæGÈåY©o(¯æé®ÆCÛeæMòiæ -$¹öÌ\\nºMÙBe&·ºGÕ&>£&àÒWa Ì1[Á¤)ËÕ}Ý[\\fÜ×Eå\\nÚ®">gzD]§g\\t¬ùÇPb V6AOã×ï§HÈÐ%"Ö¿l:ªÖ1þ\\nüâ)r\e®y$'
    //   11: dup
    //   12: astore_2
    //   13: invokevirtual length : ()I
    //   16: istore #4
    //   18: bipush #15
    //   20: istore_1
    //   21: iconst_m1
    //   22: istore_0
    //   23: bipush #6
    //   25: iinc #0, 1
    //   28: aload_2
    //   29: iload_0
    //   30: dup
    //   31: iload_1
    //   32: iadd
    //   33: invokevirtual substring : (II)Ljava/lang/String;
    //   36: iconst_m1
    //   37: goto -> 143
    //   40: aload #5
    //   42: swap
    //   43: iload_3
    //   44: iinc #3, 1
    //   47: swap
    //   48: aastore
    //   49: iload_0
    //   50: iload_1
    //   51: iadd
    //   52: dup
    //   53: istore_0
    //   54: iload #4
    //   56: if_icmpge -> 68
    //   59: aload_2
    //   60: iload_0
    //   61: invokevirtual charAt : (I)C
    //   64: istore_1
    //   65: goto -> 23
    //   68: ldc 'æ½%dAç7ÊD°wÎN0\\tH-!vûïF®¥^\\fHyN\\rÖ'
    //   70: dup
    //   71: astore_2
    //   72: invokevirtual length : ()I
    //   75: istore #4
    //   77: bipush #18
    //   79: istore_1
    //   80: iconst_m1
    //   81: istore_0
    //   82: bipush #74
    //   84: iinc #0, 1
    //   87: aload_2
    //   88: iload_0
    //   89: dup
    //   90: iload_1
    //   91: iadd
    //   92: invokevirtual substring : (II)Ljava/lang/String;
    //   95: iconst_0
    //   96: goto -> 143
    //   99: aload #5
    //   101: swap
    //   102: iload_3
    //   103: iinc #3, 1
    //   106: swap
    //   107: aastore
    //   108: iload_0
    //   109: iload_1
    //   110: iadd
    //   111: dup
    //   112: istore_0
    //   113: iload #4
    //   115: if_icmpge -> 127
    //   118: aload_2
    //   119: iload_0
    //   120: invokevirtual charAt : (I)C
    //   123: istore_1
    //   124: goto -> 82
    //   127: aload #5
    //   129: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.a : [Ljava/lang/String;
    //   132: bipush #18
    //   134: anewarray java/lang/String
    //   137: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.b : [Ljava/lang/String;
    //   140: goto -> 300
    //   143: dup_x2
    //   144: pop
    //   145: invokevirtual toCharArray : ()[C
    //   148: dup_x1
    //   149: arraylength
    //   150: dup_x2
    //   151: pop
    //   152: iconst_0
    //   153: istore #6
    //   155: dup2_x1
    //   156: pop2
    //   157: dup_x2
    //   158: iconst_1
    //   159: if_icmpgt -> 260
    //   162: dup2
    //   163: swap
    //   164: iload #6
    //   166: dup2_x1
    //   167: caload
    //   168: swap
    //   169: iload #6
    //   171: bipush #7
    //   173: irem
    //   174: tableswitch default -> 242, 0 -> 212, 1 -> 217, 2 -> 222, 3 -> 227, 4 -> 232, 5 -> 237
    //   212: bipush #126
    //   214: goto -> 244
    //   217: bipush #79
    //   219: goto -> 244
    //   222: bipush #103
    //   224: goto -> 244
    //   227: bipush #32
    //   229: goto -> 244
    //   232: bipush #48
    //   234: goto -> 244
    //   237: bipush #66
    //   239: goto -> 244
    //   242: bipush #61
    //   244: ixor
    //   245: ixor
    //   246: i2c
    //   247: castore
    //   248: iinc #6, 1
    //   251: dup
    //   252: ifne -> 260
    //   255: dup2
    //   256: dup_x1
    //   257: goto -> 166
    //   260: dup2_x1
    //   261: pop2
    //   262: dup_x2
    //   263: iload #6
    //   265: if_icmpgt -> 162
    //   268: pop
    //   269: new java/lang/String
    //   272: dup_x1
    //   273: swap
    //   274: invokespecial <init> : ([C)V
    //   277: invokevirtual intern : ()Ljava/lang/String;
    //   280: swap
    //   281: pop
    //   282: swap
    //   283: tableswitch default -> 40, 0 -> 99
    //   300: sipush #27963
    //   303: sipush #17389
    //   306: invokestatic a : (II)Ljava/lang/String;
    //   309: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : Ljava/lang/String;
    //   312: sipush #27944
    //   315: sipush #12540
    //   318: invokestatic a : (II)Ljava/lang/String;
    //   321: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : Ljava/lang/String;
    //   324: new org/bukkit/NamespacedKey
    //   327: dup
    //   328: invokestatic getInstance : ()Lpl/Main;
    //   331: sipush #27940
    //   334: sipush #30101
    //   337: invokestatic a : (II)Ljava/lang/String;
    //   340: invokespecial <init> : (Lorg/bukkit/plugin/Plugin;Ljava/lang/String;)V
    //   343: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d : Lorg/bukkit/NamespacedKey;
    //   346: new java/util/HashSet
    //   349: dup
    //   350: invokespecial <init> : ()V
    //   353: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : Ljava/util/Set;
    //   356: invokestatic getInstance : ()Lpl/Main;
    //   359: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   362: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f : Lorg/bukkit/configuration/file/FileConfiguration;
    //   365: return
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0x6D2B) & 0xFFFF;
    if (b[i] == null) {
      char[] arrayOfChar = a[i].toCharArray();
      switch (arrayOfChar[0] & 0xFF) {
        case 0:
        
        case 1:
        
        case 2:
        
        case 3:
        
        case 4:
        
        case 5:
        
        case 6:
        
        case 7:
        
        case 8:
        
        case 9:
        
        case 10:
        
        case 11:
        
        case 12:
        
        case 13:
        
        case 14:
        
        case 15:
        
        case 16:
        
        case 17:
        
        case 18:
        
        case 19:
        
        case 20:
        
        case 21:
        
        case 22:
        
        case 23:
        
        case 24:
        
        case 25:
        
        case 26:
        
        case 27:
        
        case 28:
        
        case 29:
        
        case 30:
        
        case 31:
        
        case 32:
        
        case 33:
        
        case 34:
        
        case 35:
        
        case 36:
        
        case 37:
        
        case 38:
        
        case 39:
        
        case 40:
        
        case 41:
        
        case 42:
        
        case 43:
        
        case 44:
        
        case 45:
        
        case 46:
        
        case 47:
        
        case 48:
        
        case 49:
        
        case 50:
        
        case 51:
        
        case 52:
        
        case 53:
        
        case 54:
        
        case 55:
        
        case 56:
        
        case 57:
        
        case 58:
        
        case 59:
        
        case 60:
        
        case 61:
        
        case 62:
        
        case 63:
        
        case 64:
        
        case 65:
        
        case 66:
        
        case 67:
        
        case 68:
        
        case 69:
        
        case 70:
        
        case 71:
        
        case 72:
        
        case 73:
        
        case 74:
        
        case 75:
        
        case 76:
        
        case 77:
        
        case 78:
        
        case 79:
        
        case 80:
        
        case 81:
        
        case 82:
        
        case 83:
        
        case 84:
        
        case 85:
        
        case 86:
        
        case 87:
        
        case 88:
        
        case 89:
        
        case 90:
        
        case 91:
        
        case 92:
        
        case 93:
        
        case 94:
        
        case 95:
        
        case 96:
        
        case 97:
        
        case 98:
        
        case 99:
        
        case 100:
        
        case 101:
        
        case 102:
        
        case 103:
        
        case 104:
        
        case 105:
        
        case 106:
        
        case 107:
        
        case 108:
        
        case 109:
        
        case 110:
        
        case 111:
        
        case 112:
        
        case 113:
        
        case 114:
        
        case 115:
        
        case 116:
        
        case 117:
        
        case 118:
        
        case 119:
        
        case 120:
        
        case 121:
        
        case 122:
        
        case 123:
        
        case 124:
        
        case 125:
        
        case 126:
        
        case 127:
        
        case 128:
        
        case 129:
        
        case 130:
        
        case 131:
        
        case 132:
        
        case 133:
        
        case 134:
        
        case 135:
        
        case 136:
        
        case 137:
        
        case 138:
        
        case 139:
        
        case 140:
        
        case 141:
        
        case 142:
        
        case 143:
        
        case 144:
        
        case 145:
        
        case 146:
        
        case 147:
        
        case 148:
        
        case 149:
        
        case 150:
        
        case 151:
        
        case 152:
        
        case 153:
        
        case 154:
        
        case 155:
        
        case 156:
        
        case 157:
        
        case 158:
        
        case 159:
        
        case 160:
        
        case 161:
        
        case 162:
        
        case 163:
        
        case 164:
        
        case 165:
        
        case 166:
        
        case 167:
        
        case 168:
        
        case 169:
        
        case 170:
        
        case 171:
        
        case 172:
        
        case 173:
        
        case 174:
        
        case 175:
        
        case 176:
        
        case 177:
        
        case 178:
        
        case 179:
        
        case 180:
        
        case 181:
        
        case 182:
        
        case 183:
        
        case 184:
        
        case 185:
        
        case 186:
        
        case 187:
        
        case 188:
        
        case 189:
        
        case 190:
        
        case 191:
        
        case 192:
        
        case 193:
        
        case 194:
        
        case 195:
        
        case 196:
        
        case 197:
        
        case 198:
        
        case 199:
        
        case 200:
        
        case 201:
        
        case 202:
        
        case 203:
        
        case 204:
        
        case 205:
        
        case 206:
        
        case 207:
        
        case 208:
        
        case 209:
        
        case 210:
        
        case 211:
        
        case 212:
        
        case 213:
        
        case 214:
        
        case 215:
        
        case 216:
        
        case 217:
        
        case 218:
        
        case 219:
        
        case 220:
        
        case 221:
        
        case 222:
        
        case 223:
        
        case 224:
        
        case 225:
        
        case 226:
        
        case 227:
        
        case 228:
        
        case 229:
        
        case 230:
        
        case 231:
        
        case 232:
        
        case 233:
        
        case 234:
        
        case 235:
        
        case 236:
        
        case 237:
        
        case 238:
        
        case 239:
        
        case 240:
        
        case 241:
        
        case 242:
        
        case 243:
        
        case 244:
        
        case 245:
        
        case 246:
        
        case 247:
        
        case 248:
        
        case 249:
        
        case 250:
        
        case 251:
        
        case 252:
        
        case 253:
        
        case 254:
        
        default:
          break;
      } 
      char c = 'Ç';
      int j = (paramInt2 & 0xFF) - c;
      if (j < 0)
        j += 256; 
      int k = ((paramInt2 & 0xFFFF) >>> 8) - c;
      if (k < 0)
        k += 256; 
      for (byte b = 0; b < arrayOfChar.length; b++) {
        int m = b % 2;
        if (m == 0) {
          arrayOfChar[b] = (char)(arrayOfChar[b] ^ j);
          j = ((j >>> 3 | j << 5) ^ arrayOfChar[b]) & 0xFF;
        } else {
          arrayOfChar[b] = (char)(arrayOfChar[b] ^ k);
          k = ((k >>> 3 | k << 5) ^ arrayOfChar[b]) & 0xFF;
        } 
      } 
      b[i] = (new String(arrayOfChar)).intern();
    } 
    return b[i];
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */