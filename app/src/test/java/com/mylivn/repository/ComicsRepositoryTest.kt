package com.mylivn.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mylivn.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class ComicsRepositoryTest : BaseTest() {

    private lateinit var comicsRepository: ComicsRepository

    @Before
    fun setUp() {
        super.setup()
        comicsRepository = ComicsRepository(comicsDao)
    }

    @Test
    fun `test to fetch list of comics for a hero`() {
        runBlocking {

        }
    }
}