package com.semenchuk.details.domain.usecase.impl

import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.details.domain.repository.DetailsRepository
import com.semenchuk.details.domain.usecase.GetStarShipsUseCase

class GetStarShipsUseCaseImpl(private val detailsRepository: DetailsRepository) :
    GetStarShipsUseCase {
    override suspend fun get(idList: List<Int>): List<StarshipsResponse> {

        return detailsRepository.getStarships(idList)
    }
}