package com.mylivn.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.mylivn.BaseTest
import com.mylivn.data.local.entities.Events
import com.mylivn.data.sample.eventsSample
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.time.ExperimentalTime

@RunWith(RobolectricTestRunner::class)
internal class EventsDaoTest : BaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalTime
    @ExperimentalCoroutinesApi
    @Test
    fun `test inserting and retrieving events`() = runBlockingTest {
        eventsDao.insert(eventsSample)
        val event = eventsDao.getHeroEvents(1)
        event.test {
            assertEquals(listOf(Events(1, 1, "One", "")), expectItem())
        }
    }
}