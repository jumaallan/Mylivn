package com.mylivn.data.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingData
import com.mylivn.BaseTest
import com.mylivn.data.sample.comicsSample
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
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
        assertThat(comic, `is`(PagingData.from(comicsSample)))
    }
}