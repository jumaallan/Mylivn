package com.mylivn.data.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.mylivn.data.local.entities.Hero

@Dao
interface HeroDao : BaseDao<Hero> {

    @Query("SELECT * FROM hero WHERE heroId =:heroId")
    suspend fun getHero(heroId: Int): Hero

    @Query("SELECT * FROM hero")
    fun getHeroes(): PagingSource<Int, Hero>

    @Query("SELECT * FROM hero")
    suspend fun fetchAllHeroes(): List<Hero>

    @Query("SELECT * FROM hero")
    fun fetchHeroes(): LiveData<List<Hero>>
}