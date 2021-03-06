package com.mylivn.ui.viewmodels

import androidx.lifecycle.*
import com.mylivn.core.data.models.HeroesResponse
import com.mylivn.core.network.NetworkResult
import com.mylivn.data.local.entities.Hero
import com.mylivn.repository.MarvelRepository
import kotlinx.coroutines.launch

class MarvelViewModel(
    private val marvelRepository: MarvelRepository
) : ViewModel() {
    val marvelResponse = MutableLiveData<NetworkResult<HeroesResponse>>()

    fun fetchMarvelHeroes(): LiveData<List<Hero>> =
        marvelRepository.getMarvelHeroes().asLiveData()

    fun fetchCharacters() {
        viewModelScope.launch {
            marvelResponse.postValue(marvelRepository.fetchMarvelHeroes())
        }
    }
}