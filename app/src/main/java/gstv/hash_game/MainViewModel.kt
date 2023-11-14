package gstv.hash_game

import androidx.lifecycle.ViewModel
import gstv.hash_game.compose.HashGameState
import gstv.hash_game.compose.WinStates
import gstv.hash_game.compose.getFromString
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(
            HashGameState()
    )
    val hashState = _state.asStateFlow()

    private fun getTurn() = if (_state.value.isXTurn) {
        "X"
    } else {
        "O"
    }

    fun clearGame() {
        _state.update {
            it.copy(
                    plays = emptyList(),
                    isXTurn = true,
                    currentTurn = "X",
                    showPopUp = false,
                    winner = WinStates.NON_WIN
            )
        }
    }

    fun createPlay(line: Int, column: Int) {
        _state.update {
            it.copy(
                    plays = it.plays + HashGame(line = line, column = column, value = getTurn()),
                    isXTurn = !it.isXTurn
            )
        }
        if (checkPlay().message.isNotEmpty()) {
            updateWinner(checkPlay())
        }
        updateCurrentTurn()
    }

    private fun updateWinner(winnerValue: WinStates) {
        _state.update {
            it.copy(
                    winner = winnerValue,
                    showPopUp = true
            )
        }
    }

    private fun updateCurrentTurn() {
        _state.update {
            it.copy(
                    currentTurn = getTurn()
            )
        }
    }

    private fun List<HashGame>.allListWithSameValue() =
            (filter { it.value == "X" }.size == 3 || filter { it.value == "O" }.size == 3)

    private fun getResultByLine(): WinStates {
        val line1 =
                _state.value.plays.filter { it.line == 1 }
        val line2 =
                _state.value.plays.filter { it.line == 2 }
        val line3 =
                _state.value.plays.filter { it.line == 3 }

        if (line1.size == 3 || line2.size == 3 || line3.size == 3) {
            if (line1.allListWithSameValue()) return getFromString(line1.first().value)
            if (line2.allListWithSameValue()) return getFromString(line2.first().value)
            if (line3.allListWithSameValue()) return getFromString(line3.first().value)
        }

        return WinStates.NON_WIN
    }

    private fun getResultByColumn(): WinStates {
        val column1 =
                _state.value.plays.filter { it.column == 1 }
        val column2 =
                _state.value.plays.filter { it.column == 2 }
        val column3 =
                _state.value.plays.filter { it.column == 3 }

        if (column1.size == 3 || column2.size == 3 || column3.size == 3) {
            if (column1.allListWithSameValue()) return getFromString(column1.first().value)
            if (column2.allListWithSameValue()) return getFromString(column2.first().value)
            if (column3.allListWithSameValue()) return getFromString(column3.first().value)
        }
        return WinStates.NON_WIN
    }

    private fun checkPlay(): WinStates {

        if (getResultByLine().message.isNotEmpty()) {
            return getResultByLine()
        }
        if (getResultByColumn().message.isNotEmpty()) {
            return getResultByColumn()
        }

        val position1 = _state.value.plays.find { it.line == 1 && it.column == 1 }
        val position2 = _state.value.plays.find { it.line == 2 && it.column == 2 }
        val position3 = _state.value.plays.find { it.line == 3 && it.column == 3 }

        if (position1 != null && position2 != null && position3 != null &&
                (position1.value == position2.value && position1.value == position3.value)
        ) {
            return getFromString(position1.value)

        }

        val position4 = _state.value.plays.find { it.line == 1 && it.column == 3 }
        val position5 = _state.value.plays.find { it.line == 2 && it.column == 2 }
        val position6 = _state.value.plays.find { it.line == 3 && it.column == 1 }
        if (position4 != null && position5 != null && position6 != null &&
                (position4.value == position5.value && position4.value == position6.value)
        ) {
            return getFromString(position4.value)
        }

        if (_state.value.plays.size == 9) {
            return WinStates.TIED
        }
        return WinStates.NON_WIN
    }
}


