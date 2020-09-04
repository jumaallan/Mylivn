package com.mylivn.data

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mylivn.data.dao.HeroDao
import com.mylivn.data.model.Hero

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