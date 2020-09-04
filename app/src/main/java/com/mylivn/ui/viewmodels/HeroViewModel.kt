package com.mylivn.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.mylivn.data.repository.HeroRepository

class HeroViewModel(
    private val heroRepository: HeroRepository
) : ViewModel() {

}