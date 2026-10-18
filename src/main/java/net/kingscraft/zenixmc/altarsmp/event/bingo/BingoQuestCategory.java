// 
// Decompiled by Procyon v0.6.0
// 

package net.kingscraft.zenixmc.altarsmp.event.bingo;

enum BingoQuestCategory {
    COLLECT, 
    KILL;

    public static final BingoQuestCategory[] VALUES;

    public static BingoQuestCategory[] createValuesArray() {
        return new BingoQuestCategory[] {
                BingoQuestCategory.COLLECT,
                BingoQuestCategory.KILL };
    }

    static {
        VALUES = createValuesArray();
    }
}
