package com.mylivn.data.repository

import com.mylivn.core.data.api.HeroAPI
import com.mylivn.core.data.models.HeroesResponse
import com.mylivn.core.network.NetworkResult
import com.mylivn.core.network.safeApiCall
import com.mylivn.data.dao.HeroDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class HeroRepository(
    private val heroAPI: HeroAPI,
    private val heroDao: HeroDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun fetchHeroes(): NetworkResult<HeroesResponse> =
        safeApiCall(ioDispatcher) {
            return@safeApiCall heroAPI.fetchHeroes(
                "a5df6fc2b951d20f5aaef40803ab166c",
                "d1489c94740f45d9c0fd62234fb2432a",
                "1"
            )
        }
}