package com.mylivn

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.gson.GsonBuilder
import com.mylivn.core.data.api.HeroAPI
import com.mylivn.data.local.Database
import com.mylivn.data.local.dao.*
import com.mylivn.dispatcher.MockRequestDispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

internal open class BaseTest {

    // mock web server and network api
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var loggingInterceptor: HttpLoggingInterceptor
    private lateinit var heroAPI: HeroAPI

    // database and dao
    private lateinit var database: Database
    protected lateinit var comicsDao: ComicsDao
    protected lateinit var eventsDao: EventsDao
    protected lateinit var heroDao: HeroDao
    protected lateinit var seriesDao: SeriesDao
    protected lateinit var storiesDao: StoriesDao

    @Before
    open fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = MockRequestDispatcher()
        mockWebServer.start()
        loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        okHttpClient = buildOkhttpClient(loggingInterceptor)

        val gson = GsonBuilder()
            .serializeNulls()
            .create()

        heroAPI = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(HeroAPI::class.java)

        val context = ApplicationProvider.getApplicationContext<Context>()
        database =
            Room.inMemoryDatabaseBuilder(context, Database::class.java).allowMainThreadQueries()
                .build()
        comicsDao = database.comicsDao()
        eventsDao = database.eventsDao()
        heroDao = database.heroDao()
        seriesDao = database.seriesDao()
        storiesDao = database.storiesDao()
    }

    @After
    @Throws(IOException::class)
    open fun tearDown() {
        mockWebServer.shutdown()
        database.close()
    }

    private fun buildOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }
}