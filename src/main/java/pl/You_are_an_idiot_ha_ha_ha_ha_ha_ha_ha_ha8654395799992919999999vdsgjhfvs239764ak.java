package pl;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ak implements Listener {
  public static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  public static final HashMap<UUID, LivingEntity> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  public static final int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  public static final double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  public static final int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  
  public static HashSet<UUID> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i;
  
  
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    {
      if (itemStack.getType() != Material.NETHERITE_SWORD)
        return false; 
    }{
      if (!itemStack.hasItemMeta())
        return false; 
    }ItemMeta itemMeta = itemStack.getItemMeta();
    {
      if (itemMeta == null)
        return false; 
    }{
      if (!itemMeta.hasCustomModelData())
        return false; 
    }{
    
    }return (itemMeta.getCustomModelData() == 8);
  }
  
  @EventHandler
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    LivingEntity livingEntity;
    Entity entity1 = paramEntityDamageByEntityEvent.getDamager();
    if (entity1 instanceof Player) {
      player = (Player)entity1;
    } else {
      return;
    } 
    Entity entity2 = paramEntityDamageByEntityEvent.getEntity();
    if (entity2 instanceof LivingEntity) {
      livingEntity = (LivingEntity)entity2;
    } else {
      return;
    } 
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player))
        return; 
    }if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), "used_meteor")) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), "used_meteor", 0.0D);
      Location location = livingEntity.getLocation().add(0.0D, 1.0D, 0.0D);
      livingEntity.getWorld().spawnParticle(Particle.GUST_EMITTER_LARGE, location, 1, 0.0D, 0.0D, 0.0D, 0.0D);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a6.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location);
      livingEntity.getWorld().spawnParticle(Particle.FLAME, location, 60, 0.1D, 0.1D, 0.1D, 0.1D);
      livingEntity.getWorld().playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
      paramEntityDamageByEntityEvent.setDamage(paramEntityDamageByEntityEvent.getDamage() + You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h);
      livingEntity.setVelocity(player.getLocation().getDirection().multiply(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g));
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, "Meteor Strike", You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, ChatColor.YELLOW);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 10, 3, false, false, true));
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BREEZE_INHALE, 1.0F, 1.0F);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d9(paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d_(paramPlayer)).runTaskLater((Plugin)Main.getInstance(), 10L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getBlock : ()Lorg/bukkit/block/Block;
    //   4: astore_1
    //   5: aload_1
    //   6: invokeinterface getType : ()Lorg/bukkit/Material;
    //   11: getstatic org/bukkit/Material.MUD : Lorg/bukkit/Material;
    //   14: if_acmpne -> 22
    //   17: return
    //   18: invokestatic a : (Ljava/lang/MatchException;)Ljava/lang/MatchException;
    //   21: athrow
    //   22: aload_1
    //   23: invokeinterface getBlockData : ()Lorg/bukkit/block/data/BlockData;
    //   28: invokeinterface clone : ()Lorg/bukkit/block/data/BlockData;
    //   33: astore_2
    //   34: aload_1
    //   35: getstatic org/bukkit/Material.MUD : Lorg/bukkit/Material;
    //   38: invokeinterface setType : (Lorg/bukkit/Material;)V
    //   43: invokestatic getScheduler : ()Lorg/bukkit/scheduler/BukkitScheduler;
    //   46: invokestatic getInstance : ()Lpl/Main;
    //   49: aload_1
    //   50: aload_2
    //   51: <illegal opcode> run : (Lorg/bukkit/block/Block;Lorg/bukkit/block/data/BlockData;)Ljava/lang/Runnable;
    //   56: ldc2_w 40
    //   59: invokeinterface runTaskLater : (Lorg/bukkit/plugin/Plugin;Ljava/lang/Runnable;J)Lorg/bukkit/scheduler/BukkitTask;
    //   64: pop
    //   65: return
    // Exception table:
    //   from	to	target	type
    //   5	18	18	java/lang/MatchException
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(LivingEntity paramLivingEntity, Player paramPlayer) {
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ec(paramLivingEntity, paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerJumpEvent paramPlayerJumpEvent) {
    Player player = paramPlayerJumpEvent.getPlayer();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.contains(player.getUniqueId()))
        return; 
    }(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ed(this, player)).runTaskLater((Plugin)Main.getInstance(), 1L);
    paramPlayerJumpEvent.setCancelled(true);
  }
  
  private static void lambda$makeMud$0(Block paramBlock, BlockData paramBlockData) {
    paramBlock.setBlockData(paramBlockData);
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = Main.getInstance().getConfig().getInt("EarthGauntletMeteorStrike", 30);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = Main.getInstance().getConfig().getInt("EarthGauntletMudslide", 18);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = "meteorStrike";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = "mudSlide";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = new HashMap<>();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = Main.getInstance().getConfig().getInt("meteorUseDuration", 10);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = (double)Main.getInstance().getConfig().getInt("meteorStrikeKnockback", 8);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = Main.getInstance().getConfig().getInt("meteorDamage", 14);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i = new HashSet<>();
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ak.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */