package pl;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class WindweaverAbility implements Listener {
  public static Main plugin;
  
  public static HashMap<UUID, Integer> gustChargeLevels;
  
  public static HashMap<UUID, Long> gustChargeStartTimes;
  
  public static HashMap<UUID, BukkitRunnable> chargeTasks;
  
  public static HashMap<UUID, Boolean> isCharging;
  
  static int DASH_COOLDOWN;
  
  static int SPEED_BOOST_DURATION;
  
  static int GUST_COOLDOWN;
  
  static int GUST_STRENGTH;
  
  
  
  public WindweaverAbility(Main paramMain) {
    plugin = paramMain;
  }
  
  public static boolean isWindweaverSwordInMainHand(Player paramPlayer) {
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
    
    }return (itemMeta.getCustomModelData() == 12);
  }
  
  public static boolean isWindweaverSwordInOffHand(Player paramPlayer) {
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
    
    }return (itemMeta.getCustomModelData() == 12);
  }
  
  @EventHandler
  public void onPlayerToggleSneak(PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
    Player player = paramPlayerToggleSneakEvent.getPlayer();
    {
      if (!isWindweaverSwordInMainHand(player))
        {
          if (!isWindweaverSwordInOffHand(player))
            return; 
        }}{
      if (!paramPlayerToggleSneakEvent.isSneaking())
        {
          if (((Boolean) isCharging.getOrDefault(player.getUniqueId(), Boolean.valueOf(false))).booleanValue()) {
            cancelWindGustCharge(player);
            BossBarManager.removeBar(player, "Charging");
          } 
        }}}
  
  public static void activateWindLeap(Player paramPlayer) {
    {
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "windleap"))
        return; 
    }
      CooldownManager.setCooldown(paramPlayer.getUniqueId(), "windleap", DASH_COOLDOWN);
    BossBarManager.createBar(paramPlayer, "Wind Leap", DASH_COOLDOWN, ChatColor.YELLOW);
    Location location = paramPlayer.getLocation();
    Vector vector1 = paramPlayer.getLocation().getDirection().normalize();
    double d = Main.getInstance().getConfig().getDouble("windweaver.dashStrength", 2.0D);
    Vector vector2 = vector1.clone().multiply(d);
    paramPlayer.setVelocity(vector2);
    paramPlayer.getWorld().spawnParticle(Particle.GUST, location, 20, 0.3D, 0.1D, 0.3D, 0.05D);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_WIND_CHARGE_WIND_BURST, 1.0F, 1.2F);
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, SPEED_BOOST_DURATION * 20, 3, true, true, true));
    (new WindLeapParticleTask(paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 2L);
  }
  
  public static void spawnWindParticles(Location paramLocation, int paramInt1, Particle paramParticle, Player paramPlayer, int paramInt2) {
    (new WindGustExpansionTask(paramInt1, paramLocation, paramParticle, paramPlayer, paramInt2)).runTaskTimer((Plugin) plugin, 0L, 1L);
  }
  
  public static void activateWindGust(Player paramPlayer) {
    {
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "windgust"))
        return; 
    }UUID uUID = paramPlayer.getUniqueId();
    int i = ((Integer) gustChargeLevels.getOrDefault(uUID, Integer.valueOf(0))).intValue();
    spawnWindParticles(paramPlayer.getLocation(), 3 + i, Particle.CLOUD, paramPlayer, i + GUST_STRENGTH);
    BossBarManager.removeBar(paramPlayer, "Charging");
    CooldownManager.setCooldown(uUID, "windgust", GUST_COOLDOWN);
    BossBarManager.createBar(paramPlayer, "Windweaver Gust", GUST_COOLDOWN, ChatColor.YELLOW);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_WIND_CHARGE_WIND_BURST, 2.0F, 0.8F);
    cancelWindGustCharge(paramPlayer);
  }
  
  public static void startWindGustCharge(Player paramPlayer) {
    UUID uUID = paramPlayer.getUniqueId();
    {
      if (CooldownManager.isOnCooldown(uUID, "windgust"))
        return; 
    }{
      if (((Boolean) isCharging.getOrDefault(uUID, Boolean.valueOf(false))).booleanValue())
        return; 
    }
    isCharging.put(uUID, Boolean.valueOf(true));
    gustChargeLevels.put(uUID, Integer.valueOf(0));
    WindGustChargeTask windGustChargeTask = new WindGustChargeTask(uUID, paramPlayer);
    windGustChargeTask.runTaskTimer((Plugin) plugin, 0L, 1L);
    chargeTasks.put(uUID, windGustChargeTask);
  }
  
  public static void cancelWindGustCharge(Player paramPlayer) {
    UUID uUID = paramPlayer.getUniqueId();
    {
      isCharging.put(uUID, Boolean.valueOf(false));
      gustChargeStartTimes.remove(uUID);
      if (chargeTasks.containsKey(uUID)) {
        ((BukkitRunnable) chargeTasks.get(uUID)).cancel();
        chargeTasks.remove(uUID);
      } 
    }}

  static {
    gustChargeLevels = new HashMap<>();
    gustChargeStartTimes = new HashMap<>();
    chargeTasks = new HashMap<>();
    isCharging = new HashMap<>();
    DASH_COOLDOWN = Main.getInstance().getConfig().getInt("windweaver.dashCooldown", 15);
    SPEED_BOOST_DURATION = Main.getInstance().getConfig().getInt("windweaver.speedAfterDashDuration", 4);
    GUST_COOLDOWN = Main.getInstance().getConfig().getInt("windweaver.gustCooldown", 30);
    GUST_STRENGTH = Main.getInstance().getConfig().getInt("windweaver.gustStrength", 1);
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ao.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */