package com.uvg.lab9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.uvg.lab9.navigation.AppNavGraph
import com.uvg.lab9.ui.theme.Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Theme {
                // Usar el NavGraph como punto de entrada
                AppNavGraph()
            }
        }
    }
}
