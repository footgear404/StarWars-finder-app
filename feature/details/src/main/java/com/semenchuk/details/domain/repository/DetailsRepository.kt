package com.semenchuk.details.domain.repository

import com.semenchuk.EntityType
import com.semenchuk.api.retrofit.models.FilmsResponse
import com.semenchuk.api.retrofit.models.HomeworldResponse
import com.semenchuk.api.retrofit.models.StarshipsResponse

interface DetailsRepository {
    suspend fun getHomeworldName(id: Int): HomeworldResponse?

    suspend fun getFilms(idList: List<Int>): List<FilmsResponse>

    suspend fun getStarships(idList: List<Int>): List<StarshipsResponse>
}