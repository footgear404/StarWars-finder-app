package com.semenchuk.details.domain.usecase.impl

import com.semenchuk.api.retrofit.models.FilmsResponse
import com.semenchuk.details.domain.repository.DetailsRepository
import com.semenchuk.details.domain.usecase.GetFilmsUseCase

class GetFilmsUseCaseImpl(private val detailsRepository: DetailsRepository) : GetFilmsUseCase {
    override suspend fun get(listId: List<Int>): List<FilmsResponse> {
        return detailsRepository.getFilms(listId)
    }
}