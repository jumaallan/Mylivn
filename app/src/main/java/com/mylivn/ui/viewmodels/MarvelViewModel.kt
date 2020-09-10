package com.mylivn.ui.viewmodels

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mylivn.core.data.models.HeroesResponse
import com.mylivn.core.network.NetworkResult
import com.mylivn.data.local.entities.Hero
import com.mylivn.data.models.HeroResponse
import com.mylivn.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MarvelViewModel(
    private val marvelRepository: MarvelRepository
) : ViewModel() {
    val marvelResponse = MutableLiveData<NetworkResult<HeroesResponse>>()

    fun fetchMarvelHeroes(): LiveData<PagingData<Hero>> =
        marvelRepository.getMarvelHeroes().asLiveData()


    fun fetchCharacters() {
        viewModelScope.launch {
            marvelResponse.postValue(marvelRepository.fetchMarvelHeroes())
        }
    }

    suspend fun areItemsPresent(): Boolean {
        return marvelRepository.areItemsPresent()
    }
}