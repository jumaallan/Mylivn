package com.mylivn.repository

import com.mylivn.BaseTest
import com.mylivn.data.sample.eventsSample
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
internal class EventsRepositoryTest : BaseTest() {

    private lateinit var eventsRepository: EventsRepository

    @Before
    fun setUp() {
        super.setup()
        eventsRepository = EventsRepository(eventsDao)
    }

    @Test
    fun `test to fetch list of events for a hero`() = runBlocking {
        eventsDao.insert(eventsSample)
        val events = eventsRepository.getHeroEvents(1)
        val actual = events.first().first()
        val expected = eventsSample.first()
        assertThat(actual.eventName, `is`(expected.eventName))
        assertThat(actual.resourceURI, `is`(expected.resourceURI))
    }
}