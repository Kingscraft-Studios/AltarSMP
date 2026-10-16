// 
// Decompiled by Procyon v0.6.0
// 

package pl;

import org.bukkit.entity.Player;
import org.bukkit.Material;

enum BingoQuestType {
    AMETHYST(Material.AMETHYST_SHARD, "Amethyst Collector", "Gather 24 amethyst shards from geodes.", BingoQuestCategory.COLLECT, Material.AMETHYST_SHARD, 24),
    SLAYER(Material.IRON_SWORD, "Slayer", "Kill a non teammate player.", BingoQuestCategory.KILL, (Material)null, 1),
    COPPER(Material.WAXED_CUT_COPPER_STAIRS, "Copper Enthusiast", "Craft or collect 32 Waxed Cut Copper Stairs.", BingoQuestCategory.COLLECT, Material.WAXED_CUT_COPPER_STAIRS, 32),
    OBSIDIAN(Material.OBSIDIAN, "Obsidian Hoarder", "Collect 32 obsidian.", BingoQuestCategory.COLLECT, Material.OBSIDIAN, 32),
    SEA(Material.HEART_OF_THE_SEA, "Sea Explorer", "Find 1 Heart of the Sea.", BingoQuestCategory.COLLECT, Material.HEART_OF_THE_SEA, 1),
    BERRIES(Material.GLOW_BERRIES, "Glow Berry Hunter", "Collect 48 glow berries.", BingoQuestCategory.COLLECT, Material.GLOW_BERRIES, 48),
    TUFF(Material.TUFF, "Tuff Miner", "Collect 96 tuff.", BingoQuestCategory.COLLECT, Material.TUFF, 96),
    SCULK(Material.SCULK, "Sculk Collector", "Collect 48 sculk blocks.", BingoQuestCategory.COLLECT, Material.SCULK, 48),
    SADDLE(Material.SADDLE, "Saddle Finder", "Find 1 saddle.", BingoQuestCategory.COLLECT, Material.SADDLE, 1),
    MUD(Material.MUD_BRICKS, "Mud Brick Maker", "Collect 48 mud bricks.", BingoQuestCategory.COLLECT, Material.MUD_BRICKS, 48),
    WHEAT(Material.WHEAT, "Farmer", "Collect 64 wheat.", BingoQuestCategory.COLLECT, Material.WHEAT, 64),
    NAMETAG(Material.NAME_TAG, "Name Tag Hunter", "Find 2 name tags.", BingoQuestCategory.COLLECT, Material.NAME_TAG, 2),
    DIAMOND(Material.DIAMOND, "Diamond Finder", "Find 8 diamonds.", BingoQuestCategory.COLLECT, Material.DIAMOND, 8),
    PRISMARINE(Material.PRISMARINE, "Prismarine Collector", "Collect 48 prismarine blocks.", BingoQuestCategory.COLLECT, Material.PRISMARINE, 48),
    TOTEM(Material.TOTEM_OF_UNDYING, "Totem Saver", "Obtain 1 Totem of Undying.", BingoQuestCategory.COLLECT, Material.TOTEM_OF_UNDYING, 1),
    BLACKSTONE(Material.BLACKSTONE, "Blackstone Miner", "Collect 64 blackstone.", BingoQuestCategory.COLLECT, Material.BLACKSTONE, 64),
    COAL(Material.COAL_BLOCK, "Coal Block Crafter", "Craft or collect 4 coal blocks.", BingoQuestCategory.COLLECT, Material.COAL_BLOCK, 4),
    NAUTILUS(Material.NAUTILUS_SHELL, "Nautilus Hunter", "Find 4 nautilus shells.", BingoQuestCategory.COLLECT, Material.NAUTILUS_SHELL, 4),
    DISC(Material.MUSIC_DISC_CAT, "Disc Lover", "Find 2 music discs.", BingoQuestCategory.COLLECT, (Material)null, 2, BingoQuestType::lambda$static$0),
    MOSS(Material.MOSS_BLOCK, "Moss Collector", "Collect 48 moss blocks.", BingoQuestCategory.COLLECT, Material.MOSS_BLOCK, 48),
    HONEY(Material.HONEY_BLOCK, "Honey Worker", "Obtain 4 honey blocks.", BingoQuestCategory.COLLECT, Material.HONEY_BLOCK, 4),
    PURPUR(Material.PURPUR_BLOCK, "Purpur Builder", "Collect 32 purpur blocks.", BingoQuestCategory.COLLECT, Material.PURPUR_BLOCK, 32),
    CACTUS(Material.CACTUS, "Cactus Farmer", "Collect 48 cactus.", BingoQuestCategory.COLLECT, Material.CACTUS, 48),
    FLOWER(Material.OXEYE_DAISY, "Flower Picker", "Pick 8 Oxeye Daisies.", BingoQuestCategory.COLLECT, Material.OXEYE_DAISY, 8),
    PORK(Material.PORKCHOP, "Pork Supplier", "Collect 32 porkchops.", BingoQuestCategory.COLLECT, Material.PORKCHOP, 32),
    DIORITE(Material.DIORITE, "Diorite Miner", "Collect 64 diorite.", BingoQuestCategory.COLLECT, Material.DIORITE, 64),
    SHARD(Material.PRISMARINE_SHARD, "Shard Collector", "Collect 24 prismarine shards.", BingoQuestCategory.COLLECT, Material.PRISMARINE_SHARD, 24),
    SAND(Material.SAND, "Sand Collector", "Collect 96 sand.", BingoQuestCategory.COLLECT, Material.SAND, 96),
    SHRIEKER(Material.SCULK_SHRIEKER, "Shrieker Seeker", "Obtain 1 sculk shrieker.", BingoQuestCategory.COLLECT, Material.SCULK_SHRIEKER, 1),
    CLAY(Material.CLAY_BALL, "Clay Finder", "Collect 64 clay balls.", BingoQuestCategory.COLLECT, Material.CLAY_BALL, 64),
    SLIME(Material.SLIME_BALL, "Slime Hunter", "Collect 24 slime balls.", BingoQuestCategory.COLLECT, Material.SLIME_BALL, 24),
    WART(Material.NETHER_WART_BLOCK, "Nether Wart Builder", "Obtain 8 Nether Wart Blocks.", BingoQuestCategory.COLLECT, Material.NETHER_WART_BLOCK, 8),
    LEATHER(Material.LEATHER, "Leather Worker", "Collect 48 leather.", BingoQuestCategory.COLLECT, Material.LEATHER, 48),
    CORAL(Material.TUBE_CORAL_BLOCK, "Coral Collector", "Obtain 4 Tube Coral Blocks.", BingoQuestCategory.COLLECT, Material.TUBE_CORAL_BLOCK, 4),
    SANDSTONE(Material.SANDSTONE, "Sandstone Builder", "Collect 64 sandstone.", BingoQuestCategory.COLLECT, Material.SANDSTONE, 64),
    SNOW(Material.SNOWBALL, "Snowballer", "Collect 64 snowballs.", BingoQuestCategory.COLLECT, Material.SNOWBALL, 64),
    SLIMEBLOCK(Material.SLIME_BLOCK, "Slime Block Crafter", "Craft or collect 4 slime blocks.", BingoQuestCategory.COLLECT, Material.SLIME_BLOCK, 4),
    COCOA(Material.COCOA_BEANS, "Cocoa Collector", "Collect 32 cocoa beans.", BingoQuestCategory.COLLECT, Material.COCOA_BEANS, 32),
    AXOLOTL(Material.AXOLOTL_BUCKET, "Axolotl Friend", "Catch 1 axolotl in a bucket.", BingoQuestCategory.COLLECT, Material.AXOLOTL_BUCKET, 1),
    WITHER(Material.WITHER_ROSE, "Wither Gardener", "Obtain 2 wither roses.", BingoQuestCategory.COLLECT, Material.WITHER_ROSE, 2);
    
    final Material displayMaterial;
    final String displayName;
    final String description;
    final BingoQuestCategory questType;
    final Material targetMaterial;
    final int requiredAmount;
    final BingoQuestCompletionCondition completionCondition;
    private static final BingoQuestType[] VALUES;
    
    private BingoQuestType(final Material displayMaterial, final String displayName, final String description,
                           final BingoQuestCategory questType, final Material targetMaterial, final int amount) {
        this(displayMaterial, displayName, description, questType, targetMaterial, amount, null);
    }
    
    private BingoQuestType(final Material displayMaterial, final String displayName, final String description,
                           final BingoQuestCategory questType, final Material targetMaterial, final int amount,
                           final BingoQuestCompletionCondition completionCondition) {
        this.displayMaterial = displayMaterial;
        this.displayName = displayName;
        this.description = description;
        this.questType = questType;
        this.targetMaterial = targetMaterial;
        this.requiredAmount = amount;
        this.completionCondition = completionCondition;
    }
    
    private static boolean lambda$static$0(final Player player, final BingoQuestType bingoQuestType) {
        if (BingoEventManager.countMusicDiscs(player) >= bingoQuestType.requiredAmount) {
            return true;
        }
        return false;
    }
    
    private static BingoQuestType[] createValuesArray() {
        return new BingoQuestType[]
                {
                        BingoQuestType.AMETHYST,
                        BingoQuestType.SLAYER,
                        BingoQuestType.COPPER,
                        BingoQuestType.OBSIDIAN,
                        BingoQuestType.SEA,
                        BingoQuestType.BERRIES,
                        BingoQuestType.TUFF,
                        BingoQuestType.SCULK,
                        BingoQuestType.SADDLE,
                        BingoQuestType.MUD,
                        BingoQuestType.WHEAT,
                        BingoQuestType.NAMETAG,
                        BingoQuestType.DIAMOND,
                        BingoQuestType.PRISMARINE,
                        BingoQuestType.TOTEM,
                        BingoQuestType.BLACKSTONE,
                        BingoQuestType.COAL,
                        BingoQuestType.NAUTILUS,
                        BingoQuestType.DISC,
                        BingoQuestType.MOSS,
                        BingoQuestType.HONEY,
                        BingoQuestType.PURPUR,
                        BingoQuestType.CACTUS,
                        BingoQuestType.FLOWER,
                        BingoQuestType.PORK,
                        BingoQuestType.DIORITE,
                        BingoQuestType.SHARD,
                        BingoQuestType.SAND,
                        BingoQuestType.SHRIEKER,
                        BingoQuestType.CLAY,
                        BingoQuestType.SLIME,
                        BingoQuestType.WART,
                        BingoQuestType.LEATHER,
                        BingoQuestType.CORAL,
                        BingoQuestType.SANDSTONE,
                        BingoQuestType.SNOW,
                        BingoQuestType.SLIMEBLOCK,
                        BingoQuestType.COCOA,
                        BingoQuestType.AXOLOTL,
                        BingoQuestType.WITHER
                };
    }
    
    static {
        VALUES = createValuesArray();
    }
}
