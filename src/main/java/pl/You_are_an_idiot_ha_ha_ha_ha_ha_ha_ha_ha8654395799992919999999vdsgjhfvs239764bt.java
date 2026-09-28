package pl;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt {
  private static final Map<UUID, Map<String, Double>> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = new ConcurrentHashMap<>();
  
  private static final Map<UUID, Map<String, Double>> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new ConcurrentHashMap<>();
  
  private static final Map<UUID, Map<String, Double>> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new ConcurrentHashMap<>();
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(UUID paramUUID, String paramString) {
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bu.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d())
        return true; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
    
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramUUID, paramString) > 0.0D);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(UUID paramUUID, String paramString, double paramDouble) {
    ((Map<String, Double>)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.computeIfAbsent(paramUUID, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt::lambda$setCooldown$0)).put(paramString, Double.valueOf(System.currentTimeMillis() + paramDouble * 1000.0D));
    ((Map<String, Double>)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.computeIfAbsent(paramUUID, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt::lambda$setCooldown$1)).put(paramString, Double.valueOf(paramDouble));
    ((Map<String, Double>)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.computeIfAbsent(paramUUID, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt::lambda$setCooldown$2)).put(paramString, Double.valueOf(paramDouble));
  }
  
  public static double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(UUID paramUUID, String paramString) {
    return ((Double)((Map)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getOrDefault(paramUUID, Collections.emptyMap())).getOrDefault(paramString, Double.valueOf(0.0D))).doubleValue();
  }
  
  public static Integer You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(UUID paramUUID, String paramString) {
    Map map = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.get(paramUUID);
    try {
      if (map != null)
        try {
          if (map.containsKey(paramString)) {
            double d = ((Double)map.get(paramString)).doubleValue() - System.currentTimeMillis();
            int i = (int)(d / 1000.0D);
            return Integer.valueOf(i);
          } 
          return Integer.valueOf(0);
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return Integer.valueOf(0);
  }
  
  public static double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(UUID paramUUID, String paramString) {
    Map map = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.get(paramUUID);
    try {
      if (map != null)
        try {
          if (map.containsKey(paramString)) {
            double d = ((Double)map.get(paramString)).doubleValue() - System.currentTimeMillis();
            try {
            
            } catch (MatchException matchException) {
              throw a(null);
            } 
            return (d > 0.0D) ? d : 0.0D;
          } 
          return 0.0D;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return 0.0D;
  }
  
  public static double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(UUID paramUUID, String paramString) {
    return ((Double)((Map)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getOrDefault(paramUUID, Collections.emptyMap())).getOrDefault(paramString, Double.valueOf(0.0D))).doubleValue();
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(UUID paramUUID) {
    Map map = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.get(paramUUID);
    try {
      if (map == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    double d = System.currentTimeMillis();
    Iterator<Double> iterator = map.values().iterator();
    while (iterator.hasNext()) {
      double d1 = ((Double)iterator.next()).doubleValue();
      try {
        if (d1 > d)
          return true; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
    return false;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(UUID paramUUID) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.remove(paramUUID);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(UUID paramUUID) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(paramUUID);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(UUID paramUUID) {
    Map map1 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.get(paramUUID);
    Map map2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.get(paramUUID);
    try {
      if (map1 != null)
        try {
          if (map2 != null) {
            for (String str : (Iterable<String>)(Iterable<?>)map1.keySet()) {
              Double double_ = (Double)map2.get(str);
              try {
                if (double_ != null)
                  try {
                    if (double_.doubleValue() > 0.0D)
                      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramUUID, str, double_.doubleValue()); 
                  } catch (MatchException matchException) {
                    throw a(null);
                  }  
              } catch (MatchException matchException) {
                throw a(null);
              } 
            } 
            return;
          } 
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private static Map lambda$setCooldown$2(UUID paramUUID) {
    return new ConcurrentHashMap<>();
  }
  
  private static Map lambda$setCooldown$1(UUID paramUUID) {
    return new ConcurrentHashMap<>();
  }
  
  private static Map lambda$setCooldown$0(UUID paramUUID) {
    return new ConcurrentHashMap<>();
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */