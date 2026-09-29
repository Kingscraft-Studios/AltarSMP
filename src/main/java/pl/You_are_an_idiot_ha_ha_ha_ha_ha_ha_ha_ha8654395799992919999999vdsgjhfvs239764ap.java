package pl;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ap implements Listener {
  public static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  public static final HashMap<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  public static final int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = 3;
  
  public static HashMap<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  
  
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fg()).runTaskTimer((Plugin)Main.getInstance(), 0L, 5L);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    return Main.areSimilar(itemStack, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.WITHERED_BONE_BLADE.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0());
  }
  
  @EventHandler(ignoreCancelled = true)
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player))
        return; 
    }int i = ((Integer)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.getOrDefault(player.getUniqueId(), Integer.valueOf(0))).intValue();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.put(player.getUniqueId(), Integer.valueOf(i + You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h));
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    UUID uUID = paramPlayer.getUniqueId();
    int i = ((Integer)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.getOrDefault(uUID, Integer.valueOf(3))).intValue();
    {
      if (i <= 0)
        return; 
    }Vector vector = paramPlayer.getLocation().getDirection();
    {
      vector.multiply(Main.getInstance().getConfig().getDouble("WitherBoneLeapHorizontalStrength", 1.5D)).setY(Main.getInstance().getConfig().getDouble("WitherBoneLeapVerticalStrength", 0.6D));
      paramPlayer.setVelocity(vector);
      paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 2));
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.put(uUID, Integer.valueOf(--i));
      paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_SKELETON_DEATH, 1.0F, 1.0F);
      paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_WITHER_BREAK_BLOCK, 1.5F, 1.5F);
      if (i <= 0) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(uUID);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "Wither Leap", You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, ChatColor.YELLOW);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a);
      } 
    }}
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fh(paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation) {
    Location location = paramLocation.clone();
    ItemDisplay itemDisplay = (ItemDisplay)paramLocation.getWorld().spawn(location, ItemDisplay.class);
    itemDisplay.setItemStack(new ItemStack(Material.BONE));
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getScale().set(0.2F, 0.2F, 0.2F);
    itemDisplay.setTransformation(transformation);
    itemDisplay.setBrightness(new Display.Brightness(15, 15));
    double d1 = Math.random() * Math.PI * 2.0D;
    double d2 = 0.15D;
    Vector vector = new Vector(Math.cos(d1) * d2, 0.0D, Math.sin(d1) * d2);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fi(vector, itemDisplay)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    {
      if (((Integer)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.getOrDefault(paramPlayer.getUniqueId(), Integer.valueOf(0))).intValue() < You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g) {
        paramPlayer.sendMessage("§7Not enough bars");
        return;
      } 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.put(paramPlayer.getUniqueId(), Integer.valueOf(0));
    paramPlayer.swingMainHand();
    paramPlayer.updateInventory();
    Location location = paramPlayer.getLocation();
    World world = paramPlayer.getWorld();
    int i = Main.getInstance().getConfig().getInt("WitherBoneCleansingDuration", 5);
    for (byte b = 0; b < 48; b++) {
      Location location1 = location.clone().add(0.0D, 1.0D, 0.0D);
      ItemDisplay itemDisplay1 = (ItemDisplay)world.spawnEntity(location1, EntityType.ITEM_DISPLAY);
      itemDisplay1.setItemStack(new ItemStack(Material.BLACK_CONCRETE));
      ItemDisplay itemDisplay2 = (ItemDisplay)world.spawnEntity(location1, EntityType.ITEM_DISPLAY);
      itemDisplay2.setItemStack(new ItemStack(Material.BLACK_STAINED_GLASS));
      double d1 = Math.random() * Math.PI * 2.0D;
      double d2 = Math.random() * 1.2D + 0.5D;
      Vector vector = new Vector(Math.cos(d1) * d2, 0.1D, Math.sin(d1) * d2);
      float f1 = (float)(Math.random() * 0.6D + 0.4D);
      float f2 = f1 + 0.1F;
      Transformation transformation1 = itemDisplay1.getTransformation();
      transformation1.getScale().set(f1, 1.0F, f1);
      itemDisplay1.setTransformation(transformation1);
      Transformation transformation2 = itemDisplay2.getTransformation();
      transformation2.getScale().set(f2, 1.0F, f2);
      itemDisplay2.setTransformation(transformation2);
      Location location2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location1.clone(), vector.clone(), world);
      {
        if (location1.getWorld() == location2.getWorld()) {
          double d = location1.distance(location2);
          int j = (int)Math.min(d / 1.2D, 40.0D);
          (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fj(itemDisplay1, itemDisplay2, j, location2, world, location1, f1, f2)).runTaskLater((Plugin)Main.getInstance(), 2L);
          (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fm(itemDisplay1, itemDisplay2, i, j, world, paramPlayer, vector)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
        } 
      }} 
    world.playSound(location, Sound.ENTITY_PLAYER_SPLASH, 1.0F, 0.8F);
  }
  
  public static Location You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Vector paramVector, World paramWorld) {
    Location location1 = paramLocation.clone();
    Vector vector = paramVector.clone();
    char c = 'È';
    for (byte b = 0; b < c; b++) {
      vector.setY(vector.getY() - 0.08D);
      vector.multiply(0.98D);
      Location location = location1.clone().add(vector);
      double d = Math.max(1.0D, vector.length() * 5.0D);
      Vector vector1 = vector.clone().multiply(1.0D / d);
      for (byte b1 = 0; b1 < d; b1++) {
        Location location3 = location1.clone().add(vector1.clone().multiply(b1));
        Location location4 = location3.clone().subtract(0.0D, 0.1D, 0.0D);
        if (location4.getBlock().getType().isSolid())
          return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location3, paramWorld); 
      } 
      location1 = location;
      {
        if (vector.length() < 0.01D)
          break; 
      }} 
    Location location2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location1, paramWorld, 30);
    {
    
    }return (location2 != null) ? location2 : location1;
  }
  
  public static Location You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, World paramWorld) {
    for (int i = (int)paramLocation.getY(); i > paramLocation.getY() - 5.0D; i--) {
      Location location1 = new Location(paramWorld, paramLocation.getX(), i, paramLocation.getZ());
      Location location2 = location1.clone().add(0.0D, 1.0D, 0.0D);
      {
        if (location1.getBlock().getType().isSolid())
          {
            if (location2.getBlock().getType().isAir())
              return location2; 
          }}} 
    return new Location(paramWorld, paramLocation.getX(), (paramLocation.getBlockY() + 1), paramLocation.getZ());
  }
  
  public static Location You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, World paramWorld, int paramInt) {
    for (int i = (int)paramLocation.getY(); i > paramLocation.getY() - paramInt; i--) {
      Location location = new Location(paramWorld, paramLocation.getX(), i, paramLocation.getZ());
      {
        if (location.getBlock().getType().isSolid())
          return location.clone().add(0.0D, 1.0D, 0.0D); 
      }} 
    return null;
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = Main.getInstance().getConfig().getInt("WitherBoneleapCooldown", 10);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = "leap";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = "cleansing";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = new HashMap<>();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = new HashMap<>();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = 48;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = 2;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ap.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */