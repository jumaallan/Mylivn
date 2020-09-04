package com.mylivn.core.data.models

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemSeries>,
    val returned: Int
)