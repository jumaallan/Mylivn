package com.mylivn.data.local.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["heroId"], unique = true)])
data class Hero(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var heroId: Int,
    var heroName: String,
    var heroDescription: String,
    var heroThumbnail: String
)