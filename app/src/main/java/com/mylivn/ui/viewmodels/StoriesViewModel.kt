package com.mylivn.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import com.mylivn.data.local.entities.Stories
import com.mylivn.repository.StoriesRepository

class StoriesViewModel(
    private val storiesRepository: StoriesRepository
) : ViewModel() {

    fun getHeroSeries(heroId: Int): LiveData<PagingData<Stories>> =
        storiesRepository.getHeroStories(heroId).asLiveData()

}