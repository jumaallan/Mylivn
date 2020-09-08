package com.mylivn.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Events(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var heroId: Int,
    var eventName: String,
    val resourceURI: String
)