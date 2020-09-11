package com.mylivn.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.mylivn.BaseTest
import com.mylivn.data.local.entities.Comics
import com.mylivn.data.sample.comicsSample
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.time.ExperimentalTime

@RunWith(RobolectricTestRunner::class)
internal class ComicsDaoTest : BaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalTime
    @ExperimentalCoroutinesApi
    @Test
    fun `test inserting and retrieving comics`() = runBlockingTest {
        comicsDao.insert(comicsSample)
        val comics = comicsDao.getHeroComics(1)
        comics.test {
            assertEquals(listOf(Comics(1, 1, "One", "uri")), expectItem())
        }
    }
}