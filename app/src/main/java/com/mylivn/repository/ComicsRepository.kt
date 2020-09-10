package com.mylivn.repository

import com.mylivn.data.local.dao.ComicsDao
import com.mylivn.data.local.entities.Comics
import kotlinx.coroutines.flow.Flow

class ComicsRepository(
    private val comicsDao: ComicsDao
) {

    fun getHeroComics(heroId: Int): Flow<List<Comics>> = comicsDao.getHeroComics(heroId)
}