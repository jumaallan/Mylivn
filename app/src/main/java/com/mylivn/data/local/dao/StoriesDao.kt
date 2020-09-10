package com.mylivn.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.mylivn.data.local.entities.Stories
import kotlinx.coroutines.flow.Flow

@Dao
interface StoriesDao : BaseDao<Stories> {

    @Query("SELECT * FROM stories WHERE heroId =:heroId")
    fun getHeroStories(heroId: Int): Flow<List<Stories>>
}