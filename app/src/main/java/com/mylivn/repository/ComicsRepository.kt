package com.mylivn.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mylivn.data.local.dao.ComicsDao
import com.mylivn.data.local.entities.Comics
import kotlinx.coroutines.flow.Flow

class ComicsRepository(
    private val comicsDao: ComicsDao
) {

    fun getHeroComics(heroId: Int): Flow<PagingData<Comics>> =
        Pager(
            PagingConfig(pageSize = 40, enablePlaceholders = false, prefetchDistance = 3),
            pagingSourceFactory = { comicsDao.getHeroComics(heroId) }
        ).flow
}