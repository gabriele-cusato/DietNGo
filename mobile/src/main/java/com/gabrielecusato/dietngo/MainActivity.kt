package com.gabrielecusato.dietngo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.gabrielecusato.dietngo.ui.home.HomeScreen
import com.gabrielecusato.dietngo.ui.theme.DietNGoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DietNGoTheme {
                HomeScreen()
            }
        }
    }
}
