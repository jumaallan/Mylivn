package com.mylivn.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Stories(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var heroId: Int,
    var storyName: String,
    val resourceURI: String,
    val type: String
)