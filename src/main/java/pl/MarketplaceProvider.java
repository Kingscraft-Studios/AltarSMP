package pl;

public class MarketplaceProvider {
  private static String polymartEnabled = "%%__POLYMART__%%";
  
  private static String licenseKey = "%%__LICENSE__%%";
  
  private static String polymartUserId = "%%__USER__%%";
  
  private static String bbbLicenseKey = "%%__BBB_LICENSE__%%";
  
  protected static String getLicenseKey() {
    try {
      if (!bbbLicenseKey.startsWith("%%__"))
        return bbbLicenseKey;
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (polymartEnabled.equals("1"))
        try {
          if (!licenseKey.startsWith("%%__"))
            return "pm_" + licenseKey;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  protected static String getPolymartUserId() {
    try {
      if (polymartEnabled.equals("1"))
        try {
          if (!polymartUserId.startsWith("%%__"))
            return polymartUserId;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/MarketplaceProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */