package com.semenchuk.api.retrofit.models

import com.semenchuk.entity.People
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PeopleResponse(
    @Json(name = "birth_year")
    override val birthYear: String?,
    @Json(name = "created")
    override val created: String?,
    @Json(name = "edited")
    override val edited: String?,
    @Json(name = "eye_color")
    override val eyeColor: String?,
    @Json(name = "films")
    override val films: List<String?>,
    @Json(name = "gender")
    override val gender: String?,
    @Json(name = "hair_color")
    override val hairColor: String?,
    @Json(name = "height")
    override val height: String?,
    @Json(name = "homeworld")
    override val homeworld: String?,
    @Json(name = "mass")
    override val mass: String?,
    @Json(name = "name")
    override val name: String?,
    @Json(name = "skin_color")
    override val skinColor: String?,
    @Json(name = "species")
    override val species: List<String?>,
    @Json(name = "starships")
    override val starships: List<String?>,
    @Json(name = "url")
    override val url: String?,
    @Json(name = "vehicles")
    override val vehicles: List<String?>
) : People
