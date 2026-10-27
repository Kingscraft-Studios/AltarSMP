package net.kingscraft.zenixmc.altarsmp.core.update;

public class VersionComparator {
    public static boolean isNewer(String current, String latest) {
        if (current == null || latest == null) {
            return false;
        }
        if (current.equals(latest)) {
            return false;
        }
        String[] currentParts = current.replaceAll("[^0-9.]", "").split("\\.");
        String[] latestParts = latest.replaceAll("[^0-9.]", "").split("\\.");
        int maxLength = Math.max(currentParts.length, latestParts.length);
        for (int i = 0; i < maxLength; i++) {
            int currentVersion = i < currentParts.length && !currentParts[i].isEmpty() ? Integer.parseInt(currentParts[i]) : 0;
            int latestVersion = i < latestParts.length && !latestParts[i].isEmpty() ? Integer.parseInt(latestParts[i]) : 0;
            if (latestVersion > currentVersion) {
                return true;
            }
            if (latestVersion < currentVersion) {
                return false;
            }
        }
        return false;
    }
}
