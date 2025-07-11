package com.example.idiomasvideos.pantallas

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.idiomasvideos.logica.Helper.Barras.AppScaffold
import com.example.idiomasvideos.logica.Logica_pantallas.CirculoPrueba


@Composable
fun MostrarCirculoPrueba(
    modifier: Modifier = Modifier,
    navController: NavHostController
                         ){
    AppScaffold(
    navController = navController,
        content = { padding ->
            CirculoPrueba(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding),
            )
        }
    )

}