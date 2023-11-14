package gstv.hash_game.compose

import gstv.hash_game.HashGame

data class HashGameState(
        val plays: List<HashGame> = emptyList(),
        val isXTurn: Boolean = true,
        val currentTurn: String = "X",
        val showPopUp: Boolean = false,
        val winner: WinStates = WinStates.NON_WIN
)

enum class WinStates(val message: String, val player: String) {
    TIED("Empatou", "empate"),
    X_WIN("X Ganhou", "X"),
    O_WIN("O Ganhou", "O"),
    NON_WIN("","")

}

fun getFromString(player: String) = WinStates.values().firstOrNull { it.player == player }
        ?: WinStates.TIED