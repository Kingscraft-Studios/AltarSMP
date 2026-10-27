package net.kingscraft.zenixmc.altarsmp.copper.chestplate;

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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class CopperChestplateComboAbility implements Listener {
  public AltarSMP plugin;

  public BukkitTask comboTask;

  public HashMap<UUID, Integer> attackComboCounts = new HashMap<>();

  public HashSet<UUID> activeComboPlayers = new HashSet<>();

  public HashMap<UUID, Long> lastAttackTimestamps = new HashMap<>();

  public static double MAX_DAMAGE;

  public static final String DAMAGE_CONFIG_KEY;

  public CopperChestplateComboAbility(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
    MAX_DAMAGE = AltarSMP.getInstance().getConfig().getDouble(DAMAGE_CONFIG_KEY, 5.0D);
    Bukkit.getPluginManager().registerEvents(this, paramAltarSMP);
    startComboTask();
  }

  public void startComboTask() {
    this.comboTask = (new CopperChestplateResistanceTask(this)).runTaskTimer(this.plugin, 0L, 20L);
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

    if (itemMeta.getCustomModelDataComponent().getFloats().isEmpty())
      return false;


    return (itemMeta.getCustomModelDataComponent().getFloats().getFirst() == 1);
  }

  public void applyResistance(Player paramPlayer) {
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 200, 0));
  }

  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    if (!(paramEntityDamageByEntityEvent.getDamager() instanceof Player player))
      return;

    if (!(paramEntityDamageByEntityEvent.getEntity() instanceof LivingEntity livingEntity))
      return;

    if (paramEntityDamageByEntityEvent.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK)
      return;

    if (!hasCustomNetheriteChestplate(player))
      return;

    UUID uUID = player.getUniqueId();
    long l = System.currentTimeMillis();
    if (this.lastAttackTimestamps.containsKey(uUID))
      {
        if (l - this.lastAttackTimestamps.get(uUID) < 250L)
          return;
      }

    this.lastAttackTimestamps.put(uUID, l);
    if (this.activeComboPlayers.contains(uUID))
      return;

    int i = this.attackComboCounts.getOrDefault(uUID, 0) + 1;
    this.attackComboCounts.put(uUID, i);
    if (i >= 7) {
      triggerLightningCombo(livingEntity.getLocation(), player, livingEntity);
      this.attackComboCounts.remove(uUID);
      this.activeComboPlayers.add(uUID);
      (new CopperChestplateComboResetTask(this, uUID)).runTaskLater(this.plugin, 5L);
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
    (new CopperChestplateComboDamageTask(paramLivingEntity, paramPlayer)).runTaskLater(this.plugin, 1L);
  }

  static {
    DAMAGE_CONFIG_KEY = "copperChestplateDamage";
    MAX_DAMAGE = 5.0D;
}

}
