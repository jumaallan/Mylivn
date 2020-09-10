package com.mylivn.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mylivn.data.local.entities.Stories
import com.mylivn.repository.StoriesRepository
import kotlinx.coroutines.flow.Flow

class StoriesViewModel(
    private val storiesRepository: StoriesRepository
) : ViewModel() {

    fun getHeroStories(heroId: Int): LiveData<PagingData<Stories>> =
        storiesRepository.getHeroStories(heroId).cachedIn(viewModelScope).asLiveData()
}