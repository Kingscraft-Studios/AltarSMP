package pl;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.bukkit.plugin.java.JavaPlugin;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bz {
  
  
  private static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(JavaPlugin paramJavaPlugin, String paramString1, String paramString2, File paramFile) {
    try {
      String s4 = java.util.UUID.randomUUID().toString();
      String s5 = java.util.UUID.randomUUID().toString();
      String s6 = java.net.URLEncoder.encode(paramString1, StandardCharsets.UTF_8.toString()).replace("+", "%20");
      String s7 = java.net.URLEncoder.encode(paramString2, StandardCharsets.UTF_8.toString()).replace("+", "%20");
      String s8 = String.format("https://api.mclicense.org/validate/%s/%s", s6, s7) + "?sessionId=" + s4 + "&nonce=" + s5;
      String s9 = MarketplaceProvider.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
      if (s9 != null) {
        s8 = s8 + "&polymartUserId=" + java.net.URLEncoder.encode(s9, StandardCharsets.UTF_8.toString());
      }
      java.net.HttpURLConnection connection = (java.net.HttpURLConnection)(new java.net.URL(s8).openConnection());
      connection.setRequestMethod("GET");
      connection.setConnectTimeout(5000);
      connection.setReadTimeout(5000);
      String s12;
      try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(connection.getResponseCode() >= 400 ? connection.getErrorStream() : connection.getInputStream()))) {
        StringBuilder stringBuilder = new StringBuilder();
        String s13;
        while ((s13 = reader.readLine()) != null)
          stringBuilder.append(s13);
        s12 = stringBuilder.toString();
      }
      if (connection.getResponseCode() != 200) {
        String s14 = "\n\n\n\n\n\n\n\n\n\n";
        try {
          org.json.JSONObject jsonObject = new org.json.JSONObject(s12);
          String s15 = "\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n" + "\u00a7cLicense validation failed for \u00a7e" + paramJavaPlugin.getName() + " \u00a7c(" + jsonObject.getString("message") + ")" + "\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n";
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info(s15);
          for (org.bukkit.entity.Player onlinePlayer : org.bukkit.Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.isOp())
              onlinePlayer.sendMessage(s15);
          }
        } catch (Exception exception) {
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info("License validation failed for " + paramJavaPlugin.getName() + " (Server error)");
        }
        return false;
      }
      org.json.JSONObject jsonObject2 = new org.json.JSONObject(s12);
      if (!jsonObject2.getString("nonce").equals(s5)) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info("License validation failed for " + paramJavaPlugin.getName() + " (Nonce mismatch)");
        return false;
      }
      if (!jsonObject2.getString("key").equals(paramString2) || !jsonObject2.getString("pluginId").equals(paramString1)) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info("License validation failed for " + paramJavaPlugin.getName() + " (Key or pluginId mismatch)");
        return false;
      }
      String s16 = jsonObject2.getString("signature");
      org.json.JSONObject jsonObject3 = new org.json.JSONObject();
      jsonObject3.put("key", jsonObject2.getString("key"));
      jsonObject3.put("pluginId", jsonObject2.getString("pluginId"));
      jsonObject3.put("status", jsonObject2.getString("status"));
      jsonObject3.put("message", jsonObject2.getString("message"));
      jsonObject3.put("nonce", jsonObject2.getString("nonce"));
      String s17 = jsonObject3.toString();
      String s18 = "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArhw7oQaOrgCzUxDi5D+N\nTH9te0JYB1EvW7CEI40+n2drmHJ4+g0CXXYjJc5LyuePskSUPnnHf3UkRvi1GTUd\n6Bqi2Jpeu+qbBfm3hg6rcyLUWo8d5MrBQDbVcIvKmQNegTaJGxFRpEFR9XOeHI1g\n4dfF+hOfy+1rbEF4p4fgiz0irtKv8l3uSPOKVoEjTL9xnZx4MU5rIsn6W3jee04q\nESPJpCg8nmmZSuJ+9EzzoLnLnUc2/sBuqJ/jexpNfMrXIR11+L8DFqei7J2M7aKi\n0KZvQNIqzqTPBCR9VLZPBjFu6cYT/E/WUjjFROuRhi+7Xsa6tKLqoiO4VwJSrn5L\nzwIDAQAB-----END PUBLIC KEY-----".replace("-----BEGIN PUBLIC KEY-----\n", "").replace("\n-----END PUBLIC KEY-----", "").replaceAll("\n", "");
      byte[] s19 = java.util.Base64.getDecoder().decode(s18);
      java.security.spec.X509EncodedKeySpec x509EncodedKeySpec = new java.security.spec.X509EncodedKeySpec(s19);
      java.security.KeyFactory keyFactory = java.security.KeyFactory.getInstance("RSA");
      java.security.PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
      java.security.Signature signature = java.security.Signature.getInstance("SHA256withRSA");
      signature.initVerify(publicKey);
      signature.update(s17.getBytes(StandardCharsets.UTF_8));
      boolean s20 = signature.verify(java.util.Base64.getDecoder().decode(s16));
      if (!s20) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info("License validation failed for " + paramJavaPlugin.getName() + " (Signature mismatch)");
        return false;
      }
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramJavaPlugin, paramString1, paramString2, s4);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info("License validation succeeded for " + paramJavaPlugin.getName() + "!");
      return true;
    } catch (Exception exception) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info("License validation failed for " + paramJavaPlugin.getName() + " (System error)");
      exception.printStackTrace();
      return false;
    }
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(JavaPlugin paramJavaPlugin, String paramString) {
    try {
      File file = new File(paramJavaPlugin.getDataFolder(), "mclicense.txt");
      String str1 = "";
      {
        if (!file.exists()) {
          paramJavaPlugin.getDataFolder().mkdirs();
          file.createNewFile();
        } else {
          str1 = (new String(Files.readAllBytes(Paths.get(file.getPath(), new String[0])), StandardCharsets.UTF_8)).trim();
        } 
      }
      String str2 = str1;
      if (str2.isEmpty()) {
        String str = MarketplaceProvider.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
        if (str != null) {
          str2 = str;
        } else {
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info(paramJavaPlugin.getName() + "License key is empty for " + "! Place your key in the 'mclicense.txt' file in the plugin folder and restart the server.");
          return false;
        }
      }
      boolean bool = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramJavaPlugin, paramString, str2, file);
      {
        if (bool)
          {
            if (!str2.equals(str1))
              Files.write(file.toPath(), str2.getBytes(StandardCharsets.UTF_8), new java.nio.file.OpenOption[0]);
          }}{
        if (bool) {
          AntiTamperGuard.markLicensed();
        } 
      }return bool;
    } catch (Exception exception) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info(paramJavaPlugin.getName() + "License validation failed for " + " (System error)");
      exception.printStackTrace();
      return false;
    } 
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(JavaPlugin paramJavaPlugin, String paramString1, String paramString2) {
    try {
      File file = new File(paramJavaPlugin.getDataFolder(), "mclicense.txt");
      {
        if (!file.exists()) {
          paramJavaPlugin.getDataFolder().mkdirs();
          file.createNewFile();
        } 
      }Files.write(file.toPath(), paramString2.getBytes(StandardCharsets.UTF_8), new java.nio.file.OpenOption[0]);
      return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramJavaPlugin, paramString1, paramString2, file);
    } catch (Exception exception) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info(paramJavaPlugin.getName() + "License write and validation failed for " + " (System error)");
      exception.printStackTrace();
      return false;
    } 
  }
  
  private static Throwable a(Throwable paramThrowable) {
    return paramThrowable;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bz.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */