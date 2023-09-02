package com.semenchuk.search.domain.usecase.impl

import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.SWSearch
import com.semenchuk.search.domain.repository.SearchRepository
import com.semenchuk.search.domain.usecase.SearchPeopleUseCase
import retrofit2.Response

class SearchPeopleUseCaseImpl(private val searchRepository: SearchRepository): SearchPeopleUseCase {
    override suspend fun searchPeople(name: String): Response<SWSearch<PeopleResponse>> {
        return searchRepository.searchPeople(name)
    }

}