package com.mylivn.repository

import com.mylivn.data.local.dao.EventsDao
import com.mylivn.data.local.entities.Events
import kotlinx.coroutines.flow.Flow

class EventsRepository(
    private val eventsDao: EventsDao
) {

    fun getHeroEvents(heroId: Int): Flow<List<Events>> = eventsDao.getHeroEvents(heroId)
}