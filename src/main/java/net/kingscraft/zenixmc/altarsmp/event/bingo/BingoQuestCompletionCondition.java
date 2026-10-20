package net.kingscraft.zenixmc.altarsmp.event.bingo;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.Player;

interface BingoQuestCompletionCondition {
  boolean isCompleted(Player paramPlayer, BingoQuestType bingoQuestType);
}
