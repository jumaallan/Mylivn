package com.mylivn.ui.viewmodels

import androidx.lifecycle.ViewModel
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

    fun fetchMarvelHeroes(): Flow<PagingData<Hero>> =
        marvelRepository.getMarvelHeroes().cachedIn(viewModelScope)

    fun fetchCharacters() = viewModelScope.launch {
        marvelRepository.fetchMarvelHeroes()
    }

}