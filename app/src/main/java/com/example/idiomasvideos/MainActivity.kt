package com.example.idiomasvideos

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.idiomasvideos.logica.LocaleHelper.LocaleHelper
import com.example.idiomasvideos.navegacion.AppNavGraph
import com.example.idiomasvideos.ui.theme.IdiomasVideosTheme

class MainActivity : ComponentActivity() {
    //Se llama esto antes del OnCreate, asi envolvemos la app con este contexto de idioma antes de que se cree.
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.wrapContext(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IdiomasVideosTheme {
                val navController = rememberNavController()
                AppNavGraph(
                    navController = navController,
                    modifier = Modifier
                )
            }
        }
    }
}





