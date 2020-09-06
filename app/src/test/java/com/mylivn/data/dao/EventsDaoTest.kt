package com.mylivn.data.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mylivn.BaseTest
import com.mylivn.data.sample.eventsSample
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class EventsDaoTest : BaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Test
    fun `test inserting and retrieving events`() = runBlockingTest {
        eventsDao.insert(eventsSample)
        val event = eventsDao.getHeroEvents(1)
        // MatcherAssert.assertThat(comic., `is`(testCharacters[0].name))
    }
}