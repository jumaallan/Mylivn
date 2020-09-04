package com.mylivn.di

import androidx.room.Room
import com.mylivn.data.Database
import com.mylivn.data.repository.HeroRepository
import com.mylivn.ui.viewmodels.HeroViewModel
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
}

private val repositoryModule: Module = module {
    single { HeroRepository(get(), get()) }
}

private val viewModelModule: Module = module {
    viewModel { HeroViewModel(get()) }
}

val appModules: List<Module> = listOf(
    databaseModule,
    daoModule,
    repositoryModule,
    viewModelModule
)