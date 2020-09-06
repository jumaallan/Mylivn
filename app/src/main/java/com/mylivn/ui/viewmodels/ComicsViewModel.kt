package com.mylivn.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.mylivn.repository.ComicsRepository

class ComicsViewModel(
    private val comicsRepository: ComicsRepository
) : ViewModel()