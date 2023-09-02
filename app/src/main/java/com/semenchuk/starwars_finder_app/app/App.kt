package com.semenchuk.starwars_finder_app.app

import android.app.Application
import com.semenchuk.di.apiModule
import com.semenchuk.search.di.searchModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(androidContext = this@App)
            modules(searchModule, apiModule)
        }
    }
}