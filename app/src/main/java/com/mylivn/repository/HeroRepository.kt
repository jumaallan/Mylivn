package com.mylivn.repository

import com.mylivn.data.local.dao.HeroDao
import com.mylivn.data.local.entities.Hero

class HeroRepository(
    private val heroDao: HeroDao,
) {

    suspend fun getHero(heroId: Int): Hero = heroDao.getHero(heroId)
}