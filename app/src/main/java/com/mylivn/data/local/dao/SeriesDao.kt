package com.mylivn.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.mylivn.data.local.entities.Series

@Dao
interface SeriesDao : BaseDao<Series> {

    @Query("SELECT * FROM series WHERE heroId =:heroId")
    fun getHeroSeries(heroId: Int): PagingSource<Int, Series>
}