package com.mylivn.data.local

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mylivn.data.local.dao.*
import com.mylivn.data.local.entities.*

@androidx.room.Database(
    entities = [
        Hero::class,
        Comics::class,
        Events::class,
        Series::class,
        Stories::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class Database : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun comicsDao(): ComicsDao
    abstract fun eventsDao(): EventsDao
    abstract fun seriesDao(): SeriesDao
    abstract fun storiesDao(): StoriesDao
}