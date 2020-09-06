package com.mylivn.data.local.entities

import androidx.room.PrimaryKey

data class Stories(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var heroName: String
)