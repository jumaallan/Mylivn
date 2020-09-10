package com.mylivn.repository

import androidx.lifecycle.LiveData
import com.mylivn.data.local.dao.HeroDao
import com.mylivn.data.local.entities.Hero

class HeroRepository(
    private val heroDao: HeroDao,
) {

    fun getHero(heroId: Int): LiveData<Hero> = heroDao.getHero(heroId)
}