package com.mylivn.ui.viewmodels

import com.jraska.livedata.test
import com.mylivn.BaseViewModelTest
import com.mylivn.data.models.HeroResponse
import com.mylivn.data.sample.hero
import com.mylivn.repository.MarvelRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.FlowPreview
import org.junit.Before
import org.junit.Test

class MarvelViewModelTest : BaseViewModelTest() {

    private val marvelRepository = mockk<MarvelRepository>()
    private lateinit var marvelViewModel: MarvelViewModel

    @Before
    fun setUp() {
        marvelViewModel = MarvelViewModel(
            marvelRepository
        )
    }

    @FlowPreview
    @Test
    fun `test to fetch list of heroes, and their details`() {

        coEvery { marvelRepository.fetchHeroes() } returns hero

        marvelViewModel.getHeroes()
        coVerify { marvelRepository.fetchHeroes() }

        marvelViewModel.heroesResponseState.test().assertValue(
            HeroResponse(
                hero
            )
        )

    }
}