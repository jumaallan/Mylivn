package com.mylivn.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mylivn.data.local.entities.Series
import com.mylivn.repository.SeriesRepository
import kotlinx.coroutines.flow.Flow

class SeriesViewModel(
    private val seriesRepository: SeriesRepository
) : ViewModel() {

    fun getHeroSeries(heroId: Int): Flow<PagingData<Series>> =
        seriesRepository.getHeroSeries(heroId).cachedIn(viewModelScope)
}