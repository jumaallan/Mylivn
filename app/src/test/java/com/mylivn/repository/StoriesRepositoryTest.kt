package com.mylivn.repository

import com.mylivn.BaseTest
import com.mylivn.data.sample.storiesSample
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
internal class StoriesRepositoryTest : BaseTest() {

    private lateinit var storiesRepository: StoriesRepository

    @Before
    fun setUp() {
        super.setup()
        storiesRepository = StoriesRepository(storiesDao)
    }

    @Test
    fun `test to fetch list of stories for a hero`() = runBlocking {
        storiesDao.insert(storiesSample)
        val stories = storiesRepository.getHeroStories(1)
        val actual = stories.first().first()
        val expected = storiesSample.first()
        MatcherAssert.assertThat(actual.storyName, CoreMatchers.`is`(expected.storyName))
        MatcherAssert.assertThat(actual.resourceURI, CoreMatchers.`is`(expected.resourceURI))
    }
}