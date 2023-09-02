package com.semenchuk.search.domain.usecase.impl

import com.semenchuk.api.retrofit.models.SWSearch
import com.semenchuk.search.domain.repository.SearchRepository
import com.semenchuk.search.domain.usecase.SearchUseCase
import retrofit2.Response

class SearchUseCaseImpl(private val searchRepository: SearchRepository) :
    SearchUseCase {

//    override suspend fun <T> search(entity: String, name: String): Response<SWSearch<T>> {
//        return searchRepository.getEntity(entity, name)
//    }

}