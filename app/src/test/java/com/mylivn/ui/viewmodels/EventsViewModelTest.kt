package com.mylivn.ui.viewmodels

import com.mylivn.BaseViewModelTest
import com.mylivn.repository.EventsRepository
import io.mockk.mockk
import kotlinx.coroutines.FlowPreview
import org.junit.Before
import org.junit.Test

class EventsViewModelTest : BaseViewModelTest() {

    private val eventRepository = mockk<EventsRepository>()
    private lateinit var eventsViewModel: EventsViewModel

    @Before
    fun setUp() {
        eventsViewModel = EventsViewModel(eventRepository)
    }

    @FlowPreview
    @Test
    fun `test to fetch list of events for a hero`() {

    }
}