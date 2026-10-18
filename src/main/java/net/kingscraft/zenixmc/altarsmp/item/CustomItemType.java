// 
// Decompiled by Procyon v0.6.0
// 

package net.kingscraft.zenixmc.altarsmp.item;

import org.bukkit.inventory.ItemStack;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public enum CustomItemType {
    WARDEN_HEART("WARDEN_HEART", 0) {
        @Override
        public ItemStack getItem() {
            return CustomItemType.WARDEN_HEART_ITEM;
        }
    },
    WEAPON_HANDLE("WEAPON_HANDLE", 1) {
        @Override
        public ItemStack getItem() {
            return CustomItemType.WEAPON_HANDLE_ITEM;
        }
    },
    VULCAN_SKULL("VULCAN_SKULL", 2) {
        @Override
        public ItemStack getItem() {
            return CustomItemType.VULCAN_SKULL_ITEM;
        }
    },
    ILLUSION_CORE("ILLUSION_CORE", 3) {
        @Override
        public ItemStack getItem() {
            return CustomItemType.ILLUSION_CORE_ITEM;
        }
    },
    HYPERION_SHARD("HYPERION_SHARD", 4) {
        @Override
        public ItemStack getItem() {
            return CustomItemType.HYPERION_SHARD_ITEM;
        }
    },
    VAMPIRE_SHARD("VAMPIRE_SHARD", 5) {
        @Override
        public ItemStack getItem() {
            return CustomItemType.VAMPIRE_SHARD_ITEM;
        }
    },
    PALE_SHARD("PALE_SHARD", 6) {
        @Override
        public ItemStack getItem() {
            return CustomItemType.PALE_SHARD_ITEM;
        }
    },
    CHESTPLATE_SHARD("CHESTPLATE_SHARD", 7) {
        @Override
        public ItemStack getItem() {
            return CustomItemType.CHESTPLATE_SHARD_ITEM;
        }
    },
    HELMET_SHARD("HELMET_SHARD", 8) {
        @Override
        public ItemStack getItem() {
            return CustomItemType.HELMET_SHARD_ITEM;
        }
    },
    CONTAGION("CONTAGION", 9) {
        @Override
        public ItemStack getItem() {
            return CustomItemType.CONTAGION_ITEM;
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
    public static final CustomItemType[] VALUES_CACHE;

    public abstract ItemStack getItem();

    private CustomItemType(final String name, final int ordinal) {
    }

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
    }
}
