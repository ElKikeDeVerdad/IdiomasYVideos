package com.example.idiomasvideos.pantallas

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.idiomasvideos.logica.Helper.Barras.AppScaffold
import com.example.idiomasvideos.logica.Logica_pantallas.ConfiguracionScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.idiomasvideos.ViewModel.ConfiguracionViewModel.ConfiguracionViewModel

@Composable
fun MostrarConfiguracionScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: ConfiguracionViewModel = viewModel()
) {
    AppScaffold(
        navController = navController,
        content = { padding ->
            ConfiguracionScreen(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding),
                viewModel = viewModel // <-- Pasas el viewModel aquí
            )
        }
    )
}
