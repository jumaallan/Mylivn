package com.mylivn.data

import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@androidx.room.Database(
    entities = [
        Character::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class Database : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
}