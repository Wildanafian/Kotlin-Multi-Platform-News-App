package com.wildan.newsappkmm.android.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.wildan.newsappkmm.android.core.theme.MyApplicationTheme
import com.wildan.newsappkmm.android.feature.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                AppNavigation()
            }
        }
    }
}