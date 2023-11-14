package gstv.hash_game

import android.bluetooth.BluetoothManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import gstv.hash_game.compose.MainScreen
import gstv.hash_game.theme.JogoDaVelhaTheme

class MainActivity : ComponentActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = viewModel.hashState.collectAsState().value

            JogoDaVelhaTheme {
                MainScreen(mainViewModel = viewModel, state = state)
            }
        }
    }

    private fun checkBluetooth() {
        val bluetoothManager = this.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val adapter = bluetoothManager.adapter
        if (adapter != null) {
            if (adapter.isEnabled) {
                Log.e("Bluetooth", "Ativou")
                //   val intent = Intent(this@BluetoothEnable, ListBluetooth::class.java)
                //   startActivity(intent)
                //   finish()
            }else{
                Log.e("Bluetooth", "Não sei")
            }
        }else{
            Log.e("Bluetooth", "Desativado")
        }
    }
}


