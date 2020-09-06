package com.mylivn.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mylivn.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class HeroRepositoryTest : BaseTest() {

    private lateinit var heroRepository: HeroRepository

    @Before
    fun setUp() {
        super.setup()
        heroRepository = HeroRepository(heroDao)
    }

    @Test
    fun `test to fetch a list of heroes`() {
        runBlocking {
        }
    }
}