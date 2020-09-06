package com.mylivn.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.mylivn.repository.StoriesRepository

class StoriesViewModel(
    private val storiesRepository: StoriesRepository
) : ViewModel()