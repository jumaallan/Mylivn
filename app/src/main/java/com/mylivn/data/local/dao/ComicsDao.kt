package com.mylivn.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.mylivn.data.local.entities.Comics
import kotlinx.coroutines.flow.Flow

@Dao
interface ComicsDao : BaseDao<Comics> {

    @Query("SELECT * FROM comics WHERE heroId =:heroId")
    fun getHeroComics(heroId: Int): Flow<List<Comics>>
}