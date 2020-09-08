package com.mylivn.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MarvelKeys(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val after: String?,
    val before: String?
)