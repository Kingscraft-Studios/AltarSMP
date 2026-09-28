// 
// Decompiled by Procyon v0.6.0
// 

package pl;

public enum You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764m
{
    TEXT, 
    NUMBER, 
    BOOL, 
    SINGLE_OPTION, 
    CONFIRMATION, 
    MULTI_ACTION;
    
    private static final You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764m[] You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
    
    private static You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764m[] You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
        return new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764m[] { You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764m.TEXT, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764m.NUMBER, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764m.BOOL, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764m.SINGLE_OPTION, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764m.CONFIRMATION, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764m.MULTI_ACTION };
    }
    
    static {
        final String[] array = new String[6];
        int n = 0;
        String s;
        int n2 = (s = ";\t\n?\r<\u0005\u001c,Rz\u0019 \u001c\u0006\"Qq\f\"\u0019\u001e?W`\u0007,\u0018\u001b$P\u0006!\u0019\u001f)[m").length();
        int n3 = 4;
        int n4 = -1;
    Label_0022:
        while (true) {
            while (true) {
                int n8;
                int n7;
                int n6;
                int n5 = n6 = (n7 = (n8 = 20));
                ++n4;
                final String s2 = s;
                final int beginIndex = n4;
                String s3 = s2.substring(beginIndex, beginIndex + n3);
                int n9 = -1;
                while (true) {
                    final char[] charArray = s3.toCharArray();
                    final int length = charArray.length;
                    int n10 = 0;
                    while (true) {
                        Label_0244: {
                            if (length > 1) {
                                break Label_0244;
                            }
                            n7 = (n6 = n10);
                            do {
                                final char c = charArray[n6];
                                charArray[n7] = (char)(c ^ (n5 ^ switch (n10 % 7) {
                                    case 0 -> 123;
                                    case 1 -> 88;
                                    case 2 -> 70;
                                    case 3 -> 127;
                                    case 4 -> 10;
                                    case 5 -> 43;
                                    default -> 82;
                                }));
                                ++n10;
                            } while (n8 == 0);
                        }
                        if (length > n10) {
                            continue;
                        }
                        break;
                    }
                    final String intern = new String(charArray).intern();
                    switch (n9) {
                        default: {
                            array[n++] = intern;
                            if ((n4 += n3) < n2) {
                                n3 = s.charAt(n4);
                                continue Label_0022;
                            }
                            n2 = (s = "\u000e >\u0004\f\u000f ?\u000etN(\r;8\u0007s").length();
                            n3 = 4;
                            n4 = -1;
                            break;
                        }
                        case 0: {
                            array[n++] = intern;
                            if ((n4 += n3) < n2) {
                                n3 = s.charAt(n4);
                                break;
                            }
                            break Label_0022;
                        }
                    }
                    n5 = (n6 = (n7 = (n8 = 55)));
                    ++n4;
                    final String s4 = s;
                    final int beginIndex2 = n4;
                    s3 = s4.substring(beginIndex2, beginIndex2 + n3);
                    n9 = 0;
                }
            }
            break;
        }
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    }
}
