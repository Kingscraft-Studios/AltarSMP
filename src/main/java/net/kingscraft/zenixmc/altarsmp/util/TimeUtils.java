package net.kingscraft.zenixmc.altarsmp.util;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;


public class TimeUtils {
  private static final int TICKS_PER_SECOND = 20;
  
  public static long ticksToSeconds(long paramLong) {
    return paramLong / 20L;
  }
  
  public static long ticksToMinutes(long paramLong) {
    return ticksToSeconds(paramLong) / 60L;
  }
  
  public static long ticksToHours(long paramLong) {
    return ticksToSeconds(paramLong) / 3600L;
  }
  
  public static String formatMmSs(long paramLong) {
    long l1 = ticksToSeconds(paramLong);
    long l2 = l1 / 3600L;
    long l3 = l1 % 3600L / 60L;
    long l4 = l1 % 60L;
    return String.format("%02d:%02d", new Object[] { Long.valueOf(l3), Long.valueOf(l4) });
  }
  
  public static String formatHhMm(long paramLong) {
    long l1 = ticksToSeconds(paramLong);
    long l2 = l1 / 3600L;
    long l3 = l1 % 3600L / 60L;
    return String.format("%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
  }
  
  public static double ticksToHoursDouble(long paramLong) {
    return paramLong / 72000.0D;
  }
  
  public static long secondsToTicks(long paramLong) {
    return paramLong * 20L;
  }
  
  public static long minutesToTicks(long paramLong) {
    return secondsToTicks(paramLong * 60L);
  }
  
  public static long hoursToTicks(long paramLong) {
    return secondsToTicks(paramLong * 3600L);
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ch.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */