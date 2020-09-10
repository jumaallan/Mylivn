package com.mylivn.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mylivn.data.local.entities.Comics
import com.mylivn.repository.ComicsRepository

class ComicsViewModel(
    private val comicsRepository: ComicsRepository
) : ViewModel() {

    fun getHeroComics(heroId: Int): LiveData<PagingData<Comics>> =
        comicsRepository.getHeroComics(heroId).cachedIn(viewModelScope).asLiveData()
}