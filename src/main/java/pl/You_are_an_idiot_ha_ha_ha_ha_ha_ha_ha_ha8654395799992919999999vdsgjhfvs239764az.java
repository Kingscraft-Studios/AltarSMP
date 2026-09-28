package pl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764az implements Listener {
  public final Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public final Map<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new HashMap<>();
  
  public BukkitTask You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  static final int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764az(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ga(this)).runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 0L, 20L);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getHelmet();
    try {
      if (itemStack == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemStack.getType() != Material.NETHERITE_HELMET)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemStack.hasItemMeta())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    ItemMeta itemMeta = itemStack.getItemMeta();
    try {
      if (itemMeta == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemMeta.hasCustomModelData())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
    
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return (itemMeta.getCustomModelData() == 1);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    UUID uUID = paramPlayer.getUniqueId();
    if (paramPlayer.isSneaking()) {
      int i = ((Integer)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.getOrDefault(uUID, Integer.valueOf(0))).intValue() + 1;
      try {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(uUID, Integer.valueOf(i));
        if (i <= 4) {
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_TRIAL_SPAWNER_CLOSE_SHUTTER, 1.0F, 1.0F);
        } else if (i >= 5) {
          this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(uUID, Integer.valueOf(0));
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_TRIAL_SPAWNER_CLOSE_SHUTTER, 1.0F, 1.0F);
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1.0F, 1.0F);
          paramPlayer.getWorld().strikeLightning(paramPlayer.getLocation());
          for (Player player : paramPlayer.getLocation().getNearbyPlayers(50.0D)) {
            try {
              if (!player.getUniqueId().equals(uUID))
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 600, 1)); 
            } catch (MatchException matchException) {
              throw a(null);
            } 
          } 
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } else {
      this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(uUID, Integer.valueOf(0));
    } 
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 200, 0));
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 200, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d));
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerQuitEvent paramPlayerQuitEvent) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.remove(paramPlayerQuitEvent.getPlayer().getUniqueId());
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b() {
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c != null)
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.cancel(); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.clear();
  }
  
  static {
    // Byte code:
    //   0: bipush #115
    //   2: ldc '-dU.z+gDF<nD4s#{V5W<'
    //   4: iconst_m1
    //   5: goto -> 12
    //   8: astore_0
    //   9: goto -> 154
    //   12: dup_x2
    //   13: pop
    //   14: invokevirtual toCharArray : ()[C
    //   17: dup_x1
    //   18: arraylength
    //   19: dup_x2
    //   20: pop
    //   21: iconst_0
    //   22: istore_1
    //   23: dup2_x1
    //   24: pop2
    //   25: dup_x2
    //   26: iconst_1
    //   27: if_icmpgt -> 128
    //   30: dup2
    //   31: swap
    //   32: iload_1
    //   33: dup2_x1
    //   34: caload
    //   35: swap
    //   36: iload_1
    //   37: bipush #7
    //   39: irem
    //   40: tableswitch default -> 110, 0 -> 80, 1 -> 85, 2 -> 90, 3 -> 95, 4 -> 100, 5 -> 105
    //   80: bipush #61
    //   82: goto -> 112
    //   85: bipush #120
    //   87: goto -> 112
    //   90: bipush #8
    //   92: goto -> 112
    //   95: bipush #8
    //   97: goto -> 112
    //   100: bipush #67
    //   102: goto -> 112
    //   105: bipush #47
    //   107: goto -> 112
    //   110: bipush #65
    //   112: ixor
    //   113: ixor
    //   114: i2c
    //   115: castore
    //   116: iinc #1, 1
    //   119: dup
    //   120: ifne -> 128
    //   123: dup2
    //   124: dup_x1
    //   125: goto -> 33
    //   128: dup2_x1
    //   129: pop2
    //   130: dup_x2
    //   131: iload_1
    //   132: if_icmpgt -> 30
    //   135: pop
    //   136: new java/lang/String
    //   139: dup_x1
    //   140: swap
    //   141: invokespecial <init> : ([C)V
    //   144: invokevirtual intern : ()Ljava/lang/String;
    //   147: swap
    //   148: pop
    //   149: swap
    //   150: pop
    //   151: goto -> 8
    //   154: invokestatic getInstance : ()Lpl/Main;
    //   157: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   160: aload_0
    //   161: iconst_1
    //   162: invokevirtual getInt : (Ljava/lang/String;I)I
    //   165: iconst_1
    //   166: isub
    //   167: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764az.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d : I
    //   170: return
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764az.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */