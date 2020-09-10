package com.mylivn.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.mylivn.BaseTest
import com.mylivn.data.local.entities.Series
import com.mylivn.data.sample.seriesSample
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.time.ExperimentalTime

@RunWith(RobolectricTestRunner::class)
internal class SeriesDaoTest : BaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalTime
    @ExperimentalCoroutinesApi
    @Test
    fun `test inserting and retrieving series`() = runBlockingTest {
        seriesDao.insert(seriesSample)
        val series = seriesDao.getHeroSeries(1)
        series.test {
            assertEquals(listOf(Series(1, 1, "One", "uri")), expectItem())
        }
    }
}