package com.mylivn.repository

import com.mylivn.BaseTest
import com.mylivn.core.network.NetworkResult.Success
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
internal class MarvelRepositoryTest : BaseTest() {

    private lateinit var marvelRepository: MarvelRepository

    @Before
    fun setUp() {
        super.setup()
        marvelRepository =
            MarvelRepository(marvelAPI, heroDao, comicsDao, eventsDao, seriesDao, storiesDao)
    }

    @Test
    fun `test to fetch list of heroes, and their details`() = runBlocking {
        val result = marvelRepository.fetchMarvelHeroes()
        assertThat(result, instanceOf(Success::class.java))
    }
}