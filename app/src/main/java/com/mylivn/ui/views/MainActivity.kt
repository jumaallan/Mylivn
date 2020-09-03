package com.mylivn.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mylivn.R

/**
 *  Main Activity which is the Launcher Activity
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}