package com.mylivn.di

import androidx.room.Room
import com.mylivn.data.local.Database
import com.mylivn.repository.*
import com.mylivn.ui.viewmodels.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 *  App DI Module
 *
 *  This file is responsible for setting up and injecting the following
 *      - Database (Room DB)
 *      - DAOs
 *      - Repository
 *      - ViewModels
 *
 * The modules are only available on the app module. They are app specific and therefore should
 * be managed centrally inside the app module.
 *
 * This setup also allows us to re-use the globally injected modules, to avoid duplication.
 */
private val databaseModule: Module = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            Database::class.java,
            "mylivn-db"
        ).build()
    }
}

private val daoModule: Module = module {
    single { get<Database>().heroDao() }
    single { get<Database>().comicsDao() }
    single { get<Database>().eventsDao() }
    single { get<Database>().seriesDao() }
    single { get<Database>().storiesDao() }
    single { get<Database>().marvelKeysDao() }
}

private val repositoryModule: Module = module {
    single { MarvelRepository(get(), get(), get(), get(), get(), get(), get()) }
    single { HeroRepository(get()) }
    single { ComicsRepository(get()) }
    single { EventsRepository(get()) }
    single { SeriesRepository(get()) }
    single { StoriesRepository(get()) }
    single { ThemeRepository(get()) }
}

private val viewModelModule: Module = module {
    viewModel { MarvelViewModel(get()) }
    viewModel { HeroViewModel(get()) }
    viewModel { ComicsViewModel(get()) }
    viewModel { EventsViewModel(get()) }
    viewModel { SeriesViewModel(get()) }
    viewModel { StoriesViewModel(get()) }
    viewModel { ThemeViewModel(get()) }
}

val appModules: List<Module> = listOf(
    databaseModule,
    daoModule,
    repositoryModule,
    viewModelModule
)