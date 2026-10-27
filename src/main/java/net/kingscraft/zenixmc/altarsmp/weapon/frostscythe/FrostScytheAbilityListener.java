package net.kingscraft.zenixmc.altarsmp.weapon.frostscythe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.kyori.adventure.text.format.NamedTextColor;
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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import java.util.HashMap;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.weapon.crazy.CrazySlotsListener;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public class FrostScytheAbilityListener implements Listener {
  public static AltarSMP plugin;

  public static String ICE_THROW_COOLDOWN_KEY;

  public static String SCYTHE_THROW_COOLDOWN_KEY;

  public static Map<UUID, Integer> throwCounts;

  public static Map<UUID, Long> lastThrowTimestamps;


  public FrostScytheAbilityListener(AltarSMP paramAltarSMP) {
    plugin = paramAltarSMP;
  }

  public static boolean isFrostScythe(ItemStack paramItemStack) {
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
      List<Float> customModelData = itemMeta.getCustomModelDataComponent().getFloats();
      return !customModelData.isEmpty() && customModelData.getFirst() == 4;
    }
  }

  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    {
      if (!(paramEntityDamageByEntityEvent.getDamager() instanceof Player))
        return; 
    }Player player = (Player)paramEntityDamageByEntityEvent.getDamager();
    {
      if (!isFrostScythe(player.getInventory().getItemInMainHand()))
        return; 
    }
    throwScythe(player, paramEntityDamageByEntityEvent.getEntity().getLocation().add(0.0D, 1.0D, 0.0D));
  }

  @EventHandler
  public void onPlayerItemConsume(PlayerItemConsumeEvent paramPlayerItemConsumeEvent) {
    {
      if (isFrostScythe(paramPlayerItemConsumeEvent.getItem())) {
        paramPlayerItemConsumeEvent.setCancelled(true);
        (new FrostScytheInventoryUpdateTask(paramPlayerItemConsumeEvent)).runTaskLater(AltarSMP.getInstance(), 1L);
        if (!CooldownManager.isOnCooldown(paramPlayerItemConsumeEvent.getPlayer().getUniqueId(), SCYTHE_THROW_COOLDOWN_KEY)) {
          int i = AltarSMP.getInstance().getConfig().getInt("scytheThrowCooldown", 30);
          launchScythe(paramPlayerItemConsumeEvent.getPlayer());
          BossBarManager.createBar(paramPlayerItemConsumeEvent.getPlayer(), "Scythe Throw", i, NamedTextColor.YELLOW);
          CooldownManager.setCooldown(paramPlayerItemConsumeEvent.getPlayer().getUniqueId(), SCYTHE_THROW_COOLDOWN_KEY, i);
        } 
      } 
    }}

  public static void spawnIceSpiralParticles(Location paramLocation, double paramDouble, boolean paramBoolean1, boolean paramBoolean2) {
    int b1 = 35;
    double d = 2.2D;
    for (int b2 = 0; b2 < b1; b2++) {
      double d2;
      double d3;
      double d4;
      double d1 = (double) b2 / b1;
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

  public static void throwScythe(Player paramPlayer, Location paramLocation) {
    int i = getThrowCount(paramPlayer);
    double d = Math.toRadians(paramPlayer.getLocation().getYaw());
    {
      switch (i % 4) {
        case 0:
          spawnIceSpiralParticles(paramLocation, d, true, false);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ITEM_TRIDENT_THROW, 1.0F, 1.0F);
          break;
        case 1:
          spawnIceSpiralParticles(paramLocation, d, false, false);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ITEM_TRIDENT_THROW, 1.0F, 1.0F);
          break;
        case 2:
          spawnIceSpiralParticles(paramLocation, d, true, true);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ITEM_TRIDENT_THROW, 1.0F, 1.0F);
          break;
        case 3:
          spawnIceSpiralParticles(paramLocation, d, false, true);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ITEM_TRIDENT_THROW, 1.0F, 1.0F);
          break;
      } 
    }
    getThrowCount(paramPlayer);
  }

  public static int getThrowCount(Player paramPlayer) {
    long l = System.currentTimeMillis();
    {
      if (lastThrowTimestamps.containsKey(paramPlayer.getUniqueId()))
        {
          if (l - lastThrowTimestamps.get(paramPlayer.getUniqueId()) > 2500L)
            throwCounts.put(paramPlayer.getUniqueId(), 0);
        }}return throwCounts.getOrDefault(paramPlayer.getUniqueId(), 0);
  }

  public static void incrementThrowCount(Player paramPlayer) {
    int i = getThrowCount(paramPlayer);
    throwCounts.put(paramPlayer.getUniqueId(), i + 1);
    lastThrowTimestamps.put(paramPlayer.getUniqueId(), System.currentTimeMillis());
  }

  public static void launchScythe(Player paramPlayer) {
    {
      if (!AltarSMP.getInstance().getConfig().getBoolean("holdForThrowFrostScythe", true)) {
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BREEZE_INHALE, 1.0F, 1.0F);
        paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 20, 4));
      } 
    }double d = AltarSMP.getInstance().getConfig().getInt("scytheThrowPower", 2);
    int i = AltarSMP.getInstance().getConfig().getInt("scytheThrowMaxThrow", 100);
    int j = AltarSMP.getInstance().getConfig().getInt("scytheThrowDamage", 8);
    boolean bool = AltarSMP.getInstance().getConfig().getBoolean("scytheThrowReturnScythe", true);
    (new FrostScytheLaunchTask(paramPlayer, bool, d, i, j)).runTaskLater(AltarSMP.getInstance(), 20L);
  }

  public static void animateScythe(Player paramPlayer, ItemDisplay paramItemDisplay, double paramDouble) {
    (new FrostScytheReturnTask(paramPlayer, paramItemDisplay, paramDouble)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  public static Boolean hasEmptyInventorySlot(Player paramPlayer) {
    PlayerInventory playerInventory = paramPlayer.getInventory();
    int b = 0;
    while (true) {
      {
        if (b < 36) {
          {
            if (playerInventory.getItem(b) == null)
              return true;
          }b++;
          continue;
        } 
      }return false;
    } 
  }

  public static void handleScytheReturn(Player paramPlayer, ItemDisplay paramItemDisplay) {
    {
      if (!paramPlayer.getWorld().equals(paramItemDisplay.getWorld()))
        return; 
    }{
      if (paramPlayer.getInventory().contains(CustomItemRegistry.getCrazySlots())) {
        {
          if (CrazySlotsListener.isCrazySlotsItem(paramItemDisplay.getItemStack())) {
            paramItemDisplay.remove();
          } else {
            returnScytheToPlayer(paramPlayer, paramItemDisplay);
          } 
        }} else {
        returnScytheToPlayer(paramPlayer, paramItemDisplay);
      } 
    }}

  public static void returnScytheToPlayer(Player paramPlayer, ItemDisplay paramItemDisplay) {
    {
      if (hasEmptyInventorySlot(paramPlayer)) {
        paramItemDisplay.remove();
        paramPlayer.getInventory().addItem(paramItemDisplay.getItemStack());
      } else {
        {
          if (CrazySlotsListener.isCrazySlotsItem(paramItemDisplay.getItemStack())) {
            paramItemDisplay.remove();
            return;
          } 
        }
        (new FrostScytheReturnAnimationTask(paramPlayer, paramItemDisplay)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
      } 
    }}

  public static void activateCommandOfIce(Player paramPlayer) {
    ArrayList<ItemDisplay> arrayList = new ArrayList<>();
    Location location = paramPlayer.getLocation();
    int i = plugin.getConfig().getInt("commandOfIceCooldown", 45);
    BossBarManager.createBar(paramPlayer, "Command Of Ice", i, NamedTextColor.YELLOW);
    for (int b = 0; b < 3; b++) {
      double d = 0.0D;
      Vector vector1 = location.getDirection();
      Vector vector2 = vector1.clone().crossProduct(new Vector(0, 1, 0)).normalize();
      Location location1 = location.clone().add(0.0D, 0.0D, 0.0D).add(vector2.multiply(d));
      ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawnEntity(location1, EntityType.ITEM_DISPLAY);
      itemDisplay.setItemStack(new ItemStack(Material.BLUE_ICE));
      paramPlayer.addPassenger(itemDisplay);
      itemDisplay.setRotation(0.0F, 0.0F);
      itemDisplay.setViewRange(0.0F);
      Transformation transformation = new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new Quaternionf(), new Vector3f(0.75F, 0.75F, 0.75F), new Quaternionf());
      itemDisplay.setTransformation(transformation);
      arrayList.add(itemDisplay);
    } 
    (new FrostScytheBladeFormationTask(arrayList, paramPlayer)).runTaskTimer(AltarSMP.getInstance(), 2L, 5L);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_TRIAL_SPAWNER_ABOUT_TO_SPAWN_ITEM, 1.0F, 2.0F);
    (new FrostScytheBladeChargingTask(arrayList, paramPlayer)).runTaskTimer(plugin, 0L, 1L);
  }

  public static void scheduleIceBladeLaunches(List<ItemDisplay> paramList, Player paramPlayer) {
    int[] arrayOfInt = { 0, 2, 1 };
    for (int b = 0; b < arrayOfInt.length; b++) {
      int i = arrayOfInt[b];
      int j = b * 3;
      (new FrostScytheBladeLaunchTask(paramList, i, paramPlayer)).runTaskLater(plugin, j);
    } 
  }

  public static void createIceExplosion(Location paramLocation, Player paramPlayer) {
    paramLocation.getWorld().spawnParticle(Particle.SNOWFLAKE, paramLocation, 30, 1.0D, 1.0D, 1.0D, 0.1D);
    paramLocation.getWorld().spawnParticle(Particle.CLOUD, paramLocation, 20, 1.0D, 1.0D, 1.0D, 0.05D);
    paramLocation.getWorld().spawnParticle(Particle.EXPLOSION, paramLocation, 3, 0.5D, 0.5D, 0.5D, 0.0D);
    paramLocation.getWorld().spawnParticle(Particle.ITEM, paramLocation, 200, 0.0D, 0.0D, 0.0D, 0.3D, new ItemStack(Material.BLUE_ICE));
    paramLocation.getWorld().playSound(paramLocation, Sound.BLOCK_GLASS_BREAK, 1.5F, 0.7F);
    paramLocation.getWorld().playSound(paramLocation, Sound.ENTITY_GENERIC_EXPLODE, 0.8F, 1.2F);
    double d1 = plugin.getConfig().getDouble("commandOfIceDamage", 8.0D) * 0.5D;
    double d2 = 3.0D;
    for (Entity entity : paramLocation.getWorld().getNearbyEntities(paramLocation, d2, d2, d2)) {
      {
        if (entity instanceof LivingEntity livingEntity && entity != paramPlayer) {
          TrueDamage.apply(livingEntity, d1, paramPlayer);
          livingEntity.setNoDamageTicks(0);
          livingEntity.setFreezeTicks(100);
          Vector vector = livingEntity.getLocation().toVector().subtract(paramLocation.toVector()).normalize().multiply(0.5D);
          livingEntity.setVelocity(vector);
        } 
      }} 
  }

  static {
    ICE_THROW_COOLDOWN_KEY = "FrostScythe_IceThrow";
    SCYTHE_THROW_COOLDOWN_KEY = "FrostScythe_ScytheThrow";
    throwCounts = new HashMap<>();
    lastThrowTimestamps = new HashMap<>();
  }

}
