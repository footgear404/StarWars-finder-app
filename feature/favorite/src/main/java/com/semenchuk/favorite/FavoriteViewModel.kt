package com.semenchuk.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.data.room.SWDatabaseDao
import com.semenchuk.details.utils.Mapper.Companion.toPeopleResponse
import com.semenchuk.details.utils.Mapper.Companion.toStarshipResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val swDatabaseDao: SWDatabaseDao) : ViewModel() {

    private var _favoritePerson = MutableStateFlow<List<PeopleResponse>?>(null)
    val favoritePerson get() = _favoritePerson.asStateFlow()

    private var _favoriteStarships = MutableStateFlow<List<StarshipsResponse>?>(null)
    val favoriteStarships get() = _favoriteStarships.asStateFlow()


    fun loadFavoritePerson() {
        val listPersons = mutableListOf<PeopleResponse>()
        viewModelScope.launch(Dispatchers.IO) {
            swDatabaseDao.getFavoritePersons().forEach {
                listPersons.add(it.toPeopleResponse())
            }
            _favoritePerson.value = listPersons
        }
    }

    fun loadFavoriteStarship() {
        val listPersons = mutableListOf<StarshipsResponse>()
        viewModelScope.launch(Dispatchers.IO) {
            swDatabaseDao.getFavoriteStarships().forEach {
                listPersons.add(it.toStarshipResponse())
            }
            _favoriteStarships.value = listPersons
        }
    }
}