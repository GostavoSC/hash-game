package com.gstv.paymentslist.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.gstv.paymentslist.database.PaymentsRepository
import com.gstv.paymentslist.database.FinanceDatabase
import com.gstv.paymentslist.database.PaymentsDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@RequiresApi(Build.VERSION_CODES.O)
class MainViewModel(repository: PaymentsRepository) : ViewModel() {

    private val _state = MutableStateFlow(
        MainState()
    )
    val state = _state.asStateFlow()
}