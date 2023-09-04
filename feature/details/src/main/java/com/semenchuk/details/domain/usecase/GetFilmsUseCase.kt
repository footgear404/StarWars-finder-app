package com.semenchuk.details.domain.usecase

import com.semenchuk.api.retrofit.models.FilmsResponse

interface GetFilmsUseCase {
    suspend fun get(listId: List<Int>) : List<FilmsResponse>
}