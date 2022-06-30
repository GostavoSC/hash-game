package gstv.hash_game.utils

import gstv.hash_game.HashGame

fun List<HashGame>.getPlaysLineOrEmpty(line: Int): List<HashGame> {
    return if (isNotEmpty()) {
        filter { it.line == line }
    } else {
        this
    }
}

fun List<HashGame>.getPlaysColumnOrEmpty(column: Int): List<HashGame> {
    return if (isNotEmpty()) {
        filter { it.column == column }
    } else {
        this
    }
}
