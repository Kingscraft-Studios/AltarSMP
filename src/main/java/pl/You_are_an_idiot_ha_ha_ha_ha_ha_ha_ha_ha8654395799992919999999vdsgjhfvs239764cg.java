package pl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cg implements CommandExecutor {
  private static final String a = "Player not found or not online.";
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cg(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cf paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cf) {}
  
  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    Player player;
    if (paramArrayOfString.length == 0) {
      player = (Player)paramCommandSender;
    } else {
      player = Bukkit.getPlayer(paramArrayOfString[0]);
    } 
    try {
      if (player != null)
        try {
          if (player.isOnline()) {
            player.getInventory().addItem(new ItemStack[] { You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cf.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() });
            return true;
          } 
          paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
          return true;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
    return true;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  static {
    // Byte code:
    //   0: bipush #16
    //   2: ldc '{ixL`&Ej!O}sEaZn[2hDqZnG~oE`T'
    //   4: iconst_m1
    //   5: goto -> 14
    //   8: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cg.a : Ljava/lang/String;
    //   11: goto -> 153
    //   14: dup_x2
    //   15: pop
    //   16: invokevirtual toCharArray : ()[C
    //   19: dup_x1
    //   20: arraylength
    //   21: dup_x2
    //   22: pop
    //   23: iconst_0
    //   24: istore_0
    //   25: dup2_x1
    //   26: pop2
    //   27: dup_x2
    //   28: iconst_1
    //   29: if_icmpgt -> 127
    //   32: dup2
    //   33: swap
    //   34: iload_0
    //   35: dup2_x1
    //   36: caload
    //   37: swap
    //   38: iload_0
    //   39: bipush #7
    //   41: irem
    //   42: tableswitch default -> 109, 0 -> 80, 1 -> 85, 2 -> 90, 3 -> 95, 4 -> 100, 5 -> 105
    //   80: bipush #59
    //   82: goto -> 111
    //   85: bipush #21
    //   87: goto -> 111
    //   90: bipush #106
    //   92: goto -> 111
    //   95: bipush #17
    //   97: goto -> 111
    //   100: bipush #57
    //   102: goto -> 111
    //   105: iconst_2
    //   106: goto -> 111
    //   109: bipush #22
    //   111: ixor
    //   112: ixor
    //   113: i2c
    //   114: castore
    //   115: iinc #0, 1
    //   118: dup
    //   119: ifne -> 127
    //   122: dup2
    //   123: dup_x1
    //   124: goto -> 35
    //   127: dup2_x1
    //   128: pop2
    //   129: dup_x2
    //   130: iload_0
    //   131: if_icmpgt -> 32
    //   134: pop
    //   135: new java/lang/String
    //   138: dup_x1
    //   139: swap
    //   140: invokespecial <init> : ([C)V
    //   143: invokevirtual intern : ()Ljava/lang/String;
    //   146: swap
    //   147: pop
    //   148: swap
    //   149: pop
    //   150: goto -> 8
    //   153: return
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cg.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */