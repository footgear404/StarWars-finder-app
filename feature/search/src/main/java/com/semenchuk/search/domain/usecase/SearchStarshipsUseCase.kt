package com.semenchuk.search.domain.usecase

import com.semenchuk.api.retrofit.models.SWSearch
import com.semenchuk.api.retrofit.models.StarshipsResponse
import retrofit2.Response

interface SearchStarshipsUseCase {

    suspend fun searchStarships(name: String): Response<SWSearch<StarshipsResponse>>

}