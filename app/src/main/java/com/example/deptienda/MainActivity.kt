package com.example.deptienda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.deptienda.ui.navigation.AppNavHost
import com.example.deptienda.ui.theme.DepTheme
//Imports de actividad 3.1.2
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.deptienda.ui.navigation.PostScreen
//import com.example.deptienda.ui.theme.ApiRestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Permite a la app dibujar contenido debajo de la barra del sistema (¿?)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        //Jetpack compose
        setContent {
            DepTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost()
                }
            }
        }
    }
}