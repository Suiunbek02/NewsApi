package com.example.newsapi

import android.app.Application
import com.example.newsapi.servcelocator.appModule
import com.example.newsapi.servcelocator.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidContext(this@App)
            modules(appModule, dataModule)
        }
    }
}