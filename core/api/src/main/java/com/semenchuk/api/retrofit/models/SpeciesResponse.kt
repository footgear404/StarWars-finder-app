package com.semenchuk.api.retrofit.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpeciesResponse(
    @Json(name = "average_height")
    val averageHeight: String?,
    @Json(name = "average_lifespan")
    val averageLifespan: String?,
    @Json(name = "classification")
    val classification: String?,
    @Json(name = "created")
    val created: String?,
    @Json(name = "designation")
    val designation: String?,
    @Json(name = "edited")
    val edited: String?,
    @Json(name = "eye_colors")
    val eyeColors: String?,
    @Json(name = "films")
    val films: List<String?>?,
    @Json(name = "hair_colors")
    val hairColors: String?,
    @Json(name = "homeworld")
    val homeworld: String?,
    @Json(name = "language")
    val language: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "people")
    val people: List<String?>?,
    @Json(name = "skin_colors")
    val skinColors: String?,
    @Json(name = "url")
    val url: String?
)