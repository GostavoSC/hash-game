package com.gstv.paymentslist

import android.app.Application
import android.content.Context
import com.gstv.paymentslist.di.financeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class Application : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        startKoin {
            androidContext(this@Application)
            modules(financeModule)
        }
    }
}

