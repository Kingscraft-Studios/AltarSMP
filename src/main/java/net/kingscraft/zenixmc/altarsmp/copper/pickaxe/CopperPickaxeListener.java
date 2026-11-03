package net.kingscraft.zenixmc.altarsmp.copper.pickaxe;

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

public class CopperPickaxeListener implements Listener {
  public AltarSMP plugin;

  public HashMap<UUID, Boolean> veinMinerEnabled = new HashMap<>();

  public CopperPickaxeListener(AltarSMP paramAltarSMP) {
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

    var floats = itemMeta.getCustomModelDataComponent().getFloats();

    if (floats.isEmpty())
      return false;

    return floats.getFirst() == 1.0f;
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
      boolean bool = this.veinMinerEnabled.getOrDefault(uUID, true);


      boolean bool1 = !bool;
      this.veinMinerEnabled.put(uUID, bool1);
      player.getWorld().playSound(player.getLocation(), Sound.BLOCK_RESPAWN_ANCHOR_CHARGE, 1.0F, 2.0F);

    } 
  }

  @EventHandler(ignoreCancelled = true)
  public void handleBlockBreak(BlockBreakEvent event) {
    Player player = event.getPlayer();
    if (!isCopperPickaxe(player)) {
      return;
    }
    UUID uuid = player.getUniqueId();

    if (!this.veinMinerEnabled.getOrDefault(uuid, true)) {
      return;
    }

    Block origin = event.getBlock();
    float pitch = player.getLocation().getPitch();
    float yaw = player.getLocation().getYaw();

    if (Math.abs(pitch) >= 45.0F) {
      // Looking up/down: horizontal plane.
      for (int x = -1; x <= 1; x++) {
        for (int z = -1; z <= 1; z++) {
          if (x == 0 && z == 0) continue;

          breakNearbyBlock(origin.getRelative(x, 0, z), player);
        }
      }
    } else {
      // Looking north/south or east/west: vertical plane.
      if (Math.abs(Math.cos(Math.toRadians(yaw))) > Math.abs(Math.sin(Math.toRadians(yaw)))) {

        // North/south facing: X and Y plane.
        for (int x = -1; x <= 1; x++) {
          for (int y = -1; y <= 1; y++) {
            if (x == 0 && y == 0) continue;

            breakNearbyBlock(origin.getRelative(x, y, 0), player);
          }
        }

      } else {
        // East/west facing: Y and Z plane.
        for (int y = -1; y <= 1; y++) {
          for (int z = -1; z <= 1; z++) {
            if (y == 0 && z == 0) continue;

            breakNearbyBlock(origin.getRelative(0, y, z), player);
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

      paramBlock.breakNaturally(paramPlayer.getInventory().getItemInMainHand(), false, true);
      return;
    }

    paramBlock.setType(Material.AIR);
  }

}
