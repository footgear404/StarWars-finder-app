package com.semenchuk.api.retrofit.models


import com.semenchuk.entity.Homeworld
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeworldResponse(
    @Json(name = "climate")
    override val climate: String?,
    @Json(name = "created")
    override val created: String?,
    @Json(name = "diameter")
    override val diameter: String?,
    @Json(name = "edited")
    override val edited: String?,
    @Json(name = "films")
    override val films: List<String?>?,
    @Json(name = "gravity")
    override val gravity: String?,
    @Json(name = "name")
    override val name: String,
    @Json(name = "orbital_period")
    override val orbitalPeriod: String?,
    @Json(name = "population")
    override val population: String?,
    @Json(name = "residents")
    override val residents: List<String?>,
    @Json(name = "rotation_period")
    override val rotationPeriod: String?,
    @Json(name = "surface_water")
    override val surfaceWater: String?,
    @Json(name = "terrain")
    override val terrain: String?,
    @Json(name = "url")
    override val url: String?
) : Homeworld