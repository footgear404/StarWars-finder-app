package com.semenchuk.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.semenchuk.entity.Films
@Entity(tableName = "film")
data class Film(
    @PrimaryKey
    @ColumnInfo(name = "title")
    override val title: String?,
    @ColumnInfo(name = "characters")
    override val characters: List<String?>,
    @ColumnInfo(name = "created")
    override val created: String?,
    @ColumnInfo(name = "director")
    override val director: String?,
    @ColumnInfo(name = "edited")
    override val edited: String?,
    @ColumnInfo(name = "episodeId")
    override val episodeId: Int?,
    @ColumnInfo(name = "openingCrawl")
    override val openingCrawl: String?,
    @ColumnInfo(name = "planets")
    override val planets: List<String?>,
    @ColumnInfo(name = "producer")
    override val producer: String?,
    @ColumnInfo(name = "releaseDate")
    override val releaseDate: String?,
    @ColumnInfo(name = "species")
    override val species: List<String?>,
    @ColumnInfo(name = "starships")
    override val starships: List<String?>,
    @ColumnInfo(name = "url")
    override val url: String?,
    @ColumnInfo(name = "vehicles")
    override val vehicles: List<String?>
) : Films
