package pl;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ax implements Listener {
  private static final Set<Material> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  private final Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  public final Map<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new HashMap<>();
  
  public final Set<Player> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = Collections.newSetFromMap(new WeakHashMap<>());
  
  private final Map<Player, Boolean> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = new WeakHashMap<>();
  
  private BukkitTask You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  private BukkitTask You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  public boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  
  private static final String a;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ax(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = paramMain;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.getConfig().getBoolean(a, true);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b() {
    for (Player player : Bukkit.getOnlinePlayers())
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player); 
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c() {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e();
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f6(this)).runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, 0L, 1L);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f7(this)).runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, 0L, 10L);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerJoinEvent paramPlayerJoinEvent) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayerJoinEvent.getPlayer());
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerQuitEvent paramPlayerQuitEvent) {
    Player player = paramPlayerQuitEvent.getPlayer();
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(player);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.remove(player);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(player.getUniqueId());
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerMoveEvent paramPlayerMoveEvent) {
    try {
      if (paramPlayerMoveEvent.getTo() == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramPlayerMoveEvent.getFrom().getBlockX() == paramPlayerMoveEvent.getTo().getBlockX())
        try {
          if (paramPlayerMoveEvent.getFrom().getBlockY() == paramPlayerMoveEvent.getTo().getBlockY())
            try {
              if (paramPlayerMoveEvent.getFrom().getBlockZ() == paramPlayerMoveEvent.getTo().getBlockZ())
                return; 
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Player player = paramPlayerMoveEvent.getPlayer();
    try {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.contains(player))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, true);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(paramPlayer)) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.add(paramPlayer);
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.putIfAbsent(paramPlayer, Boolean.valueOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer)));
      } else {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(paramPlayer);
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.remove(paramPlayer);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, boolean paramBoolean) {
    try {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.contains(paramPlayer))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    boolean bool1 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
    boolean bool2 = ((Boolean)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getOrDefault(paramPlayer, Boolean.valueOf(false))).booleanValue();
    try {
      if (paramBoolean)
        try {
          if (bool1 == bool2) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer, bool1);
            return;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.put(paramPlayer, Boolean.valueOf(bool1));
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer, bool1);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer, boolean paramBoolean) {
    try {
      if (paramBoolean) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, PotionEffectType.SPEED, 60, 3);
      } else {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, PotionEffectType.SPEED, 60, 2);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h)
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, PotionEffectType.FIRE_RESISTANCE, 60, 0); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer, boolean paramBoolean) {
    try {
      if (paramBoolean) {
        paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 3, false, false, false));
      } else {
        paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 2, false, false, false));
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h)
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, PotionEffectType.FIRE_RESISTANCE, 60, 0); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, PotionEffectType paramPotionEffectType, int paramInt1, int paramInt2) {
    PotionEffect potionEffect = paramPlayer.getPotionEffect(paramPotionEffectType);
    try {
      if (potionEffect != null)
        try {
          if (potionEffect.getAmplifier() == paramInt2)
            try {
              if (potionEffect.getDuration() > 20)
                return; 
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramPlayer.addPotionEffect(new PotionEffect(paramPotionEffectType, paramInt1, paramInt2, false, false, false));
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getBoots();
    try {
      if (itemStack == null)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemStack.getType() != Material.NETHERITE_BOOTS)
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
      if (itemMeta != null)
        try {
          if (itemMeta.hasCustomModelData())
            try {
              if (itemMeta.getCustomModelData() == 1);
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return false;
  }
  
  public boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    Block block = paramPlayer.getLocation().getBlock().getRelative(0, -1, 0);
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.contains(block.getType());
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f() {
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f != null) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.cancel();
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = null;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g != null) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.cancel();
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = null;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  static {
    a = "enableFireResistanceOnBoots";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = EnumSet.of(Material.COPPER_BLOCK, Material.CUT_COPPER, Material.EXPOSED_COPPER, Material.EXPOSED_CUT_COPPER, Material.WEATHERED_COPPER, Material.WEATHERED_CUT_COPPER, Material.OXIDIZED_COPPER, Material.OXIDIZED_CUT_COPPER, Material.WAXED_COPPER_BLOCK, Material.WAXED_CUT_COPPER, Material.WAXED_EXPOSED_COPPER, Material.WAXED_EXPOSED_CUT_COPPER, Material.WAXED_WEATHERED_COPPER, Material.WAXED_WEATHERED_CUT_COPPER, Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_CUT_COPPER);
}

  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ax.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */