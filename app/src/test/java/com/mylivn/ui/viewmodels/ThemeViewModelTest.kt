package com.mylivn.ui.viewmodels

import com.mylivn.BaseViewModelTest
import com.mylivn.repository.ThemeRepository
import io.mockk.mockk
import kotlinx.coroutines.FlowPreview
import org.junit.Before
import org.junit.Test

class ThemeViewModelTest : BaseViewModelTest() {

    private val themeRepository = mockk<ThemeRepository>()
    private lateinit var themeViewModel: ThemeViewModel

    @Before
    fun setUp() {
        themeViewModel = ThemeViewModel(
            themeRepository
        )
    }

    @FlowPreview
    @Test
    fun `test to test app theme`() {

    }
}