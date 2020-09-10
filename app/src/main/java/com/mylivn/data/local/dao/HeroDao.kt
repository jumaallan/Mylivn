package com.mylivn.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mylivn.data.local.entities.Hero
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroDao : BaseDao<Hero> {

    @Query("SELECT * FROM hero WHERE heroId =:heroId")
    fun getHero(heroId: Int): LiveData<Hero>

    @Query("SELECT * FROM hero")
    fun getHeroes(): Flow<List<Hero>>

    @Query("SELECT * FROM hero")
    suspend fun fetchAllHeroes(): List<Hero>
}