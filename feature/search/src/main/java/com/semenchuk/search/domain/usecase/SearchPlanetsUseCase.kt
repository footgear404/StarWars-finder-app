package com.semenchuk.search.domain.usecase

import com.semenchuk.api.retrofit.models.PlanetsResponse
import com.semenchuk.api.retrofit.models.SWSearch
import retrofit2.Response

interface SearchPlanetsUseCase {

    suspend fun searchPlanets(name: String): Response<SWSearch<PlanetsResponse>>

}