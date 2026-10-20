package net.kingscraft.zenixmc.altarsmp.item;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import net.kyori.adventure.text.Component;

public interface ItemStat {
  Component label();

  String key();
}
