package com.mylivn.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.mylivn.data.local.entities.Stories

@Dao
interface StoriesDao : BaseDao<Stories> {

    @Query("SELECT * FROM stories WHERE heroId =:heroId")
    fun getHeroStories(heroId: Int): PagingSource<Int, Stories>
}