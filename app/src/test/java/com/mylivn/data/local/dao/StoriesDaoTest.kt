package com.mylivn.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mylivn.BaseTest
import com.mylivn.data.sample.storiesSample
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class StoriesDaoTest : BaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Test
    fun `test inserting and retrieving stories`() = runBlockingTest {
        storiesDao.insert(storiesSample)
        val stories = storiesDao.getHeroStories(1)
        // MatcherAssert.assertThat(comic., `is`(testCharacters[0].name))
    }
}