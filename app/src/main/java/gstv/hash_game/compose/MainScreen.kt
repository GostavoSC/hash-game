package gstv.hash_game.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gstv.hash_game.HashGame
import gstv.hash_game.MainViewModel
import gstv.hash_game.theme.Line
import gstv.hash_game.utils.getPlaysColumnOrEmpty
import gstv.hash_game.utils.getPlaysLineOrEmpty

@Composable
fun MainScreen(mainViewModel: MainViewModel, state: HashGameState) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        if (state.showPopUp) {
            AlertDialog(
                title = {
                    var text = "Parabéns!!!"
                    if (state.winner == "empate") {
                        text = "Vishhhhh"
                    }
                    Text(text = text)
                },
                text = {
                    var text = "O vencendor da rodada foi: ${state.winner}"
                    if (state.winner == "empate") {
                        text = "Empatou :("
                    }
                    Text(text = text)
                },
                onDismissRequest = {
                    mainViewModel.clearGame()
                },
                confirmButton = {
                    TextButton(onClick = { mainViewModel.clearGame() }) {
                        Text(text = "Ok")
                    }
                }
            )
        }
        ScreenContent(state.plays, state.currentTurn) { line, column ->
            mainViewModel.createPlay(
                line = line,
                column = column
            )
        }
    }
}

@Composable
private fun ScreenContent(
    plays: List<HashGame>,
    turn: String,
    onCreatePlay: (line: Int, column: Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 120.dp)
    ) {
        Text(text = "É a vez do: $turn", fontSize = 25.sp)
        Spacer(modifier = Modifier.padding(top = 40.dp))
        LineGame(plays.getPlaysLineOrEmpty(1)) {
            onCreatePlay(1, it)
        }
        Divider(color = Line, modifier = Modifier.size(height = 4.dp, width = 312.dp))
        LineGame(plays.getPlaysLineOrEmpty(2)) {
            onCreatePlay(2, it)
        }
        Divider(color = Line, modifier = Modifier.size(height = 4.dp, width = 312.dp))
        LineGame(plays.getPlaysLineOrEmpty(3)) {
            onCreatePlay(3, it)
        }

    }
}

@Composable
private fun ItemLine(plays: List<HashGame>, column: Int, onClickItem: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clickable {
                onClickItem(column)
            }, contentAlignment = Alignment.Center
    ) {
        TextHashGame(column = column, plays = plays)
    }
}


@Composable
private fun LineGame(plays: List<HashGame>, onClickItem: (Int) -> Unit) {
    Row {
        ItemLine(plays = plays, column = 1, onClickItem = { onClickItem(it) })

        Divider(color = Line, modifier = Modifier.size(height = 100.dp, width = 4.dp))

        ItemLine(plays = plays, column = 2, onClickItem = { onClickItem(it) })

        Divider(color = Line, modifier = Modifier.size(height = 100.dp, width = 4.dp))

        ItemLine(plays = plays, column = 3, onClickItem = { onClickItem(it) })
    }
}

@Composable
private fun TextHashGame(column: Int, plays: List<HashGame>) {
    val playsInColumn = plays.getPlaysColumnOrEmpty(column)
    if (plays.isNotEmpty() && playsInColumn.isNotEmpty()) {
        Text(text = playsInColumn.first().value, color = Color.White, fontSize = 85.sp)
    } else {
        Text(text = "", color = Color.White, fontSize = 85.sp)
    }
}
