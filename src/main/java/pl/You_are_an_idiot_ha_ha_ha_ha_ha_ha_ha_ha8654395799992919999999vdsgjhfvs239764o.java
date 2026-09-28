// 
// Decompiled by Procyon v0.6.0
// 

package pl;

enum You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764o
{
    COLLECT, 
    KILL;
    
    private static final You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764o[] You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
    
    private static You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764o[] You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
        return new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764o[] { You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764o.COLLECT, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764o.KILL };
    }
    
    static {
        final String[] array = new String[2];
        int n = 0;
        final String s;
        final int length = (s = ",5I:\u0007$3I:\u001d\u001bi").length();
        int char1 = 4;
        int index = -1;
        Label_0021: {
            break Label_0021;
            do {
                char1 = s.charAt(index);
                int n4;
                int n3;
                final int n2 = n3 = (n4 = 94);
                ++index;
                final String s2 = s;
                final int beginIndex = index;
                final char[] charArray = s2.substring(beginIndex, beginIndex + char1).toCharArray();
                final int length2 = charArray.length;
                int n5 = 0;
                while (true) {
                    Label_0188: {
                        if (length2 > 1) {
                            break Label_0188;
                        }
                        n4 = (n3 = n5);
                        do {
                            final char c = charArray[n3];
                            charArray[n4] = (char)(c ^ (n2 ^ switch (n5 % 7) {
                                case 0 -> 57;
                                case 1 -> 34;
                                case 2 -> 91;
                                case 3 -> 40;
                                case 4 -> 6;
                                case 5 -> 6;
                                default -> 99;
                            }));
                            ++n5;
                        } while (n2 == 0);
                    }
                    if (length2 > n5) {
                        continue;
                    }
                    break;
                }
                array[n++] = new String(charArray).intern();
            } while ((index += char1) < length);
        }
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    }
}
