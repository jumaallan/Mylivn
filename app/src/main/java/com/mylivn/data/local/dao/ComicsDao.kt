package com.mylivn.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.mylivn.data.local.entities.Comics

@Dao
interface ComicsDao : BaseDao<Comics> {

    @Query("SELECT * FROM comics WHERE heroId =:heroId")
    fun getHeroComics(heroId: Int): PagingSource<Int, Comics>

}