package pl;

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

public class CopperBootsSpeedAbility implements Listener {
  private static final Set<Material> COPPER_BLOCK_MATERIALS;
  
  private final Main plugin;
  
  public final Map<UUID, Integer> previousSpeedAmplifiers = new HashMap<>();
  
  public final Set<Player> copperBootsPlayers = Collections.newSetFromMap(new WeakHashMap<>());
  
  private final Map<Player, Boolean> previousGroundStates = new WeakHashMap<>();
  
  private BukkitTask groundCheckTask;
  
  private BukkitTask effectRefreshTask;
  
  public boolean enableFireResistance;
  
  private static final String a;
  
  public CopperBootsSpeedAbility(Main paramMain) {
    this.plugin = paramMain;
    loadConfiguration();
    initializeOnlinePlayers();
    startTasks();
  }
  
  public void loadConfiguration() {
    this.enableFireResistance = this.plugin.getConfig().getBoolean(a, true);
  }
  
  private void initializeOnlinePlayers() {
    for (Player player : Bukkit.getOnlinePlayers())
      updateCopperBootsStatus(player);
  }
  
  public void startTasks() {
    cancelTasks();
    startGroundCheckTask();
    startEffectRefreshTask();
  }
  
  private void startGroundCheckTask() {
    this.groundCheckTask = (new CopperBootsFlameParticleTask(this)).runTaskTimer((Plugin)this.plugin, 0L, 1L);
  }
  
  private void startEffectRefreshTask() {
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
    try {
      if (paramPlayerMoveEvent.getTo() == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramPlayerMoveEvent.getFrom().getBlockX() == paramPlayerMoveEvent.getTo().getBlockX())
        try {
          if (paramPlayerMoveEvent.getFrom().getBlockY() == paramPlayerMoveEvent.getTo().getBlockY())
            try {
              if (paramPlayerMoveEvent.getFrom().getBlockZ() == paramPlayerMoveEvent.getTo().getBlockZ())
                return; 
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Player player = paramPlayerMoveEvent.getPlayer();
    try {
      updateCopperBootsStatus(player);
      if (!this.copperBootsPlayers.contains(player))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    updatePlayerEffects(player, true);
  }
  
  private void updateCopperBootsStatus(Player paramPlayer) {
    try {
      if (hasCustomNetheriteBoots(paramPlayer)) {
        this.copperBootsPlayers.add(paramPlayer);
        this.previousGroundStates.putIfAbsent(paramPlayer, Boolean.valueOf(isStandingOnCopper(paramPlayer)));
      } else {
        this.copperBootsPlayers.remove(paramPlayer);
        this.previousGroundStates.remove(paramPlayer);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public void updatePlayerEffects(Player paramPlayer, boolean paramBoolean) {
    try {
      if (!this.copperBootsPlayers.contains(paramPlayer))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    boolean bool1 = isStandingOnCopper(paramPlayer);
    boolean bool2 = ((Boolean)this.previousGroundStates.getOrDefault(paramPlayer, Boolean.valueOf(false))).booleanValue();
    try {
      if (paramBoolean)
        try {
          if (bool1 == bool2) {
            applySpeedEffects(paramPlayer, bool1);
            return;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.previousGroundStates.put(paramPlayer, Boolean.valueOf(bool1));
    applyImmediateSpeedEffects(paramPlayer, bool1);
  }
  
  private void applySpeedEffects(Player paramPlayer, boolean paramBoolean) {
    try {
      if (paramBoolean) {
        applyPotionEffectIfNeeded(paramPlayer, PotionEffectType.SPEED, 60, 3);
      } else {
        applyPotionEffectIfNeeded(paramPlayer, PotionEffectType.SPEED, 60, 2);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.enableFireResistance)
        applyPotionEffectIfNeeded(paramPlayer, PotionEffectType.FIRE_RESISTANCE, 60, 0);
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private void applyImmediateSpeedEffects(Player paramPlayer, boolean paramBoolean) {
    try {
      if (paramBoolean) {
        paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 3, false, false, false));
      } else {
        paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 2, false, false, false));
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.enableFireResistance)
        applyPotionEffectIfNeeded(paramPlayer, PotionEffectType.FIRE_RESISTANCE, 60, 0);
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private void applyPotionEffectIfNeeded(Player paramPlayer, PotionEffectType paramPotionEffectType, int paramInt1, int paramInt2) {
    PotionEffect potionEffect = paramPlayer.getPotionEffect(paramPotionEffectType);
    try {
      if (potionEffect != null)
        try {
          if (potionEffect.getAmplifier() == paramInt2)
            try {
              if (potionEffect.getDuration() > 20)
                return; 
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramPlayer.addPotionEffect(new PotionEffect(paramPotionEffectType, paramInt1, paramInt2, false, false, false));
  }
  
  public static boolean hasCustomNetheriteBoots(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getBoots();
    try {
      if (itemStack == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemStack.getType() != Material.NETHERITE_BOOTS)
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
      if (itemMeta != null)
        try {
          if (itemMeta.hasCustomModelData())
            try {
              if (itemMeta.getCustomModelData() == 1);
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return false;
  }
  
  public boolean isStandingOnCopper(Player paramPlayer) {
    Block block = paramPlayer.getLocation().getBlock().getRelative(0, -1, 0);
    return COPPER_BLOCK_MATERIALS.contains(block.getType());
  }
  
  private void cancelTasks() {
    try {
      if (this.groundCheckTask != null) {
        this.groundCheckTask.cancel();
        this.groundCheckTask = null;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.effectRefreshTask != null) {
        this.effectRefreshTask.cancel();
        this.effectRefreshTask = null;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  static {
    a = "enableFireResistanceOnBoots";
    COPPER_BLOCK_MATERIALS = EnumSet.of(Material.COPPER_BLOCK, Material.CUT_COPPER, Material.EXPOSED_COPPER, Material.EXPOSED_CUT_COPPER, Material.WEATHERED_COPPER, Material.WEATHERED_CUT_COPPER, Material.OXIDIZED_COPPER, Material.OXIDIZED_CUT_COPPER, Material.WAXED_COPPER_BLOCK, Material.WAXED_CUT_COPPER, Material.WAXED_EXPOSED_COPPER, Material.WAXED_EXPOSED_CUT_COPPER, Material.WAXED_WEATHERED_COPPER, Material.WAXED_WEATHERED_CUT_COPPER, Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_CUT_COPPER);
}

  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ax.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */