package pl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ay implements Listener {
  public Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public BukkitTask You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public HashMap<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new HashMap<>();
  
  public HashSet<UUID> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = new HashSet<>();
  
  public HashMap<UUID, Long> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = new HashMap<>();
  
  static double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  private static final String a;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ay(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = Main.getInstance().getConfig().getDouble(a, 5.0D);
    Bukkit.getPluginManager().registerEvents(this, (Plugin)paramMain);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f8(this)).runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 0L, 20L);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getChestplate();
    try {
      if (itemStack == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemStack.getType() != Material.NETHERITE_CHESTPLATE)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemStack.hasItemMeta())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    ItemMeta itemMeta = itemStack.getItemMeta();
    try {
      if (itemMeta == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemMeta.hasCustomModelData())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
    
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return (itemMeta.getCustomModelData() == 1);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 200, 0));
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    try {
      if (!(paramEntityDamageByEntityEvent.getDamager() instanceof Player))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!(paramEntityDamageByEntityEvent.getEntity() instanceof LivingEntity))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramEntityDamageByEntityEvent.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Player player = (Player)paramEntityDamageByEntityEvent.getDamager();
    LivingEntity livingEntity = (LivingEntity)paramEntityDamageByEntityEvent.getEntity();
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    UUID uUID = player.getUniqueId();
    long l = System.currentTimeMillis();
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.containsKey(uUID))
        try {
          if (l - ((Long)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.get(uUID)).longValue() < 250L)
            return; 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.put(uUID, Long.valueOf(l));
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.contains(uUID))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    int i = ((Integer)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getOrDefault(uUID, Integer.valueOf(0))).intValue() + 1;
    try {
      this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.put(uUID, Integer.valueOf(i));
      if (i >= 7) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity.getLocation(), player, livingEntity);
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(uUID);
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.add(uUID);
        (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f9(this, uUID)).runTaskLater((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 5L);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Player paramPlayer, LivingEntity paramLivingEntity) {
    double d = 3.0D;
    byte b1 = 5;
    for (byte b2 = 0; b2 < b1; b2++) {
      double d1 = 6.283185307179586D / b1 * b2;
      double d2 = paramLocation.getX() + d * Math.cos(d1);
      double d3 = paramLocation.getZ() + d * Math.sin(d1);
      Location location = new Location(paramLocation.getWorld(), d2, paramLocation.getY(), d3);
      paramLocation.getWorld().strikeLightningEffect(location);
    } 
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f_(this, paramLivingEntity, paramPlayer)).runTaskLater((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 1L);
  }
  
  static {
    a = "copperChestplateDamage";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = 5.0D;
}

  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ay.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */