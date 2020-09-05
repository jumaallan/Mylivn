package com.mylivn.data.models

import com.mylivn.core.data.models.HeroesResponse
import com.mylivn.core.network.NetworkResult

data class HeroResponse(
    val heroes: NetworkResult<HeroesResponse?>?,
)