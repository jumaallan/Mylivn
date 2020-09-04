package com.mylivn.ui.views

import android.os.Bundle
import com.mylivn.R
import com.mylivn.databinding.ActivityHeroBinding

/**
 *  Hero Activity which is the Launcher Activity
 */

class HeroActivity : BindingActivity<ActivityHeroBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override val layoutResId: Int
        get() = R.layout.activity_hero
}