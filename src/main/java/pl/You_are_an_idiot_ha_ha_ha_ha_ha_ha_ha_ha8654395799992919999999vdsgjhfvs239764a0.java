package pl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0 implements Listener {
  private final Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  private final Map<UUID, Double> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new HashMap<>();
  
  private final Map<UUID, Boolean> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new HashMap<>();
  
  private final Map<UUID, Long> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = new HashMap<>();
  
  private static final boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  static double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = false;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = Main.getInstance().getConfig().getDouble("copperLeggingsMaxDamage", 30.0D);
  }
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getLeggings();
    {
      if (itemStack == null)
        return false; 
    }{
      if (itemStack.getType() != Material.NETHERITE_LEGGINGS)
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
    
    }return (itemMeta.getCustomModelData() == 1);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerMoveEvent paramPlayerMoveEvent) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    }Player player = paramPlayerMoveEvent.getPlayer();
    UUID uUID = player.getUniqueId();
    {
      if (player.getVelocity().getY() >= 0.8D) {
        {
          if (player.isOnGround())
            return; 
        }} else {
        return;
      } 
    }{
      if (paramPlayerMoveEvent.getFrom().getBlockY() == paramPlayerMoveEvent.getTo().getBlockY())
        return; 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player)) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(uUID);
        return;
      } 
    }double d = player.getLocation().getY();
    {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(uUID)) {
        {
          if (player.getVelocity().getY() > 0.8D)
            {
              if (!player.isOnGround()) {
                this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(uUID, Double.valueOf(d));
                this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.put(uUID, Long.valueOf(System.currentTimeMillis()));
              } 
            }}return;
      } 
    }Long long_ = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.get(uUID);
    {
      if (long_ != null)
        {
          if (System.currentTimeMillis() - long_.longValue() <= 10000L) {
            {
              this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.compute(uUID, (paramK, paramV) -> lambda$onMove$0(d, paramK, paramV));
              if (!player.isOnGround())
                return; 
            }double d1 = ((Double)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.get(uUID)).doubleValue();
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(uUID);
            double d2 = d1 - d;
            {
              if (d2 < 5.0D)
                return; 
            }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, player.getLocation(), d2);
            return;
          } 
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(uUID);
          return;
        }}You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(uUID);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageEvent paramEntityDamageEvent) {
    Player player;
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    }Entity entity = paramEntityDamageEvent.getEntity();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    {
      if (paramEntityDamageEvent.getCause() != EntityDamageEvent.DamageCause.FALL)
        return; 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player))
        return; 
    }double d = player.getFallDistance();
    Location location = player.getLocation().clone();
    {
      paramEntityDamageEvent.setCancelled(true);
      if (d < 5.0D)
        return; 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, location, d);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(UUID paramUUID) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.remove(paramUUID);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(paramUUID);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(paramUUID);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, Location paramLocation, double paramDouble) {
    World world = paramLocation.getWorld();
    if (world == null) {
      return;
    }
    double d = Math.pow(paramDouble / 5.0D, 1.5D) * 15.0D;
    d = Math.min(d, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f);
    double d2 = Math.min(paramDouble / 4.0D, 8.0D);
    if (paramDouble >= 5.0D && paramDouble < 10.0D) {
      world.playSound(paramLocation, Sound.ENTITY_GENERIC_EXPLODE, 0.5F, 1.2F);
      world.spawnParticle(Particle.EXPLOSION, paramLocation, 1);
      world.spawnParticle(Particle.BLOCK, paramLocation.clone().add(0.0D, 0.1D, 0.0D), 30, 0.5D, 0.1D, 0.5D, Material.DIRT.createBlockData());
    }
    if (paramDouble >= 10.0D && paramDouble < 90.0D) {
      world.playSound(paramLocation, Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 0.9F);
      world.spawnParticle(Particle.EXPLOSION, paramLocation, 3, 0.5D, 0.1D, 0.5D);
      world.spawnParticle(Particle.BLOCK, paramLocation.clone().add(0.0D, 0.1D, 0.0D), 60, 1.0D, 0.1D, 1.0D, Material.STONE.createBlockData());
      world.spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, paramLocation, 20, 0.5D, 0.1D, 0.5D, 0.05D);
    }
    if (paramDouble >= 90.0D) {
      world.playSound(paramLocation, Sound.ENTITY_GENERIC_EXPLODE, 2.0F, 0.7F);
      world.playSound(paramLocation, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.5F, 0.8F);
      world.spawnParticle(Particle.EXPLOSION, paramLocation, 8, 1.0D, 0.2D, 1.0D);
      world.spawnParticle(Particle.EXPLOSION, paramLocation, 2);
      world.spawnParticle(Particle.BLOCK, paramLocation.clone().add(0.0D, 0.1D, 0.0D), 100, 2.0D, 0.2D, 2.0D, Material.STONE.createBlockData());
      world.spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, paramLocation, 40, 1.0D, 0.5D, 1.0D, 0.1D);
      world.spawnParticle(Particle.LAVA, paramLocation, 15, 1.5D, 0.1D, 1.5D);
      double d5 = Math.min(paramDouble / 10.0D, 4.0D);
      Bukkit.getScheduler().runTask(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, () -> lambda$triggerShockwave$1(d5, paramLocation));
    }
    Collection<? extends Entity> collection = world.getNearbyEntities(paramLocation, d2, d2, d2);
    for (Entity entity : collection) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity) entity;
        if (entity.equals(paramPlayer)) {
          continue;
        }
        if (paramLocation.getWorld() != livingEntity.getWorld()) {
          continue;
        }
        double d3 = livingEntity.getLocation().distance(paramLocation);
        if (d3 > d2) {
          continue;
        }
        double d4 = Math.max(0.0D, d * (1.5D - d3 / d2));
        if (d4 <= 0.0D) {
          continue;
        }
        livingEntity.damage(d4, paramPlayer);
        Vector vector = livingEntity.getLocation().toVector().subtract(paramLocation.toVector());
        if (vector.lengthSquared() > 1.0E-4D) {
          vector.normalize().multiply(0.5D).setY(0.3D);
          livingEntity.setVelocity(vector);
        }
      }
    }
  }
  
  private static void lambda$triggerShockwave$1(double paramDouble, Location paramLocation) {
    for (int i = -((int)paramDouble); i <= paramDouble; i++) {
      for (byte b = -1; b <= 1; b++) {
        for (int j = -((int)paramDouble); j <= paramDouble; j++) {
          Location location = paramLocation.clone().add(i, b, j);
          {
            if (paramLocation.getWorld() == location.getWorld())
              {
                if (location.distance(paramLocation) <= paramDouble) {
                  Material material = location.getBlock().getType();
                  {
                    if (material != Material.AIR)
                      {
                        if (material != Material.BEDROCK)
                          {
                            if (material != Material.OBSIDIAN)
                              {
                                if (material != Material.BARRIER)
                                  {
                                    if (!material.name().contains("COMMAND"))
                                      {
                                        if (Math.random() < 0.5D)
                                          location.getBlock().breakNaturally(); 
                                      }}}}}}} 
              }}} 
      } 
    } 
  }
  
  private static Double lambda$onMove$0(double paramDouble, UUID paramUUID, Double paramDouble1) {
    return Double.valueOf(Math.max(paramDouble1.doubleValue(), paramDouble));
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */