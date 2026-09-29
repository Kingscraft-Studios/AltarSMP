package pl;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c0 extends BukkitRunnable {
  int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = 0;
  
  final int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = 10;
  
  final LivingEntity You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  final Player You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  private static final String a = "minecraft:bloodlust.dive";
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c0(LivingEntity paramLivingEntity, Player paramPlayer) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = paramLivingEntity;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = paramPlayer;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = 0;
    }
  
  public void run() {
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a < 10)
        try {
          if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.isValid())
            try {
              if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.isOnline()) {
                try {
                  if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.getWorld() != this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getWorld())
                    return; 
                } catch (MatchException matchException) {
                  throw a(null);
                } 
                try {
                  if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.getLocation().distance(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getLocation()) <= 2.0D) {
                    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.setVelocity(new Vector(0, 0, 0));
                    cancel();
                    return;
                  } 
                } catch (MatchException matchException) {
                  throw a(null);
                } 
                Location location1 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getLocation().clone().add(0.0D, 1.0D, 0.0D);
                Location location2 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.getLocation().clone().add(0.0D, 1.0D, 0.0D);
                Vector vector1 = location2.toVector().subtract(location1.toVector());
                double d = vector1.length();
                Vector vector2 = vector1.normalize().multiply(1);
                if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a % 2 == 0) {
                  double d1;
                  for (d1 = 0.0D; d1 < d; d1++) {
                    Location location = location1.clone().add(vector2.clone().multiply(d1));
                    location1.getWorld().spawnParticle(Particle.ITEM, location, 0, 0.0D, 0.0D, 0.0D, 0.0D, new ItemStack(Material.REDSTONE_BLOCK));
                  } 
                } 
                this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.getWorld().playSound(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.getLocation(), a, 2.0F, 0.8F);
                Vector vector3 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.getLocation().toVector().subtract(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getLocation().toVector()).normalize();
                this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.setVelocity(vector3.multiply(1.5D));
                this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a++;
                return;
              } 
              cancel();
              return;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    cancel();
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  static {
    // Byte code:
    //   0: bipush #59
    //   2: ldc '?(WbJ945CPmW76-\\fAu<;7'
    //   4: iconst_m1
    //   5: goto -> 14
    //   8: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c0.a : Ljava/lang/String;
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
    //   80: bipush #105
    //   82: goto -> 111
    //   85: bipush #122
    //   87: goto -> 111
    //   90: bipush #66
    //   92: goto -> 111
    //   95: bipush #9
    //   97: goto -> 111
    //   100: bipush #58
    //   102: goto -> 111
    //   105: iconst_3
    //   106: goto -> 111
    //   109: bipush #99
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c0.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */