package net.kingscraft.zenixmc.altarsmp.altarS2.weapon.amethyst;

import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemType;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.advancement.Advancement;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.CookingRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class AmethystToolListener implements Listener {
   private static final int[][] NEIGHBOR_OFFSETS = createNeighborOffsets();
   private static final int MAX_AXE_BLOCKS = 128;
   private static final int MAX_PICKAXE_BLOCKS = 128;
   private static final int BLOCKS_PER_TICK = 2;
   private static final int PIGLIN_ANGER_RANGE = 16;
   private static final Map<Material, int[]> ORE_XP = createOreXp();
   private static final Set<Material> PIGLIN_GUARDED_ORES = Set.of(Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE, Material.NETHER_GOLD_ORE);

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
      final boolean silkTouch = hasSilkTouch(tool);
      final boolean smelt = toolType == ToolType.PICKAXE && !silkTouch;
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
                        breakBlockAndDrop(block, event.getPlayer(), current, smelt, silkTouch);
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

   private void breakBlockAndDrop(Block block, Player player, ItemStack tool, boolean smeltItems, boolean silkTouch) {
      Material material = block.getType();
      Location location = block.getLocation().add(0.5, 0.5, 0.5);
      if (silkTouch && material == Material.NETHER_GOLD_ORE) {
         // Silk Touch normally returns the ore block, but Nether Gold Ore is a special case:
         // it always gives one gold ingot per block instead.
         addDrop(block, player, location, new ItemStack(Material.GOLD_INGOT));
      } else {
         for (ItemStack drop : block.getDrops(tool)) {
            ItemStack item = smeltItems ? smeltDrop(drop) : drop;
            addDrop(block, player, location, item);
         }
      }

      awardOreExperience(player, material);
      player.incrementStatistic(Statistic.MINE_BLOCK, material);
      // inventory_changed advancements (diamond, iron ingot, etc.) fire from the normal
      // inventory update on the next server tick. Ancient debris is awarded explicitly
      // because auto-smelting turns it into netherite scrap before it reaches the inventory.
      if (material == Material.ANCIENT_DEBRIS) {
         awardAdvancement(player, "nether/obtain_ancient_debris", "ancient_debris");
      }
      if (PIGLIN_GUARDED_ORES.contains(material)) {
         angerNearbyPiglins(player);
      }
      block.setType(Material.AIR, false);
   }

   private void awardAdvancement(Player player, String key, String criterion) {
      Advancement advancement = Bukkit.getAdvancement(NamespacedKey.minecraft(key));
      if (advancement != null) {
         player.getAdvancementProgress(advancement).awardCriteria(criterion);
      }
   }

   private void addDrop(Block block, Player player, Location location, ItemStack item) {
      HashMap<Integer, ItemStack> leftover = player.getInventory().addItem(item);
      for (ItemStack overflow : leftover.values()) {
         block.getWorld().dropItemNaturally(location, overflow);
      }
   }

   private void awardOreExperience(Player player, Material material) {
      if (player.getGameMode() == GameMode.CREATIVE) {
         return;
      }
      int[] range = ORE_XP.get(material);
      if (range == null || range[1] <= 0) {
         return;
      }
      int amount = range[0] == range[1]
         ? range[0]
         : ThreadLocalRandom.current().nextInt(range[0], range[1] + 1);
      if (amount > 0) {
         player.giveExp(amount, true);
      }
   }

   private void angerNearbyPiglins(Player player) {
      try {
         Object serverPlayer = player.getClass().getMethod("getHandle").invoke(player);
         Object serverLevel = player.getWorld().getClass().getMethod("getHandle").invoke(player.getWorld());
         Class<?> piglinAi = Class.forName("net.minecraft.world.entity.monster.piglin.PiglinAi");
         for (Method method : piglinAi.getMethods()) {
            if (method.getName().equals("angerNearbyPiglins") && method.getParameterCount() == 3) {
               method.invoke(null, serverLevel, serverPlayer, false);
               return;
            }
         }
      } catch (ReflectiveOperationException | RuntimeException exception) {
         exception.printStackTrace();
      }

      for (Entity entity : player.getWorld().getNearbyEntities(player.getLocation(), PIGLIN_ANGER_RANGE, PIGLIN_ANGER_RANGE, PIGLIN_ANGER_RANGE)) {
         if (entity instanceof Piglin piglin && piglin.isAdult() && piglin.getTarget() == null) {
            piglin.setTarget(player);
         }
      }
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

   private static Map<Material, int[]> createOreXp() {
      Map<Material, int[]> xp = new EnumMap<>(Material.class);
      xp.put(Material.COAL_ORE, new int[]{0, 2});
      xp.put(Material.DEEPSLATE_COAL_ORE, new int[]{0, 2});
      xp.put(Material.COPPER_ORE, new int[]{0, 0});
      xp.put(Material.DEEPSLATE_COPPER_ORE, new int[]{0, 0});
      xp.put(Material.DIAMOND_ORE, new int[]{3, 7});
      xp.put(Material.DEEPSLATE_DIAMOND_ORE, new int[]{3, 7});
      xp.put(Material.EMERALD_ORE, new int[]{3, 7});
      xp.put(Material.DEEPSLATE_EMERALD_ORE, new int[]{3, 7});
      xp.put(Material.LAPIS_ORE, new int[]{2, 5});
      xp.put(Material.DEEPSLATE_LAPIS_ORE, new int[]{2, 5});
      xp.put(Material.REDSTONE_ORE, new int[]{1, 5});
      xp.put(Material.DEEPSLATE_REDSTONE_ORE, new int[]{1, 5});
      xp.put(Material.IRON_ORE, new int[]{0, 0});
      xp.put(Material.DEEPSLATE_IRON_ORE, new int[]{0, 0});
      xp.put(Material.GOLD_ORE, new int[]{0, 0});
      xp.put(Material.DEEPSLATE_GOLD_ORE, new int[]{0, 0});
      xp.put(Material.NETHER_GOLD_ORE, new int[]{0, 1});
      xp.put(Material.NETHER_QUARTZ_ORE, new int[]{2, 5});
      xp.put(Material.ANCIENT_DEBRIS, new int[]{0, 0});
      return xp;
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
      PICKAXE
   }
}
