package com.mylivn.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.mylivn.repository.SeriesRepository

class SeriesViewModel(
    private val seriesRepository: SeriesRepository
) : ViewModel()