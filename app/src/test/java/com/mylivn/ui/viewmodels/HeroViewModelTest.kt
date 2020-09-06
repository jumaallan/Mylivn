package com.mylivn.ui.viewmodels

import com.mylivn.BaseViewModelTest
import com.mylivn.repository.HeroRepository
import io.mockk.mockk
import kotlinx.coroutines.FlowPreview
import org.junit.Before
import org.junit.Test

class HeroViewModelTest : BaseViewModelTest() {

    private val heroRepository = mockk<HeroRepository>()
    private lateinit var heroViewModel: HeroViewModel

    @Before
    fun setUp() {
        heroViewModel = HeroViewModel(heroRepository)
    }

    @FlowPreview
    @Test
    fun `test to fetch list of heroes`() {

    }
}