package com.mylivn.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mylivn.data.local.entities.Stories
import com.mylivn.repository.StoriesRepository
import kotlinx.coroutines.flow.Flow

class StoriesViewModel(
    private val storiesRepository: StoriesRepository
) : ViewModel() {

    fun getHeroStories(heroId: Int): Flow<PagingData<Stories>> =
        storiesRepository.getHeroStories(heroId).cachedIn(viewModelScope)
}