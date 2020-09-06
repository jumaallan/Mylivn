package com.mylivn.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.mylivn.repository.EventsRepository

class EventsViewModel(
    private val eventsRepository: EventsRepository
) : ViewModel()