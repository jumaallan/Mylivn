package com.mylivn.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Comics(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var heroId: Int,
    var comicName: String,
    val resourceURI: String
)