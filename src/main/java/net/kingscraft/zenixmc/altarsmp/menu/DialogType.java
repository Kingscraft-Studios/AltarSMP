// 
// Decompiled by Procyon v0.6.0
// 

package net.kingscraft.zenixmc.altarsmp.menu;

public enum DialogType {
    TEXT, 
    NUMBER, 
    BOOL, 
    SINGLE_OPTION, 
    CONFIRMATION, 
    MULTI_ACTION;
    
    public static final DialogType[] ENUM_CONSTANTS;
    
    public static DialogType[] createEnumValues() {
        return new DialogType[] {
                DialogType.TEXT,
                DialogType.NUMBER,
                DialogType.BOOL,
                DialogType.SINGLE_OPTION,
                DialogType.CONFIRMATION,
                DialogType.MULTI_ACTION
        };
    }
    
    static {
        ENUM_CONSTANTS = createEnumValues();
    }
}
