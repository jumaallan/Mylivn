package com.mylivn.data.sample

import com.mylivn.core.data.models.Data
import com.mylivn.core.data.models.HeroesResponse
import com.mylivn.core.data.models.Result
import com.mylivn.core.data.models.Thumbnail
import com.mylivn.core.network.NetworkResult
import com.mylivn.data.local.entities.*

val comicsSample = listOf(
    Comics(0, 1, "One", "uri")
)

val eventsSample = listOf(
    Events(0, 1, "One", "uri")
)

val heroSample = listOf(
    Hero(0, 1, "One", "description", "thumbnail")
)

val seriesSample = listOf(
    Series(0, 1, "One", "uri")
)

val storiesSample = listOf(
    Stories(0, 1, "One", "uri", "type")
)

val heroResponse = HeroesResponse(
    "",
    "",
    200,
    "",
    Data(
        0,
        20,
        0,
        listOf(
            Result(
                com.mylivn.core.data.models.Comics(
                    1,
                    "",
                    emptyList(),
                    0
                ),
                "",
                com.mylivn.core.data.models.Events(
                    1,
                    "",
                    emptyList(),
                    0
                ),
                1,
                "",
                "",
                "",
                com.mylivn.core.data.models.Series(
                    0,
                    "",
                    emptyList(),
                    1
                ),
                com.mylivn.core.data.models.Stories(
                    0,
                    "",
                    emptyList(),
                    1
                ),
                Thumbnail(
                    "",
                    ""
                ),
                emptyList()
            )
        ),
        0

    ),
    "",
    ""
)

val hero: NetworkResult<HeroesResponse> =
    NetworkResult.Success(heroResponse)