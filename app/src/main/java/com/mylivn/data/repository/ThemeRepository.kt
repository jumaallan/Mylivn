package com.mylivn.data.repository

import com.mylivn.core.settings.Settings
import com.mylivn.core.utils.MylivnSharedPreferenceLiveData

/**
 * ThemeRepository
 *
 * This repository class is responsible for observing the app theme, and its changes
 *
 * @param settings
 */
class ThemeRepository(
    private val settings: Settings
) {

    /**
     * getAppTheme is responsible for listening to live changes on the app theme preference, on the shared preference file
     *
     * @return a MylivnSharedPreferenceLiveData that can be observed on the UI
     */
    fun getAppTheme(): MylivnSharedPreferenceLiveData = MylivnSharedPreferenceLiveData(
        sharedPreferences = settings.settings,
        key = Settings.PREFERENCE_THEME_KEY,
        defValue = settings.getAppTheme()
    )
}