package com.mylivn.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import com.mylivn.data.local.entities.Comics
import com.mylivn.repository.ComicsRepository

class ComicsViewModel(
    private val comicsRepository: ComicsRepository
) : ViewModel() {

    fun getHeroComics(heroId: Int): LiveData<PagingData<Comics>> =
        comicsRepository.getHeroComics(heroId).asLiveData()
}