package com.mylivn.core.data.models

data class Comics(
    val available: Int?,
    val collectionURI: String?,
    val itemComics: List<ItemComics?>?,
    val returned: Int?
)