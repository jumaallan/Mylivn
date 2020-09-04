package com.mylivn.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mylivn.data.repository.HeroRepository
import com.mylivn.ui.adapter.HeroResponse
import kotlinx.coroutines.launch

class HeroViewModel(
    private val heroRepository: HeroRepository
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
            heroes = heroRepository.fetchHeroes()
        )
    }
}