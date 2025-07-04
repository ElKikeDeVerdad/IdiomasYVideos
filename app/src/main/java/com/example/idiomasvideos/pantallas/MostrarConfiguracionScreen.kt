package com.example.idiomasvideos.pantallas

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.idiomasvideos.logica.Helper.Barras.AppScaffold
import com.example.idiomasvideos.logica.Logica_pantallas.ConfiguracionScreen

@Composable
fun MostrarConfiguracionScreen (
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit = {},
    navController: NavHostController
) {
    AppScaffold(
        navController = navController,
        content = { padding ->
            ConfiguracionScreen(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding),)
            //content(padding)
        }
    )
}
