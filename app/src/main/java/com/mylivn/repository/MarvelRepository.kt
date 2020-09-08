package com.mylivn.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mylivn.core.data.api.MarvelAPI
import com.mylivn.data.local.dao.*
import com.mylivn.data.local.entities.Hero
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class MarvelRepository(
    private val marvelAPI: MarvelAPI,
    private val marvelKeysDao: MarvelKeysDao,
    private val heroDao: HeroDao,
    private val comicsDao: ComicsDao,
    private val eventsDao: EventsDao,
    private val seriesDao: SeriesDao,
    private val storiesDao: StoriesDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    @OptIn(ExperimentalPagingApi::class)
    fun fetchMarvelHeroes(): Flow<PagingData<Hero>> {
        return Pager(
            PagingConfig(pageSize = 40, enablePlaceholders = false, prefetchDistance = 3),
//            remoteMediator = MarvelRemoteMediator(
//                marvelAPI,
//                marvelKeysDao,
//                heroDao,
//                comicsDao,
//                eventsDao,
//                seriesDao,
//                storiesDao
//            ),
            pagingSourceFactory = { heroDao.getHeroes() }
        ).flow
    }

}