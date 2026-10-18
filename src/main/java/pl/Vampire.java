package pl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

  public class Vampire implements Listener {
  public static Main plugin;
  
  public static FileConfiguration config;
  
  public static final Map<UUID, Double> healthStealMap;
  
  public static final Map<UUID, Boolean> transformedPlayers;
  
  public static int unusedInt1;
  
  public static int unusedInt2;
  
  public static double unusedDouble;

  public Vampire() {
    config = plugin.getConfig();
  }
  
  public static void startPassiveTask() {
    (new NightPiercerPassiveTask()).runTaskTimer((Plugin)Main.getInstance(), 0L, 40L);
  }
  
  public static void crimsonBite(Player paramPlayer) {
    {
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "crimsonBite"))
        return; 
    }int i = config.getInt("crimsonBiteCooldown", 60);
    double d = config.getDouble("crimsonBiteHealthSteal", 4.0D);
    int j = config.getInt("crimsonBiteDuration", 10);
    LivingEntity livingEntity1 = null;
    Location location = paramPlayer.getLocation().clone().add(0.0D, 1.5D, 0.0D).add(paramPlayer.getLocation().getDirection().clone().normalize().multiply(1.5D));
    for (Entity entity : location.getNearbyEntities(3.0D, 3.0D, 3.0D)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity)entity;
        {
          if (Main.isTrusted(paramPlayer, (Entity)livingEntity))
            continue; 
        }{
          if (paramPlayer == livingEntity)
            continue; 
        }livingEntity1 = livingEntity;
        break;
      } 
    } 
    {
      if (livingEntity1 == null) {
        paramPlayer.sendMessage("§cNo nearby enemies");
        return;
      } 
    }LivingEntity livingEntity2 = livingEntity1;
    spawnBiteParticles((LivingEntity)paramPlayer);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_PHANTOM_BITE, 1.0F, 1.0F);
    (new CrimsonBiteTask(livingEntity2, d, paramPlayer, j, i)).runTaskLater((Plugin) plugin, 1L);
  }
  
  public static void transformIntoBat(Player paramPlayer) {
    for (Player player : Bukkit.getOnlinePlayers())
      player.hidePlayer((Plugin)Main.getInstance(), paramPlayer); 
    int i = config.getInt("transformationDuration", 2);
    double d = config.getDouble("transformationSpeed", 1.0D);
    int j = config.getInt("transformationDamage", 6);
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, i * 20, 0));
    ArrayList<Bat> arrayList = new ArrayList();
    HashMap<Object, Object> hashMap = new HashMap<>();
    for (int b = 0; b < 7; b++) {
      double d1 = (Math.random() - 0.5D) * 2.0D;
      double d2 = Math.random();
      double d3 = (Math.random() - 0.5D) * 2.0D;
      Vector vector = new Vector(d1, d2, d3);
      Bat bat = (Bat)paramPlayer.getWorld().spawn(paramPlayer.getLocation().clone().add(vector), Bat.class);
      bat.setAI(false);
      bat.setInvulnerable(true);
      bat.setSilent(true);
      bat.setAwake(true);
      arrayList.add(bat);
      hashMap.put(bat, vector);
    } 
    transformedPlayers.put(paramPlayer.getUniqueId(), Boolean.valueOf(true));
    (new BatTransformationTask(i, paramPlayer, arrayList, hashMap, d, j)).runTaskTimer((Plugin) plugin, 0L, 1L);
  }
  
  public static void spawnBiteParticles(LivingEntity paramLivingEntity) {
    int b1 = 0;
    double d = 1.0D;
    Location location = paramLivingEntity.getLocation().clone().add(0.0D, 1.5D, 0.0D);
    World world = paramLivingEntity.getWorld();
    Vector vector1 = paramLivingEntity.getLocation().getDirection().normalize();
    Vector vector2 = new Vector(0, 1, 0);
    Vector vector3 = vector1.getCrossProduct(vector2).normalize();
    for (int b2 = 0; b2 < 2; b2++) {
      for (int b = -60; b < 60; b += 4) {
        Vector vector;
        double d1 = Math.toRadians(b);
        double d2 = Math.cos(d1);
        double d3 = Math.sin(d1);
        if (b1 == 1) {
          vector = vector1.clone().multiply(d2).add(vector3.clone().multiply(d3)).subtract(vector2.clone().multiply(d3));
        } else {
          vector = vector1.clone().multiply(d2).add(vector3.clone().multiply(d3)).add(vector2.clone().multiply(d3));
        } 
        Location location1 = location.clone().add(vector.multiply(d));
        world.spawnParticle(Particle.DUST, location1, 0, 0.0D, 0.0D, 0.0D, 0.0D, new Particle.DustOptions(Color.RED, 1.0F));
        world.spawnParticle(Particle.ITEM, location1, 0, 0.0D, 0.0D, 0.0D, 0.0D, new ItemStack(Material.RED_TERRACOTTA));
      } 
      b1++;
    } 
  }
  
  public static boolean isHoldingNightPiercer(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    return Main.areSimilar(itemStack, CustomItemRegistry.getNightpiercer());
  }

  static {
    plugin = Main.getInstance();
    healthStealMap = new HashMap<>();
    transformedPlayers = new HashMap<>();
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ah.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */