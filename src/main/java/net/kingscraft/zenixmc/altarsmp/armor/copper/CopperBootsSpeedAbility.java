package net.kingscraft.zenixmc.altarsmp.armor.copper;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class CopperBootsSpeedAbility implements Listener {
  public static final Set<Material> COPPER_BLOCK_MATERIALS;

  public final AltarSMP plugin;

  public final Map<UUID, Integer> previousSpeedAmplifiers = new HashMap<>();

  public final Set<Player> copperBootsPlayers = Collections.newSetFromMap(new WeakHashMap<>());

  private final Map<Player, Boolean> previousGroundStates = new WeakHashMap<>();

  public BukkitTask groundCheckTask;

  public BukkitTask effectRefreshTask;

  public boolean enableFireResistance;

  public static final String a;

  public CopperBootsSpeedAbility(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
    loadConfiguration();
    initializeOnlinePlayers();
    startTasks();
  }

  public void loadConfiguration() {
    this.enableFireResistance = this.plugin.getConfig().getBoolean(a, true);
  }

  public void initializeOnlinePlayers() {
    for (Player player : Bukkit.getOnlinePlayers())
      updateCopperBootsStatus(player);
  }

  public void startTasks() {
    cancelTasks();
    startGroundCheckTask();
    startEffectRefreshTask();
  }

  public void startGroundCheckTask() {
    this.groundCheckTask = (new CopperBootsFlameParticleTask(this)).runTaskTimer((Plugin)this.plugin, 0L, 1L);
  }

  public void startEffectRefreshTask() {
    this.effectRefreshTask = (new CopperBootsEffectRefreshTask(this)).runTaskTimer((Plugin)this.plugin, 0L, 10L);
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent paramPlayerJoinEvent) {
    updateCopperBootsStatus(paramPlayerJoinEvent.getPlayer());
  }

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent paramPlayerQuitEvent) {
    Player player = paramPlayerQuitEvent.getPlayer();
    this.copperBootsPlayers.remove(player);
    this.previousGroundStates.remove(player);
    this.previousSpeedAmplifiers.remove(player.getUniqueId());
  }

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent paramPlayerMoveEvent) {
    if (paramPlayerMoveEvent.getTo() == null)
      return; 

    if (paramPlayerMoveEvent.getFrom().getBlockX() == paramPlayerMoveEvent.getTo().getBlockX())
      {
        if (paramPlayerMoveEvent.getFrom().getBlockY() == paramPlayerMoveEvent.getTo().getBlockY())
          {
            if (paramPlayerMoveEvent.getFrom().getBlockZ() == paramPlayerMoveEvent.getTo().getBlockZ())
              return; 
          }  
      }  

    Player player = paramPlayerMoveEvent.getPlayer();
    updateCopperBootsStatus(player);
    if (!this.copperBootsPlayers.contains(player))
      return; 

    updatePlayerEffects(player, true);
  }

  public void updateCopperBootsStatus(Player paramPlayer) {
    if (hasCustomNetheriteBoots(paramPlayer)) {
      this.copperBootsPlayers.add(paramPlayer);
      this.previousGroundStates.putIfAbsent(paramPlayer, Boolean.valueOf(isStandingOnCopper(paramPlayer)));
    } else {
      this.copperBootsPlayers.remove(paramPlayer);
      this.previousGroundStates.remove(paramPlayer);
    } 

  }

  public void updatePlayerEffects(Player paramPlayer, boolean paramBoolean) {
    if (!this.copperBootsPlayers.contains(paramPlayer))
      return; 

    boolean bool1 = isStandingOnCopper(paramPlayer);
    boolean bool2 = ((Boolean)this.previousGroundStates.getOrDefault(paramPlayer, Boolean.valueOf(false))).booleanValue();
    if (paramBoolean)
      {
        if (bool1 == bool2) {
          applySpeedEffects(paramPlayer, bool1);
          return;
        } 
      }  

    this.previousGroundStates.put(paramPlayer, Boolean.valueOf(bool1));
    applyImmediateSpeedEffects(paramPlayer, bool1);
  }

  public void applySpeedEffects(Player paramPlayer, boolean paramBoolean) {
    if (paramBoolean) {
      applyPotionEffectIfNeeded(paramPlayer, PotionEffectType.SPEED, 60, 3);
    } else {
      applyPotionEffectIfNeeded(paramPlayer, PotionEffectType.SPEED, 60, 2);
    } 

    if (this.enableFireResistance)
      applyPotionEffectIfNeeded(paramPlayer, PotionEffectType.FIRE_RESISTANCE, 60, 0);

  }

  public void applyImmediateSpeedEffects(Player paramPlayer, boolean paramBoolean) {
    if (paramBoolean) {
      paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 3, false, false, false));
    } else {
      paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 2, false, false, false));
    } 

    if (this.enableFireResistance)
      applyPotionEffectIfNeeded(paramPlayer, PotionEffectType.FIRE_RESISTANCE, 60, 0);

  }

  public void applyPotionEffectIfNeeded(Player paramPlayer, PotionEffectType paramPotionEffectType, int paramInt1, int paramInt2) {
    PotionEffect potionEffect = paramPlayer.getPotionEffect(paramPotionEffectType);
    if (potionEffect != null)
      {
        if (potionEffect.getAmplifier() == paramInt2)
          {
            if (potionEffect.getDuration() > 20)
              return; 
          }  
      }  

    paramPlayer.addPotionEffect(new PotionEffect(paramPotionEffectType, paramInt1, paramInt2, false, false, false));
  }

  public static boolean hasCustomNetheriteBoots(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getBoots();
    if (itemStack == null)
      return false; 

    if (itemStack.getType() != Material.NETHERITE_BOOTS)
      return false; 

    if (!itemStack.hasItemMeta())
      return false; 

    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta != null)
      {
        if (itemMeta.hasCustomModelData())
          {
            if (itemMeta.getCustomModelData() == 1);
          }  
      }  

    return false;
  }

  public boolean isStandingOnCopper(Player paramPlayer) {
    Block block = paramPlayer.getLocation().getBlock().getRelative(0, -1, 0);
    return COPPER_BLOCK_MATERIALS.contains(block.getType());
  }

  public void cancelTasks() {
    if (this.groundCheckTask != null) {
      this.groundCheckTask.cancel();
      this.groundCheckTask = null;
    } 

    if (this.effectRefreshTask != null) {
      this.effectRefreshTask.cancel();
      this.effectRefreshTask = null;
    } 

  }

  static {
    a = "enableFireResistanceOnBoots";
    COPPER_BLOCK_MATERIALS = EnumSet.of(Material.COPPER_BLOCK, Material.CUT_COPPER, Material.EXPOSED_COPPER, Material.EXPOSED_CUT_COPPER, Material.WEATHERED_COPPER, Material.WEATHERED_CUT_COPPER, Material.OXIDIZED_COPPER, Material.OXIDIZED_CUT_COPPER, Material.WAXED_COPPER_BLOCK, Material.WAXED_CUT_COPPER, Material.WAXED_EXPOSED_COPPER, Material.WAXED_EXPOSED_CUT_COPPER, Material.WAXED_WEATHERED_COPPER, Material.WAXED_WEATHERED_CUT_COPPER, Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_CUT_COPPER);
}

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ax.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */