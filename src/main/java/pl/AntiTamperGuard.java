package pl;

public class AntiTamperGuard {
  static String licenseMarker = null;

  private static final String MAGIC = LicenseConstants.VALIDATION_MARKER;

  public static void markLicensed() {
    licenseMarker = MAGIC;
  }

  public static boolean isLicenseInvalid() {
    return !MAGIC.equals(licenseMarker);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bu.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */