package com.mylivn

import android.app.Application
import android.os.Build
import com.facebook.stetho.Stetho
import com.mylivn.core.di.coreModules
import com.mylivn.core.utils.CrashlyticsTree
import com.mylivn.di.appModules
import org.jetbrains.annotations.NotNull
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.error.KoinAppAlreadyStartedException
import org.koin.core.logger.Level
import org.koin.core.module.Module
import timber.log.Timber
import javax.annotation.Nullable

/**
 * Mylivn
 *
 * This is the main application class, that instantiates a few things:
 *      - KOIN : For dependency injection
 *      - Stetho : To debug our shared preferences and room db. ONLY available on debug APK builds
 *      - Timber : To ease logging in our application
 */
class Mylivn : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initStetho()
        initTimber()
    }

    private fun initKoin() {
        try {
            startKoin {
                androidLogger(Level.ERROR)
                androidContext(applicationContext)
                val modules = mutableListOf<Module>().apply {
                    addAll(coreModules)
                    addAll(appModules)
                }
                modules(modules)
            }
        } catch (error: KoinAppAlreadyStartedException) {
            Timber.e(error.localizedMessage)
        }
    }

    private fun initStetho() {
        if (!isRoboUnitTest() && BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                @Nullable
                override fun createStackElementTag(@NotNull element: StackTraceElement): String? {
                    return super.createStackElementTag(element) + ":" + element.lineNumber
                }
            })
        } else {
            Timber.plant(CrashlyticsTree())
        }
    }

    private fun isRoboUnitTest(): Boolean = "robolectric" == Build.FINGERPRINT
}