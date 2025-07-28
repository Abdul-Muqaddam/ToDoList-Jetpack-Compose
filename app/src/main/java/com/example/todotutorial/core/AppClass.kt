package com.example.todotutorial.core

import android.app.Application
import appModule
import com.example.todotutorial.data.AppPreference
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AppClass: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppClass)
            modules(appModule)
        }
        AppPreference.init(this)
    }
}