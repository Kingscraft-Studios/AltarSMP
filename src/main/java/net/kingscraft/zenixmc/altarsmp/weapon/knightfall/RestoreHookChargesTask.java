package net.kingscraft.zenixmc.altarsmp.weapon.knightfall;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;

public class RestoreHookChargesTask extends BukkitRunnable {
  public final Player player;

  public final int cooldownSeconds;

  private static final Component HOOK_LABEL = Component.text()
      .append(Component.text("Grappling Hook ", NamedTextColor.YELLOW, TextDecoration.BOLD))
      .append(Component.text("x", NamedTextColor.GOLD, TextDecoration.BOLD))
      .build();

  public RestoreHookChargesTask(Player paramPlayer, int paramInt) {
        this.player = paramPlayer;
        this.cooldownSeconds = paramInt;
    }

  public void run() {
    KnightfallListener.hookCharges.put(this.player.getUniqueId(), KnightfallListener.hookCharges.getOrDefault(this.player.getUniqueId(), 1) - 1);
    int i = KnightfallListener.hookCharges.getOrDefault(this.player.getUniqueId(), 1);
      KnightfallListener.showHookCharges(this.player);
      if (i > 0) {
        BossBarManager.createBar(this.player, LegacyComponentSerializer.legacySection().serialize(HOOK_LABEL.append(Component.text(i))), this.cooldownSeconds, NamedTextColor.YELLOW);
        KnightfallListener.startHookCooldown(this.player, this.cooldownSeconds);
      }
  }
}
