package com.mylivn.data.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mylivn.BaseTest
import com.mylivn.data.sample.comicsSample
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class ComicsDaoTest : BaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Test
    fun `test inserting and retrieving comics`() = runBlockingTest {
        comicsDao.insert(comicsSample)
        val comic = comicsDao.getHeroComics(1)
        // MatcherAssert.assertThat(comic., `is`(testCharacters[0].name))
    }
}