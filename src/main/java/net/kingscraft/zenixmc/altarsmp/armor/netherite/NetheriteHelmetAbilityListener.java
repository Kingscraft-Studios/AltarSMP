package net.kingscraft.zenixmc.altarsmp.armor.netherite;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class NetheriteHelmetAbilityListener implements Listener {
  public final AltarSMP plugin;
  
  public final Map<UUID, Integer> sneakCounts = new HashMap<>();
  
  public BukkitTask effectTask;
  
  public static final int STRENGTH_AMPLIFIER;
  
  public NetheriteHelmetAbilityListener(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
    startEffectTask();
  }
  
  public void startEffectTask() {
    this.effectTask = (new NetheriteHelmetEffectTask(this)).runTaskTimer((Plugin)this.plugin, 0L, 20L);
  }
  
  public static boolean isCustomNetheriteHelmet(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getHelmet();
    try {
      if (itemStack == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemStack.getType() != Material.NETHERITE_HELMET)
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
  
  public void handleSneakAbility(Player paramPlayer) {
    UUID uUID = paramPlayer.getUniqueId();
    if (paramPlayer.isSneaking()) {
      int i = ((Integer)this.sneakCounts.getOrDefault(uUID, Integer.valueOf(0))).intValue() + 1;
      try {
        this.sneakCounts.put(uUID, Integer.valueOf(i));
        if (i <= 4) {
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_TRIAL_SPAWNER_CLOSE_SHUTTER, 1.0F, 1.0F);
        } else if (i >= 5) {
          this.sneakCounts.put(uUID, Integer.valueOf(0));
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_TRIAL_SPAWNER_CLOSE_SHUTTER, 1.0F, 1.0F);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1.0F, 1.0F);
          paramPlayer.getWorld().strikeLightning(paramPlayer.getLocation());
          for (Player player : paramPlayer.getLocation().getNearbyPlayers(50.0D)) {
            try {
              if (!player.getUniqueId().equals(uUID))
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 600, 1)); 
            } catch (MatchException matchException) {
              throw a(null);
            } 
          } 
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } else {
      this.sneakCounts.put(uUID, Integer.valueOf(0));
    } 
  }
  
  public void applyWaterBreathing(Player paramPlayer) {
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 200, 0));
  }
  
  public void applyStrength(Player paramPlayer) {
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 200, STRENGTH_AMPLIFIER));
  }
  
  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent paramPlayerQuitEvent) {
    this.sneakCounts.remove(paramPlayerQuitEvent.getPlayer().getUniqueId());
  }
  
  public void stopEffectTask() {
    try {
      if (this.effectTask != null)
        this.effectTask.cancel();
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.sneakCounts.clear();
  }
  
  static {
    STRENGTH_AMPLIFIER = AltarSMP.getInstance().getConfig().getInt("copperHelmetStrengthAmplifier", 1) - 1;
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764az.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */