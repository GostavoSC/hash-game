package com.gstv.paymentslist.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.Month

@RequiresApi(Build.VERSION_CODES.O)
data class MainState(
    val currentMonth: Month = LocalDateTime.now().month,
)
