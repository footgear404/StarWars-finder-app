package com.semenchuk.details.domain.usecase

import com.semenchuk.api.retrofit.models.HomeworldResponse
import retrofit2.Response

interface GetHomeworldUseCase {

    suspend fun get(id: Int): HomeworldResponse?

}