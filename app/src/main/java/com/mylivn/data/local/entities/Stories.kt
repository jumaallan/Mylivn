package com.mylivn.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Stories(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var heroId: Int,
    var heroName: String
)