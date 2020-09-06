package com.mylivn.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mylivn.data.local.dao.StoriesDao
import com.mylivn.data.local.entities.Stories
import kotlinx.coroutines.flow.Flow

class StoriesRepository(
    private val storiesDao: StoriesDao
) {

    fun getHeroStories(heroId: Int): Flow<PagingData<Stories>> =
        Pager(
            PagingConfig(pageSize = 40, enablePlaceholders = false, prefetchDistance = 3),
            pagingSourceFactory = { storiesDao.getHeroStories(heroId) }
        ).flow

}