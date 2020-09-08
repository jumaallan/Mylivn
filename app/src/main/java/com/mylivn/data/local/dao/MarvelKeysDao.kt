package com.mylivn.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.mylivn.data.local.entities.MarvelKeys

@Dao
interface MarvelKeysDao : BaseDao<MarvelKeys> {

    @Query("SELECT * FROM marvelkeys ORDER BY id DESC")
    suspend fun getMarvelKeys(): List<MarvelKeys>
}