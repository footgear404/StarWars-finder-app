package com.semenchuk.di

import androidx.room.Room
import com.semenchuk.data.room.SWDatabase
import com.semenchuk.data.room.SWDatabaseDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val storageModule = module {

    single<SWDatabase> {
        Room.databaseBuilder(
            androidApplication().applicationContext,
            SWDatabase::class.java,
            name = "SWDB"
        ).build()
    }

    single<SWDatabaseDao> {
        get<SWDatabase>().appDatabaseDao()
    }
}