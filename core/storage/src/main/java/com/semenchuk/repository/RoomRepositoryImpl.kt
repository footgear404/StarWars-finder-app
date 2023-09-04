package com.semenchuk.repository

import com.semenchuk.data.models.Person
import com.semenchuk.data.room.SWDatabaseDao
import com.semenchuk.domain.RoomRepository

class RoomRepositoryImpl(
    private val swDatabaseDao: SWDatabaseDao
) : RoomRepository {
    override suspend fun save(person: Person) {
        swDatabaseDao.savePerson(person)
    }
}