@file:Suppress("UNNECESSARY_SAFE_CALL")

package com.mylivn.core.network

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.mylivn.core.data.api.MarvelAPI
import com.mylivn.core.data.models.HeroesResponse
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class MarvelRemoteMediator(
    private val marvelAPI: MarvelAPI,
) : RemoteMediator<Int, HeroesResponse>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, HeroesResponse>
    ): MediatorResult {
        return try {
            val remoteKey = getRedditKeys()
            val response = marvelAPI.fetchHeroes(
                loadSize = state.config.pageSize,
                after = remoteKey.after,
                before = remoteKey.before
            )
            val listing = response.body()?.data
            val redditPosts = listing?.children?.map { it.data }
            if (redditPosts != null) {
                redditDatabase.withTransaction {
                    redditDatabase.redditKeysDao()
                        .saveRedditKeys(RedditKeys(0, listing.after, listing.before))
                    redditDatabase.redditPostsDao().savePosts(redditPosts)
                }

            }
            MediatorResult.Success(endOfPaginationReached = listing.after == null)

        } catch (exception: IOException) {
            MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            MediatorResult.Error(exception)
        }

    }

    private suspend fun getMarvelKeys(): RedditKeys? =
        redditDatabase.redditKeysDao().getRedditKeys().firstOrNull()
}