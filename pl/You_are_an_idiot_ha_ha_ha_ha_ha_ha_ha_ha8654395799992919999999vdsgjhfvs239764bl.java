// 
// Decompiled by Procyon v0.6.0
// 

package pl;

import java.lang.invoke.CallSite;
import java.util.UUID;
import pl.Main;
import pl.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x;
import org.bukkit.entity.Warden;
import java.util.Random;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.Listener;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bl implements Listener
{
    public Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
    private static final String[] a;
    private static final String[] b;
    
    public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bl(final Main you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(final PlayerDeathEvent playerDeathEvent) {
        final Player entity = playerDeathEvent.getEntity();
        
        if (Bukkit.getPluginManager().getPlugin(a(-7722, 19081)) != null) {
            return;
        }
    
        try {
            if (playerDeathEvent.isCancelled()) {
                return;
            }
     
        if (playerDeathEvent.isCancelled()) {
            return;
        }
        return;
        }
    
        final Player killer = playerDeathEvent.getEntity().getKiller();
        if (killer instanceof Player) {
            final Player player = killer;
            final World world = entity.getWorld();
            final Location location = entity.getLocation();
            final ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)itemStack.getItemMeta();
            itemMeta.setOwningPlayer(Bukkit.getOfflinePlayer(entity.getUniqueId()));
            itemMeta.setDisplayName(String.valueOf(ChatColor.RESET) + entity.getName() + a(-7724, 31423));
            final ArrayList lore = new ArrayList();
            final String value = String.valueOf(ChatColor.GOLD);
            final String value2 = String.valueOf(ChatColor.YELLOW);
            final String name = player.getName();
            final String s = value2;
            
            lore.add(value + a(-7728, 28187) + s + name);
            itemMeta.setLore((List)lore);
            itemStack.setItemMeta((ItemMeta)itemMeta);
            if (Main.getInstance().getConfig().getBoolean(a(-7725, 29376), true)) {
                player.getInventory().addItem(new ItemStack[] { itemStack });
                return;
            }
        
            world.dropItemNaturally(location, itemStack);
        }
    }
    
    @EventHandler
    public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(final EntityDeathEvent entityDeathEvent) {
        
        if (entityDeathEvent.isCancelled()) {
            return;
        }
    
        
        if (Bukkit.getPluginManager().getPlugin(a(-7721, 893)) != null) {
            return;
        }
    
        final int i
        if
        if (entityDeathEvent.isCancelled()) {
            return;
        }
        return;
            }
            final Random random2 = random;
            final int n = 100;
            final int n2 = random2.nextInt(n);
            final int n3 = int1;
            if (n2 <= n3) {
                break Label_0094;
            }
            return;
        
            
            final Random random2 = random;
            final int n = 100;
            final int n2 = random2.nextInt(n);
            final int n3 = int1;
            if (n2 <= n3) {
                entityDeathEvent.getDrops().add(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764t());
            }
        
        }
    }
    
    private static MatchException a(final MatchException ex) {
        return ex;
    }
    
    static {
        final String[] a2 = new String[7];
        int n = 0;
        String s;
        int n2 = (s = """
                      \u00d6Nª\u00dbm\u00ca\u00e1\u0007d³\u00fcd§=¸\u0007\r\u00e0/\u00db\u0014\u00f4m
                      \u001b\u00d7\u0089$\=\u0018¿\u00e6¤\u0015\u00ad\u0019\u0017\u0098\u000b:¢\u009d<e,d¢m\u0004$\u00fb\\u00c4
                      \u001c""").length();
        int n3 = 7;
        int n4 = -1;
    Label_0023:
        while (true) {
            while (true) {
                int n8;
                int n7;
                int n6;
                int n5 = n6 = (n7 = (n8 = 2));
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
                        Label_0260: {
                            if (length > 1) {
                                break Label_0260;
                            }
                            n7 = (n6 = n10);
                            do {
                                final char c = charArray[n6];
                                charArray[n7] = (char)(c ^ (n5 ^ switch (n10 % 7) {
                                    case 0 -> 19;
                                    case 1 -> 103;
                                    case 2 -> 77;
                                    case 3 -> 60;
                                    case 4 -> 91;
                                    case 5 -> 106;
                                    default -> 107;
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
                            a2[n++] = intern;
                            if ((n4 += n3) < n2) {
                                n3 = s.charAt(n4);
                                continue Label_0023;
                            }
                            n2 = (s = "E\u008d\u00e0\u00da\u0093\u0081.s\u0019)rW¯\u00f0\u00e0\u008a\u0004\tt\u008d±\u009c{L\reE\n\u008aqªL¹{D!E\u009f").length();
                            n3 = 27;
                            n4 = -1;
                            break;
                        }
                        case 0: {
                            a2[n++] = intern;
                            if ((n4 += n3) < n2) {
                                n3 = s.charAt(n4);
                                break;
                            }
                            break Label_0023;
                        }
                    }
                    n5 = (n6 = (n7 = (n8 = 61)));
                    ++n4;
                    final String s4 = s;
                    final int beginIndex2 = n4;
                    s3 = s4.substring(beginIndex2, beginIndex2 + n3);
                    n9 = 0;
                }
            }
            break;
        }
        a = a2;
        b = new String[7];
    }
    
    private static String a(final int n, final int n2) {
        final int n3 = (n ^ 0xFFFFE1D6) & 0xFFFF;
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bl.b[n3] == null) {
            final char[] charArray = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bl.a[n3].toCharArray();
            final int n5 = switch (charArray[0] & '\u00ff') {
                case 0 -> 67;
                case 1 -> 197;
                case 2 -> 207;
                case 3 -> 186;
                case 4 -> 54;
                case 5 -> 243;
                case 6 -> 126;
                case 7 -> 107;
                case 8 -> 145;
                case 9 -> 235;
                case 10 -> 162;
                case 11 -> 242;
                case 12 -> 125;
                case 13 -> 21;
                case 14 -> 16;
                case 15 -> 38;
                case 16 -> 47;
                case 17 -> 131;
                case 18 -> 168;
                case 19 -> 136;
                case 20 -> 147;
                case 21 -> 80;
                case 22 -> 9;
                case 23 -> 205;
                case 24 -> 164;
                case 25 -> 251;
                case 26 -> 166;
                case 27 -> 108;
                case 28 -> 132;
                case 29 -> 189;
                case 30 -> 137;
                case 31 -> 227;
                case 32 -> 20;
                case 33 -> 69;
                case 34 -> 149;
                case 35 -> 15;
                case 36 -> 85;
                case 37 -> 61;
                case 38 -> 8;
                case 39 -> 195;
                case 40 -> 113;
                case 41 -> 151;
                case 42 -> 144;
                case 43 -> 156;
                case 44 -> 22;
                case 45 -> 49;
                case 46 -> 96;
                case 47 -> 191;
                case 48 -> 254;
                case 49 -> 213;
                case 50 -> 177;
                case 51 -> 101;
                case 52 -> 57;
                case 53 -> 123;
                case 54 -> 204;
                case 55 -> 24;
                case 56 -> 90;
                case 57 -> 127;
                case 58 -> 111;
                case 59 -> 92;
                case 60 -> 234;
                case 61 -> 52;
                case 62 -> 210;
                case 63 -> 154;
                case 64 -> 155;
                case 65 -> 13;
                case 66 -> 169;
                case 67 -> 82;
                case 68 -> 34;
                case 69 -> 121;
                case 70 -> 77;
                case 71 -> 35;
                case 72 -> 103;
                case 73 -> 74;
                case 74 -> 158;
                case 75 -> 244;
                case 76 -> 163;
                case 77 -> 135;
                case 78 -> 32;
                case 79 -> 104;
                case 80 -> 218;
                case 81 -> 45;
                case 82 -> 59;
                case 83 -> 112;
                case 84 -> 226;
                case 85 -> 173;
                case 86 -> 102;
                case 87 -> 236;
                case 88 -> 146;
                case 89 -> 110;
                case 90 -> 239;
                case 91 -> 72;
                case 92 -> 11;
                case 93 -> 211;
                case 94 -> 100;
                case 95 -> 212;
                case 96 -> 17;
                case 97 -> 33;
                case 98 -> 1;
                case 99 -> 142;
                case 100 -> 56;
                case 101 -> 214;
                case 102 -> 124;
                case 103 -> 238;
                case 104 -> 109;
                case 105 -> 115;
                case 106 -> 250;
                case 107 -> 180;
                case 108 -> 190;
                case 109 -> 93;
                case 110 -> 42;
                case 111 -> 240;
                case 112 -> 220;
                case 113 -> 10;
                case 114 -> 40;
                case 115 -> 130;
                case 116 -> 2;
                case 117 -> 73;
                case 118 -> 247;
                case 119 -> 128;
                case 120 -> 28;
                case 121 -> 53;
                case 122 -> 153;
                case 123 -> 51;
                case 124 -> 41;
                case 125 -> 134;
                case 126 -> 187;
                case 127 -> 143;
                case 128 -> 231;
                case 129 -> 237;
                case 130 -> 222;
                case 131 -> 216;
                case 132 -> 84;
                case 133 -> 39;
                case 134 -> 133;
                case 135 -> 122;
                case 136 -> 129;
                case 137 -> 31;
                case 138 -> 37;
                case 139 -> 201;
                case 140 -> 87;
                case 141 -> 167;
                case 142 -> 176;
                case 143 -> 199;
                case 144 -> 36;
                case 145 -> 105;
                case 146 -> 157;
                case 147 -> 86;
                case 148 -> 94;
                case 149 -> 12;
                case 150 -> 245;
                case 151 -> 188;
                case 152 -> 255;
                case 153 -> 83;
                case 154 -> 219;
                case 155 -> 27;
                case 156 -> 97;
                case 157 -> 140;
                case 158 -> 209;
                case 159 -> 60;
                case 160 -> 171;
                case 161 -> 224;
                case 162 -> 181;
                case 163 -> 141;
                case 164 -> 44;
                case 165 -> 14;
                case 166 -> 18;
                case 167 -> 221;
                case 168 -> 64;
                case 169 -> 119;
                case 170 -> 179;
                case 171 -> 75;
                case 172 -> 0;
                case 173 -> 252;
                case 174 -> 99;
                case 175 -> 65;
                case 176 -> 150;
                case 177 -> 175;
                case 178 -> 19;
                case 179 -> 91;
                case 180 -> 183;
                case 181 -> 106;
                case 182 -> 185;
                case 183 -> 55;
                case 184 -> 25;
                case 185 -> 81;
                case 186 -> 70;
                case 187 -> 4;
                case 188 -> 159;
                case 189 -> 194;
                case 190 -> 63;
                case 191 -> 253;
                case 192 -> 196;
                case 193 -> 170;
                case 194 -> 23;
                case 195 -> 223;
                case 196 -> 160;
                case 197 -> 178;
                case 198 -> 139;
                case 199 -> 3;
                case 200 -> 152;
                case 201 -> 217;
                case 202 -> 26;
                case 203 -> 208;
                case 204 -> 95;
                case 205 -> 6;
                case 206 -> 120;
                case 207 -> 182;
                case 208 -> 248;
                case 209 -> 66;
                case 210 -> 184;
                case 211 -> 46;
                case 212 -> 225;
                case 213 -> 78;
                case 214 -> 89;
                case 215 -> 29;
                case 216 -> 200;
                case 217 -> 117;
                case 218 -> 172;
                case 219 -> 5;
                case 220 -> 241;
                case 221 -> 193;
                case 222 -> 48;
                case 223 -> 68;
                case 224 -> 192;
                case 225 -> 174;
                case 226 -> 233;
                case 227 -> 229;
                case 228 -> 71;
                case 229 -> 206;
                case 230 -> 116;
                case 231 -> 202;
                case 232 -> 50;
                case 233 -> 228;
                case 234 -> 249;
                case 235 -> 138;
                case 236 -> 161;
                case 237 -> 215;
                case 238 -> 232;
                case 239 -> 88;
                case 240 -> 98;
                case 241 -> 30;
                case 242 -> 230;
                case 243 -> 43;
                case 244 -> 165;
                case 245 -> 198;
                case 246 -> 114;
                case 247 -> 246;
                case 248 -> 148;
                case 249 -> 62;
                case 250 -> 203;
                case 251 -> 79;
                case 252 -> 118;
                case 253 -> 58;
                case 254 -> 7;
                default -> 76;
            };
            int n6 = (n2 & 0xFF) - n5;
            if (n6 < '\0') {
                n6 += '\u0100';
            }
            int n7 = ((n2 & 0xFFFF) >>> 8) - n5;
            if (n7 < '\0') {
                n7 += '\u0100';
            }
            for (int i = 0; i < charArray.length; ++i) {
                final int n8 = i % 2;
                final char[] array = charArray;
                final int n9 = i;
                final char c = array[n9];
                if (n8 == 0) {
                    array[n9] = (char)(c ^ n6);
                    n6 = (((n6 >>> 3 | n6 << 5) ^ charArray[i]) & 0xFF);
                }
                else {
                    array[n9] = (char)(c ^ n7);
                    n7 = (((n7 >>> 3 | n7 << 5) ^ charArray[i]) & 0xFF);
                }
            }
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bl.b[n3] = new String(charArray).intern();
        }
        return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bl.b[n3];
    }
}
