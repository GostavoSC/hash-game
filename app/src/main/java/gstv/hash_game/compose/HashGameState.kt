package gstv.hash_game.compose

import gstv.hash_game.HashGame

data class HashGameState(
    val plays: List<HashGame> = emptyList(),
    val isXTurn: Boolean = true,
    val currentTurn: String = "X",
    val showPopUp: Boolean = false,
    val winner: String = ""
)
