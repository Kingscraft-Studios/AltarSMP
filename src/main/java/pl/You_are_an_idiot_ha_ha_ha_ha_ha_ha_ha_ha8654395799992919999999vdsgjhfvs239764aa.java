package pl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import java.util.HashMap;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa implements Listener {
  public static Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  public static Map<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  public static Map<UUID, Long> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  public static final int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = 23;
  
  public static final int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = 30;
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa(Main paramMain) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ItemStack paramItemStack) {
    {
      if (paramItemStack.getType() != Material.NETHERITE_SWORD)
        return false; 
    }{
      if (!paramItemStack.hasItemMeta())
        return false; 
    }ItemMeta itemMeta = paramItemStack.getItemMeta();
    {
      if (itemMeta == null)
        return false; 
    }{
      if (!itemMeta.hasCustomModelData())
        return false; 
    }{
    
    }return (itemMeta.getCustomModelData() == 4);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    {
      if (!(paramEntityDamageByEntityEvent.getDamager() instanceof Player))
        return; 
    }Player player = (Player)paramEntityDamageByEntityEvent.getDamager();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getInventory().getItemInMainHand()))
        return; 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, paramEntityDamageByEntityEvent.getEntity().getLocation().add(0.0D, 1.0D, 0.0D));
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerItemConsumeEvent paramPlayerItemConsumeEvent) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayerItemConsumeEvent.getItem())) {
        paramPlayerItemConsumeEvent.setCancelled(true);
        (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c9(this, paramPlayerItemConsumeEvent)).runTaskLater((Plugin)Main.getInstance(), 1L);
        if (!CooldownManager.isOnCooldown(paramPlayerItemConsumeEvent.getPlayer().getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c)) {
          int i = Main.getInstance().getConfig().getInt("scytheThrowCooldown", 30);
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayerItemConsumeEvent.getPlayer());
          BossBarManager.createBar(paramPlayerItemConsumeEvent.getPlayer(), "Scythe Throw", i, ChatColor.YELLOW);
          CooldownManager.setCooldown(paramPlayerItemConsumeEvent.getPlayer().getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, i);
        } 
      } 
    }}
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, double paramDouble, boolean paramBoolean1, boolean paramBoolean2) {
    byte b1 = 35;
    double d = 2.2D;
    for (byte b2 = 0; b2 < b1; b2++) {
      double d2 = 0;
      double d3 = 0;
      double d4 = 0;
      double d1 = b2 / b1;
      if (!paramBoolean1)
        d1 = 1.0D - d1; 
      if (paramBoolean2) {
        double d5 = (d1 - 0.5D) * d;
        d2 = Math.cos(paramDouble) * d5;
        d3 = (1.0D - d1) * d * 0.8D;
        d4 = Math.sin(paramDouble) * d5;
      } else {
        double d5 = (d1 - 0.5D) * d;
        d2 = Math.cos(paramDouble) * d5;
        {
        
        }d3 = paramBoolean1 ? ((1.0D - d1) * d * 0.8D) : ((d1 - 1.0D) * d * 0.8D);
        d4 = Math.sin(paramDouble) * d5;
      } 
      Location location = paramLocation.clone().add(d2, d3, d4);
      paramLocation.getWorld().spawnParticle(Particle.ENCHANTED_HIT, location, 3, 0.08D, 0.08D, 0.08D, 0.0D);
      paramLocation.getWorld().spawnParticle(Particle.BLOCK, location, 3, 0.08D, 0.08D, 0.08D, 0.0D, Material.ICE.createBlockData());
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, Location paramLocation) {
    int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
    double d = Math.toRadians(paramPlayer.getLocation().getYaw());
    {
      switch (i % 4) {
        case 0:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, d, true, false);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ITEM_TRIDENT_THROW, 1.0F, 1.0F);
          break;
        case 1:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, d, false, false);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ITEM_TRIDENT_THROW, 1.0F, 1.0F);
          break;
        case 2:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, d, true, true);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ITEM_TRIDENT_THROW, 1.0F, 1.0F);
          break;
        case 3:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, d, false, true);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ITEM_TRIDENT_THROW, 1.0F, 1.0F);
          break;
      } 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
  }
  
  public static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    long l = System.currentTimeMillis();
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.containsKey(paramPlayer.getUniqueId()))
        {
          if (l - ((Long)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.get(paramPlayer.getUniqueId())).longValue() > 2500L)
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.put(paramPlayer.getUniqueId(), Integer.valueOf(0)); 
        }}return ((Integer)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.getOrDefault(paramPlayer.getUniqueId(), Integer.valueOf(0))).intValue();
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(Player paramPlayer) {
    int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.put(paramPlayer.getUniqueId(), Integer.valueOf(i + 1));
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.put(paramPlayer.getUniqueId(), Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    {
      if (!Main.getInstance().getConfig().getBoolean("holdForThrowFrostScythe", true)) {
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BREEZE_INHALE, 1.0F, 1.0F);
        paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 20, 4));
      } 
    }double d = Main.getInstance().getConfig().getInt("scytheThrowPower", 2);
    int i = Main.getInstance().getConfig().getInt("scytheThrowMaxThrow", 100);
    int j = Main.getInstance().getConfig().getInt("scytheThrowDamage", 8);
    boolean bool = Main.getInstance().getConfig().getBoolean("scytheThrowReturnScythe", true);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c_(paramPlayer, bool, d, i, j)).runTaskLater((Plugin)Main.getInstance(), 20L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, ItemDisplay paramItemDisplay, double paramDouble) {
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dc(paramPlayer, paramItemDisplay, paramDouble)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static Boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    PlayerInventory playerInventory = paramPlayer.getInventory();
    byte b = 0;
    while (true) {
      {
        if (b < 36) {
          {
            if (playerInventory.getItem(b) == null)
              return Boolean.valueOf(true); 
          }b++;
          continue;
        } 
      }return Boolean.valueOf(false);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, ItemDisplay paramItemDisplay) {
    {
      if (!paramPlayer.getWorld().equals(paramItemDisplay.getWorld()))
        return; 
    }{
      if (paramPlayer.getInventory().contains(CustomItemRegistry.getCrazySlots())) {
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramItemDisplay.getItemStack())) {
            paramItemDisplay.remove();
          } else {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer, paramItemDisplay);
          } 
        }} else {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer, paramItemDisplay);
      } 
    }}
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer, ItemDisplay paramItemDisplay) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(paramPlayer).booleanValue()) {
        paramItemDisplay.remove();
        paramPlayer.getInventory().addItem(new ItemStack[] { paramItemDisplay.getItemStack() });
      } else {
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramItemDisplay.getItemStack())) {
            paramItemDisplay.remove();
            return;
          } 
        }BukkitTask bukkitTask = (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dd(paramPlayer, paramItemDisplay)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
      } 
    }}
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    ArrayList<ItemDisplay> arrayList = new ArrayList();
    Location location = paramPlayer.getLocation();
    int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getInt("commandOfIceCooldown", 45);
    BossBarManager.createBar(paramPlayer, "Command Of Ice", i, ChatColor.YELLOW);
    for (byte b = 0; b < 3; b++) {
      double d = 0.0D;
      Vector vector1 = location.getDirection();
      Vector vector2 = vector1.clone().crossProduct(new Vector(0, 1, 0)).normalize();
      Location location1 = location.clone().add(0.0D, 0.0D, 0.0D).add(vector2.multiply(d));
      ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawnEntity(location1, EntityType.ITEM_DISPLAY);
      itemDisplay.setItemStack(new ItemStack(Material.BLUE_ICE));
      paramPlayer.addPassenger((Entity)itemDisplay);
      itemDisplay.setRotation(0.0F, 0.0F);
      itemDisplay.setViewRange(0.0F);
      Transformation transformation = new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new Quaternionf(), new Vector3f(0.75F, 0.75F, 0.75F), new Quaternionf());
      itemDisplay.setTransformation(transformation);
      arrayList.add(itemDisplay);
    } 
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764de(arrayList, paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 2L, 5L);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_TRIAL_SPAWNER_ABOUT_TO_SPAWN_ITEM, 1.0F, 2.0F);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764df(arrayList, paramPlayer)).runTaskTimer((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(List<ItemDisplay> paramList, Player paramPlayer) {
    int[] arrayOfInt = { 0, 2, 1 };
    for (byte b = 0; b < arrayOfInt.length; b++) {
      int i = arrayOfInt[b];
      int j = b * 3;
      (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dg(paramList, i, paramPlayer)).runTaskLater((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, j);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Player paramPlayer) {
    paramLocation.getWorld().spawnParticle(Particle.SNOWFLAKE, paramLocation, 30, 1.0D, 1.0D, 1.0D, 0.1D);
    paramLocation.getWorld().spawnParticle(Particle.CLOUD, paramLocation, 20, 1.0D, 1.0D, 1.0D, 0.05D);
    paramLocation.getWorld().spawnParticle(Particle.EXPLOSION, paramLocation, 3, 0.5D, 0.5D, 0.5D, 0.0D);
    paramLocation.getWorld().spawnParticle(Particle.ITEM, paramLocation, 200, 0.0D, 0.0D, 0.0D, 0.3D, new ItemStack(Material.BLUE_ICE));
    paramLocation.getWorld().playSound(paramLocation, Sound.BLOCK_GLASS_BREAK, 1.5F, 0.7F);
    paramLocation.getWorld().playSound(paramLocation, Sound.ENTITY_GENERIC_EXPLODE, 0.8F, 1.2F);
    double d1 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getDouble("commandOfIceDamage", 8.0D) * 0.5D;
    double d2 = 3.0D;
    for (Entity entity : paramLocation.getWorld().getNearbyEntities(paramLocation, d2, d2, d2)) {
      {
        if (entity instanceof LivingEntity && entity != paramPlayer) {
          LivingEntity livingEntity = (LivingEntity)entity;
          TrueDamage.apply(livingEntity, d1, paramPlayer);
          livingEntity.setNoDamageTicks(0);
          livingEntity.setFreezeTicks(100);
          Vector vector = livingEntity.getLocation().toVector().subtract(paramLocation.toVector()).normalize().multiply(0.5D);
          livingEntity.setVelocity(vector);
        } 
      }} 
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = "FrostScythe_IceThrow";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = "FrostScythe_ScytheThrow";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = new HashMap<>();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = new HashMap<>();
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */