package com.mylivn.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hero(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var heroName: String,
)

