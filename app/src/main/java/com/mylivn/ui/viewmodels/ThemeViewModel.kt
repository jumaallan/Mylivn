package com.mylivn.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.mylivn.core.utils.MylivnSharedPreferenceLiveData
import com.mylivn.data.repository.ThemeRepository

/**
 * ThemeViewModel
 *
 * This viewmodel is responsible for handling theme changes from the ThemeRepository
 * @param themeRepository
 */
class ThemeViewModel(
    private val themeRepository: ThemeRepository
) : ViewModel() {

    /**
     * getAppTheme is responsible for listening in on theme changes
     *
     * @return a MylivnSharedPreferenceLiveData that can be observed on the UI
     */
    fun getAppTheme(): MylivnSharedPreferenceLiveData =
        themeRepository.getAppTheme()
}