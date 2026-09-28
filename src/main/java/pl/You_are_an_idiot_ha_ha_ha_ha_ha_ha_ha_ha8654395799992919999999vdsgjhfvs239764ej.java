package pl;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ej extends BukkitRunnable {
  final ItemDisplay You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ej(ItemDisplay paramItemDisplay) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramItemDisplay;
    }
  
  public void run() {
    // Byte code:
    //   0: ldc2_w 0.5
    //   3: dstore_1
    //   4: aload_0
    //   5: getfield You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Lorg/bukkit/entity/ItemDisplay;
    //   8: aload_0
    //   9: getfield You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Lorg/bukkit/entity/ItemDisplay;
    //   12: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   17: dconst_0
    //   18: dload_1
    //   19: dconst_0
    //   20: invokevirtual add : (DDD)Lorg/bukkit/Location;
    //   23: invokeinterface teleport : (Lorg/bukkit/Location;)Z
    //   28: pop
    //   29: aload_0
    //   30: getfield You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Lorg/bukkit/entity/ItemDisplay;
    //   33: bipush #10
    //   35: invokeinterface setTeleportDuration : (I)V
    //   40: invokestatic getScheduler : ()Lorg/bukkit/scheduler/BukkitScheduler;
    //   43: invokestatic getInstance : ()Lpl/Main;
    //   46: aload_0
    //   47: aload_0
    //   48: getfield You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Lorg/bukkit/entity/ItemDisplay;
    //   51: dload_1
    //   52: <illegal opcode> run : (Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ej;Lorg/bukkit/entity/ItemDisplay;D)Ljava/lang/Runnable;
    //   57: ldc2_w 10
    //   60: invokeinterface runTaskLater : (Lorg/bukkit/plugin/Plugin;Ljava/lang/Runnable;J)Lorg/bukkit/scheduler/BukkitTask;
    //   65: pop
    //   66: return
  }
  
  private void lambda$run$0(ItemDisplay paramItemDisplay, double paramDouble) {
    paramItemDisplay.teleport(paramItemDisplay.getLocation().subtract(0.0D, paramDouble, 0.0D));
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ek(this, paramItemDisplay)).runTaskLater((Plugin)Main.getInstance(), 10L);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ej.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */