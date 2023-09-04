package com.semenchuk.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.semenchuk.data.models.Film
import com.semenchuk.data.models.Person
import com.semenchuk.data.models.Starship

@Database(entities = [Person::class, Starship::class], version = 1)
abstract class SWDatabase : RoomDatabase() {
    abstract fun appDatabaseDao(): SWDatabaseDao
}