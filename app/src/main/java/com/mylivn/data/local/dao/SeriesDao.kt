package com.mylivn.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.mylivn.data.local.entities.Series
import kotlinx.coroutines.flow.Flow

@Dao
interface SeriesDao : BaseDao<Series> {

    @Query("SELECT * FROM series WHERE heroId =:heroId")
    fun getHeroSeries(heroId: Int): Flow<List<Series>>
}