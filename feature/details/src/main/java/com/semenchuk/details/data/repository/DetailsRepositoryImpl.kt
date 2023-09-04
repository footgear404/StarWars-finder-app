package com.semenchuk.details.data.repository

import com.semenchuk.api.retrofit.StarWarsApi
import com.semenchuk.api.retrofit.models.FilmsResponse
import com.semenchuk.api.retrofit.models.HomeworldResponse
import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.details.domain.repository.DetailsRepository

class DetailsRepositoryImpl(private val starWarsApi: StarWarsApi) : DetailsRepository {
    override suspend fun getHomeworldName(id: Int): HomeworldResponse? {
        val response = starWarsApi.searchFor.homeworld(id)
        return if (response.isSuccessful) {
            response.body()
        } else null
    }

    override suspend fun getFilms(idList: List<Int>): List<FilmsResponse> {

        val response = starWarsApi.searchFor.films()
        val listOfFilms = mutableListOf<FilmsResponse>()
        return if (response.isSuccessful) {
            idList.forEach {
                listOfFilms.add(response.body()!!.results[it - 1])
            }
            return listOfFilms.toList()
        } else emptyList()
    }

    override suspend fun getStarships(idList: List<Int>): List<StarshipsResponse> {

        val listOfStarships = mutableListOf<StarshipsResponse>()

        idList.forEach { shipId ->
            val response = starWarsApi.searchFor.starshipById(shipId)
            if (response.isSuccessful) {
                response.body()?.let { listOfStarships.add(it) }
            }
        }
        return listOfStarships.toList()
    }
}