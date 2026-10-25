package net.kingscraft.zenixmc.altarsmp.util;

public class TimeUtils {

  public static long ticksToSeconds(long paramLong) {
    return paramLong / 20L;
  }

  public static String formatMmSs(long paramLong) {
    long l1 = ticksToSeconds(paramLong);
    long l3 = l1 % 3600L / 60L;
    long l4 = l1 % 60L;
    return String.format("%02d:%02d", l3, l4);
  }}
