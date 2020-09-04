package com.mylivn.core.data.api

import com.mylivn.core.data.models.HeroesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroAPI {

    @GET("v1/public/characters")
    suspend fun fetchHeroes(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") timeStamp: String
    ): HeroesResponse
}