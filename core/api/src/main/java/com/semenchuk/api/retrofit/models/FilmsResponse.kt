package com.semenchuk.api.retrofit.models


import com.semenchuk.entity.Films
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmsResponse(
    @Json(name = "characters")
    override val characters: List<String?>,
    @Json(name = "created")
    override val created: String?,
    @Json(name = "director")
    override val director: String?,
    @Json(name = "edited")
    override val edited: String?,
    @Json(name = "episode_id")
    override val episodeId: Int?,
    @Json(name = "opening_crawl")
    override val openingCrawl: String?,
    @Json(name = "planets")
    override val planets: List<String?>,
    @Json(name = "producer")
    override val producer: String?,
    @Json(name = "release_date")
    override val releaseDate: String?,
    @Json(name = "species")
    override val species: List<String?>,
    @Json(name = "starships")
    override val starships: List<String?>,
    @Json(name = "title")
    override val title: String?,
    @Json(name = "url")
    override val url: String?,
    @Json(name = "vehicles")
    override val vehicles: List<String?>
) : Films