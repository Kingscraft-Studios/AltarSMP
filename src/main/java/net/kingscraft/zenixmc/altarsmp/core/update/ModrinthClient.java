package net.kingscraft.zenixmc.altarsmp.core.update;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ModrinthClient {
    private static final String PROJECT_ID = "DAFLO9lU";
    private static final String API_URL = "https://api.modrinth.com/v2/project/" + PROJECT_ID + "/version";

    public UpdateVersion fetchLatest(String currentVersion) throws IOException {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(API_URL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "AltarSMP-UpdateChecker");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new IOException("Failed to fetch updates: HTTP " + responseCode);
            }

            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
            }

            JsonElement element = JsonParser.parseString(sb.toString());
            if (!element.isJsonArray()) {
                return null;
            }

            JsonArray array = element.getAsJsonArray();
            if (array.isEmpty()) {
                return null;
            }

            JsonObject latest = array.get(0).getAsJsonObject();
            String latestVersion = latest.has("version_number") ? latest.get("version_number").getAsString() : "";
            String name = latest.has("name") ? latest.get("name").getAsString() : latestVersion;
            String changelog = latest.has("changelog") ? latest.get("changelog").getAsString() : "";
            String downloadUrl = null;
            if (latest.has("files") && latest.get("files").isJsonArray()) {
                JsonArray files = latest.get("files").getAsJsonArray();
                for (JsonElement f : files) {
                    if (f.isJsonObject()) {
                        JsonObject fo = f.getAsJsonObject();
                        if (fo.has("primary") && fo.get("primary").getAsBoolean() && fo.has("url")) {
                            downloadUrl = fo.get("url").getAsString();
                            break;
                        }
                    }
                }
                if (downloadUrl == null && !files.isEmpty() && files.get(0).isJsonObject()) {
                    JsonObject fo = files.get(0).getAsJsonObject();
                    if (fo.has("url")) {
                        downloadUrl = fo.get("url").getAsString();
                    }
                }
            }

            if (VersionComparator.isNewer(currentVersion, latestVersion)) {
                return new UpdateVersion(latestVersion, name, changelog, downloadUrl);
            }
            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
