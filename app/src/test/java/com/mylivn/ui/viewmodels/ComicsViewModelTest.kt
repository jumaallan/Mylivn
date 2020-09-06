package com.mylivn.ui.viewmodels

import com.mylivn.BaseViewModelTest
import com.mylivn.repository.ComicsRepository
import io.mockk.mockk
import kotlinx.coroutines.FlowPreview
import org.junit.Before
import org.junit.Test

class ComicsViewModelTest : BaseViewModelTest() {

    private val comicsRepository = mockk<ComicsRepository>()
    private lateinit var comicsViewModel: ComicsViewModel

    @Before
    fun setUp() {
        comicsViewModel = ComicsViewModel(comicsRepository)
    }

    @FlowPreview
    @Test
    fun `test to fetch list of comics for a hero`() {

    }
}