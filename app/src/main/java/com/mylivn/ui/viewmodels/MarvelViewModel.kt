package com.mylivn.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mylivn.data.local.entities.Hero
import com.mylivn.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MarvelViewModel(
    private val marvelRepository: MarvelRepository
) : ViewModel() {

    fun fetchMarvelHeroes(): LiveData<PagingData<Hero>> =
        marvelRepository.getMarvelHeroes().asLiveData()


    fun fetchCharacters() {
        viewModelScope.launch {
            marvelRepository.fetchMarvelHeroes()
        }
    }
}