package com.mylivn.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mylivn.data.local.dao.EventsDao
import com.mylivn.data.local.entities.Events
import kotlinx.coroutines.flow.Flow

class EventsRepository(
    private val eventsDao: EventsDao
) {

    fun getHeroEvents(heroId: Int): Flow<PagingData<Events>> =
        Pager(
            PagingConfig(pageSize = 40, enablePlaceholders = false, prefetchDistance = 3),
            pagingSourceFactory = { eventsDao.getHeroEvents(heroId) }
        ).flow

}