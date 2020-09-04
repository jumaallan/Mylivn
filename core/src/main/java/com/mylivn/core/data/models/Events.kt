package com.mylivn.core.data.models

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemEvent>,
    val returned: Int
)