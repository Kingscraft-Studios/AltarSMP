package pl;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dn extends BukkitRunnable {
  int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = 0;
  
  final int int1 = Main.getInstance().getConfig().getInt(a, 500);

  final Vector vector1;
  Vector vector;
  final double Double = 0.025D;
  final ItemDisplay itemDisplay1;
  final Player player;
  final You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  private static final String a = "vulcanMaxDistance";
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dn(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad, Vector paramVector, ItemDisplay paramItemDisplay, Player paramPlayer) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad;
        this.vector1 = paramVector;
        this.itemDisplay1 = paramItemDisplay;
        this.player = paramPlayer;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = 0;
        this.vector = this.vector1.clone();
    }
  
  public void run() {
    try {
      if (!this.itemDisplay1.isDead())
        try {
          if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a++ < this.int1) {
            this.itemDisplay1.setTeleportDuration(3);
            Location location = this.itemDisplay1.getLocation();
            this.vector.setY(this.vector.getY() - 0.025D);
            location.add(this.vector);
            this.itemDisplay1.teleport(location);
            location.getWorld().spawnParticle(Particle.FLAME, location, 3, 0.1D, 0.1D, 0.1D, 0.01D);
            Vector vector = this.vector.clone().normalize();
            try {
              location.setDirection(vector);
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764t.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location)) {
                this.itemDisplay1.remove();
                cancel();
                return;
              } 
            } catch (MatchException matchException) {

            } 
            for (Entity entity : this.itemDisplay1.getNearbyEntities(1.0D, 1.0D, 1.0D)) {
              try {
                if (entity instanceof org.bukkit.entity.LivingEntity)
                  try {
                    if (entity != this.player) {
                      this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(this.itemDisplay1.getLocation(), this.player);
                      this.itemDisplay1.remove();
                      cancel();
                      return;
                    } 
                  } catch (MatchException matchException) {

                  }  
              } catch (MatchException matchException) {

              } 
            } 
            try {
              if (!location.getBlock().getType().isAir()) {
                this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location, this.player);
                this.itemDisplay1.remove();
                cancel();
              } 
            } catch (MatchException matchException) {

            } 
            return;
          } 
          this.itemDisplay1.getLocation().createExplosion(2.0F);
          this.itemDisplay1.remove();
          cancel();
          return;
        } catch (MatchException matchException) {

        }  
    } catch (MatchException matchException) {

    } 
    this.itemDisplay1.getLocation().createExplosion(2.0F);
    this.itemDisplay1.remove();
    cancel();
  }
  
  static {
    // Byte code:
    //   0: bipush #76
    //   2: ldc '{5YiWel8qcEIc#P'
    //   4: iconst_m1
    //   5: goto -> 14
    //   8: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dn.a : Ljava/lang/String;
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
    //   80: bipush #65
    //   82: goto -> 112
    //   85: bipush #12
    //   87: goto -> 112
    //   90: bipush #121
    //   92: goto -> 112
    //   95: bipush #70
    //   97: goto -> 112
    //   100: bipush #122
    //   102: goto -> 112
    //   105: bipush #33
    //   107: goto -> 112
    //   110: bipush #100
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dn.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */