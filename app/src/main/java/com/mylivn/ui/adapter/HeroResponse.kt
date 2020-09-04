package com.mylivn.ui.adapter

import com.mylivn.core.data.models.HeroesResponse
import com.mylivn.core.network.NetworkResult

data class HeroResponse(
    val heroes: NetworkResult<HeroesResponse?>?,
)