package pl;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dc extends BukkitRunnable {
  int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = 0;
  
  final double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = Main.getInstance().getConfig().getInt(a, 2);
  
  final Player You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  final ItemDisplay You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  final double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  private static final String a = "scytheReturnPowdr";
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dc(Player paramPlayer, ItemDisplay paramItemDisplay, double paramDouble) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = paramPlayer;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = paramItemDisplay;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = paramDouble;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = 0;
    }
  
  public void run() {
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.isOnline())
        try {
          if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.isDead()) {
            try {
              if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a++ >= this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e) {
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d);
                cancel();
                return;
              } 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.setTeleportDuration(2);
            this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.setInterpolationDelay(0);
            this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.setInterpolationDuration(2);
            Transformation transformation = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.getTransformation();
            try {
              transformation.getLeftRotation().rotateX((float)Math.toRadians(30.0D));
              this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.setTransformation(transformation);
              if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a % 4 == 0)
                this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getWorld().playSound((Entity)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, Sound.ENTITY_WITCH_THROW, 1.0F, 1.0F); 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            Location location1 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.getLocation();
            Location location2 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getEyeLocation();
            Vector vector1 = location2.toVector().subtract(location1.toVector());
            double d = vector1.length();
            try {
              if (d < 1.0D) {
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d);
                cancel();
                return;
              } 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            Vector vector2 = vector1.normalize().multiply(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b);
            location1.add(vector2);
            this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.teleport(location1);
            location1.getWorld().spawnParticle(Particle.SNOWFLAKE, location1, 3, 0.1D, 0.1D, 0.1D, 0.01D);
            location1.setDirection(vector2);
            return;
          } 
          try {
            if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.isDead())
              this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(); 
          } catch (MatchException matchException) {
            throw a(null);
          } 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.isDead())
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  static {
    // Byte code:
    //   0: bipush #121
    //   2: ldc '34N2*T$8H4i5?'
    //   4: iconst_m1
    //   5: goto -> 14
    //   8: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dc.a : Ljava/lang/String;
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
    //   80: bipush #10
    //   82: goto -> 112
    //   85: bipush #41
    //   87: goto -> 112
    //   90: bipush #52
    //   92: goto -> 112
    //   95: bipush #67
    //   97: goto -> 112
    //   100: bipush #35
    //   102: goto -> 112
    //   105: bipush #54
    //   107: goto -> 112
    //   110: bipush #127
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dc.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */