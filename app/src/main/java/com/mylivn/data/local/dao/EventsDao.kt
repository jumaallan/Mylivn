package com.mylivn.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.mylivn.data.local.entities.Events
import kotlinx.coroutines.flow.Flow

@Dao
interface EventsDao : BaseDao<Events> {

    @Query("SELECT * FROM events WHERE heroId =:heroId")
    fun getHeroEvents(heroId: Int): Flow<List<Events>>
}