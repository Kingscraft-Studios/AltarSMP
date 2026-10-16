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

public class NetheriteChestplateComboAbility implements Listener {
  public Main plugin;

  public BukkitTask comboTask;

  public HashMap<UUID, Integer> attackComboCounts = new HashMap<>();

  public HashSet<UUID> activeComboPlayers = new HashSet<>();

  public HashMap<UUID, Long> lastAttackTimestamps = new HashMap<>();

  static double MAX_DAMAGE;

  private static final String DAMAGE_CONFIG_KEY;

  public NetheriteChestplateComboAbility(Main paramMain) {
    this.plugin = paramMain;
    MAX_DAMAGE = Main.getInstance().getConfig().getDouble(DAMAGE_CONFIG_KEY, 5.0D);
    Bukkit.getPluginManager().registerEvents(this, (Plugin)paramMain);
    startComboTask();
  }

  public void startComboTask() {
    this.comboTask = (new NetheriteChestplateResistanceTask(this)).runTaskTimer((Plugin)this.plugin, 0L, 20L);
  }

  public static boolean hasCustomNetheriteChestplate(Player paramPlayer) {
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

  public void applyResistance(Player paramPlayer) {
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 200, 0));
  }

  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
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
      if (!hasCustomNetheriteChestplate(player))
        return;
    } catch (MatchException matchException) {
      throw a(null);
    }
    UUID uUID = player.getUniqueId();
    long l = System.currentTimeMillis();
    try {
      if (this.lastAttackTimestamps.containsKey(uUID))
        try {
          if (l - ((Long)this.lastAttackTimestamps.get(uUID)).longValue() < 250L)
            return;
        } catch (MatchException matchException) {
          throw a(null);
        }
    } catch (MatchException matchException) {
      throw a(null);
    }
    try {
      this.lastAttackTimestamps.put(uUID, Long.valueOf(l));
      if (this.activeComboPlayers.contains(uUID))
        return;
    } catch (MatchException matchException) {
      throw a(null);
    }
    int i = ((Integer)this.attackComboCounts.getOrDefault(uUID, Integer.valueOf(0))).intValue() + 1;
    try {
      this.attackComboCounts.put(uUID, Integer.valueOf(i));
      if (i >= 7) {
        triggerLightningCombo(livingEntity.getLocation(), player, livingEntity);
        this.attackComboCounts.remove(uUID);
        this.activeComboPlayers.add(uUID);
        (new NetheriteChestplateComboResetTask(this, uUID)).runTaskLater((Plugin)this.plugin, 5L);
      }
    } catch (MatchException matchException) {
      throw a(null);
    }
  }

  public void triggerLightningCombo(Location paramLocation, Player paramPlayer, LivingEntity paramLivingEntity) {
    double d = 3.0D;
    byte b1 = 5;
    for (byte b2 = 0; b2 < b1; b2++) {
      double d1 = 6.283185307179586D / b1 * b2;
      double d2 = paramLocation.getX() + d * Math.cos(d1);
      double d3 = paramLocation.getZ() + d * Math.sin(d1);
      Location location = new Location(paramLocation.getWorld(), d2, paramLocation.getY(), d3);
      paramLocation.getWorld().strikeLightningEffect(location);
    }
    (new NetheriteChestplateComboDamageTask(this, paramLivingEntity, paramPlayer)).runTaskLater((Plugin)this.plugin, 1L);
  }

  static {
    DAMAGE_CONFIG_KEY = "copperChestplateDamage";
    MAX_DAMAGE = 5.0D;
}

  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ay.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */