package com.mylivn.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mylivn.BaseTest
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class MarvelRepositoryTest : BaseTest() {

    private lateinit var marvelRepository: MarvelRepository

    @Before
    fun setUp() {
        super.setup()
//        marvelRepository = MarvelRepository(marvelAPI, heroDao)
    }

//    @Test
//    fun `test to fetch list of heroes, and their details`() {
//        runBlocking {
//            val heroResponse =
//                marvelRepository.fetchHeroes()
//            Truth.assertThat(heroResponse).isInstanceOf(NetworkResult.Success::class.java)
//            (heroResponse as NetworkResult.Success)
//            Truth.assertThat(heroResponse.data.data.results[0].name).matches("3-D Man")
//        }
//    }
}