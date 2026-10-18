package pl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;

public class PaladinEarthAbility implements Listener {
  public Main plugin;
  
  public static int EARTH_SHATTER_COOLDOWN;
  
  public static int STALWART_ABSORPTION_COOLDOWN;
  
  public static int STALWART_ABSORPTION_DURATION;
  
  public static String EARTH_SHATTER_COOLDOWN_KEY;
  
  public static String STALWART_ABSORPTION_COOLDOWN_KEY;
  
  public static HashMap<UUID, Integer> absorptionDamage;
  
  static final boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = !PaladinEarthAbility.class.desiredAssertionStatus();
    EARTH_SHATTER_COOLDOWN = Main.getInstance().getConfig().getInt("paladinEarthShatterCooldown", 45);
    STALWART_ABSORPTION_COOLDOWN = Main.getInstance().getConfig().getInt("paladinStalwartAbsorptionCooldown", 45);
    STALWART_ABSORPTION_DURATION = Main.getInstance().getConfig().getInt("paladinStalwartAbsorptionDuration", 5);
    EARTH_SHATTER_COOLDOWN_KEY = "paladinEarthShatter";
    STALWART_ABSORPTION_COOLDOWN_KEY = "paladinStalwartAbsorption";
    absorptionDamage = new HashMap<>();
  }
  
  
  
  public PaladinEarthAbility(Main paramMain) {
    this.plugin = paramMain;
  }
  
  public static void activateStalwartAbsorption(Player paramPlayer) {
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "StalwartAbsorption", STALWART_ABSORPTION_DURATION);
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, STALWART_ABSORPTION_DURATION * 20, 1));
    TextDisplay textDisplay = (TextDisplay)paramPlayer.getWorld().spawnEntity(paramPlayer.getLocation(), EntityType.TEXT_DISPLAY);
    textDisplay.setText("§60 §c❤");
    textDisplay.setBillboard(Display.Billboard.CENTER);
    Transformation transformation = textDisplay.getTransformation();
    transformation.getScale().set(1.0F, 1.0F, 1.0F);
    transformation.getTranslation().set(0.0D, 0.5D, 0.0D);
    textDisplay.setTransformation(transformation);
    paramPlayer.addPassenger((Entity)textDisplay);
    (new StalwartAbsorptionTask(paramPlayer, textDisplay)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  @EventHandler(ignoreCancelled = true)
  public static void onAbsorptionDamage(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Entity entity = paramEntityDamageByEntityEvent.getEntity();
    if (entity instanceof Player) {
      Player player = (Player)entity;
      if (CooldownManager.isOnCooldown(player.getUniqueId(), "StalwartAbsorption")) {
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_BREEZE_CHARGE, 1.0F, 1.0F);
        player.getWorld().spawnParticle(Particle.DUST, player.getLocation().clone().add(0.0D, 1.0D, 0.0D), 50, 0.3D, 0.5D, 0.3D, new Particle.DustOptions(Color.fromRGB(200, 165, 100), 1.0F));
        int i = Main.getInstance().getConfig().getInt("absorptionDamageLimit");
        int j = Math.min(((Integer) absorptionDamage.getOrDefault(player.getUniqueId(), Integer.valueOf(0))).intValue() + (int)paramEntityDamageByEntityEvent.getDamage(), i);
        absorptionDamage.put(player.getUniqueId(), Integer.valueOf(j));
      } 
    } 
  }
  
  public static ItemStack createEarthShatterItem() {
    ItemStack itemStack = new ItemStack(Material.CLAY_BALL);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(8));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static boolean activateEarthShatter(Player paramPlayer) {
    int i = Main.getInstance().getConfig().getInt("earthShatterRadius", 10);
    double d = Main.getInstance().getConfig().getDouble("earthShatterDamage", 5.0D);
    RayTraceResult rayTraceResult = paramPlayer.getWorld().rayTraceBlocks(paramPlayer.getEyeLocation(), paramPlayer.getEyeLocation().getDirection(), 100.0D);
    {
      if (rayTraceResult == null) {
        paramPlayer.sendMessage("§cNo target found!");
        return false;
      } 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h)
        {
          if (rayTraceResult.getHitBlock() == null)
            throw new AssertionError(); 
        }}Location location = rayTraceResult.getHitBlock().getLocation().add(0.0D, 1.0D, 0.0D);
    int b = 10;
    {
      if (WorldGuardHook.isBlocked(location))
        return false; 
    }paramPlayer.getWorld().playSound(location, Sound.ENTITY_BREEZE_CHARGE, 1.0F, 0.8F);
    ItemDisplay itemDisplay = (ItemDisplay)location.getWorld().spawnEntity(location, EntityType.ITEM_DISPLAY);
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getScale().set(1.0F, 1.0F, 1.0F);
    transformation.getRightRotation().set((Quaternionfc)(new Quaternionf()).rotateX(3.1415927F));
    itemDisplay.setTransformation(transformation);
    itemDisplay.setRotation(180.0F, 0.0F);
    (new EarthShatterRisingAnimationTask(itemDisplay, b, location)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
    (new EarthShatterItemDisplayTask(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 2L);
    (new EarthShatterDisplayExpandTask(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 3L);
    (new EarthShatterTeleportAnimationTask(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 3L);
    (new EarthShatterDisplayRiseTask(itemDisplay, b)).runTaskLater((Plugin)Main.getInstance(), 4L);
    (new EarthShatterDisplayTeleportResetTask(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 5L);
    (new EarthShatterDisplayFinalRiseTask(itemDisplay, b)).runTaskLater((Plugin)Main.getInstance(), 6L);
    (new EarthShatterDisplayTeleportSlowTask(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 18L);
    (new EarthShatterDisplayDescendTask(itemDisplay, b)).runTaskLater((Plugin)Main.getInstance(), 20L);
    (new EarthShatterDetonationTask(itemDisplay, paramPlayer, location, i, b, d)).runTaskLater((Plugin)Main.getInstance(), 27L);
    return true;
  }
  
  public static void createRisingBlocks(Location paramLocation, int paramInt) {
    World world = paramLocation.getWorld();
    Random random = new Random();
    Map<Integer, List<Block>> map = new HashMap<>();
    for (int i = -paramInt; i <= paramInt; i++) {
      for (int j = -paramInt; j <= paramInt; j++) {
        if (i * i + j * j > paramInt * paramInt) {
          continue;
        }
        int k = (int)Math.round(Math.sqrt(i * i + j * j));
        Location location = paramLocation.clone().add(i, -1.0D, j);
        Block block = location.getBlock();
        if (block.getType().isAir()) {
          continue;
        }
        if (!block.getType().isItem()) {
          continue;
        }
        map.computeIfAbsent(k, PaladinEarthAbility::lambda$risingBlocks$0).add(block);
      }
    }
    for (Map.Entry<Integer, List<Block>> entry : map.entrySet()) {
      int k = entry.getKey();
      List<Block> list = entry.getValue();
      Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> lambda$risingBlocks$1(list, world), (long)k * 2L);
    }
  }
  
  private static void lambda$risingBlocks$1(List paramList, World paramWorld) {
    for (Block block : (Iterable<Block>)(Iterable<?>)paramList) {
      Location location = block.getLocation().clone().add(0.5D, 0.5D, 0.5D);
      ItemDisplay itemDisplay = (ItemDisplay)paramWorld.spawnEntity(location, EntityType.ITEM_DISPLAY);
      itemDisplay.setItemStack(new ItemStack(block.getType()));
      itemDisplay.setBrightness(new Display.Brightness(15, 15));
      itemDisplay.setTeleportDuration(5);
      (new EarthShatterRisingBlockAnimationTask(itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 2L);
    } 
  }
  
  private static List lambda$risingBlocks$0(Integer paramInteger) {
    return new ArrayList();
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */