package com.mylivn.repository

import com.mylivn.BaseTest
import com.mylivn.data.sample.seriesSample
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
internal class SeriesRepositoryTest : BaseTest() {

    private lateinit var seriesRepository: SeriesRepository

    @Before
    fun setUp() {
        super.setup()
        seriesRepository = SeriesRepository(seriesDao)
    }

    @Test
    fun `test to fetch list of series for a hero`() = runBlocking {
        seriesDao.insert(seriesSample)
        val series = seriesRepository.getHeroSeries(1)
        val actual = series.first().first()
        val expected = seriesSample.first()
        MatcherAssert.assertThat(actual.seriesName, CoreMatchers.`is`(expected.seriesName))
        MatcherAssert.assertThat(actual.resourceURI, CoreMatchers.`is`(expected.resourceURI))
    }
}