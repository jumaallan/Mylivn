package com.mylivn.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.mylivn.data.local.entities.Events

@Dao
interface EventsDao : BaseDao<Events> {

    @Query("SELECT * FROM events WHERE heroId =:heroId")
    fun getHeroEvents(heroId: Int): PagingSource<Int, Events>
}