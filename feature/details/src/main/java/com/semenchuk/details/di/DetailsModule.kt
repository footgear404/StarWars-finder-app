package com.semenchuk.details.di

import com.semenchuk.details.data.repository.DetailsRepositoryImpl
import com.semenchuk.details.domain.repository.DetailsRepository
import com.semenchuk.details.domain.usecase.GetFilmsUseCase
import com.semenchuk.details.domain.usecase.GetHomeworldUseCase
import com.semenchuk.details.domain.usecase.GetStarShipsUseCase
import com.semenchuk.details.domain.usecase.impl.GetFilmsUseCaseImpl
import com.semenchuk.details.domain.usecase.impl.GetHomeworldUseCaseImpl
import com.semenchuk.details.domain.usecase.impl.GetStarShipsUseCaseImpl
import com.semenchuk.details.presentation.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {

    single<DetailsRepository> {
        DetailsRepositoryImpl(starWarsApi = get())
    }

    single<GetHomeworldUseCase> {
        GetHomeworldUseCaseImpl(detailsRepository = get())
    }

    single<GetFilmsUseCase> {
        GetFilmsUseCaseImpl(detailsRepository = get())
    }

    single<GetStarShipsUseCase> {
        GetStarShipsUseCaseImpl(detailsRepository = get())
    }
    viewModel<DetailsViewModel> {
        DetailsViewModel(
            getHomeworldUseCase = get(),
            getFilmsUseCase = get(),
            getStarShipsUseCase = get(),
            swDatabaseDao = get()
        )
    }
}