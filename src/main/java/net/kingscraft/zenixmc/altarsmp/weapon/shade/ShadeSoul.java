package net.kingscraft.zenixmc.altarsmp.weapon.shade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Transformation;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.weapon.holylance.HolyLanceTask;
import net.kingscraft.zenixmc.altarsmp.weapon.precision.SlashDespawnTask;
import net.kingscraft.zenixmc.altarsmp.weapon.precision.SlashHideTask;
import net.kingscraft.zenixmc.altarsmp.weapon.precision.SlashStreakTask;
import net.kingscraft.zenixmc.altarsmp.weapon.precision.SlashSwingTask;
import net.kingscraft.zenixmc.altarsmp.weapon.wind.CycloneBlockClearTask;
import net.kingscraft.zenixmc.altarsmp.weapon.wind.CycloneSlashSpinTask;

  public class ShadeSoul implements Listener {
  public AltarSMP plugin;
  
  public final Map<UUID, Integer> comboCounters = new HashMap<>();
  
  public final Map<UUID, Long> lastActionTimes = new HashMap<>();
  
  public static int shadeSoulCooldown;
  
  public static int cycloneSlashCooldown;
  
  public static String shadePart;
  
  public static String slashPart;
  
  public ShadeSoul(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
  }
  
  public static boolean isHoldingShadeBlade(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    if (itemStack.getType() != Material.NETHERITE_SWORD)
      return false;
    if (!itemStack.hasItemMeta())
        return false; 
    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta == null)
      return false;

    if (!itemMeta.hasCustomModelData())
        return false; 

    return (itemMeta.getCustomModelData() == 7);
  }
  
  @EventHandler
  public void onEntityDamage(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    if (!isHoldingShadeBlade(player))
        return;
    spawnComboSlash(player, paramEntityDamageByEntityEvent.getEntity().getLocation().add(0.0D, 1.0D, 0.0D));
  }
  
  public static ItemStack createShadeOrbItem() {
    ItemStack itemStack = new ItemStack(Material.CLAY_BALL);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(6));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static ItemStack createSlashItem() {
    ItemStack itemStack = new ItemStack(Material.CLAY_BALL);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(7));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static void castShadeSoul(Player paramPlayer) {
    ArrayList arrayList = new ArrayList();
    paramPlayer.getWorld().playSound((Entity)paramPlayer, Sound.ENTITY_WARDEN_SONIC_CHARGE, 1.0F, 1.5F);
    spawnShadeOrbs(paramPlayer);
    (new ShadeOrbRayTask(paramPlayer, arrayList)).runTaskLater((Plugin)AltarSMP.getInstance(), 22L);
    (new ShadeOrbTeleportTask(arrayList, paramPlayer)).runTaskLater((Plugin)AltarSMP.getInstance(), 22L);
    (new ShadeOrbInterpolateTask(arrayList)).runTaskLater((Plugin)AltarSMP.getInstance(), 38L);
  }
  
  public static void spawnShadeOrbs(Player paramPlayer) {
    (new SlashSwingTask(paramPlayer)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }
  
  public static void spawnSlashDisplay(Location paramLocation) {
    paramLocation.add(0.0D, 0.0D, 0.0D);
    World world = paramLocation.getWorld();
    ItemStack itemStack = createShadeOrbItem();
    ItemDisplay itemDisplay = (ItemDisplay)world.spawnEntity(paramLocation, EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(itemStack);
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getScale().set(0.35D, 0.35D, 0.35D);
    itemDisplay.setTransformation(transformation);
    itemDisplay.setInterpolationDelay(0);
    itemDisplay.setInterpolationDuration(22);
    itemDisplay.setTeleportDuration(22);
    (new SlashStreakTask(paramLocation, itemDisplay)).runTaskLater((Plugin)AltarSMP.getInstance(), 2L);
    (new SlashHideTask(itemDisplay)).runTaskLater((Plugin)AltarSMP.getInstance(), 2L);
    (new SlashDespawnTask(itemDisplay)).runTaskLater((Plugin)AltarSMP.getInstance(), 22L);
  }
  
  public static void castHolyLance(Player paramPlayer) {
    float f = 7.5F;
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 9, false, false, true));
    paramPlayer.getWorld().playSound((Entity)paramPlayer, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.5F);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BREEZE_WHIRL, 1.0F, 1.0F);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BREEZE_WHIRL, 1.0F, 1.0F);
    paramPlayer.setVelocity(paramPlayer.getLocation().getDirection().multiply(0.5D).setY(0.2D));
    ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawnEntity(paramPlayer.getLocation().add(0.0D, 1.0D, 0.0D), EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(createSlashItem());
    itemDisplay.setInterpolationDelay(0);
    itemDisplay.setInterpolationDuration(5);
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getScale().set(7.5F, 1.0F, 7.5F);
    transformation.getTranslation().set(0.0F, 0.0F, 0.0F);
    itemDisplay.setTransformation(transformation);
    paramPlayer.addPassenger((Entity)itemDisplay);
    itemDisplay.setRotation(0.0F, 0.0F);
    (new HolyLanceTask(itemDisplay, paramPlayer)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 5L);
    (new CycloneSlashSpinTask(itemDisplay)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }
  
  public static void castCycloneSlash(Player paramPlayer) {
    (new CycloneBlockClearTask(paramPlayer)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }
  
  public static List<Block> getBlocksInArea(Player paramPlayer, int paramInt1, int paramInt2) {
    int i = paramInt1 / 2;
    int j = paramInt2 / 2;
    ArrayList<Block> arrayList = new ArrayList();
    Location location = paramPlayer.getLocation().getBlock().getLocation();
    for (int k = -i; k <= i; k++) {
      for (int m = -i; m <= i; m++) {
        int n = -j;
        while (n <= j) {
          arrayList.add(location.clone().add(k, n, m).getBlock());
          n++;
        }
      } 
    } 
    return arrayList;
  }
  
  public void spawnSlashParticles(Location paramLocation, double paramDouble, boolean paramBoolean1, boolean paramBoolean2) {
    int b1 = 35;
    double d = 2.2D;
    for (int b2 = 0; b2 < b1; b2++) {
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
        d3 = paramBoolean1 ? ((1.0D - d1) * d * 0.8D) : ((d1 - 1.0D) * d * 0.8D);
        d4 = Math.sin(paramDouble) * d5;
      } 
      Location location = paramLocation.clone().add(d2, d3, d4);
      paramLocation.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, location, 2, 0.0D, 0.0D, 0.0D, 0.0D);
      paramLocation.getWorld().spawnParticle(Particle.DUST, location, 2, 0.0D, 0.0D, 0.0D, 0.0D, new Particle.DustOptions(Color.WHITE, 1.0F));
    } 
  }
  
  public void spawnComboSlash(Player paramPlayer, Location paramLocation) {
    int i = getComboCount(paramPlayer);
    double d = Math.toRadians(paramPlayer.getLocation().getYaw());
    switch (i % 4) {
      case 0:
        spawnSlashParticles(paramLocation, d, true, false);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
        break;
      case 1:
        spawnSlashParticles(paramLocation, d, false, false);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
        break;
      case 2:
        spawnSlashParticles(paramLocation, d, true, true);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
        break;
      case 3:
        spawnSlashParticles(paramLocation, d, false, true);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
        break;
    }
    incrementCombo(paramPlayer);
  }
  
  public int getComboCount(Player paramPlayer) {
    long l = System.currentTimeMillis();
    
      if (this.lastActionTimes.containsKey(paramPlayer.getUniqueId()))
        if (l - ((Long)this.lastActionTimes.get(paramPlayer.getUniqueId())).longValue() > 2500L)
          this.comboCounters.put(paramPlayer.getUniqueId(), Integer.valueOf(0));

    return ((Integer)this.comboCounters.getOrDefault(paramPlayer.getUniqueId(), Integer.valueOf(0))).intValue();
  }
  
  public void incrementCombo(Player paramPlayer) {
    int i = getComboCount(paramPlayer);
    this.comboCounters.put(paramPlayer.getUniqueId(), Integer.valueOf(i + 1));
    this.lastActionTimes.put(paramPlayer.getUniqueId(), Long.valueOf(System.currentTimeMillis()));
  }
  
  static {
    shadeSoulCooldown = AltarSMP.getInstance().getConfig().getInt("shadeSoulCooldown", 30);
    cycloneSlashCooldown = AltarSMP.getInstance().getConfig().getInt("cycloneSlashCooldown", 60);
    shadePart = "shade";
    slashPart = "slash";
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764am.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */