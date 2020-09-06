package com.mylivn.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mylivn.data.models.HeroResponse
import com.mylivn.repository.MarvelRepository
import kotlinx.coroutines.launch

class MarvelViewModel(
    private val marvelRepository: MarvelRepository
) : ViewModel() {

    val heroesResponseState: LiveData<HeroResponse>
        get() = heroesResponse

    private var heroesResponse =
        MutableLiveData<HeroResponse>(HeroResponse(null))

    fun getHeroes() = viewModelScope.launch {
        fetchHeroes()
    }

    private suspend fun fetchHeroes() {
        heroesResponse.value = heroesResponse.value?.copy(
            heroes = marvelRepository.fetchHeroes()
        )
    }
}