package pl;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai implements Listener {
  public Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  private static final String[] a;
  
  private static final String[] b;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    try {
      if (itemStack == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemStack.getType() != Material.CROSSBOW)
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
    return (itemMeta.getCustomModelData() == 2);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractEvent paramPlayerInteractEvent) {
    Player player = paramPlayerInteractEvent.getPlayer();
    ItemStack itemStack = player.getInventory().getItemInMainHand();
    try {
      if (itemStack.getType() != Material.CROSSBOW)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemStack.hasItemMeta())
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    CrossbowMeta crossbowMeta = (CrossbowMeta)itemStack.getItemMeta();
    try {
      if (crossbowMeta != null) {
        try {
          if (!crossbowMeta.hasCustomModelData())
            return; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } else {
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!crossbowMeta.hasChargedProjectiles())
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) {
        try {
          if (paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            try {
              if (player.hasCooldown(Material.CROSSBOW))
                return; 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            paramPlayerInteractEvent.setCancelled(true);
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
            return;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (player.hasCooldown(Material.CROSSBOW))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramPlayerInteractEvent.setCancelled(true);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
  }
  
  public static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    ItemStack itemStack = new ItemStack(Material.PALE_OAK_LOG);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setItemModel(new NamespacedKey(a(-25578, -22930), a(-25582, -24167)));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    ArrayList arrayList = new ArrayList();
    int i = Main.getInstance().getConfig().getInt(a(-25580, 5512), 12);
    int j = Main.getInstance().getConfig().getInt(a(-25574, 2815), 3);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d3(paramPlayer, arrayList, i, j)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), a(-25583, -3635)))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    CrossbowMeta crossbowMeta = (CrossbowMeta)paramPlayer.getInventory().getItemInMainHand().getItemMeta();
    crossbowMeta.setChargedProjectiles(null);
    paramPlayer.getInventory().getItemInMainHand().setItemMeta((ItemMeta)crossbowMeta);
    paramPlayer.setVelocity(paramPlayer.getLocation().getDirection().normalize().multiply(-0.5D));
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 2.0F, 1.5F);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), a(-25576, 30990), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, a(-25584, -2324), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, ChatColor.YELLOW, BarColor.YELLOW);
    Location location = paramPlayer.getEyeLocation();
    Vector vector1 = location.getDirection().normalize();
    ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawnEntity(location, EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(new ItemStack(Material.RESIN_BLOCK));
    itemDisplay.setTransformation(new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new AxisAngle4f((float)Math.toRadians(90.0D), 1.0F, 0.0F, 0.0F), new Vector3f(0.75F, 0.75F, 0.75F), new AxisAngle4f(0.0F, 0.0F, 0.0F, 1.0F)));
    double d = Main.getInstance().getConfig().getInt(a(-25575, 7878), 2);
    Vector vector2 = vector1.multiply(d);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d5(this, vector2, itemDisplay, paramPlayer)).runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Player paramPlayer) {
    paramLocation = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, 3);
    World world = paramLocation.getWorld();
    world.playSound(paramLocation, Sound.ENTITY_GENERIC_EXPLODE, 2.0F, 1.0F);
    double d = Main.getInstance().getConfig().getDouble(a(-25577, 6438), 8.0D);
    paramLocation.getWorld().spawnParticle(Particle.ITEM, paramLocation, 200, 0.0D, 0.0D, 0.0D, 0.5D, new ItemStack(Material.RESIN_BLOCK));
    for (Entity entity : paramLocation.getNearbyEntities(5.0D, 5.0D, 5.0D)) {
      try {
        if (entity == paramPlayer)
          continue; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      try {
        if (!Main.isTrusted(paramPlayer, entity) && entity instanceof LivingEntity) {
          LivingEntity livingEntity = (LivingEntity)entity;
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity, d, paramPlayer);
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
    if (Main.getInstance().getConfig().getBoolean(a(-25579, 32298), true)) {
      AreaEffectCloud areaEffectCloud = (AreaEffectCloud)world.spawnEntity(paramLocation, EntityType.AREA_EFFECT_CLOUD);
      areaEffectCloud.setDuration(80);
      areaEffectCloud.setRadius(5.0F);
      areaEffectCloud.setRadiusOnUse(0.0F);
      areaEffectCloud.setRadiusPerTick(0.0F);
      areaEffectCloud.setWaitTime(0);
      areaEffectCloud.setReapplicationDelay(200);
      areaEffectCloud.addCustomEffect(new PotionEffect(PotionEffectType.LUCK, 12000, 1, true, false, true), true);
      areaEffectCloud.setParticle(Particle.ENTITY_EFFECT, Color.GRAY);
    } 
  }
  
  static {
    // Byte code:
    //   0: bipush #11
    //   2: anewarray java/lang/String
    //   5: astore #5
    //   7: iconst_0
    //   8: istore_3
    //   9: ldc 'Sæø|Ö5=zÏ\\n\\nÕ\\fòÆ%fÍë|øñ0É5êÅ®N¹ejÈ°ß²+"|U´ÎID3§ÜyÕfz¢mâ\\rå9Àm%\\rÆ5róDuÂ3Pæ\\n%uïYYÙ·\\nè>«gÿtsµ'
    //   11: dup
    //   12: astore_2
    //   13: invokevirtual length : ()I
    //   16: istore #4
    //   18: bipush #11
    //   20: istore_1
    //   21: iconst_m1
    //   22: istore_0
    //   23: bipush #49
    //   25: iinc #0, 1
    //   28: aload_2
    //   29: iload_0
    //   30: dup
    //   31: iload_1
    //   32: iadd
    //   33: invokevirtual substring : (II)Ljava/lang/String;
    //   36: iconst_m1
    //   37: goto -> 143
    //   40: aload #5
    //   42: swap
    //   43: iload_3
    //   44: iinc #3, 1
    //   47: swap
    //   48: aastore
    //   49: iload_0
    //   50: iload_1
    //   51: iadd
    //   52: dup
    //   53: istore_0
    //   54: iload #4
    //   56: if_icmpge -> 68
    //   59: aload_2
    //   60: iload_0
    //   61: invokevirtual charAt : (I)C
    //   64: istore_1
    //   65: goto -> 23
    //   68: ldc 'üÇ1@ÀñáQ%3\\r\\fb0 ·Lì'
    //   70: dup
    //   71: astore_2
    //   72: invokevirtual length : ()I
    //   75: istore #4
    //   77: bipush #9
    //   79: istore_1
    //   80: iconst_m1
    //   81: istore_0
    //   82: bipush #99
    //   84: iinc #0, 1
    //   87: aload_2
    //   88: iload_0
    //   89: dup
    //   90: iload_1
    //   91: iadd
    //   92: invokevirtual substring : (II)Ljava/lang/String;
    //   95: iconst_0
    //   96: goto -> 143
    //   99: aload #5
    //   101: swap
    //   102: iload_3
    //   103: iinc #3, 1
    //   106: swap
    //   107: aastore
    //   108: iload_0
    //   109: iload_1
    //   110: iadd
    //   111: dup
    //   112: istore_0
    //   113: iload #4
    //   115: if_icmpge -> 127
    //   118: aload_2
    //   119: iload_0
    //   120: invokevirtual charAt : (I)C
    //   123: istore_1
    //   124: goto -> 82
    //   127: aload #5
    //   129: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai.a : [Ljava/lang/String;
    //   132: bipush #11
    //   134: anewarray java/lang/String
    //   137: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai.b : [Ljava/lang/String;
    //   140: goto -> 300
    //   143: dup_x2
    //   144: pop
    //   145: invokevirtual toCharArray : ()[C
    //   148: dup_x1
    //   149: arraylength
    //   150: dup_x2
    //   151: pop
    //   152: iconst_0
    //   153: istore #6
    //   155: dup2_x1
    //   156: pop2
    //   157: dup_x2
    //   158: iconst_1
    //   159: if_icmpgt -> 260
    //   162: dup2
    //   163: swap
    //   164: iload #6
    //   166: dup2_x1
    //   167: caload
    //   168: swap
    //   169: iload #6
    //   171: bipush #7
    //   173: irem
    //   174: tableswitch default -> 242, 0 -> 212, 1 -> 217, 2 -> 222, 3 -> 227, 4 -> 232, 5 -> 237
    //   212: bipush #76
    //   214: goto -> 244
    //   217: bipush #62
    //   219: goto -> 244
    //   222: bipush #58
    //   224: goto -> 244
    //   227: bipush #88
    //   229: goto -> 244
    //   232: bipush #88
    //   234: goto -> 244
    //   237: bipush #44
    //   239: goto -> 244
    //   242: bipush #25
    //   244: ixor
    //   245: ixor
    //   246: i2c
    //   247: castore
    //   248: iinc #6, 1
    //   251: dup
    //   252: ifne -> 260
    //   255: dup2
    //   256: dup_x1
    //   257: goto -> 166
    //   260: dup2_x1
    //   261: pop2
    //   262: dup_x2
    //   263: iload #6
    //   265: if_icmpgt -> 162
    //   268: pop
    //   269: new java/lang/String
    //   272: dup_x1
    //   273: swap
    //   274: invokespecial <init> : ([C)V
    //   277: invokevirtual intern : ()Ljava/lang/String;
    //   280: swap
    //   281: pop
    //   282: swap
    //   283: tableswitch default -> 40, 0 -> 99
    //   300: invokestatic getInstance : ()Lpl/Main;
    //   303: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   306: sipush #-25581
    //   309: sipush #4734
    //   312: invokestatic a : (II)Ljava/lang/String;
    //   315: bipush #30
    //   317: invokevirtual getInt : (Ljava/lang/String;I)I
    //   320: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : I
    //   323: return
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0xFFFF9C10) & 0xFFFF;
    if (b[i] == null) {
      char[] arrayOfChar = a[i].toCharArray();
      switch (arrayOfChar[0] & 0xFF) {
        case 0:
        
        case 1:
        
        case 2:
        
        case 3:
        
        case 4:
        
        case 5:
        
        case 6:
        
        case 7:
        
        case 8:
        
        case 9:
        
        case 10:
        
        case 11:
        
        case 12:
        
        case 13:
        
        case 14:
        
        case 15:
        
        case 16:
        
        case 17:
        
        case 18:
        
        case 19:
        
        case 20:
        
        case 21:
        
        case 22:
        
        case 23:
        
        case 24:
        
        case 25:
        
        case 26:
        
        case 27:
        
        case 28:
        
        case 29:
        
        case 30:
        
        case 31:
        
        case 32:
        
        case 33:
        
        case 34:
        
        case 35:
        
        case 36:
        
        case 37:
        
        case 38:
        
        case 39:
        
        case 40:
        
        case 41:
        
        case 42:
        
        case 43:
        
        case 44:
        
        case 45:
        
        case 46:
        
        case 47:
        
        case 48:
        
        case 49:
        
        case 50:
        
        case 51:
        
        case 52:
        
        case 53:
        
        case 54:
        
        case 55:
        
        case 56:
        
        case 57:
        
        case 58:
        
        case 59:
        
        case 60:
        
        case 61:
        
        case 62:
        
        case 63:
        
        case 64:
        
        case 65:
        
        case 66:
        
        case 67:
        
        case 68:
        
        case 69:
        
        case 70:
        
        case 71:
        
        case 72:
        
        case 73:
        
        case 74:
        
        case 75:
        
        case 76:
        
        case 77:
        
        case 78:
        
        case 79:
        
        case 80:
        
        case 81:
        
        case 82:
        
        case 83:
        
        case 84:
        
        case 85:
        
        case 86:
        
        case 87:
        
        case 88:
        
        case 89:
        
        case 90:
        
        case 91:
        
        case 92:
        
        case 93:
        
        case 94:
        
        case 95:
        
        case 96:
        
        case 97:
        
        case 98:
        
        case 99:
        
        case 100:
        
        case 101:
        
        case 102:
        
        case 103:
        
        case 104:
        
        case 105:
        
        case 106:
        
        case 107:
        
        case 108:
        
        case 109:
        
        case 110:
        
        case 111:
        
        case 112:
        
        case 113:
        
        case 114:
        
        case 115:
        
        case 116:
        
        case 117:
        
        case 118:
        
        case 119:
        
        case 120:
        
        case 121:
        
        case 122:
        
        case 123:
        
        case 124:
        
        case 125:
        
        case 126:
        
        case 127:
        
        case 128:
        
        case 129:
        
        case 130:
        
        case 131:
        
        case 132:
        
        case 133:
        
        case 134:
        
        case 135:
        
        case 136:
        
        case 137:
        
        case 138:
        
        case 139:
        
        case 140:
        
        case 141:
        
        case 142:
        
        case 143:
        
        case 144:
        
        case 145:
        
        case 146:
        
        case 147:
        
        case 148:
        
        case 149:
        
        case 150:
        
        case 151:
        
        case 152:
        
        case 153:
        
        case 154:
        
        case 155:
        
        case 156:
        
        case 157:
        
        case 158:
        
        case 159:
        
        case 160:
        
        case 161:
        
        case 162:
        
        case 163:
        
        case 164:
        
        case 165:
        
        case 166:
        
        case 167:
        
        case 168:
        
        case 169:
        
        case 170:
        
        case 171:
        
        case 172:
        
        case 173:
        
        case 174:
        
        case 175:
        
        case 176:
        
        case 177:
        
        case 178:
        
        case 179:
        
        case 180:
        
        case 181:
        
        case 182:
        
        case 183:
        
        case 184:
        
        case 185:
        
        case 186:
        
        case 187:
        
        case 188:
        
        case 189:
        
        case 190:
        
        case 191:
        
        case 192:
        
        case 193:
        
        case 194:
        
        case 195:
        
        case 196:
        
        case 197:
        
        case 198:
        
        case 199:
        
        case 200:
        
        case 201:
        
        case 202:
        
        case 203:
        
        case 204:
        
        case 205:
        
        case 206:
        
        case 207:
        
        case 208:
        
        case 209:
        
        case 210:
        
        case 211:
        
        case 212:
        
        case 213:
        
        case 214:
        
        case 215:
        
        case 216:
        
        case 217:
        
        case 218:
        
        case 219:
        
        case 220:
        
        case 221:
        
        case 222:
        
        case 223:
        
        case 224:
        
        case 225:
        
        case 226:
        
        case 227:
        
        case 228:
        
        case 229:
        
        case 230:
        
        case 231:
        
        case 232:
        
        case 233:
        
        case 234:
        
        case 235:
        
        case 236:
        
        case 237:
        
        case 238:
        
        case 239:
        
        case 240:
        
        case 241:
        
        case 242:
        
        case 243:
        
        case 244:
        
        case 245:
        
        case 246:
        
        case 247:
        
        case 248:
        
        case 249:
        
        case 250:
        
        case 251:
        
        case 252:
        
        case 253:
        
        case 254:
        
        default:
          break;
      } 
      char c = 'Ê';
      int j = (paramInt2 & 0xFF) - c;
      if (j < 0)
        j += 256; 
      int k = ((paramInt2 & 0xFFFF) >>> 8) - c;
      if (k < 0)
        k += 256; 
      for (byte b = 0; b < arrayOfChar.length; b++) {
        int m = b % 2;
        if (m == 0) {
          arrayOfChar[b] = (char)(arrayOfChar[b] ^ j);
          j = ((j >>> 3 | j << 5) ^ arrayOfChar[b]) & 0xFF;
        } else {
          arrayOfChar[b] = (char)(arrayOfChar[b] ^ k);
          k = ((k >>> 3 | k << 5) ^ arrayOfChar[b]) & 0xFF;
        } 
      } 
      b[i] = (new String(arrayOfChar)).intern();
    } 
    return b[i];
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */