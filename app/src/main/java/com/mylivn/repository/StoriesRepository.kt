package com.mylivn.repository

import com.mylivn.data.local.dao.StoriesDao
import com.mylivn.data.local.entities.Stories
import kotlinx.coroutines.flow.Flow

class StoriesRepository(
    private val storiesDao: StoriesDao
) {

    fun getHeroStories(heroId: Int): Flow<List<Stories>> = storiesDao.getHeroStories(heroId)
}