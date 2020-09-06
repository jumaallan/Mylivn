package com.mylivn.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mylivn.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class SeriesRepositoryTest : BaseTest() {

    private lateinit var seriesRepository: SeriesRepository

    @Before
    fun setUp() {
        super.setup()
        seriesRepository = SeriesRepository(seriesDao)
    }

    @Test
    fun `test to fetch list of series for a hero`() {
        runBlocking {
        }
    }
}