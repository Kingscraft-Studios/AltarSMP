package pl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Transformation;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi implements Listener, CommandExecutor {
  public final HashMap<UUID, ItemDisplay> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = new HashMap<>();
  
  public final HashMap<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new HashMap<>();
  
  protected NamespacedKey You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new NamespacedKey((Plugin)Main.getPlugin(Main.class), a(10245, -2920));
  
  private static final String[] a;
  
  private static final String[] b;
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0() {
    int i = Main.getInstance().getConfig().getInt(a(10256, 15926), 60);
    int j = Main.getInstance().getConfig().getInt(a(10255, 32471), 30) * 60 * 20;
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gh(this, j, i)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b() {
    UUID uUID = null;
    int i = -1;
    for (Map.Entry<UUID, Integer> entry : this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.entrySet()) {
      if (((Integer)entry.getValue()).intValue() > i) {
        i = ((Integer)entry.getValue()).intValue();
        uUID = (UUID)entry.getKey();
      } 
    } 
    Main.getInstance().getConfig().set(a(10246, 22247), Boolean.valueOf(false));
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
    if (uUID != null) {
      Player player = Bukkit.getPlayer(uUID);
      try {
      
      } catch (MatchException matchException) {
        throw a(null);
      } 
      String str1 = (player != null) ? player.getName() : Bukkit.getOfflinePlayer(uUID).getName();
      Bukkit.broadcastMessage(String.valueOf(ChatColor.of(a(10268, 10996))) + String.valueOf(ChatColor.of(a(10268, 10996))) + ChatColor.BOLD.toString() + str1);
      String str2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ch.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(i);
      String str3 = String.valueOf(ChatColor.of(a(10268, 10996)));
      try {
        Bukkit.broadcastMessage(a(10253, 22607) + a(10253, 22607) + str3);
        if (player != null && player.isOnline()) {
          ItemStack itemStack1 = player.getInventory().getLeggings();
          player.getInventory().setLeggings(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764E());
          player.getInventory().addItem(new ItemStack[] { itemStack1 });
          player.sendMessage(String.valueOf(ChatColor.of(a(10268, 10996))) + String.valueOf(ChatColor.of(a(10268, 10996))) + ChatColor.BOLD.toString());
          ItemStack itemStack2 = null;
          for (ItemStack itemStack : player.getInventory().getContents()) {
            if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack)) {
              itemStack2 = itemStack;
              break;
            } 
          } 
          try {
            if (itemStack2 != null)
              player.getInventory().removeItem(new ItemStack[] { itemStack2 }); 
          } catch (MatchException matchException) {
            throw a(null);
          } 
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.clear();
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawn(paramPlayer.getEyeLocation().clone().add(0.0D, 1.0D, 0.0D), ItemDisplay.class, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi::lambda$spawnDisplay$0);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.put(paramPlayer.getUniqueId(), itemDisplay);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, double paramDouble) {
    ItemDisplay itemDisplay = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.get(paramPlayer.getUniqueId());
    try {
      if (itemDisplay == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    double d1 = Math.cos(paramDouble) * 0.6D;
    double d2 = Math.sin(paramDouble) * 0.6D;
    double d3 = 0.5D + Math.sin(paramDouble * 0.5D) * 0.2D;
    Location location = paramPlayer.getEyeLocation().add(d1, d3 + 2.0D, d2);
    location.setYaw((float)Math.toDegrees(paramDouble));
    itemDisplay.setTeleportDuration(1);
    itemDisplay.setInterpolationDuration(1);
    itemDisplay.setInterpolationDelay(0);
    itemDisplay.teleport(location);
    location.getWorld().spawnParticle(Particle.FLAME, location, 2, 0.5D, 0.3D, 0.5D, 0.0D);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    ItemDisplay itemDisplay = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.remove(paramPlayer.getUniqueId());
    try {
      if (itemDisplay != null)
        itemDisplay.remove(); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.values().forEach(Entity::remove);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.clear();
    for (Player player : Bukkit.getOnlinePlayers()) {
      ItemStack itemStack = null;
      for (ItemStack itemStack1 : player.getInventory().getContents()) {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack1)) {
          itemStack = itemStack1;
          break;
        } 
      } 
      try {
        if (itemStack != null)
          player.getInventory().removeItem(new ItemStack[] { itemStack }); 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ServerLoadEvent paramServerLoadEvent) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
  }
  
  public String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(World paramWorld) {
    String str = paramWorld.getName();
    byte b = -1;
    try {
      switch (str.hashCode()) {
        case 113318802:
          if (str.equals(a(10241, 13501)))
            b = 0; 
          break;
        case 1865466277:
          if (str.equals(a(10240, -28387)))
            b = 1; 
          break;
        case -1198266272:
          if (str.equals(a(10247, -27073)))
            b = 2; 
          break;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      switch (b) {
        case 0:
          return a(10243, 19639);
        case 1:
          return a(10251, -1330);
        case 2:
          return a(10242, 26735);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return paramWorld.getName();
  }
  
  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String[] paramArrayOfString) {
    Player player;
    if (paramCommandSender instanceof Player) {
      player = (Player)paramCommandSender;
    } else {
      return true;
    } 
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.clear();
    Main.getInstance().getConfig().set(a(10254, 26469), Boolean.valueOf(true));
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(player);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    return false;
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d() {
    int i = Main.getInstance().getConfig().getInt(a(10263, -11041), 30) * 60;
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0F, 1.0F);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(String.valueOf(ChatColor.of(a(10268, 10996))) + String.valueOf(ChatColor.of(a(10268, 10996))), i, BarColor.PINK);
    } 
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    Location location = paramPlayer.getEyeLocation();
    String str1 = String.valueOf(ChatColor.of(a(10268, 10996)));
    int i = location.getBlockZ();
    int j = location.getBlockY();
    int k = location.getBlockX();
    String str2 = ChatColor.of(a(10268, 10996)).toString();
    String str3 = String.valueOf(ChatColor.of(a(10268, 10996)));
    Bukkit.broadcastMessage(a(10270, 14385) + a(10270, 14385) + str3 + a(10252, -2016) + str2 + a(10269, 30778) + k + a(10262, 22329) + j + a(10244, -13672) + i + a(10266, -184) + str1);
    location.setYaw(0.0F);
    location.setPitch(0.0F);
    location.getWorld().spawn(location.clone().add(0.0D, 2.0D, 0.0D), ItemDisplay.class, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi::lambda$spawnCore$1);
    Interaction interaction = (Interaction)location.getWorld().spawnEntity(location.clone().add(0.0D, 1.0D, 0.0D), EntityType.INTERACTION);
    interaction.setInteractionWidth(1.2F);
    interaction.setInteractionHeight(1.2F);
    interaction.getPersistentDataContainer().set(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, PersistentDataType.STRING, a(10259, -30372));
  }
  
  private static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    ItemStack itemStack = new ItemStack(Material.HEAVY_CORE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(998));
    itemMeta.addEnchant(Enchantment.BREACH, 1, true);
    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    itemMeta.setDisplayName(String.valueOf(ChatColor.of(a(10268, 10996))) + String.valueOf(ChatColor.of(a(10268, 10996))));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractAtEntityEvent paramPlayerInteractAtEntityEvent) {
    Interaction interaction;
    Entity entity = paramPlayerInteractAtEntityEvent.getRightClicked();
    if (entity instanceof Interaction) {
      interaction = (Interaction)entity;
    } else {
      return;
    } 
    try {
      if (paramPlayerInteractAtEntityEvent.getRightClicked().getPersistentDataContainer().get(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, PersistentDataType.STRING) != a(10248, -23115))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramPlayerInteractAtEntityEvent.getPlayer().getInventory().addItem(new ItemStack[] { You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() });
    Bukkit.broadcastMessage(String.valueOf(ChatColor.of(a(10268, 10996))) + String.valueOf(ChatColor.of(a(10268, 10996))) + a(10261, 7676) + paramPlayerInteractAtEntityEvent.getPlayer().getName());
    for (Entity entity1 : paramPlayerInteractAtEntityEvent.getRightClicked().getNearbyEntities(2.0D, 2.0D, 2.0D)) {
      try {
        if (entity1 instanceof ItemDisplay) {
          entity1.remove();
          interaction.remove();
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player1;
    Player player2;
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      player1 = (Player)entity;
      entity = paramEntityDamageByEntityEvent.getEntity();
      if (entity instanceof Player) {
        player2 = (Player)entity;
      } else {
        return;
      } 
    } else {
      return;
    } 
    for (ItemStack itemStack : player2.getInventory().getContents()) {
      try {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack)) {
          player2.getInventory().removeItem(new ItemStack[] { itemStack });
          player1.getInventory().addItem(new ItemStack[] { You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() });
          Bukkit.broadcastMessage(String.valueOf(ChatColor.of(a(10258, -17644))) + String.valueOf(ChatColor.of(a(10258, -17644))) + a(10249, 1764) + player1.getName());
          break;
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerQuitEvent paramPlayerQuitEvent) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayerQuitEvent.getPlayer());
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerDeathEvent paramPlayerDeathEvent) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayerDeathEvent.getEntity());
  }
  
  public boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ItemStack paramItemStack) {
    try {
      if (paramItemStack != null) {
        try {
          if (!paramItemStack.hasItemMeta())
            return false; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } else {
        return false;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramItemStack.getType() == Material.HEAVY_CORE)
        try {
          if (paramItemStack.getItemMeta().getCustomModelData() == 998);
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return false;
  }
  
  private static void lambda$spawnCore$1(ItemDisplay paramItemDisplay) {
    paramItemDisplay.setItemStack(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a());
    paramItemDisplay.setBrightness(new Display.Brightness(15, 15));
  }
  
  private static void lambda$spawnDisplay$0(ItemDisplay paramItemDisplay) {
    paramItemDisplay.setItemStack(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a());
    paramItemDisplay.setBrightness(new Display.Brightness(15, 15));
    paramItemDisplay.setTransformation(new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new Quaternionf(), new Vector3f(0.8F, 0.8F, 0.8F), new Quaternionf()));
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  static {
    // Byte code:
    //   0: bipush #32
    //   2: anewarray java/lang/String
    //   5: astore #5
    //   7: iconst_0
    //   8: istore_3
    //   9: ldc '@ì$·u½sò3ÂÞàæ`ÁuzeEºVyKÞØÝÍÉÁ!CÊÃëÖ¤ ÖKkzÛ£Ì/füÎp÷)ËeÌ5lJ£@ò&ß5JífÐÕ=&[á¢üSkQë¹s2´'EM5ò½,¨³ßÑERÚÌ_\\fQ&ím½ýCN@q!á¦÷s+à\\fb¶AÊÖÂ)\\t>:¿$xõ¾±Mý´ÉzÊ9×!\\r4ïu¨ÒÒ^qÌ_ÎSaCQÛé §¯¤N&Éz!­uWhh}ñíG_ª@P°ØcÇC?þó÷ÛSEv*ZÁ/ë}·Xaå&¶TÓ2*úN>Ñ@fÄ£«4a'îJS÷JÁPñuIærüÊ}{Aù.Thª¨w¥§bQFæhçè[o>0ï0Ê·3:²}^ç=ìtËb-¸øë\\bÕxÒ^oCB|4üâ-/Xt»? c´¢p\\bs8öQK´â¢õEOúMjñ\\n¿ò²VOéü)¼@âÎªG¹gU¾¨wxìç±êùbõí(è\\n ºm\\b_PÚnkà¥7^ýoÒ¤áH#t O8Ãö3ý¢Èòò.vÕ°Th|~»3KgÕÁ,{38¸Æ'
    //   11: dup
    //   12: astore_2
    //   13: invokevirtual length : ()I
    //   16: istore #4
    //   18: bipush #11
    //   20: istore_1
    //   21: iconst_m1
    //   22: istore_0
    //   23: bipush #96
    //   25: iinc #0, 1
    //   28: aload_2
    //   29: iload_0
    //   30: dup
    //   31: iload_1
    //   32: iadd
    //   33: invokevirtual substring : (II)Ljava/lang/String;
    //   36: iconst_m1
    //   37: goto -> 142
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
    //   68: ldc 'çàK:Yq\\f;Ä\k!É¦0U'
    //   70: dup
    //   71: astore_2
    //   72: invokevirtual length : ()I
    //   75: istore #4
    //   77: bipush #12
    //   79: istore_1
    //   80: iconst_m1
    //   81: istore_0
    //   82: iconst_3
    //   83: iinc #0, 1
    //   86: aload_2
    //   87: iload_0
    //   88: dup
    //   89: iload_1
    //   90: iadd
    //   91: invokevirtual substring : (II)Ljava/lang/String;
    //   94: iconst_0
    //   95: goto -> 142
    //   98: aload #5
    //   100: swap
    //   101: iload_3
    //   102: iinc #3, 1
    //   105: swap
    //   106: aastore
    //   107: iload_0
    //   108: iload_1
    //   109: iadd
    //   110: dup
    //   111: istore_0
    //   112: iload #4
    //   114: if_icmpge -> 126
    //   117: aload_2
    //   118: iload_0
    //   119: invokevirtual charAt : (I)C
    //   122: istore_1
    //   123: goto -> 82
    //   126: aload #5
    //   128: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi.a : [Ljava/lang/String;
    //   131: bipush #32
    //   133: anewarray java/lang/String
    //   136: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi.b : [Ljava/lang/String;
    //   139: goto -> 300
    //   142: dup_x2
    //   143: pop
    //   144: invokevirtual toCharArray : ()[C
    //   147: dup_x1
    //   148: arraylength
    //   149: dup_x2
    //   150: pop
    //   151: iconst_0
    //   152: istore #6
    //   154: dup2_x1
    //   155: pop2
    //   156: dup_x2
    //   157: iconst_1
    //   158: if_icmpgt -> 260
    //   161: dup2
    //   162: swap
    //   163: iload #6
    //   165: dup2_x1
    //   166: caload
    //   167: swap
    //   168: iload #6
    //   170: bipush #7
    //   172: irem
    //   173: tableswitch default -> 242, 0 -> 212, 1 -> 217, 2 -> 222, 3 -> 227, 4 -> 232, 5 -> 237
    //   212: bipush #51
    //   214: goto -> 244
    //   217: bipush #54
    //   219: goto -> 244
    //   222: bipush #52
    //   224: goto -> 244
    //   227: bipush #45
    //   229: goto -> 244
    //   232: bipush #55
    //   234: goto -> 244
    //   237: bipush #21
    //   239: goto -> 244
    //   242: bipush #16
    //   244: ixor
    //   245: ixor
    //   246: i2c
    //   247: castore
    //   248: iinc #6, 1
    //   251: dup
    //   252: ifne -> 260
    //   255: dup2
    //   256: dup_x1
    //   257: goto -> 165
    //   260: dup2_x1
    //   261: pop2
    //   262: dup_x2
    //   263: iload #6
    //   265: if_icmpgt -> 161
    //   268: pop
    //   269: new java/lang/String
    //   272: dup_x1
    //   273: swap
    //   274: invokespecial <init> : ([C)V
    //   277: invokevirtual intern : ()Ljava/lang/String;
    //   280: swap
    //   281: pop
    //   282: swap
    //   283: tableswitch default -> 40, 0 -> 98
    //   300: return
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0x2809) & 0xFFFF;
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
      byte b1 = 104;
      int j = (paramInt2 & 0xFF) - b1;
      if (j < 0)
        j += 256; 
      int k = ((paramInt2 & 0xFFFF) >>> 8) - b1;
      if (k < 0)
        k += 256; 
      for (byte b2 = 0; b2 < arrayOfChar.length; b2++) {
        int m = b2 % 2;
        if (m == 0) {
          arrayOfChar[b2] = (char)(arrayOfChar[b2] ^ j);
          j = ((j >>> 3 | j << 5) ^ arrayOfChar[b2]) & 0xFF;
        } else {
          arrayOfChar[b2] = (char)(arrayOfChar[b2] ^ k);
          k = ((k >>> 3 | k << 5) ^ arrayOfChar[b2]) & 0xFF;
        } 
      } 
      b[i] = (new String(arrayOfChar)).intern();
    } 
    return b[i];
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */