package com.mylivn.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Series(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var heroId: Int,
    var seriesName: String,
    val resourceURI: String
)