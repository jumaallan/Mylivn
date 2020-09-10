package com.mylivn.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mylivn.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class StoriesRepositoryTest : BaseTest() {

    private lateinit var storiesRepository: StoriesRepository

    @Before
    fun setUp() {
        super.setup()
        storiesRepository = StoriesRepository(storiesDao)
    }

    @Test
    fun `test to fetch list of stories for a hero`() = runBlocking {

    }
}