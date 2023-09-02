package com.semenchuk.search.domain.repository

import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.PlanetsResponse
import com.semenchuk.api.retrofit.models.SWSearch
import com.semenchuk.api.retrofit.models.StarshipsResponse
import retrofit2.Response

interface SearchRepository {
//    suspend fun <T> getEntity(entity: String, name: String): Response<SWSearch<T>>

    suspend fun searchPeople(name: String): Response<SWSearch<PeopleResponse>>

    suspend fun searchPlanets(name: String): Response<SWSearch<PlanetsResponse>>

    suspend fun searchStarships(name: String): Response<SWSearch<StarshipsResponse>>

}