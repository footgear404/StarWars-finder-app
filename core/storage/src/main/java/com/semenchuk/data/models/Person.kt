package com.semenchuk.data.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.semenchuk.api.retrofit.models.FilmsResponse
import com.semenchuk.api.retrofit.models.StarshipsResponse

@Entity(tableName = "person")
data class Person(
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "sumOfStarships")
    val sumOfStarships: Int?,
    @ColumnInfo(name = "birthYear")
    val birthYear: String?,
    @ColumnInfo(name = "eyeColor")
    val eyeColor: String?,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "hairColor")
    val hairColor: String,
    @ColumnInfo(name = "height")
    val height: String,
    @ColumnInfo(name = "homeworld")
    val homeworld: String,
    @ColumnInfo(name = "mass")
    val mass: String,
    @ColumnInfo(name = "skinColor")
    val skinColor: String,
)