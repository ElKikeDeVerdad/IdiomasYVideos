package com.example.idiomasvideos.pantallas

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.idiomasvideos.logica.Helper.Barras.AppScaffold

import com.example.idiomasvideos.logica.Logica_pantallas.CirculoPruebaGrandeScreen

@Composable
fun MostrarCirculoGrandeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    AppScaffold(
        navController = navController,
        content = { padding ->
            CirculoPruebaGrandeScreen(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding)
            )
        }
    )

}