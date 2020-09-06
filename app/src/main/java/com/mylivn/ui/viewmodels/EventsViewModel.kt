package com.mylivn.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import com.mylivn.data.local.entities.Events
import com.mylivn.repository.EventsRepository

class EventsViewModel(
    private val eventsRepository: EventsRepository
) : ViewModel() {

    fun getHeroEvents(heroId: Int): LiveData<PagingData<Events>> =
        eventsRepository.getHeroEvents(heroId).asLiveData()

}