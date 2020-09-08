package com.mylivn.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mylivn.data.local.entities.Comics
import com.mylivn.repository.ComicsRepository
import kotlinx.coroutines.flow.Flow

class ComicsViewModel(
    private val comicsRepository: ComicsRepository
) : ViewModel() {

    fun getHeroComics(heroId: Int): Flow<PagingData<Comics>> =
        comicsRepository.getHeroComics(heroId).cachedIn(viewModelScope)
}