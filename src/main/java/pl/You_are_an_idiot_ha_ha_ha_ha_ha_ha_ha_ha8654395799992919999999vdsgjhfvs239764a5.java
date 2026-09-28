package pl;

import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5 {
  private static final String a;
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(LivingEntity paramLivingEntity, double paramDouble, Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLivingEntity, paramDouble, paramPlayer, false);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(LivingEntity paramLivingEntity, double paramDouble, Player paramPlayer, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface getHealth : ()D
    //   6: d2i
    //   7: istore #5
    //   9: aload_3
    //   10: invokeinterface getGameMode : ()Lorg/bukkit/GameMode;
    //   15: getstatic org/bukkit/GameMode.SPECTATOR : Lorg/bukkit/GameMode;
    //   18: if_acmpne -> 26
    //   21: return
    //   22: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   25: athrow
    //   26: aload_0
    //   27: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   32: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/Location;)Z
    //   35: ifne -> 57
    //   38: aload_3
    //   39: invokeinterface getLocation : ()Lorg/bukkit/Location;
    //   44: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/Location;)Z
    //   47: ifeq -> 62
    //   50: goto -> 57
    //   53: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   56: athrow
    //   57: return
    //   58: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   61: athrow
    //   62: aload_0
    //   63: instanceof org/bukkit/entity/Player
    //   66: ifeq -> 289
    //   69: aload_0
    //   70: checkcast org/bukkit/entity/Player
    //   73: astore #6
    //   75: iload #4
    //   77: ifne -> 102
    //   80: aload #6
    //   82: invokeinterface isBlocking : ()Z
    //   87: ifeq -> 102
    //   90: goto -> 97
    //   93: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   96: athrow
    //   97: return
    //   98: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   101: athrow
    //   102: aload #6
    //   104: invokeinterface getGameMode : ()Lorg/bukkit/GameMode;
    //   109: getstatic org/bukkit/GameMode.SPECTATOR : Lorg/bukkit/GameMode;
    //   112: if_acmpeq -> 135
    //   115: aload #6
    //   117: invokeinterface getGameMode : ()Lorg/bukkit/GameMode;
    //   122: getstatic org/bukkit/GameMode.CREATIVE : Lorg/bukkit/GameMode;
    //   125: if_acmpne -> 140
    //   128: goto -> 135
    //   131: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   134: athrow
    //   135: return
    //   136: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   139: athrow
    //   140: aload_3
    //   141: aload #6
    //   143: invokestatic isTrusted : (Lorg/bukkit/entity/Player;Lorg/bukkit/entity/Entity;)Z
    //   146: ifeq -> 154
    //   149: return
    //   150: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   153: athrow
    //   154: invokestatic getInstance : ()Lpl/Main;
    //   157: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   160: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.a : Ljava/lang/String;
    //   163: iconst_1
    //   164: invokevirtual getBoolean : (Ljava/lang/String;Z)Z
    //   167: ifne -> 182
    //   170: aload_0
    //   171: dload_1
    //   172: invokeinterface damage : (D)V
    //   177: return
    //   178: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   181: athrow
    //   182: aload #6
    //   184: invokeinterface getInventory : ()Lorg/bukkit/inventory/PlayerInventory;
    //   189: invokeinterface getItemInMainHand : ()Lorg/bukkit/inventory/ItemStack;
    //   194: invokevirtual getType : ()Lorg/bukkit/Material;
    //   197: astore #7
    //   199: aload #6
    //   201: invokeinterface getInventory : ()Lorg/bukkit/inventory/PlayerInventory;
    //   206: invokeinterface getItemInOffHand : ()Lorg/bukkit/inventory/ItemStack;
    //   211: invokevirtual getType : ()Lorg/bukkit/Material;
    //   214: astore #8
    //   216: aload #7
    //   218: getstatic org/bukkit/Material.TOTEM_OF_UNDYING : Lorg/bukkit/Material;
    //   221: if_acmpeq -> 239
    //   224: aload #8
    //   226: getstatic org/bukkit/Material.TOTEM_OF_UNDYING : Lorg/bukkit/Material;
    //   229: if_acmpne -> 280
    //   232: goto -> 239
    //   235: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   238: athrow
    //   239: iload #5
    //   241: i2d
    //   242: dload_1
    //   243: dcmpg
    //   244: ifgt -> 271
    //   247: goto -> 254
    //   250: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   253: athrow
    //   254: aload #6
    //   256: ldc2_w 200.0
    //   259: invokeinterface damage : (D)V
    //   264: goto -> 286
    //   267: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   270: athrow
    //   271: aload #6
    //   273: dload_1
    //   274: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/LivingEntity;D)V
    //   277: goto -> 286
    //   280: aload #6
    //   282: dload_1
    //   283: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/LivingEntity;D)V
    //   286: goto -> 294
    //   289: aload_0
    //   290: dload_1
    //   291: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/LivingEntity;D)V
    //   294: return
    // Exception table:
    //   from	to	target	type
    //   9	22	22	java/lang/MatchException
    //   26	50	53	java/lang/MatchException
    //   38	58	58	java/lang/MatchException
    //   75	90	93	java/lang/MatchException
    //   80	98	98	java/lang/MatchException
    //   102	128	131	java/lang/MatchException
    //   115	136	136	java/lang/MatchException
    //   140	150	150	java/lang/MatchException
    //   154	178	178	java/lang/MatchException
    //   216	232	235	java/lang/MatchException
    //   224	247	250	java/lang/MatchException
    //   239	267	267	java/lang/MatchException
  }
  
  private static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(LivingEntity paramLivingEntity, double paramDouble) {
    double d = 0.0D;
    if (paramLivingEntity.hasPotionEffect(PotionEffectType.ABSORPTION)) {
      d = paramLivingEntity.getAbsorptionAmount();
      paramLivingEntity.setAbsorptionAmount(Math.max(d - paramDouble, 0.0D));
      paramDouble = Math.max(paramDouble - d, 0.0D);
    } 
    Sound sound = paramLivingEntity.getHurtSound();
    try {
      if (sound != null)
        paramLivingEntity.getWorld().playSound(paramLivingEntity.getLocation(), sound, 1.0F, 1.0F); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramLivingEntity.setHealth(Math.max(paramLivingEntity.getHealth() - paramDouble, 0.0D));
    paramLivingEntity.playHurtAnimation(0.0F);
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  static {
    // Byte code:
    //   0: bipush #11
    //   2: ldc '~tyuKka'
    //   4: iconst_m1
    //   5: goto -> 14
    //   8: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.a : Ljava/lang/String;
    //   11: goto -> 153
    //   14: dup_x2
    //   15: pop
    //   16: invokevirtual toCharArray : ()[C
    //   19: dup_x1
    //   20: arraylength
    //   21: dup_x2
    //   22: pop
    //   23: iconst_0
    //   24: istore_0
    //   25: dup2_x1
    //   26: pop2
    //   27: dup_x2
    //   28: iconst_1
    //   29: if_icmpgt -> 127
    //   32: dup2
    //   33: swap
    //   34: iload_0
    //   35: dup2_x1
    //   36: caload
    //   37: swap
    //   38: iload_0
    //   39: bipush #7
    //   41: irem
    //   42: tableswitch default -> 109, 0 -> 80, 1 -> 84, 2 -> 89, 3 -> 94, 4 -> 99, 5 -> 104
    //   80: iconst_1
    //   81: goto -> 111
    //   84: bipush #13
    //   86: goto -> 111
    //   89: bipush #107
    //   91: goto -> 111
    //   94: bipush #23
    //   96: goto -> 111
    //   99: bipush #58
    //   101: goto -> 111
    //   104: bipush #33
    //   106: goto -> 111
    //   109: bipush #114
    //   111: ixor
    //   112: ixor
    //   113: i2c
    //   114: castore
    //   115: iinc #0, 1
    //   118: dup
    //   119: ifne -> 127
    //   122: dup2
    //   123: dup_x1
    //   124: goto -> 35
    //   127: dup2_x1
    //   128: pop2
    //   129: dup_x2
    //   130: iload_0
    //   131: if_icmpgt -> 32
    //   134: pop
    //   135: new java/lang/String
    //   138: dup_x1
    //   139: swap
    //   140: invokespecial <init> : ([C)V
    //   143: invokevirtual intern : ()Ljava/lang/String;
    //   146: swap
    //   147: pop
    //   148: swap
    //   149: pop
    //   150: goto -> 8
    //   153: return
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */