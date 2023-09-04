package com.semenchuk.details.domain.usecase.impl

import com.semenchuk.api.retrofit.models.HomeworldResponse
import com.semenchuk.details.domain.repository.DetailsRepository
import com.semenchuk.details.domain.usecase.GetHomeworldUseCase

class GetHomeworldUseCaseImpl(private val detailsRepository: DetailsRepository) :
    GetHomeworldUseCase {
    override suspend fun get(id: Int): HomeworldResponse? {
        return detailsRepository.getHomeworldName(id)
    }
}