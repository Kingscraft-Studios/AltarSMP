// 
// 

package net.kingscraft.zenixmc.altarsmp.item;

import org.bukkit.inventory.ItemStack;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public enum CustomItemType {
    WARDEN_HEART() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.WARDEN_HEART_ITEM;
        }
    },
    WEAPON_HANDLE() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.WEAPON_HANDLE_ITEM;
        }
    },
    VULCAN_SKULL() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.VULCAN_SKULL_ITEM;
        }
    },
    ILLUSION_CORE() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.ILLUSION_CORE_ITEM;
        }
    },
    HYPERION_SHARD() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.HYPERION_SHARD_ITEM;
        }
    },
    VAMPIRE_SHARD() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.VAMPIRE_SHARD_ITEM;
        }
    },
    PALE_SHARD() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.PALE_SHARD_ITEM;
        }
    },
    CHESTPLATE_SHARD() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.CHESTPLATE_SHARD_ITEM;
        }
    },
    HELMET_SHARD() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.HELMET_SHARD_ITEM;
        }
    },
    CONTAGION() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.CONTAGION_ITEM;
        }
    },
    DRAGON_HEART() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.DRAGON_HEART_ITEM;
        }
    },
    SOUL_IN_A_BOTTLE() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.SOUL_IN_A_BOTTLE_ITEM;
        }
    },
    FRAGMENT_OF_THE_SEA() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.FRAGMENT_OF_THE_SEA_ITEM;
        }
    },
    NETHERITE_HARNESS() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.NETHERITE_HARNESS_ITEM;
        }
    },
    AMETHYST_AXE() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.AMETHYST_AXE_ITEM;
        }
    },
    AMETHYST_PICKAXE() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.AMETHYST_PICKAXE_ITEM;
        }
    },
    VOID_CLOCK() {
        @Override
        public ItemStack getItem() {
            return CustomItemType.VOID_CLOCK_ITEM;
        }
    };

    public static final ItemStack VULCAN_SKULL_ITEM;
    public static final ItemStack WARDEN_HEART_ITEM;
    public static final ItemStack WEAPON_HANDLE_ITEM;
    public static final ItemStack ILLUSION_CORE_ITEM;
    public static final ItemStack HYPERION_SHARD_ITEM;
    public static final ItemStack VAMPIRE_SHARD_ITEM;
    public static final ItemStack PALE_SHARD_ITEM;
    public static final ItemStack CHESTPLATE_SHARD_ITEM;
    public static final ItemStack HELMET_SHARD_ITEM;
    public static final ItemStack CONTAGION_ITEM;
    public static final ItemStack DRAGON_HEART_ITEM;
    public static final ItemStack SOUL_IN_A_BOTTLE_ITEM;
    public static final ItemStack FRAGMENT_OF_THE_SEA_ITEM;
    public static final ItemStack NETHERITE_HARNESS_ITEM;
    public static final ItemStack AMETHYST_AXE_ITEM;
    public static final ItemStack AMETHYST_PICKAXE_ITEM;
    public static final ItemStack VOID_CLOCK_ITEM;
    public static final CustomItemType[] VALUES_CACHE;

    public abstract ItemStack getItem();

    public boolean isItem(final ItemStack itemStack) {
        return AltarSMP.areSimilar(this.getItem(), itemStack);
    }

    public static CustomItemType fromItem(final ItemStack itemStack) {
        for (final CustomItemType v : values()) {
            if (v.isItem(itemStack)) {
                return v;
            }
        }
        return null;
    }

    static {
        VALUES_CACHE = values();
        VULCAN_SKULL_ITEM = CustomItemRegistry.getVulcanSkull();
        WARDEN_HEART_ITEM = CustomItemRegistry.getWardenHeart();
        WEAPON_HANDLE_ITEM = CustomItemRegistry.getWeaponHandle();
        ILLUSION_CORE_ITEM = CustomItemRegistry.getIllusionCore();
        HYPERION_SHARD_ITEM = CustomItemRegistry.getHyperionShard();
        VAMPIRE_SHARD_ITEM = CustomItemRegistry.getVampireShard();
        PALE_SHARD_ITEM = CustomItemRegistry.getPaleShard();
        CHESTPLATE_SHARD_ITEM = CustomItemRegistry.getChestplateShard();
        HELMET_SHARD_ITEM = CustomItemRegistry.getHelmetShard();
        CONTAGION_ITEM = CustomItemRegistry.getContagionSignal();
        DRAGON_HEART_ITEM = CustomItemRegistry.getDragonHeart();
        SOUL_IN_A_BOTTLE_ITEM = CustomItemRegistry.getSoulInABottle();
        FRAGMENT_OF_THE_SEA_ITEM = CustomItemRegistry.getFragmentOfTheSea();
        NETHERITE_HARNESS_ITEM = CustomItemRegistry.getNetheriteHarness();
        AMETHYST_AXE_ITEM = CustomItemRegistry.getAmethystAxe();
        AMETHYST_PICKAXE_ITEM = CustomItemRegistry.getAmethystPickaxe();
        VOID_CLOCK_ITEM = CustomItemRegistry.getVoidClock();
    }
}
