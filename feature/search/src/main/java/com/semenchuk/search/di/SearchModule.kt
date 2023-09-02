package com.semenchuk.search.di

import com.semenchuk.search.data.repository.SearchRepositoryImpl
import com.semenchuk.search.domain.repository.SearchRepository
import com.semenchuk.search.domain.usecase.SearchPeopleUseCase
import com.semenchuk.search.domain.usecase.SearchPlanetsUseCase
import com.semenchuk.search.domain.usecase.SearchStarshipsUseCase
import com.semenchuk.search.domain.usecase.impl.SearchPeopleUseCaseImpl
import com.semenchuk.search.domain.usecase.impl.SearchPlanetsUseCaseImpl
import com.semenchuk.search.domain.usecase.impl.SearchStarshipsUseCaseImpl
import com.semenchuk.search.presentation.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {

    single<SearchRepository> {
        SearchRepositoryImpl(starWarsApi = get())
    }

    single<SearchPeopleUseCase> {
        SearchPeopleUseCaseImpl(searchRepository = get())
    }

    single<SearchStarshipsUseCase> {
        SearchStarshipsUseCaseImpl(searchRepository = get())
    }

    single<SearchPlanetsUseCase> {
        SearchPlanetsUseCaseImpl(searchRepository = get())
    }
    viewModel<SearchViewModel> {
        SearchViewModel(
            searchPeopleUseCase = get(),
            searchPlanetsUseCase = get(),
            searchStarshipsUseCase = get()
        )
    }
}