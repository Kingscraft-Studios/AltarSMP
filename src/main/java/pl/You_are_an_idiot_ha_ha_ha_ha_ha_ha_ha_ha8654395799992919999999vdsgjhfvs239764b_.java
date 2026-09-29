package pl;

import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b_ implements Listener {
  
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerJoinEvent paramPlayerJoinEvent) {
    {
      if (paramPlayerJoinEvent.getPlayer().isOp())
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayerJoinEvent.getPlayer()); 
    }}
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PluginEnableEvent paramPluginEnableEvent) {
    {
      if (!paramPluginEnableEvent.getPlugin().getName().equalsIgnoreCase(Main.getInstance().getName()))
        return; 
    }for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (player.isOp())
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player); 
      }} 
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    Bukkit.getAsyncScheduler().runNow((Plugin)Main.getInstance(), paramTask -> lambda$checkForUpdate$1(paramPlayer, paramTask));
  }
  
  private static void lambda$checkForUpdate$1(Player paramPlayer, ScheduledTask paramScheduledTask) {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: sipush #31067
    //   6: sipush #25074
    //   9: invokestatic a : (II)Ljava/lang/String;
    //   12: dup_x2
    //   13: pop
    //   14: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;J)Ljava/lang/String;
    //   19: astore_2
    //   20: new java/net/URL
    //   23: dup
    //   24: aload_2
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: astore_3
    //   29: new java/io/BufferedReader
    //   32: dup
    //   33: new java/io/InputStreamReader
    //   36: dup
    //   37: aload_3
    //   38: invokevirtual openStream : ()Ljava/io/InputStream;
    //   41: invokespecial <init> : (Ljava/io/InputStream;)V
    //   44: invokespecial <init> : (Ljava/io/Reader;)V
    //   47: astore #4
    //   49: aconst_null
    //   50: astore #5
    //   52: aload #4
    //   54: invokevirtual readLine : ()Ljava/lang/String;
    //   57: dup
    //   58: astore #6
    //   60: ifnull -> 104
    //   63: aload #6
    //   65: invokevirtual trim : ()Ljava/lang/String;
    //   68: astore #6
    //   70: aload #6
    //   72: sipush #31071
    //   75: sipush #-23565
    //   78: invokestatic a : (II)Ljava/lang/String;
    //   81: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   84: ifeq -> 52
    //   87: aload #6
    //   89: ldc ':'
    //   91: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   94: iconst_1
    //   95: aaload
    //   96: invokevirtual trim : ()Ljava/lang/String;
    //   99: astore #5
    //   101: goto -> 104
    //   104: aload #4
    //   106: invokevirtual close : ()V
    //   109: aload #5
    //   111: astore #7
    //   113: invokestatic getInstance : ()Lpl/Main;
    //   116: invokevirtual getDescription : ()Lorg/bukkit/plugin/PluginDescriptionFile;
    //   119: invokevirtual getVersion : ()Ljava/lang/String;
    //   122: astore #8
    //   124: aload #5
    //   126: aload #8
    //   128: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   131: ifne -> 166
    //   134: invokestatic getRegionScheduler : ()Lio/papermc/paper/threadedregions/scheduler/RegionScheduler;
    //   137: invokestatic getInstance : ()Lpl/Main;
    //   140: aload_0
    //   141: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   146: aload_0
    //   147: aload #7
    //   149: <illegal opcode> run : (Lorg/bukkit/entity/Player;Ljava/lang/String;)Ljava/lang/Runnable;
    //   154: invokeinterface execute : (Lorg/bukkit/plugin/Plugin;Lorg/bukkit/Location;Ljava/lang/Runnable;)V
    //   159: goto -> 166
    //   162: invokestatic a : (Ljava/lang/Exception;)Ljava/lang/Exception;
    //   165: athrow
    //   166: goto -> 198
    //   169: astore_2
    //   170: invokestatic getInstance : ()Lpl/Main;
    //   173: invokevirtual getLogger : ()Ljava/util/logging/Logger;
    //   176: aload_2
    //   177: invokevirtual getMessage : ()Ljava/lang/String;
    //   180: sipush #31068
    //   183: sipush #18738
    //   186: invokestatic a : (II)Ljava/lang/String;
    //   189: swap
    //   190: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   195: invokevirtual warning : (Ljava/lang/String;)V
    //   198: return
    // Exception table:
    //   from	to	target	type
    //   0	166	169	java/lang/Exception
    //   124	159	162	java/lang/Exception
  }
  
  private static void lambda$checkForUpdate$0(Player paramPlayer, String paramString) {
    paramPlayer.sendMessage(String.valueOf(ChatColor.GOLD) + String.valueOf(ChatColor.GOLD) + "[AltarSMP] A new version is available: v");
    paramPlayer.sendMessage(String.valueOf(ChatColor.AQUA) + String.valueOf(ChatColor.AQUA));
    paramPlayer.sendMessage(String.valueOf(ChatColor.YELLOW) + String.valueOf(ChatColor.YELLOW));
    paramPlayer.sendMessage(String.valueOf(ChatColor.YELLOW) + String.valueOf(ChatColor.YELLOW));
  }}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b_.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */