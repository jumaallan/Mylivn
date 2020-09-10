package com.mylivn.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mylivn.core.data.api.MarvelAPI
import com.mylivn.core.data.models.HeroesResponse
import com.mylivn.core.network.NetworkResult
import com.mylivn.core.network.safeApiCall
import com.mylivn.data.local.dao.*
import com.mylivn.data.local.entities.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class MarvelRepository(
    private val marvelAPI: MarvelAPI,
    private val heroDao: HeroDao,
    private val comicsDao: ComicsDao,
    private val eventsDao: EventsDao,
    private val seriesDao: SeriesDao,
    private val storiesDao: StoriesDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun fetchMarvelHeroes(): NetworkResult<HeroesResponse> {
        val marvelResponse = safeApiCall(ioDispatcher) {
            return@safeApiCall marvelAPI.fetchHeroes(
                "a5df6fc2b951d20f5aaef40803ab166c",
                "d1489c94740f45d9c0fd62234fb2432a",
                "1",
                limit = 40,
            )
        }
        when (marvelResponse) {
            is NetworkResult.Success -> {
                marvelResponse.data.data.results.forEach { hero ->
                    // save the hero first
                    heroDao.insert(
                        Hero(
                            0,
                            hero.id,
                            hero.name,
                            hero.description.toString(),
                            """${hero.thumbnail?.path}.${hero.thumbnail?.extension}"""
                        )
                    )
                    // save the comics
                    hero.comics?.items?.forEach { comics ->
                        comicsDao.insert(
                            Comics(
                                0,
                                hero.id,
                                comics?.name.toString(),
                                comics?.resourceURI.toString()
                            )
                        )
                    }
                    // save the events
                    hero.events?.items?.forEach { events ->
                        eventsDao.insert(
                            Events(
                                0,
                                hero.id,
                                events.name,
                                events.resourceURI
                            )
                        )
                    }
                    // save the series
                    hero.series?.items?.forEach { series ->
                        seriesDao.insert(
                            Series(
                                0,
                                hero.id,
                                series.name,
                                series.resourceURI
                            )
                        )
                    }
                    // save the stories
                    hero.stories?.items?.forEach { stories ->
                        storiesDao.insert(
                            Stories(
                                0,
                                hero.id,
                                stories.name,
                                stories.resourceURI,
                                stories.type
                            )
                        )
                    }
                }
            }
            is NetworkResult.ServerError -> {
                Timber.d(marvelResponse.errorBody?.message ?: "A network error occurred")
            }
            is NetworkResult.NetworkError -> {
                Timber.d("A network error occurred when making your request")
            }
        }
        return marvelResponse
    }

    fun getMarvelHeroes(): Flow<PagingData<Hero>> =
        Pager(
            PagingConfig(pageSize = 40, enablePlaceholders = false, prefetchDistance = 3),
            pagingSourceFactory = { heroDao.getHeroes() }
        ).flow

    suspend fun areItemsPresent(): Boolean =
        heroDao.fetchAllHeroes().isNotEmpty()
}