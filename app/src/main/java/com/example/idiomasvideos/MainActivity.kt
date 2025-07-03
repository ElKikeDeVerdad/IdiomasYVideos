package com.example.idiomasvideos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.idiomasvideos.pantallas.MostrarConfiguracionScreen
import com.example.idiomasvideos.pantallas.MostrarHomeScreen
import com.example.idiomasvideos.pantallas.MostrarTextoPruebaScreen
import com.example.idiomasvideos.ui.theme.IdiomasVideosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IdiomasVideosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MostrarHomeScreen(
                        navController = rememberNavController(),
                        modifier = Modifier.padding(innerPadding)
                    )
                   // MostrarTextoPruebaScreen(
                   //     modifier = Modifier.padding((innerPadding))
                   // )
                    MostrarConfiguracionScreen(
                        modifier = Modifier.padding((innerPadding))
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewCopiarAEjercicioIdiomasVideos() {
        IdiomasVideosTheme {
            //MostrarTextoPruebaScreen(modifier = Modifier)
            MostrarConfiguracionScreen(modifier = Modifier)
        }
    }


}

