package com.semenchuk.details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semenchuk.api.retrofit.models.FilmsResponse
import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.data.room.SWDatabaseDao
import com.semenchuk.details.domain.usecase.GetFilmsUseCase
import com.semenchuk.details.domain.usecase.GetHomeworldUseCase
import com.semenchuk.details.domain.usecase.GetStarShipsUseCase
import com.semenchuk.details.utils.Mapper.Companion.toPerson
import com.semenchuk.details.utils.Mapper.Companion.toStarshipEntity
import com.semenchuk.state.LoadState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getHomeworldUseCase: GetHomeworldUseCase,
    private val getFilmsUseCase: GetFilmsUseCase,
    private val getStarShipsUseCase: GetStarShipsUseCase,
    private val swDatabaseDao: SWDatabaseDao,
) : ViewModel() {

    private val _loadStarshipsState = MutableStateFlow<LoadState>(LoadState.Success)
    val loadStarshipsState = _loadStarshipsState.asStateFlow()

    private val _loadFilmState = MutableStateFlow<LoadState>(LoadState.Success)
    val loadFilmState = _loadFilmState.asStateFlow()

    private val _loadHomeworldState = MutableStateFlow<LoadState>(LoadState.Success)
    val loadHomeworldState = _loadHomeworldState.asStateFlow()

    private var _homeworld = MutableStateFlow<String>(LOADING)
    val homeworld get() = _homeworld.asStateFlow()

    private var _films = MutableStateFlow<List<FilmsResponse>>(emptyList())
    val films get() = _films.asStateFlow()

    private var _starships = MutableStateFlow<List<StarshipsResponse>>(emptyList())
    val starships get() = _starships.asStateFlow()
    fun getHomeworldName(id: Int) {
        _loadHomeworldState.value = LoadState.Loading
        viewModelScope.launch {
            _homeworld.value = getHomeworldUseCase.get(id)?.name ?: LOADING
            _loadHomeworldState.value = LoadState.Success
        }
    }

    fun getFilmsById(idList: List<Int?>) {
        _loadFilmState.value = LoadState.Loading
        viewModelScope.launch {
            if (idList.isNotEmpty()) {
                val intIdList = idList.filterNotNull().map { it }
                _films.value = getFilmsUseCase.get(intIdList)
                _loadFilmState.value = LoadState.Success
            }
        }
    }

    fun getStarshipsById(idList: List<Int?>) {
        _loadStarshipsState.value = LoadState.Loading
        viewModelScope.launch {
            if (idList.isNotEmpty()) {
                val intIdList = idList.filterNotNull().map { it }
                _starships.value = getStarShipsUseCase.get(intIdList)
                _loadStarshipsState.value = LoadState.Success
            }
        }
    }

    fun addPeopleToFavorite(peopleResponse: PeopleResponse) {
        viewModelScope.launch {
            swDatabaseDao.savePerson(peopleResponse.toPerson())
        }
    }

    fun removePeopleFromFavorite(peopleResponse: PeopleResponse) {
        viewModelScope.launch {
            swDatabaseDao.removePerson(peopleResponse.name!!)
        }
    }

    fun addStarshipToFavorite(starshipsResponse: StarshipsResponse) {
        viewModelScope.launch {
            swDatabaseDao.saveStarship(starshipsResponse.toStarshipEntity())
        }
    }

    fun removeStarshipFromFavorite(starshipsResponse: StarshipsResponse) {
        viewModelScope.launch {
            swDatabaseDao.removeStarship(starshipsResponse.name)
        }
    }

    companion object {
        const val LOADING = "*Searching*"
    }

}