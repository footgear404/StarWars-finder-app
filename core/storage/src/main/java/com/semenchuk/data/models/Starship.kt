package com.semenchuk.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.entity.Starships
@Entity(tableName = "starship")
data class Starship(
    @PrimaryKey
    @ColumnInfo(name = "name")
    override val name: String,
    @ColumnInfo(name = "cargoCapacity")
    override val cargoCapacity: String?,
    @ColumnInfo(name = "consumables")
    override val consumables: String?,
    @ColumnInfo(name = "costInCredits")
    override val costInCredits: String?,
    @ColumnInfo(name = "created")
    override val created: String?,
    @ColumnInfo(name = "crew")
    override val crew: String?,
    @ColumnInfo(name = "edited")
    override val edited: String?,
    @ColumnInfo(name = "hyperdriveRating")
    override val hyperdriveRating: String?,
    @ColumnInfo(name = "length")
    override val length: String?,
    @ColumnInfo(name = "mGLT")
    override val mGLT: String?,
    @ColumnInfo(name = "manufacturer")
    override val manufacturer: String?,
    @ColumnInfo(name = "maxAtmospheringSpeed")
    override val maxAtmospheringSpeed: String?,
    @ColumnInfo(name = "model")
    override val model: String?,
    @ColumnInfo(name = "passengers")
    override val passengers: String?,
    @ColumnInfo(name = "starshipClass")
    override val starshipClass: String?,
    @ColumnInfo(name = "url")
    override val url: String?
) : Starships
