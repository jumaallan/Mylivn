package com.mylivn.data.repository

import com.mylivn.core.data.api.HeroAPI
import com.mylivn.data.dao.HeroDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class HeroRepository(
    private val heroAPI: HeroAPI,
    private val heroDao: HeroDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

}