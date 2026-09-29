package pl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;
import java.util.HashMap;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764_ implements Listener {
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public static final Map<LivingEntity, List<ItemDisplay>> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  public static final Map<LivingEntity, Location> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    Location location = paramPlayer.getLocation();
    double d1 = Main.getInstance().getConfig().getDouble("skeletalLeapDistance", 1.5D);
    double d2 = Main.getInstance().getConfig().getDouble("skeletalLeapDamage", 14.0D);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location, Material.BONE, 10, 2.0D, 15);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c1(paramPlayer, d2)).runTaskTimer((Plugin)Main.getInstance(), 3L, 1L);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1.0F, 1.0F);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_SKELETON_DEATH, 1.0F, 0.8F);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c2(paramPlayer)).runTaskLater((Plugin)Main.getInstance(), 2L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c3(paramPlayer)).runTaskLater((Plugin)Main.getInstance(), 4L);
    paramPlayer.setVelocity(paramPlayer.getLocation().getDirection().multiply(d1));
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 2));
    int i = Main.getInstance().getConfig().getInt("skeletalLeapCooldown", 30);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "Skeletal Leap", i, ChatColor.YELLOW);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Material paramMaterial, int paramInt1, double paramDouble, int paramInt2) {
    paramDouble *= 0.1D;
    World world = paramLocation.getWorld();
    ArrayList<Item> arrayList = new ArrayList();
    for (byte b = 0; b < paramInt1; b++) {
      Item item = world.dropItem(paramLocation.clone(), new ItemStack(paramMaterial));
      item.setPickupDelay(2147483647);
      item.setVelocity(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramDouble));
      arrayList.add(item);
    } 
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c4(arrayList)).runTaskLater((Plugin)Main.getInstance(), 5L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c5(arrayList)).runTaskLater((Plugin)Main.getInstance(), paramInt2);
  }
  
  private static Vector You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(double paramDouble) {
    while (true) {
      double d1 = (Math.random() - 0.5D) * 2.0D;
      double d2 = Math.random();
      double d3 = (Math.random() - 0.5D) * 2.0D;
      Vector vector = new Vector(d1, d2, d3);
      if (vector.lengthSquared() >= 1.0E-4D)
        return vector.normalize().multiply(paramDouble); 
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    int i = Main.getInstance().getConfig().getInt("boneCageLength", 30);
    int j = Main.getInstance().getConfig().getInt("boneCageStunDuration", 4);
    int k = Main.getInstance().getConfig().getInt("boneCageCooldown", 20);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_SKELETON_AMBIENT, 1.0F, 0.8F);
    Location location = paramPlayer.getLocation().clone().add(0.0D, 1.0D, 0.0D);
    Vector vector = location.getDirection().normalize();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "Bone Cage", k, ChatColor.YELLOW);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c6(i, location, vector, paramPlayer, j)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(LivingEntity paramLivingEntity, int paramInt) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764t.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLivingEntity.getLocation()))
        return; 
    }paramLivingEntity.getWorld().playSound(paramLivingEntity.getLocation(), Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 2.0F, 0.7F);
    paramLivingEntity.getWorld().playSound(paramLivingEntity.getLocation(), Sound.ENTITY_SKELETON_DEATH, 1.0F, 0.8F);
    paramLivingEntity.getWorld().spawnParticle(Particle.ITEM, paramLivingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 32, 1.0D, 1.0D, 1.0D, 2.0D, new ItemStack(Material.BONE));
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLivingEntity.getLocation().clone().add(0.0D, 1.0D, 0.0D), Material.BONE, 30, 3.0D, 25);
    ArrayList<ItemDisplay> arrayList = new ArrayList();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.put(paramLivingEntity, arrayList);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c7(paramLivingEntity)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
    for (byte b = 0; b < 3; b++) {
      ItemDisplay itemDisplay = (ItemDisplay)paramLivingEntity.getWorld().spawnEntity(paramLivingEntity.getLocation().add(0.0D, 1.0D, 0.0D), EntityType.ITEM_DISPLAY);
      itemDisplay.setItemStack(new ItemStack(Material.BONE_BLOCK));
      itemDisplay.setTransformation(new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new AxisAngle4f(0.0F, 0.0F, 0.0F, 1.0F), new Vector3f(0.4F, 0.4F, 0.4F), new AxisAngle4f(0.0F, 0.0F, 0.0F, 1.0F)));
      itemDisplay.setBillboard(Display.Billboard.CENTER);
      arrayList.add(itemDisplay);
    } 
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c8(paramInt, arrayList, paramLivingEntity)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerDeathEvent paramPlayerDeathEvent) {
    Player player = paramPlayerDeathEvent.getEntity();
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.containsKey(player))
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(player); 
    }if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(player)) {
      List list = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.get(player);
      ((List<ItemDisplay>)(List<?>)list).forEach(Entity::remove);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(player);
    } 
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerMoveEvent paramPlayerMoveEvent) {
    Player player = paramPlayerMoveEvent.getPlayer();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(player))
        return; 
    }Location location1 = paramPlayerMoveEvent.getFrom();
    Location location2 = paramPlayerMoveEvent.getTo();
    Location location3 = location1.clone();
    location3.setYaw(location2.getYaw());
    location3.setPitch(location2.getPitch());
    paramPlayerMoveEvent.setTo(location3);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractEvent paramPlayerInteractEvent) {
    {
      if (!Main.getInstance().getConfig().getBoolean("boneCageStopInteractions", false))
        return; 
    }Player player = paramPlayerInteractEvent.getPlayer();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(player))
        return; 
    }paramPlayerInteractEvent.setCancelled(true);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerItemConsumeEvent paramPlayerItemConsumeEvent) {
    {
      if (!Main.getInstance().getConfig().getBoolean("boneCageStopInteractions", false))
        return; 
    }Player player = paramPlayerItemConsumeEvent.getPlayer();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(player))
        return; 
    }paramPlayerItemConsumeEvent.setCancelled(true);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerDropItemEvent paramPlayerDropItemEvent) {
    {
      if (!Main.getInstance().getConfig().getBoolean("boneCageStopInteractions", false))
        return; 
    }Player player = paramPlayerDropItemEvent.getPlayer();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(player))
        return; 
    }paramPlayerDropItemEvent.setCancelled(true);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(InventoryClickEvent paramInventoryClickEvent) {
    {
      if (!Main.getInstance().getConfig().getBoolean("boneCageStopInteractions", false))
        return; 
    }Player player = (Player)paramInventoryClickEvent.getWhoClicked();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(player))
        return; 
    }paramInventoryClickEvent.setCancelled(true);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractEntityEvent paramPlayerInteractEntityEvent) {
    {
      if (!Main.getInstance().getConfig().getBoolean("boneCageStopInteractions", false))
        return; 
    }Player player = paramPlayerInteractEntityEvent.getPlayer();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(player))
        return; 
    }paramPlayerInteractEntityEvent.setCancelled(true);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ProjectileLaunchEvent paramProjectileLaunchEvent) {
    LivingEntity livingEntity;
    {
      if (!Main.getInstance().getConfig().getBoolean("boneCageStopInteractions", false))
        return; 
    }ProjectileSource projectileSource = paramProjectileLaunchEvent.getEntity().getShooter();
    if (projectileSource instanceof LivingEntity) {
      livingEntity = (LivingEntity)projectileSource;
    } else {
      return;
    } 
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(livingEntity))
        return; 
    }paramProjectileLaunchEvent.setCancelled(true);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    LivingEntity livingEntity;
    {
      if (!Main.getInstance().getConfig().getBoolean("boneCageStopAttacking", true))
        return; 
    }Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof LivingEntity) {
      livingEntity = (LivingEntity)entity;
    } else {
      return;
    } 
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(livingEntity))
        return; 
    }paramEntityDamageByEntityEvent.setCancelled(true);
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = "bone_blade_bone_cage";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = "bone_blade_skeletal_leap";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new HashMap<>();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = new HashMap<>();
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764_.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */