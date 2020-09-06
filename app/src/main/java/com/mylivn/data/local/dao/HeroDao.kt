package com.mylivn.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.mylivn.data.local.entities.Hero

@Dao
interface HeroDao : BaseDao<Hero> {

    @Query("SELECT * FROM hero WHERE heroId =:heroId")
    fun getHero(heroId: Int): Hero
}