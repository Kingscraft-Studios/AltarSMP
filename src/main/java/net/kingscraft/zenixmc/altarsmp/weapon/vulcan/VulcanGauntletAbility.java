package net.kingscraft.zenixmc.altarsmp.weapon.vulcan;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public class VulcanGauntletAbility implements Listener {
  public AltarSMP plugin;

  public Set<Player> chargedCrossbowUsers = new HashSet<>();

  private static final NamespacedKey PASSIVE_SIDE_KEY =
          new NamespacedKey(AltarSMP.getInstance(), "passive_side");

  private static final NamespacedKey PASSIVE_MAIN_KEY =
          new NamespacedKey(AltarSMP.getInstance(), "passive_main");


  public VulcanGauntletAbility(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
  }

  public static boolean hasVulcanCrossbow(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    {
      if (itemStack.getType() != Material.CROSSBOW)
        return false;
    }{
      if (!itemStack.hasItemMeta())
        return false;
    }ItemMeta itemMeta = itemStack.getItemMeta();
    {
      if (itemMeta == null)
        return false;
    }{
      List<Float> customModelData = itemMeta.getCustomModelDataComponent().getFloats();
      return !customModelData.isEmpty() && customModelData.getFirst() == 1;
    }
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent paramPlayerInteractEvent) {
    Player player = paramPlayerInteractEvent.getPlayer();
    ItemStack itemStack = player.getInventory().getItemInMainHand();

    if (!hasVulcanCrossbow(player)) {
      return;
    }

    CrossbowMeta crossbowMeta = (CrossbowMeta) itemStack.getItemMeta();
    if (!crossbowMeta.hasChargedProjectiles()) {
      return;
    }

    if (paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR
            && paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }

    paramPlayerInteractEvent.setCancelled(true);
    crossbowMeta.setChargedProjectiles(null);
    itemStack.setItemMeta(crossbowMeta);

    if (player.isSneaking() || CooldownManager.isOnCooldown(player.getUniqueId(), "charged_vulcan_powershot")) {
      if (!CooldownManager.isOnCooldown(player.getUniqueId(), "vulcan_powershot")) {
        CooldownManager.setCooldown(player.getUniqueId(), "charged_vulcan_powershot", 0.0D);
        activateVulcansWrath(player);
        return;
      }
    }

    firePassiveArrows(player);
  }

  public static void firePassiveArrows(Player paramPlayer) {
    World world = paramPlayer.getWorld();
    world.playSound(paramPlayer.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1.0F, 0.8F);
    world.playSound(paramPlayer.getLocation(), Sound.ENTITY_WARDEN_SONIC_BOOM, 1.0F, 1.5F);
    world.playSound(paramPlayer.getLocation(), Sound.ENTITY_GENERIC_EXTINGUISH_FIRE, 1.0F, 1.0F);
    world.playSound(paramPlayer.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 1.0F, 0.0F);
    Vector vector = paramPlayer.getLocation().getDirection().normalize();
    Vector vector2 = paramPlayer.getVelocity();
    Location location = paramPlayer.getLocation().clone().add(0.0D, 1.6D, 0.0D).add(vector.clone().multiply(1.5D));
    Vector vector3 = vector.clone().crossProduct(new Vector(0, 1, 0)).normalize();
    Location location2 = location.clone().add(vector3.clone().multiply(2));
    Location location3 = location.clone().subtract(vector3.clone().multiply(2));
    Arrow arrow = (Arrow)world.spawnEntity(location, EntityType.ARROW, SpawnReason.CUSTOM, entity -> lambda$passiveArrows$0(paramPlayer, vector, vector2, entity));
    Arrow arrow2 = (Arrow)world.spawnEntity(location2, EntityType.ARROW, SpawnReason.CUSTOM, entity -> lambda$passiveArrows$1(paramPlayer, vector, vector2, entity));
    Arrow arrow3 = (Arrow)world.spawnEntity(location3, EntityType.ARROW, SpawnReason.CUSTOM, entity -> lambda$passiveArrows$2(paramPlayer, vector, vector2, entity));
    (new VulcanArrowTrailTask(arrow, arrow2, arrow3, world)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  @EventHandler
  public void onProjectileHit(ProjectileHitEvent paramProjectileHitEvent) {
    double d = AltarSMP.getInstance().getConfig().getDouble("vulcansScattershotDamage", 12.0D);
    Projectile projectile = paramProjectileHitEvent.getEntity();
    if (!(projectile instanceof Arrow arrow)) {
      return;
    }
    ProjectileSource projectileSource = arrow.getShooter();
    if (!(projectileSource instanceof Player player)) {
      return;
    }
    Entity entity = paramProjectileHitEvent.getHitEntity();
    if (!(entity instanceof LivingEntity livingEntity)) {
      return;
    }

    if (arrow.getPersistentDataContainer().has(PASSIVE_SIDE_KEY, PersistentDataType.BYTE)
            || arrow.getPersistentDataContainer().has(PASSIVE_MAIN_KEY, PersistentDataType.BYTE)) {
      livingEntity.damage(d, player);
      if (arrow.getPersistentDataContainer().has(PASSIVE_MAIN_KEY, PersistentDataType.BYTE)) {
        livingEntity.setFireTicks(80);
      }
    }
  }

  public void activateVulcansWrath(Player paramPlayer) {
    int i = AltarSMP.getInstance().getConfig().getInt("legendaryLimit", -1);
    {
      if (i != -1)
        {
          if (CustomItem.countInInventory(paramPlayer) > i) {
            paramPlayer.sendMessage(Component.text("The legendary limit is " + i, NamedTextColor.YELLOW));
            paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
            return;
          }
        }}int j = this.plugin.getConfig().getInt("vulcansWrathCooldown", 45);
    paramPlayer.setVelocity(paramPlayer.getLocation().getDirection().normalize().multiply(-0.5D));
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 1.0F, 0.0F);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_WARDEN_SONIC_BOOM, 1.0F, 1.0F);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "vulcan_powershot", j);
    (new VulcanChargedCrossbowCleanupTask(this, paramPlayer)).runTaskLater(this.plugin, 5L);
    BossBarManager.createBar(paramPlayer, "Vulcan's Wrath", j, NamedTextColor.YELLOW);
    Location location = paramPlayer.getEyeLocation();
    Vector vector1 = location.getDirection().normalize();
    ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawnEntity(location.add(vector1.clone().multiply(0.5D)), EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(new ItemStack(Material.MAGMA_BLOCK));
    itemDisplay.setTransformation(new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new AxisAngle4f((float)Math.toRadians(90.0D), 1.0F, 0.0F, 0.0F), new Vector3f(0.75F, 0.75F, 0.75F), new AxisAngle4f(0.0F, 0.0F, 0.0F, 1.0F)));
    double d = AltarSMP.getInstance().getConfig().getInt("vulcanPower", 2);
    Vector vector2 = vector1.multiply(d);
    (new VulcanMagmaProjectileTask(this, vector2, itemDisplay, paramPlayer)).runTaskTimer(this.plugin, 0L, 1L);
  }

  public void createVulcanExplosion(Location paramLocation, Player paramPlayer) {
    int i = this.plugin.getConfig().getInt("vulcanExplosionRadius", 4);
    paramLocation = findSafeExplosionLocation(paramLocation, 10).clone().subtract(0.0D, ((double) i / 2), 0.0D);
    paramLocation.getWorld().spawnParticle(Particle.FLAME, paramLocation, 150, 0.0D, 0.0D, 0.0D, 0.5D);
    double d = this.plugin.getConfig().getDouble("vulcansWrathDamage", 8.0D);
    boolean bool = this.plugin.getConfig().getBoolean("vulcanWrathVisual", false);
    paramLocation.getWorld().playSound(paramLocation, Sound.ENTITY_GENERIC_EXPLODE, 5.0F, 0.0F);
    World world = paramLocation.getWorld();
    {
      if (world == null)
        return;
    }Set<Material> set = Set.of(Material.BEDROCK, Material.END_PORTAL, Material.END_PORTAL_FRAME, Material.BARRIER, Material.COMMAND_BLOCK, Material.END_GATEWAY);
    Random random = new Random();
    int j;
    for (j = -i; j <= i; j++) {
      for (int k = -i; k <= i; k++) {
        for (int m = -i; m <= i; m++) {
          Location location = paramLocation.clone().add(j, k, m);
          Block block = location.getBlock();
          {
            if (!set.contains(block.getType()))
              {
                if (k <= i - 1) {
                  double d1 = location.distance(paramLocation);
                  {
                    if (d1 <= i)
                      {
                        if (random.nextDouble() <= 0.8D)
                          {
                            if (!bool)
                              block.setType(Material.LAVA);
                          }}}}
              }}}
      }
    }
    for (j = -i; j <= i; j++) {
      for (int k = -i; k <= i; k++) {
        for (int m = -i; m <= i; m++) {
          Location location = paramLocation.clone().add(j, k, m);
          Block block = location.getBlock();
          {
            if (!set.contains(block.getType()))
              {
                if (location.distance(paramLocation) <= i)
                  {
                    if (k <= i - 1)
                      {
                        if (random.nextDouble() <= 0.6D)
                          {
                            if (!bool) {
                              block.setType(Material.MAGMA_BLOCK);
                            } else {
                              spawnMagmaBlockDisplay(block.getLocation(), Material.MAGMA_BLOCK.createBlockData());
                            }
                          }}}}}}
      }
    }
    for (j = -i; j <= i; j++) {
      for (int k = -i; k <= i; k++) {
        for (int m = -i; m <= i; m++) {
          Location location = paramLocation.clone().add(j, k, m);
          Block block = location.getBlock();
          {
            if (!set.contains(block.getType()))
              {
                if (location.distance(paramLocation) <= i)
                  {
                    if (random.nextDouble() <= 0.4D)
                      {
                        if (!bool)
                          block.setType(Material.FIRE);
                      }}}}}
      }
    }
    for (Entity entity : world.getNearbyEntities(paramLocation, i, i, i)) {
      if (entity instanceof LivingEntity livingEntity) {
          {
          if (livingEntity == paramPlayer)
            continue;
        }{
          if (AltarSMP.isTrusted(paramPlayer, livingEntity))
            continue;
        }
          TrueDamage.apply(livingEntity, d, paramPlayer);
      }
    }
  }

  public static void spawnMagmaBlockDisplay(Location paramLocation, BlockData paramBlockData) {
    BlockDisplay blockDisplay = (BlockDisplay)paramLocation.getWorld().spawnEntity(paramLocation, EntityType.BLOCK_DISPLAY);
    blockDisplay.setBlock(paramBlockData);
    Transformation transformation = blockDisplay.getTransformation();
    transformation.getScale().set(1.01D, 1.01D, 1.01D);
    blockDisplay.setTransformation(transformation);
    (new VulcanMagmaBlockShrinkTask(blockDisplay)).runTaskLater(AltarSMP.getInstance(), 100L);
  }

  public static Location findSafeExplosionLocation(Location paramLocation, int paramInt) {
    paramLocation = paramLocation.set(paramLocation.getX(), paramLocation.getBlock().getLocation().getY() + 0.5D, paramLocation.getZ());
    {
      if (isSafeExplosionLocation(paramLocation))
        return paramLocation;
    }for (int b = 1; b <= paramInt; b++) {
      Location location1 = paramLocation.clone().add(0.0D, b, 0.0D);
      {
        if (isSafeExplosionLocation(location1))
          return location1;
      }Location location2 = paramLocation.clone().add(0.0D, -b, 0.0D);
      {
        if (isSafeExplosionLocation(location2))
          return location2;
      }}
    return paramLocation;
  }

  public static boolean isSafeExplosionLocation(Location paramLocation) {
    {
      if (paramLocation.getBlock().getType() != Material.WATER)
        {
          if (paramLocation.getBlock().getType() != Material.LAVA) {
            {
              if (paramLocation.getBlock().getType().isSolid()) {
                {
                    return !paramLocation.clone().add(0.0D, 1.0D, 0.0D).getBlock().getType().isSolid();
                }
              }
            }return false;
          }
        }}{
          return !paramLocation.clone().add(0.0D, 1.0D, 0.0D).getBlock().getType().isSolid();
    }
  }

  private static void lambda$passiveArrows$2(Player paramPlayer, Vector paramVector1, Vector paramVector2, Entity paramEntity) {
    Arrow arrow = (Arrow)paramEntity;
    arrow.setRotation(paramPlayer.getYaw(), paramPlayer.getPitch());
    arrow.setVelocity(paramVector1.clone().multiply(3).add(paramVector2));
    arrow.setDamage(0.0D);
    arrow.setShooter(paramPlayer);
    arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
    arrow.getPersistentDataContainer().set(PASSIVE_SIDE_KEY, PersistentDataType.BYTE, (byte) 1);
  }

  private static void lambda$passiveArrows$1(Player paramPlayer, Vector paramVector1, Vector paramVector2, Entity paramEntity) {
    Arrow arrow = (Arrow)paramEntity;
    arrow.setRotation(paramPlayer.getYaw(), paramPlayer.getPitch());
    arrow.setVelocity(paramVector1.clone().multiply(3).add(paramVector2));
    arrow.setDamage(0.0D);
    arrow.setShooter(paramPlayer);
    arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
    arrow.getPersistentDataContainer().set(PASSIVE_SIDE_KEY, PersistentDataType.BYTE, (byte) 1);
  }

  private static void lambda$passiveArrows$0(Player paramPlayer, Vector paramVector1, Vector paramVector2, Entity paramEntity) {
    Arrow arrow = (Arrow)paramEntity;
    arrow.setRotation(paramPlayer.getYaw(), paramPlayer.getPitch());
    arrow.setVelocity(paramVector1.clone().multiply(3).add(paramVector2));
    arrow.setDamage(0.0D);
    arrow.setShooter(paramPlayer);
    arrow.setPierceLevel(3);
    arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
    arrow.getPersistentDataContainer().set(PASSIVE_MAIN_KEY, PersistentDataType.BYTE, (byte) 1);
  }



}
