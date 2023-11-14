package gstv.hash_game

import gstv.hash_game.compose.WinStates
import io.kotest.matchers.shouldBe
import org.junit.Test


class MainViewModelTest {
    private val viewModel = MainViewModel()

    @Test
    fun should_return_x_when_win_in_middle_1() {
        viewModel.createPlay(1,1)//x
        viewModel.createPlay(1,2)//o
        viewModel.createPlay(2,2)//x
        viewModel.createPlay(1,3)//o
        viewModel.createPlay(3,3)//x

        viewModel.hashState.value.winner shouldBe WinStates.X_WIN
    }

    @Test
    fun should_return_O_when_win_in_middle_1() {
        viewModel.createPlay(1,2)//x
        viewModel.createPlay(1,1)//o
        viewModel.createPlay(1,3)//x
        viewModel.createPlay(2,2)//o
        viewModel.createPlay(2,1)//x
        viewModel.createPlay(3,3)//o

        viewModel.hashState.value.winner shouldBe WinStates.O_WIN
    }
    @Test
    fun should_return_x_when_win_in_middle_2() {
        viewModel.createPlay(1,3)//x
        viewModel.createPlay(1,2)//o
        viewModel.createPlay(2,2)//x
        viewModel.createPlay(1,3)//o
        viewModel.createPlay(3,1)//x

        viewModel.hashState.value.winner shouldBe WinStates.X_WIN
    }

    @Test
    fun should_return_O_when_win_in_middle_2() {
        viewModel.createPlay(1,2)//x
        viewModel.createPlay(1,3)//o
        viewModel.createPlay(1,1)//x
        viewModel.createPlay(2,2)//o
        viewModel.createPlay(2,1)//x
        viewModel.createPlay(3,1)//o

        viewModel.hashState.value.winner shouldBe WinStates.O_WIN
    }

    @Test
    fun should_return_X_when_win_in_top_line() {
        viewModel.createPlay(1,1)//x
        viewModel.createPlay(2,1)//o
        viewModel.createPlay(1,2)//x
        viewModel.createPlay(3,2)//o
        viewModel.createPlay(1,3)//x

        viewModel.hashState.value.winner shouldBe WinStates.X_WIN
    }
    @Test
    fun should_return_X_when_win_in_middle_line() {
        viewModel.createPlay(2,1)//x
        viewModel.createPlay(3,1)//o
        viewModel.createPlay(2,2)//x
        viewModel.createPlay(1,2)//o
        viewModel.createPlay(2,3)//x

        viewModel.hashState.value.winner shouldBe WinStates.X_WIN
    }

    @Test
    fun should_return_X_when_win_in_bottom_line() {
        viewModel.createPlay(3,1)//x
        viewModel.createPlay(2,1)//o
        viewModel.createPlay(3,2)//x
        viewModel.createPlay(1,2)//o
        viewModel.createPlay(3,3)//x

        viewModel.hashState.value.winner shouldBe WinStates.X_WIN
    }

    @Test
    fun should_return_X_when_win_in_first_column() {
        viewModel.createPlay(1,1)//x
        viewModel.createPlay(1,2)//o
        viewModel.createPlay(2,1)//x
        viewModel.createPlay(2,2)//o
        viewModel.createPlay(3,1)//x

        viewModel.hashState.value.winner shouldBe WinStates.X_WIN
    }

    @Test
    fun should_return_X_when_win_in_middle_column() {
        viewModel.createPlay(1,2)//x
        viewModel.createPlay(1,1)//o
        viewModel.createPlay(2,2)//x
        viewModel.createPlay(3,1)//o
        viewModel.createPlay(3,2)//x

        viewModel.hashState.value.winner shouldBe WinStates.X_WIN
    }

    @Test
    fun should_return_X_when_win_in_end_column() {
        viewModel.createPlay(1,3)//x
        viewModel.createPlay(1,1)//o
        viewModel.createPlay(2,3)//x
        viewModel.createPlay(2,1)//o
        viewModel.createPlay(3,3)//x

        viewModel.hashState.value.winner shouldBe WinStates.X_WIN
    }
}