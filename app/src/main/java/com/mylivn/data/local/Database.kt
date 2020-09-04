package com.mylivn.data.local

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mylivn.data.local.dao.HeroDao
import com.mylivn.data.local.entities.Hero

@androidx.room.Database(
    entities = [
        Hero::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class Database : RoomDatabase() {

    abstract fun heroDao(): HeroDao
}