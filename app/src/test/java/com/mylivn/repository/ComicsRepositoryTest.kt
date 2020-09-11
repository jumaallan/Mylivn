package com.mylivn.repository

import com.mylivn.BaseTest
import com.mylivn.data.sample.comicsSample
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
internal class ComicsRepositoryTest : BaseTest() {

    private lateinit var comicsRepository: ComicsRepository

    @Before
    fun setUp() {
        super.setup()
        comicsRepository = ComicsRepository(comicsDao)
    }

    @Test
    fun `test to fetch list of comics for a hero`() = runBlocking {
        comicsDao.insert(comicsSample)
        val comics = comicsRepository.getHeroComics(1)
        val actual = comics.first().first()
        val expected = comicsSample.first()
        assertThat(actual.comicName, `is`(expected.comicName))
        assertThat(actual.resourceURI, `is`(expected.resourceURI))
    }
}