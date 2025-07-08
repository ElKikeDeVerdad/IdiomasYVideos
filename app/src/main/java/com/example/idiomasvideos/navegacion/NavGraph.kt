package com.example.idiomasvideos.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.idiomasvideos.pantallas.MostrarConfiguracionScreen
import com.example.idiomasvideos.pantallas.MostrarHomeScreen
import com.example.idiomasvideos.pantallas.MostrarTextoPruebaScreen

@Composable
fun AppNavGraph(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String = Rutas.HOME
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Rutas.TEXTOPRUEBASCREEN) {
            MostrarTextoPruebaScreen(
                navController = navController,
                modifier = modifier
            ) }
        composable(Rutas.CONFIGURACION){
            MostrarConfiguracionScreen(
                navController = navController,
                modifier = modifier,
            )
        }

        composable(Rutas.HOME){
            MostrarHomeScreen(
                navController = navController,
                modifier = modifier
            )
        }

    }
}


