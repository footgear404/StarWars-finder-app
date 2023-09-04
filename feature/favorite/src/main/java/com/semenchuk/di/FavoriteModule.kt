package com.semenchuk.di

import com.semenchuk.favorite.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {

    viewModel<FavoriteViewModel> {
        FavoriteViewModel(
            swDatabaseDao = get()
        )
    }
}