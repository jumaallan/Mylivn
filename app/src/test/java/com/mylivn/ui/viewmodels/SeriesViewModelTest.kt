package com.mylivn.ui.viewmodels

import com.mylivn.BaseViewModelTest
import com.mylivn.repository.SeriesRepository
import io.mockk.mockk
import kotlinx.coroutines.FlowPreview
import org.junit.Before
import org.junit.Test

class SeriesViewModelTest : BaseViewModelTest() {

    private val seriesRepository = mockk<SeriesRepository>()
    private lateinit var seriesViewModel: SeriesViewModel

    @Before
    fun setUp() {
        seriesViewModel = SeriesViewModel(seriesRepository)
    }

    @FlowPreview
    @Test
    fun `test to fetch list of series for a hero`() {

    }
}