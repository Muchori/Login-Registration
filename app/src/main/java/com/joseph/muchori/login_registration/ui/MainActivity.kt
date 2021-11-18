@file:Suppress("PackageNaming")
package com.joseph.muchori.login_registration.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joseph.muchori.login_registration.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
