package com.example.idiomasvideos.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.idiomasvideos.pantallas.ConfiguracionScreen
import com.example.idiomasvideos.pantallas.HomeScreen
import androidx.navigation.compose.NavHost

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
         startDestination = Rutas.HOME) {
         }
}


