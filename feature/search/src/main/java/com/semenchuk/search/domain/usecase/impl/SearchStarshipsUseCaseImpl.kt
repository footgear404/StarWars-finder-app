package com.semenchuk.search.domain.usecase.impl

import com.semenchuk.api.retrofit.models.SWSearch
import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.search.domain.repository.SearchRepository
import com.semenchuk.search.domain.usecase.SearchStarshipsUseCase
import retrofit2.Response

class SearchStarshipsUseCaseImpl(private val searchRepository: SearchRepository) :
    SearchStarshipsUseCase {
    override suspend fun searchStarships(name: String): Response<SWSearch<StarshipsResponse>> {
        return searchRepository.searchStarships(name)
    }
}