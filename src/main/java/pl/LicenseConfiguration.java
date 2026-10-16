package pl;

import java.util.logging.Logger;

class LicenseConfiguration {
  static final Logger LOGGER;
  
  static final String API_BASE_URL;
  
  static final String VALIDATION_URL;
  
  static final String HEARTBEAT_URL;
  
  static final int CONNECT_TIMEOUT = 5000;
  
  static final int HEARTBEAT_INTERVAL = 30;
  
  static final String PUBLIC_KEY;
  
  static final boolean IS_FOLIA;

  static {
    API_BASE_URL = "https://api.mclicense.org";
    VALIDATION_URL = "https://api.mclicense.org/validate/%s/%s";
    PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArhw7oQaOrgCzUxDi5D+N\nTH9te0JYB1EvW7CEI40+n2drmHJ4+g0CXXYjJc5LyuePskSUPnnHf3UkRvi1GTUd\n6Bqi2Jpeu+qbBfm3hg6rcyLUWo8d5MrBQDbVcIvKmQNegTaJGxFRpEFR9XOeHI1g\n4dfF+hOfy+1rbEF4p4fgiz0irtKv8l3uSPOKVoEjTL9xnZx4MU5rIsn6W3jee04q\nESPJpCg8nmmZSuJ+9EzzoLnLnUc2/sBuqJ/jexpNfMrXIR11+L8DFqei7J2M7aKi\n0KZvQNIqzqTPBCR9VLZPBjFu6cYT/E/WUjjFROuRhi+7Xsa6tKLqoiO4VwJSrn5L\nzwIDAQAB\n-----END PUBLIC KEY-----";
    HEARTBEAT_URL = "https://api.mclicense.org/heartbeat/%s/%s";
    LOGGER = Logger.getLogger("MCLicense");
    IS_FOLIA = isFoliaServer();
  }
  
  
  
  private static boolean isFoliaServer() {
    try {
      Class.forName("io.papermc.paper.threadedregions.RegionizedServer");
      return true;
    } catch (ClassNotFoundException classNotFoundException) {
      return false;
    } 
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */