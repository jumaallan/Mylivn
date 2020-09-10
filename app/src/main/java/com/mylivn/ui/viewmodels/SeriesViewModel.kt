package com.mylivn.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mylivn.data.local.entities.Series
import com.mylivn.repository.SeriesRepository

class SeriesViewModel(
    private val seriesRepository: SeriesRepository
) : ViewModel() {

    fun getHeroSeries(heroId: Int): LiveData<PagingData<Series>> =
        seriesRepository.getHeroSeries(heroId).cachedIn(viewModelScope).asLiveData()
}