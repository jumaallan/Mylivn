package com.mylivn.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mylivn.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class EventsRepositoryTest : BaseTest() {

    private lateinit var eventsRepository: EventsRepository

    @Before
    fun setUp() {
        super.setup()
        eventsRepository = EventsRepository(eventsDao)
    }

    @Test
    fun `test to fetch list of events for a hero`() {
        runBlocking {

        }
    }
}