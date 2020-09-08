package com.mylivn.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mylivn.data.local.entities.Events
import com.mylivn.repository.EventsRepository
import kotlinx.coroutines.flow.Flow

class EventsViewModel(
    private val eventsRepository: EventsRepository
) : ViewModel() {

    fun getHeroEvents(heroId: Int): Flow<PagingData<Events>> =
        eventsRepository.getHeroEvents(heroId).cachedIn(viewModelScope)
}