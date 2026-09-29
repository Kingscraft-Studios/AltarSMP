package pl;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c7 extends BukkitRunnable {
  final LivingEntity You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  private static final String a = "Stunned!";
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c7(LivingEntity paramLivingEntity) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramLivingEntity;
    }
  
  public void run() {
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764_.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.containsKey(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
        cancel();
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a instanceof Player) {
      Player player = (Player)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
      player.sendTitle("", String.valueOf(ChatColor.YELLOW) + String.valueOf(ChatColor.YELLOW), 0, 10, 0);
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  static {
    // Byte code:
    //   0: bipush #16
    //   2: ldc 'S3\\nQQ!'
    //   4: iconst_m1
    //   5: goto -> 14
    //   8: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c7.a : Ljava/lang/String;
    //   11: goto -> 154
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
    //   29: if_icmpgt -> 128
    //   32: dup2
    //   33: swap
    //   34: iload_0
    //   35: dup2_x1
    //   36: caload
    //   37: swap
    //   38: iload_0
    //   39: bipush #7
    //   41: irem
    //   42: tableswitch default -> 110, 0 -> 80, 1 -> 85, 2 -> 90, 3 -> 95, 4 -> 100, 5 -> 105
    //   80: bipush #16
    //   82: goto -> 112
    //   85: bipush #87
    //   87: goto -> 112
    //   90: bipush #111
    //   92: goto -> 112
    //   95: bipush #99
    //   97: goto -> 112
    //   100: bipush #47
    //   102: goto -> 112
    //   105: bipush #101
    //   107: goto -> 112
    //   110: bipush #37
    //   112: ixor
    //   113: ixor
    //   114: i2c
    //   115: castore
    //   116: iinc #0, 1
    //   119: dup
    //   120: ifne -> 128
    //   123: dup2
    //   124: dup_x1
    //   125: goto -> 35
    //   128: dup2_x1
    //   129: pop2
    //   130: dup_x2
    //   131: iload_0
    //   132: if_icmpgt -> 32
    //   135: pop
    //   136: new java/lang/String
    //   139: dup_x1
    //   140: swap
    //   141: invokespecial <init> : ([C)V
    //   144: invokevirtual intern : ()Ljava/lang/String;
    //   147: swap
    //   148: pop
    //   149: swap
    //   150: pop
    //   151: goto -> 8
    //   154: return
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c7.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */