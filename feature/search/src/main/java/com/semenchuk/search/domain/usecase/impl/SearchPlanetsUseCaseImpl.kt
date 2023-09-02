package com.semenchuk.search.domain.usecase.impl

import com.semenchuk.api.retrofit.models.PlanetsResponse
import com.semenchuk.api.retrofit.models.SWSearch
import com.semenchuk.search.domain.repository.SearchRepository
import com.semenchuk.search.domain.usecase.SearchPlanetsUseCase
import retrofit2.Response

class SearchPlanetsUseCaseImpl(private val searchRepository: SearchRepository) :
    SearchPlanetsUseCase {
    override suspend fun searchPlanets(name: String): Response<SWSearch<PlanetsResponse>> {
        return searchRepository.searchPlanets(name)
    }
}