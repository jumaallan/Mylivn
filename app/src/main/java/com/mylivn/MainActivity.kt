package com.mylivn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *  Main Activity which is the Launcher Activity
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}