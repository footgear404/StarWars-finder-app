package com.semenchuk.di

import com.semenchuk.api.retrofit.StarWarsApi
import org.koin.dsl.module

val apiModule = module {
    single<StarWarsApi> {
        StarWarsApi()
    }
}