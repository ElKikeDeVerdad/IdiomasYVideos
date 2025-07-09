package com.example.idiomasvideos.pantallas


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.idiomasvideos.logica.Helper.Barras.AppScaffold
import com.example.idiomasvideos.logica.Logica_pantallas.BoxScreen



@Composable
fun MostrarBoxScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    AppScaffold(
        navController = navController,
        content = { padding ->
            BoxScreen(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding),
                boxUnoViewModel = viewModel()
            )
        }
    )
}