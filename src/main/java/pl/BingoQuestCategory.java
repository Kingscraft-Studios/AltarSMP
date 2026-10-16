// 
// Decompiled by Procyon v0.6.0
// 

package pl;

enum BingoQuestCategory {
    COLLECT, 
    KILL;
    
    private static final BingoQuestCategory[] VALUES;
    
    private static BingoQuestCategory[] createValuesArray() {
        return new BingoQuestCategory[] {
                BingoQuestCategory.COLLECT,
                BingoQuestCategory.KILL };
    }
    
    static {
        VALUES = createValuesArray();
    }
}
