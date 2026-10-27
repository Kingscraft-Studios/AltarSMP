package net.kingscraft.zenixmc.altarsmp.core;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CooldownManager {
  private static final Map<UUID, Map<String, Double>> expiryTimestamps = new ConcurrentHashMap<>();

  private static final Map<UUID, Map<String, Double>> totalCooldowns = new ConcurrentHashMap<>();

  private static final Map<UUID, Map<String, Double>> remainingCooldowns = new ConcurrentHashMap<>();

  public static boolean isOnCooldown(UUID paramUUID, String paramString) {
    return (getRemainingMillis(paramUUID, paramString) > 0.0D);
  }

  public static void setCooldown(UUID paramUUID, String paramString, double paramDouble) {
    expiryTimestamps.computeIfAbsent(paramUUID, CooldownManager::newCooldownMap).put(paramString, System.currentTimeMillis() + paramDouble * 1000.0D);
    remainingCooldowns.computeIfAbsent(paramUUID, CooldownManager::newCooldownMap).put(paramString, paramDouble);
    totalCooldowns.computeIfAbsent(paramUUID, CooldownManager::newCooldownMap).put(paramString, paramDouble);
  }

  public static int getRemainingSeconds(UUID paramUUID, String paramString) {
    Map<String, Double> map = expiryTimestamps.get(paramUUID);
    if (map != null)
      if (map.containsKey(paramString)) {
        double d = map.get(paramString) - System.currentTimeMillis();
        return (int)(d / 1000.0D);
      }
    return 0;
  }

  public static double getRemainingMillis(UUID paramUUID, String paramString) {
    Map<String, Double> map = expiryTimestamps.get(paramUUID);
    if (map == null || !map.containsKey(paramString)) {
      return 0.0D;
    }
    double remaining = map.get(paramString) - System.currentTimeMillis();
    return Math.max(remaining, 0.0D);
  }

  public static void clearExpiries(UUID paramUUID) {
    expiryTimestamps.remove(paramUUID);
  }

  private static <T> Map<String, T> newCooldownMap(UUID uuid) {
    return new ConcurrentHashMap<>();
  }
}
