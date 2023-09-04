package com.semenchuk.details.presentation

import android.os.Parcelable
import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.PlanetsResponse
import com.semenchuk.api.retrofit.models.StarshipsResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseTransferObject(
    val peopleResponse: PeopleResponse?,
    val starshipsResponse: StarshipsResponse?,
    val planetsResponse: PlanetsResponse?
) : Parcelable