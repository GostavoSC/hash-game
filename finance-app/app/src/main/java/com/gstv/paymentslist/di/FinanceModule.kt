package com.gstv.paymentslist.di

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.gstv.paymentslist.database.DATA_BASE_NAME
import com.gstv.paymentslist.database.FinanceDatabase
import com.gstv.paymentslist.database.PaymentsDao
import com.gstv.paymentslist.database.PaymentsRepository
import com.gstv.paymentslist.screens.home.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

@RequiresApi(Build.VERSION_CODES.O)
val financeModule = module {

    single<FinanceDatabase> {
        Room.databaseBuilder(
            androidApplication(),
            FinanceDatabase::class.java,
            DATA_BASE_NAME
        ).build()
    }

    single<PaymentsDao> {
        val database = get<FinanceDatabase>()
        database.getNotesDao()
    }
    singleOf(::PaymentsRepository)

    viewModelOf(::MainViewModel)

}