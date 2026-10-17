// 
// Decompiled by Procyon v0.6.0
// 

package pl;

public enum DialogType {
    TEXT, 
    NUMBER, 
    BOOL, 
    SINGLE_OPTION, 
    CONFIRMATION, 
    MULTI_ACTION;
    
    private static final DialogType[] ENUM_CONSTANTS;
    
    private static DialogType[] createEnumValues() {
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
