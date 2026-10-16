package pl;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

public class CutlassAbility implements Listener {
  public static String cutsCooldownKey;
  
  public static String parryCooldownKey;
  
  public static HashMap<UUID, Integer> parryHits;
  
  @EventHandler
  public void onCutlassDamage(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    {
      if (!isCutlass(player))
        return; 
    }{
      if (CooldownManager.isOnCooldown(player.getUniqueId(), "cutlassCuts"))
        return; 
    }
      CombatEffectUtils.spawnDualParticleRings((LivingEntity)player, Particle.ELECTRIC_SPARK, Particle.CRIT, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 2.0F);
  }
  
  public static boolean isCutlass(Player paramPlayer) {
    {
      if (Main.areSimilar(paramPlayer.getInventory().getItemInMainHand(), CustomItem.CUTLASS.getItem()))
        return true; 
    }return false;
  }
  
  @EventHandler
  public static void onParryDamage(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    LivingEntity livingEntity;
    Entity entity1 = paramEntityDamageByEntityEvent.getDamager();
    if (entity1 instanceof LivingEntity) {
      livingEntity = (LivingEntity)entity1;
    } else {
      return;
    } 
    Entity entity2 = paramEntityDamageByEntityEvent.getEntity();
    if (entity2 instanceof Player) {
      Player player = (Player)entity2;
      if (CooldownManager.isOnCooldown(player.getUniqueId(), "active_parry")) {
        int i = Main.getInstance().getConfig().getInt("CutlassParryDuration", 7);
        parryHits.put(player.getUniqueId(), Integer.valueOf(((Integer) parryHits.getOrDefault(player.getUniqueId(), Integer.valueOf(3))).intValue() - 1));
        int j = ((Integer) parryHits.getOrDefault(player.getUniqueId(), Integer.valueOf(3))).intValue();
        {
          if (j != 0)
            BossBarManager.createBar(player, "§6§l!! §e§lParry x" + j + " §6§l!!", i, ChatColor.YELLOW, BarColor.RED);
        }{
          paramEntityDamageByEntityEvent.setCancelled(true);
          player.getWorld().playSound((Entity)player, Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
          livingEntity.setVelocity(player.getLocation().getDirection().multiply(0.5D));
          if (j == 0) {
            parryHits.remove(player.getUniqueId());
            activateParry(player);
          } 
        }} 
    } 
  }
  
  public static void activateParry(Player paramPlayer) {
    int i = Main.getInstance().getConfig().getInt("CutlassParryCooldown", 30);
    clearParryBars(paramPlayer);
    BossBarManager.createBar(paramPlayer, "§e§lParry", i, ChatColor.YELLOW);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "active_parry", 0.0D);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), parryCooldownKey, i);
  }
  
  public static void clearParryBars(Player paramPlayer) {
    BossBarManager.removeBar(paramPlayer, "!! Parry x3 !!");
    BossBarManager.removeBar(paramPlayer, "!! Parry x2 !!");
    BossBarManager.removeBar(paramPlayer, "!! Parry x1 !!");
  }
  
  public static void startCutlassAttack(Player paramPlayer) {
    byte b = 2;
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "cutlassCuts", 1.0D);
    (new CutlassAttackTask(paramPlayer, b)).runTaskTimer((Plugin)Main.getInstance(), 0L, b);
  }
  
  public static void startCutlassParry(Player paramPlayer) {
    (new CutlassParryLaunchTask(paramPlayer)).runTaskLater((Plugin)Main.getInstance(), 10L);
  }
  
  public static LivingEntity findTargetEntity(LivingEntity paramLivingEntity, double paramDouble) {
    LivingEntity livingEntity = null;
    double d = Double.MAX_VALUE;
    Location location = paramLivingEntity.getLocation().clone().add(0.0D, 1.0D, 0.0D).add(paramLivingEntity.getLocation().getDirection().clone().normalize().multiply(paramDouble));
    for (Entity entity : location.getNearbyEntities(paramDouble, paramDouble, paramDouble)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity1 = (LivingEntity)entity;
        {
          if (livingEntity1.equals(paramLivingEntity))
            continue; 
        }{
          if (paramLivingEntity.getWorld() != livingEntity1.getWorld())
            continue; 
        }double d1 = paramLivingEntity.getLocation().distance(livingEntity1.getLocation());
        if (d1 < d) {
          d = d1;
          livingEntity = livingEntity1;
        } 
      } 
    } 
    return livingEntity;
  }

  static {
    cutsCooldownKey = "cuts";
    parryCooldownKey = "parry";
    parryHits = new HashMap<>();
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aj.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */