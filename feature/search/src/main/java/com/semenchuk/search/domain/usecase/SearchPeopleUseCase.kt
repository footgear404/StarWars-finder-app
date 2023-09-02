package com.semenchuk.search.domain.usecase

import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.PlanetsResponse
import com.semenchuk.api.retrofit.models.SWSearch
import retrofit2.Response

interface SearchPeopleUseCase {
    suspend fun searchPeople(name: String): Response<SWSearch<PeopleResponse>>

}