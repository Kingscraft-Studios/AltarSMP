package net.kingscraft.zenixmc.altarsmp.altars2.listener;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.CookingRecipe;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class AmethystToolListener implements Listener {
   private static final int[][] NEIGHBOR_OFFSETS = createNeighborOffsets();
   private static final int MAX_AXE_BLOCKS = 128;
   private static final int MAX_PICKAXE_BLOCKS = 64;
   private static final int BLOCKS_PER_TICK = 2;
   private final Plugin plugin;
   private final Set<UUID> processingPlayers = new HashSet<>();

   public AmethystToolListener(Plugin paramPlugin) {
      this.plugin = paramPlugin;
   }

   @EventHandler(ignoreCancelled = true)
   public void handleBlockBreak(final BlockBreakEvent event) {
      final UUID uuid = event.getPlayer().getUniqueId();
      if (this.processingPlayers.contains(uuid)) {
         return;
      }

      ItemStack tool = event.getPlayer().getInventory().getItemInMainHand();
      final ToolType toolType = getToolType(tool);
      if (toolType == null) {
         return;
      }

      makeToolUnbreakable(tool);
      Block origin = event.getBlock();
      if (!isValidBlock(origin.getType(), toolType)) {
         return;
      }

      event.setCancelled(true);
      event.setDropItems(false);
      boolean smelt = toolType == ToolType.PICKAXE && !hasSilkTouch(tool);
      int limit = toolType == ToolType.AXE ? MAX_AXE_BLOCKS : MAX_PICKAXE_BLOCKS;
      final List<Block> connected = findConnectedBlocks(origin, toolType, limit);
      if (connected.isEmpty()) {
         return;
      }

      this.processingPlayers.add(uuid);
      new BukkitRunnable() {
         private int index;

         @Override
         public void run() {
            try {
               if (event.getPlayer().isOnline() && this.index < connected.size()) {
                  ItemStack current = event.getPlayer().getInventory().getItemInMainHand();
                  for (int i = 0; i < BLOCKS_PER_TICK && this.index < connected.size(); i++) {
                     Block block = connected.get(this.index++);
                     if (isValidBlock(block.getType(), toolType)) {
                        playBreakEffects(block);
                        breakBlockAndDrop(block, current, event.getPlayer().getInventory(), smelt);
                     }
                  }
               } else {
                  finish();
               }
            } catch (RuntimeException e) {
               finish();
               throw e;
            }
         }

         private void finish() {
            processingPlayers.remove(uuid);
            cancel();
         }
      }.runTaskTimer(this.plugin, 0L, 1L);
   }

   private boolean hasSilkTouch(ItemStack itemStack) {
      if (itemStack == null) {
         return false;
      }
      ItemMeta itemMeta = itemStack.getItemMeta();
      return itemMeta != null && itemMeta.hasEnchant(Enchantment.SILK_TOUCH);
   }

   private ToolType getToolType(ItemStack itemStack) {
      if (CustomItemType.AMETHYST_AXE.isItem(itemStack)) {
         return ToolType.AXE;
      }
      return CustomItemType.AMETHYST_PICKAXE.isItem(itemStack) ? ToolType.PICKAXE : null;
   }

   private List<Block> findConnectedBlocks(Block paramBlock, ToolType tooltype, int paramInt) {
      ArrayDeque<Block> queue = new ArrayDeque<>();
      HashSet<String> visited = new HashSet<>();
      ArrayList<Block> result = new ArrayList<>();
      queue.add(paramBlock);
      visited.add(getBlockKey(paramBlock));

      while (!queue.isEmpty() && result.size() < paramInt) {
         Block current = queue.removeFirst();
         if (isValidBlock(current.getType(), tooltype)) {
            result.add(current);
            for (int[] offset : NEIGHBOR_OFFSETS) {
               Block neighbor = current.getRelative(offset[0], offset[1], offset[2]);
               if (visited.add(getBlockKey(neighbor)) && isValidBlock(neighbor.getType(), tooltype)) {
                  queue.addLast(neighbor);
               }
            }
         }
      }

      result.sort(
         Comparator.<Block>comparingInt(block -> getDistanceSquared(paramBlock, block))
            .thenComparingInt(Block::getY)
            .thenComparingInt(Block::getX)
            .thenComparingInt(Block::getZ)
      );
      return result;
   }

   private boolean isValidBlock(Material material, ToolType toolType) {
      return toolType == ToolType.AXE ? isWood(material) : isOre(material);
   }

   private boolean isWood(Material material) {
      String name = material.name().toUpperCase(Locale.ROOT);
      return name.endsWith("_LOG") || name.endsWith("_WOOD") || name.endsWith("_STEM") || name.endsWith("_HYPHAE") || material == Material.MUSHROOM_STEM;
   }

   private boolean isOre(Material material) {
      String name = material.name().toUpperCase(Locale.ROOT);
      return name.endsWith("_ORE") || material == Material.ANCIENT_DEBRIS;
   }

   private void makeToolUnbreakable(ItemStack itemStack) {
      if (itemStack != null && !itemStack.getType().isAir()) {
         ItemMeta itemMeta = itemStack.getItemMeta();
         if (itemMeta != null && !itemMeta.isUnbreakable()) {
            itemMeta.setUnbreakable(true);
            itemStack.setItemMeta(itemMeta);
         }
      }
   }

   private void playBreakEffects(Block block) {
      World world = block.getWorld();
      Location location = block.getLocation().add(0.5, 0.5, 0.5);
      world.spawnParticle(Particle.BLOCK, location, 22, 0.28, 0.28, 0.28, Material.AMETHYST_BLOCK.createBlockData());
      world.playSound(location, Sound.BLOCK_AMETHYST_BLOCK_CHIME, 0.55F, 1.75F);
      world.playSound(location, Sound.BLOCK_AMETHYST_BLOCK_BREAK, 0.35F, 1.55F);
   }

   private void breakBlockAndDrop(Block block, ItemStack itemStack, Inventory itemStacks, boolean smeltItems) {
      Location location = block.getLocation().add(0.5, 0.5, 0.5);
      for (ItemStack drop : block.getDrops(itemStack)) {
         ItemStack item = smeltItems ? smeltDrop(drop) : drop;
         HashMap<Integer, ItemStack> leftover = itemStacks.addItem(item);
         for (ItemStack overflow : leftover.values()) {
            block.getWorld().dropItemNaturally(location, overflow);
         }
      }
      block.setType(Material.AIR, false);
   }

   private ItemStack smeltDrop(ItemStack itemStack) {
      if (itemStack == null || itemStack.getType().isAir()) {
         return itemStack;
      }
      String name = itemStack.getType().name().toUpperCase(Locale.ROOT);
      boolean smeltable = name.endsWith("_ORE") || name.startsWith("RAW_") || itemStack.getType() == Material.ANCIENT_DEBRIS;
      if (!smeltable) {
         return itemStack;
      }
      for (Recipe recipe : Bukkit.getRecipesFor(itemStack)) {
         if (recipe instanceof CookingRecipe<?> cookingRecipe && cookingRecipe.getInputChoice().test(itemStack)) {
            return createSmeltedItem(cookingRecipe, itemStack);
         }
      }
      Iterator<Recipe> iterator = Bukkit.recipeIterator();
      while (iterator.hasNext()) {
         Recipe recipe = iterator.next();
         if (recipe instanceof CookingRecipe<?> cookingRecipe && cookingRecipe.getInputChoice().test(itemStack)) {
            return createSmeltedItem(cookingRecipe, itemStack);
         }
      }
      return itemStack;
   }

   private ItemStack createSmeltedItem(CookingRecipe<?> cookingRecipe, ItemStack itemStack) {
      ItemStack result = cookingRecipe.getResult().clone();
      result.setAmount(Math.max(1, result.getAmount()) * itemStack.getAmount());
      return result;
   }

   private String getBlockKey(Block block) {
      return block.getWorld().getName() + ":" + block.getX() + ":" + block.getY() + ":" + block.getZ();
   }

   private int getDistanceSquared(Block block, Block block1) {
      int dx = block1.getX() - block.getX();
      int dy = block1.getY() - block.getY();
      int dz = block1.getZ() - block.getZ();
      return dx * dx + dy * dy + dz * dz;
   }

   private static int[][] createNeighborOffsets() {
      ArrayList<int[]> offsets = new ArrayList<>();
      for (int y = -1; y <= 1; y++) {
         for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
               if (y != 0 || x != 0 || z != 0) {
                  offsets.add(new int[]{x, y, z});
               }
            }
         }
      }
      offsets.sort(
         Comparator.<int[]>comparingInt(offset -> offset[0] * offset[0] + offset[1] * offset[1] + offset[2] * offset[2])
            .thenComparingInt(offset -> Math.abs(offset[1]))
            .thenComparingInt(offset -> offset[1])
            .thenComparingInt(offset -> offset[0])
            .thenComparingInt(offset -> offset[2])
      );
      return offsets.toArray(int[][]::new);
   }

   private enum ToolType {
      AXE,
      PICKAXE;
   }
}
