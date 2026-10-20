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
    if (itemStack == null)
      return false; 

    if (itemStack.getType() != Material.NETHERITE_HELMET)
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

  public void handleSneakAbility(Player paramPlayer) {
    UUID uUID = paramPlayer.getUniqueId();
    if (paramPlayer.isSneaking()) {
      int i = ((Integer)this.sneakCounts.getOrDefault(uUID, Integer.valueOf(0))).intValue() + 1;
      this.sneakCounts.put(uUID, Integer.valueOf(i));
      if (i <= 4) {
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_TRIAL_SPAWNER_CLOSE_SHUTTER, 1.0F, 1.0F);
      } else if (i >= 5) {
        this.sneakCounts.put(uUID, Integer.valueOf(0));
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_TRIAL_SPAWNER_CLOSE_SHUTTER, 1.0F, 1.0F);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1.0F, 1.0F);
        paramPlayer.getWorld().strikeLightning(paramPlayer.getLocation());
        for (Player player : paramPlayer.getLocation().getNearbyPlayers(50.0D)) {
          if (!player.getUniqueId().equals(uUID))
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 600, 1)); 

        } 
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
    if (this.effectTask != null)
      this.effectTask.cancel();

    this.sneakCounts.clear();
  }

  static {
    STRENGTH_AMPLIFIER = AltarSMP.getInstance().getConfig().getInt("copperHelmetStrengthAmplifier", 1) - 1;
  }

}
