package net.kingscraft.zenixmc.altarsmp.armor.copper;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class CopperOreVeinMinerListener implements Listener {
  public AltarSMP plugin;
  
  public HashMap<UUID, Boolean> veinMinerEnabled = new HashMap<>();
  
  public CopperOreVeinMinerListener(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
    startTask();
  }
  
  public static boolean isCopperPickaxe(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    try {
      if (itemStack == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemStack.getType() != Material.NETHERITE_PICKAXE)
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
  
  public void startTask() {
    (new CopperOreVeinMinerStatusTask(this)).runTaskTimer((Plugin)this.plugin, 0L, 10L);
  }
  
  @EventHandler
  public void handleSwapHandItems(PlayerSwapHandItemsEvent paramPlayerSwapHandItemsEvent) {
    Player player = paramPlayerSwapHandItemsEvent.getPlayer();
    UUID uUID = player.getUniqueId();
    if (isCopperPickaxe(player)) {
      paramPlayerSwapHandItemsEvent.setCancelled(true);
      boolean bool = ((Boolean)this.veinMinerEnabled.getOrDefault(uUID, Boolean.valueOf(true))).booleanValue();
      try {
      
      } catch (MatchException matchException) {
        throw a(null);
      } 
      boolean bool1 = !bool ? true : false;
      try {
        this.veinMinerEnabled.put(uUID, Boolean.valueOf(bool1));
        if (bool1) {
          player.getWorld().playSound(player.getLocation(), Sound.BLOCK_RESPAWN_ANCHOR_CHARGE, 1.0F, 2.0F);
        } else {
          player.getWorld().playSound(player.getLocation(), Sound.BLOCK_RESPAWN_ANCHOR_CHARGE, 1.0F, 2.0F);
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
  }
  
  @EventHandler
  public void handleBlockBreak(BlockBreakEvent paramBlockBreakEvent) {
    Player player = paramBlockBreakEvent.getPlayer();
    Block block = paramBlockBreakEvent.getBlock();
    Location location = block.getLocation();
    if (isCopperPickaxe(player)) {
      UUID uUID = player.getUniqueId();
      boolean bool = ((Boolean)this.veinMinerEnabled.getOrDefault(uUID, Boolean.valueOf(true))).booleanValue();
      if (bool) {
        for (int b = -1; b <= 1; b++) {
          for (int b1 = -1; b1 <= 1; b1++) {
            for (int b2 = -1; b2 <= 1; b2++) {
              if (b != 0 && b1 != 0 && b2 != 0) {
                Block block1 = location.clone().add((double)b, (double)b1, (double)b2).getBlock();
                this.breakNearbyBlock(block1, player);
              } 
            } 
          } 
        } 
      } 
    } 
  }
  
  public void breakNearbyBlock(Block paramBlock, Player paramPlayer) {
    Material material = paramBlock.getType();
    try {
      if (material == Material.AIR)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramBlock.getType().getHardness() < 0.0F)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Location location = paramBlock.getLocation().add(0.5D, 0.5D, 0.5D);
    try {
      paramBlock.getWorld().spawnParticle(Particle.BLOCK, location, 20, 0.3D, 0.3D, 0.3D, 0.1D, Material.COPPER_ORE.createBlockData());
      if (material != Material.LAVA) {
        try {
          if (material == Material.WATER) {
            paramBlock.setType(Material.AIR);
            return;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        paramBlock.breakNaturally(paramPlayer.getInventory().getItemInMainHand());
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramBlock.setType(Material.AIR);
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a1.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */