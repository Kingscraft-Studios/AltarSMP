package net.kingscraft.zenixmc.altarsmp.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class ColorUtil {

  private static final LegacyComponentSerializer LEGACY_AMPERSAND = LegacyComponentSerializer.builder()
      .character('&')
      .hexColors()
      .build();

  public static Component translateColors(String paramString) {
    if (paramString == null || paramString.isEmpty()) {
      return Component.empty();
    }
    return LEGACY_AMPERSAND.deserialize(paramString);
  }

  public static Component gradient(String text, String fromHex, String toHex) {
    int from = parseGradientHex(fromHex);
    int to = parseGradientHex(toHex);
    int denominator = Math.max(text.length() - 1, 1);
    Component gradient = Component.empty();
    for (int i = 0; i < text.length(); i++) {
      double progress = i / (double) denominator;
      int red = gradientChannel((from >> 16) & 0xFF, (to >> 16) & 0xFF, progress);
      int green = gradientChannel((from >> 8) & 0xFF, (to >> 8) & 0xFF, progress);
      int blue = gradientChannel(from & 0xFF, to & 0xFF, progress);
      gradient = gradient.append(Component.text(String.valueOf(text.charAt(i)), TextColor.color(red, green, blue), TextDecoration.BOLD));
    }
    return gradient;
  }

  private static int gradientChannel(int from, int to, double progress) {
    return (int)Math.round(from + (to - from) * progress);
  }

  private static int parseGradientHex(String hex) {
    String value = hex.startsWith("#") ? hex.substring(1) : hex;
    return Integer.parseInt(value, 16);
  }
}
