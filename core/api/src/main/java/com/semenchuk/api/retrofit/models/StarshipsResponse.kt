package com.semenchuk.api.retrofit.models


import android.os.Parcelable
import com.semenchuk.entity.Starships
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class StarshipsResponse(
    @Json(name = "cargo_capacity")
    override val cargoCapacity: String,
    @Json(name = "consumables")
    override val consumables: String?,
    @Json(name = "cost_in_credits")
    override val costInCredits: String?,
    @Json(name = "created")
    override val created: String?,
    @Json(name = "crew")
    override val crew: String?,
    @Json(name = "edited")
    override val edited: String?,
    @Json(name = "films")
    val films: List<String?>,
    @Json(name = "hyperdrive_rating")
    override val hyperdriveRating: String?,
    @Json(name = "length")
    override val length: String?,
    @Json(name = "MGLT")
    override val mGLT: String?,
    @Json(name = "manufacturer")
    override val manufacturer: String?,
    @Json(name = "max_atmosphering_speed")
    override val maxAtmospheringSpeed: String?,
    @Json(name = "model")
    override val model: String?,
    @Json(name = "name")
    override val name: String,
    @Json(name = "passengers")
    override val passengers: String?,
    @Json(name = "pilots")
    val pilots: List<String?>,
    @Json(name = "starship_class")
    override val starshipClass: String?,
    @Json(name = "url")
    override val url: String?
) : Starships, Parcelable