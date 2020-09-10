package com.mylivn.data.network

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.mylivn.core.data.api.MarvelAPI
import com.mylivn.core.network.NetworkResult
import com.mylivn.core.network.safeApiCall
import com.mylivn.data.local.dao.*
import com.mylivn.data.local.entities.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

@ExperimentalPagingApi
class MarvelRemoteMediator(
    private val marvelAPI: MarvelAPI,
    private val heroDao: HeroDao,
    private val comicsDao: ComicsDao,
    private val eventsDao: EventsDao,
    private val seriesDao: SeriesDao,
    private val storiesDao: StoriesDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RemoteMediator<Int, Hero>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Hero>
    ): MediatorResult {
        return try {
            var pageLimit = 0
            val marvelResponse = safeApiCall(ioDispatcher) {
                return@safeApiCall marvelAPI.fetchHeroes(
                    "a5df6fc2b951d20f5aaef40803ab166c",
                    "d1489c94740f45d9c0fd62234fb2432a",
                    "1",
                    limit = state.config.pageSize
                )
            }
            when (marvelResponse) {
                is NetworkResult.Success -> {
                    pageLimit = marvelResponse.data.data.limit
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
            MediatorResult.Success(endOfPaginationReached = pageLimit == null)
        } catch (exception: IOException) {
            MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            MediatorResult.Error(exception)
        }
    }
}