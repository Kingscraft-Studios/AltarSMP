package pl;

import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.json.JSONObject;

class LicenseHeartbeatManager {
  public static boolean heartbeatActive;
  
  private static String pluginId;
  
  private static String licenseKey;
  
  private static String serverIp;
  
  private static ScheduledTask foliaHeartbeatTask;
  
  private static BukkitTask bukkitHeartbeatTask;
  
  private static boolean shutdownListenerRegistered;
  
  
  
  protected static void startHeartbeat(JavaPlugin paramJavaPlugin, String paramString1, String paramString2, String paramString3) {
    {
      if (heartbeatActive)
        stopHeartbeat();
    }{
      if (!shutdownListenerRegistered) {
        paramJavaPlugin.getServer().getPluginManager().registerEvents(new LicenseShutdownListener(paramJavaPlugin), (Plugin)paramJavaPlugin);
        shutdownListenerRegistered = true;
      } 
    }{
      pluginId = paramString1;
      licenseKey = paramString2;
      serverIp = paramString3;
      if (LicenseConfiguration.IS_FOLIA) {
        foliaHeartbeatTask = Bukkit.getAsyncScheduler().runAtFixedRate((Plugin)paramJavaPlugin, LicenseHeartbeatManager::lambda$startHeartbeat$0, 30L, 30L, TimeUnit.SECONDS);
      } else {
        bukkitHeartbeatTask = Bukkit.getScheduler().runTaskTimerAsynchronously((Plugin)paramJavaPlugin, LicenseHeartbeatManager::lambda$startHeartbeat$1, 600L, 600L);
      } 
    }
    heartbeatActive = true;
  }
  
  protected static void sendHeartbeat(boolean paramBoolean) {
    try {
      URL uRL = new URL(String.format("https://api.mclicense.org/heartbeat/%s/%s", new Object[] {pluginId, licenseKey}));
      HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
      httpURLConnection.setRequestMethod("POST");
      httpURLConnection.setRequestProperty("Content-Type", "application/json");
      httpURLConnection.setConnectTimeout(5000);
      httpURLConnection.setReadTimeout(5000);
      httpURLConnection.setDoOutput(true);
      JSONObject jSONObject = new JSONObject();
      {
        jSONObject.put("serverIp", serverIp);
        if (paramBoolean)
          jSONObject.put("shutdown", true); 
      }OutputStream outputStream = httpURLConnection.getOutputStream();
      try {
        byte[] arrayOfByte = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
        outputStream.write(arrayOfByte, 0, arrayOfByte.length);
        if (outputStream != null)
          outputStream.close(); 
      } catch (Throwable throwable) {
        if (outputStream != null)
          try {
            outputStream.close();
          } catch (Throwable throwable1) {
            throwable.addSuppressed(throwable1);
          }  
        throw throwable;
      } 
      if (httpURLConnection.getResponseCode() != 200);
    } catch (Exception exception) {}
  }
  
  private static void stopHeartbeat() {
    sendHeartbeat(true);
    if (LicenseConfiguration.IS_FOLIA) {
      if (foliaHeartbeatTask != null) {
        foliaHeartbeatTask.cancel();
        foliaHeartbeatTask = null;
      } 
    } 
    if (!LicenseConfiguration.IS_FOLIA) {
      if (bukkitHeartbeatTask != null) {
        bukkitHeartbeatTask.cancel();
        bukkitHeartbeatTask = null;
      } 
    } 
    heartbeatActive = false;
  }
  
  private static void lambda$startHeartbeat$1() {
    sendHeartbeat(false);
  }
  
  private static void lambda$startHeartbeat$0(ScheduledTask paramScheduledTask) {
    sendHeartbeat(false);
  }

  
  private static Throwable a(Throwable paramThrowable) {
    return paramThrowable;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */