package net.kingscraft.zenixmc.altarsmp.core;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class CooldownManager {
  private static final Map<UUID, Map<String, Double>> expiryTimestamps = new ConcurrentHashMap<>();
  
  private static final Map<UUID, Map<String, Double>> totalCooldowns = new ConcurrentHashMap<>();
  
  private static final Map<UUID, Map<String, Double>> remainingCooldowns = new ConcurrentHashMap<>();
  
  public static boolean isOnCooldown(UUID paramUUID, String paramString) {
    return (getRemainingMillis(paramUUID, paramString) > 0.0D);
  }
  
  public static void setCooldown(UUID paramUUID, String paramString, double paramDouble) {
    ((Map<String, Double>) expiryTimestamps.computeIfAbsent(paramUUID, CooldownManager::newCooldownMap)).put(paramString, Double.valueOf(System.currentTimeMillis() + paramDouble * 1000.0D));
    ((Map<String, Double>) remainingCooldowns.computeIfAbsent(paramUUID, CooldownManager::newCooldownMap)).put(paramString, Double.valueOf(paramDouble));
    ((Map<String, Double>) totalCooldowns.computeIfAbsent(paramUUID, CooldownManager::newCooldownMap)).put(paramString, Double.valueOf(paramDouble));
  }
  
  public static double getRemainingCooldown(UUID paramUUID, String paramString) {
    return ((Double)((Map) remainingCooldowns.getOrDefault(paramUUID, Collections.emptyMap())).getOrDefault(paramString, Double.valueOf(0.0D))).doubleValue();
  }
  
  public static Integer getRemainingSeconds(UUID paramUUID, String paramString) {
    Map map = expiryTimestamps.get(paramUUID);
    if (map != null)
      if (map.containsKey(paramString)) {
        double d = ((Double)map.get(paramString)).doubleValue() - System.currentTimeMillis();
        int i = (int)(d / 1000.0D);
        return Integer.valueOf(i);
      }
    return Integer.valueOf(0);
  }
  
  public static double getRemainingMillis(UUID paramUUID, String paramString) {
    Map<String, Double> map = expiryTimestamps.get(paramUUID);
    if (map == null || !map.containsKey(paramString)) {
      return 0.0D;
    }
    double remaining = map.get(paramString) - System.currentTimeMillis();
    return (remaining > 0.0D) ? remaining : 0.0D;
  }
  
  public static double getTotalCooldown(UUID paramUUID, String paramString) {
    return ((Double)((Map) remainingCooldowns.getOrDefault(paramUUID, Collections.emptyMap())).getOrDefault(paramString, Double.valueOf(0.0D))).doubleValue();
  }
  
  public static boolean hasActiveCooldown(UUID paramUUID) {
    Map<String, Double> map = expiryTimestamps.get(paramUUID);
    if (map == null) {
      return false;
    }
    double now = System.currentTimeMillis();
    for (Double expiry : map.values()) {
      if (expiry > now) {
        return true;
      }
    }
    return false;
  }
  
  public static void clearExpiries(UUID paramUUID) {
    expiryTimestamps.remove(paramUUID);
  }
  
  public static void clearRemainingCooldowns(UUID paramUUID) {
    remainingCooldowns.remove(paramUUID);
  }
  
  public static void refreshCooldowns(UUID paramUUID) {
    Map<String, Double> expiries = expiryTimestamps.get(paramUUID);
    Map<String, Double> remaining = remainingCooldowns.get(paramUUID);
    if (expiries == null || remaining == null) {
      return;
    }
    for (String key : expiries.keySet()) {
      Double duration = remaining.get(key);
      if (duration != null && duration > 0.0D) {
        setCooldown(paramUUID, key, duration);
      }
    }
  }

  private static Map newCooldownMap(UUID uuid) { return new ConcurrentHashMap<>(); }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */