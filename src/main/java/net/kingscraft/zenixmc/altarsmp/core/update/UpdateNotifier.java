package net.kingscraft.zenixmc.altarsmp.core.update;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UpdateNotifier implements Listener {
    private final UpdateChecker checker;

    public UpdateNotifier(UpdateChecker checker) {
        this.checker = checker;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().isOp()) {
            return;
        }
        UpdateVersion update = checker.getUpdate();
        if (update != null) {
            Player player = event.getPlayer();
            player.sendMessage(Component.text("[AltarSMP] ", NamedTextColor.GOLD).append(Component.text("A new update is available! (v" + update.version() + ")",
                    NamedTextColor.YELLOW)));

            player.sendMessage(Component.text("[AltarSMP] ", NamedTextColor.GOLD).append(Component.text("Download it here: ", NamedTextColor.WHITE)
                            .append(Component.text("https://modrinth.com/plugin/DAFLO9lU", NamedTextColor.AQUA).clickEvent(ClickEvent.openUrl("https://modrinth.com/plugin/DAFLO9lU")))));
        }
    }
}
