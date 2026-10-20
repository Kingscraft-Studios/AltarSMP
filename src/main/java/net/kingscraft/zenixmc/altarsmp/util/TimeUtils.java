package net.kingscraft.zenixmc.altarsmp.util;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class TimeUtils {

  public static long ticksToSeconds(long paramLong) {
    return paramLong / 20L;
  }

  public static String formatMmSs(long paramLong) {
    long l1 = ticksToSeconds(paramLong);
    long l2 = l1 / 3600L;
    long l3 = l1 % 3600L / 60L;
    long l4 = l1 % 60L;
    return String.format("%02d:%02d", Long.valueOf(l3), Long.valueOf(l4));
  }}
