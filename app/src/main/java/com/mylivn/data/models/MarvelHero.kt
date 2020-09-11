package com.mylivn.data.models

data class MarvelHero(
    val heroName: String,
    val heroDescription: String,
    val heroThumbnail: String,
    val heroId: Int,
    val isSelected: Boolean = false
)