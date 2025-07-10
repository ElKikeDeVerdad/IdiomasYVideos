package com.example.idiomasvideos.pantallas

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.idiomasvideos.logica.Helper.Barras.AppScaffold
import com.example.idiomasvideos.logica.Logica_pantallas.ParallaxScreen

@Composable
fun MostrarParallaxScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    AppScaffold(
        navController = navController,
        content = { padding ->
            ParallaxScreen(modifier = modifier
                .fillMaxSize()
                .padding(padding))

        }
    )
}