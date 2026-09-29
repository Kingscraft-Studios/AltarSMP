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

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw {
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  private static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  private static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  private static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  private static ScheduledTask You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  private static BukkitTask You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  private static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  
  
  protected static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(JavaPlugin paramJavaPlugin, String paramString1, String paramString2, String paramString3) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(); 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g) {
        paramJavaPlugin.getServer().getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b0(paramJavaPlugin), (Plugin)paramJavaPlugin);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = true;
      } 
    }{
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = paramString1;
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = paramString2;
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = paramString3;
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = Bukkit.getAsyncScheduler().runAtFixedRate((Plugin)paramJavaPlugin, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw::lambda$startHeartbeat$0, 30L, 30L, TimeUnit.SECONDS);
      } else {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = Bukkit.getScheduler().runTaskTimerAsynchronously((Plugin)paramJavaPlugin, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw::lambda$startHeartbeat$1, 600L, 600L);
      } 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = true;
  }
  
  protected static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(boolean paramBoolean) {
    try {
      URL uRL = new URL(String.format("https://api.mclicense.org/heartbeat/%s/%s", new Object[] { You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c }));
      HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
      httpURLConnection.setRequestMethod("POST");
      httpURLConnection.setRequestProperty("Content-Type", "application/json");
      httpURLConnection.setConnectTimeout(5000);
      httpURLConnection.setReadTimeout(5000);
      httpURLConnection.setDoOutput(true);
      JSONObject jSONObject = new JSONObject();
      {
        jSONObject.put("serverIp", You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d);
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
  
  private static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    // Byte code:
    //   0: iconst_1
    //   1: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Z)V
    //   4: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h : Z
    //   7: ifeq -> 43
    //   10: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : Lio/papermc/paper/threadedregions/scheduler/ScheduledTask;
    //   13: ifnull -> 43
    //   16: goto -> 23
    //   19: invokestatic a : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   22: athrow
    //   23: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : Lio/papermc/paper/threadedregions/scheduler/ScheduledTask;
    //   26: invokeinterface cancel : ()Lio/papermc/paper/threadedregions/scheduler/ScheduledTask$CancelledState;
    //   31: pop
    //   32: aconst_null
    //   33: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : Lio/papermc/paper/threadedregions/scheduler/ScheduledTask;
    //   36: goto -> 81
    //   39: invokestatic a : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   42: athrow
    //   43: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h : Z
    //   46: ifne -> 81
    //   49: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f : Lorg/bukkit/scheduler/BukkitTask;
    //   52: ifnull -> 81
    //   55: goto -> 62
    //   58: invokestatic a : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   61: athrow
    //   62: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f : Lorg/bukkit/scheduler/BukkitTask;
    //   65: invokeinterface cancel : ()V
    //   70: aconst_null
    //   71: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f : Lorg/bukkit/scheduler/BukkitTask;
    //   74: goto -> 81
    //   77: invokestatic a : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   80: athrow
    //   81: iconst_0
    //   82: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Z
    //   85: return
    // Exception table:
    //   from	to	target	type
    //   0	16	19	java/lang/MatchException
    //   10	39	39	java/lang/MatchException
    //   43	55	58	java/lang/MatchException
    //   49	74	77	java/lang/MatchException
  }
  
  private static void lambda$startHeartbeat$1() {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(false);
  }
  
  private static void lambda$startHeartbeat$0(ScheduledTask paramScheduledTask) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(false);
  }

  
  private static Throwable a(Throwable paramThrowable) {
    return paramThrowable;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bw.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */