package com.mylivn.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.mylivn.data.local.entities.Hero
import com.mylivn.repository.HeroRepository

class HeroViewModel(
    private val heroRepository: HeroRepository
) : ViewModel() {

    fun getHero(heroId: Int): Hero = heroRepository.getHero(heroId)
}