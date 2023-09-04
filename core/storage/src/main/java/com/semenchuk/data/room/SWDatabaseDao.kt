package com.semenchuk.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.semenchuk.data.models.Person
import com.semenchuk.data.models.Starship

@Dao
interface SWDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun savePerson(person: Person)

    @Query("DELETE FROM person WHERE name = :name")
    suspend fun removePerson(name: String)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveStarship(starship: Starship)

    @Query("DELETE FROM starship WHERE name = :name")
    suspend fun removeStarship(name: String)

    @Query("SELECT * FROM person")
    fun getFavoritePersons(): List<Person>

    @Query("SELECT * FROM starship")
    fun getFavoriteStarships(): List<Starship>

}