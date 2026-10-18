package net.kingscraft.zenixmc.altarsmp.armor.netherite;

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
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class NetheriteChestplateComboAbility implements Listener {
  public AltarSMP plugin;

  public BukkitTask comboTask;

  public HashMap<UUID, Integer> attackComboCounts = new HashMap<>();

  public HashSet<UUID> activeComboPlayers = new HashSet<>();

  public HashMap<UUID, Long> lastAttackTimestamps = new HashMap<>();

  public static double MAX_DAMAGE;

  public static final String DAMAGE_CONFIG_KEY;

  public NetheriteChestplateComboAbility(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
    MAX_DAMAGE = AltarSMP.getInstance().getConfig().getDouble(DAMAGE_CONFIG_KEY, 5.0D);
    Bukkit.getPluginManager().registerEvents(this, (Plugin)paramAltarSMP);
    startComboTask();
  }

  public void startComboTask() {
    this.comboTask = (new NetheriteChestplateResistanceTask(this)).runTaskTimer((Plugin)this.plugin, 0L, 20L);
  }

  public static boolean hasCustomNetheriteChestplate(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getChestplate();
    if (itemStack == null)
      return false;

    if (itemStack.getType() != Material.NETHERITE_CHESTPLATE)
      return false;

    if (!itemStack.hasItemMeta())
      return false;

    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta == null)
      return false;

    if (!itemMeta.hasCustomModelData())
      return false;


    return (itemMeta.getCustomModelData() == 1);
  }

  public void applyResistance(Player paramPlayer) {
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 200, 0));
  }

  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    if (!(paramEntityDamageByEntityEvent.getDamager() instanceof Player))
      return;

    if (!(paramEntityDamageByEntityEvent.getEntity() instanceof LivingEntity))
      return;

    if (paramEntityDamageByEntityEvent.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK)
      return;

    Player player = (Player)paramEntityDamageByEntityEvent.getDamager();
    LivingEntity livingEntity = (LivingEntity)paramEntityDamageByEntityEvent.getEntity();
    if (!hasCustomNetheriteChestplate(player))
      return;

    UUID uUID = player.getUniqueId();
    long l = System.currentTimeMillis();
    if (this.lastAttackTimestamps.containsKey(uUID))
      {
        if (l - ((Long)this.lastAttackTimestamps.get(uUID)).longValue() < 250L)
          return;
      }

    this.lastAttackTimestamps.put(uUID, Long.valueOf(l));
    if (this.activeComboPlayers.contains(uUID))
      return;

    int i = ((Integer)this.attackComboCounts.getOrDefault(uUID, Integer.valueOf(0))).intValue() + 1;
    this.attackComboCounts.put(uUID, Integer.valueOf(i));
    if (i >= 7) {
      triggerLightningCombo(livingEntity.getLocation(), player, livingEntity);
      this.attackComboCounts.remove(uUID);
      this.activeComboPlayers.add(uUID);
      (new NetheriteChestplateComboResetTask(this, uUID)).runTaskLater((Plugin)this.plugin, 5L);
    }

  }

  public void triggerLightningCombo(Location paramLocation, Player paramPlayer, LivingEntity paramLivingEntity) {
    double d = 3.0D;
    int b1 = 5;
    for (int b2 = 0; b2 < b1; b2++) {
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

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ay.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */