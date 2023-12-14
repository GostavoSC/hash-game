package gstv.hash_game

import android.Manifest
import android.app.admin.DevicePolicyManager
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.core.app.ActivityCompat
import gstv.hash_game.compose.MainScreen
import gstv.hash_game.theme.JogoDaVelhaTheme

class MainActivity : ComponentActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tm = baseContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        tm.connectionInfo.macAddress
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


