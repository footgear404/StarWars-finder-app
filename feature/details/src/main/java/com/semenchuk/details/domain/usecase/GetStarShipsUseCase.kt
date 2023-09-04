package com.semenchuk.details.domain.usecase

import com.semenchuk.EntityType
import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.details.domain.repository.DetailsRepository

interface GetStarShipsUseCase {
    suspend fun get(idList: List<Int>): List<StarshipsResponse>
}