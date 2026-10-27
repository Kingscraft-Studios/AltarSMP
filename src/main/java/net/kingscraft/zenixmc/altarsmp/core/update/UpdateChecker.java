package net.kingscraft.zenixmc.altarsmp.core.update;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import java.util.concurrent.atomic.AtomicReference;

public class UpdateChecker {
    private final AltarSMP plugin;
    private final ModrinthClient client;
    private final AtomicReference<UpdateVersion> update = new AtomicReference<>();

    public UpdateChecker(AltarSMP plugin) {
        this.plugin = plugin;
        this.client = new ModrinthClient();
    }

    public void check() {
        try {
            String currentVersion = plugin.getPluginMeta().getVersion();
            UpdateVersion latest = client.fetchLatest(currentVersion);
            if (latest != null) {
                update.set(latest);
                plugin.getLogger().info("A new update is available! Current: " + currentVersion + ", Latest: " + latest.version());
                plugin.getLogger().info("Download: https://modrinth.com/plugin/DAFLO9lU/version/" + latest.version());
            } else {
                plugin.getLogger().info("You are running the latest version of AltarSMP!");
            }
        } catch (Exception e) {
            plugin.getLogger().warning("Failed to check for updates: " + e.getMessage());
        }
    }

    public UpdateVersion getUpdate() {
        return update.get();
    }

    public boolean hasUpdate() {
        return update.get() != null;
    }
}
