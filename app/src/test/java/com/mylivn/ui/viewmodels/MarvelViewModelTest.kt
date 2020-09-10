package com.mylivn.ui.viewmodels

import com.mylivn.BaseViewModelTest
import com.mylivn.repository.MarvelRepository
import io.mockk.mockk
import org.junit.Before

class MarvelViewModelTest : BaseViewModelTest() {

    private val marvelRepository = mockk<MarvelRepository>()
    private lateinit var marvelViewModel: MarvelViewModel

    @Before
    fun setUp() {
        marvelViewModel = MarvelViewModel(marvelRepository)
    }

//    @FlowPreview
//    @Test
//    fun `test to fetch list of heroes, and their details`() {
//
//        coEvery { marvelRepository.fetchHeroes() } returns hero
//
//        marvelViewModel.getHeroes()
//        coVerify { marvelRepository.fetchHeroes() }
//
//        marvelViewModel.heroesResponseState.test().assertValue(
//            HeroResponse(hero)
//        )
//    }
}