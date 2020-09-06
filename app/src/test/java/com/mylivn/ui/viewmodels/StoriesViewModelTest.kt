package com.mylivn.ui.viewmodels

import com.mylivn.BaseViewModelTest
import com.mylivn.repository.StoriesRepository
import io.mockk.mockk
import kotlinx.coroutines.FlowPreview
import org.junit.Before
import org.junit.Test

class StoriesViewModelTest : BaseViewModelTest() {

    private val storiesRepository = mockk<StoriesRepository>()
    private lateinit var storiesViewModel: StoriesViewModel

    @Before
    fun setUp() {
        storiesViewModel = StoriesViewModel(storiesRepository)
    }

    @FlowPreview
    @Test
    fun `test to fetch list of stories for a hero`() {
    }
}