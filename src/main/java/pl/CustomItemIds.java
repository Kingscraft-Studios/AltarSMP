package pl;

class CustomItemIds {
  static final int[] ID_BY_ITEM = new int[CustomItem.values().length];
  
  static {
    ID_BY_ITEM[CustomItem.KNIGHTFALL.ordinal()] = 1;
    ID_BY_ITEM[CustomItem.NUKE_REMOTE.ordinal()] = 2;
    ID_BY_ITEM[CustomItem.BLOODLUST.ordinal()] = 3;
    ID_BY_ITEM[CustomItem.BONE_BLADE.ordinal()] = 4;
    ID_BY_ITEM[CustomItem.CUTLASS.ordinal()] = 5;
    ID_BY_ITEM[CustomItem.STRIKER.ordinal()] = 6;
    ID_BY_ITEM[CustomItem.VULCAN_CROSSBOW.ordinal()] = 7;
    ID_BY_ITEM[CustomItem.FROST_SCYTHE.ordinal()] = 8;
    ID_BY_ITEM[CustomItem.EARTH_GAUNTLET.ordinal()] = 9;
    ID_BY_ITEM[CustomItem.ECLIPSE.ordinal()] = 10;
    ID_BY_ITEM[CustomItem.ECHO.ordinal()] = 11;
    ID_BY_ITEM[CustomItem.NIGHTPIERCER.ordinal()] = 12;
    ID_BY_ITEM[CustomItem.HYPERION.ordinal()] = 13;
    ID_BY_ITEM[CustomItem.PALE_CANNON.ordinal()] = 14;
    ID_BY_ITEM[CustomItem.ILLUSION_WAND.ordinal()] = 15;
    ID_BY_ITEM[CustomItem.PALADIN_AXE.ordinal()] = 16;
    ID_BY_ITEM[CustomItem.PURE_BLADE.ordinal()] = 17;
    ID_BY_ITEM[CustomItem.WINDWEAVER.ordinal()] = 18;
    ID_BY_ITEM[CustomItem.WITHERED_BONE_BLADE.ordinal()] = 19;
  } 
}
