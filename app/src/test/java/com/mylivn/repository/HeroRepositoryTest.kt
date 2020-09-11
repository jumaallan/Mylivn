package com.mylivn.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.test
import com.mylivn.BaseTest
import com.mylivn.data.sample.heroSample
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
internal class HeroRepositoryTest : BaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var heroRepository: HeroRepository

    @Before
    fun setUp() {
        super.setup()
        heroRepository = HeroRepository(heroDao)
    }

    @Test
    fun `test to fetch a list of heroes`() = runBlocking {
        heroDao.insert(heroSample)
        val expected = heroSample.first()
        val hero = heroRepository.getHero(1)
        hero.test().assertValue {
            it.heroName == expected.heroName
        }
        Unit
    }
}