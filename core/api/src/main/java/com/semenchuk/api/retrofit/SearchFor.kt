package com.semenchuk.api.retrofit

import com.semenchuk.api.retrofit.models.FilmsResponse
import com.semenchuk.api.retrofit.models.HomeworldResponse
import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.PlanetsResponse
import com.semenchuk.api.retrofit.models.SWSearch
import com.semenchuk.api.retrofit.models.StarshipsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SearchFor {

    @GET("people/")
    suspend fun people(
        @Query("search") name: String
    ): Response<SWSearch<PeopleResponse>>

    @GET("starships/")
    suspend fun starships(
        @Query("search") name: String
    ): Response<SWSearch<StarshipsResponse>>

    @GET("planets/")
    suspend fun planets(
        @Query("search") name: String
    ): Response<SWSearch<PlanetsResponse>>


    @GET("planets/{id}")
    suspend fun homeworld(
        @Path("id") id: Int,
    ): Response<HomeworldResponse>

    @GET("films/")
    suspend fun films(): Response<SWSearch<FilmsResponse>>

    @GET("starships/{id}")
    suspend fun starshipById(
        @Path("id") id: Int,
    ): Response<StarshipsResponse>


    @GET("films/{id}")
    suspend fun filmsById(
        @Path("id") id: Int,
    ): Response<FilmsResponse>

}