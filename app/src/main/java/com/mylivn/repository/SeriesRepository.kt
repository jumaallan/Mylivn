package com.mylivn.repository

import com.mylivn.data.local.dao.SeriesDao
import com.mylivn.data.local.entities.Series
import kotlinx.coroutines.flow.Flow

class SeriesRepository(
    private val seriesDao: SeriesDao
) {

    fun getHeroSeries(heroId: Int): Flow<List<Series>> = seriesDao.getHeroSeries(heroId)
}