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

    if (itemStack.getType() != Material.NETHERITE_PICKAXE)
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

  public void startTask() {
    (new CopperOreVeinMinerStatusTask(this)).runTaskTimer(this.plugin, 0L, 10L);
  }

  @EventHandler
  public void handleSwapHandItems(PlayerSwapHandItemsEvent paramPlayerSwapHandItemsEvent) {
    Player player = paramPlayerSwapHandItemsEvent.getPlayer();
    UUID uUID = player.getUniqueId();
    if (isCopperPickaxe(player)) {
      paramPlayerSwapHandItemsEvent.setCancelled(true);
      boolean bool = this.veinMinerEnabled.getOrDefault(uUID, Boolean.TRUE);


      boolean bool1 = !bool;
      this.veinMinerEnabled.put(uUID, bool1);
      if (bool1) {
        player.getWorld().playSound(player.getLocation(), Sound.BLOCK_RESPAWN_ANCHOR_CHARGE, 1.0F, 2.0F);
      } else {
        player.getWorld().playSound(player.getLocation(), Sound.BLOCK_RESPAWN_ANCHOR_CHARGE, 1.0F, 2.0F);
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
      boolean bool = this.veinMinerEnabled.getOrDefault(uUID, Boolean.TRUE);
      if (bool) {
        for (int b = -1; b <= 1; b++) {
          for (int b1 = -1; b1 <= 1; b1++) {
            for (int b2 = -1; b2 <= 1; b2++) {
              if (b != 0 && b1 != 0 && b2 != 0) {
                Block block1 = location.clone().add(b, b1, b2).getBlock();
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
    if (material == Material.AIR)
      return; 

    if (paramBlock.getType().getHardness() < 0.0F)
      return; 

    Location location = paramBlock.getLocation().add(0.5D, 0.5D, 0.5D);
    paramBlock.getWorld().spawnParticle(Particle.BLOCK, location, 20, 0.3D, 0.3D, 0.3D, 0.1D, Material.COPPER_ORE.createBlockData());
    if (material != Material.LAVA) {
      if (material == Material.WATER) {
        paramBlock.setType(Material.AIR);
        return;
      } 

      paramBlock.breakNaturally(paramPlayer.getInventory().getItemInMainHand());
      return;
    } 

    paramBlock.setType(Material.AIR);
  }

}
