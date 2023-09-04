package com.semenchuk.domain

import com.semenchuk.data.models.Person

interface RoomRepository {
    suspend fun save(person: Person)

}