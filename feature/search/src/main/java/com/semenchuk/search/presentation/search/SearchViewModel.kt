package com.semenchuk.search.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semenchuk.EntityType
import com.semenchuk.api.retrofit.models.SWSearch
import com.semenchuk.search.domain.usecase.SearchPeopleUseCase
import com.semenchuk.search.domain.usecase.SearchPlanetsUseCase
import com.semenchuk.search.domain.usecase.SearchStarshipsUseCase
import com.semenchuk.state.LoadState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class SearchViewModel(
    private val searchPeopleUseCase: SearchPeopleUseCase,
    private val searchPlanetsUseCase: SearchPlanetsUseCase,
    private val searchStarshipsUseCase: SearchStarshipsUseCase
) : ViewModel() {

    private val _loadState = MutableStateFlow<LoadState>(LoadState.Success)
    val loadState = _loadState.asStateFlow()

    private var _result = MutableStateFlow<Response<SWSearch<Any>>?>(null)
    val result get() = _result.asStateFlow()


    var entityType = EntityType.PEOPLE


    fun searchPeople(entity: EntityType, name: String) {
        _loadState.value = LoadState.Loading
        viewModelScope.launch {
            when (entity) {
                EntityType.PEOPLE -> {
                    _result.value =
                        searchPeopleUseCase.searchPeople(name) as Response<SWSearch<Any>>
                    _loadState.value = LoadState.Success
                }

                EntityType.PLANETS -> {
                    _result.value =
                        searchPlanetsUseCase.searchPlanets(name) as Response<SWSearch<Any>>
                    _loadState.value = LoadState.Success
                }

                EntityType.STARSHIPS -> {
                    _result.value =
                        searchStarshipsUseCase.searchStarships(name) as Response<SWSearch<Any>>
                    _loadState.value = LoadState.Success
                }
            }

        }
    }
}