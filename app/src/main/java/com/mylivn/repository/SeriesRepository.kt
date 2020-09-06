package com.mylivn.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mylivn.data.local.dao.SeriesDao
import com.mylivn.data.local.entities.Series
import kotlinx.coroutines.flow.Flow

class SeriesRepository(
    private val seriesDao: SeriesDao
) {

    fun getHeroSeries(heroId: Int): Flow<PagingData<Series>> =
        Pager(
            PagingConfig(pageSize = 40, enablePlaceholders = false, prefetchDistance = 3),
            pagingSourceFactory = { seriesDao.getHeroSeries(heroId) }
        ).flow

}