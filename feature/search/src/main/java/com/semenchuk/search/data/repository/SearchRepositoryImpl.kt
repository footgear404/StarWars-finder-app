package com.semenchuk.search.data.repository

import com.semenchuk.api.retrofit.StarWarsApi
import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.PlanetsResponse
import com.semenchuk.api.retrofit.models.SWSearch
import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.search.domain.repository.SearchRepository
import retrofit2.Response

class SearchRepositoryImpl(
    private val starWarsApi: StarWarsApi
) : SearchRepository {
//    override suspend fun <T> getEntity(entity: String, name: String): Response<SWSearch<T>> {
//        return starWarsApi.searchFor.entity(entity = entity, name = name)
//    }

    override suspend fun searchPeople(name: String): Response<SWSearch<PeopleResponse>> {
        return starWarsApi.searchFor.people(name = name)
    }
    override suspend fun searchPlanets(name: String): Response<SWSearch<PlanetsResponse>> {
        return starWarsApi.searchFor.planets(name = name)
    }

    override suspend fun searchStarships(name: String): Response<SWSearch<StarshipsResponse>> {
        return starWarsApi.searchFor.starships(name = name)
    }
}