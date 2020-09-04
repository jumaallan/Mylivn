package com.mylivn.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mylivn.R

/**
 *  Dashboard Activity which is the Launcher Activity
 */

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }
}