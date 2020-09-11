package com.mylivn.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.mylivn.BaseTest
import com.mylivn.data.local.entities.Stories
import com.mylivn.data.sample.storiesSample
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.time.ExperimentalTime

@RunWith(RobolectricTestRunner::class)
internal class StoriesDaoTest : BaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalTime
    @ExperimentalCoroutinesApi
    @Test
    fun `test inserting and retrieving stories`() = runBlockingTest {
        storiesDao.insert(storiesSample)
        val stories = storiesDao.getHeroStories(1)
        stories.test {
            assertEquals(listOf(Stories(1, 1, "One", "uri", "type")), expectItem())
        }
    }
}