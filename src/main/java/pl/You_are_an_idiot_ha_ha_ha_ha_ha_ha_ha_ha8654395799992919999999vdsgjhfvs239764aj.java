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

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aj implements Listener {
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public static HashMap<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  
  
  @EventHandler
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
    }{
      if (CooldownManager.isOnCooldown(player.getUniqueId(), "cutlassCuts"))
        return; 
    }
      CombatEffectUtils.spawnDualParticleRings((LivingEntity)player, Particle.ELECTRIC_SPARK, Particle.CRIT, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 2.0F);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    {
      if (Main.areSimilar(paramPlayer.getInventory().getItemInMainHand(), CustomItem.CUTLASS.getItem()))
        return true; 
    }return false;
  }
  
  @EventHandler
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
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
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.put(player.getUniqueId(), Integer.valueOf(((Integer)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getOrDefault(player.getUniqueId(), Integer.valueOf(3))).intValue() - 1));
        int j = ((Integer)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getOrDefault(player.getUniqueId(), Integer.valueOf(3))).intValue();
        {
          if (j != 0)
            BossBarManager.createBar(player, "§6§l!! §e§lParry x" + j + " §6§l!!", i, ChatColor.YELLOW, BarColor.RED);
        }{
          paramEntityDamageByEntityEvent.setCancelled(true);
          player.getWorld().playSound((Entity)player, Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
          livingEntity.setVelocity(player.getLocation().getDirection().multiply(0.5D));
          if (j == 0) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(player.getUniqueId());
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
          } 
        }} 
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    int i = Main.getInstance().getConfig().getInt("CutlassParryCooldown", 30);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
    BossBarManager.createBar(paramPlayer, "§e§lParry", i, ChatColor.YELLOW);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "active_parry", 0.0D);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, i);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    BossBarManager.removeBar(paramPlayer, "!! Parry x3 !!");
    BossBarManager.removeBar(paramPlayer, "!! Parry x2 !!");
    BossBarManager.removeBar(paramPlayer, "!! Parry x1 !!");
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    byte b = 2;
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "cutlassCuts", 1.0D);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d6(paramPlayer, b)).runTaskTimer((Plugin)Main.getInstance(), 0L, b);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(Player paramPlayer) {
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d7(paramPlayer)).runTaskLater((Plugin)Main.getInstance(), 10L);
  }
  
  public static LivingEntity You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(LivingEntity paramLivingEntity, double paramDouble) {
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

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = "cuts";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = "parry";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new HashMap<>();
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aj.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */